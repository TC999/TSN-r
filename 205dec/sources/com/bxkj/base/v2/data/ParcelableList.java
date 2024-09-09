package com.bxkj.base.v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ParcelableList.kt */
@Parcelize
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B(\u0012\u001f\u0010\u0013\u001a\u001b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\t\u00a2\u0006\u0002\b\r\u00a2\u0006\u0004\b\u0014\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R;\u0010\u0013\u001a\u001b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\t\u00a2\u0006\u0002\b\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/base/v2/data/ParcelableList;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/f1;", "writeToParcel", "", "", "", "", "Lkotlinx/parcelize/RawValue;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "list", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ParcelableList implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ParcelableList> CREATOR = new a();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<? extends Map<String, ? extends Object>> f18671a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ParcelableList.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements Parcelable.Creator<ParcelableList> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public final ParcelableList createFromParcel(@NotNull Parcel parcel) {
            f0.p(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i4 = 0; i4 != readInt; i4++) {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                for (int i5 = 0; i5 != readInt2; i5++) {
                    linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableList.class.getClassLoader()));
                }
                arrayList.add(linkedHashMap);
            }
            return new ParcelableList(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public final ParcelableList[] newArray(int i4) {
            return new ParcelableList[i4];
        }
    }

    public ParcelableList(@NotNull List<? extends Map<String, ? extends Object>> list) {
        f0.p(list, "list");
        this.f18671a = list;
    }

    @NotNull
    public final List<Map<String, Object>> a() {
        return this.f18671a;
    }

    public final void b(@NotNull List<? extends Map<String, ? extends Object>> list) {
        f0.p(list, "<set-?>");
        this.f18671a = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        f0.p(out, "out");
        List<? extends Map<String, ? extends Object>> list = this.f18671a;
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
