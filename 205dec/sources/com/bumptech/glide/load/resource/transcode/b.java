package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.util.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f17569a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<BitmapDrawable> a(@NonNull u<Bitmap> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        return t.d(this.f17569a, uVar);
    }

    @Deprecated
    public b(@NonNull Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(resources);
    }

    public b(@NonNull Resources resources) {
        this.f17569a = (Resources) j.d(resources);
    }
}
