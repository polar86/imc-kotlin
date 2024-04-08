package com.tecmoveis.myproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.tecmoveis.myproject.ui.theme.MyProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitialForm()
        }
    }
}

private fun mToast(context: Context, field: String) {
    Toast.makeText(context, "Invalid Field: $field", Toast.LENGTH_SHORT).show();
}

private fun validateFields(name: String, height: String, weight: String): Boolean {
    if (name.isNotBlank() && height.isNotBlank() && weight.isNotBlank())
        return true;
    return false;
}

@Preview(showBackground = true)
@Composable
fun InitialForm(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var isValidHeight by remember { mutableStateOf(false) }
    var weight by remember { mutableStateOf("") }
    var isValidWeight by remember { mutableStateOf(false) }
    val mContext = LocalContext.current
    MyProjectTheme {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = modifier.fillMaxSize()) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "IMC - TEST",
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Please enter your Name") },
                        modifier = modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    OutlinedTextField(
                        value = height,
                        onValueChange = { newValue ->
                            if (newValue.isDigitsOnly()) {
                                height = newValue
                                isValidHeight = false
                            } else {
                                isValidHeight = true
                                mToast(mContext, "height")
                            }
                        },
                        label = { Text("Please insert your Height (cm)") },
                        modifier = modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    OutlinedTextField(
                        value = weight,
                        onValueChange = { newValue ->
                            if (newValue.isDigitsOnly()) {
                                weight = newValue
                                isValidWeight = false
                            } else {
                                isValidWeight = true
                                mToast(mContext, "weight")
                            }
                        },
                        label = { Text("Please insert your Weight (kg)") },
                        modifier = modifier.fillMaxWidth(),
                        isError = isValidWeight,
                        singleLine = true
                    )
                }
                Button(
                    onClick = {
                        val imc = IMC(name, weight.toFloat(), height.toFloat())
                        val intent = Intent(mContext, FinalActivity::class.java)
                        intent.putExtra("value", imc)
                        mContext.startActivity(intent)
                    },
                    enabled = validateFields(name, height, weight),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text("Submit")
                }
            }
        }
    }
}