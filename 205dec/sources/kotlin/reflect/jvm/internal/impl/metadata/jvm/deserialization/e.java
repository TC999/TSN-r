package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmMetadataVersion.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.metadata.deserialization.a {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final a f57536h = new a(null);
    @JvmField
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final e f57537i = new e(1, 6, 0);
    @JvmField
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final e f57538j = new e(new int[0]);

    /* renamed from: g  reason: collision with root package name */
    private final boolean f57539g;

    /* compiled from: JvmMetadataVersion.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull int[] versionArray, boolean z3) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        f0.p(versionArray, "versionArray");
        this.f57539g = z3;
    }

    public boolean h() {
        boolean z3;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f57539g) {
            z3 = f(f57537i);
        } else {
            int a4 = a();
            e eVar = f57537i;
            z3 = a4 == eVar.a() && b() <= eVar.b() + 1;
        }
        return z3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NotNull int... numbers) {
        this(numbers, false);
        f0.p(numbers, "numbers");
    }
}
