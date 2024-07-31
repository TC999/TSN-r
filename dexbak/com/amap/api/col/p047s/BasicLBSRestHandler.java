package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.s.b4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BasicLBSRestHandler<T, V> extends BasicHandler<T, V> {
    public BasicLBSRestHandler(Context context, T t) {
        super(context, t);
    }

    /* renamed from: S */
    private static String m53220S(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(m53219T(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    /* renamed from: T */
    private static String m53219T(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C2082j4.m52825i(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public static String m53218i(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C2082j4.m52825i(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            C2082j4.m52825i(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public abstract V mo52183I(String str) throws AMapException;

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected abstract String mo52182M();

    @Override // com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public Map<String, String> mo52383o() {
        return null;
    }

    @Override // com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: p */
    public Map<String, String> mo52199p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", C2016a1.m53274b(this.f5883q));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: q */
    public byte[] mo52382q() {
        try {
            String mo52182M = mo52182M();
            StringBuffer stringBuffer = new StringBuffer();
            if (mo52182M != null) {
                stringBuffer.append(mo52182M);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String m53220S = m53220S(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String m53275a = C2016a1.m53275a();
            stringBuffer3.append("&ts=".concat(String.valueOf(m53275a)));
            stringBuffer3.append("&scode=" + C2016a1.m53273c(this.f5883q, m53275a, m53220S));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            C2082j4.m52825i(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
