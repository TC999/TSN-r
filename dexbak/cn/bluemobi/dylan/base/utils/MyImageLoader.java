package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: cn.bluemobi.dylan.base.utils.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MyImageLoader {
    /* renamed from: a */
    public static void m57724a(Context context, String str, ImageView imageView) {
        Glide.m45751C(context).mo45507a(str).m45551i1(imageView);
    }

    /* renamed from: b */
    public static void m57723b(Context context, String str, ImageView imageView, @DrawableRes int i, @DrawableRes int i2) {
        Glide.m45751C(context).mo45507a(str).m44601w0(i).m44600x(i2).m45551i1(imageView);
    }

    /* renamed from: c */
    public static void m57722c(Context context, String str, ImageView imageView, int i) {
        Glide.m45751C(context).mo45507a(str).mo44636b(RequestOptions.m44583S0(new RoundedCorners(6)).m44612r(DiskCacheStrategy.f13787b).m44668G0(true)).m45551i1(imageView);
    }

    /* renamed from: d */
    public static void m57721d(Context context, String str, ImageView imageView, @DrawableRes int i, @DrawableRes int i2, int i3) {
        Glide.m45751C(context).mo45507a(str).mo44636b(RequestOptions.m44583S0(new RoundedCorners(6)).m44601w0(i).m44600x(i2).m44612r(DiskCacheStrategy.f13787b).m44668G0(true)).m45551i1(imageView);
    }

    /* renamed from: e */
    public static void m57720e(Context context, String str, ImageView imageView) {
        Glide.m45751C(context).mo45507a(str).mo44636b(RequestOptions.m44580V0().m44612r(DiskCacheStrategy.f13787b).m44668G0(true)).m45551i1(imageView);
    }

    /* renamed from: f */
    public static void m57719f(Context context, String str, ImageView imageView, @DrawableRes int i, @DrawableRes int i2) {
        Glide.m45751C(context).mo45507a(str).mo44636b(RequestOptions.m44580V0().m44601w0(i).m44600x(i2).m44612r(DiskCacheStrategy.f13787b).m44668G0(true)).m45551i1(imageView);
    }
}
