package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ResourceDecoder<T, Z> {
    /* renamed from: a */
    boolean mo2814a(@NonNull T t, @NonNull Options options) throws IOException;

    @Nullable
    /* renamed from: b */
    Resource<Z> mo2813b(@NonNull T t, int i, int i2, @NonNull Options options) throws IOException;
}
