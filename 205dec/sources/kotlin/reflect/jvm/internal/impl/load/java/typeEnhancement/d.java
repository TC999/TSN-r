package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: typeQualifiers.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f56999e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final d f57000f = new d(null, null, false, false, 8, null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final NullabilityQualifier f57001a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final MutabilityQualifier f57002b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f57003c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f57004d;

    /* compiled from: typeQualifiers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final d a() {
            return d.f57000f;
        }
    }

    public d(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z3, boolean z4) {
        this.f57001a = nullabilityQualifier;
        this.f57002b = mutabilityQualifier;
        this.f57003c = z3;
        this.f57004d = z4;
    }

    public final boolean b() {
        return this.f57003c;
    }

    @Nullable
    public final MutabilityQualifier c() {
        return this.f57002b;
    }

    @Nullable
    public final NullabilityQualifier d() {
        return this.f57001a;
    }

    public final boolean e() {
        return this.f57004d;
    }

    public /* synthetic */ d(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z3, boolean z4, int i4, u uVar) {
        this(nullabilityQualifier, mutabilityQualifier, z3, (i4 & 8) != 0 ? false : z4);
    }
}
