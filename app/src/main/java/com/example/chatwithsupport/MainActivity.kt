package com.example.chatwithsupport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import zendesk.core.AnonymousIdentity
import zendesk.core.Zendesk
import zendesk.support.Support
import zendesk.core.Identity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Zendesk.INSTANCE.init(this, "https://eduardbedrosov.zendesk.com",
            "4f0ca951db108b9219daf1f0a729635c709c402d715b201d",
            "mobile_sdk_client_09305d9eb78b3baada8b")

        Support.INSTANCE.init(Zendesk.INSTANCE)

        val identity: Identity = AnonymousIdentity()
        Zendesk.INSTANCE.setIdentity(identity)

        Support.INSTANCE.init(Zendesk.INSTANCE)
        zendesk.android.Zendesk.instance.messaging.showMessaging(this)
    }
}