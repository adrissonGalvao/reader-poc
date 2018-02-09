package repository

import domain.Transaction

import scala.collection.mutable.ListBuffer

trait TransactionRepository {

  def create(transaction: Transaction): Long

  def findById(id: Long): Option[Transaction]

}


class TransactionRepositoryInMemory extends TransactionRepository {

  def create(transaction: Transaction) = {
    TransactionRepositoryInMemory.rep += transaction
    transaction.id
  }

  def findById(id: Long) = TransactionRepositoryInMemory.rep.find(_.id == id)

}

object TransactionRepositoryInMemory extends TransactionRepositoryInMemory {

  var rep: ListBuffer[Transaction] = new ListBuffer()

}