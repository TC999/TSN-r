package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkApi
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SdkConfig {
    public static final String DEF_NIGHT_THEME_STYLE_FILE_NAME = "ks_adsdk_night_styles.xml";
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 2;
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    @KsAdSdkApi
    @Keep
    public static final int SCREEN_ORIENTATION_UNKNOWN = 0;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appId;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appKey;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appName;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appWebKey;
    @KsAdSdkApi
    @Keep
    private boolean canReadICCID;
    @KsAdSdkApi
    @Keep
    private boolean canReadMacAddress;
    @KsAdSdkApi
    @Keep
    private boolean canReadNearbyWifiList;
    @KsAdSdkApi
    @Keep
    public boolean enableDebug;
    @Nullable
    @KsAdSdkApi
    @Keep
    public KsCustomController ksCustomController;
    @Nullable
    public KsInitCallback ksInitCallback;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String nightThemeStyleAssetsFileName;
    @Nullable
    @KsAdSdkApi
    @Keep
    public boolean showNotification;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsAdSdkApi
    @Keep
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class Builder {
        @Nullable
        private String appId;
        @Nullable
        private String appKey;
        @Nullable
        private String appName;
        @Nullable
        private String appWebKey;
        private boolean enableDebug;
        @Nullable
        private KsCustomController ksCustomController;
        @Nullable
        private KsInitCallback ksInitCallback;
        private boolean showNotification = true;
        private boolean canReadMacAddress = true;
        private boolean canReadNearbyWifiList = true;
        private boolean canReadICCID = true;
        private String nightThemeStyleAssetsFileName = "ks_adsdk_night_styles.xml";

        @KsAdSdkApi
        @Keep
        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appKey(@Nullable String str) {
            this.appKey = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appWebKey(@Nullable String str) {
            this.appWebKey = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public SdkConfig build() {
            return new SdkConfig(this);
        }

        @KsAdSdkApi
        @Keep
        @Deprecated
        public Builder canReadICCID(boolean z3) {
            this.canReadICCID = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        @Deprecated
        public Builder canReadMacAddress(boolean z3) {
            this.canReadMacAddress = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadNearbyWifiList(boolean z3) {
            this.canReadNearbyWifiList = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder customController(KsCustomController ksCustomController) {
            this.ksCustomController = ksCustomController;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder debug(boolean z3) {
            this.enableDebug = z3;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder nightThemeStyleAssetsFileName(@Nullable String str) {
            this.nightThemeStyleAssetsFileName = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setInitCallback(KsInitCallback ksInitCallback) {
            this.ksInitCallback = ksInitCallback;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder showNotification(boolean z3) {
            this.showNotification = z3;
            return this;
        }
    }

    public static SdkConfig create(String str) {
        Builder builder = new Builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.enableDebug = jSONObject.optBoolean("enableDebug");
            builder.appId = jSONObject.optString("appId");
            builder.appName = jSONObject.optString("appName");
            builder.appKey = jSONObject.optString("appKey");
            builder.appWebKey = jSONObject.optString("appWebKey");
            builder.showNotification = jSONObject.optBoolean("showNotification");
            builder.canReadMacAddress = jSONObject.optBoolean("canReadMacAddress");
            builder.canReadNearbyWifiList = jSONObject.optBoolean("canReadNearbyWifiList");
            builder.canReadICCID = jSONObject.optBoolean("canReadICCID");
            builder.nightThemeStyleAssetsFileName = jSONObject.optString("nightThemeStyleAssetsFileName");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return builder.build();
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadICCID() {
        return this.canReadICCID;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadMacAddress() {
        return this.canReadMacAddress;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadNearbyWifiList() {
        return this.canReadNearbyWifiList;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableDebug", this.enableDebug);
            jSONObject.put("appId", this.appId);
            jSONObject.put("appName", this.appName);
            jSONObject.put("appKey", this.appKey);
            jSONObject.put("appWebKey", this.appWebKey);
            jSONObject.put("showNotification", this.showNotification);
            jSONObject.put("canReadMacAddress", this.canReadMacAddress);
            jSONObject.put("canReadNearbyWifiList", this.canReadNearbyWifiList);
            jSONObject.put("canReadICCID", this.canReadICCID);
            jSONObject.put("nightThemeStyleAssetsFileName", this.nightThemeStyleAssetsFileName);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    @KsAdSdkApi
    @Keep
    private SdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appKey = builder.appKey;
        this.appWebKey = builder.appWebKey;
        this.showNotification = builder.showNotification;
        this.canReadMacAddress = builder.canReadMacAddress;
        this.canReadNearbyWifiList = builder.canReadNearbyWifiList;
        this.canReadICCID = builder.canReadICCID;
        this.nightThemeStyleAssetsFileName = builder.nightThemeStyleAssetsFileName;
        this.ksCustomController = builder.ksCustomController;
        this.ksInitCallback = builder.ksInitCallback;
    }
}
