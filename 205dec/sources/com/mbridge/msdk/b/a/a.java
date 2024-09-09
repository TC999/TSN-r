package com.mbridge.msdk.b.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* compiled from: PreloadListenerEx.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements PreloadListener {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<PreloadListener> f38676a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38677b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f38678c = 0;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f38676a = new WeakReference<>(preloadListener);
        }
    }

    public final boolean a() {
        return this.f38677b;
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f38676a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f38676a.get().onPreloadFaild(str);
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f38676a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f38676a.get().onPreloadSucceed();
    }

    public final void a(boolean z3) {
        this.f38677b = z3;
    }
}
