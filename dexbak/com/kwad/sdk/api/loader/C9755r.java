package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* renamed from: com.kwad.sdk.api.loader.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9755r {
    /* renamed from: a */
    public static boolean m27850a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(C9756s.getFileMD5(file).toLowerCase());
    }

    /* renamed from: k */
    public static boolean m27849k(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }
}
