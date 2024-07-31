package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11137y;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* renamed from: com.kwad.sdk.core.network.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10440p {
    private static String awq = "";
    private static String awr = "";

    /* renamed from: DO */
    public static String m26068DO() {
        try {
            if (!TextUtils.isEmpty(awq)) {
                return awq;
            }
            String property = System.getProperty("http.agent");
            awq = property;
            if (TextUtils.isEmpty(property)) {
                return awq;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = awq.length();
            for (int i = 0; i < length; i++) {
                char charAt = awq.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            awq = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: DP */
    public static String m26067DP() {
        String m23580cg;
        if (!TextUtils.isEmpty(awr)) {
            return awr;
        }
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            m23580cg = C11137y.m23580cg(context);
            awr = m23580cg;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(m23580cg)) {
            return awr;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        awr = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        awr = encode;
        C11137y.m23599ai(context, encode);
        return awr;
    }

    /* renamed from: b */
    public static void m26066b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", m26067DP());
        httpURLConnection.setRequestProperty("SystemUa", m26068DO());
    }

    public static String getDefaultUserAgent() {
        return m26068DO() + "-ksad-android-3.3.59.1";
    }

    public static String getUserAgent() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).getUserAgent();
    }
}
