package com.baidu.liantian.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.F;

/* compiled from: MethodImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {
    public static void a(final Context context, final int i4, boolean z3) {
        try {
            d.f12175c = z3;
            com.baidu.liantian.b.e.l(context);
            if (z3) {
                new Thread(new Runnable() { // from class: com.baidu.liantian.core.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            Context context2 = context;
                            d.f12174b = context2;
                            if (!com.baidu.liantian.b.e.a(context2, true)) {
                                com.baidu.liantian.b.a();
                            } else if (!com.baidu.liantian.b.e.a(context)) {
                                com.baidu.liantian.b.a();
                            } else {
                                d a4 = d.a(context);
                                com.baidu.liantian.b.g.a(context);
                                int i5 = i4;
                                if (i5 > 0) {
                                    Thread.sleep(i5 * 1000);
                                }
                                new com.baidu.liantian.e(context).a(1);
                                d.a(1);
                                a4.a((Callback) null);
                            }
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }).start();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    private static String b(Context context) {
        com.baidu.liantian.e eVar;
        String string;
        String[] split;
        byte[] re;
        try {
            eVar = new com.baidu.liantian.e(context);
            string = eVar.f12229b.getString("xytk", "");
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (TextUtils.isEmpty(string)) {
            String a4 = com.baidu.liantian.b.g.a(context);
            if (!TextUtils.isEmpty(a4) && (split = a4.split("\\|")) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (re = F.getInstance().re(split[1].getBytes(), split[0].getBytes())) != null) {
                String str = split[0] + com.baidu.liantian.b.e.a(re);
                eVar.f12231d.putString("xytk", str);
                eVar.f12231d.commit();
                return str;
            }
            return "74FFB5E615AA72E0B057EE43E3D5A23A|440049145074113";
        }
        return string;
    }

    private static Pair<Integer, Object> a(int i4, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = d.f12174b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!com.baidu.liantian.b.e.a(context, false)) {
                com.baidu.liantian.b.a();
                return new Pair<>(11, null);
            }
            String b4 = com.baidu.liantian.b.e.b(d.f12174b);
            if (TextUtils.isEmpty(b4)) {
                if (com.baidu.liantian.b.e.b(d.f12174b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                com.baidu.liantian.b.a();
                return d.a(context).a(i4, str, clsArr, objArr);
            } else if (com.baidu.liantian.b.e.b(b4)) {
                com.baidu.liantian.b.a();
                return a(d.f12174b, i4, str, clsArr, objArr);
            } else {
                com.baidu.liantian.b.a();
                return d.a(context).a(i4, str, clsArr, objArr);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return new Pair<>(3, null);
        }
    }

    public static boolean a(final int i4, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            Context context = d.f12174b;
            if (context == null) {
                com.baidu.liantian.b.a();
                if (callback != null) {
                    callback.onError(4);
                }
                return false;
            } else if (!com.baidu.liantian.b.e.a(context, false)) {
                com.baidu.liantian.b.a();
                if (callback != null) {
                    callback.onError(11);
                }
                return false;
            } else {
                String b4 = com.baidu.liantian.b.e.b(d.f12174b);
                if (TextUtils.isEmpty(b4)) {
                    if (com.baidu.liantian.b.e.b(d.f12174b.getPackageName())) {
                        if (callback != null) {
                            callback.onError(5);
                        }
                        return false;
                    }
                    com.baidu.liantian.b.a();
                    d.a(context).a(i4, str, callback, clsArr, objArr);
                    return true;
                } else if (com.baidu.liantian.b.e.b(b4)) {
                    com.baidu.liantian.b.a();
                    final Context context2 = d.f12174b;
                    if (!TextUtils.isEmpty(str)) {
                        new Thread() { // from class: com.baidu.liantian.core.e.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                super.run();
                                Callback callback2 = Callback.this;
                                if (callback2 != null) {
                                    callback2.onBegin(new Object[0]);
                                }
                                Pair<Integer, Object> a4 = e.a(context2, i4, 0, str, clsArr, objArr);
                                if (Callback.this != null) {
                                    if (((Integer) a4.first).intValue() != 0) {
                                        Callback.this.onError(a4.first);
                                    } else {
                                        Callback.this.onEnd(a4.second);
                                    }
                                }
                            }
                        }.start();
                    } else if (callback != null) {
                        callback.onError(1);
                    }
                    return true;
                } else {
                    com.baidu.liantian.b.a();
                    d.a(context).a(i4, str, callback, clsArr, objArr);
                    return true;
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    public static String a(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (!com.baidu.liantian.b.e.a(context, false)) {
            com.baidu.liantian.b.a();
            return "";
        }
        String b4 = com.baidu.liantian.b.e.b(context);
        if (TextUtils.isEmpty(b4)) {
            if (com.baidu.liantian.b.e.b(context.getPackageName())) {
                return "";
            }
            com.baidu.liantian.b.a();
            return b(context);
        } else if (com.baidu.liantian.b.e.b(b4)) {
            com.baidu.liantian.b.a();
            Pair<Integer, Object> a4 = a(context, 0, "gz", (Class<?>[]) null, new Object[0]);
            if (a4 != null) {
                if (((Integer) a4.first).intValue() == 0) {
                    return (String) a4.second;
                }
                com.baidu.liantian.b.a();
                return "";
            }
            return "";
        } else {
            com.baidu.liantian.b.a();
            return b(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #3 {all -> 0x01af, blocks: (B:3:0x000d, B:7:0x0025, B:31:0x00ce, B:34:0x00d8, B:64:0x017f, B:66:0x0187, B:68:0x0191, B:69:0x0195, B:71:0x01ab, B:35:0x00dd, B:37:0x00f6, B:38:0x00f9, B:40:0x00fc, B:42:0x0109, B:44:0x0111, B:46:0x0117, B:48:0x0127, B:47:0x011d, B:49:0x012a, B:51:0x012e, B:53:0x0147, B:60:0x016a, B:55:0x014e, B:57:0x015e, B:8:0x002a, B:10:0x003b, B:12:0x0040, B:17:0x006a, B:19:0x0070, B:22:0x0078, B:23:0x008e, B:24:0x00a7, B:26:0x00b1, B:27:0x00b5, B:13:0x0051, B:15:0x0054), top: B:76:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1 A[Catch: all -> 0x00c6, TryCatch #3 {all -> 0x01af, blocks: (B:3:0x000d, B:7:0x0025, B:31:0x00ce, B:34:0x00d8, B:64:0x017f, B:66:0x0187, B:68:0x0191, B:69:0x0195, B:71:0x01ab, B:35:0x00dd, B:37:0x00f6, B:38:0x00f9, B:40:0x00fc, B:42:0x0109, B:44:0x0111, B:46:0x0117, B:48:0x0127, B:47:0x011d, B:49:0x012a, B:51:0x012e, B:53:0x0147, B:60:0x016a, B:55:0x014e, B:57:0x015e, B:8:0x002a, B:10:0x003b, B:12:0x0040, B:17:0x006a, B:19:0x0070, B:22:0x0078, B:23:0x008e, B:24:0x00a7, B:26:0x00b1, B:27:0x00b5, B:13:0x0051, B:15:0x0054), top: B:76:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #3 {all -> 0x01af, blocks: (B:3:0x000d, B:7:0x0025, B:31:0x00ce, B:34:0x00d8, B:64:0x017f, B:66:0x0187, B:68:0x0191, B:69:0x0195, B:71:0x01ab, B:35:0x00dd, B:37:0x00f6, B:38:0x00f9, B:40:0x00fc, B:42:0x0109, B:44:0x0111, B:46:0x0117, B:48:0x0127, B:47:0x011d, B:49:0x012a, B:51:0x012e, B:53:0x0147, B:60:0x016a, B:55:0x014e, B:57:0x015e, B:8:0x002a, B:10:0x003b, B:12:0x0040, B:17:0x006a, B:19:0x0070, B:22:0x0078, B:23:0x008e, B:24:0x00a7, B:26:0x00b1, B:27:0x00b5, B:13:0x0051, B:15:0x0054), top: B:76:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle a(android.content.Context r18, java.lang.String r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.e.a(android.content.Context, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x00a1, B:31:0x00aa, B:33:0x00be, B:35:0x00c8, B:39:0x00d2, B:38:0x00d0), top: B:43:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x00a1, B:31:0x00aa, B:33:0x00be, B:35:0x00c8, B:39:0x00d2, B:38:0x00d0), top: B:43:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0012, B:9:0x001a, B:14:0x0027, B:16:0x0034, B:17:0x0038, B:19:0x003b, B:21:0x0043, B:23:0x004f, B:25:0x006b, B:24:0x0063, B:26:0x006e, B:27:0x0070, B:29:0x00a1, B:31:0x00aa, B:33:0x00be, B:35:0x00c8, B:39:0x00d2, B:38:0x00d0), top: B:43:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.util.Pair<java.lang.Integer, java.lang.Object> a(android.content.Context r5, int r6, int r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Object... r10) {
        /*
            r0 = 3
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 == 0) goto L12
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Ld7
            android.util.Pair r5 = android.util.Pair.create(r5, r1)     // Catch: java.lang.Throwable -> Ld7
            return r5
        L12:
            java.lang.String r2 = "gzfi"
            boolean r2 = r2.equals(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 != 0) goto L26
            java.lang.String r2 = "gz"
            boolean r2 = r2.equals(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 == 0) goto L23
            goto L26
        L23:
            java.lang.String r2 = "invokeMethod"
            goto L27
        L26:
            r2 = r8
        L27:
            com.baidu.liantian.core.c r3 = new com.baidu.liantian.core.c     // Catch: java.lang.Throwable -> Ld7
            r3.<init>()     // Catch: java.lang.Throwable -> Ld7
            r3.f12168a = r6     // Catch: java.lang.Throwable -> Ld7
            r3.f12170c = r8     // Catch: java.lang.Throwable -> Ld7
            r3.f12169b = r7     // Catch: java.lang.Throwable -> Ld7
            if (r9 == 0) goto L70
            int r6 = r9.length     // Catch: java.lang.Throwable -> Ld7
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Ld7
            r7 = 0
        L38:
            int r8 = r9.length     // Catch: java.lang.Throwable -> Ld7
            if (r7 >= r8) goto L6e
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            boolean r8 = r8.isPrimitive()     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto L63
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = com.baidu.liantian.b.e.a(r8)     // Catch: java.lang.Throwable -> Ld7
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r4 != 0) goto L6b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r4.<init>()     // Catch: java.lang.Throwable -> Ld7
            r4.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = "@@"
            r4.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> Ld7
            r6[r7] = r8     // Catch: java.lang.Throwable -> Ld7
            goto L6b
        L63:
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Throwable -> Ld7
            r6[r7] = r8     // Catch: java.lang.Throwable -> Ld7
        L6b:
            int r7 = r7 + 1
            goto L38
        L6e:
            r3.f12171d = r6     // Catch: java.lang.Throwable -> Ld7
        L70:
            r3.f12172e = r10     // Catch: java.lang.Throwable -> Ld7
            android.os.Bundle r6 = new android.os.Bundle     // Catch: java.lang.Throwable -> Ld7
            r6.<init>()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = "args"
            r6.putParcelable(r7, r3)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = "content://"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r5.getPackageName()     // Catch: java.lang.Throwable -> Ld7
            r7.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = ".liantian.ac.provider"
            r7.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Ld7
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch: java.lang.Throwable -> Ld7
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> Ld7
            android.os.Bundle r5 = r5.call(r7, r2, r1, r6)     // Catch: java.lang.Throwable -> Ld7
            if (r5 != 0) goto Laa
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Ld7
            android.util.Pair r5 = android.util.Pair.create(r5, r1)     // Catch: java.lang.Throwable -> Ld7
            return r5
        Laa:
            java.lang.Class<com.baidu.liantian.core.c> r6 = com.baidu.liantian.core.c.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.Throwable -> Ld7
            r5.setClassLoader(r6)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r6 = "status"
            int r6 = r5.getInt(r6)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.liantian.b.a()     // Catch: java.lang.Throwable -> Ld7
            if (r6 != 0) goto Lc7
            java.lang.String r7 = "result"
            android.os.Parcelable r5 = r5.getParcelable(r7)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.liantian.core.c r5 = (com.baidu.liantian.core.c) r5     // Catch: java.lang.Throwable -> Ld7
            goto Lc8
        Lc7:
            r5 = r1
        Lc8:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Ld7
            if (r5 != 0) goto Ld0
            r5 = r1
            goto Ld2
        Ld0:
            java.lang.Object r5 = r5.f12173f     // Catch: java.lang.Throwable -> Ld7
        Ld2:
            android.util.Pair r5 = android.util.Pair.create(r6, r5)     // Catch: java.lang.Throwable -> Ld7
            return r5
        Ld7:
            com.baidu.liantian.b.e.a()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            android.util.Pair r5 = android.util.Pair.create(r5, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.e.a(android.content.Context, int, int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
    }

    private static Pair<Integer, Object> a(Context context, int i4, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i4, 1, str, clsArr, objArr);
    }
}
