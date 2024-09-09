package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.c1;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NetReuestParam.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x1 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f10381b = j1.t("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c  reason: collision with root package name */
    private static final String f10382c = j1.t("FbGJzX3Nkaw");

    /* renamed from: d  reason: collision with root package name */
    private static final String f10383d = j1.t("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e  reason: collision with root package name */
    private static final String f10384e = j1.t("FQU5EU0RLMTA");

    /* renamed from: f  reason: collision with root package name */
    private static final String f10385f = j1.t("FMTAw");

    /* renamed from: g  reason: collision with root package name */
    private static boolean f10386g = false;

    /* renamed from: a  reason: collision with root package name */
    private String f10387a = "";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NetReuestParam.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements c1.c {

        /* renamed from: a  reason: collision with root package name */
        private x1 f10388a = new x1();

        a() {
        }

        @Override // com.amap.api.col.s.c1.c
        public final String a() {
            return x1.e();
        }

        @Override // com.amap.api.col.s.c1.c
        public final dz b(byte[] bArr, Map<String, String> map) {
            return new t2(bArr, map);
        }

        @Override // com.amap.api.col.s.c1.c
        public final String a(Context context, String str) {
            return x1.b(context, str);
        }

        @Override // com.amap.api.col.s.c1.c
        public final Map<String, String> b() {
            return this.f10388a.d();
        }

        @Override // com.amap.api.col.s.c1.c
        public final String a(String str, String str2, String str3, String str4) {
            return this.f10388a.c(str, str2, str3, str4);
        }
    }

    public static c1.c a() {
        return new a();
    }

    public static String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(j1.t("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(j1.t("FZGF0YQ"))).optString(j1.t("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                y1.b(optString);
                t1.a(context).c(optString);
                return optString;
            }
            return "";
        } catch (JSONException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return y1.a();
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f10387a)) {
            return this.f10387a;
        }
        String a4 = d1.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < a4.length(); i4++) {
            stringBuffer.append((char) (a4.charAt(i4) - (i4 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i5 = 0; i5 < stringBuffer2.length() / 2; i5++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i5) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i5)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f10387a = stringBuffer4;
        return stringBuffer4;
    }

    public final String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(j1.t("LdGlk"), str);
            jSONObject.put(j1.t("FZGl1"), str2);
            jSONObject.put(j1.t("AZGl1Mg"), str3);
            jSONObject.put(j1.t("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String b4 = a2.b();
        if (!TextUtils.isEmpty(b4)) {
            String a4 = v1.a(q2.a((jSONObject2 + "\u0000").getBytes(), b4.getBytes()));
            if (!TextUtils.isEmpty(a4)) {
                try {
                    String a5 = v1.a(z1.b(b4.getBytes("utf-8"), z1.a(f())));
                    return j1.t("Fa2V5PQ") + URLEncoder.encode(a5) + j1.t("SJmRhdGE9") + URLEncoder.encode(a4);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> d() {
        if (f10386g) {
            return null;
        }
        f10386g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(j1.t("FZW50"), j1.t("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(j1.t("SY2hhbm5lbD0"));
        String str = f10382c;
        sb.append(str);
        sb.append(j1.t("SJmRpdj0"));
        String str2 = f10384e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(j1.t("FQA"));
        stringBuffer.append(f10383d);
        String d4 = a2.d(stringBuffer.toString());
        sb.append(j1.t("FJnNpZ249"));
        sb.append(d4.toUpperCase(Locale.US));
        sb.append(j1.t("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(j1.t("FaW4"), v1.a(q2.a(sb.toString().getBytes(), f10381b.getBytes())));
        hashMap.put(j1.t("Sa2V5dA"), f10385f);
        return hashMap;
    }
}
