package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.dislike.ui.c;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p.xv.xv;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.f;
import com.bytedance.sdk.openadsdk.core.ugeno.gd.sr;
import com.bytedance.sdk.openadsdk.core.ugeno.gd.w;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTNativePageActivity extends Activity implements n.c {

    /* renamed from: w  reason: collision with root package name */
    private static WeakReference<xv> f31871w;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f31872a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    c f31873c;
    private int ck;
    private TTViewStub ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f31874f;
    private ux fp;
    private FrameLayout fz;
    private boolean gb;
    private TTViewStub gd;

    /* renamed from: i  reason: collision with root package name */
    private w f31875i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31876j;

    /* renamed from: k  reason: collision with root package name */
    private TTViewStub f31877k;
    private FrameLayout ls;

    /* renamed from: n  reason: collision with root package name */
    private boolean f31878n;

    /* renamed from: p  reason: collision with root package name */
    private TTViewStub f31879p;

    /* renamed from: q  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.xv.c f31880q;

    /* renamed from: r  reason: collision with root package name */
    private Context f31881r;

    /* renamed from: s  reason: collision with root package name */
    private Activity f31882s;
    private ImageView sr;

    /* renamed from: t  reason: collision with root package name */
    private String f31883t;

    /* renamed from: u  reason: collision with root package name */
    private sr f31884u;
    private TextView ux;
    private ImageView xv;

    /* renamed from: y  reason: collision with root package name */
    private long f31885y;
    private me ys;

    /* renamed from: z  reason: collision with root package name */
    private int f31886z;
    private AtomicBoolean ia = new AtomicBoolean(true);
    private boolean ba = true;
    private final n eq = new n(Looper.getMainLooper(), this);
    private String me = "\u7acb\u5373\u4e0b\u8f7d";

    static {
        StubApp.interface11(17843);
    }

    private boolean a() {
        return me.xv(this.ys);
    }

    private void bk() {
        this.ck = 0;
        if (this.gb) {
            this.ck = com.bytedance.sdk.openadsdk.core.r.xv.f34517c;
        } else if (this.f31878n && !com.bytedance.sdk.openadsdk.core.r.xv.sr) {
            this.ck = m.t(this.ys);
        }
        xv(this.ck);
        if (this.ck > 0 && !this.eq.hasMessages(10)) {
            if (this.gb) {
                this.eq.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.f31878n) {
                this.eq.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.w.c ev() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.multipro.w.c.c(new JSONObject(stringExtra));
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void f() {
        this.f31878n = m.fz(this.ys);
        boolean s3 = m.s(this.ys);
        this.gb = s3;
        if (this.f31878n) {
            if (!com.bytedance.sdk.openadsdk.core.r.xv.sr) {
                this.gb = false;
            } else if (s3) {
                this.f31878n = false;
            }
        }
    }

    private void gd() {
        com.bytedance.sdk.openadsdk.core.ugeno.f.c ys = this.ys.ys();
        if (ys == null) {
            return;
        }
        int sr = ys.sr();
        if (sr == 2) {
            sr srVar = new sr(this.f31881r, this.fz, this.fp, this.ys, this.f31883t, this.bk);
            this.f31884u = srVar;
            srVar.a();
        } else if (sr == 3) {
            w wVar = new w(this.f31881r, this.fz, this.fp, this.ys, this.f31883t, this.bk);
            this.f31875i = wVar;
            wVar.w(false);
            this.f31875i.a();
            if (TextUtils.equals(ys.c(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.f31881r);
            float xv = xk.xv(this.f31881r, 18.0f);
            float xv2 = xk.xv(this.f31881r, 18.0f);
            int i4 = (int) xv;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
            layoutParams.gravity = 53;
            int i5 = (int) xv2;
            layoutParams.setMargins(i5, i5, i5, i5);
            this.ls.addView(imageView, layoutParams);
            imageView.setImageDrawable(i.xv(this.f31881r, "tt_unmute"));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity tTNativePageActivity = TTNativePageActivity.this;
                    tTNativePageActivity.f31876j = !tTNativePageActivity.f31876j;
                    imageView.setImageDrawable(TTNativePageActivity.this.f31876j ? i.xv(TTNativePageActivity.this.f31881r, "tt_mute") : i.xv(TTNativePageActivity.this.f31881r, "tt_unmute"));
                    TTNativePageActivity.this.f31875i.xv(TTNativePageActivity.this.f31876j);
                }
            });
        }
    }

    private boolean k() {
        return this.gb || this.f31878n;
    }

    private void p() {
        TTViewStub tTViewStub;
        this.ls = (FrameLayout) findViewById(2114387633);
        this.fz = (FrameLayout) findViewById(2114387719);
        this.f31877k = (TTViewStub) findViewById(2114387956);
        this.ev = (TTViewStub) findViewById(2114387772);
        this.gd = (TTViewStub) findViewById(2114387794);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387939);
        this.f31879p = tTViewStub2;
        if (!this.gb && !this.f31878n) {
            int ys = k.sr().ys();
            if (ys == 0) {
                TTViewStub tTViewStub3 = this.ev;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (ys == 1 && (tTViewStub = this.gd) != null) {
                tTViewStub.setVisibility(0);
            }
        } else {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.f31872a = (ImageView) findViewById(2114387846);
        }
        ImageView imageView = (ImageView) findViewById(2114387704);
        this.xv = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387703);
        this.sr = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.ux = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387626);
        this.f31874f = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.c();
                }
            });
        }
    }

    private void r() {
        if (f.ev(this.ys)) {
            com.bytedance.sdk.openadsdk.core.ugeno.xv.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.xv.c(this, this.fz, this.fp, this.ys, this.f31883t, this.bk, ev());
            this.f31880q = cVar;
            cVar.c(new com.bytedance.sdk.openadsdk.core.ugeno.sr.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
                public void c(int i4) {
                    TTNativePageActivity.this.c(i4);
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
                public void c(View view) {
                }
            });
            this.f31880q.c();
            return;
        }
        gd();
    }

    private void ux() {
        me meVar = this.ys;
        if (meVar == null || meVar.ys() == null || this.ys.ys().sr() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.sr.c().c(this.ys);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.xv.c cVar = this.f31880q;
        if (cVar != null) {
            cVar.sr();
        }
        w wVar = this.f31875i;
        if (wVar != null) {
            wVar.ys();
        }
        ux uxVar = this.fp;
        if (uxVar != null) {
            uxVar.sr();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.ugeno.xv.c cVar = this.f31880q;
        if (cVar != null) {
            cVar.w();
        }
        xv();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ux uxVar = this.fp;
        if (uxVar != null) {
            uxVar.xv();
        }
        sr();
        com.bytedance.sdk.openadsdk.core.ugeno.xv.c cVar = this.f31880q;
        if (cVar != null) {
            cVar.xv();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ux uxVar = this.fp;
        if (uxVar != null) {
            uxVar.c(0);
        }
        if (this.ba) {
            this.ba = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, this.f31885y);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c(this.ys, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    public void sr() {
        if (!k() || this.eq.hasMessages(10)) {
            return;
        }
        this.eq.sendEmptyMessageDelayed(10, 1000L);
    }

    private void w(int i4) {
        if (a()) {
            xk.c((View) this.sr, 4);
        } else if (this.sr == null || !a()) {
        } else {
            xk.c((View) this.sr, i4);
        }
    }

    private void xv(int i4) {
        if (i4 > 0) {
            if (this.gb) {
                TextView textView = this.ux;
                xk.c(textView, i4 + "s\u540e\u53ef\u9886\u53d6\u5956\u52b1");
            } else if (this.f31878n) {
                SpannableString spannableString = new SpannableString("\u6d4f\u89c8 " + i4 + "\u79d2 \u83b7\u5f97\u66f4\u591a\u798f\u5229");
                spannableString.setSpan(new ForegroundColorSpan(-65536), spannableString.length() + (-4), spannableString.length(), 17);
                xk.c(this.ux, spannableString);
            }
        } else if (this.gb) {
            xk.c(this.ux, "\u9886\u53d6\u6210\u529f");
        } else if (this.f31878n) {
            xk.c((View) this.f31872a, 8);
            xk.c(this.ux, "\u606d\u559c\u4f60\uff01\u798f\u5229\u5df2\u9886\u53d6");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        Intent intent;
        WeakReference<xv> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = f31871w) != null && weakReference.get() != null) {
            f31871w.get().ux(false);
            f31871w.get().c(me.ux(this.ys));
            f31871w = null;
        } else {
            if (me.w(this.ys) && wv.xv(this.ys)) {
                intent = new Intent(this, TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.w.c(this.f31882s, intent, null);
            } catch (Throwable th) {
                a.xv("TTNativePageActivity", th);
            }
        }
        finish();
    }

    void w() {
        c cVar = new c(this.f31882s, this.ys.ve(), this.f31883t, true);
        this.f31873c = cVar;
        com.bytedance.sdk.openadsdk.core.dislike.xv.c(this.f31882s, cVar, this.ys);
        this.f31873c.c(new c.InterfaceC0490c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c() {
                TTNativePageActivity.this.xv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void w() {
                TTNativePageActivity.this.sr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.c.InterfaceC0490c
            public void c(int i4, String str, boolean z3) {
                TTNativePageActivity.this.sr();
            }
        });
    }

    public void xv() {
        if (k()) {
            this.eq.removeMessages(10);
        }
    }

    protected void c() {
        if (this.ys == null || isFinishing()) {
            return;
        }
        if (this.f31873c == null) {
            w();
        }
        this.f31873c.c();
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 10 && k()) {
            int i4 = this.f31886z + 1;
            this.f31886z = i4;
            if (this.gb) {
                com.bytedance.sdk.openadsdk.core.r.xv.f34518w = i4;
            }
            int max = Math.max(0, this.ck - i4);
            xv(max);
            if (max <= 0 && this.f31878n) {
                com.bytedance.sdk.openadsdk.core.r.xv.sr = true;
            }
            this.eq.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public static void c(xv xvVar) {
        f31871w = new WeakReference<>(xvVar);
    }
}
