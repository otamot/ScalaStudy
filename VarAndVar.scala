package Practice

object VarAndVar {
  /**
   * var と valの練習。
   * varは再代入可能な変数,valは再代入不可能な変数。
   */
	def main(args:Array[String])={
	    var x:Int = 3;//Int型のvar変数の宣言
	    var s:String = "aaaa";//String型のvar変数の宣言
	    println(x + ":" + s);
	    
			var a =1;
			println(a);
			a = 2;//varは再代入可能
			println(a);
			val b = 10;
			println(b);
	//  b = 20; //valは再代入できない。(コンパイルエラーとなる。)
	}

}