package com.qq.e.comm.plugin.c0;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.h0.i;
import com.qq.e.comm.plugin.h0.l;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.m0;
import com.qq.e.comm.plugin.util.p0;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.c.a implements ACTD {
    private ValueCallback<Uri[]> A;
    private ValueCallback<Uri> B;
    private String C;
    private e D;
    private final int E;
    private final boolean F;
    private final Runnable G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;

    /* renamed from: u  reason: collision with root package name */
    private Activity f42143u;

    /* renamed from: v  reason: collision with root package name */
    private long f42144v;

    /* renamed from: w  reason: collision with root package name */
    private long f42145w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f42146x;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.comm.plugin.c0.a f42147y;

    /* renamed from: z  reason: collision with root package name */
    private String f42148z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.e()) {
                return;
            }
            b.this.l();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.c0.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class View$OnClickListenerC0795b implements View.OnClickListener {
        View$OnClickListenerC0795b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.l();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((com.qq.e.comm.plugin.c.a) b.this).f42117e != null && ((com.qq.e.comm.plugin.c.a) b.this).f42117e.canGoBack()) {
                b.this.f42147y.b();
            } else {
                p0.a(this, 500L);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f42152a;

        d(WeakReference<b> weakReference) {
            this.f42152a = weakReference;
        }

        private void a(String str) {
            b bVar = this.f42152a.get();
            if (bVar == null) {
                return;
            }
            char c4 = '\uffff';
            int hashCode = str.hashCode();
            if (hashCode != 94756344) {
                if (hashCode == 1239801022 && str.equals("feedbackSuccess")) {
                    c4 = 1;
                }
            } else if (str.equals("close")) {
                c4 = 0;
            }
            if (c4 == 0) {
                bVar.onBackPressed();
            } else if (c4 != 1) {
            } else {
                bVar.m();
            }
        }

        @JavascriptInterface
        public void invoke(String str, Object obj, Object obj2) {
            d1.a("FeedbackJSBridge:" + str, new Object[0]);
            a(str);
        }
    }

    public b(Activity activity) {
        super(activity);
        this.G = new c();
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.f42143u = activity;
        int intExtra = activity.getIntent().getIntExtra("web_page_type", 0);
        this.E = intExtra;
        this.f42120h = intExtra == 2;
        this.f42115c = 1;
        this.F = com.qq.e.comm.plugin.d0.a.d().f().a("lpnaspl", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (b()) {
            this.f42143u.finish();
            a(2040005, this.f42125m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.qq.e.comm.plugin.fs.e.c.a().a(this.f42125m, 10016);
        v.a(1200100, this.f42119g, 0);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i4, int i5, Intent intent) {
        Uri data;
        if (1 == i4 && this.A != null) {
            this.A.onReceiveValue((i5 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.A = null;
        } else if (2 != i4 || this.B == null) {
        } else {
            this.B.onReceiveValue((i5 != -1 || intent == null) ? null : intent.getData());
            this.B = null;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        this.f42143u.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.f42143u);
        this.f42143u.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f42147y = new com.qq.e.comm.plugin.c0.a(this.f42143u);
        int applyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.f42143u.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, applyDimension);
        layoutParams.gravity = 48;
        this.f42147y.setLayoutParams(layoutParams);
        this.f42147y.setBackgroundColor(-1);
        String stringExtra = this.f42143u.getIntent().getStringExtra("objectId");
        this.C = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.D = ((com.qq.e.comm.plugin.d0.b.a) com.qq.e.comm.plugin.d0.b.e.a(this.C, com.qq.e.comm.plugin.d0.b.a.class)).a();
        }
        b(this.D);
        b(4003034);
        e eVar = this.D;
        if (eVar != null) {
            if (!TextUtils.isEmpty(eVar.J0())) {
                this.f42148z = this.D.J0();
            } else {
                this.f42148z = this.D.A();
            }
        } else {
            this.f42148z = "";
        }
        this.f42147y.a(new a());
        frameLayout.addView(this.f42147y);
        this.f42147y.b(new View$OnClickListenerC0795b());
        h a4 = a(this.f42143u, this.D);
        this.f42117e = a4;
        if (a4 == null) {
            return;
        }
        if (this.E == 1) {
            a4.addJavascriptInterface(new d(new WeakReference(this)), "TencentFeedbackJSBridge");
        }
        d(this.f42125m);
        m0.c(this.f42119g, this.D);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = applyDimension;
        this.f42117e.a().setLayoutParams(layoutParams2);
        frameLayout.addView(this.f42117e.a());
        m0.e(this.f42119g, this.D);
        p0.a(this.G, 500L);
        l.a().b(3).b("afterCreate", 2302301, this.f42119g);
        if (i.e()) {
            new com.qq.e.comm.plugin.h0.e(this.f42143u, 2302303).c();
        }
        e eVar2 = this.D;
        if (eVar2 == null || !this.f42120h) {
            return;
        }
        ((LPCallback) com.qq.e.comm.plugin.h.a.b(eVar2.l0(), LPCallback.class)).g().a();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        l();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        l.a().b(3).b("beforeCreate", 2302300, null);
        this.f42143u.requestWindowFeature(1);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.D;
        if (eVar != null && this.f42120h) {
            ((LPCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), LPCallback.class)).onClose().a();
        }
        com.qq.e.comm.plugin.i.b.a();
        if (!this.H && !this.K) {
            m0.a(this.f42119g, this.D);
        }
        p0.e(this.G);
        if (this.E == 1) {
            com.qq.e.comm.plugin.fs.e.c.a().a(this.f42125m);
        }
        if (!TextUtils.isEmpty(this.C)) {
            com.qq.e.comm.plugin.d0.b.e.b(this.C, com.qq.e.comm.plugin.d0.b.a.class);
        }
        l.a().a(3);
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.pi.ACTD
    public void onPause() {
        super.onPause();
        h hVar = this.f42117e;
        if (hVar != null) {
            hVar.onPause();
            this.f42146x = true;
        }
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.pi.ACTD
    public void onResume() {
        super.onResume();
        l.a().b(3).a("onResume", 2302302, this.f42119g);
        if (this.f42146x) {
            h hVar = this.f42117e;
            if (hVar != null) {
                hVar.onResume();
            }
            this.f42146x = false;
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
        super.a(str, bitmap);
        if (this.J) {
            return;
        }
        this.J = true;
        a(2040002, str);
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void b(String str) {
        super.b(str);
        d1.a("title:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            this.f42147y.a(this.f42148z);
        } else {
            this.f42147y.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void c(String str) {
        super.c(str);
        if (this.H) {
            return;
        }
        this.H = true;
        d1.a("PageFinished url=" + str, new Object[0]);
        this.f42144v = System.currentTimeMillis();
        d1.a("\u9875\u9762\u52a0\u8f7d\u5b8c\u6210\uff0c\u8017\u65f6\uff1a" + (this.f42144v - this.f42145w), new Object[0]);
        a(2040003, str);
        m0.d(this.f42119g, this.D);
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
        super.a(i4, str, str2);
        if (this.K) {
            return;
        }
        this.K = true;
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("url", str2);
        m0.a(this.f42119g, i4, dVar, this.D);
        b(2040004, str2, str);
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        super.b(valueCallback, intent);
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.A = valueCallback;
        this.f42143u.startActivityForResult(intent, 1);
        return true;
    }

    private void b(int i4, String str, String str2) {
        if (this.F) {
            m0.a(i4, this.f42118f, this.f42119g, str, str2);
        }
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(String str) {
        super.a(str);
        if (this.I) {
            return;
        }
        this.I = true;
        d1.a("302 to url:" + str, new Object[0]);
        this.f42145w = System.currentTimeMillis();
        d1.a("\u70b9\u51fb\u5230302\u8017\u65f6\uff1a" + (this.f42145w - this.f42118f), new Object[0]);
        a(2040001, str);
    }

    @Override // com.qq.e.comm.plugin.c.a, com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
        super.a(i4);
        if (i4 == 100) {
            this.f42147y.a();
        } else {
            this.f42147y.b(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.q0.j, com.qq.e.comm.plugin.q0.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        super.a(valueCallback, intent);
        if (valueCallback == null || intent == null) {
            return;
        }
        this.B = valueCallback;
        this.f42143u.startActivityForResult(intent, 2);
    }

    private void a(int i4, String str) {
        b(i4, str, null);
    }
}
