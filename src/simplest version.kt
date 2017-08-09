import Person.Language

/**
 * Created by ncyang on 8/30/16.
 */

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "world"
    println("Hello $name!")
    println("Hello ${args[0]}")

    val people = listOf(
            Person("Michael"),
            Hispanophone("Miguel"),
            Francophone("Michelle")
    )

    for (person in people) {
        person.greet()
    }
}

fun getLanguage(args: Array<String>) {
    val language = if (args.size == 0) "EN" else args[0]
    println(when (language) {
        "EN" -> "Hello!"
        "FR" -> "Salut!"
        "IT" -> "Ciao"
        else -> "Sorry, I can't greet you in $language yet"
    })
}

open class Person(var name: String, var lang: Language = Language.EN) {

    enum class Language(val greeting: String) {
        EN("Hello"), ES("Hola"), FR("Bonjour")
    }

    fun greet() = {
        println("${lang.greeting}, $name")
    }
}

class Hispanophone(name: String) : Person(name, Language.ES)
class Francophone(name: String) : Person(name, Language.FR)




