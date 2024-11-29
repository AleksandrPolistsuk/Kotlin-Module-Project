class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun showArchiveMenu() {
        while (true) {
            println("Архив $name :")
            val options = listOf("Создать заметку") + notes.map { it.title }
            val choice = getMenuChoice(options, includeBackOption = true)

            when (choice) {
                0 -> createNote()
                in 1..notes.size -> notes[choice - 1].showNote()
                else -> return
            }
        }
    }

    private fun createNote() {
        val title = getUserInput("Введите название заметки:")

        if (title.isBlank()) {
            println("Название заметки не может быть пустым.")
            return
        }

        val content = getUserInput("Введите текст заметки:")

        if (content.isBlank()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        notes.add(Note(title, content))
        println("Заметка $title создана.")
    }
}
