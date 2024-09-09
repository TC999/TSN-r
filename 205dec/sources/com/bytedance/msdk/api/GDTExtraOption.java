package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GDTExtraOption {

    /* renamed from: a  reason: collision with root package name */
    private boolean f27341a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27342b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27343c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27344d;

    /* renamed from: e  reason: collision with root package name */
    private int f27345e;

    /* renamed from: f  reason: collision with root package name */
    private final int f27346f;

    /* renamed from: g  reason: collision with root package name */
    private final int f27347g;

    /* renamed from: h  reason: collision with root package name */
    private final int f27348h;

    /* renamed from: i  reason: collision with root package name */
    private final int f27349i;

    /* renamed from: j  reason: collision with root package name */
    private final int f27350j;

    /* renamed from: k  reason: collision with root package name */
    private final int f27351k;

    /* renamed from: l  reason: collision with root package name */
    private int f27352l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f27353m;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class BrowserType {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_INNER = 1;
        public static final int TYPE_SYS = 2;
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f27354a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27355b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27356c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f27357d;

        /* renamed from: e  reason: collision with root package name */
        private int f27358e;

        /* renamed from: f  reason: collision with root package name */
        private int f27359f;

        /* renamed from: g  reason: collision with root package name */
        private int f27360g;

        /* renamed from: h  reason: collision with root package name */
        private int f27361h;

        /* renamed from: i  reason: collision with root package name */
        private int f27362i;

        /* renamed from: j  reason: collision with root package name */
        private int f27363j;

        /* renamed from: k  reason: collision with root package name */
        private int f27364k;

        /* renamed from: l  reason: collision with root package name */
        private int f27365l = 1;

        /* renamed from: m  reason: collision with root package name */
        private boolean f27366m;

        public final GDTExtraOption build() {
            return new GDTExtraOption(this);
        }

        public Builder setAutoPlayPolicy(int i4) {
            this.f27360g = i4;
            return this;
        }

        public Builder setBrowserType(int i4) {
            this.f27361h = i4;
            return this;
        }

        public Builder setDownAPPConfirmPolicy(int i4) {
            this.f27362i = i4;
            return this;
        }

        public Builder setFeedExpressType(int i4) {
            this.f27365l = i4;
            return this;
        }

        public Builder setGDTAutoPlayMuted(boolean z3) {
            this.f27355b = z3;
            return this;
        }

        public Builder setGDTDetailPageMuted(boolean z3) {
            this.f27356c = z3;
            return this;
        }

        public Builder setGDTEnableDetailPage(boolean z3) {
            this.f27354a = z3;
            return this;
        }

        public Builder setGDTEnableUserControl(boolean z3) {
            this.f27357d = z3;
            return this;
        }

        public Builder setGDTMaxVideoDuration(int i4) {
            this.f27359f = i4;
            return this;
        }

        public Builder setGDTMinVideoDuration(int i4) {
            this.f27358e = i4;
            return this;
        }

        public Builder setHeight(int i4) {
            this.f27364k = i4;
            return this;
        }

        public Builder setSplashPreLoad(boolean z3) {
            this.f27366m = z3;
            return this;
        }

        public Builder setWidth(int i4) {
            this.f27363j = i4;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class DownAPPConfirmPolicy {
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_NO_CONFIRM = 1;
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class FeedExpressType {
        public static final int FEED_EXPRESS_TYPE_1 = 1;
        public static final int FEED_EXPRESS_TYPE_2 = 2;
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    public int getBrowserType() {
        return this.f27348h;
    }

    public int getDownAPPConfirmPolicy() {
        return this.f27349i;
    }

    public int getFeedExpressType() {
        return this.f27352l;
    }

    public int getGDTAutoPlayPolicy() {
        return this.f27345e;
    }

    public int getGDTMaxVideoDuration() {
        return this.f27347g;
    }

    public int getGDTMinVideoDuration() {
        return this.f27346f;
    }

    public int getHeight() {
        return this.f27351k;
    }

    public int getWidth() {
        return this.f27350j;
    }

    public boolean isGDTAutoPlayMuted() {
        return this.f27342b;
    }

    public boolean isGDTDetailPageMuted() {
        return this.f27343c;
    }

    public boolean isGDTEnableDetailPage() {
        return this.f27341a;
    }

    public boolean isGDTEnableUserControl() {
        return this.f27344d;
    }

    public boolean isSplashPreLoad() {
        return this.f27353m;
    }

    private GDTExtraOption(Builder builder) {
        this.f27341a = true;
        this.f27342b = true;
        this.f27343c = false;
        this.f27344d = false;
        this.f27345e = 0;
        this.f27352l = 1;
        this.f27341a = builder.f27354a;
        this.f27342b = builder.f27355b;
        this.f27343c = builder.f27356c;
        this.f27344d = builder.f27357d;
        this.f27346f = builder.f27358e;
        this.f27347g = builder.f27359f;
        this.f27345e = builder.f27360g;
        this.f27348h = builder.f27361h;
        this.f27349i = builder.f27362i;
        this.f27350j = builder.f27363j;
        this.f27351k = builder.f27364k;
        this.f27352l = builder.f27365l;
        this.f27353m = builder.f27366m;
    }
}
