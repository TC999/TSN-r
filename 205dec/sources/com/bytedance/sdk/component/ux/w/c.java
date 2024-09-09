package com.bytedance.sdk.component.ux.w;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.ux.sr<sr> {
    private Map<String, String> c(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // com.bytedance.sdk.component.ux.sr
    public sr call(com.bytedance.sdk.component.ux.ux uxVar) {
        Closeable closeable;
        InputStream inputStream;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        String message;
        Closeable closeable2;
        HttpURLConnection httpURLConnection;
        int i4 = 0;
        InputStream inputStream2 = null;
        Map<String, String> map = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(uxVar.c()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (MalformedURLException e4) {
                e = e4;
                inputStream = null;
                bArr = null;
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
                bArr = null;
            } catch (Throwable th) {
                th = th;
                closeable = null;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream2);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable);
                throw th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (MalformedURLException e6) {
                        e = e6;
                        bArr = null;
                    } catch (IOException e7) {
                        e = e7;
                        bArr = null;
                    }
                }
                i4 = 200;
                bArr = byteArrayOutputStream.toByteArray();
            } catch (MalformedURLException e8) {
                e = e8;
                bArr = null;
                byteArrayOutputStream = bArr;
                Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                return new sr(i4, bArr, message, map);
            } catch (IOException e9) {
                e = e9;
                bArr = null;
                byteArrayOutputStream = bArr;
                Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                return new sr(i4, bArr, message, map);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                inputStream2 = inputStream;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream2);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable);
                throw th;
            }
            try {
                map = uxVar.w() ? c(httpURLConnection) : null;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                com.bytedance.sdk.component.ux.xv.xv.w.c(byteArrayOutputStream);
                message = "success";
            } catch (MalformedURLException e10) {
                e = e10;
                Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                return new sr(i4, bArr, message, map);
            } catch (IOException e11) {
                e = e11;
                Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                message = e.getMessage();
                closeable2 = byteArrayOutputStream;
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
                com.bytedance.sdk.component.ux.xv.xv.w.c(closeable2);
                return new sr(i4, bArr, message, map);
            }
            return new sr(i4, bArr, message, map);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
