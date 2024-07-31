package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15137n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: OnUndeliveredElement.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001aE\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0011"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "c", "(Ll1/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "Lkotlin/coroutines/f;", "context", "b", "(Ll1/l;Ljava/lang/Object;Lkotlin/coroutines/f;)V", "", "a", "(Ll1/l;Ljava/lang/Object;Lkotlin/coroutines/f;)Ll1/l;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15070b0 {

    /* compiled from: OnUndeliveredElement.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "<anonymous parameter 0>", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.b0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15071a extends Lambda implements InterfaceC15280l<Throwable, Unit> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l f43030a;

        /* renamed from: b */
        final /* synthetic */ Object f43031b;

        /* renamed from: c */
        final /* synthetic */ CoroutineContext f43032c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15071a(InterfaceC15280l interfaceC15280l, Object obj, CoroutineContext coroutineContext) {
            super(1);
            this.f43030a = interfaceC15280l;
            this.f43031b = obj;
            this.f43032c = coroutineContext;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            C15070b0.m4379b(this.f43030a, this.f43031b, this.f43032c);
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <E> InterfaceC15280l<Throwable, Unit> m4380a(@NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l, E e, @NotNull CoroutineContext coroutineContext) {
        return new C15071a(interfaceC15280l, e, coroutineContext);
    }

    /* renamed from: b */
    public static final <E> void m4379b(@NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l, E e, @NotNull CoroutineContext coroutineContext) {
        OnUndeliveredElement m4378c = m4378c(interfaceC15280l, e, null);
        if (m4378c != null) {
            C15137n0.m3969b(coroutineContext, m4378c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* renamed from: c */
    public static final <E> OnUndeliveredElement m4378c(@NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l, E e, @Nullable OnUndeliveredElement onUndeliveredElement) {
        try {
            interfaceC15280l.invoke(e);
        } catch (Throwable th) {
            if (onUndeliveredElement != null && onUndeliveredElement.getCause() != th) {
                C14305i.m8548a(onUndeliveredElement, th);
            } else {
                return new OnUndeliveredElement("Exception in undelivered element handler for " + e, th);
            }
        }
        return onUndeliveredElement;
    }

    /* renamed from: d */
    public static /* synthetic */ OnUndeliveredElement m4377d(InterfaceC15280l interfaceC15280l, Object obj, OnUndeliveredElement onUndeliveredElement, int i, Object obj2) {
        if ((i & 2) != 0) {
            onUndeliveredElement = null;
        }
        return m4378c(interfaceC15280l, obj, onUndeliveredElement);
    }
}
