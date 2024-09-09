package e1;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.contracts.ExperimentalContracts;
import kotlin.contracts.InvocationKind;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ContractBuilder.kt */
@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\u0007\u001a\u00020\u0006H'J&\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH'\u00a8\u0006\u000f"}, d2 = {"Le1/c;", "", "Le1/f;", "a", "value", "b", "Le1/g;", "c", "R", "Lkotlin/j;", "lambda", "Lkotlin/contracts/InvocationKind;", "kind", "Le1/a;", "d", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@ExperimentalContracts
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface c {

    /* compiled from: ContractBuilder.kt */
    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class a {
        public static /* synthetic */ e1.a a(c cVar, kotlin.j jVar, InvocationKind invocationKind, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return cVar.d(jVar, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @ContractsDsl
    @NotNull
    f a();

    @ContractsDsl
    @NotNull
    f b(@Nullable Object obj);

    @ContractsDsl
    @NotNull
    g c();

    @ContractsDsl
    @NotNull
    <R> e1.a d(@NotNull kotlin.j<? extends R> jVar, @NotNull InvocationKind invocationKind);
}
