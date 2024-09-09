package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.bk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private Toast f35338c;

    /* renamed from: f  reason: collision with root package name */
    private w f35339f;
    private String sr;
    private final AtomicBoolean ux = new AtomicBoolean(true);

    /* renamed from: w  reason: collision with root package name */
    private final me f35340w;
    private final Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c();

        void c(String str, boolean z3);
    }

    public sr(me meVar, Context context) {
        this.f35340w = meVar;
        this.xv = context;
    }

    private void w(final bk bkVar) {
        if (bkVar == null) {
            return;
        }
        try {
            ls.c().c(com.bytedance.sdk.component.utils.c.c(bkVar.w()), new ck.xv<com.bytedance.sdk.component.ev.w>() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.sr.3
                @Override // com.bytedance.sdk.openadsdk.core.ck.xv
                public void c(int i4, String str) {
                    sr.this.c();
                    sr.this.xv(bkVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ck.xv
                public void c(com.bytedance.sdk.component.ev.w wVar) {
                    if (wVar == null || !wVar.ev() || TextUtils.isEmpty(wVar.sr())) {
                        sr.this.c();
                        sr.this.xv(bkVar);
                        return;
                    }
                    try {
                        sr.this.c(new JSONObject(wVar.sr()));
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(bk bkVar) {
        if (this.ux.getAndSet(false)) {
            w(bkVar);
        }
    }

    private void w(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("is_apply_coupon");
        String optString = jSONObject.optString("error_type");
        if (optBoolean && "success".equals(optString)) {
            com.bytedance.sdk.openadsdk.core.a.xv.sr(this.f35340w, this.sr, 1);
        } else if (optBoolean && "has_applied".equals(optString)) {
            com.bytedance.sdk.openadsdk.core.a.xv.sr(this.f35340w, this.sr, 2);
        } else if (!optBoolean) {
            com.bytedance.sdk.openadsdk.core.a.xv.sr(this.f35340w, this.sr, 3);
        }
        if (this.f35339f != null) {
            if (optBoolean && "success".equals(optString)) {
                this.f35339f.c();
            } else {
                this.f35339f.c(optString, optBoolean);
            }
        }
    }

    public sr c(String str) {
        this.sr = str;
        return this;
    }

    public void c(w wVar) {
        this.f35339f = wVar;
    }

    public static boolean c(me meVar, Context context) {
        bk ue = meVar != null ? meVar.ue() : null;
        return ue != null && ue.ux();
    }

    public static boolean c(me meVar) {
        bk ue;
        if (meVar == null || (ue = meVar.ue()) == null) {
            return false;
        }
        return ue.xv() == 0 || ue.xv() == 5;
    }

    public boolean c(final c cVar) {
        me meVar = this.f35340w;
        bk ue = meVar != null ? meVar.ue() : null;
        c(ue);
        w(ue);
        q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.sr.1
            @Override // java.lang.Runnable
            public void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }
        }, 500L);
        return true;
    }

    private void c(bk bkVar) {
        if (bkVar == null || TextUtils.isEmpty(bkVar.sr())) {
            return;
        }
        final String sr = bkVar.sr();
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.sr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sr srVar = sr.this;
                    srVar.f35338c = Toast.makeText(StubApp.getOrigApplicationContext(srVar.xv.getApplicationContext()), sr, 0);
                    sr.this.f35338c.setGravity(17, 0, 0);
                    sr.this.f35338c.show();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.a.xv.sr(this.f35340w, this.sr, 4);
        w wVar = this.f35339f;
        if (wVar != null) {
            wVar.c("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                w(jSONObject);
            }
        } catch (Throwable unused) {
            c();
        }
    }
}
