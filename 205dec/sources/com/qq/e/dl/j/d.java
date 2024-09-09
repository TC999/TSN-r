package com.qq.e.dl.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final Handler f47003a = new Handler(Looper.getMainLooper());
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final Handler f47004a;

        static {
            HandlerThread handlerThread = new HandlerThread("DLThread");
            handlerThread.start();
            f47004a = new Handler(handlerThread.getLooper());
        }
    }

    public static Handler a() {
        return a.f47003a;
    }

    public static Handler b() {
        return b.f47004a;
    }
}
