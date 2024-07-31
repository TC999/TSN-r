package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CompletionState.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u000e\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "", "c", "(Ljava/lang/Object;Ll1/l;)Ljava/lang/Object;", "Lkotlinx/coroutines/o;", "caller", "b", "(Ljava/lang/Object;Lkotlinx/coroutines/o;)Ljava/lang/Object;", "state", "Lkotlin/coroutines/c;", "uCont", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.i0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15063i0 {
    @NotNull
    /* renamed from: a */
    public static final <T> Object m4406a(@Nullable Object obj, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        if (obj instanceof CompletionState) {
            Result.C14124a c14124a = Result.Companion;
            return Result.m60148constructorimpl(C14294d0.m8609a(((CompletionState) obj).f42189a));
        }
        Result.C14124a c14124a2 = Result.Companion;
        return Result.m60148constructorimpl(obj);
    }

    @Nullable
    /* renamed from: b */
    public static final <T> Object m4405b(@NotNull Object obj, @NotNull InterfaceC15146o<?> interfaceC15146o) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        return m60151exceptionOrNullimpl == null ? obj : new CompletionState(m60151exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    /* renamed from: c */
    public static final <T> Object m4404c(@NotNull Object obj, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl == null) {
            return interfaceC15280l != null ? new C14774e0(obj, interfaceC15280l) : obj;
        }
        return new CompletionState(m60151exceptionOrNullimpl, false, 2, null);
    }

    /* renamed from: d */
    public static /* synthetic */ Object m4403d(Object obj, InterfaceC15280l interfaceC15280l, int i, Object obj2) {
        if ((i & 1) != 0) {
            interfaceC15280l = null;
        }
        return m4404c(obj, interfaceC15280l);
    }
}
