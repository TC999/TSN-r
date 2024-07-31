package com.kwad.components.offline.api.core.soloader;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface SoLoadListener {
    void onFailed(int i, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
