package com.bytedance.msdk.api.sr;

import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private boolean f27623c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private String f27624w;
    private boolean xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private boolean f27625c = false;

        /* renamed from: w  reason: collision with root package name */
        private String f27626w = null;
        private boolean xv = false;
        private boolean sr = false;

        public c c(boolean z3) {
            this.f27625c = z3;
            return this;
        }

        public c w(boolean z3) {
            this.xv = z3;
            return this;
        }

        public c xv(boolean z3) {
            this.sr = z3;
            return this;
        }

        public c c(String str) {
            this.f27626w = str;
            return this;
        }

        public ev c() {
            return new ev(this);
        }
    }

    @Nullable
    public String c() {
        return this.f27624w;
    }

    public boolean sr() {
        return this.sr;
    }

    public boolean w() {
        return this.f27623c;
    }

    public boolean xv() {
        return this.xv;
    }

    private ev(c cVar) {
        this.f27623c = cVar.f27625c;
        this.f27624w = cVar.f27626w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
    }
}
