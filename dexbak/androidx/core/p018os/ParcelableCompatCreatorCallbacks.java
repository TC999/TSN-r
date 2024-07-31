package androidx.core.p018os;

import android.os.Parcel;

@Deprecated
/* renamed from: androidx.core.os.ParcelableCompatCreatorCallbacks */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
