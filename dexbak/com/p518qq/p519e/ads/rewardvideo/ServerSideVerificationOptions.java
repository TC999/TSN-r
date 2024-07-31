package com.p518qq.p519e.ads.rewardvideo;

import org.json.JSONObject;

/* renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a */
    private String f32854a;

    /* renamed from: b */
    private String f32855b;

    /* renamed from: c */
    private final JSONObject f32856c;

    /* renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$Builder */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class Builder {

        /* renamed from: a */
        private String f32857a;

        /* renamed from: b */
        private String f32858b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f32857a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f32858b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f32856c = new JSONObject();
        this.f32854a = builder.f32857a;
        this.f32855b = builder.f32858b;
    }

    public String getCustomData() {
        return this.f32854a;
    }

    public JSONObject getOptions() {
        return this.f32856c;
    }

    public String getUserId() {
        return this.f32855b;
    }
}
