package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class G implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f6723a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ H f6724b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(H h4, Activity activity) {
        this.f6724b = h4;
        this.f6723a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClipData primaryClip = ((ClipboardManager) this.f6723a.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            return;
        }
        String charSequence = primaryClip.getItemAt(0).getText().toString();
        Log.d("ShopHelpManager", "getFromClipboard text=" + charSequence);
    }
}
