package com.umeng.socialize.p569a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: NetClient.java */
/* renamed from: com.umeng.socialize.a.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13309d {

    /* renamed from: a */
    private static final String f39301a = "NetClient";

    /* renamed from: a */
    public static JSONObject m13417a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(m13419a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (UPLog.m13369a() && (z || AzxConstant.f39292c)) {
                UPLog.m13366a(f39301a, "req: ", url, ShellAdbUtils.f33810d, jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (UPLog.m13369a() && (z || AzxConstant.f39292c)) {
                UPLog.m13366a(f39301a, "req: ", url, ShellAdbUtils.f33810d, jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m13419a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        UMZipUtils.m13371a(str.getBytes(), byteArrayOutputStream);
        byte[] m13388a = UMCryptXor.m13388a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(m13388a.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(m13388a);
            C13308c.m13424a(outputStream);
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
                        C13308c.m13424a(inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] m13388a2 = UMCryptXor.m13388a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                UMZipUtils.m13370b(m13388a2, byteArrayOutputStream);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13418a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.p569a.C13309d.m13418a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }
}
