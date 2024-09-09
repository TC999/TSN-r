package com.bytedance.adsdk.lottie.xv.c;

import com.bytedance.adsdk.lottie.n;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class k<V, O> implements b<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<n.h<V>> f25774a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(List<n.h<V>> list) {
        this.f25774a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f25774a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f25774a.toArray()));
        }
        return sb.toString();
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public boolean w() {
        return this.f25774a.isEmpty() || (this.f25774a.size() == 1 && this.f25774a.get(0).h());
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public List<n.h<V>> xv() {
        return this.f25774a;
    }
}
