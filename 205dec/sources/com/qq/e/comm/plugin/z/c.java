package com.qq.e.comm.plugin.z;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.b.l;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.gdtnativead.m;
import com.qq.e.comm.plugin.u.j;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.i0;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.r1;
import com.qq.e.comm.plugin.util.x0;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends j implements com.qq.e.comm.plugin.intersitial2.d, DialogInterface.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    protected final Object f46798h;

    /* renamed from: i  reason: collision with root package name */
    protected com.qq.e.comm.plugin.z.a f46799i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f46800j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f46801k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f46802l;

    /* renamed from: m  reason: collision with root package name */
    protected Dialog f46803m;

    /* renamed from: n  reason: collision with root package name */
    protected int f46804n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f46805o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f46806p;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f46807q;

    /* renamed from: r  reason: collision with root package name */
    private String f46808r;

    /* renamed from: s  reason: collision with root package name */
    protected x0 f46809s;

    /* renamed from: t  reason: collision with root package name */
    private int f46810t;

    /* renamed from: u  reason: collision with root package name */
    private int f46811u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements DialogInterface.OnKeyListener {
        a(c cVar) {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
            return i4 == 4 && keyEvent.getAction() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements ADListener {
        b() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 103) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(103, new Object[0]));
            } else if (type == 210) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(210, Integer.valueOf(c.this.getVideoDuration())));
            } else if (type == 1005) {
                if (c.this.f46799i == null) {
                    return;
                }
                Point point = new Point(c.this.f46799i.b().o0(), c.this.f46799i.b().n0());
                c cVar = c.this;
                cVar.a(point, cVar.f46799i);
                c cVar2 = c.this;
                cVar2.f46801k = true;
                Dialog dialog = cVar2.f46803m;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = c.this.f46799i.e().getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                }
                c.this.f46803m.getWindow().getAttributes().width = -2;
                c.this.f46803m.getWindow().getAttributes().height = -2;
            } else if (type == 105) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(105, new Object[0]));
            } else if (type == 106) {
                c.this.close();
            } else if (type == 109) {
                c cVar3 = c.this;
                cVar3.f46802l = false;
                cVar3.b(109);
                c cVar4 = c.this;
                cVar4.f46806p = true;
                if (cVar4.i()) {
                    c.this.b(209);
                }
                c.this.c();
            } else if (type == 110) {
                if (c.this.hasShown()) {
                    c.this.close();
                }
                c.this.b(110);
            } else if (type == 301) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(301, new Object[0]));
            } else if (type == 302) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(302, new Object[0]));
            } else {
                switch (type) {
                    case 201:
                        c cVar5 = c.this;
                        cVar5.f46807q = true;
                        cVar5.c();
                        return;
                    case 202:
                    case 203:
                        ((j) c.this).f46299e.onADEvent(new ADEvent(202, new Object[0]));
                        return;
                    case 204:
                    case 205:
                        ((j) c.this).f46299e.onADEvent(new ADEvent(204, new Object[0]));
                        return;
                    case 206:
                        ((j) c.this).f46299e.onADEvent(new ADEvent(206, new Object[0]));
                        return;
                    case 207:
                        c.this.a(5002);
                        ((j) c.this).f46299e.onADEvent(new ADEvent(207, 5002));
                        return;
                    default:
                        ((j) c.this).f46299e.onADEvent(aDEvent);
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.z.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0912c extends r1 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f46813d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object[] f46814e;

        C0912c(int i4, Object[] objArr) {
            this.f46813d = i4;
            this.f46814e = objArr;
        }

        @Override // com.qq.e.comm.plugin.util.r1
        public void b() {
            if (((j) c.this).f46299e != null) {
                ((j) c.this).f46299e.onADEvent(new ADEvent(this.f46813d, this.f46814e));
            }
        }
    }

    public c(Context context, String str, String str2, String str3, ADListener aDListener) {
        this(context, str, str2, l.f42027d, aDListener);
        this.f46808r = str3;
    }

    @Override // com.qq.e.comm.plugin.intersitial2.d
    public void close() {
        Dialog dialog = this.f46803m;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void destroy() {
        close();
        b();
        this.f46800j = true;
    }

    public int getAdPatternType() {
        return i() ? 2 : 0;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar != null) {
            return aVar.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionFailureUrls() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        return aVar != null ? aVar.getCompetitionFailureUrls() : new String[0];
    }

    @Override // com.qq.e.comm.plugin.e0.a
    public String[] getCompetitionWinUrls() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        return aVar != null ? aVar.getCompetitionWinUrls() : new String[0];
    }

    public int getVideoDuration() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar != null) {
            return aVar.getVideoDuration();
        }
        return 0;
    }

    protected boolean hasShown() {
        return this.f46802l;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        b();
        this.f46809s.b();
        b(106);
    }

    @Override // com.qq.e.comm.plugin.intersitial2.d
    public boolean r() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar != null) {
            return aVar.r();
        }
        return false;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar != null) {
            aVar.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void show(Activity activity) {
        Dialog dialog;
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar == null || aVar.e() == null) {
            GDTLogger.w("\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0c\u8bf7\u5728\u5e7f\u544a\u52a0\u8f7d\u6210\u529f\u4e4b\u540e\u8c03\u7528");
        } else if (activity == null) {
            GDTLogger.e("\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0cactivity\u53c2\u6570\u4e3a\u7a7a");
        } else if (activity.getWindow() == null) {
            GDTLogger.e("\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0cActivity\u7684Window\u4e3a\u7a7a");
        } else {
            i0.a(this.f46301g);
            if (!this.f46802l && (((dialog = this.f46803m) == null || !dialog.isShowing()) && this.f46799i.e().getParent() == null)) {
                if (this.f46799i.r()) {
                    i0.a(this.f46301g, 5012);
                    return;
                } else {
                    a(this.f46799i, activity);
                    return;
                }
            }
            GDTLogger.e("\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0c\u540c\u4e00\u6761\u5e7f\u544a\u4e0d\u5141\u8bb8\u591a\u6b21\u5c55\u793a\uff0c\u8bf7\u518d\u6b21\u62c9\u53d6\u540e\u5c55\u793a");
            i0.a(this.f46301g, 4015);
        }
    }

    private Point g() {
        Display defaultDisplay;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) this.f46297c.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    @Override // com.qq.e.comm.plugin.u.j
    protected g a() {
        return g.UNIFIED_INTERSTITIAL;
    }

    protected void b() {
        synchronized (this.f46798h) {
            if (this.f46799i != null) {
                this.f46799i.setAdListener(null);
                this.f46799i.destroy();
                this.f46799i = null;
                this.f46806p = false;
                this.f46807q = false;
            }
        }
    }

    protected void c() {
        if (this.f46806p && this.f46807q) {
            this.f46299e.onADEvent(new ADEvent(201, new Object[0]));
        }
    }

    protected boolean h() {
        return com.qq.e.comm.plugin.d0.a.d().c().x();
    }

    protected boolean i() {
        com.qq.e.comm.plugin.z.a aVar = this.f46799i;
        if (aVar != null) {
            return aVar.h();
        }
        return false;
    }

    protected boolean j() {
        q b4 = this.f46799i.b();
        if (b4 == null) {
            a(5004);
            return false;
        } else if (a(new Point(b4.I0(), b4.F0()), this.f46799i)) {
            boolean h4 = h();
            this.f46805o = h4;
            a(b4, h4, true);
            this.f46799i.render();
            return true;
        } else {
            return false;
        }
    }

    c(Context context, String str, String str2, l lVar, ADListener aDListener) {
        super(context, str, str2, lVar, aDListener);
        this.f46798h = new Object();
        this.f46809s = new x0();
    }

    protected void a(com.qq.e.comm.plugin.u.a aVar, Activity activity) {
        View decorView;
        if (k.a(activity)) {
            boolean z3 = (activity.getWindow().getAttributes().flags & 1024) == 1024;
            Dialog dialog = new Dialog(activity);
            this.f46803m = dialog;
            dialog.setOwnerActivity(activity);
            a(aVar, z3, activity);
            this.f46803m.setOnDismissListener(this);
            this.f46803m.setCanceledOnTouchOutside(false);
            if (this.f46803m.requestWindowFeature(0)) {
                this.f46803m.setFeatureDrawableAlpha(0, 0);
            }
            this.f46803m.setOnKeyListener(new a(this));
            this.f46803m.requestWindowFeature(1);
            Window window = this.f46803m.getWindow();
            if (window == null) {
                GDTLogger.e("\u663e\u793aDialog\u5931\u8d25\uff0cWindow\u4e3a\u7a7a");
                i0.a(this.f46301g, 9002);
                return;
            }
            window.addFlags(2);
            window.clearFlags(32);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (aVar.h() && d.c()) {
                window.addFlags(16777216);
            }
            a(window, aVar.b());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f46803m.setContentView(aVar.e(), layoutParams);
            this.f46803m.getWindow().getAttributes().width = -1;
            this.f46803m.getWindow().getAttributes().height = -1;
            this.f46803m.getWindow().getAttributes().gravity = 17;
            this.f46809s.a(activity);
            window.setLayout(-1, -1);
            boolean h4 = h();
            if (!z3 && !h4) {
                window.clearFlags(1024);
            } else {
                window.addFlags(1024);
            }
            if (Build.VERSION.SDK_INT > 19 && (decorView = window.getDecorView()) != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (h4) {
                    systemUiVisibility |= 4;
                }
                decorView.setSystemUiVisibility(systemUiVisibility | 2 | 4096);
            }
            try {
                this.f46803m.show();
                this.f46802l = true;
                b(102);
                i0.a(this.f46301g, aVar.b() != null ? aVar.b().e1() : false, !TextUtils.isEmpty(this.f46808r));
                return;
            } catch (Exception unused) {
                i0.a(this.f46301g, 9003);
                return;
            }
        }
        GDTLogger.w("Activity\u5df2\u7ecf\u88ab\u7cfb\u7edf\u56de\u6536");
        i0.a(this.f46301g, 9003);
    }

    protected void b(int i4) {
        a(i4, (Object[]) null);
    }

    private void a(Window window, e eVar) {
        y i02;
        if (window == null || eVar == null || (i02 = eVar.i0()) == null || i02.c() < 0.0f) {
            return;
        }
        window.setDimAmount(i02.c());
    }

    private void a(com.qq.e.comm.plugin.u.a aVar, boolean z3, Activity activity) {
        boolean h4 = h();
        q b4 = aVar.b();
        if (b4 == null) {
            return;
        }
        a(b4, h4, z3);
        aVar.a(activity);
    }

    private void a(q qVar, boolean z3, boolean z4) {
        int i4 = z3 ? this.f46811u : this.f46810t;
        int i5 = z3 ? this.f46810t : this.f46811u;
        if (!z4) {
            i5 -= z.d();
        }
        int b4 = f1.b(this.f46297c, i4);
        int b5 = f1.b(this.f46297c, i5);
        d1.a("HalfScreenAdImpl", "setAdSize: mScreenHeight:" + this.f46811u + ", mScreenWidth: " + this.f46810t + ", width: " + b4 + " ,height:" + b5);
        qVar.a(b4, b5);
    }

    protected boolean a(Point point, com.qq.e.comm.plugin.u.a aVar) {
        double a4;
        int i4;
        int i5;
        Point g4 = g();
        if (g4.x > 0 || g4.y > 0) {
            if (aVar.h()) {
                a4 = d.b();
            } else {
                a4 = d.a();
            }
            int i6 = g4.x;
            int i7 = g4.y;
            if (i6 >= i7) {
                this.f46810t = i7;
                this.f46811u = i6;
            } else {
                this.f46810t = i6;
                this.f46811u = i7;
            }
            double d4 = this.f46810t;
            Double.isNaN(d4);
            int i8 = (int) (d4 * a4);
            this.f46804n = i8;
            if (g4.x <= 0 || g4.y <= 0 || (i4 = point.x) <= 0 || (i5 = point.y) <= 0) {
                return true;
            }
            double d5 = this.f46811u;
            Double.isNaN(d5);
            double d6 = a4 * d5;
            double d7 = i4;
            Double.isNaN(d7);
            double d8 = d6 * d7;
            double d9 = i5;
            Double.isNaN(d9);
            this.f46804n = Math.min(i8, (int) (d8 / d9));
            return true;
        }
        return false;
    }

    public boolean a(m.d dVar, boolean z3) {
        if (this.f46800j) {
            return false;
        }
        if (dVar == null || dVar.c()) {
            if (!z3) {
                a(5004);
            }
            return false;
        }
        q qVar = dVar.b().get(0);
        if (z3) {
            d1.a("\u6a21\u677f\u63d2\u5c4f\u5e7f\u544a\u7f13\u5b58\u5230\u6587\u4ef6:" + qVar, new Object[0]);
            return false;
        }
        com.qq.e.comm.plugin.z.a aVar = (com.qq.e.comm.plugin.z.a) dVar.a().get(0);
        this.f46799i = aVar;
        aVar.setAdListener(new b());
        return j();
    }

    protected void a(int i4) {
        a(107, new Object[]{Integer.valueOf(i4)});
    }

    private void a(int i4, Object[] objArr) {
        p0.a((Runnable) new C0912c(i4, objArr));
    }
}
