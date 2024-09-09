package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f28981a;

    public static String a(Context context) {
        if (f28981a == null) {
            String[] a4 = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = a4[0];
            f28981a = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w("Zeus/init_pangle", "getHostIdentity failed. Reason: " + a4[2]);
            }
        }
        return f28981a;
    }

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
