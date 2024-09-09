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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UCrop.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int f54320c = 69;

    /* renamed from: d  reason: collision with root package name */
    public static final int f54321d = 96;

    /* renamed from: e  reason: collision with root package name */
    public static final int f54322e = 10;

    /* renamed from: f  reason: collision with root package name */
    private static final String f54323f = "com.yalantis.ucrop";

    /* renamed from: g  reason: collision with root package name */
    public static final String f54324g = "com.yalantis.ucrop.InputUri";

    /* renamed from: h  reason: collision with root package name */
    public static final String f54325h = "com.yalantis.ucrop.OutputUri";

    /* renamed from: i  reason: collision with root package name */
    public static final String f54326i = "com.yalantis.ucrop.CropAspectRatio";

    /* renamed from: j  reason: collision with root package name */
    public static final String f54327j = "com.yalantis.ucrop.ImageWidth";

    /* renamed from: k  reason: collision with root package name */
    public static final String f54328k = "com.yalantis.ucrop.ImageHeight";

    /* renamed from: l  reason: collision with root package name */
    public static final String f54329l = "com.yalantis.ucrop.OffsetX";

    /* renamed from: m  reason: collision with root package name */
    public static final String f54330m = "com.yalantis.ucrop.OffsetY";

    /* renamed from: n  reason: collision with root package name */
    public static final String f54331n = "com.yalantis.ucrop.Error";

    /* renamed from: o  reason: collision with root package name */
    public static final String f54332o = "com.yalantis.ucrop.AspectRatioX";

    /* renamed from: p  reason: collision with root package name */
    public static final String f54333p = "com.yalantis.ucrop.AspectRatioY";

    /* renamed from: q  reason: collision with root package name */
    public static final String f54334q = "com.yalantis.ucrop.MaxSizeX";

    /* renamed from: r  reason: collision with root package name */
    public static final String f54335r = "com.yalantis.ucrop.MaxSizeY";

    /* renamed from: a  reason: collision with root package name */
    private Intent f54336a = new Intent();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f54337b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UCrop.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {
        public static final String A = "com.yalantis.ucrop.HideBottomControls";
        public static final String B = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String C = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String D = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String E = "com.yalantis.ucrop.UcropRootViewBackgroundColor";

        /* renamed from: b  reason: collision with root package name */
        public static final String f54338b = "com.yalantis.ucrop.CompressionFormatName";

        /* renamed from: c  reason: collision with root package name */
        public static final String f54339c = "com.yalantis.ucrop.CompressionQuality";

        /* renamed from: d  reason: collision with root package name */
        public static final String f54340d = "com.yalantis.ucrop.AllowedGestures";

        /* renamed from: e  reason: collision with root package name */
        public static final String f54341e = "com.yalantis.ucrop.MaxBitmapSize";

        /* renamed from: f  reason: collision with root package name */
        public static final String f54342f = "com.yalantis.ucrop.MaxScaleMultiplier";

        /* renamed from: g  reason: collision with root package name */
        public static final String f54343g = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";

        /* renamed from: h  reason: collision with root package name */
        public static final String f54344h = "com.yalantis.ucrop.DimmedLayerColor";

        /* renamed from: i  reason: collision with root package name */
        public static final String f54345i = "com.yalantis.ucrop.CircleDimmedLayer";

        /* renamed from: j  reason: collision with root package name */
        public static final String f54346j = "com.yalantis.ucrop.ShowCropFrame";

        /* renamed from: k  reason: collision with root package name */
        public static final String f54347k = "com.yalantis.ucrop.CropFrameColor";

        /* renamed from: l  reason: collision with root package name */
        public static final String f54348l = "com.yalantis.ucrop.CropFrameStrokeWidth";

        /* renamed from: m  reason: collision with root package name */
        public static final String f54349m = "com.yalantis.ucrop.ShowCropGrid";

        /* renamed from: n  reason: collision with root package name */
        public static final String f54350n = "com.yalantis.ucrop.CropGridRowCount";

        /* renamed from: o  reason: collision with root package name */
        public static final String f54351o = "com.yalantis.ucrop.CropGridColumnCount";

        /* renamed from: p  reason: collision with root package name */
        public static final String f54352p = "com.yalantis.ucrop.CropGridColor";

        /* renamed from: q  reason: collision with root package name */
        public static final String f54353q = "com.yalantis.ucrop.CropGridStrokeWidth";

        /* renamed from: r  reason: collision with root package name */
        public static final String f54354r = "com.yalantis.ucrop.ToolbarColor";

        /* renamed from: s  reason: collision with root package name */
        public static final String f54355s = "com.yalantis.ucrop.StatusBarColor";

        /* renamed from: t  reason: collision with root package name */
        public static final String f54356t = "com.yalantis.ucrop.UcropColorWidgetActive";

        /* renamed from: u  reason: collision with root package name */
        public static final String f54357u = "com.yalantis.ucrop.UcropColorControlsWidgetActive";

        /* renamed from: v  reason: collision with root package name */
        public static final String f54358v = "com.yalantis.ucrop.UcropToolbarWidgetColor";

        /* renamed from: w  reason: collision with root package name */
        public static final String f54359w = "com.yalantis.ucrop.UcropToolbarTitleText";

        /* renamed from: x  reason: collision with root package name */
        public static final String f54360x = "com.yalantis.ucrop.UcropToolbarCancelDrawable";

        /* renamed from: y  reason: collision with root package name */
        public static final String f54361y = "com.yalantis.ucrop.UcropToolbarCropDrawable";

        /* renamed from: z  reason: collision with root package name */
        public static final String f54362z = "com.yalantis.ucrop.UcropLogoColor";

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f54363a = new Bundle();

        public void A(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.ToolbarColor", i4);
        }

        public void B(@DrawableRes int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropToolbarCropDrawable", i4);
        }

        public void C(@Nullable String str) {
            this.f54363a.putString("com.yalantis.ucrop.UcropToolbarTitleText", str);
        }

        public void D(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", i4);
        }

        public void E() {
            this.f54363a.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
            this.f54363a.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        }

        public void F(float f4, float f5) {
            this.f54363a.putFloat("com.yalantis.ucrop.AspectRatioX", f4);
            this.f54363a.putFloat("com.yalantis.ucrop.AspectRatioY", f5);
        }

        public void G(@IntRange(from = 10) int i4, @IntRange(from = 10) int i5) {
            this.f54363a.putInt("com.yalantis.ucrop.MaxSizeX", i4);
            this.f54363a.putInt("com.yalantis.ucrop.MaxSizeY", i5);
        }

        @NonNull
        public Bundle a() {
            return this.f54363a;
        }

        public void b(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", i4);
        }

        public void c(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropColorWidgetActive", i4);
        }

        public void d(int i4, int i5, int i6) {
            this.f54363a.putIntArray("com.yalantis.ucrop.AllowedGestures", new int[]{i4, i5, i6});
        }

        public void e(int i4, AspectRatio... aspectRatioArr) {
            if (i4 <= aspectRatioArr.length) {
                this.f54363a.putInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", i4);
                this.f54363a.putParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions", new ArrayList<>(Arrays.asList(aspectRatioArr)));
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i4), Integer.valueOf(aspectRatioArr.length)));
        }

        public void f(boolean z3) {
            this.f54363a.putBoolean("com.yalantis.ucrop.CircleDimmedLayer", z3);
        }

        public void g(@NonNull Bitmap.CompressFormat compressFormat) {
            this.f54363a.putString("com.yalantis.ucrop.CompressionFormatName", compressFormat.name());
        }

        public void h(@IntRange(from = 0) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CompressionQuality", i4);
        }

        public void i(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropFrameColor", i4);
        }

        public void j(@IntRange(from = 0) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropFrameStrokeWidth", i4);
        }

        public void k(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropGridColor", i4);
        }

        public void l(@IntRange(from = 0) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropGridColumnCount", i4);
        }

        public void m(@IntRange(from = 0) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropGridRowCount", i4);
        }

        public void n(@IntRange(from = 0) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.CropGridStrokeWidth", i4);
        }

        public void o(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.DimmedLayerColor", i4);
        }

        public void p(boolean z3) {
            this.f54363a.putBoolean("com.yalantis.ucrop.FreeStyleCrop", z3);
        }

        public void q(boolean z3) {
            this.f54363a.putBoolean("com.yalantis.ucrop.HideBottomControls", z3);
        }

        public void r(@IntRange(from = 10) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", i4);
        }

        public void s(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropLogoColor", i4);
        }

        public void t(@IntRange(from = 10) int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.MaxBitmapSize", i4);
        }

        public void u(@FloatRange(from = 1.0d, fromInclusive = false) float f4) {
            this.f54363a.putFloat("com.yalantis.ucrop.MaxScaleMultiplier", f4);
        }

        public void v(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", i4);
        }

        public void w(boolean z3) {
            this.f54363a.putBoolean("com.yalantis.ucrop.ShowCropFrame", z3);
        }

        public void x(boolean z3) {
            this.f54363a.putBoolean("com.yalantis.ucrop.ShowCropGrid", z3);
        }

        public void y(@ColorInt int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.StatusBarColor", i4);
        }

        public void z(@DrawableRes int i4) {
            this.f54363a.putInt("com.yalantis.ucrop.UcropToolbarCancelDrawable", i4);
        }
    }

    private b(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f54337b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f54337b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    @Nullable
    public static Throwable a(@NonNull Intent intent) {
        return (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error");
    }

    @Nullable
    public static Uri e(@NonNull Intent intent) {
        return (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
    }

    public static float f(@NonNull Intent intent) {
        return intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f);
    }

    public static int g(@NonNull Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.ImageHeight", -1);
    }

    public static int h(@NonNull Intent intent) {
        return intent.getIntExtra("com.yalantis.ucrop.ImageWidth", -1);
    }

    public static b i(@NonNull Uri uri, @NonNull Uri uri2) {
        return new b(uri, uri2);
    }

    public UCropFragment b() {
        return UCropFragment.P(this.f54337b);
    }

    public UCropFragment c(Bundle bundle) {
        this.f54337b = bundle;
        return b();
    }

    public Intent d(@NonNull Context context) {
        this.f54336a.setClass(context, UCropActivity.class);
        this.f54336a.putExtras(this.f54337b);
        return this.f54336a;
    }

    public void j(@NonNull Activity activity) {
        k(activity, 69);
    }

    public void k(@NonNull Activity activity, int i4) {
        activity.startActivityForResult(d(activity), i4);
    }

    public void l(@NonNull Context context, @NonNull Fragment fragment) {
        m(context, fragment, 69);
    }

    @TargetApi(11)
    public void m(@NonNull Context context, @NonNull Fragment fragment, int i4) {
        fragment.startActivityForResult(d(context), i4);
    }

    public void n(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment) {
        o(context, fragment, 69);
    }

    public void o(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment, int i4) {
        fragment.startActivityForResult(d(context), i4);
    }

    public b p() {
        this.f54337b.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        this.f54337b.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        return this;
    }

    public b q(float f4, float f5) {
        this.f54337b.putFloat("com.yalantis.ucrop.AspectRatioX", f4);
        this.f54337b.putFloat("com.yalantis.ucrop.AspectRatioY", f5);
        return this;
    }

    public b r(@IntRange(from = 10) int i4, @IntRange(from = 10) int i5) {
        if (i4 < 10) {
            i4 = 10;
        }
        if (i5 < 10) {
            i5 = 10;
        }
        this.f54337b.putInt("com.yalantis.ucrop.MaxSizeX", i4);
        this.f54337b.putInt("com.yalantis.ucrop.MaxSizeY", i5);
        return this;
    }

    public b s(@NonNull a aVar) {
        this.f54337b.putAll(aVar.a());
        return this;
    }
}
