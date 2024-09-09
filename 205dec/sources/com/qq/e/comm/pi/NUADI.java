package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface NUADI {
    String getAdNetWorkName();

    void loadData(int i4);

    void loadData(int i4, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i4);

    void setMinVideoDuration(int i4);

    void setVastClassName(String str);
}
