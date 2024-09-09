package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class Perseus implements Andromeda {

    /* renamed from: a  reason: collision with root package name */
    public Lyra f52156a;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Perseus$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52158b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f52159c;

        public Cdo(Perseus perseus, AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f52157a = atomicReference;
            this.f52158b = atomicReference2;
            this.f52159c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f52157a.set(iBinder);
            this.f52158b.set(this);
            synchronized (this.f52159c) {
                try {
                    this.f52159c.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Perseus$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cif extends Thread {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52160c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52161d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f52163f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52164g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f52165h;

        public Cif(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f52160c = atomicReference;
            this.f52161d = atomicReference2;
            this.f52162e = atomicReference3;
            this.f52163f = context;
            this.f52164g = atomicReference4;
            this.f52165h = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            try {
                str = Perseus.this.a((IBinder) this.f52160c.get());
            } catch (Throwable unused) {
                this.f52161d.set(-102);
                str = "";
            }
            this.f52162e.set(str);
            try {
                this.f52163f.unbindService((ServiceConnection) this.f52164g.get());
            } catch (Throwable unused2) {
                this.f52161d.set(-103);
            }
            synchronized (this.f52165h) {
                try {
                    this.f52165h.notifyAll();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Andromeda
    public Lyra a(Context context) {
        Lyra lyra = this.f52156a;
        if (lyra == null || lyra.f52148b != 0) {
            this.f52156a = c(context);
        }
        return this.f52156a;
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingfd.sdk.ams.au.Andromeda
    public void b(Context context) {
        this.f52156a = c(context);
    }

    public final Lyra c(Context context) {
        int i4;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            i4 = a(context, atomicReference2, atomicReference3);
            if (i4 == 0) {
                try {
                    i4 = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            i4 = -1;
        }
        return new Lyra(atomicReference.get(), i4);
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        Object obj = new Object();
        Intent intent = new Intent(Cextends.a(Cextends.f52278k));
        intent.setComponent(new ComponentName(Cextends.a(Cextends.f52266g), Cextends.a(Cextends.f52269h)));
        if (context.bindService(intent, new Cdo(this, atomicReference, atomicReference2, obj), 1)) {
            if (atomicReference.get() == null) {
                synchronized (obj) {
                    try {
                        obj.wait(1000L);
                    } catch (Throwable unused) {
                    }
                }
            }
            return atomicReference.get() == null ? -105 : 0;
        }
        return -100;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new Cif(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable unused) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
