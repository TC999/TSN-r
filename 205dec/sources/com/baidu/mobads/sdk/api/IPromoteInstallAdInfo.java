package com.baidu.mobads.sdk.api;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IPromoteInstallAdInfo {
    String getAppPublisher();

    String getAppVersion();

    String getBrandName();

    String getECPMLevel();

    String getFunctionUrl();

    String getIconUrl();

    String getPermissionUrl();

    String getPrivacyUrl();

    String getUnionLogoUrl();

    void handleAdInstall();
}
