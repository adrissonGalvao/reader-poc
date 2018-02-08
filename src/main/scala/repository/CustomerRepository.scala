package repository

import domain.Customer

import scala.collection.mutable.ListBuffer

class CustomerRepository {

  var rep: ListBuffer[Customer] = new ListBuffer()

  def createCustomer(customer: Customer): Customer = {
    rep += customer
    customer
  }

  def findCustomer(id: Long): Option[Customer] = rep.find(_.id == id)

}
