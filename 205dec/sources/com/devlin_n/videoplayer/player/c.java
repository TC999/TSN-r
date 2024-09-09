package com.devlin_n.videoplayer.player;

import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: VideoViewManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f36979b;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<IjkVideoView> f36980a;

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f36979b == null) {
                f36979b = new c();
            }
            cVar = f36979b;
        }
        return cVar;
    }

    public IjkVideoView a() {
        WeakReference<IjkVideoView> weakReference = this.f36980a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean c() {
        WeakReference<IjkVideoView> weakReference = this.f36980a;
        return (weakReference == null || weakReference.get() == null || !this.f36980a.get().X()) ? false : true;
    }

    public void d() {
        WeakReference<IjkVideoView> weakReference = this.f36980a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f36980a.get().Z();
        this.f36980a = null;
    }

    public void e(IjkVideoView ijkVideoView) {
        this.f36980a = new WeakReference<>(ijkVideoView);
    }
}
