package com.amap.api.col.p0463l;

import android.text.TextUtils;
import com.amap.api.col.p0463l.BaseNetManager;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Request.java */
/* renamed from: com.amap.api.col.3l.if */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1840if {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: d */
    private String f4519d;

    /* renamed from: e */
    private boolean f4520e;

    /* renamed from: f */
    private boolean f4521f;

    /* renamed from: o */
    BaseNetManager.InterfaceC1926a f4527o;

    /* renamed from: l */
    int f4524l = 20000;

    /* renamed from: m */
    int f4525m = 20000;

    /* renamed from: n */
    Proxy f4526n = null;

    /* renamed from: a */
    private boolean f4516a = false;

    /* renamed from: b */
    private int f4517b = 20000;

    /* renamed from: c */
    private boolean f4518c = true;

    /* renamed from: g */
    private EnumC1841a f4522g = EnumC1841a.NORMAL;

    /* renamed from: h */
    private EnumC1842b f4523h = EnumC1842b.FIRST_NONDEGRADE;

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1841a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        

        /* renamed from: f */
        private int f4534f;

        EnumC1841a(int i) {
            this.f4534f = i;
        }
    }

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1842b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        

        /* renamed from: h */
        private int f4543h;

        EnumC1842b(int i) {
            this.f4543h = i;
        }

        /* renamed from: a */
        public final int m54697a() {
            return this.f4543h;
        }

        /* renamed from: b */
        public final boolean m54696b() {
            int i = this.f4543h;
            return i == FIRST_NONDEGRADE.f4543h || i == NEVER_GRADE.f4543h || i == FIX_NONDEGRADE.f4543h;
        }

        /* renamed from: c */
        public final boolean m54695c() {
            int i = this.f4543h;
            return i == DEGRADE_BYERROR.f4543h || i == DEGRADE_ONLY.f4543h || i == FIX_DEGRADE_BYERROR.f4543h || i == FIX_DEGRADE_ONLY.f4543h;
        }

        /* renamed from: d */
        public final boolean m54694d() {
            int i = this.f4543h;
            return i == DEGRADE_BYERROR.f4543h || i == FIX_DEGRADE_BYERROR.f4543h;
        }

        /* renamed from: e */
        public final boolean m54693e() {
            return this.f4543h == NEVER_GRADE.f4543h;
        }
    }

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.3l.if$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1843c {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: c */
        private int f4547c;

        EnumC1843c(int i) {
            this.f4547c = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final String m54700a() {
        return m54699a(getURL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final String m54698b() {
        return m54699a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f4524l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EnumC1841a getDegradeAbility() {
        return this.f4522g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EnumC1842b getDegradeType() {
        return this.f4523h;
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
        return this.f4519d;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.f4526n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReal_max_timeout() {
        return this.f4517b;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f4525m;
    }

    public abstract String getURL();

    public BaseNetManager.InterfaceC1926a getUrlConnectionImpl() {
        return this.f4527o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isBinary() {
        return this.f4516a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHostToIP() {
        return this.f4518c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHttps() {
        return this.f4521f;
    }

    protected boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isIPV6Request() {
        return this.f4520e;
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
                    int i = 0;
                    String str4 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(ConstConfig.m55237a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    ConstConfig.m55236b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfp");
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
            BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfh");
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
                if (this.f4516a) {
                    str = parseSDKNameFromPlatInfo(((BinaryRequest) this).mo51367g());
                } else {
                    str = parseSdkNameFromHeader(getRequestHead());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            BasicLogHandler.m54177e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfr");
            return str;
        }
        return str;
    }

    public void setBinary(boolean z) {
        this.f4516a = z;
    }

    public final void setConnectionTimeout(int i) {
        this.f4524l = i;
    }

    public void setDegradeAbility(EnumC1841a enumC1841a) {
        this.f4522g = enumC1841a;
    }

    public void setDegradeType(EnumC1842b enumC1842b) {
        this.f4523h = enumC1842b;
    }

    public void setHostToIP(boolean z) {
        this.f4518c = z;
    }

    public void setHttpProtocol(EnumC1843c enumC1843c) {
        this.f4521f = enumC1843c == EnumC1843c.HTTPS;
    }

    public void setIPV6Request(boolean z) {
        this.f4520e = z;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f4519d = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f4526n = proxy;
    }

    public void setReal_max_timeout(int i) {
        this.f4517b = i;
    }

    public final void setSoTimeout(int i) {
        this.f4525m = i;
    }

    public void setUrlConnectionImpl(BaseNetManager.InterfaceC1926a interfaceC1926a) {
        this.f4527o = interfaceC1926a;
    }

    /* renamed from: a */
    private String m54699a(String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return str;
        }
        Map<String, String> params = getParams();
        HashMap<String, String> hashMap = BaseNetManager.f5080e;
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
        String m53761i = HttpUrlUtil.m53761i(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(m53761i);
        return stringBuffer.toString();
    }
}
