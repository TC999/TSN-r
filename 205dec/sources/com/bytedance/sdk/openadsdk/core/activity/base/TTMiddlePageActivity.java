package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTMiddlePageActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f31866c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31867f = false;

    /* renamed from: r  reason: collision with root package name */
    private Activity f31868r;
    private w sr;
    private com.bytedance.sdk.openadsdk.core.w.w ux;

    /* renamed from: w  reason: collision with root package name */
    private ys f31869w;
    private me xv;

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 extends com.bytedance.sdk.openadsdk.ls.c.w.c.w {
        AnonymousClass1(Bridge bridge) {
            super(bridge);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
        public void onAdClicked(View view, int i4) {
        }

        @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
        public void onAdShow(View view, int i4) {
        }

        @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
        public void onRenderFail(View view, String str, int i4) {
            if (TTMiddlePageActivity.this.f31867f) {
                return;
            }
            if (TTMiddlePageActivity.this.xv != null && TTMiddlePageActivity.this.xv.xw() == 1 && TTMiddlePageActivity.this.ux != null) {
                TTMiddlePageActivity.this.f31867f = true;
                com.bytedance.sdk.openadsdk.core.w.c.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.c.w) TTMiddlePageActivity.this.ux.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class);
                if (wVar != null) {
                    wVar.xv().w();
                }
            }
            TTMiddlePageActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.ls.c.w.c.w
        public void onRenderSuccess(View view, float f4, float f5) {
            if (TTMiddlePageActivity.this.isFinishing() || TTMiddlePageActivity.this.xv == null) {
                return;
            }
            xv.w(TTMiddlePageActivity.this.xv, "feed_video_middle_page", "middle_page_show");
        }
    }

    static {
        StubApp.interface11(17835);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ys ysVar = this.f31869w;
        if (ysVar != null) {
            ysVar.ux();
            this.f31869w = null;
        }
        if (this.xv != null) {
            this.xv = null;
        }
    }

    private w w(me meVar) {
        Activity activity;
        if (meVar == null || meVar.cf() == null) {
            return null;
        }
        String str = wv.gd(meVar) + "";
        float sr = xk.sr(this.f31868r, xk.sr((Context) activity));
        float f4 = 0.0f;
        try {
            f4 = xk.k(StubApp.getOrigApplicationContext(getApplicationContext()));
        } catch (Throwable unused) {
        }
        int q3 = meVar.oo() != null ? meVar.oo().q() : 0;
        Activity activity2 = this.f31868r;
        return n.c(q3, str, sr, xk.sr(activity2, xk.ux((Context) activity2) - f4));
    }

    public static boolean c(Context context, me meVar) {
        if (meVar != null && context != null) {
            boolean z3 = meVar.xw() == 1;
            me.c qy = meVar.qy();
            if (z3 && qy != null) {
                String jSONObject = meVar.mo().toString();
                Intent intent = new Intent(context, TTMiddlePageActivity.class);
                intent.putExtra("middle_page_material_meta", jSONObject);
                com.bytedance.sdk.component.utils.w.c(context, intent, null);
                return true;
            }
        }
        return false;
    }

    public static boolean c(me meVar) {
        if (meVar == null) {
            return false;
        }
        return (meVar.xw() == 2) && meVar.qy() != null;
    }

    public static boolean w(Context context, me meVar) {
        if (context != null && c(meVar)) {
            String jSONObject = meVar.mo().toString();
            Intent intent = new Intent(context, TTMiddlePageActivity.class);
            intent.putExtra("middle_page_material_meta", jSONObject);
            com.bytedance.sdk.component.utils.w.c(context, intent, null);
            return true;
        }
        return false;
    }
}
