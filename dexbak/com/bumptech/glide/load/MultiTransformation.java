package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.bumptech.glide.load.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MultiTransformation<T> implements Transformation<T> {

    /* renamed from: c */
    private final Collection<? extends Transformation<T>> f13471c;

    @SafeVarargs
    public MultiTransformation(@NonNull Transformation<T>... transformationArr) {
        if (transformationArr.length != 0) {
            this.f13471c = Arrays.asList(transformationArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<T> mo44823a(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation<T> transformation : this.f13471c) {
            Resource<T> mo44823a = transformation.mo44823a(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(mo44823a)) {
                resource2.recycle();
            }
            resource2 = mo44823a;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        for (Transformation<T> transformation : this.f13471c) {
            transformation.mo44432b(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.f13471c.equals(((MultiTransformation) obj).f13471c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f13471c.hashCode();
    }

    public MultiTransformation(@NonNull Collection<? extends Transformation<T>> collection) {
        if (!collection.isEmpty()) {
            this.f13471c = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
