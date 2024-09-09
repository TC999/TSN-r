package com.bytedance.android.live.base.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IHostPermission {
    boolean alist();

    String getAndroidID();

    String getDevImei();

    String getDevOaid();

    String getMacAddress();

    LocationProvider getTTLocation();

    boolean isCanGetAndUseAndroidID();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}