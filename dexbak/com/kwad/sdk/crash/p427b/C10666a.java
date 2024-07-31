package com.kwad.sdk.crash.p427b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.C10671e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.crash.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10666a {
    /* renamed from: F */
    private static boolean m25208F(@NonNull List<StackTraceElement[]> list) {
        for (StackTraceElement[] stackTraceElementArr : list) {
            if (m25207a(stackTraceElementArr)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m25207a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] m25133Hv = C10671e.m25134Hu().m25133Hv();
        if (m25133Hv == null || m25133Hv.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : m25133Hv) {
            z = m25206a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : C10671e.m25134Hu().m25132Hw()) {
                if (m25205b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m25205b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                C10331c.m26254d("AdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    public static boolean m25204o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return m25208F(arrayList);
    }

    /* renamed from: a */
    private static boolean m25206a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                C10331c.m26254d("AdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
