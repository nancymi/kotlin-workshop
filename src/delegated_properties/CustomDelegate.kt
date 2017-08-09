package delegated_properties

import kotlin.reflect.KProperty

/*
    String by Delegate() => set/get value 将使用声明的代理类

    println(example.p) => p.getValue() => $thisRef = class.toString, property.name = "p"
    example.p = "hello" => p.setValue() => $thisRef = class.toString, property.name = "p", value = "hello"
 */

class Example {
    var p: String by Delegate()
    var q: String by Delegate()

    override fun toString() = "P.value: $p Q.value: $q"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "Thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name}");
    }
}

fun main(args: Array<String>) {
    val e = Example()
    e.p = "NEW P"
    e.q = "NEW Q"

    println(e.p)
    println(e.q)

    println(e.toString())
}
