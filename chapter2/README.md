# Section2 Scalaプログラミング第一歩

## 2.1 [ステップ1]Scalaインタープリタの使い方を学ぶ
ターミナル上でscalaと打つと対話的シェルのScalaインタープリタを使える

```Scala
$ scala
Welcome to Scala version 2.11.7 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_65).
Type in expressions to have them evaluated.
Type :help for more information.

scala>
```

ここで1+2をいれて[Enter]を押すと

```Scala
scala> 1 + 2
```

以下が出力
```Scala
res0: Int = 3
```

* 計算された値を参照する自動生成またはユーザー定義で作られていた名前(結果0を返すres0)
* コロンと式の型(Int)
* 等号(=)
* 式評価の結果(3)

これらが含まれていた

```Scala
scala> res0*3
res2: Int = 9
```
このようにres0も使い回し可能。

Hello Worldは以下のように記述
```Scala
scala> println("Hello, world!")
Hello, World!
```

## 2.2 [ステップ2]変数の定義
Scalaの変数には以下の2つがある


|変数の種類|意味|
|:------:|:---|
|val|Javaで言うfinal変数。初期化後の再代入不可|
|var|Javaで言う非final変数。その変数が有効であれば何度でも代入可|


```Scala
scala> val msg = "Hello, world!"
msg: String = Hello, world!
```
ここではval定義のどこにも型の宣言がないが自動的にStringと型が付いている。
これを **型推論(type inference)** という。

このような明らかに型が推論できるときは型アノテーションでコードをいっぱいにするよりも、処理系に推論を委ねたほうがよい。一方明示的な型宣言をするときは以下の2つのどちらかのように書く。

```Scala
scala> val msg2: java.lang.String = "Hello again,world!"
msg2: String = Hello again,world!
```
or
```Scala
scala> val msg3: String = "Hello yet again, world!"
msg3: String = Hello yet again, world!
```


valの変数に再代入しようとするとエラーとなる。
```Scala
scala> val msg = "Hello, world!"
msg: String = Hello, world!

scala> msg = "Hallo, Scala!"
<console>:11: error: reassignment to val
       msg = "Hallo, Scala!"
           ^
```

varの変数は再代入が可能である。
```Scala
scala> var msg1 = "Hello, world"
msg1: String = Hello, world

scala> msg1 = "Hello, Scala"
msg1: String = Hello, Scala
```

### 2.3 [ステップ3]関数の定義
関数の定義の仕方
```Scala
def 関数名(カッコで囲まれたパラメータリスト): 関数の結果型 = {
  関数の処理
}
```

例)Max関数
```Scala
scala> def max(x: Int, y: Int): Int = {
        if(x > y) x
        else y
       }
max: (x: Int, y: Int)Int

scala> max(3,5)
res3: Int = 5
```

結果型が再帰的な場合など結果がたの指定をコンパイラが要求することがある。ただし、このmax関数の場合は、結果型をコンパイラが推論してくれる。また、関数が1文からなる場合は中括弧はいらない。これらから以下のように書き換えられる。

```Scala
scala> def max2(x: Int, y: Int) = if(x > y) x else y
max2: (x: Int, y: Int)Int
```

ここで出てくる

```Scala
if(x > y) x else y
```

はJavaでいう3項演算子の

```Scala
(x > y) ? x : y
```
と同値である。


Hello Worldを出力する以下の関数はUnit型を返す。
```Scala
scala> def great() = println("Hello, World!")
great: ()Unit
```

Unit型はJavaで言うvoidに似ていて関数が意味のある値を返さない。結果型がUnitの関数は **副作用(side effects)** のためのみに実行される。

インタープリタの終了には:quit または:qと入力する。
```Scala
scala> :quit
$
```

## 2.4 [ステップ4]簡単なScalaスクリプトを書く
[hello.scala](hello.scala)

```Scala
println("Hello, world, from a script!")
```

```Scala
$ scala hello.scala
Hello, world, from a script!
```

Scalaのコマンドライン引数はargsというScala配列に格納される。

[helloarg.scala](helloarg.scala)
```Scala
//第1引数にhelloと声をかける
println("Hello, " + args(0) + "!")
```

```Scala
$ scala helloarg.scala planet
Hello, planet!
```

## 2.5 [ステップ5]whileループとif分岐
whileループ
```Scala
while(条件式){
  処理
}
```

ifループ
```Scala
if(条件式){
    処理
}
else if(条件式){
    処理
}
.
.
.
else{
  処理
}
```

サンプルコード

[printargs.scala](printargs.scala)
```Scala
var i = 0
while(i < args.length){
	println(args(i))
	i += 1
}

```

```
$ scala printargs.scala Scala is fun
Scala
is
fun
```

[echoargs.scala](echoargs.scala)
```Scala
var i = 0
while(i < args.length){
	if(i != 0)
		print(" ")
	print(args(i))
	i += 1
}
println()
```

```
$ scala echoargs.scala Scala is even more fun
Scala is even more fun
```

## 2.6 [ステップ6]foreachとforによる反復実行
whileループでの処理では **命令形のスタイル(imperative stile)** でのプログラミング。Scalaでは **関数型のスタイル(functional style)** でプログラミングすることが増える。

[pa.scala](pa.scala)
```Scala
args.foreach(arg => println(arg))
```
argsのforeachメソッドを呼び出し、そのメソッドに関数を渡している。argという名前の1個のパラメータをとる **関数リテラル(function literal)** で、関数本体はprintln(arg)

```
$ scala pa.scala Consise is nice
Consise
is
nice
```

pa.scalaの書き換え表現
```Scala
args.foreach((arg: String) => println(arg)) //引数の型を明示
```

```Scala
args.foreach(println)
//関数リテラルが一つの引数を取る1文から構成される場合は引数を明示的に指定しなくて住む。
```


Scalaの関数リテラルの公文
```
(x: Int, y: Int) => x + y

(カッコで囲まれた関数パラメータ) => 関数本体
```

Scalaでのfor式は以下のように記述する。

[forargs.scala](forargs.scala)
```Scala
for(arg <- args)
  println(arg)
```
argはval変数である。

```
$ scala forargs.scala for arg in args
for
arg
in
args
```
