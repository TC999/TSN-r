package com.amap.api.col.p0463l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* renamed from: com.amap.api.col.3l.p6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseNetManager {

    /* renamed from: a */
    public static int f5076a = 0;

    /* renamed from: b */
    public static String f5077b = "";

    /* renamed from: c */
    public static HashMap<String, String> f5078c;

    /* renamed from: d */
    public static HashMap<String, String> f5079d;

    /* renamed from: e */
    public static HashMap<String, String> f5080e;

    /* renamed from: f */
    private static BaseNetManager f5081f;

    /* compiled from: BaseNetManager.java */
    /* renamed from: com.amap.api.col.3l.p6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1926a {
        /* renamed from: a */
        URLConnection m54165a();
    }

    public BaseNetManager() {
        AuthConfigManager.m55073O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static int m54176a(AbstractC1840if abstractC1840if, long j) {
        try {
            m54166k(abstractC1840if);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int conntectionTimeout = abstractC1840if.getConntectionTimeout();
            if (abstractC1840if.getDegradeAbility() != AbstractC1840if.EnumC1841a.FIX && abstractC1840if.getDegradeAbility() != AbstractC1840if.EnumC1841a.SINGLE) {
                long j3 = conntectionTimeout;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return Math.min(1000, abstractC1840if.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* renamed from: b */
    public static BaseNetManager m54175b() {
        if (f5081f == null) {
            f5081f = new BaseNetManager();
        }
        return f5081f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static AbstractC1840if.EnumC1842b m54174c(AbstractC1840if abstractC1840if, boolean z) {
        if (abstractC1840if.getDegradeAbility() == AbstractC1840if.EnumC1841a.FIX) {
            return AbstractC1840if.EnumC1842b.FIX_NONDEGRADE;
        }
        if (abstractC1840if.getDegradeAbility() == AbstractC1840if.EnumC1841a.SINGLE) {
            return AbstractC1840if.EnumC1842b.NEVER_GRADE;
        }
        return z ? AbstractC1840if.EnumC1842b.FIRST_NONDEGRADE : AbstractC1840if.EnumC1842b.NEVER_GRADE;
    }

    /* renamed from: d */
    public static ResponseEntity m54173d(AbstractC1840if abstractC1840if) throws AMapCoreException {
        return m54167j(abstractC1840if, abstractC1840if.isHttps());
    }

    /* renamed from: e */
    private static ResponseEntity m54172e(AbstractC1840if abstractC1840if, AbstractC1840if.EnumC1842b enumC1842b, int i) throws AMapCoreException {
        try {
            m54166k(abstractC1840if);
            abstractC1840if.setDegradeType(enumC1842b);
            abstractC1840if.setReal_max_timeout(i);
            return new HttpUrlUtil().m53746x(abstractC1840if);
        } catch (AMapCoreException e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new AMapCoreException(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public static AbstractC1840if.EnumC1842b m54171f(AbstractC1840if abstractC1840if, boolean z) {
        return abstractC1840if.getDegradeAbility() == AbstractC1840if.EnumC1841a.FIX ? z ? AbstractC1840if.EnumC1842b.FIX_DEGRADE_BYERROR : AbstractC1840if.EnumC1842b.FIX_DEGRADE_ONLY : z ? AbstractC1840if.EnumC1842b.DEGRADE_BYERROR : AbstractC1840if.EnumC1842b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public static boolean m54170g(AbstractC1840if abstractC1840if) throws AMapCoreException {
        m54166k(abstractC1840if);
        try {
            String ipv6url = abstractC1840if.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(abstractC1840if.getIPDNSName())) {
                host = abstractC1840if.getIPDNSName();
            }
            return AuthConfigManager.m55067U(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public static int m54169h(AbstractC1840if abstractC1840if, boolean z) {
        try {
            m54166k(abstractC1840if);
            int conntectionTimeout = abstractC1840if.getConntectionTimeout();
            int i = AuthConfigManager.f4115s;
            if (abstractC1840if.getDegradeAbility() != AbstractC1840if.EnumC1841a.FIX) {
                if (abstractC1840if.getDegradeAbility() != AbstractC1840if.EnumC1841a.SINGLE && conntectionTimeout >= i && z) {
                    return i;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public static boolean m54168i(AbstractC1840if abstractC1840if) throws AMapCoreException {
        m54166k(abstractC1840if);
        if (m54170g(abstractC1840if)) {
            if (abstractC1840if.getURL().equals(abstractC1840if.getIPV6URL()) || abstractC1840if.getDegradeAbility() == AbstractC1840if.EnumC1841a.SINGLE) {
                return false;
            }
            return AuthConfigManager.f4119w;
        }
        return true;
    }

    @Deprecated
    /* renamed from: j */
    private static ResponseEntity m54167j(AbstractC1840if abstractC1840if, boolean z) throws AMapCoreException {
        byte[] bArr;
        m54166k(abstractC1840if);
        abstractC1840if.setHttpProtocol(z ? AbstractC1840if.EnumC1843c.HTTPS : AbstractC1840if.EnumC1843c.HTTP);
        ResponseEntity responseEntity = null;
        long j = 0;
        boolean z2 = false;
        if (m54170g(abstractC1840if)) {
            boolean m54168i = m54168i(abstractC1840if);
            try {
                j = SystemClock.elapsedRealtime();
                responseEntity = m54172e(abstractC1840if, m54174c(abstractC1840if, m54168i), m54169h(abstractC1840if, m54168i));
            } catch (AMapCoreException e) {
                if (e.m55000f() == 21 && abstractC1840if.getDegradeAbility() == AbstractC1840if.EnumC1841a.INTERRUPT_IO) {
                    throw e;
                }
                if (!m54168i) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (responseEntity == null || (bArr = responseEntity.f5682a) == null || bArr.length <= 0) {
            try {
                return m54172e(abstractC1840if, m54171f(abstractC1840if, z2), m54176a(abstractC1840if, j));
            } catch (AMapCoreException e2) {
                throw e2;
            }
        }
        return responseEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public static void m54166k(AbstractC1840if abstractC1840if) throws AMapCoreException {
        if (abstractC1840if != null) {
            if (abstractC1840if.getURL() == null || "".equals(abstractC1840if.getURL())) {
                throw new AMapCoreException("request url is empty");
            }
            return;
        }
        throw new AMapCoreException("requeust is null");
    }
}
