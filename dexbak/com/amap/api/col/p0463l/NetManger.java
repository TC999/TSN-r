package com.amap.api.col.p0463l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.BasicThreadFactory;
import com.amap.api.maps.AMapException;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.w6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NetManger extends BaseNetManager {

    /* renamed from: i */
    private static NetManger f5636i;

    /* renamed from: g */
    private ThreadPool f5637g;

    /* renamed from: h */
    private Handler f5638h;

    /* compiled from: NetManger.java */
    /* renamed from: com.amap.api.col.3l.w6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class HandlerC1981a extends Handler {
        /* synthetic */ HandlerC1981a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private HandlerC1981a(Looper looper) {
            super(looper);
        }

        public HandlerC1981a() {
        }
    }

    private NetManger(boolean z) {
        if (z) {
            try {
                this.f5637g = ThreadPool.m53397i(new BasicThreadFactory.C1988b().m53510c("amap-netmanger-threadpool-%d").m53505h());
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f5638h = new HandlerC1981a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f5638h = new HandlerC1981a();
        }
    }

    /* renamed from: l */
    private static synchronized NetManger m53584l(boolean z) {
        NetManger netManger;
        synchronized (NetManger.class) {
            try {
                NetManger netManger2 = f5636i;
                if (netManger2 == null) {
                    f5636i = new NetManger(z);
                } else if (z && netManger2.f5637g == null) {
                    netManger2.f5637g = ThreadPool.m53397i(new BasicThreadFactory.C1988b().m53510c("amap-netmanger-threadpool-%d").m53505h());
                }
                netManger = f5636i;
            }
        }
        return netManger;
    }

    /* renamed from: m */
    private static Map<String, String> m53583m(AbstractC1840if abstractC1840if, AbstractC1840if.EnumC1842b enumC1842b, int i) throws AMapCoreException {
        try {
            BaseNetManager.m54166k(abstractC1840if);
            abstractC1840if.setDegradeType(enumC1842b);
            abstractC1840if.setReal_max_timeout(i);
            return new HttpUrlUtil().m53760j(abstractC1840if);
        } catch (AMapCoreException e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new AMapCoreException(AMapException.ERROR_UNKNOWN);
        }
    }

    /* renamed from: n */
    public static NetManger m53582n() {
        return m53584l(true);
    }

    /* renamed from: o */
    private static ResponseEntity m53581o(AbstractC1840if abstractC1840if, AbstractC1840if.EnumC1842b enumC1842b, int i) throws AMapCoreException {
        try {
            BaseNetManager.m54166k(abstractC1840if);
            abstractC1840if.setDegradeType(enumC1842b);
            abstractC1840if.setReal_max_timeout(i);
            return new HttpUrlUtil().m53753q(abstractC1840if);
        } catch (AMapCoreException e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new AMapCoreException(AMapException.ERROR_UNKNOWN);
        }
    }

    /* renamed from: p */
    public static NetManger m53580p() {
        return m53584l(false);
    }

    @Deprecated
    /* renamed from: q */
    public static Map<String, String> m53579q(AbstractC1840if abstractC1840if, boolean z) throws AMapCoreException {
        BaseNetManager.m54166k(abstractC1840if);
        abstractC1840if.setHttpProtocol(z ? AbstractC1840if.EnumC1843c.HTTPS : AbstractC1840if.EnumC1843c.HTTP);
        Map<String, String> map = null;
        long j = 0;
        boolean z2 = false;
        if (BaseNetManager.m54170g(abstractC1840if)) {
            boolean m54168i = BaseNetManager.m54168i(abstractC1840if);
            try {
                j = SystemClock.elapsedRealtime();
                map = m53583m(abstractC1840if, BaseNetManager.m54174c(abstractC1840if, m54168i), BaseNetManager.m54169h(abstractC1840if, m54168i));
            } catch (AMapCoreException e) {
                if (!m54168i) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (map == null) {
            try {
                return m53583m(abstractC1840if, BaseNetManager.m54171f(abstractC1840if, z2), BaseNetManager.m54176a(abstractC1840if, j));
            } catch (AMapCoreException e2) {
                throw e2;
            }
        }
        return map;
    }

    /* renamed from: r */
    public static ResponseEntity m53578r(AbstractC1840if abstractC1840if) throws AMapCoreException {
        return m53577s(abstractC1840if, abstractC1840if.isHttps());
    }

    @Deprecated
    /* renamed from: s */
    private static ResponseEntity m53577s(AbstractC1840if abstractC1840if, boolean z) throws AMapCoreException {
        byte[] bArr;
        BaseNetManager.m54166k(abstractC1840if);
        abstractC1840if.setHttpProtocol(z ? AbstractC1840if.EnumC1843c.HTTPS : AbstractC1840if.EnumC1843c.HTTP);
        ResponseEntity responseEntity = null;
        long j = 0;
        boolean z2 = false;
        if (BaseNetManager.m54170g(abstractC1840if)) {
            boolean m54168i = BaseNetManager.m54168i(abstractC1840if);
            try {
                j = SystemClock.elapsedRealtime();
                responseEntity = m53581o(abstractC1840if, BaseNetManager.m54174c(abstractC1840if, m54168i), BaseNetManager.m54169h(abstractC1840if, m54168i));
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
                return m53581o(abstractC1840if, BaseNetManager.m54171f(abstractC1840if, z2), BaseNetManager.m54176a(abstractC1840if, j));
            } catch (AMapCoreException e2) {
                throw e2;
            }
        }
        return responseEntity;
    }
}
