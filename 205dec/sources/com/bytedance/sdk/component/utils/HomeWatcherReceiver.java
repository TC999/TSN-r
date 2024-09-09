package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* renamed from: c  reason: collision with root package name */
    private c f30181c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    public void c(c cVar) {
        this.f30181c = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            Log.i("HomeReceiver", "onReceive: action: " + action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                Log.i("HomeReceiver", "reason: " + stringExtra);
                if ("homekey".equals(stringExtra)) {
                    Log.i("HomeReceiver", "homekey");
                    c cVar = this.f30181c;
                    if (cVar != null) {
                        cVar.c();
                    }
                } else if ("recentapps".equals(stringExtra)) {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    c cVar2 = this.f30181c;
                    if (cVar2 != null) {
                        cVar2.w();
                    }
                } else if ("assist".equals(stringExtra)) {
                    Log.i("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            a.f("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
