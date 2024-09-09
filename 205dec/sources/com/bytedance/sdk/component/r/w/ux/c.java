package com.bytedance.sdk.component.r.w.ux;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import com.bytedance.sdk.component.r.c.c.f;
import com.bytedance.sdk.component.r.c.ev;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.r.w.xv.xv;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.r.c.c.c<com.bytedance.sdk.component.r.c.w> {

    /* renamed from: w  reason: collision with root package name */
    private static final SimpleDateFormat f30105w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private ux sr;
    private final String xv = "x-pglcypher";

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30106c = w();

    private int sr(JSONObject jSONObject) {
        int indexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String optString = jSONObject.optString("s_sig_ts");
            if (optString != null && (indexOf = optString.indexOf("_")) >= 5) {
                String substring = optString.substring(0, indexOf);
                String substring2 = optString.substring(indexOf + 1);
                JSONObject p3 = c().sr().a().p();
                String optString2 = p3 != null ? p3.optString("device_id") : "";
                if (c(optString2 + "_" + substring, substring2)) {
                    return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(substring).longValue()) > 300 ? 513 : 0;
                }
                return 512;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    private boolean ux(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private String w(int i4) {
        return i4 >= 4 ? "application/octet-stream" : EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM;
    }

    public static byte[] w(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    public boolean xv(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase("success");
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ux c() {
        if (this.sr == null) {
            this.sr = com.bytedance.sdk.component.r.w.c.xv("csj").ux();
        }
        return this.sr;
    }

    private static boolean w() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static PublicKey xv() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    public List<com.bytedance.sdk.component.r.c.w> w(List<com.bytedance.sdk.component.r.c.w> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject r3 = wVar.r();
                String optString = r3.optString("label");
                if (TextUtils.isEmpty(optString)) {
                    optString = r3.optString("event");
                }
                jSONObject.putOpt("event", optString);
                long optLong = r3.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", f30105w.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (r3.has(EventMonitor.V3_PARAMS) && r3.has("event")) {
                    jSONObject2 = r3.optJSONObject(EventMonitor.V3_PARAMS);
                } else {
                    Iterator<String> keys = r3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, r3.opt(next));
                        }
                    }
                }
                jSONObject.putOpt(EventMonitor.V3_PARAMS, jSONObject2);
                com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(wVar.xv(), jSONObject);
                cVar.c(wVar.sr());
                cVar.w(wVar.ux());
                arrayList.add(cVar);
            } catch (Exception e4) {
                xv.sr(e4.getMessage(), c());
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.r.c.c.c
    public com.bytedance.sdk.component.r.w.w.xv.w c(List<com.bytedance.sdk.component.r.c.w> list) {
        ev a4;
        com.bytedance.sdk.component.r.w.w.xv.w c4;
        String str;
        sr sr = c().sr();
        if (sr != null) {
            try {
                if (sr.sr() && (a4 = sr.a()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str2 = "1streqid";
                    String str3 = "2ndreqid";
                    String str4 = "";
                    boolean z3 = false;
                    for (com.bytedance.sdk.component.r.c.w wVar : list) {
                        try {
                            if (TextUtils.equals("show", com.bytedance.sdk.component.r.w.xv.c.c(wVar, c()))) {
                                String c5 = com.bytedance.sdk.component.r.w.xv.c.c(wVar.r(), this.sr);
                                if (!z3) {
                                    str = com.bytedance.sdk.component.r.w.xv.c.f(wVar, this.sr);
                                } else {
                                    str3 = com.bytedance.sdk.component.r.w.xv.c.f(wVar, this.sr);
                                    str = str3;
                                }
                                str4 = c5;
                                str2 = str;
                                z3 = true;
                            }
                            arrayList.add(wVar);
                        } catch (Throwable th) {
                            th = th;
                            xv.sr(EventNetApiImpl.TAG, "uploadEvent error" + th.getMessage(), c());
                            return new com.bytedance.sdk.component.r.w.w.xv.w(false, 509, th.getMessage(), false, "error");
                        }
                    }
                    int k4 = a4.k();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject c6 = a4.c(w(arrayList), this.f30106c);
                    byte[] c7 = a4.c(c6, k4);
                    if (c7 == null) {
                        JSONObject c8 = a4.c(c6);
                        c7 = w(c8);
                        c4 = c(c7, c(c8, k4), "application/json; charset=utf-8");
                    } else {
                        c4 = c(c7, c(k4), w(k4));
                    }
                    if (z3) {
                        int length = c7 != null ? c7.length : 0;
                        if (c4 != null) {
                            boolean z4 = c4.f30161c;
                            int i4 = c4.f30162w;
                            String str5 = c4.xv;
                            com.bytedance.sdk.component.r.w.xv.c.c(z4, i4, str5, str2 + "|" + str3, length, str4);
                        }
                    }
                    return c4;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private void w(byte[] bArr, Map<String, String> map, String str) {
        ux c4;
        sr sr;
        ev a4;
        if (bArr == null || bArr.length == 0 || (c4 = c()) == null || (sr = c4.sr()) == null || (a4 = sr.a()) == null || !a4.c()) {
            return;
        }
        f ux = a4.ux();
        ux.c(a4.w());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ux.c(entry.getKey(), entry.getValue());
            }
        }
        ux.c(str, bArr);
        ux.c("User-Agent", sr.ux());
        ux.c(new com.bytedance.sdk.component.r.c.c.xv() { // from class: com.bytedance.sdk.component.r.w.ux.c.1
            @Override // com.bytedance.sdk.component.r.c.c.xv
            public void c(com.bytedance.sdk.component.r.c.c.sr srVar, com.bytedance.sdk.component.r.c.c.ux uxVar) {
                if (uxVar == null || !uxVar.c()) {
                    xv.c(EventNetApiImpl.TAG, "onResponse: NetResponse is null", c.this.c());
                    return;
                }
                xv.c(EventNetApiImpl.TAG, "onResponse: " + uxVar.w(), c.this.c());
            }

            @Override // com.bytedance.sdk.component.r.c.c.xv
            public void c(com.bytedance.sdk.component.r.c.c.sr srVar, IOException iOException) {
                xv.c(EventNetApiImpl.TAG, "onFailure: " + iOException.getMessage(), c.this.c());
            }
        });
    }

    private Map<String, String> c(int i4) {
        HashMap hashMap = new HashMap();
        if (i4 >= 4) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        hashMap.put("x-pglcypher", String.valueOf(i4));
        hashMap.put("Content-Type", w(i4));
        return hashMap;
    }

    private Map<String, String> c(JSONObject jSONObject, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (ux(jSONObject)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        hashMap.put("x-pglcypher", String.valueOf(i4));
        return hashMap;
    }

    private com.bytedance.sdk.component.r.w.w.xv.w c(byte[] bArr, Map<String, String> map, String str) {
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        boolean z5;
        String str2;
        try {
            sr sr = c().sr();
            ev a4 = sr.a();
            f ux = a4.ux();
            ux.c(a4.f());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    ux.c(entry.getKey(), entry.getValue());
                }
            }
            ux.c(str, bArr);
            ux.c("User-Agent", sr.ux());
            com.bytedance.sdk.component.r.c.c.ux c4 = ux.c();
            if (c4 == null) {
                return new com.bytedance.sdk.component.r.w.w.xv.w(false, 510, "RSP IS NULL", false, "error");
            }
            if (!c4.c() || TextUtils.isEmpty(c4.w())) {
                i4 = 0;
                z3 = false;
            } else {
                JSONObject jSONObject = new JSONObject(c4.w());
                z3 = xv(jSONObject);
                i4 = sr(jSONObject);
            }
            int xv = c4.xv();
            String str3 = c4.ux() != null ? c4.ux().get("x-tt-logid") : "error";
            boolean z6 = !z3 && xv == 200;
            String sr2 = c4.sr();
            sr2 = (sr2 == null || TextUtils.isEmpty(sr2)) ? "DEFAULT OK" : "DEFAULT OK";
            if (i4 != 0) {
                str2 = "RSP FAIL";
                i5 = i4;
                z4 = false;
                z5 = true;
            } else {
                z4 = z3;
                i5 = xv;
                z5 = z6;
                str2 = sr2;
            }
            w(bArr, map, str);
            return new com.bytedance.sdk.component.r.w.w.xv.w(z4, i5, str2, z5, str3);
        } catch (Throwable th) {
            xv.sr(EventNetApiImpl.TAG, "uploadEvent error" + th.getMessage(), c());
            return new com.bytedance.sdk.component.r.w.w.xv.w(false, 511, th.getMessage(), false, "error");
        }
    }

    private boolean c(String str, String str2) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(xv().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(generatePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @Override // com.bytedance.sdk.component.r.c.c.c
    public com.bytedance.sdk.component.r.w.w.xv.w c(JSONObject jSONObject) {
        ev a4;
        com.bytedance.sdk.component.r.c.c.ux c4;
        sr sr = c().sr();
        if (sr == null || !sr.sr() || jSONObject == null || jSONObject.length() <= 0 || (a4 = sr.a()) == null) {
            return null;
        }
        f ux = a4.ux();
        ux.c(a4.r());
        if (a4.gd()) {
            int a5 = a4.a();
            byte[] w3 = a4.w(jSONObject, a5);
            if (w3 == null) {
                ux.w(a4.c(jSONObject).toString());
            } else {
                ux.c(w(a5), w3);
                ux.c("x-pglcypher", String.valueOf(a5));
            }
        } else {
            ux.w(a4.c(jSONObject).toString());
        }
        ux.c("User-Agent", sr.ux());
        boolean z3 = false;
        int i4 = 0;
        String str = "error unknown";
        boolean z4 = false;
        try {
            c4 = ux.c();
        } catch (Throwable unused) {
        }
        if (c4 == null) {
            return new com.bytedance.sdk.component.r.w.w.xv.w(false, 0, "error unknown", false, "ignore");
        }
        if (c4.c() && !TextUtils.isEmpty(c4.w())) {
            JSONObject jSONObject2 = new JSONObject(c4.w());
            int optInt = jSONObject2.optInt("code", -1);
            str = jSONObject2.optString("data", "");
            z3 = optInt == 20000;
            if (optInt == 60005) {
                z4 = true;
            }
        }
        i4 = c4.xv();
        if (!c4.c()) {
            str = c4.sr();
        }
        return new com.bytedance.sdk.component.r.w.w.xv.w(z3, i4, str, z4, "ignore");
    }
}
