package com.qq.e.lib.a.d;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static int f47352c = 4;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<HandlerThread> f47353a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f47354b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f47355a = new a();
    }

    public static a b() {
        return b.f47355a;
    }

    public Looper a(int i4) {
        int i5 = i4 % f47352c;
        if (i5 >= this.f47353a.size()) {
            HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor-" + i5);
            handlerThread.start();
            this.f47353a.add(handlerThread);
            Looper looper = handlerThread.getLooper();
            return looper != null ? looper : Looper.getMainLooper();
        } else if (this.f47353a.get(i5) != null) {
            Looper looper2 = this.f47353a.get(i5).getLooper();
            return looper2 != null ? looper2 : Looper.getMainLooper();
        } else {
            return Looper.getMainLooper();
        }
    }

    private a() {
        this.f47353a = new ArrayList<>();
        this.f47354b = new AtomicInteger(0);
    }

    public int a() {
        return this.f47354b.getAndIncrement();
    }
}
