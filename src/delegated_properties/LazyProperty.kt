package delegated_properties

class LazyProperty {
    val lazy: String by lazy {
        println("computed!")
        "my lazy"
    }
}

fun main(args: Array<String>) {
    val sample = LazyProperty()
    println("lazy = ${sample.lazy}")
    println("lazy = ${sample.lazy}")
}





