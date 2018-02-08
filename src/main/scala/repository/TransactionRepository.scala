package repository

import domain.Transaction

import scala.collection.mutable.ListBuffer

class TransactionRepository {

  var rep: ListBuffer[Transaction] = new ListBuffer()

  def createTransaction(transaction: Transaction): Transaction = {
    rep += transaction
    transaction
  }

  def findTransaction(id: Long): Option[Transaction] = rep.find(_.id == id)

}
