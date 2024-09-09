package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import com.bytedance.sdk.openadsdk.core.widget.ux;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements b {

    /* renamed from: c  reason: collision with root package name */
    private Context f35032c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.component.b<View> f35033w;
    private ux.c xv;

    public ux(Context context) {
        this.f35032c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, JSONObject jSONObject2, r rVar) {
        i iVar = new i(this.f35032c);
        g gVar = new g();
        gVar.b(this.f35032c);
        iVar.j("ugen_download_dialog", gVar);
        com.bytedance.adsdk.ugeno.component.b<View> c4 = iVar.c(jSONObject);
        this.f35033w = c4;
        if (c4 != null) {
            iVar.g(this);
            iVar.k(jSONObject2);
        }
        if (rVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.component.b<View> bVar = this.f35033w;
        if (bVar == null) {
            rVar.c(-1, "UGenWidget is null");
        } else {
            rVar.c(bVar);
        }
    }

    public void c(ux.c cVar) {
        this.xv = cVar;
    }

    public void c(final JSONObject jSONObject, final JSONObject jSONObject2, final r rVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(jSONObject, jSONObject2, rVar);
        } else {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ux.1
                @Override // java.lang.Runnable
                public void run() {
                    ux.this.w(jSONObject, jSONObject2, rVar);
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
        if (r2.equals("openAppFunctionDesc") == false) goto L12;
     */
    @Override // com.bytedance.adsdk.ugeno.w.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.bytedance.adsdk.ugeno.w.h r2, com.bytedance.adsdk.ugeno.w.b.InterfaceC0363b r3, com.bytedance.adsdk.ugeno.w.b.a r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L7f
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            if (r3 != 0) goto L8
            goto L7f
        L8:
            int r3 = r2.g()
            r4 = 1
            if (r3 != r4) goto L7f
            org.json.JSONObject r2 = r2.i()
            if (r2 != 0) goto L16
            return
        L16:
            java.lang.String r3 = "type"
            java.lang.String r2 = r2.optString(r3)
            r2.hashCode()
            r3 = -1
            int r0 = r2.hashCode()
            switch(r0) {
                case -1822902106: goto L53;
                case -459025504: goto L4a;
                case -267096736: goto L3f;
                case 7917298: goto L34;
                case 1237425033: goto L29;
                default: goto L27;
            }
        L27:
            r4 = -1
            goto L5d
        L29:
            java.lang.String r4 = "openAppPolicy"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L32
            goto L27
        L32:
            r4 = 4
            goto L5d
        L34:
            java.lang.String r4 = "downloadEvent"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L3d
            goto L27
        L3d:
            r4 = 3
            goto L5d
        L3f:
            java.lang.String r4 = "closeDialog"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L48
            goto L27
        L48:
            r4 = 2
            goto L5d
        L4a:
            java.lang.String r0 = "openAppFunctionDesc"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5d
            goto L27
        L53:
            java.lang.String r4 = "openAppPermission"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L5c
            goto L27
        L5c:
            r4 = 0
        L5d:
            r2 = 0
            switch(r4) {
                case 0: goto L7a;
                case 1: goto L74;
                case 2: goto L6e;
                case 3: goto L68;
                case 4: goto L62;
                default: goto L61;
            }
        L61:
            goto L7f
        L62:
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            r3.sr(r2)
            goto L7f
        L68:
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            r3.c(r2)
            goto L7f
        L6e:
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            r3.xv(r2)
            goto L7f
        L74:
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            r3.ux(r2)
            goto L7f
        L7a:
            com.bytedance.sdk.openadsdk.core.widget.ux$c r3 = r1.xv
            r3.w(r2)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.ux.c(com.bytedance.adsdk.ugeno.w.h, com.bytedance.adsdk.ugeno.w.b$b, com.bytedance.adsdk.ugeno.w.b$a):void");
    }
}
