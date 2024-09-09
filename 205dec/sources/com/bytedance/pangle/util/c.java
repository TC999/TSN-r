package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    public static String[] a(File file) {
        String[] a4 = com.bytedance.pangle.util.a.b.a(file);
        return TextUtils.isEmpty(a4[0]) ? com.bytedance.pangle.util.a.a.a(file) : a4;
    }
}
