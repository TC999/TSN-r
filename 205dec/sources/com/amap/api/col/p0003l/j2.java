package com.amap.api.col.p0003l;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BaseTileRequest.java */
/* renamed from: com.amap.api.col.3l.j2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class j2 extends f2 {
    public j2() {
        setProxy(o4.c(c.f7290f));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    private static String a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(b(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            u5.p(e4, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e5) {
            u5.p(e5, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appendTsScode(String str) {
        String a4 = a(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a5 = h4.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a5)));
        stringBuffer.append("&scode=" + h4.c(c.f7290f, a5, a4));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getIPV6URL() {
        String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : a3.y(url);
    }

    @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", fa.f7732c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "3dmap"));
        hashtable.put("x-INFO", h4.b(c.f7290f));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(c.f7290f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
