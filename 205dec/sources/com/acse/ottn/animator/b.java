package com.acse.ottn.animator;

import com.acse.ottn.R;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f4948a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4948a.f4957a.f5044a.f4795c != null) {
            this.f4948a.f4957a.f5044a.f4795c.setBackgroundResource(R.mipmap.finger_normal);
        }
        this.f4948a.f4957a.f5044a.d();
    }
}
