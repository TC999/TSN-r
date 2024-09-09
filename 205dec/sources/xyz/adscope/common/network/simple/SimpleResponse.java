package xyz.adscope.common.network.simple;

import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class SimpleResponse<Succeed, Failed> {

    /* renamed from: a  reason: collision with root package name */
    public final int f64999a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f65000b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f65001c;

    /* renamed from: d  reason: collision with root package name */
    public final Succeed f65002d;

    /* renamed from: e  reason: collision with root package name */
    public final Failed f65003e;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static final class Builder<Succeed, Failed> {

        /* renamed from: a  reason: collision with root package name */
        public int f65004a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f65005b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65006c;

        /* renamed from: d  reason: collision with root package name */
        public Failed f65007d;

        /* renamed from: e  reason: collision with root package name */
        public Succeed f65008e;

        public Builder() {
        }

        public SimpleResponse<Succeed, Failed> build() {
            return new SimpleResponse<>(this);
        }

        public Builder<Succeed, Failed> code(int i4) {
            this.f65004a = i4;
            return this;
        }

        public Builder<Succeed, Failed> failed(Failed failed) {
            this.f65007d = failed;
            return this;
        }

        public Builder<Succeed, Failed> fromCache(boolean z3) {
            this.f65006c = z3;
            return this;
        }

        public Builder<Succeed, Failed> headers(Headers headers) {
            this.f65005b = headers;
            return this;
        }

        public Builder<Succeed, Failed> succeed(Succeed succeed) {
            this.f65008e = succeed;
            return this;
        }
    }

    public SimpleResponse(Builder<Succeed, Failed> builder) {
        this.f64999a = builder.f65004a;
        this.f65000b = builder.f65005b;
        this.f65001c = builder.f65006c;
        this.f65002d = (Succeed) builder.f65008e;
        this.f65003e = (Failed) builder.f65007d;
    }

    public static <Succeed, Failed> Builder<Succeed, Failed> newBuilder() {
        return new Builder<>();
    }

    public int code() {
        return this.f64999a;
    }

    public Failed failed() {
        return this.f65003e;
    }

    public boolean fromCache() {
        return this.f65001c;
    }

    public Headers headers() {
        return this.f65000b;
    }

    public boolean isSucceed() {
        return this.f65003e == null || this.f65002d != null;
    }

    public Succeed succeed() {
        return this.f65002d;
    }
}
