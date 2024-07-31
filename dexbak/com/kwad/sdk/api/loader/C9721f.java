package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.clj.fastble.BleManager;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.C9712a;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.api.loader.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class C9721f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InterfaceC9763v amj;
    private int amk;
    private String aml;
    private final String mUrl;

    /* renamed from: com.kwad.sdk.api.loader.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9722a {
        /* renamed from: a */
        void mo27886a(C9712a.C9714b c9714b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9721f(InterfaceC9763v interfaceC9763v) {
        this.amj = interfaceC9763v;
        String mo27834Am = interfaceC9763v.mo27834Am();
        this.mUrl = mo27834Am;
        this.aml = mo27834Am;
    }

    /* renamed from: Ad */
    private static Map<String, String> m27943Ad() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    /* renamed from: cc */
    private static HttpURLConnection m27939cc(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(BleManager.f22896l);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    /* renamed from: e */
    private String m27938e(Map<String, String> map) {
        String m27934az = C9723g.m27934az(this.amj.getContext());
        if (TextUtils.isEmpty(m27934az)) {
            m27934az = this.amj.mo27833An().getSDKVersion();
        }
        int sDKVersionCode = this.amj.mo27833An().getSDKVersionCode();
        JSONObject appInfo = this.amj.mo27833An().getAppInfo();
        JSONObject deviceInfo = this.amj.mo27833An().getDeviceInfo();
        JSONObject networkInfo = this.amj.mo27833An().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        C9730l.putValue(jSONObject, "sdkApiVersion", BuildConfig.VERSION_NAME);
        C9730l.putValue(jSONObject, "sdkApiVersionCode", (int) BuildConfig.VERSION_CODE);
        C9730l.putValue(jSONObject, "sdkVersion", m27934az);
        C9730l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        C9730l.putValue(jSONObject, "sdkType", 1);
        C9730l.putValue(jSONObject, "appInfo", appInfo);
        C9730l.putValue(jSONObject, "deviceInfo", deviceInfo);
        C9730l.putValue(jSONObject, "networkInfo", networkInfo);
        C9730l.putValue(jSONObject, "sdkAbi", C9764w.m27832xK());
        String jSONObject2 = jSONObject.toString();
        this.amj.mo27833An().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        C9730l.putValue(jSONObject3, ConstantHelper.LOG_VS, BuildConfig.VERSION_NAME);
        C9730l.putValue(jSONObject3, "appId", appInfo.optString("appId"));
        C9730l.putValue(jSONObject3, "message", this.amj.mo27833An().getRM(jSONObject2));
        this.amj.mo27833An().mo28006sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    /* renamed from: a */
    public final void m27942a(InterfaceC9722a interfaceC9722a) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> m27943Ad = m27943Ad();
            String m27938e = m27938e(m27943Ad);
            HttpURLConnection m27939cc = m27939cc(this.aml);
            m27940a(m27939cc, m27943Ad);
            m27939cc.connect();
            new DataOutputStream(m27939cc.getOutputStream()).write(m27938e.getBytes());
            int responseCode = m27939cc.getResponseCode();
            if (responseCode == 200) {
                String m27941a = m27941a(m27939cc.getInputStream());
                C9712a.C9714b c9714b = new C9712a.C9714b();
                JSONObject jSONObject = new JSONObject(m27941a);
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                    jSONObject.put("data", new JSONObject(this.amj.mo27833An().getRD(optString)));
                }
                c9714b.parseJson(jSONObject);
                interfaceC9722a.mo27886a(c9714b);
            } else if (responseCode / 100 == 3) {
                if (this.amk < 21) {
                    this.aml = m27939cc.getHeaderField(HttpHeaders.Names.LOCATION);
                    this.amk++;
                    m27942a(interfaceC9722a);
                }
            } else {
                throw new RuntimeException("response code = " + responseCode);
            }
            try {
                m27939cc.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:36:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m27941a(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
        La:
            int r3 = r5.read(r0)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            goto La
        L16:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r5.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r5 = move-exception
            r5.printStackTrace()
        L22:
            r2.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r5 = move-exception
            r5.printStackTrace()
        L2a:
            return r0
        L2b:
            r0 = move-exception
            goto L31
        L2d:
            r0 = move-exception
            goto L4b
        L2f:
            r0 = move-exception
            r2 = r1
        L31:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L3e
            r5.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r5 = move-exception
            r5.printStackTrace()
        L3e:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r5 = move-exception
            r5.printStackTrace()
        L48:
            return r1
        L49:
            r0 = move-exception
            r1 = r2
        L4b:
            if (r5 == 0) goto L55
            r5.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r5 = move-exception
            r5.printStackTrace()
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r5 = move-exception
            r5.printStackTrace()
        L5f:
            goto L61
        L60:
            throw r0
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.C9721f.m27941a(java.io.InputStream):java.lang.String");
    }

    /* renamed from: a */
    private static void m27940a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
