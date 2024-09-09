package com.acse.ottn.banner.util;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public interface a extends LifecycleObserver {
    void onDestroy(LifecycleOwner lifecycleOwner);

    void onStart(LifecycleOwner lifecycleOwner);

    void onStop(LifecycleOwner lifecycleOwner);
}
