package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.col.p0463l.BaseNetManager;
import com.amap.api.col.p0463l.ThreadPool;
import com.amap.api.col.p0463l.ThreadTask;
import com.autonavi.aps.amapapi.DNSIPDelegate;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2431i;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.trans.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapDnsManager {

    /* renamed from: a */
    public static int f8241a = 1;

    /* renamed from: b */
    public static int f8242b = 2;

    /* renamed from: e */
    private static AMapDnsManager f8243e;

    /* renamed from: j */
    private Context f8250j;

    /* renamed from: k */
    private String f8251k;

    /* renamed from: c */
    private long f8244c = 0;

    /* renamed from: d */
    private boolean f8245d = false;

    /* renamed from: f */
    private ArrayList<String> f8246f = new ArrayList<>();

    /* renamed from: g */
    private DNSIPDelegate f8247g = new DNSIPDelegate();

    /* renamed from: h */
    private DNSIPDelegate f8248h = new DNSIPDelegate();

    /* renamed from: i */
    private long f8249i = 120000;

    /* renamed from: l */
    private boolean f8252l = false;

    private AMapDnsManager(Context context) {
        this.f8250j = context;
    }

    /* renamed from: c */
    private static String m51395c(int i) {
        return i == f8242b ? "last_ip_6" : "last_ip_4";
    }

    /* renamed from: d */
    private void m51394d(int i) {
        if (m51400b(i).m51642d()) {
            SharedPreferences.Editor m51222a = C2431i.m51222a(this.f8250j, "cbG9jaXA");
            C2431i.m51216a(m51222a, m51395c(i));
            C2431i.m51217a(m51222a);
            m51400b(i).m51648a(false);
        }
    }

    /* renamed from: e */
    private String m51393e(int i) {
        String str;
        int i2 = 0;
        m51397b(false, i);
        String[] m51650a = m51400b(i).m51650a();
        if (m51650a != null && m51650a.length > 0) {
            int length = m51650a.length;
            while (true) {
                if (i2 >= length) {
                    str = null;
                    break;
                }
                str = m51650a[i2];
                if (!this.f8246f.contains(str)) {
                    break;
                }
                i2++;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            m51400b(i).m51649a(str);
            return str;
        }
        m51391g(i);
        return m51400b(i).m51646b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m51392f(int i) {
        if (m51400b(i).m51650a() == null || m51400b(i).m51650a().length <= 0) {
            return;
        }
        String str = m51400b(i).m51650a()[0];
        if (str.equals(this.f8251k) || this.f8246f.contains(str)) {
            return;
        }
        this.f8251k = str;
        SharedPreferences.Editor m51222a = C2431i.m51222a(this.f8250j, "cbG9jaXA");
        C2431i.m51213a(m51222a, m51395c(i), str);
        C2431i.m51217a(m51222a);
    }

    /* renamed from: g */
    private void m51391g(int i) {
        String m51219a = C2431i.m51219a(this.f8250j, "cbG9jaXA", m51395c(i), (String) null);
        if (TextUtils.isEmpty(m51219a) || this.f8246f.contains(m51219a)) {
            return;
        }
        m51400b(i).m51649a(m51219a);
        m51400b(i).m51645b(m51219a);
        m51400b(i).m51648a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public DNSIPDelegate m51400b(int i) {
        if (i == f8242b) {
            return this.f8248h;
        }
        return this.f8247g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m51396b(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0 || strArr.length != strArr2.length) {
            return false;
        }
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (!strArr[i].equals(strArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized AMapDnsManager m51408a(Context context) {
        AMapDnsManager aMapDnsManager;
        synchronized (AMapDnsManager.class) {
            if (f8243e == null) {
                f8243e = new AMapDnsManager(context);
            }
            aMapDnsManager = f8243e;
        }
        return aMapDnsManager;
    }

    /* renamed from: a */
    public final String m51404a(LocationRequest locationRequest, int i) {
        try {
            if (AuthUtil.m51316q() && locationRequest != null) {
                String url = locationRequest.getURL();
                String host = new URL(url).getHost();
                if (!"http://abroad.apilocate.amap.com/mobile/binary".equals(url) && !"abroad.apilocate.amap.com".equals(host)) {
                    String str = "apilocate.amap.com".equalsIgnoreCase(host) ? "httpdns.apilocate.amap.com" : host;
                    if (!AuthConfigManager.m55067U(str)) {
                        return null;
                    }
                    String m51393e = m51393e(i);
                    if (!TextUtils.isEmpty(m51393e)) {
                        locationRequest.m51372c(url.replace(host, m51393e));
                        locationRequest.getRequestHead().put("host", str);
                        locationRequest.m51369d(str);
                        locationRequest.setIPV6Request(i == f8242b);
                        return m51393e;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: b */
    private synchronized void m51397b(boolean z, final int i) {
        if (!z) {
            if (!AuthUtil.m51317p() && this.f8252l) {
                return;
            }
        }
        if (this.f8244c != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f8244c;
            if (currentTimeMillis - j < this.f8249i) {
                return;
            }
            if (currentTimeMillis - j < 60000) {
                return;
            }
        }
        this.f8244c = System.currentTimeMillis();
        this.f8252l = true;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.getClassName() + "(" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber() + "),");
        }
        ThreadPool.m53398h().m55654b(new ThreadTask() { // from class: com.autonavi.aps.amapapi.trans.a.1
            @Override // com.amap.api.col.p0463l.ThreadTask
            public final void runTask() {
                int i2;
                StringBuilder sb = new StringBuilder("http://");
                sb.append(AuthUtil.m51315r());
                sb.append("?host=dualstack-a.apilocate.amap.com&query=");
                sb.append(i == AMapDnsManager.f8242b ? 6 : 4);
                String sb2 = sb.toString();
                C2426b c2426b = new C2426b();
                c2426b.m51390a(sb2);
                c2426b.m51387b(sb2);
                c2426b.setDegradeAbility(AbstractC1840if.EnumC1841a.SINGLE);
                c2426b.setHttpProtocol(AbstractC1840if.EnumC1843c.HTTP);
                try {
                    BaseNetManager.m54175b();
                    JSONObject jSONObject = new JSONObject(new String(BaseNetManager.m54173d(c2426b).f5682a));
                    String[] m51398b = AMapDnsManager.m51398b(jSONObject.optJSONArray("ips"), AMapDnsManager.f8241a);
                    if (m51398b != null && m51398b.length > 0 && !AMapDnsManager.m51396b(m51398b, AMapDnsManager.this.m51400b(AMapDnsManager.f8241a).m51650a())) {
                        AMapDnsManager.this.m51400b(AMapDnsManager.f8241a).m51647a(m51398b);
                        AMapDnsManager.this.m51392f(AMapDnsManager.f8241a);
                    }
                    String[] m51398b2 = AMapDnsManager.m51398b(jSONObject.optJSONArray("ipsv6"), AMapDnsManager.f8242b);
                    if (m51398b2 != null && m51398b2.length > 0 && !AMapDnsManager.m51396b(m51398b2, AMapDnsManager.this.m51400b(AMapDnsManager.f8242b).m51650a())) {
                        AMapDnsManager.this.m51400b(AMapDnsManager.f8242b).m51647a(m51398b2);
                        AMapDnsManager.this.m51392f(AMapDnsManager.f8242b);
                    }
                    if ((jSONObject.has("ips") || jSONObject.has("ipsv6")) && jSONObject.has(RtspHeaders.Values.TTL) && (i2 = jSONObject.getInt(RtspHeaders.Values.TTL)) > 30) {
                        AMapDnsManager.this.f8249i = i2 * 1000;
                    }
                } catch (Throwable th) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(DomainCampaignEx.LOOPBACK_KEY, "dnsError");
                        jSONObject2.put(MediationConstant.KEY_REASON, th.getMessage());
                    } catch (Throwable unused) {
                    }
                    ReportUtil.m51236a(AMapDnsManager.this.f8250j, "O018", jSONObject2);
                }
            }
        });
    }

    /* renamed from: a */
    public final void m51409a(int i) {
        if (!m51400b(i).m51641e()) {
            this.f8246f.add(m51400b(i).m51646b());
            m51394d(i);
            m51397b(true, i);
            return;
        }
        m51394d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String[] m51398b(JSONArray jSONArray, int i) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String string = jSONArray.getString(i2);
            if (!TextUtils.isEmpty(string)) {
                if (i == f8242b) {
                    string = "[" + string + "]";
                }
                strArr[i2] = string;
            }
        }
        return strArr;
    }

    /* renamed from: a */
    public final void m51402a(boolean z, int i) {
        m51400b(i).m51644b(z);
        if (z) {
            String m51643c = m51400b(i).m51643c();
            String m51646b = m51400b(i).m51646b();
            if (TextUtils.isEmpty(m51646b) || m51646b.equals(m51643c)) {
                return;
            }
            SharedPreferences.Editor m51222a = C2431i.m51222a(this.f8250j, "cbG9jaXA");
            C2431i.m51213a(m51222a, m51395c(i), m51646b);
            C2431i.m51217a(m51222a);
        }
    }
}
