package com.bytedance.sdk.openadsdk.core.component.reward.xv;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ox;
import com.bytedance.sdk.openadsdk.core.ugeno.r.ux;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    protected c f32774a;
    protected AtomicBoolean bk;
    protected ox ev;

    /* renamed from: f  reason: collision with root package name */
    protected me f32775f;
    protected i gd;

    /* renamed from: k  reason: collision with root package name */
    protected String f32776k;

    /* renamed from: p  reason: collision with root package name */
    protected String f32777p;

    /* renamed from: r  reason: collision with root package name */
    protected Activity f32778r;

    /* renamed from: t  reason: collision with root package name */
    protected String f32779t;
    protected Map<String, Object> ys;

    public w(Activity activity, me meVar) {
        this.f32774a = new c(false, 0, "");
        this.bk = new AtomicBoolean(false);
        this.f32778r = activity;
        this.f32775f = meVar;
    }

    public c c(p pVar) {
        return new c(false, 0, "");
    }

    public abstract String c();

    protected float sr() {
        return 0.55f;
    }

    public void sr(String str) {
        this.f32777p = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String ux() {
        if (!TextUtils.isEmpty(this.f32779t)) {
            return this.f32779t;
        }
        return c();
    }

    public c w(p pVar) {
        return new c(false, 0, "");
    }

    public boolean w() {
        return true;
    }

    public int xv() {
        return 0;
    }

    public void xv(String str) {
        this.f32776k = str;
    }

    public void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.ys;
        if (map2 == null) {
            this.ys = map;
        } else {
            map2.putAll(map);
        }
    }

    protected void sr(p pVar) {
        if (pVar != null) {
            pVar.c();
        }
    }

    public void w(String str) {
        this.f32779t = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c xv(final p pVar) {
        if (!w()) {
            return new c(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.r rVar = new com.bytedance.sdk.openadsdk.core.widget.r(this.f32778r);
        c(rVar);
        final FrameLayout frameLayout = new FrameLayout(this.f32778r);
        rVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.w.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                i iVar = w.this.gd;
                if (iVar != null) {
                    iVar.d();
                    w.this.gd.g(null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.c();
        cVar.c(this.ev.sr());
        cVar.w(this.ev.ux());
        cVar.xv(this.ev.sr());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c(cVar, new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.w.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c
            public void c(JSONObject jSONObject) {
                if (w.this.bk.get()) {
                    return;
                }
                if (jSONObject == null) {
                    w.this.f32774a = new c(false, 0, "");
                    countDownLatch.countDown();
                    return;
                }
                w.this.c(rVar, frameLayout, pVar, jSONObject);
                w wVar = w.this;
                wVar.f32774a = new c(true, wVar.xv(), w.this.ev.sr(), rVar);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        this.bk.set(true);
        return this.f32774a;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private boolean f32787c;
        private Dialog sr;

        /* renamed from: w  reason: collision with root package name */
        private int f32788w;
        private String xv;

        public c(boolean z3, int i4, String str, Dialog dialog) {
            this.f32787c = z3;
            this.f32788w = i4;
            this.xv = str;
            this.sr = dialog;
        }

        public int c() {
            return this.f32788w;
        }

        public boolean sr() {
            Dialog dialog = this.sr;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void ux() {
            Dialog dialog = this.sr;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        public String w() {
            return this.xv;
        }

        public boolean xv() {
            return this.f32787c;
        }

        public c(boolean z3, int i4, String str) {
            this(z3, i4, str, null);
        }
    }

    public void c(final com.bytedance.sdk.openadsdk.core.widget.r rVar, final ViewGroup viewGroup, final p pVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(ux());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View c4 = c(jSONObject, jSONObject2, new b() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.w.3
            @Override // com.bytedance.adsdk.ugeno.w.b
            public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
                me meVar;
                JSONObject i4 = hVar.i();
                if (i4 == null) {
                    return;
                }
                String optString = i4.optString("type");
                JSONObject optJSONObject = jSONObject.optJSONObject("event_template");
                boolean optBoolean = i4.optBoolean("uchain", false);
                if (optJSONObject != null && optBoolean && (meVar = w.this.f32775f) != null && meVar.dd()) {
                    rVar.dismiss();
                    wv.gb();
                    com.bytedance.sdk.component.p.xv.w.INSTANCE.c(optJSONObject);
                    HashMap hashMap = new HashMap();
                    hashMap.put("reward_dialog_callback", pVar);
                    new w.c(optString).c(w.this.f32775f.mo()).c(hashMap).c().c();
                    return;
                }
                optString.hashCode();
                if (!optString.equals("exit_watch")) {
                    if (optString.equals("continue_watch")) {
                        rVar.dismiss();
                        w.this.sr(pVar);
                        return;
                    }
                    return;
                }
                rVar.dismiss();
                p pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.w();
                }
            }
        });
        if (c4 == null) {
            return;
        }
        this.f32778r.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xv.w.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(c4);
                w wVar = w.this;
                wVar.c(rVar, c4, wVar.sr());
                rVar.c(viewGroup);
                rVar.show();
            }
        });
    }

    public w(Activity activity, me meVar, ox oxVar) {
        this(activity, meVar);
        this.ev = oxVar;
    }

    protected void c(com.bytedance.sdk.openadsdk.core.widget.r rVar) {
        rVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public View c(JSONObject jSONObject, JSONObject jSONObject2, b bVar) {
        i iVar = new i(this.f32778r);
        this.gd = iVar;
        com.bytedance.adsdk.ugeno.component.b<View> c4 = iVar.c(jSONObject);
        this.gd.g(bVar);
        this.gd.k(jSONObject2);
        if (c4 == null) {
            return null;
        }
        return c4.gd();
    }

    public void c(Dialog dialog, View view, float f4) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.f32775f.fh() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = xk.ux(this.f32778r, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.f32775f.fh() == 2) {
            view.setScaleX(f4);
            view.setScaleY(f4);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) (view.getMeasuredWidth() * (1.0f - f4));
            layoutParams.topMargin = (int) Math.max(((xk.ux((Context) this.f32778r) - (view.getMeasuredHeight() * f4)) / 2.0f) - xk.k(this.f32778r), xk.k(this.f32778r));
            view.setLayoutParams(layoutParams);
        }
    }
}
