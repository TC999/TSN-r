package com.qq.e.comm.plugin.fs.f.e.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.fs.f.e.d.g;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.b0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n0;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends LinearLayout implements f, g.a {

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.c0.a f43449c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.h f43450d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.fs.f.e.d.a f43451e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43452f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43453g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f43454h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f43455i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f43456j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f43457k;

    /* renamed from: l  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.d f43458l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f43459m;

    /* renamed from: n  reason: collision with root package name */
    private final Runnable f43460n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f43450d.canGoBack()) {
                h.this.f43450d.goBack();
            } else if (h.this.f43451e != null) {
                h.this.f43451e.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f43451e != null) {
                h.this.f43451e.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements com.qq.e.comm.plugin.q0.f {
        c() {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(int i4, String str, String str2) {
            h.this.f43458l.a("wu", str2);
            v.b(1020052, com.qq.e.comm.plugin.n0.c.a(h.this.f43452f), Integer.valueOf(i4), h.this.f43458l);
            b0.a(com.qq.e.comm.plugin.n0.c.a(h.this.f43452f), 3, i4, h.this.f43458l);
            if (h.this.f43455i == null) {
                h.this.f43455i = Boolean.FALSE;
                if (h.this.f43454h) {
                    h.this.a();
                }
            }
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(ValueCallback<Uri> valueCallback, Intent intent) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void a(String str, Bitmap bitmap) {
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void b(String str) {
            if (h.this.f43449c != null) {
                h.this.f43449c.a(str);
            }
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
            return false;
        }

        @Override // com.qq.e.comm.plugin.q0.f
        public void c(String str) {
            h.this.f43458l.a("wu", str);
            v.a(1020051, com.qq.e.comm.plugin.n0.c.a(h.this.f43452f));
            if (h.this.f43455i == null) {
                b0.d(com.qq.e.comm.plugin.n0.c.a(h.this.f43452f), 3);
                h.this.f43455i = Boolean.TRUE;
                if (h.this.f43454h) {
                    h.this.d();
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f43450d.canGoBack()) {
                h.this.f43449c.b();
            } else {
                p0.a(this, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        super(context);
        this.f43460n = new d();
        setBackgroundColor(-16777216);
        this.f43452f = eVar;
        this.f43458l = new com.qq.e.comm.plugin.n0.d();
        this.f43459m = com.qq.e.comm.plugin.d0.a.d().f().a("dwajwl", this.f43452f.q0(), 0) == 1;
        a(eVar);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.g.a
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void onDestroy() {
        com.qq.e.comm.plugin.q0.h hVar = this.f43450d;
        if (hVar != null) {
            hVar.e();
        }
        com.qq.e.comm.plugin.e.a.a().b(this);
        if (this.f43455i == null) {
            b0.a(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3);
        }
        if (this.f43453g && !this.f43454h) {
            b0.e(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3);
        }
        p0.e(this.f43460n);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void show() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f43456j) {
            return;
        }
        b0.f(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3);
        this.f43456j = true;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void c() {
        setVisibility(8);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void e() {
        com.qq.e.comm.plugin.fs.f.e.d.a aVar = this.f43451e;
        if (aVar != null) {
            aVar.c();
        }
        show();
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        setOrientation(1);
        this.f43449c = new com.qq.e.comm.plugin.c0.a(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f1.a(getContext(), 45));
        layoutParams.gravity = 48;
        this.f43449c.setLayoutParams(layoutParams);
        this.f43449c.setBackgroundColor(-1);
        this.f43449c.a(new a());
        this.f43449c.b(new b());
        addView(this.f43449c);
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(getContext(), eVar).a();
        this.f43450d = a4;
        a4.a(new c());
        this.f43450d.f(this.f43459m);
        g gVar = new g(this.f43452f, this.f43450d);
        gVar.a(this);
        this.f43450d.a().setOnTouchListener(gVar);
        addView(this.f43450d.a(), new RelativeLayout.LayoutParams(-1, -1));
        z.b(this, 0);
        com.qq.e.comm.plugin.e.a.a().a(this, this.f43452f);
        p0.a(this.f43460n, 500L);
    }

    public void a(boolean z3) {
        this.f43454h = true;
        setVisibility(0);
        this.f43449c.setVisibility(z3 ? 0 : 8);
        com.qq.e.comm.plugin.fs.f.e.d.a aVar = this.f43451e;
        if (aVar != null) {
            aVar.d();
        }
        b0.b(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3);
        if (Boolean.TRUE.equals(this.f43455i)) {
            d();
        } else if (Boolean.FALSE.equals(this.f43455i)) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f43456j) {
            return;
        }
        b0.b(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3, 9001, this.f43458l);
        this.f43456j = true;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void a(com.qq.e.comm.plugin.fs.f.e.d.a aVar) {
        this.f43451e = aVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            d1.a("LandingPageView", "load url is null");
            return;
        }
        if (n0.a(this.f43452f.q0(), this.f43452f.G())) {
            str = n0.a(str, "2");
        }
        String a4 = n0.a(str, this.f43452f, false);
        com.qq.e.comm.plugin.q0.h hVar = this.f43450d;
        if (hVar == null || this.f43457k) {
            return;
        }
        hVar.loadUrl(a4);
        this.f43457k = true;
        b0.c(com.qq.e.comm.plugin.n0.c.a(this.f43452f), 3);
    }

    @Override // com.qq.e.comm.plugin.fs.f.d.a
    public boolean a(f.t tVar, long j4, long j5) {
        com.qq.e.comm.plugin.g0.e eVar = this.f43452f;
        if (eVar instanceof u) {
            if (!this.f43453g) {
                a(((u) eVar).a());
                this.f43453g = true;
            }
            if (tVar == f.t.STOP || tVar == f.t.ERROR || tVar == f.t.END) {
                d1.a("LandingPageView", "show");
                show();
            }
            return true;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.g.a
    public void a(com.qq.e.comm.plugin.i.f fVar) {
        v.a(1020050, com.qq.e.comm.plugin.n0.c.a(this.f43452f));
        v.a(1403017, com.qq.e.comm.plugin.n0.c.a(this.f43452f));
        com.qq.e.comm.plugin.fs.f.e.d.a aVar = this.f43451e;
        if (aVar != null) {
            fVar.f44107d = false;
            aVar.a(fVar, true);
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.f
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
