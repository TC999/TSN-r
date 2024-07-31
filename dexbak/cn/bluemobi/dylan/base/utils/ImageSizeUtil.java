package cn.bluemobi.dylan.base.utils;

import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* renamed from: cn.bluemobi.dylan.base.utils.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ImageSizeUtil {

    /* compiled from: ImageSizeUtil.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.i$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1139a {

        /* renamed from: a */
        public int f1809a;

        /* renamed from: b */
        public int f1810b;
    }

    /* renamed from: a */
    public static int m57740a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i || i4 > i2) {
            return Math.max(Math.round((i3 * 1.0f) / i), Math.round((i4 * 1.0f) / i2));
        }
        return 1;
    }

    /* renamed from: b */
    private static int m57739b(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(obj);
            if (i <= 0 || i >= Integer.MAX_VALUE) {
                return 0;
            }
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public static C1139a m57738c(ImageView imageView) {
        C1139a c1139a = new C1139a();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0 && layoutParams != null) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = m57739b(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0 && layoutParams != null) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = m57739b(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        c1139a.f1809a = width;
        c1139a.f1810b = height;
        return c1139a;
    }
}
