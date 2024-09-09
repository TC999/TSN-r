package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.plugin.r0.l;
import com.qq.e.dl.j.b;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d0 extends com.qq.e.dl.l.a<d> {
    private int A;
    private boolean B;

    /* renamed from: x  reason: collision with root package name */
    private final l.b f42391x;

    /* renamed from: y  reason: collision with root package name */
    private com.qq.e.dl.l.m.b.b f42392y;

    /* renamed from: z  reason: collision with root package name */
    private final String[] f42393z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements n.d {
        a() {
        }

        @Override // com.qq.e.dl.k.n.d
        public void a(Object[] objArr) {
            d0.this.f42391x.a(objArr);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements b.InterfaceC0917b {
        b() {
        }

        @Override // com.qq.e.dl.j.b.InterfaceC0917b
        public void a(int i4) {
            if (d0.this.B) {
                ((d) ((com.qq.e.dl.l.a) d0.this).f47039w).setBackgroundColor(i4);
            } else {
                d0.this.f42391x.d(i4);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new d0(aVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d extends com.qq.e.comm.plugin.r0.l implements com.qq.e.dl.l.e {

        /* renamed from: q  reason: collision with root package name */
        private com.qq.e.dl.l.h f42396q;

        public d(Context context, TextView textView) {
            super(context, textView);
        }

        @Override // com.qq.e.dl.l.e
        public void a(com.qq.e.dl.l.h hVar) {
            this.f42396q = hVar;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i4, int i5) {
            com.qq.e.dl.l.k.a i6 = this.f42396q.i();
            Pair<Integer, Integer> d4 = i6.d(i4, i5);
            super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
            Pair<Integer, Integer> c4 = i6.c(i4, i5);
            if (c4 != null) {
                super.onMeasure(((Integer) c4.first).intValue(), ((Integer) c4.second).intValue());
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42396q.a(view, i4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qq.e.comm.plugin.r0.l
        public void a(l.b bVar) {
            super.a(bVar);
        }
    }

    /* synthetic */ d0(com.qq.e.dl.a aVar, a aVar2) {
        this(aVar);
    }

    private void x() {
        if ((this.A ^ 3) == 0) {
            this.f42391x.a(this.f42393z);
            ((d) this.f47039w).a(this.f42391x);
            this.A = 0;
            this.B = true;
        }
    }

    @Override // com.qq.e.dl.l.h
    public void e(int i4) {
        if (this.B) {
            ((d) this.f47039w).setBackgroundColor(i4);
        } else {
            this.f42391x.d(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        if (!((com.qq.e.dl.l.k.b) this.f47070h).d()) {
            x();
        }
        super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: w */
    public e v() {
        return new e(this, (d) this.f47039w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e extends com.qq.e.dl.l.k.b<d> {
        public e(d0 d0Var, d dVar) {
            super(d0Var, dVar);
        }

        @Override // com.qq.e.dl.l.k.b, com.qq.e.dl.l.k.c
        public void b() {
            e().i().b();
            super.b();
        }

        com.qq.e.dl.l.m.b.b e() {
            return ((d0) this.f47182a).f42392y;
        }

        @Override // com.qq.e.dl.l.k.a
        public void b(int i4, int i5) {
            super.b(i4, i5);
            com.qq.e.dl.l.m.b.b e4 = e();
            View m4 = e4.m();
            if (m4 == null) {
                return;
            }
            com.qq.e.dl.l.c n4 = e4.n();
            if (n4.a(i4, i5)) {
                m4.setPadding(n4.c(), n4.e(), n4.d(), n4.b());
            }
        }
    }

    private d0(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f42391x = new l.b();
        this.f42393z = new String[5];
        this.A = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public d a(com.qq.e.dl.a aVar) {
        this.f42392y = new com.qq.e.dl.l.m.b.b(aVar);
        return new d(aVar.b(), (TextView) this.f42392y.m());
    }

    @Override // com.qq.e.dl.l.h
    public void c() {
        super.c();
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1487056351:
                if (str.equals("idleProgress")) {
                    c4 = '\t';
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
            case 57:
                if (str.equals("9")) {
                    c4 = '\n';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1567:
                if (str.equals("10")) {
                    c4 = 11;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1568:
                if (str.equals("11")) {
                    c4 = '\f';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1569:
                if (str.equals("12")) {
                    c4 = '\r';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1573:
                if (str.equals("16")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1598:
                if (str.equals("20")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1636:
                if (str.equals("37")) {
                    c4 = 6;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1754:
                if (str.equals("71")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1755:
                if (str.equals("72")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1756:
                if (str.equals("73")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 3683:
                if (str.equals("tW")) {
                    c4 = '\b';
                    break;
                }
                c4 = '\uffff';
                break;
            case 1525876935:
                if (str.equals("proBrBgClr")) {
                    c4 = 7;
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
                com.qq.e.comm.plugin.g0.c s3 = eVar.s();
                this.f42393z[1] = s3.c();
                this.f42393z[2] = s3.b();
                this.f42393z[3] = s3.a();
                this.f42393z[4] = s3.e();
                this.f42391x.a(eVar);
                this.A |= 1;
                return true;
            case 1:
                this.f42393z[0] = gVar.toString();
                this.A |= 2;
                return true;
            case 2:
                int a4 = com.qq.e.dl.k.n.a(gVar);
                this.f42391x.c(a4);
                this.f42391x.e(a4);
                return true;
            case 3:
                this.f42391x.g(gVar.a(new JSONObject[0]));
                return true;
            case 4:
                this.f42391x.f(gVar.f(new JSONObject[0]).a(this.f47076n.n(), this.f47076n.m()));
                return true;
            case 5:
                this.f42391x.d(com.qq.e.dl.k.n.a(gVar));
                return true;
            case 6:
                com.qq.e.dl.k.n.a(gVar, a().c(), new a());
                return true;
            case 7:
                this.f42391x.a(com.qq.e.dl.k.n.a(gVar));
                return true;
            case '\b':
                this.f42391x.h(gVar.a(new JSONObject[0]));
                return true;
            case '\t':
                if (this.B) {
                    ((d) this.f47039w).a(gVar.b(new JSONObject[0]));
                } else {
                    this.f42391x.b(gVar.b(new JSONObject[0]));
                }
                return true;
            case '\n':
            case 11:
            case '\f':
            case '\r':
                this.f42392y.n().a(str, gVar);
                return true;
            default:
                return super.a(str, gVar) || this.f42392y.a(str, gVar);
        }
    }

    @Override // com.qq.e.dl.l.h
    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qq.e.dl.j.b.a(this.f47073k.c(), str, new b());
    }
}
