package com.bytedance.msdk.api;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class TTAdConfig {

    /* renamed from: a */
    private String f21636a;

    /* renamed from: b */
    private String f21637b;

    /* renamed from: c */
    private boolean f21638c;

    /* renamed from: d */
    private boolean f21639d;

    /* renamed from: e */
    private String f21640e;

    /* renamed from: f */
    private boolean f21641f;

    /* renamed from: g */
    private int f21642g;

    /* renamed from: h */
    private String[] f21643h;

    /* renamed from: i */
    private boolean f21644i;

    /* renamed from: j */
    private boolean f21645j;

    /* renamed from: k */
    private int[] f21646k;

    /* renamed from: l */
    private boolean f21647l;

    /* renamed from: m */
    private String f21648m;

    /* renamed from: n */
    private Map<String, String> f21649n;

    /* renamed from: o */
    private TTCustomController f21650o;

    /* renamed from: p */
    private boolean f21651p;

    /* renamed from: q */
    private String f21652q;

    /* renamed from: r */
    private Set<String> f21653r;

    /* renamed from: s */
    private Map<String, Map<String, String>> f21654s;

    /* renamed from: t */
    private Map<String, Map<String, String>> f21655t;

    /* renamed from: u */
    private UserInfoForSegment f21656u;

    /* renamed from: v */
    private int f21657v;

    /* renamed from: w */
    private TTPrivacyConfig f21658w;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: a */
        private String f21659a;

        /* renamed from: b */
        private String f21660b;

        /* renamed from: h */
        private int[] f21666h;

        /* renamed from: j */
        private String[] f21668j;

        /* renamed from: k */
        private String f21669k;

        /* renamed from: m */
        private boolean f21671m;

        /* renamed from: n */
        private String f21672n;

        /* renamed from: p */
        private TTCustomController f21674p;

        /* renamed from: q */
        private String f21675q;

        /* renamed from: r */
        private Set<String> f21676r;

        /* renamed from: s */
        private Map<String, Map<String, String>> f21677s;

        /* renamed from: t */
        private Map<String, Map<String, String>> f21678t;

        /* renamed from: u */
        private UserInfoForSegment f21679u;

        /* renamed from: w */
        private TTPrivacyConfig f21681w;

        /* renamed from: c */
        private boolean f21661c = false;

        /* renamed from: d */
        private boolean f21662d = false;

        /* renamed from: e */
        private int f21663e = 0;

        /* renamed from: f */
        private boolean f21664f = true;

        /* renamed from: g */
        private boolean f21665g = false;

        /* renamed from: i */
        private boolean f21667i = false;

        /* renamed from: l */
        private boolean f21670l = true;

        /* renamed from: o */
        private Map<String, String> f21673o = new HashMap();

        /* renamed from: v */
        private int f21680v = 2;

        public Builder allowPangleShowNotify(boolean z) {
            this.f21664f = z;
            return this;
        }

        public Builder allowPangleShowPageWhenScreenLock(boolean z) {
            this.f21665g = z;
            return this;
        }

        public Builder appId(String str) {
            this.f21659a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f21660b = str;
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this);
        }

        @Deprecated
        public Builder customController(TTCustomController tTCustomController) {
            this.f21674p = tTCustomController;
            return this;
        }

        @Deprecated
        public Builder data(String str) {
            this.f21672n = str;
            return this;
        }

        public Builder dataMap(Map<String, String> map) {
            if (map != null && map.size() > 0) {
                this.f21673o.putAll(map);
            }
            return this;
        }

        public Builder isPanglePaid(boolean z) {
            this.f21662d = z;
            return this;
        }

        public Builder needPangleClearTaskReset(String... strArr) {
            this.f21668j = strArr;
            return this;
        }

        public Builder openAdnTest(boolean z) {
            this.f21671m = z;
            return this;
        }

        public Builder openDebugLog(boolean z) {
            this.f21661c = z;
            return this;
        }

        public Builder setBaiduSdkReadDeviceId(boolean z) {
            this.f21670l = z;
            return this;
        }

        public Builder setKeywords(String str) {
            this.f21675q = str;
            return this;
        }

        public Builder setPangleDirectDownloadNetworkType(int... iArr) {
            this.f21666h = iArr;
            return this;
        }

        public Builder setPangleTitleBarTheme(int i) {
            this.f21663e = i;
            return this;
        }

        public Builder setPrivacyConfig(TTPrivacyConfig tTPrivacyConfig) {
            this.f21681w = tTPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f21669k = str;
            return this;
        }

        public Builder setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
            this.f21679u = userInfoForSegment;
            return this;
        }

        public Builder usePangleTextureView(boolean z) {
            this.f21667i = z;
            return this;
        }

        public Builder data(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f21673o.put(str, str2);
            }
            return this;
        }
    }

    public boolean allowBaiduSdkReadDeviceId() {
        return this.f21651p;
    }

    public Set<String> getAdapterConfigurationClasses() {
        Set<String> set = this.f21653r;
        if (set != null) {
            return Collections.unmodifiableSet(set);
        }
        return null;
    }

    public String getAppId() {
        return this.f21636a;
    }

    public String getAppName() {
        return this.f21637b;
    }

    public Map<String, String> getExtraData() {
        return this.f21649n;
    }

    public Map<String, Map<String, String>> getMediatedNetworkConfigurations() {
        Map<String, Map<String, String>> map = this.f21654s;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    @Deprecated
    public TTCustomController getPangleCustomController() {
        return this.f21650o;
    }

    @Deprecated
    public String getPangleData() {
        return this.f21648m;
    }

    public int[] getPangleDirectDownloadNetworkType() {
        return this.f21646k;
    }

    public String getPangleKeywords() {
        return this.f21652q;
    }

    public String[] getPangleNeedClearTaskReset() {
        return this.f21643h;
    }

    public int getPanglePluginUpdateConfig() {
        return this.f21657v;
    }

    public int getPangleTitleBarTheme() {
        return this.f21642g;
    }

    public TTPrivacyConfig getPrivacyConfig() {
        return this.f21658w;
    }

    public String getPublisherDid() {
        return this.f21640e;
    }

    public Map<String, Map<String, String>> getRequestOptions() {
        Map<String, Map<String, String>> map = this.f21655t;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    public UserInfoForSegment getUserInfoForSegment() {
        return this.f21656u;
    }

    public boolean isDebug() {
        return this.f21638c;
    }

    public boolean isOpenAdnTest() {
        return this.f21641f;
    }

    public boolean isPangleAllowShowNotify() {
        return this.f21644i;
    }

    public boolean isPangleAllowShowPageWhenScreenLock() {
        return this.f21645j;
    }

    public boolean isPanglePaid() {
        return this.f21639d;
    }

    public boolean isPangleUseTextureView() {
        return this.f21647l;
    }

    private TTAdConfig(Builder builder) {
        this.f21638c = false;
        this.f21639d = false;
        this.f21640e = null;
        this.f21642g = 0;
        this.f21644i = true;
        this.f21645j = false;
        this.f21647l = false;
        this.f21651p = true;
        this.f21657v = 2;
        this.f21636a = builder.f21659a;
        this.f21637b = builder.f21660b;
        this.f21638c = builder.f21661c;
        this.f21639d = builder.f21662d;
        this.f21640e = builder.f21669k;
        this.f21641f = builder.f21671m;
        this.f21642g = builder.f21663e;
        this.f21643h = builder.f21668j;
        this.f21644i = builder.f21664f;
        this.f21645j = builder.f21665g;
        this.f21646k = builder.f21666h;
        this.f21647l = builder.f21667i;
        this.f21648m = builder.f21672n;
        this.f21649n = builder.f21673o;
        this.f21650o = builder.f21674p;
        this.f21652q = builder.f21675q;
        this.f21653r = builder.f21676r;
        this.f21654s = builder.f21677s;
        this.f21655t = builder.f21678t;
        this.f21651p = builder.f21670l;
        this.f21656u = builder.f21679u;
        this.f21657v = builder.f21680v;
        this.f21658w = builder.f21681w;
    }
}
