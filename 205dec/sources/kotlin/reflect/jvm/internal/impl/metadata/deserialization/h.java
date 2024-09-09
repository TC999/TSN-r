package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: VersionRequirement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57484b = new a(null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final h f57485c;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ProtoBuf.VersionRequirement> f57486a;

    /* compiled from: VersionRequirement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final h a(@NotNull ProtoBuf.VersionRequirementTable table) {
            f0.p(table, "table");
            if (table.getRequirementCount() == 0) {
                return b();
            }
            List<ProtoBuf.VersionRequirement> requirementList = table.getRequirementList();
            f0.o(requirementList, "table.requirementList");
            return new h(requirementList, null);
        }

        @NotNull
        public final h b() {
            return h.f57485c;
        }
    }

    static {
        List F;
        F = CollectionsKt__CollectionsKt.F();
        f57485c = new h(F);
    }

    private h(List<ProtoBuf.VersionRequirement> list) {
        this.f57486a = list;
    }

    public /* synthetic */ h(List list, u uVar) {
        this(list);
    }
}
