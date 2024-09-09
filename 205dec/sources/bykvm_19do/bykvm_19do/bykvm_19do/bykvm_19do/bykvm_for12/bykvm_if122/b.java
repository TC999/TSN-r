package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.h;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.g;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PreLoadManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b extends bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a {

    /* renamed from: l  reason: collision with root package name */
    private static volatile b f400l;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f401c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Integer> f402d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Integer> f403e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Long> f404f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, AdSlot> f405g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, f>> f406h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, Map<String, AdError>> f407i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, Boolean> f408j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, c> f409k = new HashMap();

    /* compiled from: PreLoadManager.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f412c;

        a(Context context, String str, int i4) {
            this.f410a = context;
            this.f411b = str;
            this.f412c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f410a, this.f411b, 2, this.f412c);
        }
    }

    /* compiled from: PreLoadManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class RunnableC0023b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f416c;

        RunnableC0023b(Context context, String str, int i4) {
            this.f414a = context;
            this.f415b = str;
            this.f416c = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f414a, this.f415b, 4, this.f416c);
        }
    }

    private b() {
    }

    public void b(String str, AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f405g.put(str, adSlot);
    }

    public int c(String str, int i4) {
        Integer num;
        if (i4 == 2 || (num = this.f403e.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void d(String str, int i4) {
        this.f401c.put(str, Integer.valueOf(i4));
    }

    public void e(String str, int i4) {
        this.f402d.put(str, Integer.valueOf(i4));
    }

    public void f(String str, int i4) {
        this.f403e.put(str, Integer.valueOf(i4));
    }

    public Long g(String str) {
        return this.f404f.get(str);
    }

    public List<f> h(String str) {
        ArrayList arrayList = new ArrayList();
        Map<String, f> map = this.f406h.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                f fVar = map.get(str2);
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static b a() {
        if (f400l == null) {
            synchronized (b.class) {
                if (f400l == null) {
                    f400l = new b();
                }
            }
        }
        return f400l;
    }

    public c d(String str) {
        return this.f409k.get(str);
    }

    public int e(String str) {
        Integer num = this.f401c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public int f(String str) {
        Integer num = this.f402d.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 3;
    }

    public void b(Context context, String str, int i4) {
        ThreadHelper.runOnMSDKThread(new RunnableC0023b(context, str, i4));
    }

    public AdSlot c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f405g.get(str);
    }

    private void c(String str, AdSlot adSlot) {
        Map<String, f> map = this.f406h.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                f fVar = map.get(str2);
                if (fVar != null && fVar.f418a != null) {
                    if (a(fVar)) {
                        map.put(str2, null);
                        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u9884\u7f13\u5b58\uff1a\u5e7f\u544a\u8fc7\u671f\u4e86 ---: " + fVar.f418a.getAdNetWorkName() + ", loadSort: " + fVar.f418a.getLoadSort() + ", showSort: " + fVar.f418a.getShowSort());
                    } else if (!bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(this.f405g.get(str), adSlot)) {
                        map.put(str2, null);
                        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u9884\u7f13\u5b58\uff1a\u5e7f\u544aAdSlot\u4e0d\u7b26\u5408 ---: " + fVar.f418a.getAdNetWorkName() + ", loadSort: " + fVar.f418a.getLoadSort() + ", showSort: " + fVar.f418a.getShowSort());
                    } else if (b(str2) != 0 && (!fVar.f418a.isAdCacheReady() || fVar.f418a.isHasShown())) {
                        map.put(str2, null);
                        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u9884\u7f13\u5b58\uff1aisReady\u4e3afalse ---: " + fVar.f418a.getAdNetWorkName() + ", loadSort: " + fVar.f418a.getLoadSort() + ", showSort: " + fVar.f418a.getShowSort());
                    }
                }
            }
        }
    }

    public void a(String str, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f404f.put(str, Long.valueOf(j4));
    }

    public void a(String str, String str2, long j4, AdError adError) {
        if (g(str) == null || g(str).longValue() == j4) {
            Map<String, AdError> map = this.f407i.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f407i.put(str, map);
            }
            map.put(str2, adError);
        }
    }

    public void a(String str, f fVar) {
        if (g(str) == null || g(str).longValue() == fVar.c()) {
            Map<String, f> map = this.f406h.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f406h.put(str, map);
            }
            map.put(fVar.f418a.getAdNetworkSlotId(), fVar);
        }
    }

    public boolean a(String str, AdSlot adSlot) {
        this.f408j.put(str, Boolean.FALSE);
        c cVar = this.f409k.get(str);
        if (cVar != null) {
            List<h> t3 = cVar.t();
            if (Logger.isDebug()) {
                for (h hVar : t3) {
                    Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "waterfall: " + hVar.d() + ", loadSort: " + hVar.l() + ", showSort: " + hVar.s() + ", eCpm: " + hVar.f());
                }
            }
            a(t3, str, adSlot, cVar);
            c(str, adSlot);
            Map<String, f> map = this.f406h.get(str);
            if (map != null) {
                if (cVar.b() == 1) {
                    for (int i4 = 0; i4 < f(str) && i4 < t3.size(); i4++) {
                        if (map.get(t3.get(i4).c()) != null) {
                            return true;
                        }
                    }
                } else {
                    for (int i5 = 0; i5 < t3.size(); i5++) {
                        if (map.get(t3.get(i5).c()) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void a(List<h> list, String str, AdSlot adSlot, c cVar) {
        f fVar;
        if (list.size() <= 0) {
            return;
        }
        Map<String, f> map = this.f406h.get(str);
        if (map != null && (fVar = map.get(list.get(0).c())) != null && !a(fVar) && fVar.f418a.isAdCacheReady() && !fVar.f418a.isHasShown()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u547d\u4e2d\u6700\u4f18\u5e7f\u544a\uff1a " + fVar.f418a.getAdNetWorkName() + ", loadSort: " + fVar.f418a.getLoadSort() + ", showSort: " + fVar.f418a.getShowSort());
            return;
        }
        List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a> a4 = a(list, str, map, adSlot, cVar);
        if (a4.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i4 = 0; i4 < a4.size(); i4++) {
                sb.append(a4.get(i4).a());
                if (i4 == a4.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                JSONArray jSONArray = new JSONArray(sb.toString());
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo: " + jSONArray.toString());
                g.a(this.f405g.get(str), jSONArray.toString());
            } catch (JSONException e4) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "adCannotUseInfo json err: " + e4.getMessage());
            }
        }
    }

    private List<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a> a(List<h> list, String str, Map<String, f> map, AdSlot adSlot, c cVar) {
        int f4;
        TTBaseAd tTBaseAd;
        ArrayList arrayList = new ArrayList();
        if (cVar.b() == 2 && (cVar instanceof e)) {
            f4 = ((e) cVar).A();
        } else {
            f4 = f(str);
        }
        for (int i4 = 0; i4 < list.size() && i4 < f4; i4++) {
            String c4 = list.get(i4).c();
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a();
            aVar.b(c4);
            aVar.e(list.get(i4).s());
            aVar.c(list.get(i4).l());
            f fVar = map != null ? map.get(c4) : null;
            if (fVar != null && (tTBaseAd = fVar.f418a) != null) {
                aVar.b(tTBaseAd.isHasShown() ? 1 : 0);
                int a4 = a(fVar, this.f405g.get(str), adSlot, "\u9884\u7f13\u5b58");
                if (a4 != -1) {
                    aVar.d(a4);
                    arrayList.add(aVar);
                }
            } else {
                Map<String, AdError> map2 = this.f407i.get(str);
                AdError adError = map2 != null ? map2.get(c4) : null;
                if (adError != null) {
                    aVar.d(3);
                    aVar.a(adError.thirdSdkErrorCode);
                    aVar.a(adError.thirdSdkErrorMessage);
                } else {
                    aVar.d(4);
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public f a(String str, String str2) {
        Map<String, f> map = this.f406h.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public void a(Context context, String str, int i4) {
        ThreadHelper.runOnMSDKThread(new a(context, str, i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i4, int i5) {
        c eVar;
        int c4 = c(str, i5);
        if (c4 == 0) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u914d\u7f6e\u672a\u5f00\u542f\u9884\u52a0\u8f7d\u7f13\u5b58 ----");
        } else if (this.f408j.get(str) == null || !this.f408j.get(str).booleanValue()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u9884\u7f13\u5b58\u5f00\u59cb\u8bf7\u6c42, req_type: " + c4);
            Map<String, f> map = this.f406h.get(str);
            if (map != null) {
                map.clear();
            }
            Map<String, AdError> map2 = this.f407i.get(str);
            if (map2 != null) {
                map2.clear();
            }
            if (c4 == 1) {
                eVar = new d(context, str);
            } else if (c4 == 2) {
                eVar = new e(context, str);
            } else {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- \u9884\u52a0\u8f7d\u914d\u7f6e\u9519\u8bef\uff0creq_type\uff1a" + c4);
                return;
            }
            this.f409k.put(str, eVar);
            this.f408j.put(str, Boolean.TRUE);
            AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.b.getShallowCopy(this.f405g.get(str));
            if (shallowCopy == null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- preload fail\uff0cadslot\u4e3anull\uff0crit\uff1a" + str);
                return;
            }
            shallowCopy.setPrimeRitReqType(i4);
            eVar.a(shallowCopy);
        }
    }
}
