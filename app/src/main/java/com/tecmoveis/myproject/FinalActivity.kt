package com.tecmoveis.myproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tecmoveis.myproject.ui.theme.MyProjectTheme
import java.text.DecimalFormat

class FinalActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalForm()
        }
    }

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true)
@Composable
fun FinalForm(modifier: Modifier = Modifier) {
        val mContext = LocalContext.current
        val df = DecimalFormat("#.##")
        val imc = intent.getParcelableExtra("value", IMC::class.java)
        MyProjectTheme {
            Surface(
                modifier = modifier,
                color = MaterialTheme.colorScheme.background
            )
            {
                Column(modifier = modifier.fillMaxSize()) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "IMC - Result",
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            style = MaterialTheme.typography.titleLarge,
                        )
                    }
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                            ),
                            modifier = modifier.fillMaxWidth().padding(10.dp),
                            content = {
                                Text(
                                    modifier = modifier.padding(15.dp),
                                    text = "Nome: ${imc?.name.toString()}"

                                )
                                Text(
                                    modifier = modifier.padding(15.dp),
                                    text = "Weight: ${df.format(imc?.weight)}"
                                )
                                Text(
                                    modifier = modifier.padding(15.dp),
                                    text = "Height: ${df.format(imc?.height)}"
                                )
                                Text(
                                    modifier = modifier.padding(15.dp),
                                    text = "IMC: ${imc?.calculate()}"
                                )
                                Text(
                                    modifier = modifier.padding(15.dp),
                                    text = "Imc: ${df.format(imc?.imc)}"
                                )
                            }
                        )
                    }
                    Button(
                        onClick = {
                            val intent = Intent(mContext, MainActivity::class.java)
                            mContext.startActivity(intent)
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Text("Go Back")
                    }
                }
            }
        }
}
}