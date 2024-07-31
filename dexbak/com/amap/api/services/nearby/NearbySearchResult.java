package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NearbySearchResult {

    /* renamed from: a */
    private List<NearbyInfo> f7434a = new ArrayList();

    /* renamed from: b */
    private int f7435b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f7434a;
    }

    public int getTotalNum() {
        return this.f7435b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f7434a = list;
        this.f7435b = list.size();
    }
}
