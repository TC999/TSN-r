package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ElecConsumeInfo {

    /* renamed from: a */
    private int f7660a;

    /* renamed from: b */
    private int f7661b;

    /* renamed from: c */
    private LatLonPoint f7662c;

    /* renamed from: d */
    private List<Integer> f7663d = new ArrayList();

    public int getConsumeEnergy() {
        return this.f7660a;
    }

    public List<Integer> getLeftEnergy() {
        return this.f7663d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.f7662c;
    }

    public int getRunOutStepIndex() {
        return this.f7661b;
    }

    public void setConsumeEnergy(int i) {
        this.f7660a = i;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.f7663d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.f7662c = latLonPoint;
    }

    public void setRunOutStepIndex(int i) {
        this.f7661b = i;
    }
}
