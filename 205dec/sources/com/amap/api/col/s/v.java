package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShareUrlSearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v extends a3<String, String> {

    /* renamed from: t  reason: collision with root package name */
    private String f10316t;

    public v(Context context, String str) {
        super(context, str);
        this.f10316t = str;
    }

    private static String i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String v3 = r4.v(jSONObject, "code");
            String v4 = r4.v(jSONObject, "message");
            if ("1".equals(v3)) {
                return r4.v(jSONObject, "transfer_url");
            }
            if (!"0".equals(v3)) {
                if (!"2".equals(v3)) {
                    if (!"3".equals(v3)) {
                        if (!"4".equals(v3)) {
                            if ("5".equals(v3)) {
                                throw new AMapException("\u77ed\u4e32\u5206\u4eab\u8ba4\u8bc1\u5931\u8d25", 0, v4);
                            }
                            return null;
                        }
                        throw new AMapException("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7", 0, v4);
                    }
                    throw new AMapException("\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5", 0, v4);
                }
                throw new AMapException("\u77ed\u4e32\u8bf7\u6c42\u5931\u8d25", 0, v4);
            }
            throw new AMapException("\u5176\u4ed6\u672a\u77e5\u9519\u8bef", 0, v4);
        } catch (JSONException e4) {
            j4.i(e4, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.a3
    protected final /* synthetic */ String I(String str) throws AMapException {
        return i(str);
    }

    @Override // com.amap.api.col.s.a3
    protected final String M() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.h();
    }

    @Override // com.amap.api.col.s.a3, com.amap.api.col.s.dz
    public final Map<String, String> o() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.f10316t));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.f10316t);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a4 = g1.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a4.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = g0.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e4) {
            j4.i(e4, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", d1.f(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }
}
