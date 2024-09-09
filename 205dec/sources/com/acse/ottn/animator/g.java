package com.acse.ottn.animator;

import com.acse.ottn.R;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f5047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar) {
        this.f5047a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5047a.f5048a.f5049a.f4808c != null) {
            this.f5047a.f5048a.f5049a.f4808c.setBackgroundResource(R.mipmap.finger_normal);
        }
        this.f5047a.f5048a.f5049a.d();
    }
}
