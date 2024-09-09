package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: VivoDeviceIdSupplier.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bf implements av {
    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        String str = null;
        try {
            if (!org.repackage.com.vivo.identifier.e.a(context)) {
                UMLog.mutlInfo(2, "\u5f53\u524d\u8bbe\u5907\u4e0d\u652f\u6301\u83b7\u53d6OAID");
            } else {
                str = org.repackage.com.vivo.identifier.e.c(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "\u672a\u68c0\u6d4b\u5230\u60a8\u96c6\u6210OAID SDK\u5305");
        }
        return str;
    }
}
