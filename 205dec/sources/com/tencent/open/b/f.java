package com.tencent.open.b;

import com.tencent.open.utils.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {
    public static int a(String str) {
        int a4;
        if (com.tencent.open.utils.g.a() == null || (a4 = i.a(com.tencent.open.utils.g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a4;
    }

    public static int a() {
        int a4 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
        if (a4 == 0) {
            return 2;
        }
        return a4;
    }
}
