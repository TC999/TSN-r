package com.baidu.liantian.rp.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.f;
import com.baidu.liantian.e;

/* compiled from: Receiver.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                f.a(context).a();
            } else if (action.equals("com.b.r.p")) {
                b.a();
                e eVar = new e(context);
                int x3 = eVar.x();
                b.a();
                com.baidu.liantian.b.e.a(context, x3 * 3600000);
                f.a(context).c();
                eVar.d(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }
}
