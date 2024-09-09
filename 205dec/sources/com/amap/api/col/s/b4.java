package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BasicLBSRestHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class b4<T, V> extends a3<T, V> {
    public b4(Context context, T t3) {
        super(context, t3);
    }

    private static String S(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(T(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String T(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            j4.i(e4, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e5) {
            j4.i(e5, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String i(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            j4.i(e4, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e5) {
            j4.i(e5, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a3
    public abstract V I(String str) throws AMapException;

    @Override // com.amap.api.col.s.a3
    protected abstract String M();

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", a1.b(this.f9633q));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public byte[] q() {
        try {
            String M = M();
            StringBuffer stringBuffer = new StringBuffer();
            if (M != null) {
                stringBuffer.append(M);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String S = S(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a4 = a1.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a4)));
            stringBuffer3.append("&scode=" + a1.c(this.f9633q, a4, S));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            j4.i(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
