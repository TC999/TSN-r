package cn.jiguang.common.m;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a extends g {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: cn.jiguang.common.m.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f3484a;

    private a(Parcel parcel) {
        super(parcel);
        this.f3484a = parcel.createTypedArrayList(b.CREATOR);
    }

    private a(String str) {
        super(str);
        String[] split = this.f3534b.split("\n");
        this.f3484a = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.f3484a.add(new b(str2));
            } catch (Exception unused) {
            }
        }
    }

    public static a a(int i4) {
        return new a(String.format(Locale.ENGLISH, "/proc/%d/cgroup", Integer.valueOf(i4)));
    }

    public b a(String str) {
        Iterator<b> it = this.f3484a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            for (String str2 : next.f3486b.split(",")) {
                if (str2.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // cn.jiguang.common.m.g, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f3484a);
    }
}
