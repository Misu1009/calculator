import com.example.calculator.evaluateAlgebraicExpression

fun main(){
    val expression1 = ""
    val expression2 = "9.9+5*3-2"
    val expression3 = "8*6/3"

    println(evaluateAlgebraicExpression(expression1)) // Output: "0"
    println(evaluateAlgebraicExpression(expression2)) // Output: "28.0"
    println(evaluateAlgebraicExpression(expression3)) // Output: "16.0"
}