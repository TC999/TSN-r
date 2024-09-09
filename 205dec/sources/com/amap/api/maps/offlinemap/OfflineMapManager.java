package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.ax;
import com.amap.api.col.p0003l.b0;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.g0;
import com.amap.api.col.p0003l.k4;
import com.amap.api.col.p0003l.n4;
import com.amap.api.col.p0003l.u5;
import com.amap.api.col.p0003l.x2;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class OfflineMapManager {

    /* renamed from: a  reason: collision with root package name */
    g0 f10812a;

    /* renamed from: b  reason: collision with root package name */
    b0 f10813b;

    /* renamed from: c  reason: collision with root package name */
    private Context f10814c;

    /* renamed from: d  reason: collision with root package name */
    private OfflineMapDownloadListener f10815d;

    /* renamed from: e  reason: collision with root package name */
    private OfflineLoadedListener f10816e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f10817f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f10818g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z3, String str);

        void onDownload(int i4, int i5, String str);

        void onRemove(boolean z3, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        n4 a4 = ft.a(context, a3.s());
        if (a4.f8385a == ft.c.SuccessCode) {
            this.f10815d = offlineMapDownloadListener;
            this.f10814c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10817f = new Handler(this.f10814c.getMainLooper());
            this.f10818g = new Handler(this.f10814c.getMainLooper());
            a(context);
            k4.a().c(this.f10814c);
            return;
        }
        throw new Exception(a4.f8386b);
    }

    public final void destroy() {
        try {
            b0 b0Var = this.f10813b;
            if (b0Var != null) {
                b0Var.A();
            }
            b();
            Handler handler = this.f10817f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f10817f = null;
            Handler handler2 = this.f10818g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.f10818g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.f10813b.C(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.f10813b.y(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName != null) {
                Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f10818g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f10813b.y(city);
                            } catch (AMapException e4) {
                                u5.p(e4, "OfflineMapManager", "downloadByProvinceName");
                            }
                        }
                    });
                }
                return;
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (Throwable th) {
            if (!(th instanceof AMapException)) {
                u5.p(th, "OfflineMapManager", "downloadByProvinceName");
                return;
            }
            throw th;
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f10812a.s();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f10812a.t();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f10812a.u();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f10812a.v();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f10812a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f10812a.m(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f10812a.r(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f10812a.n();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f10812a.b();
    }

    public final void pause() {
        this.f10813b.w();
    }

    public final void pauseByName(String str) {
        this.f10813b.v(str);
    }

    public final void remove(String str) {
        try {
            if (this.f10813b.m(str)) {
                this.f10813b.r(str);
                return;
            }
            OfflineMapProvince r3 = this.f10812a.r(str);
            if (r3 != null && r3.getCityList() != null) {
                Iterator<OfflineMapCity> it = r3.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.f10818g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.f10813b.r(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.f10815d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "\u6ca1\u6709\u8be5\u57ce\u5e02");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.f10816e = offlineLoadedListener;
    }

    public final void stop() {
        this.f10813b.t();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode != null && itemByCityCode.getCity() != null) {
            a(itemByCityCode.getCity());
            return;
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    private void a(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10814c = origApplicationContext;
        b0.f7175p = false;
        b0 b4 = b0.b(origApplicationContext);
        this.f10813b = b4;
        b4.g(new b0.d() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.p0003l.b0.d
            public final void a(final ax axVar) {
                if (OfflineMapManager.this.f10815d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f10817f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.f10815d.onDownload(axVar.s().d(), axVar.getcompleteCode(), axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0003l.b0.d
            public final void b(final ax axVar) {
                if (OfflineMapManager.this.f10815d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f10817f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!axVar.s().equals(axVar.f7140l) && !axVar.s().equals(axVar.f7134f)) {
                                OfflineMapManager.this.f10815d.onCheckUpdate(false, axVar.getCity());
                                return;
                            }
                            OfflineMapManager.this.f10815d.onCheckUpdate(true, axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0003l.b0.d
            public final void c(final ax axVar) {
                if (OfflineMapManager.this.f10815d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f10817f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (axVar.s().equals(axVar.f7134f)) {
                                OfflineMapManager.this.f10815d.onRemove(true, axVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.f10815d.onRemove(false, axVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.p0003l.b0.d
            public final void a() {
                if (OfflineMapManager.this.f10816e != null) {
                    OfflineMapManager.this.f10817f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.f10816e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.f10813b.d();
            this.f10812a = this.f10813b.f7188k;
            x2.k(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        this.f10815d = null;
    }

    private void a(String str) throws AMapException {
        this.f10813b.h(str);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.f10815d = offlineMapDownloadListener;
        this.f10814c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10817f = new Handler(this.f10814c.getMainLooper());
        this.f10818g = new Handler(this.f10814c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!a3.h0(this.f10814c)) {
            throw new AMapException("http\u8fde\u63a5\u5931\u8d25 - ConnectionException");
        }
    }
}
