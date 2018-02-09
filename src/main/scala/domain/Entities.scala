package domain


case class Transaction(id: Long, value: Double, description: String)

case class Customer(id: Long, name: String, balance: List[Transaction]) {

  override def equals(obj: Any): Boolean = {
    obj match {
      case o: Customer => o.canEqual(this) && o.id == this.id
      case _ => false
    }


  }
}

case class Product(id: Long, name: String, price: Double)
