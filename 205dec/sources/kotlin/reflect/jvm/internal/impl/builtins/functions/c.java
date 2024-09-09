package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.e;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: FunctionClassScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends e {

    /* compiled from: FunctionClassScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56041a;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            f56041a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull n storageManager, @NotNull b containingClass) {
        super(storageManager, containingClass);
        f0.p(storageManager, "storageManager");
        f0.p(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.e
    @NotNull
    protected List<w> j() {
        List<w> l4;
        List<w> l5;
        List<w> F;
        int i4 = a.f56041a[((b) m()).P0().ordinal()];
        if (i4 == 1) {
            l4 = x.l(d.D.a((b) m(), false));
            return l4;
        } else if (i4 != 2) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        } else {
            l5 = x.l(d.D.a((b) m(), true));
            return l5;
        }
    }
}
