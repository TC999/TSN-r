package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* renamed from: com.bumptech.glide.load.resource.gif.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo44824a() {
        ((GifDrawable) this.f14183a).m44856e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<GifDrawable> mo2883b() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((GifDrawable) this.f14183a).m44851j();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable) this.f14183a).stop();
        ((GifDrawable) this.f14183a).m44848m();
    }
}
