package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.WaterFallConfig;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.TTSortUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class BiddingUtil {
    /* renamed from: a */
    public static Map<Integer, List<WaterFallConfig>> m59650a(List<WaterFallConfig> list) {
        int i;
        List list2;
        if (list == null || list.size() == 0) {
            return null;
        }
        TTSortUtil.m59090a(list);
        HashMap hashMap = new HashMap();
        int i2 = -1000;
        for (int i3 = 0; i3 < list.size(); i3++) {
            WaterFallConfig waterFallConfig = list.get(i3);
            if (waterFallConfig != null) {
                if (waterFallConfig.m59459l() != i2) {
                    list2 = new ArrayList();
                    i = waterFallConfig.m59459l();
                } else {
                    i = i2;
                    list2 = (List) hashMap.get(Integer.valueOf(i2));
                }
                if (list2 != null) {
                    list2.add(waterFallConfig);
                    hashMap.put(Integer.valueOf(i), list2);
                }
                i2 = i;
            }
        }
        return hashMap;
    }
}
