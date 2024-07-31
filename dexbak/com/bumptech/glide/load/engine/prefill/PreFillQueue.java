package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.prefill.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class PreFillQueue {

    /* renamed from: a */
    private final Map<PreFillType, Integer> f13884a;

    /* renamed from: b */
    private final List<PreFillType> f13885b;

    /* renamed from: c */
    private int f13886c;

    /* renamed from: d */
    private int f13887d;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.f13884a = map;
        this.f13885b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.f13886c += num.intValue();
        }
    }

    /* renamed from: a */
    public int m45157a() {
        return this.f13886c;
    }

    /* renamed from: b */
    public boolean m45156b() {
        return this.f13886c == 0;
    }

    /* renamed from: c */
    public PreFillType m45155c() {
        PreFillType preFillType = this.f13885b.get(this.f13887d);
        Integer num = this.f13884a.get(preFillType);
        if (num.intValue() == 1) {
            this.f13884a.remove(preFillType);
            this.f13885b.remove(this.f13887d);
        } else {
            this.f13884a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f13886c--;
        this.f13887d = this.f13885b.isEmpty() ? 0 : (this.f13887d + 1) % this.f13885b.size();
        return preFillType;
    }
}
