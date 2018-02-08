package domain


case class Transaction(id: Long, value: Double, description: String)

case class Customer(id: Long, name: String, balance: List[Transaction])

case class Product(id: Long, name: String, price: Double)
