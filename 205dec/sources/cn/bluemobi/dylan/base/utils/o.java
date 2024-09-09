package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.load.resource.bitmap.x;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MyImageLoader.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o {
    public static void a(Context context, String str, ImageView imageView) {
        com.bumptech.glide.d.C(context).a(str).j1(imageView);
    }

    public static void b(Context context, String str, ImageView imageView, @DrawableRes int i4, @DrawableRes int i5) {
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.d.C(context).a(str).x0(i4)).y(i5)).j1(imageView);
    }

    public static void c(Context context, String str, ImageView imageView, int i4) {
        com.bumptech.glide.d.C(context).a(str).U0((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.T0(new x(6)).s(com.bumptech.glide.load.engine.j.f17104b)).H0(true)).j1(imageView);
    }

    public static void d(Context context, String str, ImageView imageView, @DrawableRes int i4, @DrawableRes int i5, int i6) {
        com.bumptech.glide.d.C(context).a(str).U0((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.T0(new x(6)).x0(i4)).y(i5)).s(com.bumptech.glide.load.engine.j.f17104b)).H0(true)).j1(imageView);
    }

    public static void e(Context context, String str, ImageView imageView) {
        com.bumptech.glide.d.C(context).a(str).U0((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.W0().s(com.bumptech.glide.load.engine.j.f17104b)).H0(true)).j1(imageView);
    }

    public static void f(Context context, String str, ImageView imageView, @DrawableRes int i4, @DrawableRes int i5) {
        com.bumptech.glide.d.C(context).a(str).U0((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) ((com.bumptech.glide.request.h) com.bumptech.glide.request.h.W0().x0(i4)).y(i5)).s(com.bumptech.glide.load.engine.j.f17104b)).H0(true)).j1(imageView);
    }
}
