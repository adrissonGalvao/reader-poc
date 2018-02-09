package service

import cats.data.Reader
import repository.ProductRepository
import domain.Product
trait ProductService {

  def create(product: Product): Reader[ProductRepository, Long]

  def findById(id: Long): Reader[ProductRepository,Option[Product]]

}

class ProductServiceInterpreter extends ProductService {

  def create(product: Product) = Reader((rep: ProductRepository) => rep.create(product) )

  def findById(id: Long) = Reader((rep: ProductRepository) => rep.findById(id))

}

object ProductServiceInterpreter extends ProductServiceInterpreter