package com.baidu.mobads.sdk.api;

import android.app.Fragment;
import androidx.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface CPUComponent {
    void destroy();

    @Nullable
    Fragment getFragment();

    @Nullable
    androidx.fragment.app.Fragment getSupportFragment();

    void refresh();
}
