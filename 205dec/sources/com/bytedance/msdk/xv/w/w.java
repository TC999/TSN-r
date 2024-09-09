package com.bytedance.msdk.xv.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.f.ia;
import com.bytedance.msdk.f.t;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.f.xv;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements c<com.bytedance.msdk.xv.c> {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f28585c = false;
    private static volatile boolean sr = true;
    private static volatile boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    public static volatile boolean f28586w;

    /* renamed from: f  reason: collision with root package name */
    private int f28587f = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f28588r = 0;
    private Context xv;

    public w(Context context) {
        this.xv = context;
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String c4 = com.bytedance.msdk.f.c.c();
                String str = 2 + c4 + com.bytedance.msdk.f.c.c(jSONObject.toString(), com.bytedance.msdk.f.c.c(c4));
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

    private String f(List<com.bytedance.msdk.xv.c> list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.msdk.xv.c cVar : list) {
                    jSONArray.put(cVar.f28472w);
                }
                jSONObject.put("stats_list", jSONArray);
                JSONObject c4 = c(jSONObject);
                c4.putOpt("ad_sdk_version", sr.w());
                c4.putOpt("plugin_version", sr.sr());
                return c4.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    private byte[] sr(List<com.bytedance.msdk.xv.c> list) {
        byte[] w3 = w(list);
        if (w3 == null) {
            c("buildAdEventV3Body", "zipData is null");
        } else if (w3.length <= 0) {
            c("buildAdEventV3Body", "zipData len 0");
        }
        byte[] c4 = c(w3, w3.length);
        if (c4 == null) {
            c("buildAdEventV3Body", "data is null");
        } else if (c4.length <= 0) {
            c("buildAdEventV3Body", "data len 0");
        }
        return c4;
    }

    private byte[] ux(List<com.bytedance.msdk.xv.c> list) {
        try {
            return c(xv.c(xv(list)).toString());
        } catch (Throwable th) {
            c("buildAdEventV3Body2", "exception: " + th.toString());
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.xv.f w(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            com.bytedance.msdk.w.w r5 = com.bytedance.msdk.w.w.c()
            com.bytedance.sdk.component.ev.c r5 = r5.w()
            com.bytedance.sdk.component.ev.w.sr r5 = r5.w()
            r5.c(r3)
            com.bytedance.msdk.core.w r3 = com.bytedance.msdk.core.w.k()
            java.lang.String r3 = r3.ev()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L29
            java.lang.String r0 = "X-Tt-Env"
            r5.w(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.w(r3, r0)
        L29:
            java.lang.String r3 = com.bytedance.msdk.c.sr.f27665c
            java.lang.String r0 = "User-Agent"
            r5.w(r0, r3)
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r0 = "union_sdk_encode"
            r5.w(r3, r0)
            r5.c(r6, r4)
            com.bytedance.sdk.component.ev.w r3 = r5.c()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L95
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L53
            java.lang.String r0 = r3.sr()     // Catch: org.json.JSONException -> L53
            r6.<init>(r0)     // Catch: org.json.JSONException -> L53
            boolean r6 = r2.w(r6)     // Catch: org.json.JSONException -> L53
            if (r6 == 0) goto L95
            r6 = 1
            goto L96
        L53:
            r6 = move-exception
            int r0 = r2.f28588r
            int r1 = r0 + 1
            r2.f28588r = r1
            r1 = 20
            if (r0 >= r1) goto L78
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "doUploadAdEvent"
            c(r1, r0)
        L78:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ignore:"
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uploadEvent"
            com.bytedance.msdk.adapter.sr.xv.sr(r1, r0)
            r6.printStackTrace()
        L95:
            r6 = 0
        L96:
            if (r3 == 0) goto L9d
            int r0 = r3.c()
            goto L9e
        L9d:
            r0 = 0
        L9e:
            if (r6 != 0) goto La7
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto La7
            java.lang.String r3 = "server say not success"
            goto Lb1
        La7:
            if (r3 == 0) goto Lae
            java.lang.String r3 = r3.w()
            goto Lb0
        Lae:
            java.lang.String r3 = "error unknown"
        Lb0:
            r4 = 0
        Lb1:
            com.bytedance.msdk.xv.f r5 = new com.bytedance.msdk.xv.f
            r5.<init>(r6, r0, r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xv.w.w.w(java.lang.String, byte[], java.util.Map, java.lang.String):com.bytedance.msdk.xv.f");
    }

    private JSONObject xv(List<com.bytedance.msdk.xv.c> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", t.xv());
            jSONObject.put("client_ip", t.w());
            jSONObject.put("header", t.r());
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.msdk.xv.c cVar : list) {
                jSONArray.put(cVar.f28472w);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e4) {
            c("getAdEventV3Json", "exception: " + e4.toString());
            e4.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.xv.f c(java.lang.String r3, byte[] r4, java.util.Map<java.lang.String, java.lang.String> r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r2 = this;
            com.bytedance.msdk.w.w r5 = com.bytedance.msdk.w.w.c()
            com.bytedance.sdk.component.ev.c r5 = r5.w()
            com.bytedance.sdk.component.ev.w.sr r5 = r5.w()
            r5.c(r3)
            com.bytedance.msdk.core.w r3 = com.bytedance.msdk.core.w.k()
            java.lang.String r3 = r3.ev()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L29
            java.lang.String r0 = "X-Tt-Env"
            r5.w(r0, r3)
            java.lang.String r3 = "x-use-ppe"
            java.lang.String r0 = "1"
            r5.w(r3, r0)
        L29:
            java.lang.String r3 = com.bytedance.msdk.c.sr.f27665c
            java.lang.String r0 = "User-Agent"
            r5.w(r0, r3)
            r5.c(r6, r4)
            com.bytedance.sdk.component.ev.w r3 = r5.c()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L8e
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4c
            java.lang.String r0 = r3.sr()     // Catch: org.json.JSONException -> L4c
            r6.<init>(r0)     // Catch: org.json.JSONException -> L4c
            boolean r6 = r2.w(r6)     // Catch: org.json.JSONException -> L4c
            if (r6 == 0) goto L8e
            r6 = 1
            goto L8f
        L4c:
            r6 = move-exception
            int r0 = r2.f28588r
            int r1 = r0 + 1
            r2.f28588r = r1
            r1 = 20
            if (r0 >= r1) goto L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "doUploadAdEvent"
            c(r1, r0)
        L71:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ignore:"
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "uploadEvent"
            com.bytedance.msdk.adapter.sr.xv.sr(r1, r0)
            r6.printStackTrace()
        L8e:
            r6 = 0
        L8f:
            if (r3 == 0) goto L96
            int r0 = r3.c()
            goto L97
        L96:
            r0 = 0
        L97:
            if (r6 != 0) goto La0
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto La0
            java.lang.String r3 = "server say not success"
            goto Laa
        La0:
            if (r3 == 0) goto La7
            java.lang.String r3 = r3.w()
            goto La9
        La7:
            java.lang.String r3 = "error unknown"
        La9:
            r4 = 0
        Laa:
            com.bytedance.msdk.xv.f r5 = new com.bytedance.msdk.xv.f
            r5.<init>(r6, r0, r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xv.w.w.c(java.lang.String, byte[], java.util.Map, java.lang.String):com.bytedance.msdk.xv.f");
    }

    private byte[] w(List<com.bytedance.msdk.xv.c> list) {
        GZIPOutputStream gZIPOutputStream = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject xv = xv(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(xv.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e4) {
                        e = e4;
                        gZIPOutputStream = gZIPOutputStream2;
                        c("buildAdEventV3BodyRaw", "exception: " + e.toString());
                        e.printStackTrace();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x015b  */
    @Override // com.bytedance.msdk.xv.w.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.msdk.xv.f c(java.util.List<com.bytedance.msdk.xv.c> r24) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.xv.w.w.c(java.util.List):com.bytedance.msdk.xv.f");
    }

    private Map<String, String> w() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM);
        return hashMap;
    }

    private boolean w(JSONObject jSONObject) {
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

    private String c(boolean z3, boolean z4) {
        if (z3) {
            if (ux) {
                ux = false;
                return "1";
            } else if (f28586w) {
                f28586w = false;
                return "4";
            }
        } else if (sr) {
            sr = false;
            return "1";
        } else if (f28585c) {
            f28585c = false;
            return "4";
        }
        return z4 ? "3" : "2";
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        return hashMap;
    }

    public byte[] c(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] c(byte[] bArr, int i4) {
        if (bArr != null && i4 > 0) {
            try {
                if (bArr.length == i4) {
                    return ia.c(bArr, i4);
                }
            } catch (Throwable th) {
                c(AdLogEventRepo.COL_ENCRYPT_TYPE, "exception: " + th.toString());
                th.printStackTrace();
                return null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("inputData is ");
        sb.append(bArr == null ? "null" : "0");
        c(AdLogEventRepo.COL_ENCRYPT_TYPE, sb.toString());
        return null;
    }

    public static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("v3_Id", str);
            jSONObject.putOpt("v3_err_msg", str2);
            wv.c(jSONObject);
        } catch (Throwable unused) {
        }
    }
}
