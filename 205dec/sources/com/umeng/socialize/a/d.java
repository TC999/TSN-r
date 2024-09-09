package com.umeng.socialize.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: NetClient.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53890a = "NetClient";

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z3) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (m.a() && (z3 || a.f53878c)) {
                m.a("NetClient", "req: ", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (m.a() && (z3 || a.f53878c)) {
                m.a("NetClient", "req: ", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(str.getBytes(), byteArrayOutputStream);
        byte[] a4 = i.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a4.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(a4);
            c.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        c.a(inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a5 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                l.b(a5, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.a.d.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }
}
