package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p397e.C10331c;
import java.io.File;

/* renamed from: com.kwad.sdk.utils.aw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11031aw {
    private static String aPH;
    private static File aPI;

    /* renamed from: Mz */
    private static boolean m23998Mz() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return false;
        }
    }

    /* renamed from: cJ */
    private static String m23997cJ(Context context) {
        if (!TextUtils.isEmpty(aPH)) {
            return aPH;
        }
        String str = null;
        if (m23998Mz()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aPH = str2;
        return str2;
    }

    /* renamed from: cK */
    public static File m23996cK(Context context) {
        File file = aPI;
        if (file != null) {
            return file;
        }
        String str = null;
        if (m23998Mz()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aPI = file2;
        if (!file2.exists()) {
            aPI.mkdirs();
        }
        return aPI;
    }

    /* renamed from: cL */
    public static File m23995cL(Context context) {
        String m23997cJ = m23997cJ(context);
        File file = new File(m23997cJ + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: cM */
    public static File m23994cM(Context context) {
        String m23997cJ = m23997cJ(context);
        File file = new File(m23997cJ + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: cN */
    public static File m23993cN(Context context) {
        String str;
        if (C9425a.f29473md.booleanValue()) {
            str = m23997cJ(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    /* renamed from: cO */
    public static String m23992cO(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }

    /* renamed from: cP */
    public static String m23991cP(Context context) {
        return m23996cK(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String m23992cO = m23992cO(context);
        StringBuilder sb = new StringBuilder();
        sb.append(m23992cO);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ksad/download/js");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        String m23992cO = m23992cO(context);
        return m23992cO + File.separator + "ksad/download/js";
    }
}
