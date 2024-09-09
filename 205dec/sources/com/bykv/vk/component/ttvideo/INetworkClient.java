package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

@Keep
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface INetworkClient {

    @Keep
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class Result {
        public final String body;
        public final int code;

        /* renamed from: e  reason: collision with root package name */
        public final Exception f24809e;
        public final String header;
        public final JSONObject response;

        @Keep
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static class Builder {
            String body;
            int code;

            /* renamed from: e  reason: collision with root package name */
            Exception f24810e;
            String header;
            JSONObject response;

            public Result build() {
                return new Result(this);
            }

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setCode(int i4) {
                this.code = i4;
                return this;
            }

            public Builder setException(Exception exc) {
                this.f24810e = exc;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }

            private Builder() {
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.f24809e = builder.f24810e;
            this.code = builder.code;
        }
    }

    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);
}
