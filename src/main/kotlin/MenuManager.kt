class MenuManager {
    private val archives = mutableListOf<Archive>()

    fun showMainMenu() {
        while (true) {
            println("Меню:")
            val options = listOf("Создать архив") + archives.map { it.name } + "Выйти"
            val choice = getMenuChoice(options)

            when (choice) {
                0 -> createArchive()
                in 1..archives.size -> archives[choice - 1].showArchiveMenu()
                else -> {
                    println("Программа завершена.")
                    return
                }
            }
        }
    }

    private fun createArchive() {
        val name = getUserInput("Введите название архива:")

        if (name.isNotBlank()) {
            archives.add(Archive(name))
            println("Архив $name создан.")
        } else {
            println("Название архива не может быть пустым.")
        }
    }
}
