package cn.jiguang.common.n;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.jiguang.common.m.g;
import cn.jiguang.common.m.h;
import cn.jiguang.common.m.i;
import java.io.IOException;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: cn.jiguang.common.n.b.1
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

    /* renamed from: c  reason: collision with root package name */
    public final String f3546c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3547d;

    public b(int i4) {
        this.f3547d = i4;
        this.f3546c = a(i4);
    }

    protected b(Parcel parcel) {
        this.f3546c = parcel.readString();
        this.f3547d = parcel.readInt();
    }

    private String a(int i4) {
        String str;
        try {
            str = g.b(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i4))).trim();
        } catch (IOException unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return h.a(i4).a();
            } catch (Exception unused2) {
                throw new IOException(String.format(Locale.ENGLISH, "Error reading /proc/%d/stat", Integer.valueOf(i4)));
            }
        }
        return str;
    }

    public String a(String str) {
        return g.b(String.format(Locale.ENGLISH, "/proc/%d/%s", Integer.valueOf(this.f3547d), str));
    }

    public cn.jiguang.common.m.a b() {
        return cn.jiguang.common.m.a.a(this.f3547d);
    }

    public int c() {
        return Integer.parseInt(a("oom_score"));
    }

    public int d() {
        return Integer.parseInt(a("oom_adj"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return Integer.parseInt(a("oom_score_adj"));
    }

    public h f() {
        return h.a(this.f3547d);
    }

    public i g() {
        return i.a(this.f3547d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f3546c);
        parcel.writeInt(this.f3547d);
    }
}
