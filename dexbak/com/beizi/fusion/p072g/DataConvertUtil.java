package com.beizi.fusion.p072g;

import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.g.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DataConvertUtil {
    /* renamed from: a */
    public static List<Pair<String, Integer>> m48220a(List<AdSpacesBean.DpLinkUrlListBean> list) {
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
