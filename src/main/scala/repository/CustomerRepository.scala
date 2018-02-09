package repository

import domain.Customer
import scala.collection.mutable.ListBuffer

trait CustomerRepository {

  def create(customer: Customer): Long

  def findById(id: Long): Option[Customer]

  def update(customer: Customer): Customer

}

class CustomerRepositoryInMemory extends CustomerRepository {

  def create(customer: Customer) = {
    CustomerRepositoryInMemory.rep += customer
    customer.id
  }

  override def findById(id: Long): Option[Customer] = CustomerRepositoryInMemory.rep.find(_.id == id)

  def update(customer: Customer): Customer = {
    CustomerRepositoryInMemory.rep -= customer
    CustomerRepositoryInMemory.rep += customer
    customer
  }
  
}

object CustomerRepositoryInMemory {

  var rep: ListBuffer[Customer] = new ListBuffer()

}
