package scripts

import scala.io.Source

object CSVScript extends App {
  println("Month, Income, Expenses, Profit")
  val bufferedSource = Source.fromFile("/opt/arpa-qualita-aria-2020-1_csv.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(";").map(_.trim)
    // do whatever you want with the columns here
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}|${cols(5)}")
  }
  bufferedSource.close
}
