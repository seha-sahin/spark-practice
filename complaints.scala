// basic data ops via spark-shell

import scala.io.Source
import java.io.PrintWriter

// Download the file
val url = "https://data.cityofnewyork.us/resource/9jgj-bmct.json"

// Specify the local file path
val localPath = "/local/file/path/to/9jgj-bmct.json"
val writer = new PrintWriter(localPath)
Source.fromURL(url).getLines.foreach(writer.println)
writer.close()

// Read the file
val sample = sc.textFile(localPath)
sample.take(5).foreach(println)
