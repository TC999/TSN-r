package com.qq.e.comm.plugin.p;

import java.util.concurrent.ExecutorService;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f45200a;

    /* renamed from: b  reason: collision with root package name */
    private int f45201b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45202c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f45203d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f45204a = new c();

        public b a(int i4) {
            this.f45204a.f45200a = i4;
            return this;
        }

        public b b(int i4) {
            this.f45204a.f45201b = i4;
            return this;
        }

        public b a(boolean z3) {
            this.f45204a.f45202c = z3;
            return this;
        }

        public b a(ExecutorService executorService) {
            this.f45204a.f45203d = executorService;
            return this;
        }

        public c a() {
            return this.f45204a;
        }
    }

    public int c() {
        return this.f45201b;
    }

    public boolean d() {
        return this.f45202c;
    }

    private c() {
        this.f45200a = 30000;
        this.f45201b = 30000;
        this.f45202c = true;
    }

    public ExecutorService b() {
        return this.f45203d;
    }

    public int a() {
        return this.f45200a;
    }
}
