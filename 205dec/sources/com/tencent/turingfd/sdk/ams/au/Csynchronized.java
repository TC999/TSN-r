package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import com.tencent.turingfd.sdk.ams.au.Apricot;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.synchronized  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Csynchronized {
    public static Apricot a(Vulpecula vulpecula, URL url, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            int i4 = Build.VERSION.SDK_INT;
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestProperty("User-Agent", "Turing");
                httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod(vulpecula.f52211b);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(vulpecula.f52213d);
                httpURLConnection.setReadTimeout(vulpecula.f52214e);
                httpURLConnection.setInstanceFollowRedirects(vulpecula.f52215f);
                Apricot.Cdo cdo = new Apricot.Cdo();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    if (responseCode != 305) {
                        switch (responseCode) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                cdo.f51883a = responseCode;
                                Apricot apricot = new Apricot(cdo);
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                                return apricot;
                        }
                    }
                    cdo.f51883a = responseCode;
                    cdo.f51886d = true;
                    cdo.f51885c = httpURLConnection.getHeaderField("Location");
                    Apricot apricot2 = new Apricot(cdo);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return apricot2;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Ara.a(bufferedInputStream2, byteArrayOutputStream);
                    URL url2 = httpURLConnection.getURL();
                    if (!url.getHost().equals(url2.getHost())) {
                        cdo.f51886d = true;
                        cdo.f51885c = url2.toString();
                    }
                    cdo.f51884b = byteArrayOutputStream.toByteArray();
                    Apricot apricot3 = new Apricot(cdo);
                    Ara.a(bufferedInputStream2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    return apricot3;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    Ara.a(bufferedInputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }
}
