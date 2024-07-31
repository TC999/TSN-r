package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Log;

/* renamed from: com.acse.ottn.util.G */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1629G implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f3150a;

    /* renamed from: b */
    final /* synthetic */ C1631H f3151b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1629G(C1631H c1631h, Activity activity) {
        this.f3151b = c1631h;
        this.f3150a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClipData primaryClip = ((ClipboardManager) this.f3150a.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return;
        }
        String charSequence = primaryClip.getItemAt(0).getText().toString();
        Log.d("ShopHelpManager", "getFromClipboard text=" + charSequence);
    }
}
