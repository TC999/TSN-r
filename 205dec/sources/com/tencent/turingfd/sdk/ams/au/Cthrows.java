package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.throws  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Cthrows {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<String> f52365a = new AtomicReference<>();

    public static String a() {
        AtomicReference<String> atomicReference = f52365a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = Build.MODEL;
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }

    public static int b() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
