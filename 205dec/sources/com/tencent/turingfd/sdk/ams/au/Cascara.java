package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tencent.turingfd.sdk.ams.au.Auriga;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cascara {

    /* renamed from: a  reason: collision with root package name */
    public static final String f51956a = Cextends.a(Cextends.G0);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Cascara$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f51957a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f51958b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f51959c;

        /* compiled from: A */
        /* renamed from: com.tencent.turingfd.sdk.ams.au.Cascara$do$do  reason: invalid class name and collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class C1048do extends Thread {

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ IBinder f51960c;

            public C1048do(IBinder iBinder) {
                this.f51960c = iBinder;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Auriga c1046do;
                int i4;
                IBinder iBinder = this.f51960c;
                String str = Auriga.Cdo.f51892a;
                if (iBinder == null) {
                    c1046do = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof Auriga)) {
                        c1046do = (Auriga) queryLocalInterface;
                    } else {
                        c1046do = new Auriga.Cdo.C1046do(iBinder);
                    }
                }
                try {
                    if (c1046do.c(2000)) {
                        i4 = 0;
                    } else {
                        c1046do.b(2000);
                        i4 = 1;
                    }
                    Cif a4 = Cascara.a(c1046do.e(2000).f51943d);
                    int i5 = a4.f51962a;
                    if (i5 != 0) {
                        Cdo.this.f51957a.set(Bullace.a(i5, i4));
                    } else {
                        Casaba casaba = a4.f51963b;
                        Cdo.this.f51957a.set(new Bullace(0, 200, System.currentTimeMillis() - Cdo.this.f51958b, casaba.f51954c, c1046do.a(), i4));
                    }
                } catch (Throwable unused) {
                    Cdo.this.f51957a.set(Bullace.a(-2003, -1));
                }
                synchronized (Cdo.this.f51959c) {
                    Cdo.this.f51959c.notify();
                }
                if (Gooseberry.f52078f.a("s_t_d_ask", false)) {
                    try {
                        c1046do.a(2000);
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }

        public Cdo(AtomicReference atomicReference, long j4, Object obj) {
            this.f51957a = atomicReference;
            this.f51958b = j4;
            this.f51959c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new C1048do(iBinder).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f51957a.set(Bullace.a(-2004, -3));
            synchronized (this.f51959c) {
                this.f51959c.notify();
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Cascara$if  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cif {

        /* renamed from: a  reason: collision with root package name */
        public int f51962a;

        /* renamed from: b  reason: collision with root package name */
        public Casaba f51963b;

        public Cif(int i4, Casaba casaba) {
            this.f51962a = i4;
            this.f51963b = casaba;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingfd.sdk.ams.au.Bullace a() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cascara.a():com.tencent.turingfd.sdk.ams.au.Bullace");
    }

    public static Bullace a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(Cextends.a(Cextends.L0));
        intent.setPackage(Cextends.a(Cextends.M0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Bullace.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new Cdo(atomicReference, currentTimeMillis, obj), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Bullace.a(-2002, -1));
        }
        return (Bullace) atomicReference.get();
    }

    public static Cif a(byte[] bArr) {
        if (bArr == null) {
            return new Cif(AVMDLDataLoader.AVMDLErrorIsStatusCodeMoreThan500, null);
        }
        if (bArr.length < 4) {
            return new Cif(AVMDLDataLoader.AVMDLErrorIsStatusCodeMoreThan500, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 += (bArr2[i5] & 255) << (i5 * 8);
        }
        if (i4 > 1048576) {
            return new Cif(-3003, null);
        }
        byte[] bArr3 = new byte[i4];
        int i6 = i4 + 4;
        if (bArr.length < i6) {
            return new Cif(-3004, null);
        }
        System.arraycopy(bArr, 4, bArr3, 0, i4);
        Casaba casaba = new Casaba(new String(bArr3), "");
        int length = bArr.length - i6;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i6, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new Cif(0, casaba);
        }
        return new Cif(-3005, null);
    }
}
