package com.baidu.liantian.b;

import android.content.Context;
import android.os.Process;

/* compiled from: PermissionChecker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q {
    public static boolean a(Context context) {
        try {
            return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
        } catch (Throwable unused) {
            e.a();
            return false;
        }
    }
}
