package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_goto109;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdsenseRitConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_goto109.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTTestToolUtil {
    /* renamed from: a */
    public static AdsenseRitConfig m59651a(AdsenseRitConfig adsenseRitConfig, String str) {
        if (adsenseRitConfig == null || TextUtils.isEmpty(str) || adsenseRitConfig.m59532s() == null || adsenseRitConfig.m59532s().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WaterFallConfig> it = adsenseRitConfig.m59532s().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WaterFallConfig next = it.next();
            if (str.equals(next.m59480c())) {
                arrayList.add(next.m59488a());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        AdsenseRitConfig m59571a = adsenseRitConfig.m59571a();
        m59571a.m59566a(arrayList);
        WaterFallConfig waterFallConfig = arrayList.get(0);
        waterFallConfig.m59473e(0);
        if (waterFallConfig.m59474e() == 0) {
            m59571a.m59570a(waterFallConfig.m59471f());
        }
        if (waterFallConfig.m59474e() == 1 || waterFallConfig.m59474e() == 2) {
            m59571a.m59565a(true);
            m59571a.m59569a(waterFallConfig.m59474e());
        }
        m59571a.m59551e(0);
        return m59571a;
    }
}
