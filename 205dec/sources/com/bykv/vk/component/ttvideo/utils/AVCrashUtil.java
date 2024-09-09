package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class AVCrashUtil {
    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[10240];
        while (true) {
            int read = inputStream.read(bArr, 0, 10240);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:44:0x0080, B:48:0x0088), top: B:80:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            java.io.File r6 = new java.io.File
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L7a java.io.IOException -> L90 java.io.FileNotFoundException -> La3
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L91 java.io.FileNotFoundException -> La4
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r3 = -1
            if (r5 == r3) goto L59
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            goto L4e
        L59:
            r2.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            r6.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
            if (r7 == 0) goto L64
            r0.delete()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L73 java.io.FileNotFoundException -> L75
        L64:
            r4 = 1
            r2.close()     // Catch: java.io.IOException -> L6c
            r6.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r5 = move-exception
            r5.printStackTrace()
        L70:
            return r4
        L71:
            r4 = move-exception
            goto L7e
        L73:
            r4 = r2
            goto L91
        L75:
            r4 = r2
            goto La4
        L77:
            r5 = move-exception
            r2 = r4
            goto L7d
        L7a:
            r5 = move-exception
            r6 = r4
            r2 = r6
        L7d:
            r4 = r5
        L7e:
            if (r2 == 0) goto L86
            r2.close()     // Catch: java.io.IOException -> L84
            goto L86
        L84:
            r5 = move-exception
            goto L8c
        L86:
            if (r6 == 0) goto L8f
            r6.close()     // Catch: java.io.IOException -> L84
            goto L8f
        L8c:
            r5.printStackTrace()
        L8f:
            throw r4
        L90:
            r6 = r4
        L91:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L97
            goto L99
        L97:
            r4 = move-exception
            goto L9f
        L99:
            if (r6 == 0) goto La2
            r6.close()     // Catch: java.io.IOException -> L97
            goto La2
        L9f:
            r4.printStackTrace()
        La2:
            return r1
        La3:
            r6 = r4
        La4:
            if (r4 == 0) goto Lac
            r4.close()     // Catch: java.io.IOException -> Laa
            goto Lac
        Laa:
            r4 = move-exception
            goto Lb2
        Lac:
            if (r6 == 0) goto Lb5
            r6.close()     // Catch: java.io.IOException -> Laa
            goto Lb5
        Lb2:
            r4.printStackTrace()
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.AVCrashUtil.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    public static void deleteCrashFile(Context context, String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) {
        FileInputStream fileInputStream;
        if (context != null && str != null) {
            File file = new File(str);
            if (!file.exists()) {
                sb.append("file not exist.path:");
                sb.append(str);
                sb.append("\r\n");
                return null;
            } else if (file.length() == 0) {
                sb.append("file size is zore.");
                sb.append("\r\n");
                return null;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                }
                try {
                    compress(fileInputStream, byteArrayOutputStream);
                    fileInputStream.close();
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    byteArrayOutputStream.close();
                    return encodeToString;
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                    sb.append("gzip file is error.error:");
                    sb.append(e.getMessage());
                    return null;
                }
            }
        }
        sb.append("context or path is null.\r\n");
        return null;
    }

    public static final boolean moveFile(String str, String str2, boolean z3) {
        return copyFile(str, str2, z3, true);
    }
}
