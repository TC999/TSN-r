package com.acse.ottn.animator;

import com.acse.ottn.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f5048a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar) {
        this.f5048a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5048a.f5049a.f4807b == null || this.f5048a.f5049a.f4806a == null) {
            return;
        }
        this.f5048a.f5049a.f4807b.setBackgroundResource(R.mipmap.switch_on_circle_point);
        this.f5048a.f5049a.c();
        this.f5048a.f5049a.f4806a.postDelayed(new g(this), 100L);
    }
}
