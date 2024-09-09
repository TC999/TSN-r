package kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LazyJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u000b"}, d2 = {"T", "Lkotlin/Function0;", "initializer", "Lkotlin/p;", "a", "Lkotlin/LazyThreadSafetyMode;", "mode", "c", "", "lock", "b", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/LazyKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r {

    /* compiled from: LazyJVM.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55757a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            f55757a = iArr;
        }
    }

    @NotNull
    public static <T> p<T> a(@NotNull d2.a<? extends T> initializer) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        return new j0(initializer, null, 2, null);
    }

    @NotNull
    public static final <T> p<T> b(@Nullable Object obj, @NotNull d2.a<? extends T> initializer) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        return new j0(initializer, obj);
    }

    @NotNull
    public static <T> p<T> c(@NotNull LazyThreadSafetyMode mode, @NotNull d2.a<? extends T> initializer) {
        kotlin.jvm.internal.f0.p(mode, "mode");
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        int i4 = a.f55757a[mode.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new e0(initializer);
        }
        return new j0(initializer, null, 2, null);
    }
}
