package com.example.componentesteste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.componentesteste.ui.theme.ComponentesTesteTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.componentesteste.ui.theme.DarkOrange


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentesTesteTheme {
               CadastroScreen()

            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CadastroScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White) // Fundo branco
    ) {
        Text(
            text = "Cadastro",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black, // Letras pretas
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        CadastroTextField("Nome Completo")
        CadastroTextField("E-mail")
        CadastroTextField("Senha", isPassword = true)
        CadastroTextField("Confirmar Senha", isPassword = true)

        Button(
            onClick = { /* Ação de cadastro */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp) // Reduzir o espaço superior
                .height(48.dp) // Altura reduzida
                .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
            colors = ButtonDefaults.buttonColors(containerColor = DarkOrange // Botão laranja
            ),
            shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)) // Bordas menos arredondadas
        ) {
            Text("Cadastrar", color = Color.White) // Letra branca
        }
    }
}

@Composable
fun CadastroTextField(
    hint: String,
    isPassword: Boolean = false
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Column {
                innerTextField()
                if (text.isEmpty()) {
                    Text(hint, style = MaterialTheme.typography.bodyLarge, color = Color.White)
                }
            }
        }
    )
}

@Preview
@Composable
fun CadastroScreenPreview() {
    CadastroScreen()
}

@Preview
@Composable
fun NomeCompletoTextFieldPreview() {
    CadastroTextField("Nome Completo")
}

@Preview
@Composable
fun EmailTextFieldPreview() {
    CadastroTextField("E-mail")
}

@Preview
@Composable
fun SenhaTextFieldPreview() {
    CadastroTextField("Senha", isPassword = true)
}

@Preview
@Composable
fun ConfirmarSenhaTextFieldPreview() {
    CadastroTextField("Confirmar Senha", isPassword = true)
}

@Preview
@Composable
fun CadastrarButtonPreview() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = DarkOrange // Botão laranja
        ),
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)) // Bordas menos arredondadas
    ) {
        Text("Cadastrar", color = Color.White) // Letra branca
    }
}