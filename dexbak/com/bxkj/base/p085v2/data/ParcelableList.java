package com.bxkj.base.p085v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: ParcelableList.kt */
@Parcelize
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B(\u0012\u001f\u0010\u0013\u001a\u001b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\t¢\u0006\u0002\b\r¢\u0006\u0004\b\u0014\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R;\u0010\u0013\u001a\u001b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\t¢\u0006\u0002\b\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/base/v2/data/ParcelableList;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/f1;", "writeToParcel", "", "", "", "", "Lkotlinx/parcelize/RawValue;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "list", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.data.ParcelableList */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ParcelableList implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ParcelableList> CREATOR = new C3981a();
    @NotNull

    /* renamed from: a */
    private List<? extends Map<String, ? extends Object>> f15180a;

    /* compiled from: ParcelableList.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.base.v2.data.ParcelableList$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3981a implements Parcelable.Creator<ParcelableList> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public final ParcelableList createFromParcel(@NotNull Parcel parcel) {
            C14342f0.m8184p(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableList.class.getClassLoader()));
                }
                arrayList.add(linkedHashMap);
            }
            return new ParcelableList(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public final ParcelableList[] newArray(int i) {
            return new ParcelableList[i];
        }
    }

    public ParcelableList(@NotNull List<? extends Map<String, ? extends Object>> list) {
        C14342f0.m8184p(list, "list");
        this.f15180a = list;
    }

    @NotNull
    /* renamed from: a */
    public final List<Map<String, Object>> m43698a() {
        return this.f15180a;
    }

    /* renamed from: b */
    public final void m43697b(@NotNull List<? extends Map<String, ? extends Object>> list) {
        C14342f0.m8184p(list, "<set-?>");
        this.f15180a = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        C14342f0.m8184p(out, "out");
        List<? extends Map<String, ? extends Object>> list = this.f15180a;
        out.writeInt(list.size());
        for (Map<String, ? extends Object> map : list) {
            out.writeInt(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeValue(entry.getValue());
            }
        }
    }
}
