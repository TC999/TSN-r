package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static boolean F(@NonNull List<StackTraceElement[]> list) {
        for (StackTraceElement[] stackTraceElementArr : list) {
            if (a(stackTraceElementArr)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Hv = e.Hu().Hv();
        if (Hv == null || Hv.length == 0) {
            return true;
        }
        boolean z3 = false;
        for (String str : Hv) {
            z3 = a(stackTraceElementArr, str);
            if (z3) {
                break;
            }
        }
        if (z3) {
            for (String str2 : e.Hu().Hw()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z3;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i4 = 0; i4 < 5; i4++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return F(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
