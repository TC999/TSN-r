package com.qq.e.dl.h;

import com.qq.e.dl.l.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements h.g, c {

    /* renamed from: a  reason: collision with root package name */
    private final h f46904a;

    /* renamed from: b  reason: collision with root package name */
    private final h.f f46905b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, a> f46906c = new HashMap(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar, h.f fVar) {
        this.f46904a = hVar;
        this.f46905b = fVar;
        hVar.a(this);
    }

    @Override // com.qq.e.dl.h.c
    public void a(a aVar) {
        this.f46906c.put(Integer.valueOf(aVar.f46894a - 1), aVar);
    }

    @Override // com.qq.e.dl.l.h.g
    public void a(h hVar, int i4, int i5) {
        a aVar;
        if (this.f46906c.size() <= 0 || (aVar = this.f46906c.get(Integer.valueOf(i5))) == null) {
            return;
        }
        aVar.a("lastStateType", Integer.valueOf(i4 + 1));
        this.f46905b.a(this.f46904a, aVar);
    }
}
