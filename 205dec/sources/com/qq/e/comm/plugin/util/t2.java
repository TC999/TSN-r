package com.qq.e.comm.plugin.util;

import android.util.Base64;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class t2 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(a(str.getBytes(com.qq.e.comm.plugin.k.a.f44515a)), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r6) {
        /*
            if (r6 == 0) goto L69
            int r0 = r6.length
            if (r0 != 0) goto L6
            goto L69
        L6:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
        L1a:
            int r4 = r3.read(r1)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L56
            r5 = -1
            if (r4 == r5) goto L26
            r5 = 0
            r6.write(r1, r5, r4)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L56
            goto L1a
        L26:
            r6.flush()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L56
            byte[] r2 = r6.toByteArray()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L56
            r3.close()     // Catch: java.lang.Exception -> L37
            r0.close()     // Catch: java.lang.Exception -> L37
            r6.close()     // Catch: java.lang.Exception -> L37
            goto L55
        L37:
            r6 = move-exception
            r6.printStackTrace()
            goto L55
        L3c:
            r1 = move-exception
            goto L42
        L3e:
            r1 = move-exception
            goto L58
        L40:
            r1 = move-exception
            r3 = r2
        L42:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.lang.Exception -> L51
        L4a:
            r0.close()     // Catch: java.lang.Exception -> L51
            r6.close()     // Catch: java.lang.Exception -> L51
            goto L55
        L51:
            r6 = move-exception
            r6.printStackTrace()
        L55:
            return r2
        L56:
            r1 = move-exception
            r2 = r3
        L58:
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.lang.Exception -> L64
        L5d:
            r0.close()     // Catch: java.lang.Exception -> L64
            r6.close()     // Catch: java.lang.Exception -> L64
            goto L68
        L64:
            r6 = move-exception
            r6.printStackTrace()
        L68:
            throw r1
        L69:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t2.b(byte[]):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r3) {
        /*
            if (r3 == 0) goto L4e
            int r0 = r3.length
            if (r0 != 0) goto L6
            goto L4e
        L6:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.write(r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3e
            r2.finish()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3e
            byte[] r1 = r0.toByteArray()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3e
            r2.close()     // Catch: java.lang.Exception -> L22
            r0.close()     // Catch: java.lang.Exception -> L22
            goto L3d
        L22:
            r3 = move-exception
            r3.printStackTrace()
            goto L3d
        L27:
            r3 = move-exception
            goto L2d
        L29:
            r3 = move-exception
            goto L40
        L2b:
            r3 = move-exception
            r2 = r1
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.lang.Exception -> L39
        L35:
            r0.close()     // Catch: java.lang.Exception -> L39
            goto L3d
        L39:
            r3 = move-exception
            r3.printStackTrace()
        L3d:
            return r1
        L3e:
            r3 = move-exception
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Exception -> L49
        L45:
            r0.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r0 = move-exception
            r0.printStackTrace()
        L4d:
            throw r3
        L4e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t2.a(byte[]):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
        throw new java.lang.Exception("unsafe zipfile!");
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00c6: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:47:0x00c6 */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            r0 = 0
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r3.<init>(r6)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> La9
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lc5
            r6.<init>(r7)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lc5
            boolean r0 = r6.exists()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            if (r0 != 0) goto L1a
            r6.mkdirs()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
        L1a:
            java.util.zip.ZipEntry r0 = r2.getNextEntry()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3 = 1
            if (r0 == 0) goto L98
            java.lang.String r4 = r0.getName()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r5 = "../"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            if (r5 != 0) goto L90
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            if (r0 == 0) goto L59
            int r0 = r4.length()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            int r0 = r0 - r3
            java.lang.String r0 = r4.substring(r1, r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r4.<init>()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r4.append(r7)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r4.append(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r4.append(r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.<init>(r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.mkdirs()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            goto L1a
        L59:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.<init>()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.append(r7)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.append(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.append(r4)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r0.<init>(r3)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r0.createNewFile()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.<init>(r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
        L7e:
            int r4 = r2.read(r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r5 = -1
            if (r4 == r5) goto L8c
            r3.write(r0, r1, r4)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            r3.flush()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            goto L7e
        L8c:
            r3.close()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            goto L1a
        L90:
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            java.lang.String r0 = "unsafe zipfile!"
            r7.<init>(r0)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
            throw r7     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> Lc5
        L98:
            r2.close()     // Catch: java.lang.Exception -> L9c
            goto La0
        L9c:
            r6 = move-exception
            r6.printStackTrace()
        La0:
            return r3
        La1:
            r7 = move-exception
            r0 = r6
            goto Lac
        La4:
            r6 = move-exception
            r7 = r6
            goto Lac
        La7:
            r6 = move-exception
            goto Lc7
        La9:
            r6 = move-exception
            r7 = r6
            r2 = r0
        Lac:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto Lba
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> Lc5
            if (r6 == 0) goto Lba
            a(r0)     // Catch: java.lang.Throwable -> Lc5
        Lba:
            if (r2 == 0) goto Lc4
            r2.close()     // Catch: java.lang.Exception -> Lc0
            goto Lc4
        Lc0:
            r6 = move-exception
            r6.printStackTrace()
        Lc4:
            return r1
        Lc5:
            r6 = move-exception
            r0 = r2
        Lc7:
            if (r0 == 0) goto Ld1
            r0.close()     // Catch: java.lang.Exception -> Lcd
            goto Ld1
        Lcd:
            r7 = move-exception
            r7.printStackTrace()
        Ld1:
            goto Ld3
        Ld2:
            throw r6
        Ld3:
            goto Ld2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.t2.a(java.lang.String, java.lang.String):boolean");
    }

    private static void a(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }
}
