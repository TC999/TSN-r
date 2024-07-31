package com.kwad.framework.filedownloader.p351d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.C11023ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9462b implements Parcelable {
    public static final Parcelable.Creator<C9462b> CREATOR = new Parcelable.Creator<C9462b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        /* renamed from: b */
        private static C9462b m28699b(Parcel parcel) {
            return new C9462b(parcel);
        }

        /* renamed from: bC */
        private static C9462b[] m28698bC(int i) {
            return new C9462b[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ C9462b createFromParcel(Parcel parcel) {
            return m28699b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ C9462b[] newArray(int i) {
            return m28698bC(i);
        }
    };
    private HashMap<String, List<String>> ahD;

    public C9462b() {
    }

    /* renamed from: bm */
    public final void m28702bm(String str) {
        HashMap<String, List<String>> hashMap = this.ahD;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.ahD.toString();
    }

    /* renamed from: wk */
    public final HashMap<String, List<String>> m28701wk() {
        return this.ahD;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.ahD);
    }

    /* renamed from: x */
    public final void m28700x(String str, String str2) {
        C11023ap.m24086gH(str);
        C11023ap.m24086gH(str2);
        if (this.ahD == null) {
            this.ahD = new HashMap<>();
        }
        List<String> list = this.ahD.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.ahD.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    protected C9462b(Parcel parcel) {
        this.ahD = parcel.readHashMap(String.class.getClassLoader());
    }
}
