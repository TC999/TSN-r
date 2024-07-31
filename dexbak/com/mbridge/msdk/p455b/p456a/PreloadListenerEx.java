package com.mbridge.msdk.p455b.p456a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* renamed from: com.mbridge.msdk.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class PreloadListenerEx implements PreloadListener {

    /* renamed from: a */
    WeakReference<PreloadListener> f29709a;

    /* renamed from: b */
    private boolean f29710b = false;

    /* renamed from: c */
    private int f29711c = 0;

    public PreloadListenerEx(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f29709a = new WeakReference<>(preloadListener);
        }
    }

    /* renamed from: a */
    public final boolean m23454a() {
        return this.f29710b;
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f29709a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29709a.get().onPreloadFaild(str);
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f29709a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29709a.get().onPreloadSucceed();
    }

    /* renamed from: a */
    public final void m23453a(boolean z) {
        this.f29710b = z;
    }
}
