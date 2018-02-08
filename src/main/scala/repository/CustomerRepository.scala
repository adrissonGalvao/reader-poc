package repository

import cats.data.Reader
import domain.Customer

import scala.collection.mutable.ListBuffer

trait CustomerRepository {

  def create(customer: Customer): Customer

}

class CustomerRepositoryImpl extends CustomerRepository {

  def create(customer: Customer) = {
    CustomerRepositoryImpl.rep += customer
    customer
  }

}

object CustomerRepositoryImpl {

  var rep: ListBuffer[Customer] = new ListBuffer()

}

trait CustomerRepositoryWrapper {

  def create(customer: Customer) =
    Reader( (rep: CustomerRepository) => rep.create(customer) )

}
