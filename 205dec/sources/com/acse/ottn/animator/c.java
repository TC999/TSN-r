package com.acse.ottn.animator;

import com.acse.ottn.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f4957a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4957a.f5044a.f4794b == null || this.f4957a.f5044a.f4793a == null) {
            return;
        }
        this.f4957a.f5044a.f4794b.setBackgroundResource(R.mipmap.switch_on_circle_point);
        this.f4957a.f5044a.c();
        this.f4957a.f5044a.f4793a.postDelayed(new b(this), 100L);
    }
}
