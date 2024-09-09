package com.bytedance.sdk.openadsdk.live.core;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface ITTLiveConfig {
    String getAppName();

    String getChannel();

    String getECHostAppId();

    String getGeneralAppId();

    TTHostPermissionInner getHostPermission();

    ITTLiveHostAction getLiveHostAction();

    String getPartner();

    String getPartnerSecret();

    String getVersion();

    int getVersionCode();

    boolean isDebug();

    boolean isValid();
}
