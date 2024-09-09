package com.acse.ottn.activity;

import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PicToPicActivity f4588a;

    A(PicToPicActivity picToPicActivity) {
        this.f4588a = picToPicActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4588a.f4690r.a();
            this.f4588a.f4689q.a();
        } catch (Exception e4) {
            ra.b("TransparentActivity", e4.getMessage());
        }
    }
}
