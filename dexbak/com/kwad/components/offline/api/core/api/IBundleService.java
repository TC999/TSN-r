package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IBundleService {
    void loadBundle(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void loadBundleWithString(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void unloadBundle(String str);
}
