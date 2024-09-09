package com.qq.e.comm.plugin.dl;

import android.view.View;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s extends q {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            View view = (View) s.this.f42564c.getRootView().getParent();
            int i5 = 0;
            if (view != null) {
                i5 = com.qq.e.dl.j.f.b(view.getWidth());
                i4 = com.qq.e.dl.j.f.b(view.getHeight());
            } else {
                i4 = 0;
            }
            if (i5 == 0 || i4 == 0) {
                return;
            }
            com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
            j0Var.a("w", i5);
            j0Var.a("h", i4);
            com.qq.e.comm.plugin.util.j0 j0Var2 = new com.qq.e.comm.plugin.util.j0();
            j0Var2.a("adViewParentSize", j0Var.toString());
            s.this.a(j0Var2.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.h.d<Integer> {
        b(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            d1.a(q.f42563q, "onDialogShow: type = %s", num);
            IGDTBiz f4 = s.this.f();
            if (f4 == null) {
                return;
            }
            f4.onDialogShow(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.h.d<Integer> {
        c(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            d1.a(q.f42563q, "onDialogDismiss: type = %s", num);
            IGDTBiz f4 = s.this.f();
            if (f4 == null) {
                return;
            }
            f4.onDialogDismiss(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<Void> {
        d(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            s.this.f().onLandingPageOpen();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends com.qq.e.comm.plugin.h.d<Void> {
        e(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            s.this.f().onLandingPageClose();
        }
    }

    public s(com.qq.e.dl.l.l.b bVar, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        super(bVar, eVar, eVar.i0());
        q();
        a(eVar);
        b(eVar);
    }

    private void q() {
        this.f42564c.getRootView().post(new a());
    }

    public void a(boolean z3) {
        if (this.f42565d.X0()) {
            com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
            j0Var.a("appInfoVis", z3 ? 0 : 2);
            a(j0Var.a());
        }
    }

    @Override // com.qq.e.comm.plugin.dl.q
    public void b() {
        super.b();
        com.qq.e.comm.plugin.h.a.c(this.f42565d.l0(), LPCallback.class);
    }

    public boolean m() {
        return com.qq.e.comm.plugin.dl.d.a(this.f42565d);
    }

    public int n() {
        return com.qq.e.comm.plugin.dl.d.c(this.f42565d);
    }

    public boolean o() {
        return com.qq.e.comm.plugin.dl.d.d(this.f42565d);
    }

    public void p() {
        com.qq.e.comm.plugin.dl.d.a(this);
    }

    public void r() {
        com.qq.e.comm.plugin.dl.d.a(this, this.f42565d);
    }

    private void b(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null || f() == null) {
            return;
        }
        LPCallback lPCallback = (LPCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), LPCallback.class);
        lPCallback.g().a(new d(this));
        lPCallback.onClose().a(new e(this));
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return;
        }
        DialogStateCallback dialogStateCallback = (DialogStateCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), DialogStateCallback.class);
        dialogStateCallback.d().a(new b(this));
        dialogStateCallback.onDismiss().a(new c(this));
    }

    public void a(int i4) {
        IGDTBiz f4 = f();
        if (f4 == null) {
            return;
        }
        f4.onReward(i4);
    }
}
