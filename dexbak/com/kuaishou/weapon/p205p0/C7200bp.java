package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kuaishou.weapon.p0.bp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7200bp {
    /* renamed from: a */
    public static boolean m34147a(Context context, String str) {
        try {
            String str2 = Engine.soPath;
            if (!TextUtils.isEmpty(str2)) {
                if (new File(str2 + "/lib" + str).exists()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return m34145a(context.getFilesDir(), str, 0).size() > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        r0.add(r3);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> m34145a(java.io.File r5, final java.lang.String r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.kuaishou.weapon.p0.bp$1 r1 = new com.kuaishou.weapon.p0.bp$1     // Catch: java.lang.Throwable -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2d
            java.io.File[] r5 = r5.listFiles(r1)     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L2d
            int r1 = r5.length     // Catch: java.lang.Throwable -> L2d
            r2 = 0
        L12:
            if (r2 >= r1) goto L2d
            r3 = r5[r2]     // Catch: java.lang.Throwable -> L2d
            boolean r4 = r3.isFile()     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L20
            r0.add(r3)     // Catch: java.lang.Throwable -> L2d
            goto L2d
        L20:
            int r4 = r7 + 1
            java.util.List r7 = m34145a(r3, r6, r7)     // Catch: java.lang.Throwable -> L2d
            r0.addAll(r7)     // Catch: java.lang.Throwable -> L2d
            int r2 = r2 + 1
            r7 = r4
            goto L12
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7200bp.m34145a(java.io.File, java.lang.String, int):java.util.List");
    }

    /* renamed from: a */
    public static void m34146a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public static int m34144a(String[] strArr) {
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                if (new File(strArr[i2]).exists()) {
                    i |= 1 << i2;
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }
}
