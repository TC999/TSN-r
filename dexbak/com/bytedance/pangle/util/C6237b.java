package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* renamed from: com.bytedance.pangle.util.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6237b {

    /* renamed from: a */
    private static String f22211a;

    /* renamed from: a */
    public static String m36928a(Context context) {
        if (f22211a == null) {
            String[] m36907a = C6247c.m36907a(new File(context.getApplicationInfo().sourceDir));
            String str = m36907a[0];
            f22211a = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.m37077w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + m36907a[2]);
            }
        }
        return f22211a;
    }

    /* renamed from: a */
    public static boolean m36929a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
