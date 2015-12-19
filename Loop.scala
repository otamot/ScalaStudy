package Practice

import scala.util.control.Breaks.{break,breakable};

object Loop {
	def main(args:Array[String])={
	    
	    //while文でのループ
			var i=0;
			while(i<10){
				println("while:" + i);
				i += 1;
			}
			
			var i2 = 0;
			do{
			  println("do while;" + i2);
			  i2 += 1;
			}while(i2 < 20)
			
			//breakを使ったループ。
			//Scalaではbreakを使うべきでない。
			breakable{
				var j = 0;
				while(true){
					if(j > 15){
						break;
					}
					println("break:" + j)
					j += 1;
				}
			}
			
			//再起を使ったループ。
			//Scalaではよく使う。
			def loop(i:Int):Unit = {
			  println("loop" + i);
			  if(i < 20) loop(i+1);
			}
			loop(0);

	}

}