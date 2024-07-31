package com.amap.api.col.p0463l;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: com.amap.api.col.3l.j2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class BaseTileRequest extends AbstractAMapRequest {
    public BaseTileRequest() {
        setProxy(ProxyUtil.m54440c(MapFragmentDelegateImp.f3708f));
        setConnectionTimeout(5000);
        setSoTimeout(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
    }

    /* renamed from: a */
    private static String m54686a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(m54685b(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    /* renamed from: b */
    private static String m54685b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            SDKLogHandler.m53863p(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            SDKLogHandler.m53863p(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appendTsScode(String str) {
        String m54686a = m54686a(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String m54933a = ClientInfo.m54933a();
        stringBuffer.append("&ts=".concat(String.valueOf(m54933a)));
        stringBuffer.append("&scode=" + ClientInfo.m54931c(MapFragmentDelegateImp.f3708f, m54933a, m54686a));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public String getIPV6URL() {
        String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : C1732a3.m55685y(url);
    }

    @Override // com.amap.api.col.p0463l.AbstractAMapRequest, com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", ConfigableConst.f3943c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "3dmap"));
        hashtable.put("x-INFO", ClientInfo.m54932b(MapFragmentDelegateImp.f3708f));
        hashtable.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(MapFragmentDelegateImp.f3708f));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
