package com.bytedance.msdk.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BaiduRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;

    /* renamed from: a  reason: collision with root package name */
    private final String f27328a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27329b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f27330c;

    /* renamed from: d  reason: collision with root package name */
    private int f27331d;

    /* renamed from: e  reason: collision with root package name */
    private int f27332e;

    /* renamed from: f  reason: collision with root package name */
    private int f27333f;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f27334a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f27335b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private boolean f27336c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f27337d = 640;

        /* renamed from: e  reason: collision with root package name */
        private int f27338e = 480;

        /* renamed from: f  reason: collision with root package name */
        private int f27339f = 1;

        public final Builder addExtra(String str, String str2) {
            if ("page_title".equals(str)) {
                this.f27335b.put("mpt", String.valueOf(1));
            }
            this.f27335b.put(str, str2);
            return this;
        }

        public final BaiduRequestParameters build() {
            return new BaiduRequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z3) {
            if (z3) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i4) {
            this.f27339f = i4;
            return this;
        }

        public final Builder setHeight(int i4) {
            this.f27338e = i4;
            return this;
        }

        public final Builder setKeywords(String str) {
            this.f27334a = str;
            return this;
        }

        public final Builder setWidth(int i4) {
            this.f27337d = i4;
            return this;
        }
    }

    public int getAPPConfirmPolicy() {
        return this.f27333f;
    }

    public Map<String, String> getExtras() {
        return this.f27330c;
    }

    public int getHeight() {
        return this.f27332e;
    }

    public final String getKeywords() {
        return this.f27328a;
    }

    public int getWidth() {
        return this.f27331d;
    }

    public boolean isConfirmDownloading() {
        return this.f27329b;
    }

    public void setExtras(Map<String, String> map) {
        this.f27330c = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.f27328a);
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f27329b));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.f27330c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }

    private BaiduRequestParameters(Builder builder) {
        this.f27331d = 0;
        this.f27332e = 0;
        this.f27328a = builder.f27334a;
        this.f27331d = builder.f27337d;
        this.f27332e = builder.f27338e;
        this.f27329b = builder.f27336c;
        this.f27333f = builder.f27339f;
        setExtras(builder.f27335b);
    }
}
