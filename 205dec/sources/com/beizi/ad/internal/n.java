package com.beizi.ad.internal;

import com.beizi.ad.RewardItem;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RewardItemImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class n implements RewardItem {

    /* renamed from: a  reason: collision with root package name */
    private String f13841a;

    /* renamed from: b  reason: collision with root package name */
    private int f13842b;

    public n(String str, int i4) {
        this.f13841a = str;
        this.f13842b = i4;
    }

    @Override // com.beizi.ad.RewardItem
    public int getAmount() {
        return this.f13842b;
    }

    @Override // com.beizi.ad.RewardItem
    public String getType() {
        return this.f13841a;
    }
}
