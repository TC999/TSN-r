package com.devlin_n.videoplayer.player;

import java.lang.ref.WeakReference;

/* renamed from: com.devlin_n.videoplayer.player.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoViewManager {

    /* renamed from: b */
    private static VideoViewManager f23383b;

    /* renamed from: a */
    private WeakReference<IjkVideoView> f23384a;

    private VideoViewManager() {
    }

    /* renamed from: b */
    public static synchronized VideoViewManager m35674b() {
        VideoViewManager videoViewManager;
        synchronized (VideoViewManager.class) {
            if (f23383b == null) {
                f23383b = new VideoViewManager();
            }
            videoViewManager = f23383b;
        }
        return videoViewManager;
    }

    /* renamed from: a */
    public IjkVideoView m35675a() {
        WeakReference<IjkVideoView> weakReference = this.f23384a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: c */
    public boolean m35673c() {
        WeakReference<IjkVideoView> weakReference = this.f23384a;
        return (weakReference == null || weakReference.get() == null || !this.f23384a.get().m35724Y()) ? false : true;
    }

    /* renamed from: d */
    public void m35672d() {
        WeakReference<IjkVideoView> weakReference = this.f23384a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f23384a.get().m35721a0();
        this.f23384a = null;
    }

    /* renamed from: e */
    public void m35671e(IjkVideoView ijkVideoView) {
        this.f23384a = new WeakReference<>(ijkVideoView);
    }
}
