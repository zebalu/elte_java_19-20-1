package example

import java.util.Iterator
import collection.JavaConverters._

class ScalaDataUser(dataList: Iterator[Data]) {
  private val data: List[Data] = dataList.asScala.toList
  
  def print() = {
    data.foreach(f => {
      println (f.getId+" --- "+f.getName)
    })
  }

  val dataWithId: Int => List[Data] = (id: Int) => data.filter(d => d.getId == id)

  val javaList: List[Data] => java.util.List[Data] = (list: List[Data]) => list.asJava
}