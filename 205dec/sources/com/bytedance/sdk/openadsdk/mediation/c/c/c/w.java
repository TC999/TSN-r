package com.bytedance.sdk.openadsdk.mediation.c.c.c;

import android.app.Activity;
import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.c.c.w.ux;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.ys.c.c.gd;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements IMediationManager {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36099c;

    public w(Bridge bridge) {
        this.f36099c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        return (Map) this.f36099c.call(270024, b.b(0).l(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        b b4 = b.b(3);
        b4.h(0, context);
        b4.h(1, adSlot);
        b4.h(2, new com.bytedance.sdk.openadsdk.mediation.c.c.w.c(iMediationDrawAdTokenCallback));
        this.f36099c.call(270022, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        b b4 = b.b(3);
        b4.h(0, context);
        b4.h(1, adSlot);
        b4.h(2, new com.bytedance.sdk.openadsdk.mediation.c.c.w.xv(iMediationNativeAdTokenCallback));
        this.f36099c.call(270021, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i4, ValueSet valueSet) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.h(1, valueSet);
        return this.f36099c.call(271043, b4.l(), Object.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i4, int i5) {
        b b4 = b.b(4);
        b4.h(0, activity);
        b4.h(1, list);
        b4.e(2, i4);
        b4.e(3, i5);
        this.f36099c.call(270013, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        b b4 = b.b(1);
        b4.h(0, context);
        this.f36099c.call(270017, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        b b4 = b.b(1);
        b4.i(0, str);
        this.f36099c.call(270015, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i4) {
        b b4 = b.b(1);
        b4.e(0, i4);
        this.f36099c.call(270019, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        b b4 = b.b(1);
        b4.h(0, mediationConfigUserInfoForSegment);
        this.f36099c.call(270014, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        b b4 = b.b(1);
        b4.h(0, new ux(mediationAppDialogClickListener));
        return ((Integer) this.f36099c.call(270020, b4.l(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updateLocalExtra(Map<String, Object> map) {
        b b4 = b.b(1);
        b4.h(0, map);
        this.f36099c.call(271050, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        b b4 = b.b(1);
        b4.h(0, new gd(tTCustomController));
        this.f36099c.call(270016, b4.l(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        b b4 = b.b(2);
        b4.h(0, context);
        b4.h(1, iArr);
        this.f36099c.call(270018, b4.l(), Void.class);
    }
}
