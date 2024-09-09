package com.acse.ottn.util;

import android.app.Activity;
import android.content.Intent;
import com.acse.ottn.activity.TransparentGreenActivity;

/* renamed from: com.acse.ottn.util.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1422d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f6815a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1424e f6816b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1422d(C1424e c1424e, Activity activity) {
        this.f6816b = c1424e;
        this.f6815a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent(this.f6815a, TransparentGreenActivity.class);
        intent.setFlags(268435456);
        this.f6815a.startActivity(intent);
    }
}
