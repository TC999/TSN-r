package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.dl.j.b;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e0 extends com.qq.e.dl.l.a<e> {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements n.d {
        a() {
        }

        @Override // com.qq.e.dl.k.n.d
        public void a(Object[] objArr) {
            ((e) ((com.qq.e.dl.l.a) e0.this).f47039w).a(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements n.c {
        b() {
        }

        @Override // com.qq.e.dl.k.n.c
        public void a(int i4) {
            ((e) ((com.qq.e.dl.l.a) e0.this).f47039w).b(i4);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements b.InterfaceC0917b {
        c() {
        }

        @Override // com.qq.e.dl.j.b.InterfaceC0917b
        public void a(int i4) {
            ((e) ((com.qq.e.dl.l.a) e0.this).f47039w).b(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new e0(aVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e extends com.qq.e.comm.plugin.r0.h implements com.qq.e.dl.l.e<e0> {

        /* renamed from: m  reason: collision with root package name */
        private e0 f42431m;

        public e(Context context) {
            super(context);
            a(true);
        }

        void b(float f4) {
            super.a((int) (f4 * 100.0f));
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            e0 e0Var = this.f42431m;
            if (e0Var != null) {
                e0Var.a(view, i4);
            }
        }

        @Override // com.qq.e.dl.l.e
        public void a(e0 e0Var) {
            this.f42431m = e0Var;
        }
    }

    /* synthetic */ e0(com.qq.e.dl.a aVar, a aVar2) {
        this(aVar);
    }

    @Override // com.qq.e.dl.l.h
    public void e(int i4) {
        ((e) this.f47039w).setBackgroundColor(i4);
    }

    private e0(com.qq.e.dl.a aVar) {
        super(aVar);
        ((e) this.f47039w).c(100);
        ((e) this.f47039w).b(com.qq.e.dl.k.n.a(com.qq.e.dl.k.l.c((Object) "#66FFFFFF")));
        ((e) this.f47039w).setBackgroundColor(com.qq.e.dl.k.n.a(com.qq.e.dl.k.l.c((Object) "#33FFFFFF")));
    }

    @Override // com.qq.e.dl.l.h
    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qq.e.dl.j.b.a(this.f47073k.c(), str, new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.qq.e.dl.k.g gVar) {
        com.qq.e.dl.k.n.a(gVar, a().c(), new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        switch (str.hashCode()) {
            case -1780721904:
                if (str.equals("barColor")) {
                    c4 = 2;
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
            case -968653863:
                if (str.equals("progressf")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 632070269:
                if (str.equals("progressGradient")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case 939293290:
                if (str.equals("barBgRadius")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1823658654:
                if (str.equals("barRoundEnable")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        if (c4 == 0) {
            ((e) this.f47039w).a(gVar.b(new JSONObject[0]));
        } else if (c4 == 1) {
            ((e) this.f47039w).b(gVar.d(new JSONObject[0]));
        } else if (c4 == 2) {
            c(gVar);
        } else if (c4 == 3) {
            ((e) this.f47039w).a(gVar.f(new JSONObject[0]).d());
        } else if (c4 == 4) {
            ((e) this.f47039w).a(gVar.b(new JSONObject[0]) > 0);
        } else if (c4 != 5) {
            return super.a(str, gVar);
        } else {
            com.qq.e.dl.k.n.a(gVar, a().c(), new a());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public e a(com.qq.e.dl.a aVar) {
        return new e(aVar.b());
    }
}
