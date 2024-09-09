package com.qq.e.comm.plugin.e0.d;

import android.content.Context;
import com.qq.e.comm.plugin.util.d1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c {
    public static String a(Context context) {
        File a4 = a(context, "config");
        if (a4 == null) {
            return null;
        }
        try {
            String a5 = a(a4);
            if (a5 == null) {
                return null;
            }
            return com.qq.e.comm.plugin.util.d.a(a5);
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        a(context, a(context, "config"), str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, String str) {
        a(context, a(context, "test"), str, false);
    }

    private static void a(Context context, File file, String str, boolean z3) {
        if (file == null) {
            return;
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                if (z3) {
                    try {
                        str = com.qq.e.comm.plugin.util.d.b(str);
                    } catch (Exception unused) {
                        outputStreamWriter = outputStreamWriter2;
                        d1.a("write mediation config to file fail", new Object[0]);
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                                return;
                            } catch (Exception unused2) {
                                d1.a("close config writer failed", new Object[0]);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception unused3) {
                                d1.a("close config writer failed", new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
                outputStreamWriter2.write(str);
                try {
                    outputStreamWriter2.close();
                } catch (Exception unused4) {
                    d1.a("close config writer failed", new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
        }
    }

    private static File a(Context context, String str) {
        File dir = context.getDir("e_qq_com_mediation", 0);
        if (!dir.exists() && !dir.mkdirs()) {
            d1.a("Create mediation config dir failed!");
            return null;
        }
        File file = new File(dir, str);
        try {
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            d1.a("Create mediation config file failed!");
            return null;
        } catch (IOException e4) {
            d1.a("Create mediation config file failed!", e4);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.File r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "Exception while close bufferreader"
            r1 = 0
            if (r5 == 0) goto L51
            boolean r2 = r5.exists()
            if (r2 != 0) goto Lc
            goto L51
        Lc:
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.String r5 = "UTF-8"
            r2.<init>(r3, r5)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L42
            r1.<init>()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L42
        L22:
            java.lang.String r2 = r5.readLine()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L42
            if (r2 == 0) goto L2c
            r1.append(r2)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L42
            goto L22
        L2c:
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L42
            r5.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r5 = move-exception
            com.qq.e.comm.plugin.util.d1.a(r0, r5)
        L38:
            return r1
        L39:
            r1 = move-exception
            goto L41
        L3b:
            r5 = move-exception
            goto L46
        L3d:
            r5 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L41:
            throw r1     // Catch: java.lang.Throwable -> L42
        L42:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
        L46:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r1 = move-exception
            com.qq.e.comm.plugin.util.d1.a(r0, r1)
        L50:
            throw r5
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e0.d.c.a(java.io.File):java.lang.String");
    }
}
