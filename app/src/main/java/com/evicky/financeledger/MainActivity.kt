package com.evicky.financeledger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.evicky.financeledger.root.RootHost
import com.evicky.financeledger.ui.theme.FinanceLedgerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceLedgerTheme {
                RootHost()
            }
        }
    }
}