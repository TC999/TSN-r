package p586e1;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.contracts.ExperimentalContracts;
import kotlin.contracts.InvocationKind;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H'J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\u0007\u001a\u00020\u0006H'J&\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH'¨\u0006\u000f"}, m12616d2 = {"Le1/c;", "", "Le1/f;", "a", DomainCampaignEx.LOOPBACK_VALUE, "b", "Le1/g;", "c", "R", "Lkotlin/j;", "lambda", "Lkotlin/contracts/InvocationKind;", "kind", "Le1/a;", "d", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalContracts
/* renamed from: e1.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface ContractBuilder {

    /* compiled from: ContractBuilder.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: e1.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13576a {
        /* renamed from: a */
        public static /* synthetic */ Effect m12819a(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return contractBuilder.m12820d(function, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @ContractsDsl
    @NotNull
    /* renamed from: a */
    InterfaceC13578f m12823a();

    @ContractsDsl
    @NotNull
    /* renamed from: b */
    InterfaceC13578f m12822b(@Nullable Object obj);

    @ContractsDsl
    @NotNull
    /* renamed from: c */
    InterfaceC13579g m12821c();

    @ContractsDsl
    @NotNull
    /* renamed from: d */
    <R> Effect m12820d(@NotNull Function<? extends R> function, @NotNull InvocationKind invocationKind);
}
