package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.v7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class UpdateStrategy {

    /* renamed from: a */
    UpdateStrategy f5568a;

    public UpdateStrategy() {
    }

    /* renamed from: a */
    public int mo53646a() {
        UpdateStrategy updateStrategy = this.f5568a;
        return Math.min(Integer.MAX_VALUE, updateStrategy != null ? updateStrategy.mo53646a() : Integer.MAX_VALUE);
    }

    /* renamed from: b */
    public void mo53645b(int i) {
        UpdateStrategy updateStrategy = this.f5568a;
        if (updateStrategy != null) {
            updateStrategy.mo53645b(i);
        }
    }

    /* renamed from: c */
    public void mo53644c(boolean z) {
        UpdateStrategy updateStrategy = this.f5568a;
        if (updateStrategy != null) {
            updateStrategy.mo53644c(z);
        }
    }

    /* renamed from: d */
    protected abstract boolean mo53576d();

    /* renamed from: e */
    public final boolean m53643e() {
        UpdateStrategy updateStrategy = this.f5568a;
        if (updateStrategy != null ? updateStrategy.m53643e() : true) {
            return mo53576d();
        }
        return false;
    }

    public UpdateStrategy(UpdateStrategy updateStrategy) {
        this.f5568a = updateStrategy;
    }
}
