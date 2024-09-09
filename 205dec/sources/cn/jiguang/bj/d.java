package cn.jiguang.bj;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f2663a = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    private static File a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public static String a(Context context, String str, int i4, String str2) {
        try {
            boolean b4 = f.b(context);
            cn.jiguang.bi.b.e("HttpUtils", " https sdk continueBusiness=" + b4);
            if (!b4) {
                cn.jiguang.bi.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection a4 = a(str);
            a4.setRequestProperty("Content-Type", "application/json");
            a4.setConnectTimeout(i4);
            a4.setReadTimeout(i4);
            a4.setRequestMethod("POST");
            a4.setDoOutput(true);
            a4.setDoInput(true);
            byte[] bytes = str2.getBytes();
            a4.getOutputStream().write(bytes);
            int responseCode = a4.getResponseCode();
            byte[] a5 = a(a4.getInputStream());
            f.a(context, str, bytes.length, a5 != null ? a5.length : 0);
            cn.jiguang.bi.b.e("HttpUtils", "httpPost:" + str + " responseCode:" + responseCode);
            if (200 == responseCode && a5 != null) {
                return new String(a5, "UTF-8");
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bi.b.a("HttpUtils", "httpPost:" + str + " fail.", th);
            return null;
        }
    }

    public static HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.InputStream r6) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26
            r1.<init>()     // Catch: java.lang.Throwable -> L26
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L24
        La:
            int r3 = r6.read(r2)     // Catch: java.lang.Throwable -> L24
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r1.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L24
            goto La
        L16:
            r1.flush()     // Catch: java.lang.Throwable -> L24
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24
            r6.close()
        L20:
            r1.close()
            goto L4a
        L24:
            r2 = move-exception
            goto L28
        L26:
            r2 = move-exception
            r1 = r0
        L28:
            java.lang.String r3 = "HttpUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r4.<init>()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = " readInputStream failed , error is : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L4b
            r4.append(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L4b
            cn.jiguang.bi.b.a(r3, r2)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L47
            r6.close()
        L47:
            if (r1 == 0) goto L4a
            goto L20
        L4a:
            return r0
        L4b:
            r0 = move-exception
            if (r6 == 0) goto L51
            r6.close()
        L51:
            if (r1 == 0) goto L56
            r1.close()
        L56:
            goto L58
        L57:
            throw r0
        L58:
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bj.d.a(java.io.InputStream):byte[]");
    }

    public static File b(Context context, String str, int i4, String str2) {
        try {
            boolean b4 = f.b(context);
            cn.jiguang.bi.b.e("HttpUtils", " https download continueBusiness=" + b4);
            if (!b4) {
                cn.jiguang.bi.b.e("HttpUtils", " https sdk limit");
                return null;
            }
            HttpURLConnection a4 = a(str);
            a4.setConnectTimeout(i4);
            a4.setReadTimeout(i4);
            int responseCode = a4.getResponseCode();
            byte[] a5 = a(a4.getInputStream());
            f.a(context, str, 0L, a5 != null ? a5.length : 0);
            cn.jiguang.bi.b.e("HttpUtils", "download:" + str + " responseCode:" + responseCode);
            if (200 != responseCode) {
                return null;
            }
            return a(str2, a5);
        } catch (Throwable th) {
            cn.jiguang.bi.b.a("HttpUtils", "download:" + str + " fail." + th.getMessage(), th);
            return null;
        }
    }
}
