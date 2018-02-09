package service

import cats.data.Reader
import domain.Customer
import repository.{CustomerRepository, CustomerRepositoryInMemory}

trait CustomerService {

  def create(customer: Customer): Reader[CustomerRepository, Long]

  def findById(id: Long): Reader[CustomerRepository,Option[Customer]]

}

class CustomerServiceInterpreter extends CustomerService {

  override def create(customer: Customer) = Reader( (rep: CustomerRepository) => rep.create(customer))

  override def findById(id: Long) = Reader((rep: CustomerRepository) => rep.findById(id))
}
