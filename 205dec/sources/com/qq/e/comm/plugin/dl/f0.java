package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.view.View;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f0 extends com.qq.e.dl.l.a<c> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new f0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends com.qq.e.comm.plugin.r0.n implements com.qq.e.dl.l.e<f0> {

        /* renamed from: h  reason: collision with root package name */
        private com.qq.e.comm.plugin.fs.f.e.c.a f42433h;

        /* renamed from: i  reason: collision with root package name */
        private f0 f42434i;

        /* renamed from: j  reason: collision with root package name */
        private int f42435j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f42436k;

        public c(Context context) {
            super(context);
            this.f42435j = -1;
            this.f42436k = false;
        }

        @Override // com.qq.e.comm.plugin.r0.n
        public void d(int i4) {
            this.f42435j = i4;
            if (this.f42436k) {
                super.d(i4);
            }
        }

        void e(int i4) {
            com.qq.e.comm.plugin.fs.f.e.c.a aVar = this.f42433h;
            if (aVar == null || aVar.b()) {
                return;
            }
            this.f42433h.b(i4);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42434i.a(view, i4);
        }

        void a(com.qq.e.comm.plugin.g0.e eVar) {
            com.qq.e.comm.plugin.b.g o4;
            if (this.f42433h != null || eVar == null || (o4 = eVar.o()) == null) {
                return;
            }
            if (o4.j()) {
                if (eVar.i0() != null && eVar.i0().y()) {
                    this.f42433h = new com.qq.e.comm.plugin.fs.f.e.c.d(this, eVar);
                } else {
                    this.f42433h = new com.qq.e.comm.plugin.fs.f.e.c.e(this, eVar);
                }
            } else if (eVar.h1()) {
                this.f42433h = new com.qq.e.comm.plugin.fs.f.e.c.c(this, eVar);
            } else if (o4.g()) {
                this.f42433h = new com.qq.e.comm.plugin.fs.f.e.c.b(this, eVar);
            }
        }

        @Override // com.qq.e.dl.l.e
        public void a(f0 f0Var) {
            this.f42434i = f0Var;
        }

        public void a(boolean z3) {
            int i4;
            this.f42436k = z3;
            if (!z3 || (i4 = this.f42435j) <= 0) {
                return;
            }
            super.d(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    private f0(com.qq.e.dl.a aVar) {
        super(aVar);
        ((c) this.f47039w).setVisibility(8);
        ((c) this.f47039w).c(0);
        ((c) this.f47039w).b(0);
        this.f47076n.a("3", com.qq.e.dl.k.l.c((Object) (-2)));
    }

    @Override // com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        char c4;
        super.a(str, jSONObject);
        int hashCode = str.hashCode();
        if (hashCode != -2070199965) {
            if (hashCode == 1487219122 && str.equals("closeVideoAuto")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("closeVideo")) {
                c4 = 1;
            }
            c4 = '\uffff';
        }
        if ((c4 == 0 || c4 == 1) && m() != null) {
            m().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1169023802:
                if (str.equals("adModel")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 51:
                if (str.equals("3")) {
                    c4 = '\t';
                    break;
                }
                c4 = '\uffff';
                break;
            case 57:
                if (str.equals("9")) {
                    c4 = '\f';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1567:
                if (str.equals("10")) {
                    c4 = '\r';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1568:
                if (str.equals("11")) {
                    c4 = '\n';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1569:
                if (str.equals("12")) {
                    c4 = 11;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1573:
                if (str.equals("16")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1575:
                if (str.equals("18")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1576:
                if (str.equals("19")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1598:
                if (str.equals("20")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1755:
                if (str.equals("72")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1756:
                if (str.equals("73")) {
                    c4 = 7;
                    break;
                }
                c4 = '\uffff';
                break;
            case 492578599:
                if (str.equals("supportTextColor")) {
                    c4 = '\b';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1611883964:
                if (str.equals("videoPlayTime")) {
                    c4 = 0;
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
                ((c) this.f47039w).e(gVar.b(new JSONObject[0]));
                break;
            case 1:
                ((c) this.f47039w).a((com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]));
                break;
            case 2:
                ((c) this.f47039w).setBackgroundColor(com.qq.e.dl.k.n.a(gVar));
                break;
            case 3:
                ((c) this.f47039w).a(com.qq.e.dl.k.n.a(gVar));
                break;
            case 4:
                ((c) this.f47039w).c(gVar.f(new JSONObject[0]).a(this.f47076n.n(), this.f47076n.m()));
                break;
            case 5:
                ((c) this.f47039w).b(gVar.f(new JSONObject[0]).a(this.f47076n.n(), this.f47076n.m()));
                break;
            case 6:
                ((c) this.f47039w).a(0, gVar.f(new JSONObject[0]).d());
                break;
            case 7:
                ((c) this.f47039w).d(com.qq.e.dl.k.n.a(gVar));
                break;
            case '\b':
                ((c) this.f47039w).a(gVar.b(new JSONObject[0]) > 0);
                break;
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                break;
            default:
                return super.a(str, gVar);
        }
        return true;
    }
}
