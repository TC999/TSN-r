package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdnLoadFailShowControl {

    /* renamed from: a */
    private Map<String, AdnLoadFailShowConfigBean> f461a;

    /* renamed from: b */
    private Map<String, ConcurrentHashMap<String, AdnLoadFailShowBean>> f462b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdnLoadFailShowControl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0967b {

        /* renamed from: a */
        private static AdnLoadFailShowControl f463a = new AdnLoadFailShowControl();
    }

    /* renamed from: a */
    public static AdnLoadFailShowControl m59628a() {
        return C0967b.f463a;
    }

    private AdnLoadFailShowControl() {
        this.f462b = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public void m59625a(ConcurrentHashMap<String, AdnLoadFailShowConfigBean> concurrentHashMap) {
        this.f461a = concurrentHashMap;
        if (concurrentHashMap != null) {
            Logger.m37562d("TTMediationSDK_AdnShowControl", "mAdnControlMap = " + concurrentHashMap);
            return;
        }
        Logger.m37562d("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
    }

    /* renamed from: a */
    public void m59626a(String str, String str2, String str3) {
        boolean z;
        Logger.m37562d("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, AdnLoadFailShowConfigBean> map = this.f461a;
        AdnLoadFailShowConfigBean adnLoadFailShowConfigBean = map != null ? map.get(str) : null;
        if (adnLoadFailShowConfigBean != null) {
            for (String str4 : adnLoadFailShowConfigBean.m59629b()) {
                if (TextUtils.equals(str4, str3)) {
                    Logger.m37562d("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = " + str4);
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            long time = new Date().getTime() + adnLoadFailShowConfigBean.m59632a();
            Logger.m37562d("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + IntervalEffectiveTime.m59607b(time));
            AdnLoadFailShowBean adnLoadFailShowBean = new AdnLoadFailShowBean(str, str2, time);
            if (this.f462b != null) {
                ConcurrentHashMap<String, AdnLoadFailShowBean> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, adnLoadFailShowBean);
                this.f462b.put(str, concurrentHashMap);
                Logger.m37562d("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.f462b);
            }
        }
    }

    /* renamed from: a */
    public boolean m59627a(String str, String str2) {
        AdnLoadFailShowBean adnLoadFailShowBean;
        ConcurrentHashMap<String, AdnLoadFailShowBean> concurrentHashMap;
        Logger.m37562d("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, AdnLoadFailShowBean>> map = this.f462b;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            adnLoadFailShowBean = null;
        } else {
            adnLoadFailShowBean = concurrentHashMap.get(str2);
            Logger.m37562d("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = " + adnLoadFailShowBean);
        }
        if (adnLoadFailShowBean == null || adnLoadFailShowBean.m59633a() == 0) {
            return true;
        }
        long time = new Date().getTime();
        if (time <= adnLoadFailShowBean.m59633a()) {
            Logger.m37562d("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + IntervalEffectiveTime.m59607b(time));
            Logger.m37562d("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + IntervalEffectiveTime.m59607b(adnLoadFailShowBean.m59633a()));
            return false;
        }
        return true;
    }
}
