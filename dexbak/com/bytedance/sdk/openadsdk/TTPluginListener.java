package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}