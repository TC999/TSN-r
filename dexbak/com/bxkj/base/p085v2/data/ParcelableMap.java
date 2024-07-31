package com.bxkj.base.p085v2.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: ParcelableMap.kt */
@Parcelize
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\"\u0012\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\u0013\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002HÖ\u0001R5\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m12616d2 = {"Lcom/bxkj/base/v2/data/ParcelableMap;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/f1;", "writeToParcel", "", "", "", "Lkotlinx/parcelize/RawValue;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "b", "(Ljava/util/Map;)V", "map", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.data.ParcelableMap */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ParcelableMap implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ParcelableMap> CREATOR = new C3982a();
    @NotNull

    /* renamed from: a */
    private Map<String, Object> f15181a;

    /* compiled from: ParcelableMap.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.base.v2.data.ParcelableMap$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3982a implements Parcelable.Creator<ParcelableMap> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public final ParcelableMap createFromParcel(@NotNull Parcel parcel) {
            C14342f0.m8184p(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readValue(ParcelableMap.class.getClassLoader()));
            }
            return new ParcelableMap(linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public final ParcelableMap[] newArray(int i) {
            return new ParcelableMap[i];
        }
    }

    public ParcelableMap(@NotNull Map<String, Object> map) {
        C14342f0.m8184p(map, "map");
        this.f15181a = map;
    }

    @NotNull
    /* renamed from: a */
    public final Map<String, Object> m43694a() {
        return this.f15181a;
    }

    /* renamed from: b */
    public final void m43693b(@NotNull Map<String, Object> map) {
        C14342f0.m8184p(map, "<set-?>");
        this.f15181a = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        C14342f0.m8184p(out, "out");
        Map<String, Object> map = this.f15181a;
        out.writeInt(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeValue(entry.getValue());
        }
    }
}
