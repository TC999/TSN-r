package com.beizi.fusion.g;

import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DataConvertUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class s {
    public static List<Pair<String, Integer>> a(List<AdSpacesBean.DpLinkUrlListBean> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (AdSpacesBean.DpLinkUrlListBean dpLinkUrlListBean : list) {
                arrayList.add(new Pair(dpLinkUrlListBean.getDpLinkUrL(), Integer.valueOf(dpLinkUrlListBean.getOptimizePercent())));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
