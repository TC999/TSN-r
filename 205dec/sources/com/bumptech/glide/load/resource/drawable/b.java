package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class b<T extends Drawable> implements u<T>, q {

    /* renamed from: a  reason: collision with root package name */
    protected final T f17500a;

    public b(T t3) {
        this.f17500a = (T) j.d(t3);
    }

    public void a() {
        T t3 = this.f17500a;
        if (t3 instanceof BitmapDrawable) {
            ((BitmapDrawable) t3).getBitmap().prepareToDraw();
        } else if (t3 instanceof GifDrawable) {
            ((GifDrawable) t3).e().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: c */
    public final T get() {
        Drawable.ConstantState constantState = this.f17500a.getConstantState();
        if (constantState == null) {
            return this.f17500a;
        }
        return (T) constantState.newDrawable();
    }
}
