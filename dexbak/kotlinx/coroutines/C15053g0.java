package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CompletionHandler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0005*#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0080\b\":\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\b8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\":\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\f8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m12616d2 = {"Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "c", "Lkotlinx/coroutines/f0;", "b", "(Lkotlinx/coroutines/f0;)Ll1/l;", "asHandler", "Lkotlinx/coroutines/n;", "a", "(Lkotlinx/coroutines/n;)Ll1/l;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.g0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15053g0 {
    @NotNull
    /* renamed from: a */
    public static final InterfaceC15280l<Throwable, Unit> m4458a(@NotNull AbstractC15136n abstractC15136n) {
        return abstractC15136n;
    }

    @NotNull
    /* renamed from: b */
    public static final InterfaceC15280l<Throwable, Unit> m4457b(@NotNull CompletionHandler completionHandler) {
        return completionHandler;
    }

    /* renamed from: c */
    public static final void m4456c(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Nullable Throwable th) {
        interfaceC15280l.invoke(th);
    }
}
