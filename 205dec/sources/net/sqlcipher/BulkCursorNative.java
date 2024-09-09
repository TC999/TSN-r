package net.sqlcipher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import net.sqlcipher.IContentObserver;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public BulkCursorNative() {
        attachInterface(this, "android.content.IBulkCursor");
    }

    public static IBulkCursor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IBulkCursor iBulkCursor = (IBulkCursor) iBinder.queryLocalInterface("android.content.IBulkCursor");
        return iBulkCursor != null ? iBulkCursor : new BulkCursorProxy(iBinder);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        try {
            switch (i4) {
                case 1:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    CursorWindow window = getWindow(parcel.readInt());
                    if (window == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    window.writeToParcel(parcel2, 0);
                    return true;
                case 2:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    int count = count();
                    parcel2.writeNoException();
                    parcel2.writeInt(count);
                    return true;
                case 3:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    String[] columnNames = getColumnNames();
                    parcel2.writeNoException();
                    parcel2.writeInt(columnNames.length);
                    int length = columnNames.length;
                    while (r0 < length) {
                        parcel2.writeString(columnNames[r0]);
                        r0++;
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    boolean updateRows = updateRows(parcel.readHashMap(null));
                    parcel2.writeNoException();
                    parcel2.writeInt(updateRows ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    boolean deleteRow = deleteRow(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(deleteRow ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    deactivate();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    int requery = requery(IContentObserver.Stub.asInterface(parcel.readStrongBinder()), CursorWindow.CREATOR.createFromParcel(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(requery);
                    parcel2.writeBundle(getExtras());
                    return true;
                case 8:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    onMove(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    boolean wantsAllOnMoveCalls = getWantsAllOnMoveCalls();
                    parcel2.writeNoException();
                    parcel2.writeInt(wantsAllOnMoveCalls ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    parcel2.writeBundle(extras);
                    return true;
                case 11:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    Bundle respond = respond(parcel.readBundle(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeBundle(respond);
                    return true;
                case 12:
                    parcel.enforceInterface("android.content.IBulkCursor");
                    close();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i4, parcel, parcel2, i5);
            }
        } catch (Exception e4) {
            DatabaseUtils.writeExceptionToParcel(parcel2, e4);
            return true;
        }
    }
}
