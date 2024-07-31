package com.bumptech.glide.load.resource;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: c */
    private static final Transformation<?> f14057c = new UnitTransformation();

    private UnitTransformation() {
    }

    @NonNull
    /* renamed from: c */
    public static <T> UnitTransformation<T> m44998c() {
        return (UnitTransformation) f14057c;
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<T> mo44823a(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
    }
}
