# 基本型と演算子
## 5.1 基本型
Byte,Short,Int,Long,Charを **整数値型(integral types)** とよぶ。整数値型とFloat,Doubleを合わせて **数値型(numeric types)** と呼ぶ。


|値型|範囲|
|:---|:---|
|Byte|2の補数表現の8ビット符号付き整数(-2^7以上2^7-1以下)|
|Short|2の補数表現の16ビット符号付き整数(-2^(15)以上2^(15)-1以下)|
|Int|2の補数表現の32ビット符号付き整数(-2^(31)以上2^(31)-1以下)|
|Long|2の補数表現の64ビット符号付き整数(-2^(63)以上2^(63)-1以下)|
|Char|16ビット符号なしUnicode文字(0以上2^(16)-1以下)|
|String|Charのシーケンス|
|Float|32ビットのIEEE754単精度浮動小数点|
|Double|64ビットのIEEE754倍精度浮動小数点|
|Boolean|trueまたはfalse|


Stringだけjava.langパッケージ。その他はscalaパッケージである。Intの完全名はscala.Int,Stringの完全名はjava.lang.String


## 5.2 リテラル
5.1の基本型は、どれも **リテラル(literal)** として書くことが可能。リテラルとはコードに定数値を直接書く書き方のこと。


### 5.2.1 整数リテラル
Int,Long,Short,Byte型の整数リテラルには10進,16進の3つの形がある。
8進はscala2.10で非推奨となった。

#### 16進
16進ははじめに0xをつける。
```Scala
scala> val hex = 0x5
hex: Int = 5

scala> val hex2 = 0x00FF
hex2: Int = 255

scala> val magix = 0xcafebabe
magix: Int = -889275714
```

#### 8進
8進ははじめに0をつける。(scala2.10以降は非推奨)
```Scala
scala> val oct = 035 //8進の35は10進の29
oct: Int = 29

scala> val nov = 0777
nov: Int = 511

scala> val dec = 0321
dec: Int = 209
```

#### 10進
10進は0以外で始まれば10進である。
```Scala
scala> val dec1 = 31
dec1: Int = 31

scala> val dec2 = 255
dec2: Int = 255

scala> val dec3 = 20
dec3: Int = 20
```


#### Longの整数リテラル
整数リテラルの末尾にlまたはLをつける
```Scala
scala> val prog = 0XCAFEBABEL
prog: Long = 3405691582

scala> val tower = 35L
tower: Long = 35

scala> val of = 31l
of: Long = 31
```

#### Short,Byteの整数リテラル
ShortやByte型の変数にIntリテラルを代入した場合、それらの型の範囲内に収まっていた場合、リテラルの型がShortやByteとして扱われる。

```Scala
scala> val little: Short = 367
little: Short = 367

scala> val littler: Byte = 38
littler: Byte = 38
```

### 5.2.2 浮動小数点リテラル

```Scala
scala> val big = 1.2345
big: Double = 1.2345

scala> val bigger = 1.2345e1
bigger: Double = 12.345

scala> val biggerStill = 123E45
biggerStill: Double = 1.23E47
```
浮動小数リテラルは10進の数字から構成され、小数点やEまたはeがつくことがある。
E,eは10の累乗である。Doubleのリテラルの末尾にはDまたはdとつけることができる。またFloatリテラルはfまたはFをつければよい。

```Scala
scala> val little = 1.2345F
little: Float = 1.2345

scala> val littleBigger = 3e5f
littleBigger: Float = 300000.0
```

### 5.2.3 文字リテラル
文字リテラルはシングルクオートでUnicode文字を囲んだもの。または、文字のコードポイントを8進または16進で書くことができる。8進値は'\0'から'\377'までの値。16進値は '\u'に続いて16進値を4つ並べたもの。

```Scala
scala> val a = 'A'
a: Char = A

scala> val c = '\101'
warning: there was one deprecation warning; re-run with -deprecation for details
c: Char = A

scala> val d = '\u0041'
d: Char = A

scala> val f = '\u0044'
f: Char = D

scala> val B\u0041\u0044 = 1 //変数名の宣言にもUnicode文字を使える
BAD: Int = 1
```


|リテラル|意味|
|:--|:--|
|\n|改行(\u000A)|
|\b|バックスペース(\u0008)|
|\t|タブ(\u0009)|
|\f|改ページ(\u000C)|
|\r|復帰(\u000D)|
|\"|ダブルクォート(\u0022)|
|\'|シングルクォート(\u0027)|
|\\|バックスラッシュ(\u005C)|


#### 特殊文字のエスケープシーケンス
```Scala
scala> val backspace = '\\'
backspace: Char = \
```


### 5.2.4 文字列リテラル
```
scala> println("""Welcome to Ultamix 3000.
                  type "Help" for help.""")
Welcome to Ultamix 3000.
           type "Help" for help.

scala> println("""|Welcome to Ultamin 3000.
                  |Type "Help" for help.""".stripMargin)
Welcome to Ultamin 3000.
Type "Help" for help.
```
### 5.2.5 シンボルリテラル
```Scala
scala> def updateRecodeByName(r: Symbol, value: Any){
         //ここにコードを書く
       }
updateRecodeByName: (r: Symbol, value: Any)Unit

scala> updateRecodeByName('favoriteAlbum, "OK Computer")
```

```Scala
scala> val s = 'aSymbol
s: Symbol = 'aSymbol

scala> s.name
res5: String = aSymbol
```
シンボルリテラルはシンボルの実体が1つしか作られない。同じシンボルリテラルを2度書いた時、両方の式は同一のSymbolオブジェクトを参照する。


### 5.2.6 Booleanリテラル
Booleanリテラルはtrueとfalseの2つのリテラルを持つ。
```Scala
scala> val bool = true
bool: Boolean = true

scala> val fool = false
fool: Boolean = false
```

## 5.3 演算子はメソッド
Intクラスは1個のIntをパラメータとして取り、Intの結果値を返す"+"というメソッドを持つ。つまり、演算子はメソッドである。

```Scala
scala> val sum = 1 + 2//下の式をScalaは呼び出している。
sum: Int = 3

scala> val sumMore = (1).+(2)
sumMore: Int = 3
```

またIntのプラスメソッドは **多重定義(overloaded)** を持つ。

```Scala
scala> val longSum = 1 + 2L
longSum: Long = 3

scala> val longSumMore = (1).+(2L)
longSumMore: Long = 3
```
Longをパラメータとして取り、Longを返す+メソッド。
(メソッド名が同じで、別の引数を取るものを多重定義という。)

Scalaはすべてのメソッドで演算子記法が使える。
```Scala
scala> val s = "Hello, world!"
s: String = Hello, world!

scala> s indexOf 'o' //Scalaはs.indexOf('o')を呼び出す
res0: Int = 4
```

引数を2個取る場合の演算子記法での書き方は
```Scala
scala> s indexOf ('o',5) //Scalaはs.indexOf('o',5)を呼び出す
res6: Int = 8
```
