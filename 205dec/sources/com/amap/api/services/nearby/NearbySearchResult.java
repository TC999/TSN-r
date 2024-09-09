package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NearbySearchResult {

    /* renamed from: a  reason: collision with root package name */
    private List<NearbyInfo> f11128a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f11129b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f11128a;
    }

    public int getTotalNum() {
        return this.f11129b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f11128a = list;
        this.f11129b = list.size();
    }
}
