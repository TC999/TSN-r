package com.qq.e.comm.plugin.f0;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends Dialog implements ComponentCallbacks {

    /* renamed from: l  reason: collision with root package name */
    private static final String f43058l = b.class.getCanonicalName();

    /* renamed from: m  reason: collision with root package name */
    private static volatile long f43059m = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Context f43060c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43061d;

    /* renamed from: e  reason: collision with root package name */
    private final String f43062e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i.d0.c f43063f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f43064g;

    /* renamed from: h  reason: collision with root package name */
    private final q f43065h;

    /* renamed from: i  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f43066i;

    /* renamed from: j  reason: collision with root package name */
    private View f43067j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f43068k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements DialogInterface.OnDismissListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f43069c;

        a(com.qq.e.comm.plugin.i.d0.c cVar) {
            this.f43069c = cVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f43069c;
            if (cVar != null) {
                cVar.b(b.this.f43068k);
            }
            long unused = b.f43059m = 0L;
            if (b.this.f43065h != null) {
                b.this.f43065h.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Activity a4 = k.a(b.this.f43060c);
                if (a4 == null || k.a(a4)) {
                    b.this.dismiss();
                }
            } catch (Throwable th) {
                d1.a(b.f43058l, "tryDismiss Exception", th);
            }
        }
    }

    public b(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.i.d0.c cVar) {
        super(context);
        this.f43068k = false;
        this.f43060c = context;
        this.f43061d = eVar;
        String e4 = eVar.q().e();
        this.f43062e = e4;
        this.f43063f = cVar;
        com.qq.e.comm.plugin.n0.w.b.a(e4).f41951g = 9;
        this.f43064g = com.qq.e.comm.plugin.d0.a.d().c().x();
        q a4 = com.qq.e.comm.plugin.dl.i.a().a(this.f43060c, this.f43061d, this.f43064g ? 2 : 1);
        this.f43065h = a4;
        if (a4 != null) {
            this.f43067j = a4.j();
            this.f43066i = com.qq.e.comm.plugin.n0.c.a(eVar, this.f43065h.h());
        }
        setOnDismissListener(new a(cVar));
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        com.qq.e.comm.plugin.i.d0.c cVar = this.f43063f;
        if (cVar != null) {
            cVar.onCancel();
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f43062e, 1100959, this.f43066i);
        }
        b();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Window window = getWindow();
        window.getAttributes().width = -1;
        window.getAttributes().height = -1;
        window.getAttributes().gravity = 17;
        if (!((window.getAttributes().flags & 1024) == 1024) && !this.f43064g) {
            window.clearFlags(1024);
        } else {
            window.addFlags(1024);
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            decorView.setPadding(0, 0, 0, 0);
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (Build.VERSION.SDK_INT > 19) {
                if (this.f43064g) {
                    systemUiVisibility |= 4;
                }
                systemUiVisibility = systemUiVisibility | 2 | 4096;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
        setCanceledOnTouchOutside(false);
        getContext().registerComponentCallbacks(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setContentView(this.f43067j, layoutParams);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        this.f43065h.a(new C0818b(this.f43065h, this.f43061d));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterComponentCallbacks(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f43067j == null) {
            com.qq.e.comm.plugin.i.d0.c cVar = this.f43063f;
            if (cVar != null) {
                cVar.a(false);
            }
        } else if (f43059m == 0 || System.currentTimeMillis() - f43059m >= 1000) {
            f43059m = System.currentTimeMillis();
            super.show();
            com.qq.e.comm.plugin.i.d0.c cVar2 = this.f43063f;
            if (cVar2 != null) {
                cVar2.a(true);
                com.qq.e.comm.plugin.apkmanager.x.d.a(this.f43062e, 1100957, this.f43066i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        p0.a((Runnable) new c());
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.f0.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0818b extends r {
        C0818b(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void b() {
            this.f42589g.add(new r.c(com.qq.e.comm.plugin.dl.c.b(a((com.qq.e.dl.l.j.c) null))));
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void c(com.qq.e.dl.l.j.c cVar) {
            super.c(cVar);
            b.this.f43068k = true;
            if (b.this.f43063f != null) {
                b.this.f43063f.onCancel();
                com.qq.e.comm.plugin.apkmanager.x.d.a(b.this.f43062e, 1100959, b.this.f43066i);
            }
            b.this.b();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void b(com.qq.e.dl.l.j.c cVar) {
            super.b(cVar);
            b.this.f43068k = true;
            if (b.this.f43063f != null) {
                boolean onConfirm = b.this.f43063f.onConfirm();
                com.qq.e.comm.plugin.apkmanager.x.d.a(b.this.f43062e, 1100958, b.this.f43066i);
                if (onConfirm) {
                    b.this.b();
                }
            }
        }
    }
}
