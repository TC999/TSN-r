package com.qq.e.comm.plugin.i0;

import java.util.concurrent.Future;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface c {

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        public static final a f44221d = new a("High", 0, 1);

        /* renamed from: e  reason: collision with root package name */
        public static final a f44222e = new a("Mid", 1, 2);

        /* renamed from: f  reason: collision with root package name */
        public static final a f44223f = new a("Low", 2, 3);

        /* renamed from: c  reason: collision with root package name */
        private int f44224c;

        private a(String str, int i4, int i5) {
            this.f44224c = i5;
        }

        public int a() {
            return this.f44224c;
        }
    }

    Future<com.qq.e.comm.plugin.i0.n.g> a(com.qq.e.comm.plugin.i0.n.f fVar);

    Future<com.qq.e.comm.plugin.i0.n.g> a(com.qq.e.comm.plugin.i0.n.f fVar, a aVar);

    void a(com.qq.e.comm.plugin.i0.n.f fVar, a aVar, b bVar);
}
