package com.kwad.components.offline.api.core.soloader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface SoLoadListener {
    void onFailed(int i4, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
