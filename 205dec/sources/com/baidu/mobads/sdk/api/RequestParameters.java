package com.baidu.mobads.sdk.api;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class RequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    private int adsType;
    private boolean confirmDownloading;
    private Map<String, String> customExt;
    private boolean customSize;
    private int downloadAppConfirmPolicy;
    private Map<String, String> extras;
    private int height;
    private String mAdPlaceId;
    private int mBidFloor;
    private final String mKeywords;
    private int width;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private String adPlaceId;
        private String keywords;
        private Map<String, String> extras = new HashMap();
        private Map<String, String> customExt = new HashMap();
        private int adsType = 3;
        private boolean clickConfirm = false;
        private int width = 640;
        private int height = 480;
        private int downloadAppConfirmPolicy = 1;
        private boolean customSize = false;
        private int bidFloor = -1;

        public final Builder addCustExt(String str, String str2) {
            this.customExt.put(str, str2);
            return this;
        }

        public final Builder addExtra(String str, String str2) {
            this.extras.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
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
            this.downloadAppConfirmPolicy = i4;
            return this;
        }

        public final Builder setAdPlaceId(String str) {
            this.adPlaceId = str;
            return this;
        }

        public final Builder setBidFloor(int i4) {
            this.bidFloor = i4;
            return this;
        }

        public final Builder setHeight(int i4) {
            this.height = i4;
            this.customSize = true;
            return this;
        }

        public final Builder setWidth(int i4) {
            this.width = i4;
            this.customSize = true;
            return this;
        }
    }

    public int getAPPConfirmPolicy() {
        return this.downloadAppConfirmPolicy;
    }

    public String getAdPlacementId() {
        return this.mAdPlaceId;
    }

    public int getAdsType() {
        return this.adsType;
    }

    public int getBidFloor() {
        return this.mBidFloor;
    }

    public Map<String, String> getExt() {
        return this.customExt;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public int getHeight() {
        return this.height;
    }

    public final String getKeywords() {
        return this.mKeywords;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isConfirmDownloading() {
        return this.confirmDownloading;
    }

    public boolean isCustomSize() {
        return this.customSize;
    }

    public void setAdsType(int i4) {
        this.adsType = i4;
    }

    public void setExt(Map<String, String> map) {
        this.customExt = map;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mKeywords", this.mKeywords);
        hashMap.put("adsType", Integer.valueOf(this.adsType));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.confirmDownloading));
        HashMap hashMap2 = new HashMap();
        Map<String, String> map = this.extras;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        HashMap hashMap3 = new HashMap();
        Map<String, String> map2 = this.customExt;
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                hashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        hashMap.put("ext", hashMap3);
        return hashMap;
    }

    private RequestParameters(Builder builder) {
        this.width = 0;
        this.height = 0;
        this.mBidFloor = -1;
        this.mKeywords = builder.keywords;
        this.adsType = builder.adsType;
        this.width = builder.width;
        this.height = builder.height;
        this.customSize = builder.customSize;
        this.confirmDownloading = builder.clickConfirm;
        this.downloadAppConfirmPolicy = builder.downloadAppConfirmPolicy;
        this.mAdPlaceId = builder.adPlaceId;
        this.mBidFloor = builder.bidFloor;
        setExtras(builder.extras);
        setExt(builder.customExt);
    }
}
