package com.kwad.sdk.crash.p426a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* renamed from: com.kwad.sdk.crash.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10655a {
    private static String aFQ;
    private static Context ayY;

    /* renamed from: A */
    public static boolean m25230A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    /* renamed from: HE */
    public static File m25229HE() {
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

    /* renamed from: HF */
    public static File m25228HF() {
        return new File(m25229HE(), "java_crash/dump");
    }

    /* renamed from: HG */
    public static File m25227HG() {
        return new File(m25229HE(), "anr_log/dump");
    }

    /* renamed from: HH */
    public static File m25226HH() {
        return new File(m25229HE(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i >= 24 ? context.getDataDir() : null;
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
