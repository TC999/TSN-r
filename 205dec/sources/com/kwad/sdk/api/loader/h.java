package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private static File amn;

    private static File aC(Context context) {
        if (amn == null) {
            amn = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return amn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && com.kwad.sdk.api.a.md.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File p(Context context, String str) {
        File aC = aC(context);
        return new File(aC, "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q(Context context, String str) {
        File aC = aC(context);
        return i(new File(aC, "apk-" + str)).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File r(Context context, String str) {
        File aC = aC(context);
        return i(new File(aC, "apk-" + str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String s(Context context, String str) {
        return new File(q(context, str), "dynamic.apk").getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Context context, String str) {
        return i(new File(q(context, str), "dex")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String u(Context context, String str) {
        return i(new File(q(context, str), "libs")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.b.a(new com.kwad.sdk.api.a.a() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // com.kwad.sdk.api.a.a
            public final void doTask() {
                try {
                    File[] listFiles = h.r(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (g.K(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            h.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
