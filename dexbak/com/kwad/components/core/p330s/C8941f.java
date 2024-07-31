package com.kwad.components.core.p330s;

import androidx.annotation.Nullable;

/* renamed from: com.kwad.components.core.s.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8941f {
    /* renamed from: a */
    public static String m29558a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
    }

    /* renamed from: az */
    public static boolean m29557az(@Nullable String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (m29558a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }
}
