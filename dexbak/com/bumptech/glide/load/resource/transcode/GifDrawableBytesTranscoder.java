package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;
import p622n.BytesResource;

/* renamed from: com.bumptech.glide.load.resource.transcode.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<byte[]> mo44784a(@NonNull Resource<GifDrawable> resource, @NonNull Options options) {
        return new BytesResource(ByteBufferUtil.m44428d(resource.get().m44858c()));
    }
}
