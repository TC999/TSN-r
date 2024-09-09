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
/* compiled from: DataCacheGenerator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements f, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f16937a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f16938b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f16939c;

    /* renamed from: d  reason: collision with root package name */
    private int f16940d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.c f16941e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.bumptech.glide.load.model.n<File, ?>> f16942f;

    /* renamed from: g  reason: collision with root package name */
    private int f16943g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f16944h;

    /* renamed from: i  reason: collision with root package name */
    private File f16945i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.f16943g < this.f16942f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        while (true) {
            boolean z3 = false;
            if (this.f16942f != null && a()) {
                this.f16944h = null;
                while (!z3 && a()) {
                    List<com.bumptech.glide.load.model.n<File, ?>> list = this.f16942f;
                    int i4 = this.f16943g;
                    this.f16943g = i4 + 1;
                    this.f16944h = list.get(i4).b(this.f16945i, this.f16938b.s(), this.f16938b.f(), this.f16938b.k());
                    if (this.f16944h != null && this.f16938b.t(this.f16944h.f17318c.a())) {
                        this.f16944h.f17318c.d(this.f16938b.l(), this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.f16940d + 1;
            this.f16940d = i5;
            if (i5 >= this.f16937a.size()) {
                return false;
            }
            com.bumptech.glide.load.c cVar = this.f16937a.get(this.f16940d);
            File b4 = this.f16938b.d().b(new d(cVar, this.f16938b.o()));
            this.f16945i = b4;
            if (b4 != null) {
                this.f16941e = cVar;
                this.f16942f = this.f16938b.j(b4);
                this.f16943g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f16939c.a(this.f16941e, exc, this.f16944h.f17318c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f16944h;
        if (aVar != null) {
            aVar.f17318c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void e(Object obj) {
        this.f16939c.f(this.f16941e, obj, this.f16944h.f17318c, DataSource.DATA_DISK_CACHE, this.f16941e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<com.bumptech.glide.load.c> list, g<?> gVar, f.a aVar) {
        this.f16940d = -1;
        this.f16937a = list;
        this.f16938b = gVar;
        this.f16939c = aVar;
    }
}
