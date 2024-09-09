package com.bytedance.embedapplog;

import android.os.SystemProperties;
import com.acse.ottn.f3;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ta {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Object f26803c;

    private Object c() {
        if (f26803c == null) {
            synchronized (ta.class) {
                if (f26803c == null) {
                    f26803c = Class.forName("android.os.SystemProperties").newInstance();
                }
            }
        }
        return f26803c;
    }

    public String c(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            be.c(th);
            try {
                Object c4 = c();
                return (String) c4.getClass().getMethod(f3.f5657f, String.class).invoke(c4, str);
            } catch (Throwable th2) {
                be.c(th2);
                return "";
            }
        }
    }
}
