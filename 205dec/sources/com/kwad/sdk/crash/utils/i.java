package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {
    private static SimpleDateFormat aHS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String ax(long j4) {
        return j4 <= 0 ? "unknown" : aHS.format(new Date(j4));
    }
}
