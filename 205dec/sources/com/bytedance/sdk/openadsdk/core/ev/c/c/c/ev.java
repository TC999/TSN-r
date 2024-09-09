package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.sr f33387c;
    private String sr;

    /* renamed from: w  reason: collision with root package name */
    private Context f33388w;
    private me xv;

    public ev(com.bytedance.sdk.openadsdk.core.u.sr srVar, Context context) {
        this.f33387c = srVar;
        this.f33388w = context;
    }

    private void w() {
        new CountDownTimer(3000L, 3000L) { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.ev.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (k.sr() == null || k.sr().c()) {
                    ev.this.c(true);
                } else {
                    ev.this.c(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
            }
        }.start();
    }

    public void c(me meVar) {
        this.xv = meVar;
    }

    public void c(String str) {
        this.sr = str;
    }

    public boolean w(String str) {
        if (this.f33388w == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            this.f33388w.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        return c();
    }

    private boolean c() {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f33387c;
        if (srVar == null) {
            return false;
        }
        String c4 = srVar.c();
        if (ia.sr(this.xv) != 3 || TextUtils.isEmpty(c4)) {
            return false;
        }
        boolean w3 = w(c4);
        if (w3) {
            w();
        } else {
            c(false);
        }
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3) {
        if (z3) {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.xv, this.sr, "quickapp_fail");
        }
    }
}
