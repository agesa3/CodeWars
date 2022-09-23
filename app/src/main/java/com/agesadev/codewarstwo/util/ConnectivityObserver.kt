package com.agesadev.codewarstwo.util

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observeConnectivity(): Flow<Status>

    enum class Status {
        CONNECTED,
        DISCONNECTED
    }
}