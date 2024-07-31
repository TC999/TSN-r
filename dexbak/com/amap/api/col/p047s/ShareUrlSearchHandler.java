package com.amap.api.col.p047s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ShareUrlSearchHandler extends BasicHandler<String, String> {

    /* renamed from: t */
    private String f6588t;

    public ShareUrlSearchHandler(Context context, String str) {
        super(context, str);
        this.f6588t = str;
    }

    /* renamed from: i */
    private static String m52397i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String m52484v = JSONHelper.m52484v(jSONObject, "code");
            String m52484v2 = JSONHelper.m52484v(jSONObject, "message");
            if ("1".equals(m52484v)) {
                return JSONHelper.m52484v(jSONObject, "transfer_url");
            }
            if (!"0".equals(m52484v)) {
                if (!"2".equals(m52484v)) {
                    if (!"3".equals(m52484v)) {
                        if (!"4".equals(m52484v)) {
                            if ("5".equals(m52484v)) {
                                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, m52484v2);
                            }
                            return null;
                        }
                        throw new AMapException("用户签名未通过", 0, m52484v2);
                    }
                    throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, m52484v2);
                }
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, m52484v2);
            }
            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, m52484v2);
        } catch (JSONException e) {
            C2082j4.m52825i(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    protected final /* synthetic */ String mo52183I(String str) throws AMapException {
        return m52397i(str);
    }

    @Override // com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        return null;
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52888h();
    }

    @Override // com.amap.api.col.p047s.BasicHandler, com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: o */
    public final Map<String, String> mo52383o() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.f6588t));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.f6588t);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String m52992a = C2059g1.m52992a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(m52992a.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = C2058g0.m52996a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            C2082j4.m52825i(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", C2040d1.m53091f(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }
}
