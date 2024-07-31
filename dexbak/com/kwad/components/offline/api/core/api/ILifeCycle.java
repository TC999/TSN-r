package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i);
}
