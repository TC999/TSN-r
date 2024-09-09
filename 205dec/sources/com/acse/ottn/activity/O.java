package com.acse.ottn.activity;

import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class O implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TransparentGreenActivity f4674a;

    O(TransparentGreenActivity transparentGreenActivity) {
        this.f4674a = transparentGreenActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4674a.f4719h.a();
            this.f4674a.f4720i.a();
        } catch (Exception e4) {
            ra.b("TransparentActivity", e4.getMessage());
        }
    }
}
