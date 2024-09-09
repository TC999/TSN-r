package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: IntervalShowControl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, g> f470a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, h> f471b;

    /* renamed from: c  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.e<h> f472c;

    /* renamed from: d  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c<g> f473d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Long> f474e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Pair<String, String>> f475f;

    /* compiled from: IntervalShowControl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f476a;

        a(String str) {
            this.f476a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.f476a);
            h i4 = i.this.i(this.f476a);
            if (i4 == null || !i4.a()) {
                return;
            }
            Date date = new Date();
            Logger.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount save time = " + f.b(date.getTime()));
            i.this.a(this.f476a, date.getTime());
        }
    }

    /* compiled from: IntervalShowControl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f478a;

        b(String str) {
            this.f478a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.f478a);
            g h4 = i.this.h(this.f478a);
            if (h4 == null || !h4.a()) {
                return;
            }
            for (e eVar : h4.e()) {
                if (eVar.a() < eVar.c()) {
                    i.this.a(h4, eVar.d(), eVar.a() + 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntervalShowControl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private static i f480a = new i(null);
    }

    /* synthetic */ i(a aVar) {
        this();
    }

    public static i b() {
        return c.f480a;
    }

    public void a() {
        this.f472c = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.f(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
        this.f473d = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.d(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d());
        this.f470a = new ConcurrentHashMap();
        this.f471b = new ConcurrentHashMap();
        this.f475f = new ConcurrentHashMap();
        this.f474e = new ConcurrentHashMap();
    }

    public boolean c(String str) {
        Logger.d("TTMediationSDK_IntervalShowControl", "checkPacing ritId = " + str);
        h i4 = i(str);
        if (i4 != null && i4.a() && i4.h()) {
            long time = new Date().getTime();
            long g4 = i4.g();
            long g5 = i4.g() + i4.e();
            Logger.d("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + f.b(time) + " showTime = " + f.b(g4) + " pacingBean.getPacing() = " + i4.e() + " pacingTime = " + f.b(g5));
            if (time <= g5) {
                this.f474e.put(str, Long.valueOf(time - g4));
                return false;
            }
        }
        return true;
    }

    public void d(String str) {
        Logger.d("TTMediationSDK_IntervalShowControl", "deleteFreqctlByRitId = " + str);
        if (this.f473d != null) {
            Map<String, g> map = this.f470a;
            if (map != null) {
                map.remove(str);
            }
            this.f473d.a(str);
        }
    }

    public void e(String str) {
        Logger.d("TTMediationSDK_IntervalShowControl", "deletePacingByRitId = " + str);
        if (this.f472c != null) {
            Map<String, h> map = this.f471b;
            if (map != null) {
                map.remove(str);
            }
            this.f472c.a(str);
        }
    }

    public Pair<String, String> f(String str) {
        return this.f475f.get(str);
    }

    public long g(String str) {
        Long l4 = this.f474e.get(str);
        if (l4 == null) {
            return -2L;
        }
        return l4.longValue();
    }

    public g h(String str) {
        if (this.f473d != null) {
            Map<String, g> map = this.f470a;
            g gVar = map != null ? map.get(str) : null;
            if (gVar != null) {
                return gVar;
            }
            g b4 = this.f473d.b(str);
            if (b4 != null) {
                Map<String, g> map2 = this.f470a;
                if (map2 != null) {
                    map2.put(b4.b(), b4);
                }
                return b4;
            }
        }
        return null;
    }

    public h i(String str) {
        if (this.f472c != null) {
            Map<String, h> map = this.f471b;
            h hVar = map != null ? map.get(str) : null;
            if (hVar != null) {
                return hVar;
            }
            h b4 = this.f472c.b(str);
            if (b4 != null) {
                this.f471b.put(b4.b(), b4);
            }
            return b4;
        }
        return null;
    }

    public void j(String str) {
        ThreadHelper.runOnMSDKThread(new a(str));
    }

    private i() {
    }

    public void b(h hVar) {
        Logger.d("TTMediationSDK_IntervalShowControl", "saveIntervalPacingBean = " + hVar.toString());
        if (this.f472c == null || TextUtils.isEmpty(hVar.f())) {
            return;
        }
        Map<String, h> map = this.f471b;
        if (map != null) {
            map.put(hVar.b(), hVar);
        }
        this.f472c.a((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.e<h>) hVar);
    }

    public void a(String str, long j4) {
        if (this.f472c != null) {
            Map<String, h> map = this.f471b;
            h hVar = map != null ? map.get(str) : null;
            if (hVar != null) {
                hVar.a(j4);
            }
            this.f472c.a(str, j4);
        }
    }

    public boolean b(String str) {
        Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl ritId = " + str);
        g h4 = h(str);
        if (h4 == null || !h4.a()) {
            return true;
        }
        for (e eVar : h4.e()) {
            Date date = new Date();
            Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + eVar.b());
            if (date.getTime() <= eVar.b()) {
                if (eVar.a() >= eVar.c()) {
                    Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl \u5230\u4e86\u4e0a\u7ebf\u4e0d\u53ef\u4ee5\u5c55\u793a ruleId = " + eVar.d() + " count = " + eVar.a());
                    Map<String, Pair<String, String>> map = this.f475f;
                    String d4 = eVar.d();
                    map.put(str, new Pair<>(d4, eVar.a() + ""));
                    return false;
                }
                Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl \u672a\u5230\u4e0a\u7ebf\u53ef\u4ee5\u5c55\u793a ruleId = " + eVar.d() + " count = " + eVar.a());
            } else {
                a(h4, eVar.d(), 0);
                a(h4, eVar.d(), f.a(eVar.e()));
                Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl \u6709\u6548\u671f\u5916\u8ba1\u6570\u9700\u8981\u6e050\uff0c\u8fc7\u671f\u65f6\u95f4\u9700\u8981\u66f4\u65b0 = " + eVar.d());
            }
        }
        return true;
    }

    public boolean a(h hVar) {
        Logger.d("TTMediationSDK_IntervalShowControl", "pacing checkPacingUpdate ritId = " + hVar.b());
        h i4 = i(hVar.b());
        if (i4 == null) {
            Logger.d("TTMediationSDK_IntervalShowControl", "pacing \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(hVar.f())) {
            Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            e(hVar.b());
            return false;
        } else if (TextUtils.equals(i4.f(), hVar.f())) {
            Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId \u4e00\u81f4 ruleId = " + i4.f() + " \u65e0\u9700\u5904\u7406");
            return false;
        } else {
            Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old ruleId = " + i4.f() + "  new ruleId" + hVar.f());
            StringBuilder sb = new StringBuilder();
            sb.append("pacing \u5220\u9664 ritId = ");
            sb.append(hVar.b());
            Logger.d("TTMediationSDK_IntervalShowControl", sb.toString());
            e(hVar.b());
            return true;
        }
    }

    public void c(g gVar) {
        Logger.d("TTMediationSDK_IntervalShowControl", "updateFreqctlItem bean = " + gVar.toString());
        if (this.f473d != null) {
            Map<String, g> map = this.f470a;
            if (map != null) {
                map.put(gVar.b(), gVar);
            }
            this.f473d.b((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c<g>) gVar);
        }
    }

    public void a(String str) {
        ThreadHelper.runOnMSDKThread(new b(str));
    }

    public boolean a(g gVar) {
        Logger.d("TTMediationSDK_IntervalShowControl", "pacing checkFreqctlUpdate ritId = " + gVar.b());
        g h4 = h(gVar.b());
        if (h4 == null) {
            Logger.d("TTMediationSDK_IntervalShowControl", "freqctl \u89c4\u5219\u4e3a\u7a7a\u76f4\u63a5\u5b58\u50a8");
            return true;
        } else if (TextUtils.isEmpty(gVar.c())) {
            Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version \u4e3a\u7a7a \u6e05\u7a7a\u672c\u5730\u6570\u636e ");
            d(gVar.b());
            return false;
        } else if (TextUtils.equals(h4.c(), gVar.c())) {
            Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version \u4e00\u81f4 version = " + h4.c() + "\u65e0\u9700\u5904\u7406");
            return false;
        } else {
            Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version\u4e0d\u4e00\u81f4\uff0c\u7f13\u5b58\u65b0\u89c4\u5219 old version = " + h4.c() + "  new version " + gVar.c());
            Logger.d("TTMediationSDK_IntervalShowControl", "freqctl \u9700\u8981\u53d6\u51fajson\u91cd\u65b0\u8d4b\u503c");
            return true;
        }
    }

    public void b(g gVar) {
        e eVar;
        Logger.d("TTMediationSDK_IntervalShowControl", "saveIntervalFreqctlBean = " + gVar.toString());
        g h4 = h(gVar.b());
        if (h4 == null) {
            Logger.d("TTMediationSDK_IntervalShowControl", "saveIntervalFreqctlBean \u6570\u636e\u5e93\u4e2d\u65e0\u5185\u5bb9\u76f4\u63a5\u5b58\u50a8");
            if (this.f473d != null) {
                Map<String, g> map = this.f470a;
                if (map != null) {
                    map.put(gVar.b(), gVar);
                }
                this.f473d.a((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c<g>) gVar);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        for (e eVar2 : h4.e()) {
            hashMap.put(eVar2.d(), eVar2);
        }
        for (e eVar3 : gVar.e()) {
            if (hashMap.containsKey(eVar3.d()) && (eVar = (e) hashMap.get(eVar3.d())) != null) {
                eVar3.a(eVar);
            }
        }
        Map<String, g> map2 = this.f470a;
        if (map2 != null) {
            map2.put(gVar.b(), gVar);
        }
        c(gVar);
    }

    public void a(g gVar, String str, int i4) {
        Logger.d("TTMediationSDK_IntervalShowControl", "updateFreqctlCount bean = " + gVar.toString() + " ruleId = " + str + " count = " + i4);
        if (this.f473d != null) {
            gVar.a(str, i4);
            Map<String, g> map = this.f470a;
            if (map != null) {
                map.put(gVar.b(), gVar);
            }
            this.f473d.a((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c<g>) gVar, str, i4);
        }
    }

    public void a(g gVar, String str, long j4) {
        Logger.d("TTMediationSDK_IntervalShowControl", "updateFreqctlTime bean = " + gVar.toString() + " ruleId = " + str + " time = " + j4);
        if (this.f473d != null) {
            gVar.a(str, j4);
            Map<String, g> map = this.f470a;
            if (map != null) {
                map.put(gVar.b(), gVar);
            }
            this.f473d.a((bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.c<g>) gVar, str, j4);
        }
    }
}
