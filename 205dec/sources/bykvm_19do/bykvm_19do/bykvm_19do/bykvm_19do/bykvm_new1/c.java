package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AdnLoadFailShowControl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b> f454a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a>> f455b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdnLoadFailShowControl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static c f456a = new c();
    }

    public static c a() {
        return b.f456a;
    }

    private c() {
        this.f455b = new ConcurrentHashMap();
    }

    public void a(ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b> concurrentHashMap) {
        this.f454a = concurrentHashMap;
        if (concurrentHashMap != null) {
            Logger.d("TTMediationSDK_AdnShowControl", "mAdnControlMap = " + concurrentHashMap);
            return;
        }
        Logger.d("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
    }

    public void a(String str, String str2, String str3) {
        boolean z3;
        Logger.d("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b> map = this.f454a;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b bVar = map != null ? map.get(str) : null;
        if (bVar != null) {
            for (String str4 : bVar.b()) {
                if (TextUtils.equals(str4, str3)) {
                    Logger.d("TTMediationSDK_AdnShowControl", "setAdnError \u547d\u4e2derrorCode = " + str4);
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            long time = new Date().getTime() + bVar.a();
            Logger.d("TTMediationSDK_AdnShowControl", "setAdnError \u66f4\u65b0\u65f6\u95f4 = " + f.b(time));
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a aVar = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a(str, str2, time);
            if (this.f455b != null) {
                ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, aVar);
                this.f455b.put(str, concurrentHashMap);
                Logger.d("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.f455b);
            }
        }
    }

    public boolean a(String str, String str2) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a aVar;
        ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a> concurrentHashMap;
        Logger.d("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a>> map = this.f455b;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            aVar = null;
        } else {
            aVar = concurrentHashMap.get(str2);
            Logger.d("TTMediationSDK_AdnShowControl", "checkLoad \u53d6\u51fa\u7684showBean = " + aVar);
        }
        if (aVar == null || aVar.a() == 0) {
            return true;
        }
        long time = new Date().getTime();
        if (time <= aVar.a()) {
            Logger.d("TTMediationSDK_AdnShowControl", "checkLoad \u5f53\u524d\u65f6\u95f4 = " + f.b(time));
            Logger.d("TTMediationSDK_AdnShowControl", "checkLoad \u89c4\u5219\u6709\u6548\u65f6\u95f4 = " + f.b(aVar.a()));
            return false;
        }
        return true;
    }
}
