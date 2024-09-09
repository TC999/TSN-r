package com.beizi.ad.lance.a;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PermissionUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n {
    public static boolean a(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }
}
