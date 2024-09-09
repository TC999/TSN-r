package com.qq.e.dl.h;

import com.qq.e.dl.l.h;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final h f46901a;

    /* renamed from: b  reason: collision with root package name */
    private final h.f f46902b;

    /* renamed from: c  reason: collision with root package name */
    private c f46903c;

    public d(h hVar, h.f fVar) {
        this.f46901a = hVar;
        this.f46902b = fVar;
    }

    public void a(List<a> list) {
        for (a aVar : list) {
            int i4 = aVar.f46894a;
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                if (this.f46903c == null) {
                    this.f46903c = new e(this.f46901a, this.f46902b);
                }
                this.f46903c.a(aVar);
            }
        }
    }
}
