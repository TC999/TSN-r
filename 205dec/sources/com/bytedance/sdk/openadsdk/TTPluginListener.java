package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i4, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}
