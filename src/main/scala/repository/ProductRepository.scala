package repository

import domain.{Product}

import scala.collection.mutable.ListBuffer

trait ProductRepository  {

  def create(product: Product): Long

  def findById(id: Long): Option[Product]

}


class ProductRepositoryInMemory extends ProductRepository {


  def create(product: Product): Long = {
    ProductRepositoryInMemory.rep += product
    product.id
  }

  def findById(id: Long): Option[Product] = ProductRepositoryInMemory.rep.find(_.id == id)

}

object  ProductRepositoryInMemory {

  var rep: ListBuffer[Product] = new ListBuffer()

}
