fun getMenuChoice(options: List<String>, includeBackOption: Boolean = false): Int {
    val fullOptions = if (includeBackOption) options + "Назад" else options

    while (true) {
        fullOptions.forEachIndexed { index, option -> println("${index + 1}. $option") }

        println("Введите номер пункта меню:")

        val input = readLine()?.toIntOrNull()
        if (input == null) {
            println("Ошибка: необходимо ввести цифру. Попробуйте снова.")
        } else if (input !in 1..fullOptions.size) {
            println("Ошибка: такой цифры нет в меню. Попробуйте снова.")
        } else {
            return input - 1
        }
    }
}

fun getUserInput(prompt: String): String {
    println(prompt)
    return readLine()?.trim().orEmpty()
}
