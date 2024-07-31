package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3770j;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.bumptech.glide.load.engine.cache.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MemorySizeCalculator {

    /* renamed from: e */
    private static final String f13653e = "MemorySizeCalculator";
    @VisibleForTesting

    /* renamed from: f */
    static final int f13654f = 4;

    /* renamed from: g */
    private static final int f13655g = 2;

    /* renamed from: a */
    private final int f13656a;

    /* renamed from: b */
    private final int f13657b;

    /* renamed from: c */
    private final Context f13658c;

    /* renamed from: d */
    private final int f13659d;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.l$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3604a {
        @VisibleForTesting

        /* renamed from: i */
        static final int f13660i = 2;

        /* renamed from: j */
        static final int f13661j;

        /* renamed from: k */
        static final float f13662k = 0.4f;

        /* renamed from: l */
        static final float f13663l = 0.33f;

        /* renamed from: m */
        static final int f13664m = 4194304;

        /* renamed from: a */
        final Context f13665a;

        /* renamed from: b */
        ActivityManager f13666b;

        /* renamed from: c */
        InterfaceC3606c f13667c;

        /* renamed from: e */
        float f13669e;

        /* renamed from: d */
        float f13668d = 2.0f;

        /* renamed from: f */
        float f13670f = 0.4f;

        /* renamed from: g */
        float f13671g = 0.33f;

        /* renamed from: h */
        int f13672h = 4194304;

        static {
            f13661j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public C3604a(Context context) {
            this.f13669e = f13661j;
            this.f13665a = context;
            this.f13666b = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            this.f13667c = new C3605b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.m45312e(this.f13666b)) {
                return;
            }
            this.f13669e = 0.0f;
        }

        /* renamed from: a */
        public MemorySizeCalculator m45310a() {
            return new MemorySizeCalculator(this);
        }

        @VisibleForTesting
        /* renamed from: b */
        C3604a m45309b(ActivityManager activityManager) {
            this.f13666b = activityManager;
            return this;
        }

        /* renamed from: c */
        public C3604a m45308c(int i) {
            this.f13672h = i;
            return this;
        }

        /* renamed from: d */
        public C3604a m45307d(float f) {
            C3770j.m44395a(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f13669e = f;
            return this;
        }

        /* renamed from: e */
        public C3604a m45306e(float f) {
            C3770j.m44395a(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f13671g = f;
            return this;
        }

        /* renamed from: f */
        public C3604a m45305f(float f) {
            C3770j.m44395a(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f13670f = f;
            return this;
        }

        /* renamed from: g */
        public C3604a m45304g(float f) {
            C3770j.m44395a(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f13668d = f;
            return this;
        }

        @VisibleForTesting
        /* renamed from: h */
        C3604a m45303h(InterfaceC3606c interfaceC3606c) {
            this.f13667c = interfaceC3606c;
            return this;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.l$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3605b implements InterfaceC3606c {

        /* renamed from: a */
        private final DisplayMetrics f13673a;

        C3605b(DisplayMetrics displayMetrics) {
            this.f13673a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.InterfaceC3606c
        /* renamed from: a */
        public int mo45302a() {
            return this.f13673a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.InterfaceC3606c
        /* renamed from: b */
        public int mo45301b() {
            return this.f13673a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.l$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    interface InterfaceC3606c {
        /* renamed from: a */
        int mo45302a();

        /* renamed from: b */
        int mo45301b();
    }

    MemorySizeCalculator(C3604a c3604a) {
        int i;
        this.f13658c = c3604a.f13665a;
        if (m45312e(c3604a.f13666b)) {
            i = c3604a.f13672h / 2;
        } else {
            i = c3604a.f13672h;
        }
        this.f13659d = i;
        int m45314c = m45314c(c3604a.f13666b, c3604a.f13670f, c3604a.f13671g);
        float mo45301b = c3604a.f13667c.mo45301b() * c3604a.f13667c.mo45302a() * 4;
        int round = Math.round(c3604a.f13669e * mo45301b);
        int round2 = Math.round(mo45301b * c3604a.f13668d);
        int i2 = m45314c - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f13657b = round2;
            this.f13656a = round;
        } else {
            float f = i2;
            float f2 = c3604a.f13669e;
            float f3 = c3604a.f13668d;
            float f4 = f / (f2 + f3);
            this.f13657b = Math.round(f3 * f4);
            this.f13656a = Math.round(f4 * c3604a.f13669e);
        }
        if (Log.isLoggable(f13653e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m45311f(this.f13657b));
            sb.append(", pool size: ");
            sb.append(m45311f(this.f13656a));
            sb.append(", byte array size: ");
            sb.append(m45311f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > m45314c);
            sb.append(", max size: ");
            sb.append(m45311f(m45314c));
            sb.append(", memoryClass: ");
            sb.append(c3604a.f13666b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m45312e(c3604a.f13666b));
            Log.d(f13653e, sb.toString());
        }
    }

    /* renamed from: c */
    private static int m45314c(ActivityManager activityManager, float f, float f2) {
        boolean m45312e = m45312e(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (m45312e) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    /* renamed from: e */
    static boolean m45312e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* renamed from: f */
    private String m45311f(int i) {
        return Formatter.formatFileSize(this.f13658c, i);
    }

    /* renamed from: a */
    public int m45316a() {
        return this.f13659d;
    }

    /* renamed from: b */
    public int m45315b() {
        return this.f13656a;
    }

    /* renamed from: d */
    public int m45313d() {
        return this.f13657b;
    }
}
