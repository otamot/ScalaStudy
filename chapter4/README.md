# クラスとオブジェクト
## クラス,フィールド,メソッド

クラス定義
```Scala
class クラス名{
  //ここにクラス定義を書く。
}
```
クラス定義の中に、 **フィールド(field)** と **メソッド** を記述する。これらまとめて **メンバ(member)** と呼ぶ。

オブジェクトの作成
```Scala
new クラス名
```

```Scala
class ChecksumAccumulator{
  private var sum = 0
}

val acc = new ChecksumAccumulator
acc.sum = 5 //sumはprivateなのでアクセス不可。コンパイルエラー
```
Scalaではアクセス修飾子をつけなえればデフォルトでpublicとなる


```Scala
class CheckSumAccumulator{
  private var sum = 0
  def add(b: Byte): Unit = {
    //b = 1 Scalaの引数はvalであり、変更不可。コンパイルエラーになる
    sum += b
  }
  def checkSum(): Int = {
    return ~(sum & 0xFF) + 1
  }
}
```

関数の返り値がUnitの時、=を省略できる。
以下が修正版CheckSumAccumulator.scala
```Scala
class CheckSumAccumulator{
  private var sum = 0
  def add(b: Byte){sum += b}
  def checksum(): Int = ~(sum & 0xFF) + 1
}
```




```Scala
scala> def f(): Unit = "this String gets lost"
f: ()Unit
```
等号を省略すると返り値はUnitとなる。

```Scala
scala> def g() {"this String gets lost too"}
g: ()Unit
```
中括弧で囲っても同様である。

```Scala
scala> def h() = {"this String gets returned!"}
h: ()String

scala> h
res0: String = this String gets returned!
```
=をつけると返り値がStringと判断され、値を返せるようになる。


## 4.2 セミコロン推論
### セミコロン推論の規則
文の分割のルールは、次の条件の中のいずれかに当てはまらないかぎり、行末はセミコロンとして扱われる。
1. 当該行の末尾が、ピリオドや中置演算子など、文の末尾として文法的に認められていない単語になっている。
2. 次の行が文の先頭として認められていない単語になっている。
3. 括弧や角括弧の中にいる状態で文末になっている。もともとこうした括弧の中に複数の文を入れることはできない。

## 4.3 シングルトンオブジェクト
scalaはstatic memberを持てない。その代わりにシングルトンオブジェクトを持つ。

```Scala
import scala.collection.mutable.Map
object ChecksumAccumulator{
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if(cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumulator
      for(c<-s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s->cs)
      cs
    }
}
```
シングルトンオブジェクトがクラスメイト同じ名前の時 **コンパニオンオブジェクト** と呼ぶ。クラス側は **コンパニオンクラス** という。両者は同一ソースファイルで定義されなければならない。




```
$ scala Summer of love
of:-213
love:-182
```
