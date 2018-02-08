package domain


case class Transactions(id: Long, value: Double, decription: String)

case class Customer(id: Long, name: String, balance: List[Transactions])

case class Product(id: Long, name: String, price: Double)
