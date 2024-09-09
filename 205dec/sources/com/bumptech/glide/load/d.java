package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MultiTransformation.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d<T> implements i<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Collection<? extends i<T>> f16794c;

    @SafeVarargs
    public d(@NonNull i<T>... iVarArr) {
        if (iVarArr.length != 0) {
            this.f16794c = Arrays.asList(iVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i4, int i5) {
        u<T> uVar2 = uVar;
        for (i<T> iVar : this.f16794c) {
            u<T> a4 = iVar.a(context, uVar2, i4, i5);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(a4)) {
                uVar2.recycle();
            }
            uVar2 = a4;
        }
        return uVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        for (i<T> iVar : this.f16794c) {
            iVar.b(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f16794c.equals(((d) obj).f16794c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f16794c.hashCode();
    }

    public d(@NonNull Collection<? extends i<T>> collection) {
        if (!collection.isEmpty()) {
            this.f16794c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
