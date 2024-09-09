package com.amap.api.col.p0003l;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDRemapRequest.java */
/* renamed from: com.amap.api.col.3l.x4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x4 extends z4 {

    /* renamed from: j  reason: collision with root package name */
    public String f9407j;

    /* renamed from: k  reason: collision with root package name */
    public String f9408k;

    /* renamed from: p  reason: collision with root package name */
    public String f9409p;

    /* renamed from: q  reason: collision with root package name */
    public String f9410q;

    /* renamed from: r  reason: collision with root package name */
    public String f9411r;

    /* renamed from: s  reason: collision with root package name */
    public String f9412s;

    /* renamed from: t  reason: collision with root package name */
    public String f9413t;

    /* renamed from: u  reason: collision with root package name */
    public String f9414u;

    /* renamed from: v  reason: collision with root package name */
    public String f9415v;

    /* renamed from: w  reason: collision with root package name */
    protected byte[] f9416w;

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.x4$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f9417a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9418b;

        a(String str, boolean z3) {
            this.f9417a = str;
            this.f9418b = z3;
        }

        public final boolean b() {
            return this.f9418b;
        }
    }

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.x4$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f9421a;

        public c(IBinder iBinder) {
            this.f9421a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9421a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f9421a;
        }

        public final boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f9421a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public x4(Context context) {
        super(context);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        byte[] bArr = this.f9416w;
        if (bArr != null) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "remap");
            jSONObject.put("package_name", e4.g(this.f9583i));
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_type", "Android");
            jSONObject.put("sdk_version", "4.3.11");
            String a4 = v4.a();
            this.f9407j = a4;
            jSONObject.put("t1", a4);
            jSONObject.put("old_t1", r4.n(this.f9583i));
            String e4 = v4.e();
            this.f9408k = e4;
            jSONObject.put("t2", e4);
            jSONObject.put("old_t2", r4.p(this.f9583i));
            String h4 = v4.h();
            this.f9409p = h4;
            jSONObject.put("t3", h4);
            jSONObject.put("old_t3", r4.r(this.f9583i));
            String i4 = v4.i();
            this.f9410q = i4;
            jSONObject.put("s1", i4);
            jSONObject.put("old_s1", r4.t(this.f9583i));
            String j4 = v4.j();
            this.f9411r = j4;
            jSONObject.put("s2", j4);
            jSONObject.put("old_s2", r4.v(this.f9583i));
            String k4 = v4.k();
            this.f9412s = k4;
            jSONObject.put("s3", k4);
            jSONObject.put("old_s3", r4.x(this.f9583i));
            String l4 = v4.l();
            this.f9413t = l4;
            jSONObject.put("s4", l4);
            jSONObject.put("old_s4", r4.z(this.f9583i));
            jSONObject.put("uuid", v4.b(this.f9583i));
            jSONObject.put("android_id", i4.G());
            jSONObject.put("hostname", v4.m());
            String f02 = i4.f0(this.f9583i);
            this.f9414u = f02;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, f02);
            jSONObject.put("old_gaid", r4.B(this.f9583i));
            String D = i4.D(this.f9583i);
            this.f9415v = D;
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, D);
            jSONObject.put("old_oaid", r4.d(this.f9583i));
            jSONObject.put("aaid", r4.f(this.f9583i));
            jSONObject.put("resetToken", r4.l(this.f9583i));
            jSONObject.put("uabc", r4.j(this.f9583i));
            this.f9416w = v4.d(q4.z(jSONObject.toString().getBytes("utf-8")), q4.u("YWDR1a2R2WEd0M3RXdHRocg==").getBytes());
        } catch (Throwable unused) {
        }
        return this.f9416w;
    }

    /* compiled from: AdvertisingId.java */
    /* renamed from: com.amap.api.col.3l.x4$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f9419a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f9420b;

        private b() {
            this.f9419a = false;
            this.f9420b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (!this.f9419a) {
                this.f9419a = true;
                return this.f9420b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9420b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }
}
