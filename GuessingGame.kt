fun generateRandomNumber(): Int {
    return (0..10).shuffled().take(4).joinToString("").toInt()
}

fun checkUserInput(num1: Int, num2: Int): Pair<Int, Int> {
    val dig1 = num1.toString().toCharArray()
    val dig2 = num2.toString().toCharArray()

    var foundNum = 0
    var foundPosition = 0

    for (i in dig1.indices)
        for (j in dig2.indices)
            if (dig1[i] == dig2[j]) {
                foundNum++
                if (i == j)
                    foundPosition++
            }

    return Pair(foundNum, foundPosition)
}

fun getHint(generatedNum: Int) {
    println("Hint for today: ${generatedNum / 100}")
}

fun checkTries(tries: Int, randomNumber: Int) {
    when (tries) {
        3 -> getHint(randomNumber)
        6 -> {
            println("Do you want the solution ? [y|n]")
            val answer = readln()
            if (answer.equals("y", true))
                println("Here is the solution $randomNumber")
        }
    }
}

fun getUserInput() {
    println("Welcome to our guessing game")
    println(
        "There is a 4 digit generated code," +
                "guess the code and you will win the prise :)"
    )

    val randomNumber = generateRandomNumber()
    var input = readln().toInt()
    var tries = 1

    while (input != randomNumber) {
        val (foundNum, foundPos) = checkUserInput(randomNumber, input)
        println("User input: ${input}, Output: $foundNum:$foundPos")
        input = readln().toInt()
        checkTries(tries, randomNumber)
        tries++
    }
    println("Nice you won :)")
}

fun main() {
    getUserInput()
}