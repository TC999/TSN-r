package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i4);
}
