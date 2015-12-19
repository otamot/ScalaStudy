package Practice

object IfElse {
  /**
   * if-elseの練習。
   * Scalaのifは文ではなく式である。
   * そのため、値を返す。3項演算の例がそれである。
   */
	def main(args:Array[String]){

	  //条件1
	  if (true){
			println("if:1")
		}
		else{
			println("else:1");
		}

		
		//条件2
		if(false){
			println("if:2");
		}
		else{
			println("else:2");
		}

		var a:String = if(1-3>0)"plus"else"minus";//javaの3項演算と同じことができる。
		//val a:String = (1-3>0)?"plus":"minus";
		println(1-3 + " is " + a); 

	}
}
