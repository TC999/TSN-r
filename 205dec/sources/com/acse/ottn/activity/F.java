package com.acse.ottn.activity;

import android.text.TextUtils;
import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f4664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(G g4) {
        this.f4664a = g4;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(SeedingLoadingActivity.i(this.f4664a.f4665a))) {
            return;
        }
        ra.a("SeedingLoadingActivity", "write code = " + SeedingLoadingActivity.i(this.f4664a.f4665a));
        com.acse.ottn.util.H a4 = com.acse.ottn.util.H.a();
        SeedingLoadingActivity seedingLoadingActivity = this.f4664a.f4665a;
        a4.a(seedingLoadingActivity, SeedingLoadingActivity.i(seedingLoadingActivity));
    }
}
