package com.baidu.mobads.sdk.api;

import android.app.Fragment;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface CPUComponent {
    void destroy();

    @Nullable
    Fragment getFragment();

    @Nullable
    androidx.fragment.app.Fragment getSupportFragment();

    void refresh();
}
