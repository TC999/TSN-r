package com.kwad.components.p208ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11100i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.splashscreen.SplashPreloadManager */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashPreloadManager {

    /* renamed from: Cm */
    private HashMap<String, PreLoadItem> f27596Cm;

    /* renamed from: Cn */
    private List<String> f27597Cn;

    /* renamed from: Co */
    private volatile SharedPreferences f27598Co;
    private final Object mLock;

    @KsJson
    /* renamed from: com.kwad.components.ad.splashscreen.SplashPreloadManager$PreLoadItem */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class PreLoadItem extends C10482a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.SplashPreloadManager$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8350a {

        /* renamed from: Cp */
        private static final SplashPreloadManager f27599Cp = new SplashPreloadManager((byte) 0);
    }

    /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    /* renamed from: T */
    public static File m30914T(String str) {
        if (str != null) {
            C10331c.m26254d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File m26391bV = C10291a.m26395Dc().m26391bV(str);
            if (m26391bV == null || !m26391bV.exists()) {
                return null;
            }
            return m26391bV;
        }
        return null;
    }

    @AnyThread
    /* renamed from: f */
    public static boolean m30911f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return C10483a.m25876bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    /* renamed from: g */
    public static boolean m30910g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return C10483a.m25877bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.f27598Co = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.f27598Co.getAll();
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
                            File m26391bV = C10291a.m26395Dc().m26391bV(preLoadItem.preloadId);
                            if (m26391bV != null && m26391bV.exists()) {
                                synchronized (this.mLock) {
                                    this.f27596Cm.put(str, preLoadItem);
                                    if (!this.f27597Cn.contains(str)) {
                                        this.f27597Cn.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                C10331c.m26254d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.f27598Co.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    /* renamed from: kx */
    private void m30909kx() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.f27596Cm.keySet()) {
                PreLoadItem preLoadItem = this.f27596Cm.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.f27598Co.edit();
            for (String str2 : arrayList) {
                this.f27597Cn.remove(str2);
                this.f27596Cm.remove(str2);
                edit.remove(str2);
                C10291a.m26395Dc().remove(str2);
            }
            edit.apply();
            size = this.f27597Cn.size();
        }
        if (size > 30) {
            C10331c.m26254d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i = size - 15;
            for (int i2 = 0; i2 < i; i2++) {
                long j = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.f27596Cm.values()) {
                        long j2 = preLoadItem2.expiredTime;
                        if (j2 < j) {
                            str3 = preLoadItem2.preloadId;
                            j = j2;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.f27597Cn.remove(str3);
                        this.f27596Cm.remove(str3);
                        this.f27598Co.edit().remove(str3).apply();
                        C10331c.m26254d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    C10291a.m26395Dc().remove(str3);
                }
            }
        }
    }

    @AnyThread
    /* renamed from: ky */
    public static SplashPreloadManager m30908ky() {
        SplashPreloadManager splashPreloadManager = C8350a.f27599Cp;
        if (splashPreloadManager.f27598Co == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    /* renamed from: o */
    private void m30907o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = C10483a.m25936aZ(adInfo);
        synchronized (this.mLock) {
            this.f27596Cm.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.f27597Cn.contains(adInfo.adPreloadInfo.preloadId)) {
                this.f27597Cn.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.f27598Co != null) {
            SharedPreferences.Editor edit = this.f27598Co.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    /* renamed from: p */
    private static boolean m30906p(AdInfo adInfo) {
        return C10251d.m26527a(C8363a.f27628CQ) && C10483a.m25876bd(adInfo);
    }

    @AnyThread
    /* renamed from: q */
    private boolean m30905q(AdInfo adInfo) {
        if (m30906p(adInfo)) {
            return KSImageLoader.isImageExist(C10483a.m25941aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File m26391bV = C10291a.m26395Dc().m26391bV(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(m26391bV == null ? "null" : Boolean.valueOf(m26391bV.exists()));
            C10331c.m26254d("PreloadManager", sb.toString());
            if (m26391bV != null && m26391bV.exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: R */
    public final List<String> m30915R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            C10331c.m26254d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.f27597Cn.size(); i++) {
                String str = this.f27597Cn.get(i);
                File m26391bV = C10291a.m26395Dc().m26391bV(str);
                if (m26391bV != null && m26391bV.exists()) {
                    arrayList.add(str);
                }
            }
            C10331c.m26254d("PreloadManager", "getPreloadIdList end ");
        }
        C10331c.m26254d("PreloadManager", "getPreloadIdList " + this.f27597Cn.size());
        return arrayList;
    }

    @AnyThread
    /* renamed from: b */
    public final int m30913b(AdResultData adResultData, boolean z) {
        String str;
        boolean m29410a;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        C8497b.m30550kV();
        C8497b.m30551h(adResultData);
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.f27598Co != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!m30905q(adInfo)) {
                            if (C10483a.m25877bc(adInfo)) {
                                str = C10483a.m25977K(adInfo);
                            } else {
                                str = C10483a.m25876bd(adInfo) ? C10483a.m25941aU(adInfo).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String m25936aZ = C10483a.m25936aZ(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || C11013ag.isWifiConnected(ServiceProvider.getContext()) || z) {
                                    C10331c.m26254d("PreloadManager", "start Download preloadId " + m25936aZ + " true url " + str);
                                    m30909kx();
                                    C10404a.C10405a c10405a = new C10404a.C10405a();
                                    if (m30906p(adInfo)) {
                                        m29410a = KSImageLoader.loadImageSync(str) != null;
                                    } else {
                                        m29410a = C9000j.m29410a(str, m25936aZ, c10405a);
                                    }
                                    if (m29410a) {
                                        m30907o(adInfo);
                                        i++;
                                        C8497b.m30550kV();
                                        C8497b.m30576a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        C8497b.m30550kV();
                                        C8497b.m30558d(next, 4, c10405a.msg);
                                        C8766a.m29888qi().m29894f(next, 1, c10405a.msg);
                                    }
                                } else {
                                    C8497b.m30550kV();
                                    C8497b.m30558d(next, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            } else {
                                C8497b.m30550kV();
                                C8497b.m30558d(next, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            C8497b.m30550kV();
                            C8497b.m30576a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            m30907o(adInfo);
                            i++;
                        }
                    } else {
                        C8497b.m30550kV();
                        C8497b.m30558d(next, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i > 0) {
            C11100i.m23787ap("splashAd_", "onSplashVideoAdCacheSuccess");
            C8766a.m29888qi().m29898e(adTemplate, i);
        } else {
            C11100i.m23787ap("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i;
    }

    @AnyThread
    /* renamed from: e */
    public final boolean m30912e(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (m30906p(adInfo)) {
                        return KSImageLoader.isImageExist(C10483a.m25941aU(adInfo).materialUrl);
                    }
                    return m30905q(adInfo);
                }
            }
        }
        return false;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.f27596Cm = new HashMap<>();
        this.f27597Cn = new ArrayList();
        init();
    }
}
