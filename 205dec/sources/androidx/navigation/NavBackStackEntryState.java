package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator<NavBackStackEntryState>() { // from class: androidx.navigation.NavBackStackEntryState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState[] newArray(int i4) {
            return new NavBackStackEntryState[i4];
        }
    };
    private final Bundle mArgs;
    private final int mDestinationId;
    private final Bundle mSavedState;
    private final UUID mUUID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.mUUID = navBackStackEntry.mId;
        this.mDestinationId = navBackStackEntry.getDestination().getId();
        this.mArgs = navBackStackEntry.getArguments();
        Bundle bundle = new Bundle();
        this.mSavedState = bundle;
        navBackStackEntry.saveState(bundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Bundle getArgs() {
        return this.mArgs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDestinationId() {
        return this.mDestinationId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Bundle getSavedState() {
        return this.mSavedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public UUID getUUID() {
        return this.mUUID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeString(this.mUUID.toString());
        parcel.writeInt(this.mDestinationId);
        parcel.writeBundle(this.mArgs);
        parcel.writeBundle(this.mSavedState);
    }

    NavBackStackEntryState(Parcel parcel) {
        this.mUUID = UUID.fromString(parcel.readString());
        this.mDestinationId = parcel.readInt();
        this.mArgs = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.mSavedState = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
