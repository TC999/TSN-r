package com.bytedance.msdk.adapter.config;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTOnNetworkInitializationFinishedListener {
    void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError);
}
