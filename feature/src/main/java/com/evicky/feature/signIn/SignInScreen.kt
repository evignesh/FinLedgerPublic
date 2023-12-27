package com.evicky.feature.signIn

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evicky.feature.R

@Composable
internal fun SignInScreen(
    signInUiState: SignInUiState,
    onSignInPress: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_finance_ledger),
            contentDescription = "logo",
            alignment = Alignment.Center,
            modifier = Modifier.height(250.dp).width(250.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        PhoneNumberField(signInUiState = signInUiState) { updatedValue ->
            onPhoneNumberChange(updatedValue)
        }
        OutlinedButton(
            onClick = { onSignInPress(signInUiState.phoneNumber) },
            enabled = signInUiState.errorMessage.isEmpty()
        ) {
            Text(text = stringResource(R.string.sign_in))
        }
    }
}

@Composable
fun PhoneNumberField(
    modifier: Modifier = Modifier,
    signInUiState: SignInUiState,
    onPhoneNumberChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = signInUiState.phoneNumber,
        onValueChange = { updatedValue -> onPhoneNumberChange(updatedValue) },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier.padding(horizontal = 40.dp)),
        label = {
            Text(text = stringResource(R.string.mobile_number))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        },
        isError = signInUiState.errorMessage.isNotEmpty(),
        supportingText = {
            Text(text = signInUiState.errorMessage, style = MaterialTheme.typography.bodySmall, color = Color.Red)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        SignInScreen(
            signInUiState = SignInUiState(),
            onSignInPress = { _ -> },
            onPhoneNumberChange = { _ -> }
        )
    }
}

@Preview(device = "id:Nexus 7", showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = false
)
@Composable
private fun LoginScreenTabPreview() {
    MaterialTheme {
        SignInScreen(
            signInUiState = SignInUiState(),
            onSignInPress = { _ -> },
            onPhoneNumberChange = { _ -> }
        )
    }
}