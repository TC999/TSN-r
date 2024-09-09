package com.acse.ottn.activity;

import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class K implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TransparentActivity f4670a;

    K(TransparentActivity transparentActivity) {
        this.f4670a = transparentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4670a.f4710m.a();
        } catch (Exception e4) {
            ra.b("TransparentActivity", e4.getMessage());
        }
    }
}
