package com.ss.android.download.api.model;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private String f48250a;
    private String ok;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f48251a;
        private String ok;

        public ok a(String str) {
            this.f48251a = str;
            return this;
        }

        public ok ok(String str) {
            this.ok = str;
            return this;
        }

        public s ok() {
            return new s(this);
        }
    }

    public s(ok okVar) {
        this.ok = okVar.ok;
        this.f48250a = okVar.f48251a;
    }

    public String ok() {
        return this.ok;
    }
}
