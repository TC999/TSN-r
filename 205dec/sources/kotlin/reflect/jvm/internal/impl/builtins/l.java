package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.z0;
import kotlin.jvm.JvmStatic;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnsignedType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final l f56224a = new l();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f56225b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f56226c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f56227d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f56228e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<UnsignedArrayType, kotlin.reflect.jvm.internal.impl.name.f> f56229f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f56230g;

    static {
        Set<kotlin.reflect.jvm.internal.impl.name.f> L5;
        Set<kotlin.reflect.jvm.internal.impl.name.f> L52;
        HashMap<UnsignedArrayType, kotlin.reflect.jvm.internal.impl.name.f> M;
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int length = values.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            UnsignedType unsignedType = values[i5];
            i5++;
            arrayList.add(unsignedType.getTypeName());
        }
        L5 = f0.L5(arrayList);
        f56225b = L5;
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        int length2 = values2.length;
        int i6 = 0;
        while (i6 < length2) {
            UnsignedArrayType unsignedArrayType = values2[i6];
            i6++;
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        L52 = f0.L5(arrayList2);
        f56226c = L52;
        f56227d = new HashMap<>();
        f56228e = new HashMap<>();
        M = z0.M(l0.a(UnsignedArrayType.UBYTEARRAY, kotlin.reflect.jvm.internal.impl.name.f.f("ubyteArrayOf")), l0.a(UnsignedArrayType.USHORTARRAY, kotlin.reflect.jvm.internal.impl.name.f.f("ushortArrayOf")), l0.a(UnsignedArrayType.UINTARRAY, kotlin.reflect.jvm.internal.impl.name.f.f("uintArrayOf")), l0.a(UnsignedArrayType.ULONGARRAY, kotlin.reflect.jvm.internal.impl.name.f.f("ulongArrayOf")));
        f56229f = M;
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length3 = values3.length;
        int i7 = 0;
        while (i7 < length3) {
            UnsignedType unsignedType2 = values3[i7];
            i7++;
            linkedHashSet.add(unsignedType2.getArrayClassId().j());
        }
        f56230g = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length4 = values4.length;
        while (i4 < length4) {
            UnsignedType unsignedType3 = values4[i4];
            i4++;
            f56227d.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            f56228e.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private l() {
    }

    @JvmStatic
    public static final boolean d(@NotNull e0 type) {
        kotlin.reflect.jvm.internal.impl.descriptors.f b4;
        kotlin.jvm.internal.f0.p(type, "type");
        if (h1.w(type) || (b4 = type.H0().b()) == null) {
            return false;
        }
        return f56224a.c(b4);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b a(@NotNull kotlin.reflect.jvm.internal.impl.name.b arrayClassId) {
        kotlin.jvm.internal.f0.p(arrayClassId, "arrayClassId");
        return f56227d.get(arrayClassId);
    }

    public final boolean b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return f56230g.contains(name);
    }

    public final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = descriptor.b();
        return (b4 instanceof g0) && kotlin.jvm.internal.f0.g(((g0) b4).e(), j.f56084m) && f56225b.contains(descriptor.getName());
    }
}
