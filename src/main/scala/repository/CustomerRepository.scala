package repository

import cats.data.Reader
import domain.Customer

import scala.collection.mutable.ListBuffer

trait CustomerRepository {

  def create(customer: Customer): Customer

  def findById(id: Long): Option[Customer]

}

class CustomerRepositoryInMemory extends CustomerRepository {

  def create(customer: Customer) = {
    CustomerRepositoryInMemory.rep += customer
    customer
  }

  override def findById(id: Long): Option[Customer] = CustomerRepositoryInMemory.rep.find(_.id == id)

}

object CustomerRepositoryInMemory {

  var rep: ListBuffer[Customer] = new ListBuffer()

}
