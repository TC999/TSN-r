package cn.jiguang.q;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.ah.d;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface c extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: cn.jiguang.q.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public static class C0064a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f3774a;

            public C0064a(IBinder iBinder) {
                this.f3774a = iBinder;
            }

            @Override // cn.jiguang.q.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(d.f("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f3774a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Throwable th) {
                    try {
                        cn.jiguang.w.a.f("ZTEOAID", "getOAID obtain exception:" + th.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3774a;
            }

            @Override // cn.jiguang.q.c
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z3 = false;
                try {
                    obtain.writeInterfaceToken(d.f("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f3774a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z3 = true;
                    }
                } finally {
                    try {
                        return z3;
                    } finally {
                    }
                }
                return z3;
            }
        }
    }

    String a();

    boolean b();
}
