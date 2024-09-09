package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> Cm;
    private List<String> Cn;
    private volatile SharedPreferences Co;
    private final Object mLock;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final SplashPreloadManager Cp = new SplashPreloadManager((byte) 0);
    }

    /* synthetic */ SplashPreloadManager(byte b4) {
        this();
    }

    public static File T(String str) {
        if (str != null) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
            if (bV == null || !bV.exists()) {
                return null;
            }
            return bV;
        }
        return null;
    }

    @AnyThread
    public static boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Co = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.Co.getAll();
        ArrayList<String> arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(preLoadItem.preloadId);
                            if (bV != null && bV.exists()) {
                                synchronized (this.mLock) {
                                    this.Cm.put(str, preLoadItem);
                                    if (!this.Cn.contains(str)) {
                                        this.Cn.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.e.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        SharedPreferences.Editor edit = this.Co.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    private void kx() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.Cm.keySet()) {
                PreLoadItem preLoadItem = this.Cm.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.Co.edit();
            for (String str2 : arrayList) {
                this.Cn.remove(str2);
                this.Cm.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.Dc().remove(str2);
            }
            edit.apply();
            size = this.Cn.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "\u5927\u4e8e 30 \u6309\u5931\u6548\u65e5\u671f\u8fdc\u8fd1\u987a\u5e8f\u79fb\u9664");
            int i4 = size - 15;
            for (int i5 = 0; i5 < i4; i5++) {
                long j4 = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.Cm.values()) {
                        long j5 = preLoadItem2.expiredTime;
                        if (j5 < j4) {
                            str3 = preLoadItem2.preloadId;
                            j4 = j5;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.Cn.remove(str3);
                        this.Cm.remove(str3);
                        this.Co.edit().remove(str3).apply();
                        com.kwad.sdk.core.e.c.d("PreloadManager", "\u79fb\u9664 preloadId = " + str3 + " expiredTime =  " + j4);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.Dc().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager ky() {
        SplashPreloadManager splashPreloadManager = a.Cp;
        if (splashPreloadManager.Co == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        synchronized (this.mLock) {
            this.Cm.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Cn.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Cn.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Co != null) {
            SharedPreferences.Editor edit = this.Co.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(bV == null ? "null" : Boolean.valueOf(bV.exists()));
            com.kwad.sdk.core.e.c.d("PreloadManager", sb.toString());
            if (bV != null && bV.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList start ");
            for (int i4 = 0; i4 < this.Cn.size(); i4++) {
                String str = this.Cn.get(i4);
                File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
                if (bV != null && bV.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList " + this.Cn.size());
        return arrayList;
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z3) {
        String str;
        boolean a4;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.h(adResultData);
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.Co != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(adInfo)) {
                            if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.K(adInfo);
                            } else {
                                str = com.kwad.sdk.core.response.b.a.bd(adInfo) ? com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String aZ = com.kwad.sdk.core.response.b.a.aZ(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || ag.isWifiConnected(ServiceProvider.getContext()) || z3) {
                                    com.kwad.sdk.core.e.c.d("PreloadManager", "start Download preloadId " + aZ + " true url " + str);
                                    kx();
                                    a.C0699a c0699a = new a.C0699a();
                                    if (p(adInfo)) {
                                        a4 = KSImageLoader.loadImageSync(str) != null;
                                    } else {
                                        a4 = j.a(str, aZ, c0699a);
                                    }
                                    if (a4) {
                                        o(adInfo);
                                        i4++;
                                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 4, c0699a.msg);
                                        com.kwad.components.core.o.a.qi().f(next, 1, c0699a.msg);
                                    }
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(next, 1, "networkError");
                                }
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.kV();
                                com.kwad.components.ad.splashscreen.monitor.b.d(next, 2, "urlError");
                            }
                        } else {
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            o(adInfo);
                            i4++;
                        }
                    } else {
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 3, "preloadIdError");
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i4 > 0) {
            i.ap("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.qi().e(adTemplate, i4);
        } else {
            i.ap("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i4;
    }

    @AnyThread
    public final boolean e(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Cm = new HashMap<>();
        this.Cn = new ArrayList();
        init();
    }
}
