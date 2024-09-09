package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IEnvironment {
    void addOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    String getAppId();

    String getAppVersion();

    String getBiz();

    Context getContext();

    String getDeviceId();

    String getKpf();

    String getKpn();

    double getLatitude(Context context);

    double getLongitude(Context context);

    String getOperator(Context context);

    String getOsVersion();

    String getProcessName(Context context);

    String getSdkVersion();

    int getStatusBarHeight(Context context);

    String getUserAgent();

    boolean isArm64(Context context);

    boolean isDebug();

    boolean isDevelopEnable();

    boolean isInMainProcess(Context context);

    boolean isTKCrashCollectEnable();

    String localIpAddress();

    void removeOnAudioConflictListener(Context context, OfflineOnAudioConflictListener offlineOnAudioConflictListener);

    boolean requestAudioFocus(Context context, boolean z3);
}
