package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ac {
    public boolean a() {
        return Process.myUid() / 100000 != 0;
    }

    public String b(Context context) {
        try {
            return context.getFilesDir().getParentFile().getAbsolutePath();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String c(Context context) {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = invoke.getClass().getDeclaredField("mPackages");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map != null && map.size() > 0) {
                for (Object obj : map.keySet()) {
                    if (obj.toString().length() > 1 && !obj.toString().equals(context.getPackageName())) {
                        File file = new File("/data/data" + File.separator + obj.toString());
                        if (file.exists() && file.canWrite()) {
                            return obj.toString();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
        if (r3 == null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONArray d(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = ".so"
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lb8
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r5 = "/proc/self/maps"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lb8
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lb8
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lb6
            r4.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r9 = r9.getPackageName()     // Catch: java.lang.Throwable -> Lb6
        L1a:
            java.lang.String r5 = r3.readLine()     // Catch: java.lang.Throwable -> Lb6
            if (r5 == 0) goto La3
            java.lang.String r6 = "@Hw"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            java.lang.String r6 = ".apk@classes.dex"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            java.lang.String r6 = "WebViewGoogle"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            java.lang.String r6 = "FeatureFramework"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            java.lang.String r6 = "framework@oppo"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            java.lang.String r6 = "framework@mediatek"
            boolean r6 = r5.contains(r6)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            int r6 = r4.size()     // Catch: java.lang.Throwable -> Lb6
            r7 = 15
            if (r6 > r7) goto La3
            boolean r6 = r5.contains(r9)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r7 = "/data/"
            if (r6 != 0) goto L7e
            boolean r6 = r5.contains(r7)     // Catch: java.lang.Throwable -> Lb6
            if (r6 == 0) goto L7e
            boolean r6 = r5.contains(r1)     // Catch: java.lang.Throwable -> Lb6
            if (r6 == 0) goto L7e
            int r6 = r5.indexOf(r7)     // Catch: java.lang.Throwable -> Lb6
            int r7 = r5.indexOf(r1)     // Catch: java.lang.Throwable -> Lb6
            int r7 = r7 + 3
            java.lang.String r5 = r5.substring(r6, r7)     // Catch: java.lang.Throwable -> Lb6
            r4.add(r5)     // Catch: java.lang.Throwable -> Lb6
            goto L1a
        L7e:
            boolean r6 = r5.contains(r9)     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L1a
            boolean r6 = r5.contains(r7)     // Catch: java.lang.Throwable -> Lb6
            if (r6 == 0) goto L1a
            boolean r6 = r5.contains(r0)     // Catch: java.lang.Throwable -> Lb6
            if (r6 == 0) goto L1a
            int r6 = r5.indexOf(r7)     // Catch: java.lang.Throwable -> Lb6
            int r7 = r5.indexOf(r0)     // Catch: java.lang.Throwable -> Lb6
            int r7 = r7 + 4
            java.lang.String r5 = r5.substring(r6, r7)     // Catch: java.lang.Throwable -> Lb6
            r4.add(r5)     // Catch: java.lang.Throwable -> Lb6
            goto L1a
        La3:
            int r9 = r4.size()     // Catch: java.lang.Throwable -> Lb6
            if (r9 <= 0) goto Lb2
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Lb6
            r9.<init>(r4)     // Catch: java.lang.Throwable -> Lb6
            r3.close()     // Catch: java.io.IOException -> Lb1
        Lb1:
            return r9
        Lb2:
            r3.close()     // Catch: java.io.IOException -> Lbc
            goto Lbc
        Lb6:
            goto Lb9
        Lb8:
            r3 = r2
        Lb9:
            if (r3 == 0) goto Lbc
            goto Lb2
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ac.d(android.content.Context):org.json.JSONArray");
    }

    public int e(Context context) {
        FileOutputStream fileOutputStream;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
                String str = "fk_w_" + System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(str);
                fileOutputStream = new FileOutputStream(sb.toString());
                try {
                    FileDescriptor fd = fileOutputStream.getFD();
                    Field declaredField = fd.getClass().getDeclaredField("descriptor");
                    declaredField.setAccessible(true);
                    declaredField.get(fd);
                    String absolutePath2 = Files.readSymbolicLink(Paths.get(String.format("/proc/self/fd/%d", Integer.valueOf(((Integer) declaredField.get(fd)).intValue())), new String[0])).toFile().getAbsolutePath();
                    if (!absolutePath2.substring(absolutePath2.lastIndexOf(str2)).equals(str2 + str)) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                        return 1;
                    }
                    boolean canRead = new File(absolutePath2.replace(str, "")).getParentFile().canRead();
                    File file = new File(absolutePath2);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (canRead) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        return 1;
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    return 0;
                } catch (Throwable unused4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return 0;
                }
            }
            return a(context) ? 1 : 0;
        } catch (Throwable unused6) {
            fileOutputStream = null;
        }
    }

    public boolean f(Context context) {
        try {
            int i4 = context.getApplicationInfo().targetSdkVersion;
            Class<?> cls = Class.forName("android.os.SELinux");
            String str = (String) cls.getDeclaredMethod("getContext", new Class[0]).invoke(cls, new Object[0]);
            String a4 = a(i4, Build.VERSION.SDK_INT);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !str.startsWith(a4);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Context context) {
        try {
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            return new File(absolutePath + File.separator + "..").canRead();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String a(int i4, int i5) {
        if (i5 < 26) {
            return "u:r:untrusted_app";
        }
        if (i4 >= i5) {
            return "u:r:untrusted_app:s0";
        } else if (i4 < 26) {
            return "u:r:untrusted_app_25:s0";
        } else {
            if (i5 == 27) {
                if (i4 >= 26) {
                    return "u:r:untrusted_app:s0";
                }
            } else if (i5 == 28 || i5 == 29) {
                if (i4 >= 26) {
                    return "u:r:untrusted_app_27:s0";
                }
            } else if (i5 == 30) {
                if (i4 >= 29) {
                    return "u:r:untrusted_app_29:s0";
                }
                return "u:r:untrusted_app_27:s0";
            }
            return "u:r:untrusted_app";
        }
    }
}
