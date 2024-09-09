package com.beizi.fusion.g;

import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PriceUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class al {
    public static int a(List<AdSpacesBean.BuyerBean.PriceDictBean> list, String str) {
        if (str == null || list == null || list.size() == 0) {
            return -1;
        }
        for (AdSpacesBean.BuyerBean.PriceDictBean priceDictBean : list) {
            af.a("BeiZis", "priceLevel = " + str + ",priceDictBean.getName() = " + priceDictBean.getName());
            if (str.equalsIgnoreCase(priceDictBean.getName())) {
                return priceDictBean.getPrice();
            }
        }
        return -2;
    }
}
