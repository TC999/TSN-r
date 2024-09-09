package com.kwad.components.offline.api.core.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ILogcat {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void i(String str, String str2);

    void printStackTrace(Throwable th);

    void printStackTraceOnly(Throwable th);

    void v(String str, String str2);

    void v(String str, String str2, boolean z3);

    void w(String str, String str2);

    void w(String str, String str2, boolean z3);
}
