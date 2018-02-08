package repository

import domain.Product

import scala.collection.mutable.ListBuffer

class ProductRepository {

  var rep: ListBuffer[Product] = new ListBuffer()

  def createProduct(product: Product): Product = {
    rep += product
    product
  }

  def findProduct(id: Long): Option[Product] = rep.find(_.id == id)

}
