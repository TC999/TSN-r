package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface TTAdManager {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface OnExitInstallListener {
        void onExitInstall();
    }

    TTAdNative createAdNative(Context context);

    String getBiddingToken(AdSlot adSlot);

    String getBiddingToken(AdSlot adSlot, boolean z3, int i4);

    <T> T getExtra(Class<T> cls, Bundle bundle);

    String getPluginVersion();

    String getSDKVersion();

    int getThemeStatus();

    void register(Object obj);

    void requestPermissionIfNecessary(Context context);

    void setThemeStatus(int i4);

    boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener);

    void unregister(Object obj);
}
