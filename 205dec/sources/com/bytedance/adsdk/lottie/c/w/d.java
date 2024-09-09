package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.xv.w.ev;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<c<com.bytedance.adsdk.lottie.xv.w.i, Path>> f25484a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c<Integer, Integer>> f25485b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ev> f25486c;

    public d(List<ev> list) {
        this.f25486c = list;
        this.f25484a = new ArrayList(list.size());
        this.f25485b = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f25484a.add(list.get(i4).c().c());
            this.f25485b.add(list.get(i4).d().c());
        }
    }

    public List<ev> a() {
        return this.f25486c;
    }

    public List<c<com.bytedance.adsdk.lottie.xv.w.i, Path>> b() {
        return this.f25484a;
    }

    public List<c<Integer, Integer>> c() {
        return this.f25485b;
    }
}
