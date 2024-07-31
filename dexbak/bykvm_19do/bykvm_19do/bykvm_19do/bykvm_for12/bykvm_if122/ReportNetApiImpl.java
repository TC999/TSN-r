package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.URLConst;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUploadResult;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventV3;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.AES;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTPangleUtil;
import com.bytedance.msdk.adapter.util.Logger;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ReportNetApiImpl implements ReportNetApi<AdEvent> {
    public ReportNetApiImpl(Context context) {
    }

    /* renamed from: a */
    public static JSONObject m59387a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String m59267a = AES.m59267a();
                String str = 2 + m59267a + AES.m59264b(jSONObject.toString(), AES.m59266a(m59267a));
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

    /* renamed from: b */
    private String m59384b(List<AdEvent> list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (AdEvent adEvent : list) {
                    jSONArray.put(adEvent.f561b);
                }
                jSONObject.put("stats_list", jSONArray);
                JSONObject m59387a = m59387a(jSONObject);
                m59387a.putOpt("ad_sdk_version", "2.9.2.1");
                return m59387a.toString();
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
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] m59382c(java.util.List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent> r5) {
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
            java.lang.String r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils.m59207i()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            java.lang.String r2 = "client_ip"
            java.lang.String r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils.m59223a()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            java.lang.String r2 = "header"
            org.json.JSONObject r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.DeviceUtils.m59208h()     // Catch: org.json.JSONException -> L5b
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L5b
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L5b
            r2.<init>()     // Catch: org.json.JSONException -> L5b
            java.util.Iterator r5 = r5.iterator()     // Catch: org.json.JSONException -> L5b
        L34:
            boolean r3 = r5.hasNext()     // Catch: org.json.JSONException -> L5b
            if (r3 == 0) goto L46
            java.lang.Object r3 = r5.next()     // Catch: org.json.JSONException -> L5b
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a r3 = (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent) r3     // Catch: org.json.JSONException -> L5b
            org.json.JSONObject r3 = r3.f561b     // Catch: org.json.JSONException -> L5b
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
            byte[] r5 = m59386a(r5, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApiImpl.m59382c(java.util.List):byte[]");
    }

    /* renamed from: b */
    private Map<String, String> m59385b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        return hashMap;
    }

    /* renamed from: b */
    private boolean m59383b(JSONObject jSONObject) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventUploadResult m59389a(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b r5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.TTNetClient.m59292b()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.a r5 = r5.m59293a()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c r5 = r5.m59082b()
            r5.m58997b(r3)
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo.m59939B()
            java.lang.String r3 = r3.m59898o()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L29
            java.lang.String r0 = "X-Tt-Env"
            r5.m58998a(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.m58998a(r3, r0)
        L29:
            java.lang.String r3 = com.bytedance.msdk.base.Sdk.f21749b
            java.lang.String r0 = "User-Agent"
            r5.m58998a(r0, r3)
            r5.m58995a(r6, r4)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.b r3 = r5.m58994b()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L6a
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4c
            java.lang.String r0 = r3.m59074a()     // Catch: org.json.JSONException -> L4c
            r6.<init>(r0)     // Catch: org.json.JSONException -> L4c
            boolean r6 = r2.m59383b(r6)     // Catch: org.json.JSONException -> L4c
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
            com.bytedance.msdk.adapter.util.Logger.m37557e(r1, r0)
            r6.printStackTrace()
        L6a:
            r6 = 0
        L6b:
            if (r3 == 0) goto L72
            int r0 = r3.m59073b()
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
            java.lang.String r3 = r3.m59071d()
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApiImpl.m59389a(java.lang.String, byte[], java.util.Map, java.lang.String):bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.f");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApi
    /* renamed from: a */
    public AdEventUploadResult mo59388a(List<AdEvent> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (AdEvent adEvent : list) {
                        if (adEvent instanceof AdEventV3) {
                            arrayList2.add(adEvent);
                        } else {
                            arrayList.add(adEvent);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return m59389a(URLConst.m59446d(), m59390a(m59384b(arrayList)), m59391a(), "application/json; charset=utf-8");
                    }
                    if (arrayList2.isEmpty()) {
                        return null;
                    }
                    return m59389a(URLConst.m59449a(), m59382c(arrayList2), m59385b(), "application/octet-stream;tt-data=a");
                }
            } catch (Throwable th) {
                Logger.m37556e("ReportNetApiImpl", "uploadEvent error", th);
                return new AdEventUploadResult(false, 509, "service_busy", false);
            }
        }
        return null;
    }

    /* renamed from: a */
    private Map<String, String> m59391a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        return hashMap;
    }

    /* renamed from: a */
    public byte[] m59390a(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    /* renamed from: a */
    public static byte[] m59386a(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTPangleUtil.m59103b(bArr, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
