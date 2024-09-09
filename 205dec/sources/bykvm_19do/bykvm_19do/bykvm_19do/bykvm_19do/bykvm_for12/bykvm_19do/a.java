package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.g;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTNetworkRequestInfo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AdCacheManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a {

    /* renamed from: k  reason: collision with root package name */
    private static volatile a f374k;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f375c = {"unity", "ks"};

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Integer> f376d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Integer> f377e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<f>> f378f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, h> f379g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, String> f380h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f381i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Integer> f382j = new HashMap();

    /* compiled from: AdCacheManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class RunnableC0022a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f383a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f384b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AdSlot f385c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map f386d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f387e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TTNetworkRequestInfo f388f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ g f389g;

        RunnableC0022a(String str, boolean z3, AdSlot adSlot, Map map, Context context, TTNetworkRequestInfo tTNetworkRequestInfo, g gVar) {
            this.f383a = str;
            this.f384b = z3;
            this.f385c = adSlot;
            this.f386d = map;
            this.f387e = context;
            this.f388f = tTNetworkRequestInfo;
            this.f389g = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            f fVar;
            List<f> list = (List) a.this.f378f.get(this.f383a);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (f fVar2 : list) {
                    if (fVar2 != null && fVar2.f418a.isHasShown()) {
                        list.remove(fVar2);
                        arrayList.add(fVar2);
                    }
                }
            }
            if (Logger.isDebug()) {
                String str2 = "";
                if (arrayList.size() <= 0 || (fVar = (f) arrayList.get(0)) == null) {
                    str = "";
                } else {
                    String b4 = com.bytedance.msdk.base.a.b(fVar.f418a.getAdType());
                    str2 = fVar.f418a.getAdNetWorkName();
                    str = b4;
                }
                Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u7f13\u5b58\u79fb\u9664 -----\uff1a" + str2 + ", " + str + ", " + this.f383a);
            }
            if (this.f384b && a.this.d(this.f383a)) {
                a.this.a(this.f383a, this.f385c, this.f386d, this.f387e, this.f388f, this.f389g);
                return;
            }
            Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0c\u56e0\u4e3a\uff1a\u5df2\u53d1\u8d77waterfall\u9884\u52a0\u8f7d\uff0c\u6216feed\u591a\u5e7f\u544a\uff0c\u6216\u672a\u5f00\u542fadn\u9884\u52a0\u8f7d --: " + this.f383a);
        }
    }

    private a() {
    }

    public synchronized int b(String str, AdSlot adSlot) {
        if (b(str) == 0) {
            return c(str, adSlot);
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f378f.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            f fVar = null;
            boolean z3 = false;
            for (f fVar2 : copyOnWriteArrayList) {
                int a4 = a(fVar2, fVar2.a(), adSlot, "\u5e7f\u544a\u590d\u7528");
                if (a4 == -1) {
                    z3 = true;
                } else {
                    if (a4 != 6) {
                        copyOnWriteArrayList.remove(fVar2);
                    }
                    if (fVar == null) {
                        fVar = fVar2;
                    }
                    bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a();
                    aVar.c(fVar2.f418a.getLoadSort());
                    aVar.e(fVar2.f418a.getShowSort());
                    aVar.b(fVar2.f418a.getAdNetworkSlotId());
                    aVar.d(a4);
                    aVar.b(fVar2.f418a.isHasShown() ? 1 : 0);
                    arrayList.add(aVar);
                }
            }
            if (z3) {
                return 3;
            }
            if (fVar != null) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot, fVar.f418a, a(arrayList));
            }
            return 2;
        }
        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5f53\u524d\u6ca1\u6709\u5e7f\u544a\u7f13\u5b58 -------adnSlotId: " + str);
        return 1;
    }

    public boolean c(String str, int i4) {
        Integer num;
        return (i4 == 2 || (num = this.f376d.get(str)) == null || num.intValue() != 1) ? false : true;
    }

    public void d(String str, int i4) {
        this.f377e.put(str, Integer.valueOf(i4));
    }

    public void e(String str, int i4) {
        this.f376d.put(str, Integer.valueOf(i4));
    }

    public boolean d(String str) {
        Integer num = this.f377e.get(str);
        return num != null && num.intValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdCacheManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements TTAbsAdLoaderAdapter.AdapterLoaderListener {

        /* renamed from: a  reason: collision with root package name */
        private AdSlot f391a;

        b(AdSlot adSlot) {
            this.f391a = adSlot;
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdFailed(AdError adError, d dVar) {
            if (adError == null || dVar == null) {
                return;
            }
            Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5e7f\u544a\u7f13\u5b58\u5931\u8d25 --- " + dVar.c() + ", " + dVar.d() + ", " + com.bytedance.msdk.base.a.b(dVar.b()) + ", errCode: " + adError.thirdSdkErrorCode + ",msg=" + adError.thirdSdkErrorMessage);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(TTBaseAd tTBaseAd, d dVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tTBaseAd);
            onAdLoaded(arrayList, dVar);
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdVideoCache() {
        }

        @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.AdapterLoaderListener
        public void onAdLoaded(List<TTBaseAd> list, d dVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    arrayList.add(new f(tTBaseAd, dVar, 0L, SystemClock.elapsedRealtime(), this.f391a));
                }
            }
            if (arrayList.size() > 0) {
                TTBaseAd tTBaseAd2 = ((f) arrayList.get(0)).f418a;
                Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5e7f\u544a\u7f13\u5b58\u6210\u529f --- " + tTBaseAd2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.base.a.b(tTBaseAd2.getAdType()) + ", adnSlotId: " + tTBaseAd2.getAdNetworkSlotId() + ", ad\u4e2a\u6570: " + arrayList.size());
                a.this.a(tTBaseAd2.getAdNetworkSlotId(), arrayList);
            }
        }
    }

    public static a a() {
        if (f374k == null) {
            synchronized (a.class) {
                if (f374k == null) {
                    f374k = new a();
                }
            }
        }
        return f374k;
    }

    public String c(String str) {
        return this.f381i.get(str);
    }

    private int c(String str, AdSlot adSlot) {
        int i4;
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f378f.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            f fVar = null;
            boolean z3 = false;
            Iterator<f> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                if (!a(next)) {
                    if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(next.a(), adSlot)) {
                        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u590d\u7528\u6210\u529f\uff1a--------" + next.f418a.getAdNetWorkName() + ", adSlotId: " + str);
                        z3 = true;
                    } else {
                        i4 = 6;
                        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:AdSlot\u4e0d\u7b26\u5408 -------: " + next.f418a.getAdNetWorkName() + ", adSlotId: " + str);
                    }
                } else {
                    copyOnWriteArrayList.remove(next);
                    i4 = next.f418a.adnHasAdExpiredApi() ? 1 : 2;
                    Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5e7f\u544a\u8fc7\u671f\u4e86 -------: " + next.f418a.getAdNetWorkName() + ", adSlotId: " + str);
                }
                if (fVar == null) {
                    fVar = next;
                }
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a();
                aVar.c(next.f418a.getLoadSort());
                aVar.e(next.f418a.getShowSort());
                aVar.b(next.f418a.getAdNetworkSlotId());
                aVar.d(i4);
                aVar.b(next.f418a.isHasShown() ? 1 : 0);
                arrayList.add(aVar);
            }
            if (z3) {
                return 3;
            }
            if (fVar != null) {
                bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(adSlot, fVar.f418a, a(arrayList));
            }
            return 2;
        }
        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5f53\u524d\u6ca1\u6709\u5e7f\u544a\u7f13\u5b58 -------adnSlotId: " + str);
        return 1;
    }

    public void a(String str, h hVar, String str2, int i4) {
        if (hVar != null) {
            this.f379g.put(str, hVar);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f380h.put(str, str2);
        }
        this.f382j.put(str, Integer.valueOf(i4));
    }

    public void a(String str, String str2) {
        this.f381i.put(str, str2);
    }

    public void a(String str, AdSlot adSlot, Map<String, Object> map, boolean z3, TTNetworkRequestInfo tTNetworkRequestInfo, g gVar, Context context) {
        ThreadHelper.runOnMSDKThread(new RunnableC0022a(str, z3, adSlot, map, context, tTNetworkRequestInfo, gVar));
    }

    public void a(String str, List<f> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f378f.get(str);
        if (copyOnWriteArrayList != null) {
            for (f fVar : list) {
                if (!a(copyOnWriteArrayList, fVar)) {
                    copyOnWriteArrayList.add(fVar);
                }
            }
            return;
        }
        this.f378f.put(str, new CopyOnWriteArrayList<>(list));
    }

    private boolean a(List<f> list, f fVar) {
        for (f fVar2 : list) {
            if (fVar2 != null && fVar != null && fVar2.f418a == fVar.f418a) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<f> a(String str, AdSlot adSlot) {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f378f.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int adCount = adSlot != null ? adSlot.getAdCount() : 1;
        ArrayList<f> arrayList = new ArrayList();
        for (int i4 = 0; arrayList.size() < adCount && i4 < copyOnWriteArrayList.size(); i4++) {
            if (!copyOnWriteArrayList.get(i4).d() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i4).a(), adSlot)) {
                arrayList.add(copyOnWriteArrayList.get(i4));
            }
        }
        for (int i5 = 0; arrayList.size() < adCount && i5 < copyOnWriteArrayList.size(); i5++) {
            if (copyOnWriteArrayList.get(i5).d() && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(copyOnWriteArrayList.get(i5).a(), adSlot)) {
                arrayList.add(copyOnWriteArrayList.get(i5));
            }
        }
        for (f fVar : arrayList) {
            fVar.a(true);
        }
        return arrayList;
    }

    private String a(List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(list.get(i4).a());
                if (i4 == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e4) {
                Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528\uff1aadCannotUseInfo json err: " + e4.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdSlot adSlot, Map<String, Object> map, Context context, TTNetworkRequestInfo tTNetworkRequestInfo, g gVar) {
        String[] strArr;
        if (adSlot == null) {
            Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0cadSlot\u4e3a\u7a7a -------: " + str);
            return;
        }
        h hVar = this.f379g.get(str);
        String str2 = this.f380h.get(str);
        if (!TextUtils.isEmpty(str2) && hVar != null) {
            for (String str3 : this.f375c) {
                if (TextUtils.equals(str3, hVar.d())) {
                    Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0c" + str3 + "\u4e3a\u5355\u4f8b\u6a21\u5f0f -------: " + str);
                    return;
                }
            }
            int intValue = this.f382j.get(str) != null ? this.f382j.get(str).intValue() : -1;
            Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5f00\u59cb -------: " + str);
            TTAbsAdLoaderAdapter d4 = com.bytedance.msdk.core.corelogic.f.d(null, hVar, str2);
            if (d4 != null) {
                d4.setAdapterListener(new b(adSlot));
                d4.loadAdInter(context, hVar, com.bytedance.msdk.core.corelogic.f.f(hVar, adSlot, map, null, tTNetworkRequestInfo, 4, 1), adSlot, gVar, intValue);
                Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5df2\u53d1\u5b8c -------: " + str);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g.a(hVar, adSlot, 4, 1);
            return;
        }
        Logger.d("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0cclassName\u6216wfcBean\u4e3a\u7a7a --: " + str);
    }
}
