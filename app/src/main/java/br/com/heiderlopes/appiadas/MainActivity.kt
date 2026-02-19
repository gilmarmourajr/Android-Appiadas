package br.com.heiderlopes.appiadas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.heiderlopes.appiadas.ui.theme.AppiadasTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppiadasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppiadasScreen()
                }
            }
        }
    }
}

@Composable
fun AppiadasScreen(modifier: Modifier = Modifier) {

    var piadaSelecionada by remember { mutableStateOf("Aqui sera exibida a piada") }
    val piadas: List<Piada> = listOf(
        Piada(1, "Qual o rei dos queijos?\nO REIqueijão"),
        Piada(2, "O que um álcool disse para outro álcool?\nEtanois!"),
        Piada(3, "O que é um piolho na cabeça de um careca?\nUm sem terra!"),
        Piada(4, "Piada 4"),
        Piada(5, "Por que o Batman colocou o bat-móvel no seguro?\nPorque ele tem medo que Robin!"),
        Piada(6, "Por que o Batman não joga baralho?\nPorque ele sempre tem medo do Coringa."),
        Piada(7, "Batman, por que você está batendo nesse palhaço?\nPorque ele é o Coringa!\nMas Batman, esse não é o Coringa, é o Patatá!"),
    )

    fun trocarPiada() {
        val index = Random.nextInt(piadas.size)
        piadaSelecionada = piadas[index].texto
    }

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(
            painter = painterResource(R.drawable.background_joker),
            contentDescription = "Imagem de fundo da aplicação",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                piadaSelecionada,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF5722),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { trocarPiada() }
            ) {
                Text("Nova piada")
            }
        }
    }
}

data class Piada (
    var id : Long,
    var texto : String
)

@Preview(showBackground = true)
@Composable
private fun AppiadasScreenPreview() {
    AppiadasTheme {
        AppiadasScreen()
    }
}