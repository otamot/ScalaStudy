package Practice

object IfElse {
  /**
   * if文の練習。
   */
	def main(args:Array[String]){


		if (true){
			println("if:1")
		}
		else{
			println("else:1");
		}
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
