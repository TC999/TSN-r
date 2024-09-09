package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.r0.k;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b0 extends com.qq.e.dl.l.a<c> {
    private static final String A = "b0";

    /* renamed from: x  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f42380x;

    /* renamed from: y  reason: collision with root package name */
    private FSCallback f42381y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f42382z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new b0(aVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends com.qq.e.comm.plugin.r0.k implements com.qq.e.dl.l.e<b0> {

        /* renamed from: f0  reason: collision with root package name */
        private b0 f42384f0;

        public c(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qq.e.comm.plugin.r0.k, android.view.View
        public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
            super.onLayout(z3, i4, i5, i6, i7);
            q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qq.e.comm.plugin.r0.k, android.view.View
        public void onMeasure(int i4, int i5) {
            com.qq.e.dl.l.k.a i6 = this.f42384f0.i();
            Pair<Integer, Integer> d4 = i6.d(i4, i5);
            super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
            Pair<Integer, Integer> c4 = i6.c(i4, i5);
            if (c4 != null) {
                super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            b0 b0Var = this.f42384f0;
            if (b0Var != null) {
                b0Var.a(view, i4);
            }
        }

        @Override // com.qq.e.dl.l.e
        public void a(b0 b0Var) {
            this.f42384f0 = b0Var;
        }
    }

    /* synthetic */ b0(com.qq.e.dl.a aVar, a aVar2) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f4) {
        FSCallback fSCallback = this.f42381y;
        if (fSCallback != null) {
            fSCallback.e().b(Float.valueOf(f4));
        }
    }

    private com.qq.e.comm.plugin.i.f x() {
        com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(this.f42380x);
        fVar.f44110g = 4;
        fVar.f44109f = 5;
        fVar.f44106c = this.f47081s;
        fVar.f44108e = -1;
        fVar.f44114k = -1;
        fVar.f44116m = true;
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        FSCallback fSCallback = this.f42381y;
        if (fSCallback != null) {
            fSCallback.H().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        FSCallback fSCallback;
        if (this.f42382z || (fSCallback = this.f42381y) == null) {
            return;
        }
        this.f42382z = true;
        fSCallback.p().b(x());
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements k.InterfaceC0885k {
        a() {
        }

        @Override // com.qq.e.comm.plugin.r0.k.InterfaceC0885k
        public void a() {
            d1.a(b0.A, "nextPage");
            b0.this.z();
        }

        @Override // com.qq.e.comm.plugin.r0.k.InterfaceC0885k
        public void b() {
            d1.a(b0.A, "prePage");
            b0.this.z();
        }

        @Override // com.qq.e.comm.plugin.r0.k.InterfaceC0885k
        public void first() {
            d1.a(b0.A, "first \u6700\u524d\u9875\u4e86");
            b0.this.z();
        }

        @Override // com.qq.e.comm.plugin.r0.k.InterfaceC0885k
        public void last() {
            d1.a(b0.A, "last \u6700\u540e\u4e00\u9875\u4e86");
            b0.this.z();
            b0.this.y();
        }

        @Override // com.qq.e.comm.plugin.r0.k.InterfaceC0885k
        public void a(float f4) {
            b0.this.e(f4);
        }
    }

    private b0(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f42382z = false;
        ((c) this.f47039w).a(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1856306106:
                if (str.equals("pageCardHeight")) {
                    c4 = '\t';
                    break;
                }
                c4 = '\uffff';
                break;
            case -1476942025:
                if (str.equals("backBgColor")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1169023802:
                if (str.equals("adModel")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case -299431109:
                if (str.equals("pageCardShowIndexInterval")) {
                    c4 = '\n';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1573:
                if (str.equals("16")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1754:
                if (str.equals("71")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1755:
                if (str.equals("72")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1756:
                if (str.equals("73")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 32530252:
                if (str.equals("rowSpace")) {
                    c4 = 7;
                    break;
                }
                c4 = '\uffff';
                break;
            case 531160335:
                if (str.equals("backTextColor")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1834668881:
                if (str.equals("lineNumPageCard")) {
                    c4 = '\b';
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
                com.qq.e.comm.plugin.g0.e eVar = (com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]);
                this.f42380x = eVar;
                if (eVar != null) {
                    this.f42381y = (FSCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), FSCallback.class);
                    break;
                }
                break;
            case 1:
                ((c) this.f47039w).c(gVar.f(new JSONObject[0]).d());
                break;
            case 2:
                ((c) this.f47039w).a(gVar.toString());
                break;
            case 3:
                ((c) this.f47039w).g(com.qq.e.dl.k.n.a(gVar));
                break;
            case 4:
                ((c) this.f47039w).c(com.qq.e.dl.k.n.a(gVar));
                break;
            case 5:
                ((c) this.f47039w).a(com.qq.e.dl.k.n.a(gVar));
                break;
            case 6:
                ((c) this.f47039w).b(com.qq.e.dl.k.n.a(gVar));
                break;
            case 7:
                ((c) this.f47039w).b(gVar.d(new JSONObject[0]));
                break;
            case '\b':
                ((c) this.f47039w).d(gVar.b(new JSONObject[0]));
                break;
            case '\t':
                ((c) this.f47039w).e(gVar.f(new JSONObject[0]).d());
                break;
            case '\n':
                ((c) this.f47039w).f(gVar.b(new JSONObject[0]));
                break;
            default:
                return super.a(str, gVar);
        }
        return true;
    }
}
