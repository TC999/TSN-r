package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Logger.java */
/* renamed from: com.orhanobut.logger.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C11792j {

    /* renamed from: a */
    public static final int f32686a = 2;

    /* renamed from: b */
    public static final int f32687b = 3;

    /* renamed from: c */
    public static final int f32688c = 4;

    /* renamed from: d */
    public static final int f32689d = 5;

    /* renamed from: e */
    public static final int f32690e = 6;

    /* renamed from: f */
    public static final int f32691f = 7;
    @NonNull

    /* renamed from: g */
    private static Printer f32692g = new LoggerPrinter();

    private C11792j() {
    }

    /* renamed from: a */
    public static void m20472a(@NonNull LogAdapter logAdapter) {
        f32692g.mo20426k((LogAdapter) C11795n.m20423a(logAdapter));
    }

    /* renamed from: b */
    public static void m20471b() {
        f32692g.mo20434d();
    }

    /* renamed from: c */
    public static void m20470c(@Nullable Object obj) {
        f32692g.mo20433d(obj);
    }

    /* renamed from: d */
    public static void m20469d(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20431f(str, objArr);
    }

    /* renamed from: e */
    public static void m20468e(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20424m(null, str, objArr);
    }

    /* renamed from: f */
    public static void m20467f(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20424m(th, str, objArr);
    }

    /* renamed from: g */
    public static void m20466g(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20432e(str, objArr);
    }

    /* renamed from: h */
    public static void m20465h(@Nullable String str) {
        f32692g.mo20436b(str);
    }

    /* renamed from: i */
    public static void m20464i(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        f32692g.mo20435c(i, str, str2, th);
    }

    /* renamed from: j */
    public static void m20463j(@NonNull Printer printer) {
        f32692g = (Printer) C11795n.m20423a(printer);
    }

    /* renamed from: k */
    public static Printer m20462k(@Nullable String str) {
        return f32692g.mo20430g(str);
    }

    /* renamed from: l */
    public static void m20461l(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20429h(str, objArr);
    }

    /* renamed from: m */
    public static void m20460m(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20425l(str, objArr);
    }

    /* renamed from: n */
    public static void m20459n(@NonNull String str, @Nullable Object... objArr) {
        f32692g.mo20437a(str, objArr);
    }

    /* renamed from: o */
    public static void m20458o(@Nullable String str) {
        f32692g.mo20427j(str);
    }
}
