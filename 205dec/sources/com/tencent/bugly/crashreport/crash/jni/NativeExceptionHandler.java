package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface NativeExceptionHandler {
    boolean getAndUpdateAnrState();

    void handleNativeException(int i4, int i5, long j4, long j5, String str, String str2, String str3, String str4, int i6, String str5, int i7, int i8, int i9, String str6, String str7);

    void handleNativeException2(int i4, int i5, long j4, long j5, String str, String str2, String str3, String str4, int i6, String str5, int i7, int i8, int i9, String str6, String str7, String[] strArr);

    CrashDetailBean packageCrashDatas(String str, String str2, long j4, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z3, boolean z4);
}
