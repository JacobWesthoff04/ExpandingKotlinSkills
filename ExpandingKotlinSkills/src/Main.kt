fun main() {
    print("Enter your name: ")
    val name = readln()
    print("Enter your age: ")
    val age = readln().toInt()
    if (age == 0) {
        println("Please enter a valid age")
        main()
    }
    val user = User(name, age)

    while (true) {
        println("Press 1 to see if you can vote")
        println("Press 2 to use the calculator")
        println("Press 3 to exit")
        print("Input: ")
        val input = readln()

        when (input) {
            1.toString() -> vote(user)
            2.toString() -> calcualtor()
            3.toString() -> {
                print("Exiting program...")
                break
            }
        }
    }
}

class User(var name: String, var age: Int) {
    init {
        println("User created for $name, $age years old.")
    }
}

fun calcualtor() {
    val operationMap = mapOf(
        "+" to "Sum",
        "-" to "Difference",
        "*" to "Product",
        "/" to "Quotient"
    )

    println("Available Operations:")
    for (operation in operationMap.keys) {
        println(operation)
    }

    print("Enter your first number: ")
    val num1 = readln().toDouble()
    print("Enter your second number: ")
    val num2 = readln().toDouble()
    listOfOperations()
    print("Enter the operation you would like to perform: ")
    val operation = readln()
    val operationName = operationMap[operation] ?: "Invalid operation"

    if (operationName != "Invalid operation") {
        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else ("You cannot divide by zero")
                else -> "Invalid operation"
        }
        println("$operationName: $result")
    } else {
        println("Invalid operation, try again")
        calcualtor()
    }

}

fun listOfOperations() {
    println("Addition: +")
    println("Subtraction: -")
    println("Multiplication: *")
    println("Division: /")
}

fun vote(user : User) {
    if (user.age >= 18) {
        print("You can vote ${user.name}!\n")
    } else {
        print("Sorry ${user.name}, you cannot vote.\n")
    }
}