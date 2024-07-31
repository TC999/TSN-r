package com.p518qq.p519e.ads.nativ;

import org.json.JSONObject;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a */
    private final String f32829a;

    /* renamed from: b */
    private final String f32830b;

    /* renamed from: c */
    private final long f32831c;

    /* renamed from: d */
    private final String f32832d;

    /* renamed from: e */
    private final String f32833e;

    /* renamed from: f */
    private final String f32834f;

    /* renamed from: g */
    private final String f32835g;

    /* renamed from: h */
    private final String f32836h;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl$Keys */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f32829a = jSONObject.optString("app_name");
        this.f32830b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f32831c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f32832d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f32833e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f32834f = jSONObject.optString(Keys.VERSION_NAME);
        this.f32835g = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.f32836h = jSONObject.optString(Keys.ICP_NUMBER);
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f32829a;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f32830b;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f32835g;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f32836h;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f32831c;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f32832d;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f32833e;
    }

    @Override // com.p518qq.p519e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f32834f;
    }
}
