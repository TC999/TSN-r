package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifDrawableResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d extends com.bumptech.glide.load.resource.drawable.b<GifDrawable> implements q {
    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.resource.drawable.b, com.bumptech.glide.load.engine.q
    public void a() {
        ((GifDrawable) this.f17500a).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<GifDrawable> b() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return ((GifDrawable) this.f17500a).j();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        ((GifDrawable) this.f17500a).stop();
        ((GifDrawable) this.f17500a).m();
    }
}
