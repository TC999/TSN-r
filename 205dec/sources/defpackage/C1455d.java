package defpackage;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: d  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1455d implements InterfaceC1484v, IBinder.DeathRecipient {

    /* renamed from: b  reason: collision with root package name */
    public static C1455d f54605b;

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1484v f54606a;

    public C1455d(InterfaceC1484v interfaceC1484v) {
        this.f54606a = interfaceC1484v;
        interfaceC1484v.asBinder().linkToDeath(this, 0);
    }

    @Override // defpackage.InterfaceC1484v
    public final ParcelFileDescriptor a(ArrayList arrayList) {
        try {
            return this.f54606a.a(arrayList);
        } catch (RemoteException | NullPointerException unused) {
            return null;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f54606a.asBinder();
    }

    @Override // defpackage.InterfaceC1484v
    public final IBinder b(String str) {
        try {
            return this.f54606a.b(str);
        } catch (RemoteException | NullPointerException unused) {
            return null;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        this.f54606a.asBinder().unlinkToDeath(this, 0);
        f54605b = null;
    }

    @Override // defpackage.InterfaceC1484v
    public final List c() {
        try {
            return this.f54606a.c();
        } catch (RemoteException | NullPointerException unused) {
            return Collections.emptyList();
        }
    }

    @Override // defpackage.InterfaceC1484v
    public final List d() {
        try {
            return this.f54606a.d();
        } catch (RemoteException | NullPointerException unused) {
            return Collections.emptyList();
        }
    }

    @Override // defpackage.InterfaceC1484v
    public final String e(String str) {
        try {
            return this.f54606a.e(str);
        } catch (RemoteException | NullPointerException unused) {
            return null;
        }
    }
}
