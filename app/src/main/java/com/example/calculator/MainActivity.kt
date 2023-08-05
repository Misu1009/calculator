package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}
@Composable
fun CalculatorApp() {
    var equation by remember { mutableStateOf("") }

    var result by remember { mutableStateOf("") }

    LaunchedEffect(equation) {
        result = evaluateAlgebraicExpression(equation)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) { // 1
            Text(
                text = "CALCULATOR",
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(275.dp))           // 2
        tiga(equation = equation, result = result)  // 3
        Spacer(modifier = Modifier.height(25.dp))
        empat(
            equation = equation,
            onClickedButtonn = { value ->
                equation += value
            },
            acClickedButton = {
                if(!(equation=="")){
                    equation = ""
                }
            },
            backspaceClickedButton = {
                if(!(equation=="")){
                    equation = equation.substring(0, equation.length-1)
                }
            },
            equalsClickedButton = {
                equation = result
            }
        )                                     // 4
    }
}
fun evaluateAlgebraicExpression(expression: String): String {
    if(expression.equals("")){
        return "0"
    }
    if(expression.last() in listOf<Char>('*', '/', '+', '-', '.')){
        return "Input Number"
    }
    val result = ExpressionBuilder(expression)
        .build()
        .evaluate()
    return result.toString()
}
@Composable
fun tiga(equation: String, result: String){
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = equation,
            fontSize = 70.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp)
        )
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "= "+ result,
            fontSize = 50.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 30.dp)
        )
    }
}

@Composable
fun empat(
    equation: String,
    onClickedButtonn: (String)-> Unit,
    acClickedButton: (String)-> Unit,
    backspaceClickedButton: (String)-> Unit,
    equalsClickedButton: (String)-> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row() {
            IconSymbol(image = R.drawable.ac, modifier = Modifier.weight(2f),
                value = "", onClickedButtonn = acClickedButton)//
            IconSymbol(image = R.drawable.baseline_backspace_24, modifier = Modifier.weight(1f),
                value = "", onClickedButtonn = backspaceClickedButton)//
//            Symbol(image = R.drawable.baseline_percent_24, modifier = Modifier.weight(1f),
//                value = "%", equation = equation, onClickedButtonn = onClickedButtonn)Icon
            IconSymbol(image = R.drawable.divide, modifier = Modifier.weight(1f),
                value = "/", onClickedButtonn = onClickedButtonn)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            IconSymbol(image = R.drawable.seven, modifier = Modifier.weight(1f),
                value = "7", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.eight, modifier = Modifier.weight(1f),
                value = "8", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.nine, modifier = Modifier.weight(1f),
                value = "9", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.times, modifier = Modifier.weight(1f),
                value = "*", onClickedButtonn = onClickedButtonn)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            IconSymbol(image = R.drawable.four, modifier = Modifier.weight(1f),
                value = "4", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.five, modifier = Modifier.weight(1f),
                value = "5", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.six, modifier = Modifier.weight(1f),
                value = "6", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.minus, modifier = Modifier.weight(1f),
                value = "-", onClickedButtonn = onClickedButtonn)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            IconSymbol(image = R.drawable.one, modifier = Modifier.weight(1f),
                value = "1", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.two, modifier = Modifier.weight(1f),
                value = "2", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.three, modifier = Modifier.weight(1f),
                value = "3", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.baseline_add_24, modifier = Modifier.weight(1f),
                value = "+", onClickedButtonn = onClickedButtonn)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
//            IconSymbol(image = R.drawable.wide, modifier = Modifier.weight(1f),
//                value = "", equation = equation, onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.zero, modifier = Modifier.weight(1f),
                value = "0", onClickedButtonn = onClickedButtonn)
            IconSymbol(image = R.drawable.dot, modifier = Modifier.weight(1f), size = 10,
                value = ".", onClickedButtonn = onClickedButtonn)//
            IconSymbol(image = R.drawable.equal, modifier = Modifier.weight(2f),
                value = "+", onClickedButtonn = equalsClickedButton)//
        }
    }
}

@Composable
fun IconSymbol(
    image: Int,
    value: String,
    modifier: Modifier= Modifier,
    size: Int = 30,
    onClickedButtonn: (String)->Unit
){
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
//            .background(Color.White)
            .clickable {
                onClickedButtonn(value)
            },
        contentAlignment = Alignment.Center,
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(size.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun IconSymbolPreview(){
    CalculatorApp()
}