package com.bytedance.sdk.component.gd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends r {

    /* renamed from: w  reason: collision with root package name */
    public static c f29839w;

    /* renamed from: c  reason: collision with root package name */
    public static final int f29838c = Runtime.getRuntime().availableProcessors();
    public static boolean xv = true;
    public static int sr = 120;

    public static void c(p pVar) {
        pVar.c(10);
        a.f29806w.p().execute(pVar);
    }

    public static void sr(p pVar) {
        a.f29806w.a().execute(pVar);
    }

    public static boolean ux() {
        return xv;
    }

    public static void w(p pVar) {
        c().execute(pVar);
    }

    public static void xv(p pVar) {
        w().execute(pVar);
    }

    public static ScheduledExecutorService sr() {
        return a.f29806w.k();
    }

    public static void ux(p pVar) {
        a.f29806w.p().execute(pVar);
    }

    public static ThreadPoolExecutor w() {
        return a.f29806w.gd();
    }

    public static ExecutorService xv() {
        return c();
    }

    public static ExecutorService c() {
        return a.f29806w.a();
    }

    public static void w(p pVar, int i4) {
        pVar.c(i4);
        a.f29806w.a().execute(pVar);
    }

    public static void c(p pVar, int i4) {
        pVar.c(i4);
        a.f29806w.a().execute(pVar);
    }

    public static void c(boolean z3) {
        xv = z3;
    }

    public static void c(c cVar) {
        f29839w = cVar;
    }

    public static void c(int i4) {
        sr = i4;
    }
}
