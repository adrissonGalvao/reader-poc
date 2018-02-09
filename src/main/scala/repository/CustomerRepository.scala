package repository

import domain.Customer
import scala.collection.mutable.ListBuffer

trait CustomerRepository {

  def create(customer: Customer): Long

  def findById(id: Long): Option[Customer]

}

class CustomerRepositoryInMemory extends CustomerRepository {

  def create(customer: Customer) = {
    CustomerRepositoryInMemory.rep += customer
    customer.id
  }

  override def findById(id: Long): Option[Customer] = CustomerRepositoryInMemory.rep.find(_.id == id)

}

object CustomerRepositoryInMemory {

  var rep: ListBuffer[Customer] = new ListBuffer()

}
