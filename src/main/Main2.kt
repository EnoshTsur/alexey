package main

fun doWith(predicate: (String) -> Boolean): (String) -> ((String) -> String, (String) -> String) -> String = {
    value -> { fn1, fn2 -> if (predicate(value)) fn1(value) else fn2(value) }
}

fun main() {
    val predicate: (String) -> Boolean = { str -> str.trim().toLowerCase().contains("a")}
  val doWithContains = doWith (predicate)

    val res = doWithContains("itsik")({ x -> "$x hahah" }, { x -> "$x baba" })
    println(res)
}