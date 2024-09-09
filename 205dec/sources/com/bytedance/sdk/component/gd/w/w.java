package com.bytedance.sdk.component.gd.w;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.n;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends n implements xv {

    /* renamed from: w  reason: collision with root package name */
    private final HandlerThread f29879w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(HandlerThread handlerThread, n.c cVar) {
        super(handlerThread.getLooper(), cVar);
        this.f29879w = handlerThread;
    }

    @Override // com.bytedance.sdk.component.gd.w.xv
    public void c() {
        removeCallbacksAndMessages(null);
        WeakReference<n.c> weakReference = this.f30203c;
        if (weakReference != null) {
            weakReference.clear();
            this.f30203c = null;
        }
    }

    public void w() {
        HandlerThread handlerThread = this.f29879w;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void c(n.c cVar) {
        this.f30203c = new WeakReference<>(cVar);
    }
}
