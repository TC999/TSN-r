package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.a;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<c> f29396c;

    public void c(c cVar) {
        this.f29396c = new WeakReference<>(cVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a.w("ThemeStatusBroadcastReceiver", "====ubject status update====");
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<c> weakReference = this.f29396c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29396c.get().b_(intExtra);
    }
}
