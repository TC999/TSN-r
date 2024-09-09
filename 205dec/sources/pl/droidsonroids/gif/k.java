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
/* compiled from: GifViewUtils.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    static final String f61857a = "http://schemas.android.com/apk/res/android";

    /* renamed from: b  reason: collision with root package name */
    static final List<String> f61858b = Arrays.asList("raw", "drawable", "mipmap");

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4, Drawable drawable) {
        if (drawable instanceof e) {
            ((e) drawable).F(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(@NonNull Resources resources, @DrawableRes @RawRes int i4) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i4, typedValue, true);
        int i5 = typedValue.density;
        if (i5 == 0) {
            i5 = 160;
        } else if (i5 == 65535) {
            i5 = 0;
        }
        int i6 = resources.getDisplayMetrics().densityDpi;
        if (i5 <= 0 || i6 <= 0) {
            return 1.0f;
        }
        return i6 / i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(ImageView imageView, AttributeSet attributeSet, int i4, int i5) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            a aVar = new a(imageView, attributeSet, i4, i5);
            int i6 = aVar.f61862b;
            if (i6 >= 0) {
                a(i6, imageView.getDrawable());
                a(i6, imageView.getBackground());
            }
            return aVar;
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new e(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(ImageView imageView, boolean z3, int i4) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (f61858b.contains(resources.getResourceTypeName(i4))) {
                    e eVar = new e(resources, i4);
                    if (z3) {
                        imageView.setImageDrawable(eVar);
                        return true;
                    }
                    imageView.setBackground(eVar);
                    return true;
                }
                return false;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    /* compiled from: GifViewUtils.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a extends b {

        /* renamed from: c  reason: collision with root package name */
        final int f61859c;

        /* renamed from: d  reason: collision with root package name */
        final int f61860d;

        a(ImageView imageView, AttributeSet attributeSet, int i4, int i5) {
            super(imageView, attributeSet, i4, i5);
            this.f61859c = a(imageView, attributeSet, true);
            this.f61860d = a(imageView, attributeSet, false);
        }

        private static int a(ImageView imageView, AttributeSet attributeSet, boolean z3) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(k.f61857a, z3 ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (k.f61858b.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !k.e(imageView, z3, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        a() {
            this.f61859c = 0;
            this.f61860d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifViewUtils.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f61861a;

        /* renamed from: b  reason: collision with root package name */
        final int f61862b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(View view, AttributeSet attributeSet, int i4, int i5) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i4, i5);
            this.f61861a = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
            this.f61862b = obtainStyledAttributes.getInt(R.styleable.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            this.f61861a = false;
            this.f61862b = -1;
        }
    }
}
