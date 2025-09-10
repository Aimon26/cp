
//todo list using interface

data class Todo(
    var id:Int,
    var title:String,
    var content:String,
    var isCompleted:Boolean=false
)
interface TodoManager{
    fun adding(todo:Todo)
    fun update(todo:Todo)
    fun delete(todo:Todo)
    fun markAsCompleted(todo:Todo)
}
class TodoManagerImpl : TodoManager {
    var x=mutableListOf<Todo>()
    override fun adding(todo: Todo) {
        x.add(todo)
    }
    override fun update(todo:Todo) {
        var p=x.indexOfFirst{it.id==todo.id}
        x[p]=todo
    }
    override fun delete(todo:Todo) {
        var p=x.find{it.id==todo.id}
        if(p!=null) x.remove(p)
        else println("No Such Task Found")

    }
    override fun markAsCompleted(todo:Todo) {
        var p=x.indexOfFirst{it.id==todo.id}
        x[p].isCompleted = true
    }
}


//coffee machine system using interface

data class Ingredients(
    var coffeeBeans: Int,
    var water: Double,
    var milk: Double,
)
interface CoffeMaker{
    fun espresso(access:Ingredients)
    fun americano(access:Ingredients)
    fun latte(access:Ingredients)
}
class CoffeMakerImplement:CoffeMaker{
    override fun espresso(access: Ingredients) {
        access.coffeeBeans = 2;
        access.water= 1.0
    }
    override fun americano(access: Ingredients) {
        access.coffeeBeans = 2;
        access.water= 3.0
    }

    override fun latte(access: Ingredients) {
        access.coffeeBeans = 2;
        access.water = 2.0;
        access.milk= 2.0
    }
}
fun main() {
    val coffeeMaker = CoffeMakerImplement()
    val ingredients = Ingredients(0, 0.0, 0.0)

    println("                Cafe Rio                ")
    println("------------------------------------------")
    println("What type of coffee would you like to drink?")
    println("1. Espresso")
    println("2. Americano")
    println("3. Latte")
    print("Enter choice (1-3): ")

    val choice = readLine()?.toIntOrNull()

    when (choice) {
        1 -> {
            coffeeMaker.espresso(ingredients)
            println("You ordered Espresso")
        }
        2 -> {
            coffeeMaker.americano(ingredients)
            println("You ordered Americano")
        }
        3 -> {
            coffeeMaker.latte(ingredients)
            println("You ordered Latte")
        }
        else -> {
            println("Invalid choice!")
            return
        }
    }

    println("\n--- Ingredients used ---")
    println("Coffee beans: ${ingredients.coffeeBeans} spoons")
    println("Water: ${ingredients.water} cups")
    println("Milk: ${ingredients.milk} cups")
}


//another coffee maker using all property of oop

open class Coffee(
    val name: String,
    val price: Double,
    val waterNeeded: Double,
    val milkNeeded: Double,
    val beansNeeded: Double
) {
    open fun brew() {
        println("Coffee brewing...")
    }
}

class Espresso : Coffee("Espresso", 150.0, 1.0, 0.0, 2.0) {
    override fun brew() {
        println("$name brewing with $waterNeeded cups of Water, $milkNeeded cups of Milk, $beansNeeded cups of Beans")
    }
}

class Latte : Coffee("Latte", 200.0, 1.0, 3.0, 2.5) {
    override fun brew() {
        println("$name brewing with $waterNeeded cups of Water, $milkNeeded cups of Milk, $beansNeeded cups of Beans")
    }
}

class Cappuccino : Coffee("Cappuccino", 220.0, 1.5, 3.0, 3.0) {
    override fun brew() {
        println("$name brewing with $waterNeeded cups of Water, $milkNeeded cups of Milk, $beansNeeded cups of Beans")
    }
}

class CoffeeMachine(
    private var water: Double,
    private var milk: Double,
    private var coffeeBeans: Double,
    private var cups: Int
) {
    fun addResources(wa: Double, mi: Double, co: Double, cu: Int) {
        water += wa
        milk += mi
        coffeeBeans += co
        cups += cu
    }

    fun makeCoffee(coffee: Coffee) {
        if (water >= coffee.waterNeeded &&
            milk >= coffee.milkNeeded &&
            coffeeBeans >= coffee.beansNeeded &&
            cups > 0
        ) {
            println("${coffee.name} is ready! Cost: ${coffee.price}")
            coffee.brew()
            water -= coffee.waterNeeded
            milk -= coffee.milkNeeded
            coffeeBeans -= coffee.beansNeeded
            cups--
        } else {
            println("Not enough resources! Please refill.")
        }
    }

    fun getStatus() {
        println("Available Water: $water")
        println("Available Milk: $milk")
        println("Available Coffee Beans: $coffeeBeans")
        println("Available Cups: $cups")
    }
}
abstract class CofeeMachineAction(

){

}

fun main() {
    val machine = CoffeeMachine(
        water = 5.0,
        milk = 5.0,
        coffeeBeans = 10.0,
        cups = 5
    )

    println("--- Coffee Machine Status at Start ---")
    machine.getStatus()

    val espresso = Espresso()
    machine.makeCoffee(espresso)

    val latte = Latte()
    machine.makeCoffee(latte)

    val cappuccino = Cappuccino()
    machine.makeCoffee(cappuccino)

    println("--- Coffee Machine Status After Serving ---")
    machine.getStatus()

    println("--- Refilling Resources ---")
    machine.addResources(3.0, 2.0, 5.0, 3)
    machine.getStatus()

    machine.makeCoffee(Latte())
}


//Shoping Cart




class Product(
    var id: Int,
    var name: String,
    var price: Double,
    var quantityAvailable: Int
)

class CartItem(
    var product: Product,
    var quantity: Int
)

interface BCart {
    fun adding(cartItem: CartItem, product: Product)
    fun delete(cartItem: CartItem)
    fun update(cartItem: CartItem, qua: Int)
    fun cost()
}

class CartItemManager :BCart {
    private val x = mutableListOf<CartItem>()

    override fun adding(cartItem: CartItem, product: Product) {
        if (product.quantityAvailable >= cartItem.quantity) {
            x.add(cartItem)
            println("${product.name} added to cart (x${cartItem.quantity})")
        } else {
            println("The item is not available. Sorry for inconvenience!")
        }
    }

    override fun delete(cartItem: CartItem) {
        val found = x.find { it.product.id == cartItem.product.id }
        if (found != null) {
            x.remove(found)
            println("${found.product.name} removed from cart.")
        } else {
            println("Item not found in cart.")
        }
    }

    override fun update(cartItem: CartItem, qua: Int) {
        val found = x.find { it.product.id == cartItem.product.id }
        if (found != null) {
            if (qua > 0) {
                found.quantity = qua
                println("${found.product.name} updated to $qua quantity.")
            } else {
                println("The quantity is invalid. Try again later.")
            }
        } else {
            println("Item not found in cart for update.")
        }
    }

    override fun cost() {
        var total = 0.0
        for (i in x) {
            println("Product Id: ${i.product.id}")
            println("Product Name: ${i.product.name}")
            println("Product Price: ${i.product.price}")
            println("Product Quantity: ${i.quantity}")
            println("-------------------------------------------")
            total += i.product.price * i.quantity
        }
        println("The Total Cost is: $total")
    }
}
class User(
    var id:Int,
    var username: String,
    var icart: BCart=CartItemManager()
){
    fun showDetails(user: User) {
        println("User ${user.id} created.")
        println("User ${user.username} created.")
        println(user.icart)
    }
}
fun main() {

    val laptop = Product(1, "Laptop", 75000.0, 5)
    val phone = Product(2, "Phone", 45000.0, 3)
    val tshirt = Product(3, "T-Shirt", 1200.0, 10)

    val user = User(101, "Asim")

    user.showDetails(user)

    // Add products to user's cart
    user.icart.adding(CartItem(laptop, 1), laptop)
    user.icart.adding(CartItem(phone, 2), phone)
    user.icart.adding(CartItem(tshirt, 3), tshirt)

    println("\n--- Cart after adding items ---")
    user.icart.cost()

    val phoneCartItem = CartItem(phone, 2) // simulate same product
    user.icart.update(phoneCartItem, 1)

    println("\n--- Cart after updating phone quantity ---")
    user.icart.cost()

    val laptopCartItem = CartItem(laptop, 1) // simulate same product
    user.icart.delete(laptopCartItem)

    println("\n--- Cart after deleting laptop ---")
    user.icart.cost()
}





