import cats.data.Reader
import domain.Customer
import repository.{CustomerRepository, CustomerRepositoryImpl}
import service.CustomerService


class Execution(customerRepository: CustomerRepository) extends CustomerService {


  def impl = {
    val customer = Customer(1,"Cliente 1", Nil)

    run(create(customer) andThen (x => println(x)) )
  }

  private def run[A](reader: Reader[CustomerRepository,A]) = {
    reader(customerRepository)
  }

}

object Execution extends Execution(new CustomerRepositoryImpl)

object Main extends App {

  val x = Execution

  x.impl


}