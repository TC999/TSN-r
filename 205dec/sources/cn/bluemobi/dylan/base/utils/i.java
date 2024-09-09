package cn.bluemobi.dylan.base.utils;

import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ImageSizeUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ImageSizeUtil.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1795a;

        /* renamed from: b  reason: collision with root package name */
        public int f1796b;
    }

    public static int a(BitmapFactory.Options options, int i4, int i5) {
        int i6 = options.outWidth;
        int i7 = options.outHeight;
        if (i6 > i4 || i7 > i5) {
            return Math.max(Math.round((i6 * 1.0f) / i4), Math.round((i7 * 1.0f) / i5));
        }
        return 1;
    }

    private static int b(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i4 = declaredField.getInt(obj);
            if (i4 <= 0 || i4 >= Integer.MAX_VALUE) {
                return 0;
            }
            return i4;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static a c(ImageView imageView) {
        a aVar = new a();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0 && layoutParams != null) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = b(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0 && layoutParams != null) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = b(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        aVar.f1795a = width;
        aVar.f1796b = height;
        return aVar;
    }
}
