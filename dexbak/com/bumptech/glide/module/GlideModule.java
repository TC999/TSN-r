package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

@Deprecated
/* renamed from: com.bumptech.glide.module.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface GlideModule extends RegistersComponents, AppliesOptions {
    @Override // com.bumptech.glide.module.AppliesOptions
    /* renamed from: a */
    /* synthetic */ void mo44710a(@NonNull Context context, @NonNull GlideBuilder glideBuilder);

    @Override // com.bumptech.glide.module.RegistersComponents
    /* renamed from: b */
    /* synthetic */ void mo44706b(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry);
}
