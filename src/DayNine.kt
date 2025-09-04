import java.time.Instant

class Customer(
    val name:String,
    val id:Int){

}
class Fooditem(
    val name: String,
    val price: Double,
)
class Order(val customer: Customer) {
    private val items = mutableListOf<Fooditem>()
    fun addItems(item:Fooditem){
        items.add(item)
    }
    fun showOrder()
    {
        println("Order given by ${customer.name} (Id: ${customer.id}) :")
        println("------------------------------")
        var c=0
        var pr =0.0
        for(i in items)
        {
            println("${i.name}-----${i.price}")
            c++
            pr+=i.price;
        }
        println("--------------------")
        println("Total items ordered : ${c}")
        println("Total price : ${pr}")
    }
}
class Restaurant(val name:String){
    private val orders = mutableListOf<Order>()
    fun addOrder(order: Order) {
        orders.add(order)
    }
    fun showAllOrders()
    {
        println("Restaurant Name: ${name}")
        println("------------------------------")
        for (order in orders) {
            order.showOrder()
            println("------------------------------")
        }
    }
}



abstract class Person(val name:String, val age:Int){
    abstract fun showDetails()
}
class Student(name:String, age:Int, private val grade:String, val subjects:List<String>):Person(name, age){
    override fun showDetails()
    {
        println("Student Name: ${name}, Age: ${age}, Grade: ${grade}")
        println("Subjects: ${subjects.joinToString ( ",")}")
    }
}
class Teacher(name:String, age:Int, val Subject:String, private val salary: Int):Person(name, age){
    override fun showDetails()
    {
        println("Teachers Name: ${name}, Age: ${age}, Subject: ${Subject} Salary: ${salary}")
    }
}
class School(var name:String)
{
    var persons=mutableListOf<Person>()
    fun addPerson(person: Person){
        persons.add(person)
    }
    fun showPersons()
    {
        println("School Name: ${name}")
        for(p in persons)
        {
            p.showDetails()
        }
    }

}


open class Products(val name: String, val price: Double, val quantity: Int) {
    open fun showDetails() {
        println("Product: $name, Price: $$price, Stock: $quantity")
    }
}

class CustomerElectronics(name: String, price: Double, quantity: Int, var warranty: String) :
    Products(name, price, quantity) {
    override fun showDetails() {
        println("Electronics's Name: $name, Price: $$price, Quantity: $quantity, Warranty: $warranty")
    }
}

class CustomerClothes(name: String, price: Double, quantity: Int, var size: String) :
    Products(name, price, quantity) {
    override fun showDetails() {
        println("Clothe's Name: $name, Price: $$price, Quantity: $quantity, Size: $size")
    }
}

class Cart() {
    private val products = mutableListOf<Products>()

    fun addProduct(product: Products) {
        products.add(product)
    }

    fun total(): Double {
        var sum = 0.0
        for (product in products) {
            sum += product.price
        }
        return sum
    }

    fun showProducts() {
        println("----- Cart Items -----")
        for (product in products) {
            product.showDetails()
        }
        println("Total Cost: $${total()}")
    }
}


open class Employee(var name:String, var id:Int, var salary: Double)
{
    open fun displayInfo()
    {
        println("Employee Name: ${name}   ID: ${id}   Salary: ${salary}" )
    }
}
class Manager(name:String, id:Int, salary: Double,var department:String):Employee(name, id, salary) {
    override fun displayInfo() {
        println("Employee Name: ${name}   ID: ${id}   Salary: ${salary}   Department: ${department}")

    }
}
class Developer(name:String, id:Int, salary: Double,var language:String):Employee(name, id, salary) {
    override fun displayInfo() {
        println("Employee Name: ${name}   ID: ${id}   Salary: ${salary}   Programming Language: ${language}")

    }
}

class Salary
{
    var x= mutableListOf<Employee>()
    fun addEmployee(employee: Employee) {
        x.add(employee)
    }
    fun giveRaise(amount: Double) {
        for(i in x)
        {
            i.salary+=amount
        }
    }
    fun bonus(percentage: Double) {
        for(i in x){
            i.salary+=((percentage/100)*i.salary)
        }
    }
}
fun main()
{
    var x=Manager("Abir",384934,40000.0,"Softwere")
    var y=Manager("Tareq",384935,30000.0,"Softwere")
    var a=Developer("Aimon",384936,20000.0,"Kotlin")
    var b=Developer("Hafiz",384937,10000.0,"Durt")
    println("Before increasing Salary and adding Bonus")
    println("----------------------------------------------------")
    var em=Salary()
    em.addEmployee(x)
    em.addEmployee(y)
    em.addEmployee(a)
    em.addEmployee(b)
    x.displayInfo()
    y.displayInfo()
    a.displayInfo()
    b.displayInfo()
    println("After increasing Salary and adding Bonus")
    println("----------------------------------------------------")
    em.giveRaise(500.0)
    em.bonus(20.0)
    x.displayInfo()
    y.displayInfo()
    a.displayInfo()
    b.displayInfo()
}

