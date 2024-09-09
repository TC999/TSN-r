package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41465a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41466b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41467c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41468d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f41469e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f41470f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f41471g;

    /* renamed from: h  reason: collision with root package name */
    private final int f41472h;

    /* renamed from: i  reason: collision with root package name */
    private final int f41473i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f41474a = true;

        /* renamed from: b  reason: collision with root package name */
        private int f41475b = 1;

        /* renamed from: c  reason: collision with root package name */
        private boolean f41476c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f41477d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f41478e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f41479f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f41480g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f41481h;

        /* renamed from: i  reason: collision with root package name */
        private int f41482i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z3) {
            this.f41474a = z3;
            return this;
        }

        public Builder setAutoPlayPolicy(int i4) {
            if (i4 < 0 || i4 > 2) {
                i4 = 1;
                GDTLogger.e("setAutoPlayPolicy \u8bbe\u7f6e\u5931\u8d25\uff0c\u503c\u53ea\u80fd\u4e3a0\u52302\u4e4b\u95f4\u7684\u6570\u503c, \u91cd\u7f6e\u4e3a : 1");
            }
            this.f41475b = i4;
            return this;
        }

        public Builder setDetailPageMuted(boolean z3) {
            this.f41480g = z3;
            return this;
        }

        public Builder setEnableDetailPage(boolean z3) {
            this.f41478e = z3;
            return this;
        }

        public Builder setEnableUserControl(boolean z3) {
            this.f41479f = z3;
            return this;
        }

        public Builder setMaxVideoDuration(int i4) {
            this.f41481h = i4;
            return this;
        }

        public Builder setMinVideoDuration(int i4) {
            this.f41482i = i4;
            return this;
        }

        public Builder setNeedCoverImage(boolean z3) {
            this.f41477d = z3;
            return this;
        }

        public Builder setNeedProgressBar(boolean z3) {
            this.f41476c = z3;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f41465a = builder.f41474a;
        this.f41466b = builder.f41475b;
        this.f41467c = builder.f41476c;
        this.f41468d = builder.f41477d;
        this.f41469e = builder.f41478e;
        this.f41470f = builder.f41479f;
        this.f41471g = builder.f41480g;
        this.f41472h = builder.f41481h;
        this.f41473i = builder.f41482i;
    }

    public boolean getAutoPlayMuted() {
        return this.f41465a;
    }

    public int getAutoPlayPolicy() {
        return this.f41466b;
    }

    public int getMaxVideoDuration() {
        return this.f41472h;
    }

    public int getMinVideoDuration() {
        return this.f41473i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f41465a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f41466b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f41471g));
        } catch (Exception e4) {
            GDTLogger.d("Get video options error: " + e4.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f41471g;
    }

    public boolean isEnableDetailPage() {
        return this.f41469e;
    }

    public boolean isEnableUserControl() {
        return this.f41470f;
    }

    public boolean isNeedCoverImage() {
        return this.f41468d;
    }

    public boolean isNeedProgressBar() {
        return this.f41467c;
    }
}
