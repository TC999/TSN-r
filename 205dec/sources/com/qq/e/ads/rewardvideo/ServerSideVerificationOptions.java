package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    private String f41569a;

    /* renamed from: b  reason: collision with root package name */
    private String f41570b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f41571c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f41572a;

        /* renamed from: b  reason: collision with root package name */
        private String f41573b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f41572a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f41573b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f41571c = new JSONObject();
        this.f41569a = builder.f41572a;
        this.f41570b = builder.f41573b;
    }

    public String getCustomData() {
        return this.f41569a;
    }

    public JSONObject getOptions() {
        return this.f41571c;
    }

    public String getUserId() {
        return this.f41570b;
    }
}
