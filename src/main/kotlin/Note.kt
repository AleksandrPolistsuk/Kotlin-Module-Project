class Note(val title: String, val content: String) {
    fun showNote() {
        while (true) {
            println("Заметка $title :")

            println(content)

            val choice = getMenuChoice(listOf("Назад"))

            when (choice) {
                0 -> return
            }
        }
    }
}
