package com.cscorner.composemvvm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

sealed class LoginEvent {
    data class OnUsernameChange(val name: String) : LoginEvent()
    data class OnPasswordChange(val pwd: String) : LoginEvent()
    data object OnLoginClick : LoginEvent()
    data object OnLogoutClick : LoginEvent()
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginState,
    onEvent: (LoginEvent) -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onPrimary,
                        MaterialTheme.colorScheme.primary,
                    )
                )
            ),
        
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(
                    MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.large,
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Login", style = MaterialTheme.typography.headlineSmall)
            HorizontalDivider()
            OutlinedTextField(
                value = state.username,
                label = { Text(text = "Username")},
                onValueChange = { onEvent(LoginEvent.OnUsernameChange(it)) },
                isError = state.isError
            )
            OutlinedTextField(
                value = state.password,
                label = { Text(text = "Password")},
                onValueChange = { onEvent(LoginEvent.OnPasswordChange(it)) },
                isError = state.isError
            )
            ExtendedFloatingActionButton(
                modifier = Modifier.align(Alignment.End),
                onClick = { onEvent(LoginEvent.OnLoginClick) }) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Login to Account")
            }
        }
    }


}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        state = LoginState(
            username = "Ayush",
            password = "2024"
        )
    )
}