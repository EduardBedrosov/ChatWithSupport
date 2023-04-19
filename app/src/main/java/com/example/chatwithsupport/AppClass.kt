package com.example.chatwithsupport

import android.app.Application
import android.util.Log
import com.example.chatwithsupport.ui.CHAT_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import zendesk.android.Zendesk
import zendesk.messaging.android.DefaultMessagingFactory

class AppClass: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppClass)
            modules(CHAT_MODULE)
        }
        Zendesk.initialize(
            context = this,
            channelKey = "eyJzZXR0aW5nc191cmwiOiJodHRwczovL2VkdWFyZGJlZHJvc292LnplbmRlc2suY29tL21vYmlsZV9zZGtfYXBpL3NldHRpbmdzLzAxR1lDWDVEWEZDQUM5QlA4U0czMTZZRkRHLmpzb24ifQ==",
            successCallback = { zendesk ->
                Log.i("IntegrationApplication", "Initialization successful")
            },
            failureCallback = { error ->
                // Tracking the cause of exceptions in your crash reporting dashboard will help to triage any unexpected failures in production
                Log.e("IntegrationApplication", "Initialization failed", error)
            },
            messagingFactory = DefaultMessagingFactory()
        )
    }
}