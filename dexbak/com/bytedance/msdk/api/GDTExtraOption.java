package com.bytedance.msdk.api;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GDTExtraOption {

    /* renamed from: a */
    private boolean f21610a;

    /* renamed from: b */
    private boolean f21611b;

    /* renamed from: c */
    private boolean f21612c;

    /* renamed from: d */
    private boolean f21613d;

    /* renamed from: e */
    private int f21614e;

    /* renamed from: f */
    private final int f21615f;

    /* renamed from: g */
    private final int f21616g;

    /* renamed from: h */
    private final int f21617h;

    /* renamed from: i */
    private final int f21618i;

    /* renamed from: j */
    private final int f21619j;

    /* renamed from: k */
    private final int f21620k;

    /* renamed from: l */
    private int f21621l;

    /* renamed from: m */
    private boolean f21622m;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class BrowserType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_INNER = 1;
        public static final int TYPE_SYS = 2;
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f21623a;

        /* renamed from: b */
        private boolean f21624b;

        /* renamed from: c */
        private boolean f21625c;

        /* renamed from: d */
        private boolean f21626d;

        /* renamed from: e */
        private int f21627e;

        /* renamed from: f */
        private int f21628f;

        /* renamed from: g */
        private int f21629g;

        /* renamed from: h */
        private int f21630h;

        /* renamed from: i */
        private int f21631i;

        /* renamed from: j */
        private int f21632j;

        /* renamed from: k */
        private int f21633k;

        /* renamed from: l */
        private int f21634l = 1;

        /* renamed from: m */
        private boolean f21635m;

        public final GDTExtraOption build() {
            return new GDTExtraOption(this);
        }

        public Builder setAutoPlayPolicy(int i) {
            this.f21629g = i;
            return this;
        }

        public Builder setBrowserType(int i) {
            this.f21630h = i;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i) {
            this.f21631i = i;
            return this;
        }

        public Builder setFeedExpressType(int i) {
            this.f21634l = i;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z) {
            this.f21624b = z;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z) {
            this.f21625c = z;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z) {
            this.f21623a = z;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z) {
            this.f21626d = z;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i) {
            this.f21628f = i;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i) {
            this.f21627e = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.f21633k = i;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.f21635m = z;
            return this;
        }

        public Builder setWidth(int i) {
            this.f21632j = i;
            return this;
        }
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class FeedExpressType {
        public static final int FEED_EXPRESS_TYPE_1 = 1;
        public static final int FEED_EXPRESS_TYPE_2 = 2;
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    public int getBrowserType() {
        return this.f21617h;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f21618i;
    }

    public int getFeedExpressType() {
        return this.f21621l;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f21614e;
    }

    public int getGDTMaxVideoDuration() {
        return this.f21616g;
    }

    public int getGDTMinVideoDuration() {
        return this.f21615f;
    }

    public int getHeight() {
        return this.f21620k;
    }

    public int getWidth() {
        return this.f21619j;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.f21611b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f21612c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.f21610a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f21613d;
    }

    public boolean isSplashPreLoad() {
        return this.f21622m;
    }

    private GDTExtraOption(Builder builder) {
        this.f21610a = true;
        this.f21611b = true;
        this.f21612c = false;
        this.f21613d = false;
        this.f21614e = 0;
        this.f21621l = 1;
        this.f21610a = builder.f21623a;
        this.f21611b = builder.f21624b;
        this.f21612c = builder.f21625c;
        this.f21613d = builder.f21626d;
        this.f21615f = builder.f21627e;
        this.f21616g = builder.f21628f;
        this.f21614e = builder.f21629g;
        this.f21617h = builder.f21630h;
        this.f21618i = builder.f21631i;
        this.f21619j = builder.f21632j;
        this.f21620k = builder.f21633k;
        this.f21621l = builder.f21634l;
        this.f21622m = builder.f21635m;
    }
}
