package com.bytedance.msdk.api.nativeAd;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    @NonNull
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int sourceId;
    public final int titleId;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Builder {

        /* renamed from: a */
        private final int f21726a;

        /* renamed from: b */
        private int f21727b;

        /* renamed from: c */
        private int f21728c;

        /* renamed from: d */
        private int f21729d;

        /* renamed from: e */
        private int f21730e;

        /* renamed from: f */
        private int f21731f;

        /* renamed from: g */
        private int f21732g;

        /* renamed from: h */
        private int f21733h;

        /* renamed from: i */
        private int f21734i;

        /* renamed from: j */
        private int f21735j;

        /* renamed from: k */
        private int f21736k;

        /* renamed from: l */
        private int f21737l;
        @NonNull

        /* renamed from: m */
        private Map<String, Integer> f21738m;

        public Builder(int i) {
            this.f21738m = Collections.emptyMap();
            this.f21726a = i;
            this.f21738m = new HashMap();
        }

        @NonNull
        public final Builder addExtra(String str, int i) {
            this.f21738m.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f21738m = new HashMap(map);
            return this;
        }

        @NonNull
        public final TTViewBinder build() {
            return new TTViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i) {
            this.f21729d = i;
            return this;
        }

        @NonNull
        public final Builder decriptionTextId(int i) {
            this.f21728c = i;
            return this;
        }

        @NonNull
        public final Builder groupImage1Id(int i) {
            this.f21735j = i;
            return this;
        }

        @NonNull
        public final Builder groupImage2Id(int i) {
            this.f21736k = i;
            return this;
        }

        @NonNull
        public final Builder groupImage3Id(int i) {
            this.f21737l = i;
            return this;
        }

        @NonNull
        public final Builder iconImageId(int i) {
            this.f21730e = i;
            return this;
        }

        @NonNull
        public final Builder logoLayoutId(int i) {
            this.f21734i = i;
            return this;
        }

        @NonNull
        public final Builder mainImageId(int i) {
            this.f21731f = i;
            return this;
        }

        @NonNull
        public final Builder mediaViewIdId(int i) {
            this.f21732g = i;
            return this;
        }

        @NonNull
        public final Builder sourceId(int i) {
            this.f21733h = i;
            return this;
        }

        @NonNull
        public final Builder titleId(int i) {
            this.f21727b = i;
            return this;
        }
    }

    private TTViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.f21726a;
        this.titleId = builder.f21727b;
        this.decriptionTextId = builder.f21728c;
        this.callToActionId = builder.f21729d;
        this.iconImageId = builder.f21730e;
        this.mainImageId = builder.f21731f;
        this.mediaViewId = builder.f21732g;
        this.sourceId = builder.f21733h;
        this.extras = builder.f21738m;
        this.groupImage1Id = builder.f21735j;
        this.groupImage2Id = builder.f21736k;
        this.groupImage3Id = builder.f21737l;
        this.logoLayoutId = builder.f21734i;
    }
}
