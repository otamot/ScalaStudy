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
