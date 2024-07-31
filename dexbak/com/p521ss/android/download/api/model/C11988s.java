package com.p521ss.android.download.api.model;

/* renamed from: com.ss.android.download.api.model.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11988s {

    /* renamed from: a */
    private String f33916a;

    /* renamed from: ok */
    private String f33917ok;

    /* renamed from: com.ss.android.download.api.model.s$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11989ok {

        /* renamed from: a */
        private String f33918a;

        /* renamed from: ok */
        private String f33919ok;

        /* renamed from: a */
        public C11989ok m19536a(String str) {
            this.f33918a = str;
            return this;
        }

        /* renamed from: ok */
        public C11989ok m19533ok(String str) {
            this.f33919ok = str;
            return this;
        }

        /* renamed from: ok */
        public C11988s m19535ok() {
            return new C11988s(this);
        }
    }

    public C11988s(C11989ok c11989ok) {
        this.f33917ok = c11989ok.f33919ok;
        this.f33916a = c11989ok.f33918a;
    }

    /* renamed from: ok */
    public String m19538ok() {
        return this.f33917ok;
    }
}
