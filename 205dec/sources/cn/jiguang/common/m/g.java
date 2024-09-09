package cn.jiguang.common.m;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends File implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: cn.jiguang.common.m.g.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i4) {
            return new g[i4];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final String f3534b;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Parcel parcel) {
        super(parcel.readString());
        this.f3534b = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(String str) {
        super(str);
        this.f3534b = b(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader = null;
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = "\n";
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return this.f3534b.length();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.f3534b);
    }
}
