package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static String aFQ;
    private static Context ayY;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File HE() {
        File file;
        if (!TextUtils.isEmpty(aFQ)) {
            file = new File(aFQ);
        } else {
            file = new File(getDataDir(ayY), "kwad_ex");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File HF() {
        return new File(HE(), "java_crash/dump");
    }

    public static File HG() {
        return new File(HE(), "anr_log/dump");
    }

    public static File HH() {
        return new File(HE(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i4 >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        ayY = context;
        aFQ = str;
    }
}
