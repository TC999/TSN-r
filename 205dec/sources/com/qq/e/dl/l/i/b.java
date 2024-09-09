package com.qq.e.dl.l.i;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final a f47100a = new a();

    /* renamed from: b  reason: collision with root package name */
    private List<d> f47101b;

    public boolean a(Object[] objArr) {
        return this.f47100a.a(objArr);
    }

    public boolean b(int[] iArr) {
        return this.f47100a.b(iArr);
    }

    public boolean c(int i4) {
        return this.f47100a.c(i4);
    }

    public boolean a(int i4) {
        return this.f47100a.a(i4);
    }

    public boolean b(int i4) {
        return this.f47100a.b(i4);
    }

    public boolean a(int[] iArr) {
        return this.f47100a.a(iArr);
    }

    @Override // com.qq.e.dl.l.i.d
    public void b(Canvas canvas, int i4, int i5) {
        this.f47100a.b(canvas, i4, i5);
        List<d> list = this.f47101b;
        if (list != null) {
            for (d dVar : list) {
                dVar.b(canvas, i4, i5);
            }
        }
    }

    @Override // com.qq.e.dl.l.i.d
    public void a(Canvas canvas, int i4, int i5) {
        List<d> list = this.f47101b;
        if (list != null) {
            for (d dVar : list) {
                dVar.a(canvas, i4, i5);
            }
        }
        this.f47100a.a(canvas, i4, i5);
    }

    public boolean a() {
        return this.f47100a.a() || this.f47101b != null;
    }

    public void a(d dVar) {
        if (this.f47101b == null) {
            this.f47101b = new ArrayList(2);
        }
        this.f47101b.add(dVar);
    }
}
