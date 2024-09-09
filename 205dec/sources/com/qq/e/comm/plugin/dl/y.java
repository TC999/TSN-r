package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.dl.j.b;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class y extends com.qq.e.dl.l.a<f> implements com.qq.e.comm.plugin.apkmanager.w.a {
    private String A;
    private com.qq.e.comm.plugin.g0.c B;
    private JSONObject C;
    private JSONObject D;
    private int E;
    private int F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;

    /* renamed from: x  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f42641x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f42642y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f42643z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements n.d {
        a() {
        }

        @Override // com.qq.e.dl.k.n.d
        public void a(Object[] objArr) {
            ((f) ((com.qq.e.dl.l.a) y.this).f47039w).a(objArr);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42645c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f42646d;

        b(int i4, int i5) {
            this.f42645c = i4;
            this.f42646d = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.c(this.f42645c, this.f42646d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements n.c {
        c() {
        }

        @Override // com.qq.e.dl.k.n.c
        public void a(int i4) {
            ((f) ((com.qq.e.dl.l.a) y.this).f47039w).b(i4);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements b.InterfaceC0917b {
        d() {
        }

        @Override // com.qq.e.dl.j.b.InterfaceC0917b
        public void a(int i4) {
            ((f) ((com.qq.e.dl.l.a) y.this).f47039w).b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new y(aVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class f extends com.qq.e.comm.plugin.r0.h implements com.qq.e.dl.l.e<y> {

        /* renamed from: m  reason: collision with root package name */
        private y f42650m;

        public f(Context context) {
            super(context);
            a(true);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            y yVar = this.f42650m;
            if (yVar != null) {
                yVar.a(view, i4);
            }
        }

        @Override // com.qq.e.dl.l.e
        public void a(y yVar) {
            this.f42650m = yVar;
        }
    }

    /* synthetic */ y(com.qq.e.dl.a aVar, a aVar2) {
        this(aVar);
    }

    private boolean i(int i4) {
        if (i4 == 4) {
            if (this.F == 1) {
                return false;
            }
            this.F = 1;
        } else if (this.F == 0) {
            return false;
        } else {
            this.F = 0;
        }
        return true;
    }

    private boolean j(int i4) {
        if (i4 != 0 && i4 != 16 && i4 != 64) {
            if (this.E == 1) {
                return false;
            }
            this.E = 1;
        } else if (this.E == 0) {
            return false;
        } else {
            this.E = 0;
        }
        return true;
    }

    @Override // com.qq.e.dl.l.h
    public void e(int i4) {
        ((f) this.f47039w).setBackgroundColor(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        com.qq.e.comm.plugin.g0.e eVar = this.f42641x;
        if (eVar == null || this.f42643z) {
            return;
        }
        a(eVar);
        this.f42643z = true;
    }

    private y(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f42642y = false;
        this.f42643z = false;
        this.E = 0;
        this.F = 0;
        this.G = "dsTxt";
        this.H = "dPro";
        this.I = "dsTxtVis";
        this.J = "norTxtVis";
        this.K = "noneDlVis";
        ((f) this.f47039w).c(100);
        ((f) this.f47039w).b(com.qq.e.dl.k.n.a(com.qq.e.dl.k.l.c((Object) "#66FFFFFF")));
        ((f) this.f47039w).setBackgroundColor(com.qq.e.dl.k.n.a(com.qq.e.dl.k.l.c((Object) "#33FFFFFF")));
    }

    @Override // com.qq.e.dl.l.h
    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qq.e.dl.j.b.a(this.f47073k.c(), str, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -2058910792:
                if (str.equals("bindDataSuffix")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1780721904:
                if (str.equals("barColor")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1169023802:
                if (str.equals("adModel")) {
                    c4 = 7;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 632070269:
                if (str.equals("progressGradient")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 939293290:
                if (str.equals("barBgRadius")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1823658654:
                if (str.equals("barRoundEnable")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1851310235:
                if (str.equals("showProgressPercent")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        switch (c4) {
            case 0:
                ((f) this.f47039w).a(gVar.b(new JSONObject[0]));
                break;
            case 1:
                c(gVar);
                break;
            case 2:
                ((f) this.f47039w).a(gVar.f(new JSONObject[0]).a(this.f47076n.n(), this.f47076n.m()));
                break;
            case 3:
                ((f) this.f47039w).a(gVar.b(new JSONObject[0]) > 0);
                break;
            case 4:
                com.qq.e.dl.k.n.a(gVar, a().c(), new a());
                break;
            case 5:
                this.f42642y = gVar.b(new JSONObject[0]) > 0;
                break;
            case 6:
                String obj = gVar.toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.G = "dsTxt" + obj;
                    this.H = "dPro" + obj;
                    this.I = "dsTxtVis" + obj;
                    this.J = "norTxtVis" + obj;
                    this.K = "noneDlVis" + obj;
                    break;
                }
                break;
            case 7:
                this.f42641x = (com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]);
                break;
            default:
                return super.a(str, gVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public f a(com.qq.e.dl.a aVar) {
        return new f(aVar.b());
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (!eVar.X0() || eVar.q() == null) {
            return;
        }
        com.qq.e.comm.plugin.g0.b q3 = eVar.q();
        String e4 = q3.e();
        this.A = e4;
        if (TextUtils.isEmpty(e4)) {
            return;
        }
        com.qq.e.comm.plugin.g0.c s3 = eVar.s();
        this.B = s3;
        s3.a(eVar.C());
        c(q3.j(), com.qq.e.comm.plugin.apkmanager.k.e().a(this.A));
        com.qq.e.comm.plugin.apkmanager.k.e().a(this.A, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.y.c(int, int):void");
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        if (this.A.equals(str)) {
            p0.d(new b(i4, i5));
        }
    }

    protected void c(com.qq.e.dl.k.g gVar) {
        com.qq.e.dl.k.n.a(gVar, a().c(), new c());
    }
}
