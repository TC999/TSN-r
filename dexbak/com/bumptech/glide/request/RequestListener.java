package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* renamed from: com.bumptech.glide.request.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface RequestListener<R> {
    /* renamed from: a */
    boolean mo44585a(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z);

    /* renamed from: c */
    boolean mo44584c(R r, Object obj, Target<R> target, DataSource dataSource, boolean z);
}
