package p649u1;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.C15080k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Cancellable.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a#\u0010\u0016\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/f1;", "c", "(Ll1/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", SocialConstants.PARAM_RECEIVER, "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "d", "(Ll1/p;Ljava/lang/Object;Lkotlin/coroutines/c;Ll1/l;)V", "fatalCompletion", "b", "Lkotlin/Function0;", "block", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: u1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C16231a {
    /* renamed from: a */
    private static final void m230a(InterfaceC14268c<?> interfaceC14268c, InterfaceC15269a<Unit> interfaceC15269a) {
        try {
            interfaceC15269a.invoke();
        } catch (Throwable th) {
            Result.C14124a c14124a = Result.Companion;
            interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: b */
    public static final void m229b(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c, @NotNull InterfaceC14268c<?> interfaceC14268c2) {
        InterfaceC14268c m8650d;
        try {
            m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
            Result.C14124a c14124a = Result.Companion;
            C15080k.m4293g(m8650d, Result.m60148constructorimpl(Unit.f41048a), null, 2, null);
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            interfaceC14268c2.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    @InternalCoroutinesApi
    /* renamed from: c */
    public static final <T> void m228c(@NotNull InterfaceC15280l<? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15280l, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        InterfaceC14268c m8652b;
        InterfaceC14268c m8650d;
        try {
            m8652b = IntrinsicsJvm.m8652b(interfaceC15280l, interfaceC14268c);
            m8650d = IntrinsicsJvm.m8650d(m8652b);
            Result.C14124a c14124a = Result.Companion;
            C15080k.m4293g(m8650d, Result.m60148constructorimpl(Unit.f41048a), null, 2, null);
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: d */
    public static final <R, T> void m227d(@NotNull InterfaceC15284p<? super R, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, R r, @NotNull InterfaceC14268c<? super T> interfaceC14268c, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        InterfaceC14268c m8651c;
        InterfaceC14268c m8650d;
        try {
            m8651c = IntrinsicsJvm.m8651c(interfaceC15284p, r, interfaceC14268c);
            m8650d = IntrinsicsJvm.m8650d(m8651c);
            Result.C14124a c14124a = Result.Companion;
            C15080k.m4294f(m8650d, Result.m60148constructorimpl(Unit.f41048a), interfaceC15280l);
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            interfaceC14268c.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th)));
        }
    }

    /* renamed from: e */
    public static /* synthetic */ void m226e(InterfaceC15284p interfaceC15284p, Object obj, InterfaceC14268c interfaceC14268c, InterfaceC15280l interfaceC15280l, int i, Object obj2) {
        if ((i & 4) != 0) {
            interfaceC15280l = null;
        }
        m227d(interfaceC15284p, obj, interfaceC14268c, interfaceC15280l);
    }
}
