package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.interface  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cinterface {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.interface$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public final String f52324a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f52325b;

        public Cdo(String str, boolean z3) {
            this.f52324a = str;
            this.f52325b = z3;
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.interface$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class Cif implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52326a = false;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f52327b = new LinkedBlockingQueue<>(1);

        public IBinder a() throws InterruptedException {
            if (!this.f52326a) {
                this.f52326a = true;
                return this.f52327b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f52327b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static Cdo a() {
        Context context;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Cif cif = new Cif();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, cif, 1)) {
                try {
                    IBinder a4 = cif.a();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    a4.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    Parcel obtain3 = Parcel.obtain();
                    Parcel obtain4 = Parcel.obtain();
                    obtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain3.writeInt(1);
                    a4.transact(2, obtain3, obtain4, 0);
                    obtain4.readException();
                    boolean z3 = obtain4.readInt() != 0;
                    obtain4.recycle();
                    obtain3.recycle();
                    return new Cdo(readString, z3);
                } catch (Exception unused) {
                } finally {
                    context.unbindService(cif);
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }
}
