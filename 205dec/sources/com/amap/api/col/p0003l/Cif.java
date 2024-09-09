package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.col.p0003l.q6;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Request.java */
/* renamed from: com.amap.api.col.3l.if  reason: invalid class name and invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class Cif {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: d  reason: collision with root package name */
    private String f8163d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8164e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8165f;

    /* renamed from: o  reason: collision with root package name */
    q6.a f8171o;

    /* renamed from: l  reason: collision with root package name */
    int f8168l = 20000;

    /* renamed from: m  reason: collision with root package name */
    int f8169m = 20000;

    /* renamed from: n  reason: collision with root package name */
    Proxy f8170n = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8160a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f8161b = 20000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8162c = true;

    /* renamed from: g  reason: collision with root package name */
    private a f8166g = a.NORMAL;

    /* renamed from: h  reason: collision with root package name */
    private b f8167h = b.FIRST_NONDEGRADE;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        

        /* renamed from: f  reason: collision with root package name */
        private int f8178f;

        a(int i4) {
            this.f8178f = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        

        /* renamed from: h  reason: collision with root package name */
        private int f8187h;

        b(int i4) {
            this.f8187h = i4;
        }

        public final int a() {
            return this.f8187h;
        }

        public final boolean b() {
            int i4 = this.f8187h;
            return i4 == FIRST_NONDEGRADE.f8187h || i4 == NEVER_GRADE.f8187h || i4 == FIX_NONDEGRADE.f8187h;
        }

        public final boolean c() {
            int i4 = this.f8187h;
            return i4 == DEGRADE_BYERROR.f8187h || i4 == DEGRADE_ONLY.f8187h || i4 == FIX_DEGRADE_BYERROR.f8187h || i4 == FIX_DEGRADE_ONLY.f8187h;
        }

        public final boolean d() {
            int i4 = this.f8187h;
            return i4 == DEGRADE_BYERROR.f8187h || i4 == FIX_DEGRADE_BYERROR.f8187h;
        }

        public final boolean e() {
            return this.f8187h == NEVER_GRADE.f8187h;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum c {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: c  reason: collision with root package name */
        private int f8191c;

        c(int i4) {
            this.f8191c = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return a(getURL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f8168l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a getDegradeAbility() {
        return this.f8166g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b getDegradeType() {
        return this.f8167h;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNon_degrade_final_Host() {
        return this.f8163d;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.f8170n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReal_max_timeout() {
        return this.f8161b;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f8169m;
    }

    public abstract String getURL();

    public q6.a getUrlConnectionImpl() {
        return this.f8171o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isBinary() {
        return this.f8160a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHostToIP() {
        return this.f8162c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHttps() {
        return this.f8165f;
    }

    protected boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isIPV6Request() {
        return this.f8164e;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    protected String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i4 = 0;
                    String str4 = "";
                    while (true) {
                        if (i4 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i4];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT)) {
                            break;
                        }
                        i4++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(f5.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    f5.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfp");
        }
        return str3;
    }

    protected String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfh");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parseSdkNameFromRequest() {
        String str;
        try {
            str = getSDKName();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f8160a) {
                    str = parseSDKNameFromPlatInfo(((r6) this).g());
                } else {
                    str = parseSdkNameFromHeader(getRequestHead());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            q5.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfr");
            return str;
        }
        return str;
    }

    public void setBinary(boolean z3) {
        this.f8160a = z3;
    }

    public final void setConnectionTimeout(int i4) {
        this.f8168l = i4;
    }

    public void setDegradeAbility(a aVar) {
        this.f8166g = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f8167h = bVar;
    }

    public void setHostToIP(boolean z3) {
        this.f8162c = z3;
    }

    public void setHttpProtocol(c cVar) {
        this.f8165f = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z3) {
        this.f8164e = z3;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f8163d = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f8170n = proxy;
    }

    public void setReal_max_timeout(int i4) {
        this.f8161b = i4;
    }

    public final void setSoTimeout(int i4) {
        this.f8169m = i4;
    }

    public void setUrlConnectionImpl(q6.a aVar) {
        this.f8171o = aVar;
    }

    private String a(String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return str;
        }
        Map<String, String> params = getParams();
        HashMap<String, String> hashMap = q6.f8838e;
        if (hashMap != null) {
            if (params != null) {
                params.putAll(hashMap);
            } else {
                params = hashMap;
            }
        }
        if (params == null) {
            return str;
        }
        String i4 = v6.i(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(i4);
        return stringBuffer.toString();
    }
}
