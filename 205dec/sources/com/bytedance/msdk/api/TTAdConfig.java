package com.bytedance.msdk.api;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class TTAdConfig {

    /* renamed from: a  reason: collision with root package name */
    private String f27367a;

    /* renamed from: b  reason: collision with root package name */
    private String f27368b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27369c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27370d;

    /* renamed from: e  reason: collision with root package name */
    private String f27371e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27372f;

    /* renamed from: g  reason: collision with root package name */
    private int f27373g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f27374h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27375i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f27376j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f27377k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27378l;

    /* renamed from: m  reason: collision with root package name */
    private String f27379m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, String> f27380n;

    /* renamed from: o  reason: collision with root package name */
    private TTCustomController f27381o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f27382p;

    /* renamed from: q  reason: collision with root package name */
    private String f27383q;

    /* renamed from: r  reason: collision with root package name */
    private Set<String> f27384r;

    /* renamed from: s  reason: collision with root package name */
    private Map<String, Map<String, String>> f27385s;

    /* renamed from: t  reason: collision with root package name */
    private Map<String, Map<String, String>> f27386t;

    /* renamed from: u  reason: collision with root package name */
    private UserInfoForSegment f27387u;

    /* renamed from: v  reason: collision with root package name */
    private int f27388v;

    /* renamed from: w  reason: collision with root package name */
    private TTPrivacyConfig f27389w;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f27390a;

        /* renamed from: b  reason: collision with root package name */
        private String f27391b;

        /* renamed from: h  reason: collision with root package name */
        private int[] f27397h;

        /* renamed from: j  reason: collision with root package name */
        private String[] f27399j;

        /* renamed from: k  reason: collision with root package name */
        private String f27400k;

        /* renamed from: m  reason: collision with root package name */
        private boolean f27402m;

        /* renamed from: n  reason: collision with root package name */
        private String f27403n;

        /* renamed from: p  reason: collision with root package name */
        private TTCustomController f27405p;

        /* renamed from: q  reason: collision with root package name */
        private String f27406q;

        /* renamed from: r  reason: collision with root package name */
        private Set<String> f27407r;

        /* renamed from: s  reason: collision with root package name */
        private Map<String, Map<String, String>> f27408s;

        /* renamed from: t  reason: collision with root package name */
        private Map<String, Map<String, String>> f27409t;

        /* renamed from: u  reason: collision with root package name */
        private UserInfoForSegment f27410u;

        /* renamed from: w  reason: collision with root package name */
        private TTPrivacyConfig f27412w;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27392c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27393d = false;

        /* renamed from: e  reason: collision with root package name */
        private int f27394e = 0;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27395f = true;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27396g = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f27398i = false;

        /* renamed from: l  reason: collision with root package name */
        private boolean f27401l = true;

        /* renamed from: o  reason: collision with root package name */
        private Map<String, String> f27404o = new HashMap();

        /* renamed from: v  reason: collision with root package name */
        private int f27411v = 2;

        public Builder allowPangleShowNotify(boolean z3) {
            this.f27395f = z3;
            return this;
        }

        public Builder allowPangleShowPageWhenScreenLock(boolean z3) {
            this.f27396g = z3;
            return this;
        }

        public Builder appId(String str) {
            this.f27390a = str;
            return this;
        }

        public Builder appName(String str) {
            this.f27391b = str;
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this);
        }

        @Deprecated
        public Builder customController(TTCustomController tTCustomController) {
            this.f27405p = tTCustomController;
            return this;
        }

        @Deprecated
        public Builder data(String str) {
            this.f27403n = str;
            return this;
        }

        public Builder dataMap(Map<String, String> map) {
            if (map != null && map.size() > 0) {
                this.f27404o.putAll(map);
            }
            return this;
        }

        public Builder isPanglePaid(boolean z3) {
            this.f27393d = z3;
            return this;
        }

        public Builder needPangleClearTaskReset(String... strArr) {
            this.f27399j = strArr;
            return this;
        }

        public Builder openAdnTest(boolean z3) {
            this.f27402m = z3;
            return this;
        }

        public Builder openDebugLog(boolean z3) {
            this.f27392c = z3;
            return this;
        }

        public Builder setBaiduSdkReadDeviceId(boolean z3) {
            this.f27401l = z3;
            return this;
        }

        public Builder setKeywords(String str) {
            this.f27406q = str;
            return this;
        }

        public Builder setPangleDirectDownloadNetworkType(int... iArr) {
            this.f27397h = iArr;
            return this;
        }

        public Builder setPangleTitleBarTheme(int i4) {
            this.f27394e = i4;
            return this;
        }

        public Builder setPrivacyConfig(TTPrivacyConfig tTPrivacyConfig) {
            this.f27412w = tTPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f27400k = str;
            return this;
        }

        public Builder setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
            this.f27410u = userInfoForSegment;
            return this;
        }

        public Builder usePangleTextureView(boolean z3) {
            this.f27398i = z3;
            return this;
        }

        public Builder data(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f27404o.put(str, str2);
            }
            return this;
        }
    }

    public boolean allowBaiduSdkReadDeviceId() {
        return this.f27382p;
    }

    public Set<String> getAdapterConfigurationClasses() {
        Set<String> set = this.f27384r;
        if (set != null) {
            return Collections.unmodifiableSet(set);
        }
        return null;
    }

    public String getAppId() {
        return this.f27367a;
    }

    public String getAppName() {
        return this.f27368b;
    }

    public Map<String, String> getExtraData() {
        return this.f27380n;
    }

    public Map<String, Map<String, String>> getMediatedNetworkConfigurations() {
        Map<String, Map<String, String>> map = this.f27385s;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    @Deprecated
    public TTCustomController getPangleCustomController() {
        return this.f27381o;
    }

    @Deprecated
    public String getPangleData() {
        return this.f27379m;
    }

    public int[] getPangleDirectDownloadNetworkType() {
        return this.f27377k;
    }

    public String getPangleKeywords() {
        return this.f27383q;
    }

    public String[] getPangleNeedClearTaskReset() {
        return this.f27374h;
    }

    public int getPanglePluginUpdateConfig() {
        return this.f27388v;
    }

    public int getPangleTitleBarTheme() {
        return this.f27373g;
    }

    public TTPrivacyConfig getPrivacyConfig() {
        return this.f27389w;
    }

    public String getPublisherDid() {
        return this.f27371e;
    }

    public Map<String, Map<String, String>> getRequestOptions() {
        Map<String, Map<String, String>> map = this.f27386t;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    public UserInfoForSegment getUserInfoForSegment() {
        return this.f27387u;
    }

    public boolean isDebug() {
        return this.f27369c;
    }

    public boolean isOpenAdnTest() {
        return this.f27372f;
    }

    public boolean isPangleAllowShowNotify() {
        return this.f27375i;
    }

    public boolean isPangleAllowShowPageWhenScreenLock() {
        return this.f27376j;
    }

    public boolean isPanglePaid() {
        return this.f27370d;
    }

    public boolean isPangleUseTextureView() {
        return this.f27378l;
    }

    private TTAdConfig(Builder builder) {
        this.f27369c = false;
        this.f27370d = false;
        this.f27371e = null;
        this.f27373g = 0;
        this.f27375i = true;
        this.f27376j = false;
        this.f27378l = false;
        this.f27382p = true;
        this.f27388v = 2;
        this.f27367a = builder.f27390a;
        this.f27368b = builder.f27391b;
        this.f27369c = builder.f27392c;
        this.f27370d = builder.f27393d;
        this.f27371e = builder.f27400k;
        this.f27372f = builder.f27402m;
        this.f27373g = builder.f27394e;
        this.f27374h = builder.f27399j;
        this.f27375i = builder.f27395f;
        this.f27376j = builder.f27396g;
        this.f27377k = builder.f27397h;
        this.f27378l = builder.f27398i;
        this.f27379m = builder.f27403n;
        this.f27380n = builder.f27404o;
        this.f27381o = builder.f27405p;
        this.f27383q = builder.f27406q;
        this.f27384r = builder.f27407r;
        this.f27385s = builder.f27408s;
        this.f27386t = builder.f27409t;
        this.f27382p = builder.f27401l;
        this.f27387u = builder.f27410u;
        this.f27388v = builder.f27411v;
        this.f27389w = builder.f27412w;
    }
}
