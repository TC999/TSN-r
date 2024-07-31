package com.acse.ottn.util;

import android.app.Activity;
import android.content.Intent;
import com.acse.ottn.activity.TransparentGreenActivity;

/* renamed from: com.acse.ottn.util.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1664d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f3305a;

    /* renamed from: b */
    final /* synthetic */ C1666e f3306b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1664d(C1666e c1666e, Activity activity) {
        this.f3306b = c1666e;
        this.f3305a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent(this.f3305a, TransparentGreenActivity.class);
        intent.setFlags(268435456);
        this.f3305a.startActivity(intent);
    }
}
