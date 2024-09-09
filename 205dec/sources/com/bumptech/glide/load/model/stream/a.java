package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.g;
import com.bumptech.glide.load.model.h;
import com.bumptech.glide.load.model.m;
import com.bumptech.glide.load.model.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseGlideUrlLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class a<Model> implements n<Model, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f17348a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m<Model, g> f17349b;

    protected a(n<g, InputStream> nVar) {
        this(nVar, null);
    }

    private static List<com.bumptech.glide.load.c> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection) {
            arrayList.add(new g(str));
        }
        return arrayList;
    }

    @Override // com.bumptech.glide.load.model.n
    @Nullable
    public n.a<InputStream> b(@NonNull Model model, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        m<Model, g> mVar = this.f17349b;
        g b4 = mVar != null ? mVar.b(model, i4, i5) : null;
        if (b4 == null) {
            String f4 = f(model, i4, i5, fVar);
            if (TextUtils.isEmpty(f4)) {
                return null;
            }
            g gVar = new g(f4, e(model, i4, i5, fVar));
            m<Model, g> mVar2 = this.f17349b;
            if (mVar2 != null) {
                mVar2.c(model, i4, i5, gVar);
            }
            b4 = gVar;
        }
        List<String> d4 = d(model, i4, i5, fVar);
        n.a<InputStream> b5 = this.f17348a.b(b4, i4, i5, fVar);
        return (b5 == null || d4.isEmpty()) ? b5 : new n.a<>(b5.f17316a, c(d4), b5.f17318c);
    }

    protected List<String> d(Model model, int i4, int i5, com.bumptech.glide.load.f fVar) {
        return Collections.emptyList();
    }

    @Nullable
    protected h e(Model model, int i4, int i5, com.bumptech.glide.load.f fVar) {
        return h.f17294b;
    }

    protected abstract String f(Model model, int i4, int i5, com.bumptech.glide.load.f fVar);

    protected a(n<g, InputStream> nVar, @Nullable m<Model, g> mVar) {
        this.f17348a = nVar;
        this.f17349b = mVar;
    }
}
