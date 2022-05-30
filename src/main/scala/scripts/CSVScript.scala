package scripts

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

import java.net.URI
import scala.io.Source

object CSVScript extends App {
  println("Month, Income, Expenses, Profit")

  val hdfs = FileSystem.get(new URI("hdfs://worker-node2/"), new Configuration())
  val path = new Path("/examples/jars/arpa-qualita-aria-2020-1_csv.csv")
  val stream = hdfs.open(path)
  val bufferedSource = Source.fromInputStream(stream)

//  val bufferedSource = Source.fromFile("hdfs:///worker-node2/opt/arpa-qualita-aria-2020-1_csv.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(";").map(_.trim)
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}|${cols(5)}")
  }
  bufferedSource.close
}
