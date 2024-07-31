package com.bytedance.msdk.api;

import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BaiduRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;

    /* renamed from: a */
    private final String f21597a;

    /* renamed from: b */
    private boolean f21598b;

    /* renamed from: c */
    private Map<String, String> f21599c;

    /* renamed from: d */
    private int f21600d;

    /* renamed from: e */
    private int f21601e;

    /* renamed from: f */
    private int f21602f;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class Builder {

        /* renamed from: a */
        private String f21603a;

        /* renamed from: b */
        private Map<String, String> f21604b = new HashMap();

        /* renamed from: c */
        private boolean f21605c = false;

        /* renamed from: d */
        private int f21606d = 640;

        /* renamed from: e */
        private int f21607e = 480;

        /* renamed from: f */
        private int f21608f = 1;

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.f21604b.put(IAdInterListener.AdReqParam.MPT, String.valueOf(1));
            }
            this.f21604b.put(str, str2);
            return this;
        }

        public final BaiduRequestParameters build() {
            return new BaiduRequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i) {
            this.f21608f = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f21607e = i;
            return this;
        }

        public final Builder setKeywords(String str) {
            this.f21603a = str;
            return this;
        }

        public final Builder setWidth(int i) {
            this.f21606d = i;
            return this;
        }
    }

    public int getAPPConfirmPolicy() {
        return this.f21602f;
    }

    public Map<String, String> getExtras() {
        return this.f21599c;
    }

    public int getHeight() {
        return this.f21601e;
    }

    public final String getKeywords() {
        return this.f21597a;
    }

    public int getWidth() {
        return this.f21600d;
    }

    public boolean isConfirmDownloading() {
        return this.f21598b;
    }

    public void setExtras(Map<String, String> map) {
        this.f21599c = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.f21597a);
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f21598b));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.f21599c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }

    private BaiduRequestParameters(Builder builder) {
        this.f21600d = 0;
        this.f21601e = 0;
        this.f21597a = builder.f21603a;
        this.f21600d = builder.f21606d;
        this.f21601e = builder.f21607e;
        this.f21598b = builder.f21605c;
        this.f21602f = builder.f21608f;
        setExtras(builder.f21604b);
    }
}
