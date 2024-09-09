package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTVideoOption {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27420a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27421b;

    /* renamed from: c  reason: collision with root package name */
    private float f27422c;

    /* renamed from: d  reason: collision with root package name */
    private GDTExtraOption f27423d;

    /* renamed from: e  reason: collision with root package name */
    private BaiduExtraOptions f27424e;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27425a = true;

        /* renamed from: b  reason: collision with root package name */
        private float f27426b;

        /* renamed from: c  reason: collision with root package name */
        private GDTExtraOption f27427c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27428d;

        /* renamed from: e  reason: collision with root package name */
        private BaiduExtraOptions f27429e;

        public final TTVideoOption build() {
            return new TTVideoOption(this);
        }

        public Builder setAdmobAppVolume(float f4) {
            if (f4 > 1.0f) {
                f4 = 1.0f;
            } else if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            this.f27426b = f4;
            return this;
        }

        public Builder setBaiduExtraOption(BaiduExtraOptions baiduExtraOptions) {
            this.f27429e = baiduExtraOptions;
            return this;
        }

        public Builder setGDTExtraOption(GDTExtraOption gDTExtraOption) {
            this.f27427c = gDTExtraOption;
            return this;
        }

        public final Builder setMuted(boolean z3) {
            this.f27425a = z3;
            return this;
        }

        public final Builder useSurfaceView(boolean z3) {
            this.f27428d = z3;
            return this;
        }
    }

    public float getAdmobAppVolume() {
        return this.f27422c;
    }

    public BaiduExtraOptions getBaiduExtraOption() {
        return this.f27424e;
    }

    public GDTExtraOption getGDTExtraOption() {
        return this.f27423d;
    }

    public boolean isMuted() {
        return this.f27420a;
    }

    public boolean useSurfaceView() {
        return this.f27421b;
    }

    private TTVideoOption(Builder builder) {
        this.f27420a = builder.f27425a;
        this.f27422c = builder.f27426b;
        this.f27423d = builder.f27427c;
        this.f27421b = builder.f27428d;
        this.f27424e = builder.f27429e;
    }
}
