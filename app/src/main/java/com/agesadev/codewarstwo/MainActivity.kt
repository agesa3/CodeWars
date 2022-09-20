package com.agesadev.codewarstwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.agesadev.codewarstwo.presentation.screens.challengelist.CompletedChallengesScreen
import com.agesadev.codewarstwo.presentation.screens.challengelist.components.CompletedChallengeItem
import com.agesadev.codewarstwo.ui.theme.CodewarsTwoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodewarsTwoTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    CompletedChallengesScreen()
                }
            }
        }
    }

}

