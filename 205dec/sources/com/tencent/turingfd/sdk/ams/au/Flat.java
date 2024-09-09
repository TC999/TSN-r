package com.tencent.turingfd.sdk.ams.au;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Flat extends Thread {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f52045c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HashMap f52046d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ITuringDeviceInfoProvider f52047e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Object f52048f;

    public Flat(Foxnut foxnut, AtomicBoolean atomicBoolean, HashMap hashMap, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, long j4, Object obj) {
        this.f52045c = atomicBoolean;
        this.f52046d = hashMap;
        this.f52047e = iTuringDeviceInfoProvider;
        this.f52048f = obj;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.f52045c.get()) {
            return;
        }
        try {
            HashMap hashMap = this.f52046d;
            String c4 = this.f52047e.c();
            if (c4 == null) {
                c4 = "";
            }
            hashMap.put("274", c4);
            HashMap hashMap2 = this.f52046d;
            String b4 = this.f52047e.b();
            if (b4 == null) {
                b4 = "";
            }
            hashMap2.put("276", b4);
            HashMap hashMap3 = this.f52046d;
            String a4 = this.f52047e.a();
            if (a4 == null) {
                a4 = "";
            }
            hashMap3.put("275", a4);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.f52048f) {
            this.f52048f.notify();
        }
    }
}
