package com.tencent.turingfd.sdk.ams.au;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class Aquila extends Binder implements IInterface {
    public Aquila() {
        attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        try {
            if (i4 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                parcel2.writeNoException();
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            } else {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int readInt = parcel.readInt();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                Pegasus pegasus = (Pegasus) this;
                if (!pegasus.f52155b) {
                    String string = (readInt != 0 || bundle == null) ? "" : bundle.getString("oa_id_flag");
                    synchronized (pegasus.f52154a) {
                        pegasus.f52154a.set(string);
                        pegasus.f52154a.notifyAll();
                    }
                }
                parcel2.writeNoException();
                return true;
            }
        } catch (RemoteException unused) {
            return false;
        }
    }
}
