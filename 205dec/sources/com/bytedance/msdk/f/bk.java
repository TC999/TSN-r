package com.bytedance.msdk.f;

import android.content.Context;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28306c;

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            File c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(context, null);
            if (c4 != null) {
                for (File file : c4.listFiles()) {
                    if (c(file)) {
                        f28306c = true;
                        return;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static boolean c(File file) {
        if (file != null && file.isFile()) {
            return file.getName().equals("gromore.debug");
        }
        return false;
    }
}
