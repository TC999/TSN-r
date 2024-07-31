package com.beizi.fusion.p072g;

import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* renamed from: com.beizi.fusion.g.ak */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PriceUtil {
    /* renamed from: a */
    public static int m48440a(List<AdSpacesBean.BuyerBean.PriceDictBean> list, String str) {
        if (str == null || list == null || list.size() == 0) {
            return -1;
        }
        for (AdSpacesBean.BuyerBean.PriceDictBean priceDictBean : list) {
            C3116af.m48496a("BeiZis", "priceLevel = " + str + ",priceDictBean.getName() = " + priceDictBean.getName());
            if (str.equalsIgnoreCase(priceDictBean.getName())) {
                return priceDictBean.getPrice();
            }
        }
        return -2;
    }
}
