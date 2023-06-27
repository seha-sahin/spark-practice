// Max volume stocks by sector
val path = "local/file/path"
val stocks = sc.textFile(path)
val splits = stocks.map(record => record.split(","))
val sectors = splits.map(row => (row(2), row(3).toInt))
val maxprice = sectors.reduceByKey((price1, price2) => Math.max(price1, price2))
maxprice.collect().foreach(println)
