package cn.jiguang.common.m;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class i extends g {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: cn.jiguang.common.m.i.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public i[] newArray(int i4) {
            return new i[i4];
        }
    };

    private i(Parcel parcel) {
        super(parcel);
    }

    private i(String str) {
        super(str);
    }

    public static i a(int i4) {
        return new i(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i4)));
    }

    public int a() {
        try {
            return Integer.parseInt(a("Uid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String a(String str) {
        String[] split;
        for (String str2 : this.f3534b.split("\n")) {
            if (str2.startsWith(str + ":")) {
                return str2.split(str + ":")[1].trim();
            }
        }
        return null;
    }
}
