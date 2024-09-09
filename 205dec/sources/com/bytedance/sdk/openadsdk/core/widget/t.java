package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.widget.ux;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t extends ux {
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.ux f35477f;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f35478r;
    private com.bytedance.sdk.openadsdk.core.ugeno.r.r sr;
    private JSONObject ux;
    Window xv;

    public t(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.r.r rVar) {
        super(activity);
        this.xv = activity == null ? null : activity.getWindow();
        this.ux = jSONObject;
        this.sr = rVar;
        this.f35477f = new com.bytedance.sdk.openadsdk.core.ugeno.ux(activity);
    }

    private void f() {
        JSONObject jSONObject = this.ux;
        if (jSONObject == null || this.sr == null) {
            return;
        }
        JSONObject w3 = com.bytedance.sdk.openadsdk.core.ugeno.f.w(this.ux.remove("ugen_md5").toString(), jSONObject.remove("ugen_url").toString());
        if (w3 == null) {
            this.sr.c(11, "uegnTemplate is empty");
            this.f35478r = true;
            return;
        }
        final FrameLayout frameLayout = new FrameLayout(this.f35482c);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f35477f.c(w3, this.ux, new com.bytedance.sdk.openadsdk.core.ugeno.r.r() { // from class: com.bytedance.sdk.openadsdk.core.widget.t.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str) {
                t.this.f35478r = true;
                if (t.this.sr != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    t.this.sr.c(i4, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                t.this.f35478r = false;
                if (t.this.sr != null) {
                    t.this.sr.c(null);
                }
                frameLayout.addView(bVar.gd(), new FrameLayout.LayoutParams(bVar.fp(), bVar.ia()));
                t.this.setContentView(frameLayout);
            }
        });
    }

    private void r() {
        JSONObject jSONObject = this.ux;
        if (jSONObject == null) {
            return;
        }
        c(jSONObject.optString("app_name"));
        ux(this.ux.optString("app_version"));
        w(this.ux.optString(CampaignEx.JSON_KEY_ICON_URL));
        f(this.ux.optString("developer_name"));
        c(this.ux.optInt("score"));
        c(this.ux.optJSONArray("creative_tags"));
        sr(this.ux.optString("description"));
    }

    private void ux() {
        if (this.xv != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.xv.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.xv.getAttributes();
            attributes.alpha = 1.0f;
            this.xv.setAttributes(attributes);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ux, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ux, android.app.Dialog
    public void show() {
        super.show();
        if (this.f35478r) {
            hide();
            dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ux
    protected void w() {
    }

    public void w(ux.c cVar) {
        super.c(cVar);
        com.bytedance.sdk.openadsdk.core.ugeno.ux uxVar = this.f35477f;
        if (uxVar != null) {
            uxVar.c(cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ux
    protected void xv() {
        if (this.ev) {
            super.xv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ux
    public void c() {
        if (this.f35482c == null) {
            this.f35482c = ls.getContext();
        }
        if (this.f35482c.getResources().getConfiguration().orientation != 1) {
            this.ev = true;
            super.c();
            super.w();
            r();
            return;
        }
        ux();
        f();
    }
}
