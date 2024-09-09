package com.bytedance.sdk.openadsdk.core.xv;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.eq;
import java.io.File;
import java.io.FileFilter;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    public static boolean c(Context context) {
        File[] listFiles;
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(context), "/pangle_p/com.byted.pangle");
        return (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.xv.f.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2 != null && file2.getName().matches("^version-(\\d+)$");
            }
        })) == null || listFiles.length == 0) ? false : true;
    }

    public static boolean c() {
        boolean z3 = eq.f33187c;
        return false;
    }
}
