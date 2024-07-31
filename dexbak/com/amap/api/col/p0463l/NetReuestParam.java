package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.DeviceInfo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.j5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NetReuestParam {

    /* renamed from: b */
    private static final String f4573b = C1925p4.m54183u("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c */
    private static final String f4574c = C1925p4.m54183u("FbGJzX3Nkaw");

    /* renamed from: d */
    private static final String f4575d = C1925p4.m54183u("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e */
    private static final String f4576e = C1925p4.m54183u("FQU5EU0RLMTA");

    /* renamed from: f */
    private static final String f4577f = C1925p4.m54183u("FMTAw");

    /* renamed from: g */
    private static boolean f4578g = false;

    /* renamed from: a */
    private String f4579a = "";

    /* compiled from: NetReuestParam.java */
    /* renamed from: com.amap.api.col.3l.j5$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    final class C1848a implements DeviceInfo.InterfaceC1831c {

        /* renamed from: a */
        private NetReuestParam f4580a = new NetReuestParam();

        C1848a() {
        }

        @Override // com.amap.api.col.p0463l.DeviceInfo.InterfaceC1831c
        /* renamed from: a */
        public final String mo54655a() {
            return NetReuestParam.m54657e();
        }

        @Override // com.amap.api.col.p0463l.DeviceInfo.InterfaceC1831c
        /* renamed from: b */
        public final AbstractC1840if mo54651b(byte[] bArr, Map<String, String> map) {
            return new ADIURequest(bArr, map);
        }

        @Override // com.amap.api.col.p0463l.DeviceInfo.InterfaceC1831c
        /* renamed from: a */
        public final String mo54654a(Context context, String str) {
            return NetReuestParam.m54660b(context, str);
        }

        @Override // com.amap.api.col.p0463l.DeviceInfo.InterfaceC1831c
        /* renamed from: b */
        public final Map<String, String> mo54652b() {
            return this.f4580a.m54658d();
        }

        @Override // com.amap.api.col.p0463l.DeviceInfo.InterfaceC1831c
        /* renamed from: a */
        public final String mo54653a(String str, String str2, String str3, String str4) {
            return this.f4580a.m54659c(str, str2, str3, str4);
        }
    }

    /* renamed from: a */
    public static DeviceInfo.InterfaceC1831c m54661a() {
        return new C1848a();
    }

    /* renamed from: b */
    public static String m54660b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(C1925p4.m54183u("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(C1925p4.m54183u("FZGF0YQ"))).optString(C1925p4.m54183u("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                NetworkParam.m54636b(optString);
                AdiuManager.m55028a(context).m55026c(optString);
                return optString;
            }
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static String m54657e() {
        return NetworkParam.m54637a();
    }

    /* renamed from: f */
    private String m54656f() {
        if (!TextUtils.isEmpty(this.f4579a)) {
            return this.f4579a;
        }
        String m54724a = Encrypt.m54724a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < m54724a.length(); i++) {
            stringBuffer.append((char) (m54724a.charAt(i) - (i % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f4579a = stringBuffer4;
        return stringBuffer4;
    }

    /* renamed from: c */
    public final String m54659c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C1925p4.m54183u("LdGlk"), str);
            jSONObject.put(C1925p4.m54183u("FZGl1"), str2);
            jSONObject.put(C1925p4.m54183u("AZGl1Mg"), str3);
            jSONObject.put(C1925p4.m54183u("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String m54526b = SecurityUtil.m54526b();
        if (!TextUtils.isEmpty(m54526b)) {
            String m54756a = Base64Util.m54756a(XXTEA.m54576a((jSONObject2 + "\u0000").getBytes(), m54526b.getBytes()));
            if (!TextUtils.isEmpty(m54756a)) {
                try {
                    String m54756a2 = Base64Util.m54756a(RSAUtil.m54577b(m54526b.getBytes("utf-8"), RSAUtil.m54578a(m54656f())));
                    return C1925p4.m54183u("Fa2V5PQ") + URLEncoder.encode(m54756a2) + C1925p4.m54183u("SJmRhdGE9") + URLEncoder.encode(m54756a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public final synchronized Map<String, String> m54658d() {
        if (f4578g) {
            return null;
        }
        f4578g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(C1925p4.m54183u("FZW50"), C1925p4.m54183u("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(C1925p4.m54183u("SY2hhbm5lbD0"));
        String str = f4574c;
        sb.append(str);
        sb.append(C1925p4.m54183u("SJmRpdj0"));
        String str2 = f4576e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(C1925p4.m54183u("FQA"));
        stringBuffer.append(f4575d);
        String m54524d = SecurityUtil.m54524d(stringBuffer.toString());
        sb.append(C1925p4.m54183u("FJnNpZ249"));
        sb.append(m54524d.toUpperCase(Locale.US));
        sb.append(C1925p4.m54183u("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(C1925p4.m54183u("FaW4"), Base64Util.m54756a(XXTEA.m54576a(sb.toString().getBytes(), f4573b.getBytes())));
        hashMap.put(C1925p4.m54183u("Sa2V5dA"), f4577f);
        return hashMap;
    }
}
