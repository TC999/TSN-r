package com.p518qq.p519e.comm.p520pi;

import com.p518qq.p519e.comm.constants.LoadAdParams;
import java.util.List;

/* renamed from: com.qq.e.comm.pi.NUADI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NUADI {
    String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(String str);
}
