package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f41544a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41545b;

    /* renamed from: c  reason: collision with root package name */
    private final long f41546c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41547d;

    /* renamed from: e  reason: collision with root package name */
    private final String f41548e;

    /* renamed from: f  reason: collision with root package name */
    private final String f41549f;

    /* renamed from: g  reason: collision with root package name */
    private final String f41550g;

    /* renamed from: h  reason: collision with root package name */
    private final String f41551h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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
        this.f41544a = jSONObject.optString("app_name");
        this.f41545b = jSONObject.optString("author_name");
        this.f41546c = jSONObject.optLong("package_size");
        this.f41547d = jSONObject.optString("permission_url");
        this.f41548e = jSONObject.optString("privacy_agreement");
        this.f41549f = jSONObject.optString("version_name");
        this.f41550g = jSONObject.optString("description_url");
        this.f41551h = jSONObject.optString("icp_number");
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f41544a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f41545b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f41550g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f41551h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f41546c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f41547d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f41548e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f41549f;
    }
}
