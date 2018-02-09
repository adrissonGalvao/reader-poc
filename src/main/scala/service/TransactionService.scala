package service

import cats.data.Reader
import domain.{Customer, Transaction}
import repository.{CustomerRepository, ProductRepository, TransactionRepository}

case class TransactionRepositoryManager(customerService: CustomerRepository,
                                        productService: ProductRepository,
                                        transactionRep: TransactionRepository)

trait TransactionService {

  def transact(customer: Customer, transaction: Transaction): Reader[TransactionRepositoryManager, Long]

  def findById(id: Long): Reader[TransactionRepositoryManager,Option[Transaction]]

}

class TransactionServerInterpreter extends TransactionService {

  override def transact(customer: Customer, transaction: Transaction) = Reader((rep: TransactionRepositoryManager) => {
    rep.transactionRep.create(transaction)
    // add transaction to user, calc

  })

  override def findById(id: Long) = Reader((rep: TransactionRepositoryManager) => rep.transactionRep.findById(id))

}

object TransactionServerInterpreter extends TransactionServerInterpreter