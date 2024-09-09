package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestListener.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface g<R> {
    boolean a(@Nullable GlideException glideException, Object obj, p<R> pVar, boolean z3);

    boolean c(R r3, Object obj, p<R> pVar, DataSource dataSource, boolean z3);
}
