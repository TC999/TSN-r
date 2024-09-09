package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.q6;
import com.amap.api.col.p0003l.z7;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapDnsManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f11913a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f11914b = 2;

    /* renamed from: e  reason: collision with root package name */
    private static a f11915e;

    /* renamed from: j  reason: collision with root package name */
    private Context f11922j;

    /* renamed from: k  reason: collision with root package name */
    private String f11923k;

    /* renamed from: c  reason: collision with root package name */
    private long f11916c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11917d = false;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f11918f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f11919g = new com.autonavi.aps.amapapi.d();

    /* renamed from: h  reason: collision with root package name */
    private com.autonavi.aps.amapapi.d f11920h = new com.autonavi.aps.amapapi.d();

    /* renamed from: i  reason: collision with root package name */
    private long f11921i = PolicyConfig.THREAD_BLOCK_TIMEOUT;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11924l = false;

    private a(Context context) {
        this.f11922j = context;
    }

    private static String c(int i4) {
        return i4 == f11914b ? "last_ip_6" : "last_ip_4";
    }

    private void d(int i4) {
        if (b(i4).d()) {
            SharedPreferences.Editor a4 = i.a(this.f11922j, "cbG9jaXA");
            i.a(a4, c(i4));
            i.a(a4);
            b(i4).a(false);
        }
    }

    private String e(int i4) {
        String str;
        int i5 = 0;
        b(false, i4);
        String[] a4 = b(i4).a();
        if (a4 != null && a4.length > 0) {
            int length = a4.length;
            while (true) {
                if (i5 >= length) {
                    str = null;
                    break;
                }
                str = a4[i5];
                if (!this.f11918f.contains(str)) {
                    break;
                }
                i5++;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            b(i4).a(str);
            return str;
        }
        g(i4);
        return b(i4).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i4) {
        if (b(i4).a() == null || b(i4).a().length <= 0) {
            return;
        }
        String str = b(i4).a()[0];
        if (str.equals(this.f11923k) || this.f11918f.contains(str)) {
            return;
        }
        this.f11923k = str;
        SharedPreferences.Editor a4 = i.a(this.f11922j, "cbG9jaXA");
        i.a(a4, c(i4), str);
        i.a(a4);
    }

    private void g(int i4) {
        String a4 = i.a(this.f11922j, "cbG9jaXA", c(i4), (String) null);
        if (TextUtils.isEmpty(a4) || this.f11918f.contains(a4)) {
            return;
        }
        b(i4).a(a4);
        b(i4).b(a4);
        b(i4).a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.autonavi.aps.amapapi.d b(int i4) {
        if (i4 == f11914b) {
            return this.f11920h;
        }
        return this.f11919g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (!strArr[i4].equals(strArr2[i4])) {
                return false;
            }
        }
        return true;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f11915e == null) {
                f11915e = new a(context);
            }
            aVar = f11915e;
        }
        return aVar;
    }

    public final String a(d dVar, int i4) {
        try {
            if (com.autonavi.aps.amapapi.utils.a.q() && dVar != null) {
                String url = dVar.getURL();
                String host = new URL(url).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(url) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!g4.U(str)) {
                        return null;
                    }
                    String e4 = e(i4);
                    if (!TextUtils.isEmpty(e4)) {
                        dVar.c(url.replace(host, e4));
                        dVar.getRequestHead().put("host", str);
                        dVar.d(str);
                        dVar.setIPV6Request(i4 == f11914b);
                        return e4;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private synchronized void b(boolean z3, final int i4) {
        if (!z3) {
            if (!com.autonavi.aps.amapapi.utils.a.p() && this.f11924l) {
                return;
            }
        }
        if (this.f11916c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = this.f11916c;
            if (currentTimeMillis - j4 < this.f11921i) {
                return;
            }
            if (currentTimeMillis - j4 < 60000) {
                return;
            }
        }
        this.f11916c = System.currentTimeMillis();
        this.f11924l = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        z7.h().b(new a8() { // from class: com.autonavi.aps.amapapi.trans.a.1
            @Override // com.amap.api.col.p0003l.a8
            public final void runTask() {
                int i5;
                StringBuilder sb = new StringBuilder(JPushConstants.HTTP_PRE);
                sb.append(com.autonavi.aps.amapapi.utils.a.r());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i4 == a.f11914b ? 6 : 4);
                String sb2 = sb.toString();
                b bVar = new b();
                bVar.a(sb2);
                bVar.b(sb2);
                bVar.setDegradeAbility(Cif.a.SINGLE);
                bVar.setHttpProtocol(Cif.c.HTTP);
                try {
                    q6.b();
                    JSONObject jSONObject = new JSONObject(new String(q6.d(bVar).f9524a));
                    String[] b4 = a.b(jSONObject.optJSONArray("ips"), a.f11913a);
                    if (b4 != null && b4.length > 0 && !a.b(b4, a.this.b(a.f11913a).a())) {
                        a.this.b(a.f11913a).a(b4);
                        a.this.f(a.f11913a);
                    }
                    String[] b5 = a.b(jSONObject.optJSONArray("ipsv6"), a.f11914b);
                    if (b5 != null && b5.length > 0 && !a.b(b5, a.this.b(a.f11914b).a())) {
                        a.this.b(a.f11914b).a(b5);
                        a.this.f(a.f11914b);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has("ttl") && (i5 = jSONObject.getInt("ttl")) > 30) {
                        a.this.f11921i = i5 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(DomainCampaignEx.LOOPBACK_KEY, "dnsError");
                        jSONObject2.put("reason", th.getMessage());
                    } catch (Throwable unused) {
                    }
                    h.a(a.this.f11922j, "O018", jSONObject2);
                }
            }
        });
    }

    public final void a(int i4) {
        if (!b(i4).e()) {
            this.f11918f.add(b(i4).b());
            d(i4);
            b(true, i4);
            return;
        }
        d(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] b(JSONArray jSONArray, int i4) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String string = jSONArray.getString(i5);
            if (!TextUtils.isEmpty(string)) {
                if (i4 == f11914b) {
                    string = "[" + string + "]";
                }
                strArr[i5] = string;
            }
        }
        return strArr;
    }

    public final void a(boolean z3, int i4) {
        b(i4).b(z3);
        if (z3) {
            String c4 = b(i4).c();
            String b4 = b(i4).b();
            if (TextUtils.isEmpty(b4) || b4.equals(c4)) {
                return;
            }
            SharedPreferences.Editor a4 = i.a(this.f11922j, "cbG9jaXA");
            i.a(a4, c(i4), b4);
            i.a(a4);
        }
    }
}
