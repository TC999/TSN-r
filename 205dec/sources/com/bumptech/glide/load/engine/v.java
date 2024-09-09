package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceCacheGenerator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class v implements f, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f17225a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f17226b;

    /* renamed from: c  reason: collision with root package name */
    private int f17227c;

    /* renamed from: d  reason: collision with root package name */
    private int f17228d = -1;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.c f17229e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.bumptech.glide.load.model.n<File, ?>> f17230f;

    /* renamed from: g  reason: collision with root package name */
    private int f17231g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f17232h;

    /* renamed from: i  reason: collision with root package name */
    private File f17233i;

    /* renamed from: j  reason: collision with root package name */
    private w f17234j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g<?> gVar, f.a aVar) {
        this.f17226b = gVar;
        this.f17225a = aVar;
    }

    private boolean a() {
        return this.f17231g < this.f17230f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        List<com.bumptech.glide.load.c> c4 = this.f17226b.c();
        boolean z3 = false;
        if (c4.isEmpty()) {
            return false;
        }
        List<Class<?>> m4 = this.f17226b.m();
        if (m4.isEmpty()) {
            if (File.class.equals(this.f17226b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f17226b.i() + " to " + this.f17226b.q());
        }
        while (true) {
            if (this.f17230f != null && a()) {
                this.f17232h = null;
                while (!z3 && a()) {
                    List<com.bumptech.glide.load.model.n<File, ?>> list = this.f17230f;
                    int i4 = this.f17231g;
                    this.f17231g = i4 + 1;
                    this.f17232h = list.get(i4).b(this.f17233i, this.f17226b.s(), this.f17226b.f(), this.f17226b.k());
                    if (this.f17232h != null && this.f17226b.t(this.f17232h.f17318c.a())) {
                        this.f17232h.f17318c.d(this.f17226b.l(), this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.f17228d + 1;
            this.f17228d = i5;
            if (i5 >= m4.size()) {
                int i6 = this.f17227c + 1;
                this.f17227c = i6;
                if (i6 >= c4.size()) {
                    return false;
                }
                this.f17228d = 0;
            }
            com.bumptech.glide.load.c cVar = c4.get(this.f17227c);
            Class<?> cls = m4.get(this.f17228d);
            this.f17234j = new w(this.f17226b.b(), cVar, this.f17226b.o(), this.f17226b.s(), this.f17226b.f(), this.f17226b.r(cls), cls, this.f17226b.k());
            File b4 = this.f17226b.d().b(this.f17234j);
            this.f17233i = b4;
            if (b4 != null) {
                this.f17229e = cVar;
                this.f17230f = this.f17226b.j(b4);
                this.f17231g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f17225a.a(this.f17234j, exc, this.f17232h.f17318c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f17232h;
        if (aVar != null) {
            aVar.f17318c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(Object obj) {
        this.f17225a.f(this.f17229e, obj, this.f17232h.f17318c, DataSource.RESOURCE_DISK_CACHE, this.f17234j);
    }
}
