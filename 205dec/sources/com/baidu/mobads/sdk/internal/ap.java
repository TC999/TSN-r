package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ap implements IPromoteInstallAdInfo {

    /* renamed from: a  reason: collision with root package name */
    private final aq f12393a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12394b;

    /* renamed from: c  reason: collision with root package name */
    private String f12395c;

    /* renamed from: d  reason: collision with root package name */
    private String f12396d;

    /* renamed from: e  reason: collision with root package name */
    private String f12397e;

    /* renamed from: f  reason: collision with root package name */
    private String f12398f;

    /* renamed from: g  reason: collision with root package name */
    private String f12399g;

    /* renamed from: h  reason: collision with root package name */
    private String f12400h;

    /* renamed from: i  reason: collision with root package name */
    private String f12401i;

    /* renamed from: j  reason: collision with root package name */
    private String f12402j;

    /* renamed from: k  reason: collision with root package name */
    private String f12403k;

    public ap(JSONObject jSONObject, Context context, aq aqVar) {
        this.f12393a = aqVar;
        this.f12394b = context;
        try {
            this.f12395c = jSONObject.optString("pk");
            this.f12396d = jSONObject.optString(RewardPlus.ICON);
            this.f12397e = jSONObject.optString("appname");
            this.f12398f = jSONObject.optString("bidlayer");
            this.f12399g = jSONObject.optString("publisher");
            this.f12400h = jSONObject.optString("app_version");
            this.f12401i = jSONObject.optString("privacy_link");
            this.f12402j = jSONObject.optString("permission_link");
            this.f12403k = jSONObject.optString("function_link");
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppPublisher() {
        return this.f12399g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppVersion() {
        return this.f12400h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getBrandName() {
        return this.f12397e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getECPMLevel() {
        return this.f12398f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getFunctionUrl() {
        return this.f12403k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getIconUrl() {
        return this.f12396d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPermissionUrl() {
        return this.f12402j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPrivacyUrl() {
        return this.f12401i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getUnionLogoUrl() {
        return "http://union.baidu.com";
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        aq aqVar = this.f12393a;
        if (aqVar != null) {
            aqVar.a(this.f12394b, this.f12395c);
        }
    }
}
