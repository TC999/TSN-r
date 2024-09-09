package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifDrawableBytesTranscoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d implements e<GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<byte[]> a(@NonNull u<GifDrawable> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.b(com.bumptech.glide.util.a.d(uVar.get().c()));
    }
}
