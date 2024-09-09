package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Logger.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f41373a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f41374b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final int f41375c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final int f41376d = 5;

    /* renamed from: e  reason: collision with root package name */
    public static final int f41377e = 6;

    /* renamed from: f  reason: collision with root package name */
    public static final int f41378f = 7;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private static m f41379g = new k();

    private j() {
    }

    public static void a(@NonNull g gVar) {
        f41379g.k((g) n.a(gVar));
    }

    public static void b() {
        f41379g.d();
    }

    public static void c(@Nullable Object obj) {
        f41379g.d(obj);
    }

    public static void d(@NonNull String str, @Nullable Object... objArr) {
        f41379g.f(str, objArr);
    }

    public static void e(@NonNull String str, @Nullable Object... objArr) {
        f41379g.m(null, str, objArr);
    }

    public static void f(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        f41379g.m(th, str, objArr);
    }

    public static void g(@NonNull String str, @Nullable Object... objArr) {
        f41379g.e(str, objArr);
    }

    public static void h(@Nullable String str) {
        f41379g.b(str);
    }

    public static void i(int i4, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        f41379g.c(i4, str, str2, th);
    }

    public static void j(@NonNull m mVar) {
        f41379g = (m) n.a(mVar);
    }

    public static m k(@Nullable String str) {
        return f41379g.g(str);
    }

    public static void l(@NonNull String str, @Nullable Object... objArr) {
        f41379g.h(str, objArr);
    }

    public static void m(@NonNull String str, @Nullable Object... objArr) {
        f41379g.l(str, objArr);
    }

    public static void n(@NonNull String str, @Nullable Object... objArr) {
        f41379g.a(str, objArr);
    }

    public static void o(@Nullable String str) {
        f41379g.j(str);
    }
}
