package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.col.p0463l.CityObject;
import com.amap.api.col.p0463l.HttpsDecisionUtil;
import com.amap.api.col.p0463l.OfflineDownloadManager;
import com.amap.api.col.p0463l.OfflineMapDownloadList;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.col.p0463l.PrivacyError;
import com.amap.api.col.p0463l.SDKLogHandler;
import com.amap.api.col.p0463l.StatisticsUtil;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OfflineMapManager {

    /* renamed from: a */
    OfflineMapDownloadList f7114a;

    /* renamed from: b */
    OfflineDownloadManager f7115b;

    /* renamed from: c */
    private Context f7116c;

    /* renamed from: d */
    private OfflineMapDownloadListener f7117d;

    /* renamed from: e */
    private OfflineLoadedListener f7118e;

    /* renamed from: f */
    private Handler f7119f;

    /* renamed from: g */
    private Handler f7120g;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        PrivacyError m54995a = Privacy.m54995a(context, C1732a3.m55691s());
        if (m54995a.f4676a == Privacy.EnumC1812c.SuccessCode) {
            this.f7117d = offlineMapDownloadListener;
            this.f7116c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f7119f = new Handler(this.f7116c.getMainLooper());
            this.f7120g = new Handler(this.f7116c.getMainLooper());
            m51991a(context);
            HttpsDecisionUtil.m54673a().m54671c(this.f7116c);
            return;
        }
        throw new Exception(m54995a.f4677b);
    }

    public final void destroy() {
        try {
            OfflineDownloadManager offlineDownloadManager = this.f7115b;
            if (offlineDownloadManager != null) {
                offlineDownloadManager.m55610A();
            }
            m51988b();
            Handler handler = this.f7119f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f7119f = null;
            Handler handler2 = this.f7120g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.f7120g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.f7115b.m55608C(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.f7115b.m55571y(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            m51992a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f7120g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f7115b.m55571y(city);
                            } catch (AMapException e) {
                                SDKLogHandler.m53863p(e, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                SDKLogHandler.m53863p(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f7114a.m54947s();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f7114a.m54946t();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f7114a.m54945u();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f7114a.m54944v();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f7114a.m54965a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f7114a.m54953m(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f7114a.m54948r(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f7114a.m54952n();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f7114a.m54964b();
    }

    public final void pause() {
        this.f7115b.m55573w();
    }

    public final void pauseByName(String str) {
        this.f7115b.m55574v(str);
    }

    public final void remove(String str) {
        try {
            if (this.f7115b.m55583m(str)) {
                this.f7115b.m55578r(str);
                return;
            }
            OfflineMapProvince m54948r = this.f7114a.m54948r(str);
            if (m54948r != null && m54948r.getCityList() != null) {
                Iterator<OfflineMapCity> it = m54948r.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f7120g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.f7115b.m55578r(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f7117d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f7118e = offlineLoadedListener;
    }

    public final void stop() {
        this.f7115b.m55576t();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            m51989a(itemByCityCode.getCity());
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        m51989a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        m51989a(str);
    }

    /* renamed from: a */
    private void m51991a(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7116c = origApplicationContext;
        OfflineDownloadManager.f3614p = false;
        OfflineDownloadManager m55594b = OfflineDownloadManager.m55594b(origApplicationContext);
        this.f7115b = m55594b;
        m55594b.m55589g(new OfflineDownloadManager.InterfaceC1747d() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.p0463l.OfflineDownloadManager.InterfaceC1747d
            /* renamed from: a */
            public final void mo51984a(final CityObject cityObject) {
                if (OfflineMapManager.this.f7117d == null || cityObject == null) {
                    return;
                }
                OfflineMapManager.this.f7119f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.f7117d.onDownload(cityObject.m55618s().m55089d(), cityObject.getcompleteCode(), cityObject.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0463l.OfflineDownloadManager.InterfaceC1747d
            /* renamed from: b */
            public final void mo51983b(final CityObject cityObject) {
                if (OfflineMapManager.this.f7117d == null || cityObject == null) {
                    return;
                }
                OfflineMapManager.this.f7119f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!cityObject.m55618s().equals(cityObject.f3579l) && !cityObject.m55618s().equals(cityObject.f3573f)) {
                                OfflineMapManager.this.f7117d.onCheckUpdate(false, cityObject.getCity());
                                return;
                            }
                            OfflineMapManager.this.f7117d.onCheckUpdate(true, cityObject.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0463l.OfflineDownloadManager.InterfaceC1747d
            /* renamed from: c */
            public final void mo51982c(final CityObject cityObject) {
                if (OfflineMapManager.this.f7117d == null || cityObject == null) {
                    return;
                }
                OfflineMapManager.this.f7119f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (cityObject.m55618s().equals(cityObject.f3573f)) {
                                OfflineMapManager.this.f7117d.onRemove(true, cityObject.getCity(), "");
                            } else {
                                OfflineMapManager.this.f7117d.onRemove(false, cityObject.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0463l.OfflineDownloadManager.InterfaceC1747d
            /* renamed from: a */
            public final void mo51985a() {
                if (OfflineMapManager.this.f7118e != null) {
                    OfflineMapManager.this.f7119f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f7118e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.f7115b.m55592d();
            this.f7114a = this.f7115b.f3627k;
            StatisticsUtil.m53550k(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m51988b() {
        this.f7117d = null;
    }

    /* renamed from: a */
    private void m51989a(String str) throws AMapException {
        this.f7115b.m55588h(str);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f7117d = offlineMapDownloadListener;
        this.f7116c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7119f = new Handler(this.f7116c.getMainLooper());
        this.f7120g = new Handler(this.f7116c.getMainLooper());
        try {
            m51991a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m51992a() throws AMapException {
        if (!C1732a3.m55703h0(this.f7116c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }
}
