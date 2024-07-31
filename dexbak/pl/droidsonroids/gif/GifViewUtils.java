package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: pl.droidsonroids.gif.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class GifViewUtils {

    /* renamed from: a */
    static final String f44444a = "http://schemas.android.com/apk/res/android";

    /* renamed from: b */
    static final List<String> f44445b = Arrays.asList("raw", "drawable", "mipmap");

    private GifViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2376a(int i, Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).m2452F(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static float m2375b(@NonNull Resources resources, @DrawableRes @RawRes int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static C15446a m2374c(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            C15446a c15446a = new C15446a(imageView, attributeSet, i, i2);
            int i3 = c15446a.f44449b;
            if (i3 >= 0) {
                m2376a(i3, imageView.getDrawable());
                m2376a(i3, imageView.getBackground());
            }
            return c15446a;
        }
        return new C15446a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m2373d(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static boolean m2372e(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (f44445b.contains(resources.getResourceTypeName(i))) {
                    GifDrawable gifDrawable = new GifDrawable(resources, i);
                    if (z) {
                        imageView.setImageDrawable(gifDrawable);
                        return true;
                    }
                    imageView.setBackground(gifDrawable);
                    return true;
                }
                return false;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* compiled from: GifViewUtils.java */
    /* renamed from: pl.droidsonroids.gif.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C15446a extends C15447b {

        /* renamed from: c */
        final int f44446c;

        /* renamed from: d */
        final int f44447d;

        C15446a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.f44446c = m2371a(imageView, attributeSet, true);
            this.f44447d = m2371a(imageView, attributeSet, false);
        }

        /* renamed from: a */
        private static int m2371a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(GifViewUtils.f44444a, z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (GifViewUtils.f44445b.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !GifViewUtils.m2372e(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        C15446a() {
            this.f44446c = 0;
            this.f44447d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifViewUtils.java */
    /* renamed from: pl.droidsonroids.gif.k$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15447b {

        /* renamed from: a */
        boolean f44448a;

        /* renamed from: b */
        final int f44449b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C15447b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, C15438R.styleable.GifView, i, i2);
            this.f44448a = obtainStyledAttributes.getBoolean(C15438R.styleable.GifView_freezesAnimation, false);
            this.f44449b = obtainStyledAttributes.getInt(C15438R.styleable.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C15447b() {
            this.f44448a = false;
            this.f44449b = -1;
        }
    }
}
