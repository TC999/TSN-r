package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class AdVideoPlayerViewCache {

    /* renamed from: Cl */
    private HashMap<String, WeakReference<TextureView$SurfaceTextureListenerC10537a>> f29596Cl;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* renamed from: a */
    public final void m25523a(String str, TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a) {
        this.f29596Cl.put(str, new WeakReference<>(textureView$SurfaceTextureListenerC10537a));
    }

    /* renamed from: ew */
    public final TextureView$SurfaceTextureListenerC10537a m25522ew(String str) {
        WeakReference<TextureView$SurfaceTextureListenerC10537a> weakReference = this.f29596Cl.get(str);
        if (weakReference != null) {
            TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = weakReference.get();
            if (textureView$SurfaceTextureListenerC10537a != null) {
                return textureView$SurfaceTextureListenerC10537a;
            }
            this.f29596Cl.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.f29596Cl.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.f29596Cl = new HashMap<>(1);
    }
}
