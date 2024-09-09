package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MemorySizeCalculator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class l {

    /* renamed from: e  reason: collision with root package name */
    private static final String f16976e = "MemorySizeCalculator";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f16977f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16978g = 2;

    /* renamed from: a  reason: collision with root package name */
    private final int f16979a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16980b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16981c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16982d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a {
        @VisibleForTesting

        /* renamed from: i  reason: collision with root package name */
        static final int f16983i = 2;

        /* renamed from: j  reason: collision with root package name */
        static final int f16984j;

        /* renamed from: k  reason: collision with root package name */
        static final float f16985k = 0.4f;

        /* renamed from: l  reason: collision with root package name */
        static final float f16986l = 0.33f;

        /* renamed from: m  reason: collision with root package name */
        static final int f16987m = 4194304;

        /* renamed from: a  reason: collision with root package name */
        final Context f16988a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f16989b;

        /* renamed from: c  reason: collision with root package name */
        c f16990c;

        /* renamed from: e  reason: collision with root package name */
        float f16992e;

        /* renamed from: d  reason: collision with root package name */
        float f16991d = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f16993f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f16994g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f16995h = 4194304;

        static {
            f16984j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f16992e = f16984j;
            this.f16988a = context;
            this.f16989b = (ActivityManager) context.getSystemService("activity");
            this.f16990c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !l.e(this.f16989b)) {
                return;
            }
            this.f16992e = 0.0f;
        }

        public l a() {
            return new l(this);
        }

        @VisibleForTesting
        a b(ActivityManager activityManager) {
            this.f16989b = activityManager;
            return this;
        }

        public a c(int i4) {
            this.f16995h = i4;
            return this;
        }

        public a d(float f4) {
            com.bumptech.glide.util.j.a(f4 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f16992e = f4;
            return this;
        }

        public a e(float f4) {
            com.bumptech.glide.util.j.a(f4 >= 0.0f && f4 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f16994g = f4;
            return this;
        }

        public a f(float f4) {
            com.bumptech.glide.util.j.a(f4 >= 0.0f && f4 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f16993f = f4;
            return this;
        }

        public a g(float f4) {
            com.bumptech.glide.util.j.a(f4 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f16991d = f4;
            return this;
        }

        @VisibleForTesting
        a h(c cVar) {
            this.f16990c = cVar;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f16996a;

        b(DisplayMetrics displayMetrics) {
            this.f16996a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.l.c
        public int a() {
            return this.f16996a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.l.c
        public int b() {
            return this.f16996a.widthPixels;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    interface c {
        int a();

        int b();
    }

    l(a aVar) {
        int i4;
        this.f16981c = aVar.f16988a;
        if (e(aVar.f16989b)) {
            i4 = aVar.f16995h / 2;
        } else {
            i4 = aVar.f16995h;
        }
        this.f16982d = i4;
        int c4 = c(aVar.f16989b, aVar.f16993f, aVar.f16994g);
        float b4 = aVar.f16990c.b() * aVar.f16990c.a() * 4;
        int round = Math.round(aVar.f16992e * b4);
        int round2 = Math.round(b4 * aVar.f16991d);
        int i5 = c4 - i4;
        int i6 = round2 + round;
        if (i6 <= i5) {
            this.f16980b = round2;
            this.f16979a = round;
        } else {
            float f4 = i5;
            float f5 = aVar.f16992e;
            float f6 = aVar.f16991d;
            float f7 = f4 / (f5 + f6);
            this.f16980b = Math.round(f6 * f7);
            this.f16979a = Math.round(f7 * aVar.f16992e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f16980b));
            sb.append(", pool size: ");
            sb.append(f(this.f16979a));
            sb.append(", byte array size: ");
            sb.append(f(i4));
            sb.append(", memory class limited? ");
            sb.append(i6 > c4);
            sb.append(", max size: ");
            sb.append(f(c4));
            sb.append(", memoryClass: ");
            sb.append(aVar.f16989b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f16989b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f4, float f5) {
        boolean e4 = e(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e4) {
            f4 = f5;
        }
        return Math.round(memoryClass * f4);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i4) {
        return Formatter.formatFileSize(this.f16981c, i4);
    }

    public int a() {
        return this.f16982d;
    }

    public int b() {
        return this.f16979a;
    }

    public int d() {
        return this.f16980b;
    }
}
