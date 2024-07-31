package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* renamed from: com.bumptech.glide.load.resource.bitmap.s */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class HardwareConfigState {

    /* renamed from: c */
    private static final int f14147c = 128;

    /* renamed from: d */
    private static final File f14148d = new File("/proc/self/fd");

    /* renamed from: e */
    private static final int f14149e = 50;

    /* renamed from: f */
    private static final int f14150f = 700;

    /* renamed from: g */
    private static volatile HardwareConfigState f14151g;

    /* renamed from: a */
    private volatile int f14152a;

    /* renamed from: b */
    private volatile boolean f14153b = true;

    private HardwareConfigState() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static HardwareConfigState m44919a() {
        if (f14151g == null) {
            synchronized (HardwareConfigState.class) {
                if (f14151g == null) {
                    f14151g = new HardwareConfigState();
                }
            }
        }
        return f14151g;
    }

    /* renamed from: b */
    private synchronized boolean m44918b() {
        boolean z = true;
        int i = this.f14152a + 1;
        this.f14152a = i;
        if (i >= 50) {
            this.f14152a = 0;
            int length = f14148d.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f14153b = z;
            if (!this.f14153b && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f14153b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: c */
    public boolean m44917c(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && m44918b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
