package com.bytedance.sdk.openadsdk.core.ugeno.xv;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.adsdk.ugeno.w.l;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements b, l {

    /* renamed from: c  reason: collision with root package name */
    private Context f35087c;

    /* renamed from: f  reason: collision with root package name */
    private String f35088f;

    /* renamed from: r  reason: collision with root package name */
    private int f35089r;
    private c sr;
    private l ux;

    /* renamed from: w  reason: collision with root package name */
    private ux f35090w;
    private com.bytedance.adsdk.ugeno.component.b<View> xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    interface c {
        void c(h hVar);
    }

    public w(Context context, ux uxVar, String str, int i4) {
        this.f35087c = context;
        this.f35090w = uxVar;
        this.f35088f = str;
        this.f35089r = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, JSONObject jSONObject2, r rVar) {
        i iVar = new i(this.f35087c);
        com.bytedance.adsdk.ugeno.component.b<View> c4 = iVar.c(jSONObject);
        this.xv = c4;
        if (c4 == null) {
            ux uxVar = this.f35090w;
            if (uxVar != null) {
                uxVar.c(-1, "ugeno render fail");
            }
            if (rVar != null) {
                rVar.c(-1, "");
                return;
            }
            return;
        }
        iVar.i(this);
        iVar.g(this);
        iVar.k(jSONObject2);
        this.f35090w.c(0L);
        if (rVar != null) {
            rVar.c(this.xv);
        }
    }

    public void c(c cVar) {
        this.sr = cVar;
    }

    public void c(l lVar) {
        this.ux = lVar;
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2, final r rVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(jSONObject, jSONObject2, rVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.w(jSONObject, jSONObject2, rVar);
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.b
    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
        c cVar;
        if (hVar == null || hVar.g() != 1 || (cVar = this.sr) == null) {
            return;
        }
        cVar.c(hVar);
    }

    @Override // com.bytedance.adsdk.ugeno.w.l
    public void c(com.bytedance.adsdk.ugeno.component.b bVar, MotionEvent motionEvent) {
        l lVar = this.ux;
        if (lVar != null) {
            lVar.c(bVar, motionEvent);
        }
    }
}
