package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ElecConsumeInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f11354a;

    /* renamed from: b  reason: collision with root package name */
    private int f11355b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11356c;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f11357d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f11354a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f11357d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f11356c;
    }

    public int getRunOutStepIndex() {
        return this.f11355b;
    }

    public void setConsumeEnergy(int i4) {
        this.f11354a = i4;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f11357d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f11356c = latLonPoint;
    }

    public void setRunOutStepIndex(int i4) {
        this.f11355b = i4;
    }
}
