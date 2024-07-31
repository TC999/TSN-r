package com.p518qq.p519e.ads.cfg;

import com.p518qq.p519e.comm.util.GDTLogger;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.cfg.VideoOption */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class VideoOption {

    /* renamed from: a */
    private final boolean f32750a;

    /* renamed from: b */
    private final int f32751b;

    /* renamed from: c */
    private final boolean f32752c;

    /* renamed from: d */
    private final boolean f32753d;

    /* renamed from: e */
    private final boolean f32754e;

    /* renamed from: f */
    private final boolean f32755f;

    /* renamed from: g */
    private final boolean f32756g;

    /* renamed from: h */
    private final int f32757h;

    /* renamed from: i */
    private final int f32758i;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$AutoPlayPolicy */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* renamed from: com.qq.e.ads.cfg.VideoOption$Builder */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f32759a = true;

        /* renamed from: b */
        private int f32760b = 1;

        /* renamed from: c */
        private boolean f32761c = true;

        /* renamed from: d */
        private boolean f32762d = true;

        /* renamed from: e */
        private boolean f32763e = true;

        /* renamed from: f */
        private boolean f32764f = false;

        /* renamed from: g */
        private boolean f32765g = false;

        /* renamed from: h */
        private int f32766h;

        /* renamed from: i */
        private int f32767i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f32759a = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                i = 1;
                GDTLogger.m20307e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.f32760b = i;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f32765g = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.f32763e = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.f32764f = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f32766h = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f32767i = i;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.f32762d = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.f32761c = z;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f32750a = builder.f32759a;
        this.f32751b = builder.f32760b;
        this.f32752c = builder.f32761c;
        this.f32753d = builder.f32762d;
        this.f32754e = builder.f32763e;
        this.f32755f = builder.f32764f;
        this.f32756g = builder.f32765g;
        this.f32757h = builder.f32766h;
        this.f32758i = builder.f32767i;
    }

    public boolean getAutoPlayMuted() {
        return this.f32750a;
    }

    public int getAutoPlayPolicy() {
        return this.f32751b;
    }

    public int getMaxVideoDuration() {
        return this.f32757h;
    }

    public int getMinVideoDuration() {
        return this.f32758i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f32750a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f32751b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f32756g));
        } catch (Exception e) {
            GDTLogger.m20308d("Get video options error: " + e.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f32756g;
    }

    public boolean isEnableDetailPage() {
        return this.f32754e;
    }

    public boolean isEnableUserControl() {
        return this.f32755f;
    }

    public boolean isNeedCoverImage() {
        return this.f32753d;
    }

    public boolean isNeedProgressBar() {
        return this.f32752c;
    }
}
