package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.c;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.w;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportNetApiImpl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements a<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> {
    public b(Context context) {
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a();
                String str = 2 + a4 + bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a.a(a4));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    private String b(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a aVar : list) {
                    jSONArray.put(aVar.f554b);
                }
                jSONObject.put("stats_list", jSONArray);
                JSONObject a4 = a(jSONObject);
                a4.putOpt("ad_sdk_version", "2.9.2.1");
                return a4.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.zip.GZIPOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] c(java.util.List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto La1
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto Lb
            goto La1
        Lb:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "http_user_agent"
            java.lang.String r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.i()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            java.lang.String r2 = "client_ip"
            java.lang.String r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.a()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            java.lang.String r2 = "header"
            org.json.JSONObject r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i.h()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L5b
            r2.<init>()     // Catch: org.json.JSONException -> L5b
            java.util.Iterator r5 = r5.iterator()     // Catch: org.json.JSONException -> L5b
        L34:
            boolean r3 = r5.hasNext()     // Catch: org.json.JSONException -> L5b
            if (r3 == 0) goto L46
            java.lang.Object r3 = r5.next()     // Catch: org.json.JSONException -> L5b
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a r3 = (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a) r3     // Catch: org.json.JSONException -> L5b
            org.json.JSONObject r3 = r3.f554b     // Catch: org.json.JSONException -> L5b
            r2.put(r3)     // Catch: org.json.JSONException -> L5b
            goto L34
        L46:
            java.lang.String r5 = "event_v3"
            r1.put(r5, r2)     // Catch: org.json.JSONException -> L5b
            java.lang.String r5 = "magic_tag"
            java.lang.String r2 = "ss_app_log"
            r1.put(r5, r2)     // Catch: org.json.JSONException -> L5b
            java.lang.String r5 = "_gen_time"
            long r2 = java.lang.System.currentTimeMillis()     // Catch: org.json.JSONException -> L5b
            r1.put(r5, r2)     // Catch: org.json.JSONException -> L5b
        L5b:
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream
            r2 = 8192(0x2000, float:1.148E-41)
            r5.<init>(r2)
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L94
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L94
            r2.write(r0)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L94
            r2.close()     // Catch: java.io.IOException -> L86
            goto L8a
        L76:
            r0 = move-exception
            goto L7d
        L78:
            r5 = move-exception
            goto L96
        L7a:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L7d:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L86
            goto L8a
        L86:
            r0 = move-exception
            r0.printStackTrace()
        L8a:
            byte[] r5 = r5.toByteArray()
            int r0 = r5.length
            byte[] r5 = a(r5, r0)
            return r5
        L94:
            r5 = move-exception
            r0 = r2
        L96:
            if (r0 == 0) goto La0
            r0.close()     // Catch: java.io.IOException -> L9c
            goto La0
        L9c:
            r0 = move-exception
            r0.printStackTrace()
        La0:
            throw r5
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.c(java.util.List):byte[]");
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM);
        return hashMap;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code") != 20000) {
                    if (!"success".equals(jSONObject.optString("message"))) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f a(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b r5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b.b()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a r5 = r5.a()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c r5 = r5.b()
            r5.b(r3)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B()
            java.lang.String r3 = r3.o()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L29
            java.lang.String r0 = "X-Tt-Env"
            r5.a(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.a(r3, r0)
        L29:
            java.lang.String r3 = com.bytedance.msdk.base.b.f27663b
            java.lang.String r0 = "User-Agent"
            r5.a(r0, r3)
            r5.a(r6, r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b r3 = r5.b()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L6a
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4c
            java.lang.String r0 = r3.a()     // Catch: org.json.JSONException -> L4c
            r6.<init>(r0)     // Catch: org.json.JSONException -> L4c
            boolean r6 = r2.b(r6)     // Catch: org.json.JSONException -> L4c
            if (r6 == 0) goto L6a
            r6 = 1
            goto L6b
        L4c:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ignore:"
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uploadEvent"
            com.bytedance.msdk.adapter.util.Logger.e(r1, r0)
            r6.printStackTrace()
        L6a:
            r6 = 0
        L6b:
            if (r3 == 0) goto L72
            int r0 = r3.b()
            goto L73
        L72:
            r0 = 0
        L73:
            if (r6 != 0) goto L7c
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L7c
            java.lang.String r3 = "server say not success"
            goto L86
        L7c:
            if (r3 == 0) goto L83
            java.lang.String r3 = r3.d()
            goto L85
        L83:
            java.lang.String r3 = "error unknown"
        L85:
            r4 = 0
        L86:
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f r5 = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f
            r5.<init>(r6, r0, r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b.a(java.lang.String, byte[], java.util.Map, java.lang.String):bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a
    public f a(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a aVar : list) {
                        if (aVar instanceof h) {
                            arrayList2.add(aVar);
                        } else {
                            arrayList.add(aVar);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return a(c.d(), a(b(arrayList)), a(), "application/json; charset=utf-8");
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    return a(c.a(), c(arrayList2), b(), EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM);
                }
            } catch (Throwable th) {
                Logger.e("ReportNetApiImpl", "uploadEvent error", th);
                return new f(false, 509, "service_busy", false);
            }
        }
        return null;
    }

    private Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        return hashMap;
    }

    public byte[] a(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr, int i4) {
        if (bArr != null && i4 > 0) {
            try {
                if (bArr.length == i4) {
                    return w.b(bArr, i4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
