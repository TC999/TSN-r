package com.acse.ottn.receiver;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.receiver.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1554b implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C1555c f2914a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1554b(C1555c c1555c) {
        this.f2914a = c1555c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AccessibilityService accessibilityService;
        if (message.what == 1 && Build.VERSION.SDK_INT >= 28) {
            accessibilityService = this.f2914a.f2918d;
            accessibilityService.performGlobalAction(8);
        }
        return true;
    }
}
