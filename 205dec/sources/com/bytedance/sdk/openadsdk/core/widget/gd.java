package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.ev;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f35424c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.c f35425f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.r.r f35426r;
    private ev.c sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private JSONObject f35427w;
    private Context xv;

    public gd(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.r.r rVar, me meVar) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35426r = rVar;
        this.xv = context;
        this.f35424c = jSONObject;
        this.ux = str;
        this.f35427w = jSONObject2;
        this.f35425f = new com.bytedance.sdk.openadsdk.core.ugeno.c(context, meVar);
    }

    private void w() {
        if (this.f35424c == null || this.f35427w == null || this.f35425f == null) {
            return;
        }
        this.ev = false;
        final FrameLayout frameLayout = new FrameLayout(this.xv);
        this.f35425f.c(this.f35424c, this.f35427w, new com.bytedance.sdk.openadsdk.core.ugeno.r.r() { // from class: com.bytedance.sdk.openadsdk.core.widget.gd.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str) {
                gd.this.ev = true;
                if (gd.this.f35426r != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    gd.this.f35426r.c(i4, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                gd.this.ev = false;
                if (gd.this.f35426r != null) {
                    gd.this.f35426r.c(null);
                }
                frameLayout.addView(bVar.gd(), new FrameLayout.LayoutParams(bVar.fp(), bVar.ia()));
                gd.this.setContentView(frameLayout);
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ev.c cVar = this.sr;
        if (cVar != null) {
            cVar.xv(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.ev) {
            hide();
            dismiss();
        }
    }

    public String c() {
        return this.ux;
    }

    public void c(ev.c cVar) {
        this.sr = cVar;
        com.bytedance.sdk.openadsdk.core.ugeno.c cVar2 = this.f35425f;
        if (cVar2 != null) {
            cVar2.c(cVar);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.r.r rVar) {
        this.f35426r = rVar;
    }
}
