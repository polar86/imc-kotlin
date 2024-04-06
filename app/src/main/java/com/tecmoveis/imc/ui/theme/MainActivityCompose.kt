package com.tecmoveis.imc.ui.theme

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Decimal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.tecmoveis.imc.Bmi
import com.tecmoveis.imc.R
import com.tecmoveis.imc.ResultActivity


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityCompose(){
    val context = LocalContext.current
    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {
        val(textViewTitleForm, layoutEditName, layoutEditWeight, layoutEditHeight, btnCalc) = createRefs()
        var nameValue by remember { mutableStateOf("") }
        var weightValue by remember { mutableStateOf("") }
        var heightValue by remember { mutableStateOf("") }
        var isButtonClicked by remember { mutableStateOf(false) }

        Text(
            text = stringResource(R.string.labelTitleFormTest),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.constrainAs(textViewTitleForm) {
                top.linkTo(parent.top, margin = 8.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            },
            onTextLayout = {},
        )
        OutlinedTextField(
            value = nameValue,
            onValueChange = { nameValue = it },
            placeholder = {Text("Enter your name here")},
            label = { Text(stringResource(R.string.labelEditName))},
            modifier = Modifier.constrainAs(layoutEditName){
                top.linkTo(textViewTitleForm.bottom, margin = 16.dp)
                start.linkTo(textViewTitleForm.start, margin = 16.dp)
                end.linkTo(textViewTitleForm.end, margin = 16.dp)
            },
            isError = true,
            singleLine = true
        )
        OutlinedTextField(
            value = weightValue,
            onValueChange = { weightValue = it },
            placeholder = {Text("Enter your weight here")},
            label = { Text(stringResource(R.string.layoutEditWeight))},
            keyboardOptions = KeyboardOptions(keyboardType = Decimal),
            modifier = Modifier.constrainAs(layoutEditWeight){
                top.linkTo(layoutEditName.bottom, margin = 16.dp)
                start.linkTo(textViewTitleForm.start, margin = 16.dp)
                end.linkTo(textViewTitleForm.end, margin = 16.dp)

            },
            isError = true,
            singleLine = true
        )
        OutlinedTextField(
            value = heightValue,
            onValueChange = { heightValue = it },
            placeholder = {Text("Enter your height here")},
            label = { Text(stringResource(R.string.layoutEditHeight))},
            keyboardOptions = KeyboardOptions(keyboardType = Decimal),
            modifier = Modifier.constrainAs(layoutEditHeight){
                top.linkTo(layoutEditWeight.bottom, margin = 16.dp)
                start.linkTo(textViewTitleForm.start, margin = 16.dp)
                end.linkTo(textViewTitleForm.end, margin = 16.dp)
            },
            isError = true,
            singleLine = true
        )
        Button(
            onClick = {
                      isButtonClicked = true
                      val bmi = Bmi(nameValue, weightValue.toFloat(), heightValue.toFloat())
                      val intent = Intent(context,ResultActivity::class.java)
                      intent.putExtra("value", bmi)
                      context.startActivity(intent)
            },
            modifier = Modifier.constrainAs(btnCalc){
                top.linkTo(layoutEditHeight.bottom, margin = 16.dp)
                start.linkTo(textViewTitleForm.start, margin =16.dp)
                end.linkTo(textViewTitleForm.end, margin = 16.dp)
            })
            { Text("Submit")}
    }
}