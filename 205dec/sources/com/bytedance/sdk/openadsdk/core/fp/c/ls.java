package com.bytedance.sdk.openadsdk.core.fp.c;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33561c;
    private long sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33562w;
    private com.bytedance.sdk.openadsdk.core.ia.f xv;

    public ls(xk xkVar, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33561c = new WeakReference<>(xkVar);
        this.f33562w = meVar;
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, final xk xkVar, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("requestVideoDelayCallback", new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.ls.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new ls(xk.this, meVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar = this.f33561c.get();
        if (xkVar != null && jSONObject != null) {
            this.xv = new com.bytedance.sdk.openadsdk.core.ia.f() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.ls.2
                @Override // com.bytedance.sdk.openadsdk.core.ia.f
                public void c() {
                    com.bytedance.sdk.component.utils.a.w("requestVideoDelay", "rdl " + ls.this.sr);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.ls.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ls.this.c((ls) new JSONObject());
                            } catch (Exception e4) {
                                com.bytedance.sdk.component.utils.a.f("requestVideoDelay", e4.getMessage());
                            }
                        }
                    }, ls.this.sr);
                }
            };
            int optInt = jSONObject.optInt("delay", -1);
            com.bytedance.sdk.component.utils.a.w("requestVideoDelay", "delay " + optInt);
            if (optInt < 0) {
                return;
            }
            this.sr = optInt;
            if (xkVar.wv()) {
                this.xv.c();
                return;
            } else {
                xkVar.c(this.xv);
                return;
            }
        }
        xv();
    }
}
