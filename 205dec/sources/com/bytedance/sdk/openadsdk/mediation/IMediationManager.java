package com.bytedance.sdk.openadsdk.mediation;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IMediationManager {
    Map<String, Object> getMediationExtraInfo();

    void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback);

    void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback);

    Object mtool(int i4, ValueSet valueSet);

    void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i4, int i5);

    void requestPermissionIfNecessary(Context context);

    void requestPermissionIfNecessary(Context context, int[] iArr);

    void setPulisherDid(String str);

    void setThemeStatus(int i4);

    void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment);

    int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener);

    void updateLocalExtra(Map<String, Object> map);

    void updatePrivacyConfig(TTCustomController tTCustomController);
}
