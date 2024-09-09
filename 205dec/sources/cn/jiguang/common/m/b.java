package cn.jiguang.common.m;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: cn.jiguang.common.m.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i4) {
            return new b[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f3485a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3486b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3487c;

    protected b(Parcel parcel) {
        this.f3485a = parcel.readInt();
        this.f3486b = parcel.readString();
        this.f3487c = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(String str) {
        String[] split = str.split(":");
        this.f3485a = Integer.parseInt(split[0]);
        this.f3486b = split[1];
        this.f3487c = split[2];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%d:%s:%s", Integer.valueOf(this.f3485a), this.f3486b, this.f3487c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f3485a);
        parcel.writeString(this.f3486b);
        parcel.writeString(this.f3487c);
    }
}
