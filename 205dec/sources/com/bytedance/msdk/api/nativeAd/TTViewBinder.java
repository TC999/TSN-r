package com.bytedance.msdk.api.nativeAd;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
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

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f27469a;

        /* renamed from: b  reason: collision with root package name */
        private int f27470b;

        /* renamed from: c  reason: collision with root package name */
        private int f27471c;

        /* renamed from: d  reason: collision with root package name */
        private int f27472d;

        /* renamed from: e  reason: collision with root package name */
        private int f27473e;

        /* renamed from: f  reason: collision with root package name */
        private int f27474f;

        /* renamed from: g  reason: collision with root package name */
        private int f27475g;

        /* renamed from: h  reason: collision with root package name */
        private int f27476h;

        /* renamed from: i  reason: collision with root package name */
        private int f27477i;

        /* renamed from: j  reason: collision with root package name */
        private int f27478j;

        /* renamed from: k  reason: collision with root package name */
        private int f27479k;

        /* renamed from: l  reason: collision with root package name */
        private int f27480l;
        @NonNull

        /* renamed from: m  reason: collision with root package name */
        private Map<String, Integer> f27481m;

        public Builder(int i4) {
            this.f27481m = Collections.emptyMap();
            this.f27469a = i4;
            this.f27481m = new HashMap();
        }

        @NonNull
        public final Builder addExtra(String str, int i4) {
            this.f27481m.put(str, Integer.valueOf(i4));
            return this;
        }

        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.f27481m = new HashMap(map);
            return this;
        }

        @NonNull
        public final TTViewBinder build() {
            return new TTViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i4) {
            this.f27472d = i4;
            return this;
        }

        @NonNull
        public final Builder decriptionTextId(int i4) {
            this.f27471c = i4;
            return this;
        }

        @NonNull
        public final Builder groupImage1Id(int i4) {
            this.f27478j = i4;
            return this;
        }

        @NonNull
        public final Builder groupImage2Id(int i4) {
            this.f27479k = i4;
            return this;
        }

        @NonNull
        public final Builder groupImage3Id(int i4) {
            this.f27480l = i4;
            return this;
        }

        @NonNull
        public final Builder iconImageId(int i4) {
            this.f27473e = i4;
            return this;
        }

        @NonNull
        public final Builder logoLayoutId(int i4) {
            this.f27477i = i4;
            return this;
        }

        @NonNull
        public final Builder mainImageId(int i4) {
            this.f27474f = i4;
            return this;
        }

        @NonNull
        public final Builder mediaViewIdId(int i4) {
            this.f27475g = i4;
            return this;
        }

        @NonNull
        public final Builder sourceId(int i4) {
            this.f27476h = i4;
            return this;
        }

        @NonNull
        public final Builder titleId(int i4) {
            this.f27470b = i4;
            return this;
        }
    }

    private TTViewBinder(@NonNull Builder builder) {
        this.layoutId = builder.f27469a;
        this.titleId = builder.f27470b;
        this.decriptionTextId = builder.f27471c;
        this.callToActionId = builder.f27472d;
        this.iconImageId = builder.f27473e;
        this.mainImageId = builder.f27474f;
        this.mediaViewId = builder.f27475g;
        this.sourceId = builder.f27476h;
        this.extras = builder.f27481m;
        this.groupImage1Id = builder.f27478j;
        this.groupImage2Id = builder.f27479k;
        this.groupImage3Id = builder.f27480l;
        this.logoLayoutId = builder.f27477i;
    }
}
