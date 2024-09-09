package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HardwareConfigState.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class s {

    /* renamed from: c  reason: collision with root package name */
    private static final int f17464c = 128;

    /* renamed from: d  reason: collision with root package name */
    private static final File f17465d = new File("/proc/self/fd");

    /* renamed from: e  reason: collision with root package name */
    private static final int f17466e = 50;

    /* renamed from: f  reason: collision with root package name */
    private static final int f17467f = 700;

    /* renamed from: g  reason: collision with root package name */
    private static volatile s f17468g;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f17469a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f17470b = true;

    private s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s a() {
        if (f17468g == null) {
            synchronized (s.class) {
                if (f17468g == null) {
                    f17468g = new s();
                }
            }
        }
        return f17468g;
    }

    private synchronized boolean b() {
        boolean z3 = true;
        int i4 = this.f17469a + 1;
        this.f17469a = i4;
        if (i4 >= 50) {
            this.f17469a = 0;
            int length = f17465d.list().length;
            if (length >= 700) {
                z3 = false;
            }
            this.f17470b = z3;
            if (!this.f17470b && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f17470b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean c(int i4, int i5, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z3, boolean z4) {
        if (!z3 || Build.VERSION.SDK_INT < 26 || z4) {
            return false;
        }
        boolean z5 = i4 >= 128 && i5 >= 128 && b();
        if (z5) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z5;
    }
}
