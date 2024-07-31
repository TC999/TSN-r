package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.load.resource.drawable.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: a */
    protected final T f14183a;

    public DrawableResource(T t) {
        this.f14183a = (T) C3770j.m44392d(t);
    }

    /* renamed from: a */
    public void mo44824a() {
        T t = this.f14183a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).m44856e().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public final T get() {
        Drawable.ConstantState constantState = this.f14183a.getConstantState();
        if (constantState == null) {
            return this.f14183a;
        }
        return (T) constantState.newDrawable();
    }
}
