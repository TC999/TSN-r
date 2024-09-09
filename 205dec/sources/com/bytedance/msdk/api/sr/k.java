package com.bytedance.msdk.api.sr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private boolean f27635c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27636f;
    private Map<String, String> gd;

    /* renamed from: p  reason: collision with root package name */
    private String f27637p;

    /* renamed from: r  reason: collision with root package name */
    private String[] f27638r;
    private boolean sr;
    private int[] ux;

    /* renamed from: w  reason: collision with root package name */
    private int f27639w;
    private boolean xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private boolean f27640c = false;

        /* renamed from: w  reason: collision with root package name */
        private int f27644w = 0;
        private boolean xv = true;
        private boolean sr = false;
        private int[] ux = {4, 3, 5};

        /* renamed from: f  reason: collision with root package name */
        private boolean f27641f = false;

        /* renamed from: r  reason: collision with root package name */
        private String[] f27643r = new String[0];
        private String ev = "";
        private final Map<String, String> gd = new HashMap();

        /* renamed from: p  reason: collision with root package name */
        private String f27642p = "";

        public c c(boolean z3) {
            this.f27640c = z3;
            return this;
        }

        public c w(boolean z3) {
            this.xv = z3;
            return this;
        }

        public c xv(boolean z3) {
            this.f27641f = z3;
            return this;
        }

        public c c(int i4) {
            this.f27644w = i4;
            return this;
        }

        public c w(@NonNull String str) {
            this.f27642p = str;
            return this;
        }

        public c c(@NonNull int... iArr) {
            this.ux = iArr;
            return this;
        }

        public c c(@NonNull String str) {
            this.ev = str;
            return this;
        }

        public c c(@NonNull Map<String, String> map) {
            this.gd.putAll(map);
            return this;
        }

        public k c() {
            return new k(this);
        }
    }

    public boolean c() {
        return this.f27635c;
    }

    @Nullable
    public String ev() {
        return this.ev;
    }

    public boolean f() {
        return this.f27636f;
    }

    @NonNull
    public Map<String, String> gd() {
        return this.gd;
    }

    @Nullable
    public String p() {
        return this.f27637p;
    }

    @Nullable
    public String[] r() {
        return this.f27638r;
    }

    public boolean sr() {
        return this.sr;
    }

    public int[] ux() {
        return this.ux;
    }

    public int w() {
        return this.f27639w;
    }

    public boolean xv() {
        return this.xv;
    }

    private k(c cVar) {
        this.f27635c = cVar.f27640c;
        this.f27639w = cVar.f27644w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f27636f = cVar.f27641f;
        this.f27638r = cVar.f27643r;
        this.ev = cVar.ev;
        this.gd = cVar.gd;
        this.f27637p = cVar.f27642p;
    }
}
