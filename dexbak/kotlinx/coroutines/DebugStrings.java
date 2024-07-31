package kotlinx.coroutines;

import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, m12616d2 = {"Lkotlin/coroutines/c;", "", "c", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "a", "classSimpleName", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.u0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DebugStrings {
    @NotNull
    /* renamed from: a */
    public static final String m3554a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    /* renamed from: b */
    public static final String m3553b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    /* renamed from: c */
    public static final String m3552c(@NotNull InterfaceC14268c<?> interfaceC14268c) {
        String m60148constructorimpl;
        if (interfaceC14268c instanceof DispatchedContinuation) {
            return interfaceC14268c.toString();
        }
        try {
            Result.C14124a c14124a = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(interfaceC14268c + '@' + m3553b(interfaceC14268c));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        if (Result.m60151exceptionOrNullimpl(m60148constructorimpl) != null) {
            m60148constructorimpl = interfaceC14268c.getClass().getName() + '@' + m3553b(interfaceC14268c);
        }
        return (String) m60148constructorimpl;
    }
}
