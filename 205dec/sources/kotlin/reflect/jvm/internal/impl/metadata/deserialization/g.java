package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeTable.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ProtoBuf.Type> f57483a;

    public g(@NotNull ProtoBuf.TypeTable typeTable) {
        int Z;
        f0.p(typeTable, "typeTable");
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            f0.o(typeList2, "typeTable.typeList");
            Z = y.Z(typeList2, 10);
            ArrayList arrayList = new ArrayList(Z);
            int i4 = 0;
            for (Object obj : typeList2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.X();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i4 >= firstNullable) {
                    type = type.toBuilder().P(true).build();
                }
                arrayList.add(type);
                i4 = i5;
            }
            typeList = arrayList;
        }
        f0.o(typeList, "run {\n        val origin\u2026 else originalTypes\n    }");
        this.f57483a = typeList;
    }

    @NotNull
    public final ProtoBuf.Type a(int i4) {
        return this.f57483a.get(i4);
    }
}
