import cats.data.Reader
import domain.Customer
import repository.{CustomerRepository, CustomerRepositoryInMemory}
import service.CustomerServiceInterpreter


class Execution(customerRepository: CustomerRepository){

  val service = new CustomerServiceInterpreter

  private def run[A](reader: Reader[CustomerRepository,A]) = {
    reader(customerRepository)
  }



  def impl = {
    val customer = Customer(1,"Cliente 1", Nil)

    run(service.create(customer))


  }


}

object Execution extends Execution(new CustomerRepositoryInMemory)

object Main extends App {

  val ex = Execution

  val x = ex.impl

  println(x)

}