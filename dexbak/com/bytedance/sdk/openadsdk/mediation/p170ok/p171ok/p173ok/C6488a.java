package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok;

import android.app.Activity;
import android.content.Context;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6477bl;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6478n;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6479ok;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6382q;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6488a implements IMediationManager {

    /* renamed from: ok */
    private final Bridge f22856ok;

    public C6488a(Bridge bridge) {
        this.f22856ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        return (Map) this.f22856ok.call(270024, C5930a.m37924c(0).m37926a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, context);
        m37924c.m37919h(1, adSlot);
        m37924c.m37919h(2, new C6479ok(iMediationDrawAdTokenCallback));
        this.f22856ok.call(270022, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        C5930a m37924c = C5930a.m37924c(3);
        m37924c.m37919h(0, context);
        m37924c.m37919h(1, adSlot);
        m37924c.m37919h(2, new C6477bl(iMediationNativeAdTokenCallback));
        this.f22856ok.call(270021, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i, ValueSet valueSet) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37921f(0, i);
        m37924c.m37919h(1, valueSet);
        return this.f22856ok.call(271043, m37924c.m37926a(), Object.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        C5930a m37924c = C5930a.m37924c(4);
        m37924c.m37919h(0, activity);
        m37924c.m37919h(1, list);
        m37924c.m37921f(2, i);
        m37924c.m37921f(3, i2);
        this.f22856ok.call(270013, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, context);
        this.f22856ok.call(270017, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37918i(0, str);
        this.f22856ok.call(270015, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37921f(0, i);
        this.f22856ok.call(270019, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, mediationConfigUserInfoForSegment);
        this.f22856ok.call(270014, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6478n(mediationAppDialogClickListener));
        return ((Integer) this.f22856ok.call(270020, m37924c.m37926a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6382q(tTCustomController));
        this.f22856ok.call(270016, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37919h(0, context);
        m37924c.m37919h(1, iArr);
        this.f22856ok.call(270018, m37924c.m37926a(), Void.class);
    }
}
