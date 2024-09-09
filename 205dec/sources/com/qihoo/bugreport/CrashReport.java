package com.qihoo.bugreport;

import android.content.Context;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;
import java.lang.Thread;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class CrashReport {

    /* renamed from: a  reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f41404a;

    /* renamed from: b  reason: collision with root package name */
    private static ExceptionHandleReporter f41405b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f41406c;

    public static void prepareInit() {
        if (f41404a == null) {
            f41404a = Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    public static void init(Context context) {
        if (context != null) {
            try {
                if (f41404a != null) {
                    if (f41406c == null || f41405b == null) {
                        f41406c = context;
                        f41405b = ExceptionHandleReporter.a(context, f41404a);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static ExceptionHandleReporter getExceptionHandlerInstance() {
        return f41405b;
    }

    public static Context a() {
        return f41406c;
    }
}
