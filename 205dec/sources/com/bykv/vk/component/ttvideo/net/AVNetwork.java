package com.bykv.vk.component.ttvideo.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bykv.vk.component.ttvideo.player.CalledByNative;
import com.bykv.vk.component.ttvideo.player.Keep;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class AVNetwork {
    public static final int IS_MOBILE_NETWORK = 2;
    public static final int IS_UNKOWN_NETWORK = 0;
    public static final int IS_WIFF_NETWORK = 1;

    @SuppressLint({"MissingPermission"})
    @CalledByNative
    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable unused) {
        }
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        return type == 0 ? 2 : 0;
    }
}
