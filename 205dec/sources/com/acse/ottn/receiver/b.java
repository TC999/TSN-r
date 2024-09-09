package com.acse.ottn.receiver;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f6217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f6217a = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AccessibilityService accessibilityService;
        if (message.what == 1 && Build.VERSION.SDK_INT >= 28) {
            accessibilityService = this.f6217a.f6221d;
            accessibilityService.performGlobalAction(8);
        }
        return true;
    }
}
