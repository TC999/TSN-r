package com.bytedance.sdk.component.adexpress.ux;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.c.n;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<n> f29407c;

    public sr(n nVar) {
        this.f29407c = new WeakReference<>(nVar);
    }

    public void c(n nVar) {
        this.f29407c = new WeakReference<>(nVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<n> weakReference = this.f29407c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29407c.get().invokeMethod(str);
    }
}
