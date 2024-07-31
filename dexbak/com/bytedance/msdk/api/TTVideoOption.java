package com.bytedance.msdk.api;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTVideoOption {

    /* renamed from: a */
    private final boolean f21689a;

    /* renamed from: b */
    private final boolean f21690b;

    /* renamed from: c */
    private float f21691c;

    /* renamed from: d */
    private GDTExtraOption f21692d;

    /* renamed from: e */
    private BaiduExtraOptions f21693e;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f21694a = true;

        /* renamed from: b */
        private float f21695b;

        /* renamed from: c */
        private GDTExtraOption f21696c;

        /* renamed from: d */
        private boolean f21697d;

        /* renamed from: e */
        private BaiduExtraOptions f21698e;

        public final TTVideoOption build() {
            return new TTVideoOption(this);
        }

        public Builder setAdmobAppVolume(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            this.f21695b = f;
            return this;
        }

        public Builder setBaiduExtraOption(BaiduExtraOptions baiduExtraOptions) {
            this.f21698e = baiduExtraOptions;
            return this;
        }

        public Builder setGDTExtraOption(GDTExtraOption gDTExtraOption) {
            this.f21696c = gDTExtraOption;
            return this;
        }

        public final Builder setMuted(boolean z) {
            this.f21694a = z;
            return this;
        }

        public final Builder useSurfaceView(boolean z) {
            this.f21697d = z;
            return this;
        }
    }

    public float getAdmobAppVolume() {
        return this.f21691c;
    }

    public BaiduExtraOptions getBaiduExtraOption() {
        return this.f21693e;
    }

    public GDTExtraOption getGDTExtraOption() {
        return this.f21692d;
    }

    public boolean isMuted() {
        return this.f21689a;
    }

    public boolean useSurfaceView() {
        return this.f21690b;
    }

    private TTVideoOption(Builder builder) {
        this.f21689a = builder.f21694a;
        this.f21691c = builder.f21695b;
        this.f21692d = builder.f21696c;
        this.f21690b = builder.f21697d;
        this.f21693e = builder.f21698e;
    }
}
