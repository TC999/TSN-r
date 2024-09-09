package com.bxkj.base.v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ParcelableMap.kt */
@Parcelize
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\"\u0012\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u00a2\u0006\u0002\b\f\u00a2\u0006\u0004\b\u0013\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R5\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t\u00a2\u0006\u0002\b\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/bxkj/base/v2/data/ParcelableMap;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/f1;", "writeToParcel", "", "", "", "Lkotlinx/parcelize/RawValue;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "b", "(Ljava/util/Map;)V", "map", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class ParcelableMap implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new a();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f18672a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ParcelableMap.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements Parcelable.Creator<ParcelableMap> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public final ParcelableMap createFromParcel(@NotNull Parcel parcel) {
            f0.p(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i4 = 0; i4 != readInt; i4++) {
                linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableMap.class.getClassLoader()));
            }
            return new ParcelableMap(linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public final ParcelableMap[] newArray(int i4) {
            return new ParcelableMap[i4];
        }
    }

    public ParcelableMap(@NotNull Map<String, Object> map) {
        f0.p(map, "map");
        this.f18672a = map;
    }

    @NotNull
    public final Map<String, Object> a() {
        return this.f18672a;
    }

    public final void b(@NotNull Map<String, Object> map) {
        f0.p(map, "<set-?>");
        this.f18672a = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        f0.p(out, "out");
        Map<String, Object> map = this.f18672a;
        out.writeInt(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeValue(entry.getValue());
        }
    }
}
