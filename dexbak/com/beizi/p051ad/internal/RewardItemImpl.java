package com.beizi.p051ad.internal;

import com.beizi.p051ad.RewardItem;

/* renamed from: com.beizi.ad.internal.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RewardItemImpl implements RewardItem {

    /* renamed from: a */
    private String f10173a;

    /* renamed from: b */
    private int f10174b;

    public RewardItemImpl(String str, int i) {
        this.f10173a = str;
        this.f10174b = i;
    }

    @Override // com.beizi.p051ad.RewardItem
    public int getAmount() {
        return this.f10174b;
    }

    @Override // com.beizi.p051ad.RewardItem
    public String getType() {
        return this.f10173a;
    }
}
