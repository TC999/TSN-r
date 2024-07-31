package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.yalantis.ucrop.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UCrop {

    /* renamed from: c */
    public static final int f39779c = 69;

    /* renamed from: d */
    public static final int f39780d = 96;

    /* renamed from: e */
    public static final int f39781e = 10;

    /* renamed from: f */
    private static final String f39782f = "com.yalantis.ucrop";

    /* renamed from: g */
    public static final String f39783g = "com.yalantis.ucrop.InputUri";

    /* renamed from: h */
    public static final String f39784h = "com.yalantis.ucrop.OutputUri";

    /* renamed from: i */
    public static final String f39785i = "com.yalantis.ucrop.CropAspectRatio";

    /* renamed from: j */
    public static final String f39786j = "com.yalantis.ucrop.ImageWidth";

    /* renamed from: k */
    public static final String f39787k = "com.yalantis.ucrop.ImageHeight";

    /* renamed from: l */
    public static final String f39788l = "com.yalantis.ucrop.OffsetX";

    /* renamed from: m */
    public static final String f39789m = "com.yalantis.ucrop.OffsetY";

    /* renamed from: n */
    public static final String f39790n = "com.yalantis.ucrop.Error";

    /* renamed from: o */
    public static final String f39791o = "com.yalantis.ucrop.AspectRatioX";

    /* renamed from: p */
    public static final String f39792p = "com.yalantis.ucrop.AspectRatioY";

    /* renamed from: q */
    public static final String f39793q = "com.yalantis.ucrop.MaxSizeX";

    /* renamed from: r */
    public static final String f39794r = "com.yalantis.ucrop.MaxSizeY";

    /* renamed from: a */
    private Intent f39795a = new Intent();

    /* renamed from: b */
    private Bundle f39796b;

    /* compiled from: UCrop.java */
    /* renamed from: com.yalantis.ucrop.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13523a {

        /* renamed from: A */
        public static final String f39797A = "com.yalantis.ucrop.HideBottomControls";

        /* renamed from: B */
        public static final String f39798B = "com.yalantis.ucrop.FreeStyleCrop";

        /* renamed from: C */
        public static final String f39799C = "com.yalantis.ucrop.AspectRatioSelectedByDefault";

        /* renamed from: D */
        public static final String f39800D = "com.yalantis.ucrop.AspectRatioOptions";

        /* renamed from: E */
        public static final String f39801E = "com.yalantis.ucrop.UcropRootViewBackgroundColor";

        /* renamed from: b */
        public static final String f39802b = "com.yalantis.ucrop.CompressionFormatName";

        /* renamed from: c */
        public static final String f39803c = "com.yalantis.ucrop.CompressionQuality";

        /* renamed from: d */
        public static final String f39804d = "com.yalantis.ucrop.AllowedGestures";

        /* renamed from: e */
        public static final String f39805e = "com.yalantis.ucrop.MaxBitmapSize";

        /* renamed from: f */
        public static final String f39806f = "com.yalantis.ucrop.MaxScaleMultiplier";

        /* renamed from: g */
        public static final String f39807g = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";

        /* renamed from: h */
        public static final String f39808h = "com.yalantis.ucrop.DimmedLayerColor";

        /* renamed from: i */
        public static final String f39809i = "com.yalantis.ucrop.CircleDimmedLayer";

        /* renamed from: j */
        public static final String f39810j = "com.yalantis.ucrop.ShowCropFrame";

        /* renamed from: k */
        public static final String f39811k = "com.yalantis.ucrop.CropFrameColor";

        /* renamed from: l */
        public static final String f39812l = "com.yalantis.ucrop.CropFrameStrokeWidth";

        /* renamed from: m */
        public static final String f39813m = "com.yalantis.ucrop.ShowCropGrid";

        /* renamed from: n */
        public static final String f39814n = "com.yalantis.ucrop.CropGridRowCount";

        /* renamed from: o */
        public static final String f39815o = "com.yalantis.ucrop.CropGridColumnCount";

        /* renamed from: p */
        public static final String f39816p = "com.yalantis.ucrop.CropGridColor";

        /* renamed from: q */
        public static final String f39817q = "com.yalantis.ucrop.CropGridStrokeWidth";

        /* renamed from: r */
        public static final String f39818r = "com.yalantis.ucrop.ToolbarColor";

        /* renamed from: s */
        public static final String f39819s = "com.yalantis.ucrop.StatusBarColor";

        /* renamed from: t */
        public static final String f39820t = "com.yalantis.ucrop.UcropColorWidgetActive";

        /* renamed from: u */
        public static final String f39821u = "com.yalantis.ucrop.UcropColorControlsWidgetActive";

        /* renamed from: v */
        public static final String f39822v = "com.yalantis.ucrop.UcropToolbarWidgetColor";

        /* renamed from: w */
        public static final String f39823w = "com.yalantis.ucrop.UcropToolbarTitleText";

        /* renamed from: x */
        public static final String f39824x = "com.yalantis.ucrop.UcropToolbarCancelDrawable";

        /* renamed from: y */
        public static final String f39825y = "com.yalantis.ucrop.UcropToolbarCropDrawable";

        /* renamed from: z */
        public static final String f39826z = "com.yalantis.ucrop.UcropLogoColor";

        /* renamed from: a */
        private final Bundle f39827a = new Bundle();

        /* renamed from: A */
        public void m13087A(@ColorInt int i) {
            this.f39827a.putInt(f39818r, i);
        }

        /* renamed from: B */
        public void m13086B(@DrawableRes int i) {
            this.f39827a.putInt(f39825y, i);
        }

        /* renamed from: C */
        public void m13085C(@Nullable String str) {
            this.f39827a.putString(f39823w, str);
        }

        /* renamed from: D */
        public void m13084D(@ColorInt int i) {
            this.f39827a.putInt(f39822v, i);
        }

        /* renamed from: E */
        public void m13083E() {
            this.f39827a.putFloat(UCrop.f39791o, 0.0f);
            this.f39827a.putFloat(UCrop.f39792p, 0.0f);
        }

        /* renamed from: F */
        public void m13082F(float f, float f2) {
            this.f39827a.putFloat(UCrop.f39791o, f);
            this.f39827a.putFloat(UCrop.f39792p, f2);
        }

        /* renamed from: G */
        public void m13081G(@IntRange(from = 10) int i, @IntRange(from = 10) int i2) {
            this.f39827a.putInt(UCrop.f39793q, i);
            this.f39827a.putInt(UCrop.f39794r, i2);
        }

        @NonNull
        /* renamed from: a */
        public Bundle m13080a() {
            return this.f39827a;
        }

        /* renamed from: b */
        public void m13079b(@ColorInt int i) {
            this.f39827a.putInt(f39821u, i);
        }

        /* renamed from: c */
        public void m13078c(@ColorInt int i) {
            this.f39827a.putInt(f39820t, i);
        }

        /* renamed from: d */
        public void m13077d(int i, int i2, int i3) {
            this.f39827a.putIntArray(f39804d, new int[]{i, i2, i3});
        }

        /* renamed from: e */
        public void m13076e(int i, AspectRatio... aspectRatioArr) {
            if (i <= aspectRatioArr.length) {
                this.f39827a.putInt(f39799C, i);
                this.f39827a.putParcelableArrayList(f39800D, new ArrayList<>(Arrays.asList(aspectRatioArr)));
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i), Integer.valueOf(aspectRatioArr.length)));
        }

        /* renamed from: f */
        public void m13075f(boolean z) {
            this.f39827a.putBoolean(f39809i, z);
        }

        /* renamed from: g */
        public void m13074g(@NonNull Bitmap.CompressFormat compressFormat) {
            this.f39827a.putString(f39802b, compressFormat.name());
        }

        /* renamed from: h */
        public void m13073h(@IntRange(from = 0) int i) {
            this.f39827a.putInt(f39803c, i);
        }

        /* renamed from: i */
        public void m13072i(@ColorInt int i) {
            this.f39827a.putInt(f39811k, i);
        }

        /* renamed from: j */
        public void m13071j(@IntRange(from = 0) int i) {
            this.f39827a.putInt(f39812l, i);
        }

        /* renamed from: k */
        public void m13070k(@ColorInt int i) {
            this.f39827a.putInt(f39816p, i);
        }

        /* renamed from: l */
        public void m13069l(@IntRange(from = 0) int i) {
            this.f39827a.putInt(f39815o, i);
        }

        /* renamed from: m */
        public void m13068m(@IntRange(from = 0) int i) {
            this.f39827a.putInt(f39814n, i);
        }

        /* renamed from: n */
        public void m13067n(@IntRange(from = 0) int i) {
            this.f39827a.putInt(f39817q, i);
        }

        /* renamed from: o */
        public void m13066o(@ColorInt int i) {
            this.f39827a.putInt(f39808h, i);
        }

        /* renamed from: p */
        public void m13065p(boolean z) {
            this.f39827a.putBoolean(f39798B, z);
        }

        /* renamed from: q */
        public void m13064q(boolean z) {
            this.f39827a.putBoolean(f39797A, z);
        }

        /* renamed from: r */
        public void m13063r(@IntRange(from = 10) int i) {
            this.f39827a.putInt(f39807g, i);
        }

        /* renamed from: s */
        public void m13062s(@ColorInt int i) {
            this.f39827a.putInt(f39826z, i);
        }

        /* renamed from: t */
        public void m13061t(@IntRange(from = 10) int i) {
            this.f39827a.putInt(f39805e, i);
        }

        /* renamed from: u */
        public void m13060u(@FloatRange(from = 1.0d, fromInclusive = false) float f) {
            this.f39827a.putFloat(f39806f, f);
        }

        /* renamed from: v */
        public void m13059v(@ColorInt int i) {
            this.f39827a.putInt(f39801E, i);
        }

        /* renamed from: w */
        public void m13058w(boolean z) {
            this.f39827a.putBoolean(f39810j, z);
        }

        /* renamed from: x */
        public void m13057x(boolean z) {
            this.f39827a.putBoolean(f39813m, z);
        }

        /* renamed from: y */
        public void m13056y(@ColorInt int i) {
            this.f39827a.putInt(f39819s, i);
        }

        /* renamed from: z */
        public void m13055z(@DrawableRes int i) {
            this.f39827a.putInt(f39824x, i);
        }
    }

    private UCrop(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f39796b = bundle;
        bundle.putParcelable(f39783g, uri);
        this.f39796b.putParcelable(f39784h, uri2);
    }

    @Nullable
    /* renamed from: a */
    public static Throwable m13106a(@NonNull Intent intent) {
        return (Throwable) intent.getSerializableExtra(f39790n);
    }

    @Nullable
    /* renamed from: e */
    public static Uri m13102e(@NonNull Intent intent) {
        return (Uri) intent.getParcelableExtra(f39784h);
    }

    /* renamed from: f */
    public static float m13101f(@NonNull Intent intent) {
        return intent.getFloatExtra(f39785i, 0.0f);
    }

    /* renamed from: g */
    public static int m13100g(@NonNull Intent intent) {
        return intent.getIntExtra(f39787k, -1);
    }

    /* renamed from: h */
    public static int m13099h(@NonNull Intent intent) {
        return intent.getIntExtra(f39786j, -1);
    }

    /* renamed from: i */
    public static UCrop m13098i(@NonNull Uri uri, @NonNull Uri uri2) {
        return new UCrop(uri, uri2);
    }

    /* renamed from: b */
    public UCropFragment m13105b() {
        return UCropFragment.m13136P(this.f39796b);
    }

    /* renamed from: c */
    public UCropFragment m13104c(Bundle bundle) {
        this.f39796b = bundle;
        return m13105b();
    }

    /* renamed from: d */
    public Intent m13103d(@NonNull Context context) {
        this.f39795a.setClass(context, UCropActivity.class);
        this.f39795a.putExtras(this.f39796b);
        return this.f39795a;
    }

    /* renamed from: j */
    public void m13097j(@NonNull Activity activity) {
        m13096k(activity, 69);
    }

    /* renamed from: k */
    public void m13096k(@NonNull Activity activity, int i) {
        activity.startActivityForResult(m13103d(activity), i);
    }

    /* renamed from: l */
    public void m13095l(@NonNull Context context, @NonNull Fragment fragment) {
        m13094m(context, fragment, 69);
    }

    @TargetApi(11)
    /* renamed from: m */
    public void m13094m(@NonNull Context context, @NonNull Fragment fragment, int i) {
        fragment.startActivityForResult(m13103d(context), i);
    }

    /* renamed from: n */
    public void m13093n(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment) {
        m13092o(context, fragment, 69);
    }

    /* renamed from: o */
    public void m13092o(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment, int i) {
        fragment.startActivityForResult(m13103d(context), i);
    }

    /* renamed from: p */
    public UCrop m13091p() {
        this.f39796b.putFloat(f39791o, 0.0f);
        this.f39796b.putFloat(f39792p, 0.0f);
        return this;
    }

    /* renamed from: q */
    public UCrop m13090q(float f, float f2) {
        this.f39796b.putFloat(f39791o, f);
        this.f39796b.putFloat(f39792p, f2);
        return this;
    }

    /* renamed from: r */
    public UCrop m13089r(@IntRange(from = 10) int i, @IntRange(from = 10) int i2) {
        if (i < 10) {
            i = 10;
        }
        if (i2 < 10) {
            i2 = 10;
        }
        this.f39796b.putInt(f39793q, i);
        this.f39796b.putInt(f39794r, i2);
        return this;
    }

    /* renamed from: s */
    public UCrop m13088s(@NonNull C13523a c13523a) {
        this.f39796b.putAll(c13523a.m13080a());
        return this;
    }
}
