package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.resource.transcode.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a */
    private static final UnitTranscoder<?> f14260a = new UnitTranscoder<>();

    /* renamed from: b */
    public static <Z> ResourceTranscoder<Z, Z> m44783b() {
        return f14260a;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<Z> mo44784a(@NonNull Resource<Z> resource, @NonNull Options options) {
        return resource;
    }
}
