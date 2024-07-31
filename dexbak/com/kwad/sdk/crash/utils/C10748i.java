package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.kwad.sdk.crash.utils.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10748i {
    private static SimpleDateFormat aHS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: ax */
    public static String m24938ax(long j) {
        return j <= 0 ? "unknown" : aHS.format(new Date(j));
    }
}
