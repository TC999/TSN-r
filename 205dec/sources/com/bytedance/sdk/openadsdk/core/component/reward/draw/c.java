package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.res.ux;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends RecyclerView.c<sr> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f32272c;
    private final float sr;
    private final float xv;

    /* renamed from: w  reason: collision with root package name */
    private final List<w> f32273w = new ArrayList();
    private final List<sr> ux = new ArrayList();

    public c(Context context, float f4, float f5) {
        this.f32272c = context;
        this.xv = f4;
        this.sr = f5;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public int c() {
        return Integer.MAX_VALUE;
    }

    public void sr() {
        for (sr srVar : this.ux) {
            srVar.xk();
        }
        this.ux.clear();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public long w(int i4) {
        return i4;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    /* renamed from: xv */
    public sr c(ViewGroup viewGroup, int i4) {
        sr srVar = new sr(ux.bk(this.f32272c));
        this.ux.add(srVar);
        return srVar;
    }

    public void c(List<w> list) {
        this.f32273w.clear();
        this.f32273w.addAll(list);
        xv();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void c(sr srVar) {
        super.c((c) srVar);
        srVar.xk();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void c(sr srVar, int i4) {
        List<w> list = this.f32273w;
        srVar.c(list.get(i4 % list.size()), this.xv, this.sr);
    }
}
