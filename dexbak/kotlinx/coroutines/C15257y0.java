package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.selects.InterfaceC15195d;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m12616d2 = {"Lkotlinx/coroutines/y0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "Lkotlinx/coroutines/x0;", "Lkotlinx/coroutines/selects/d;", "g", "()Ljava/lang/Object;", "m", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "k", "(Lkotlinx/coroutines/selects/f;Ll1/p;)V", "D", "()Lkotlinx/coroutines/selects/d;", "onAwait", "Lkotlin/coroutines/f;", "parentContext", "", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.y0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15257y0<T> extends AbstractCoroutine<T> implements Deferred<T>, InterfaceC15195d<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Builders.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0096@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "continuation", "", "await"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.DeferredCoroutine", m8638f = "Builders.common.kt", m8637i = {0}, m8636l = {101}, m8635m = "await$suspendImpl", m8634n = {"this"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.y0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15258a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f43450a;

        /* renamed from: b */
        int f43451b;

        /* renamed from: d */
        Object f43453d;

        C15258a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f43450a = obj;
            this.f43451b |= Integer.MIN_VALUE;
            return C15257y0.m3497s1(C15257y0.this, this);
        }
    }

    public C15257y0(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* renamed from: s1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m3497s1(kotlinx.coroutines.C15257y0 r4, kotlin.coroutines.InterfaceC14268c r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.C15257y0.C15258a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.y0$a r0 = (kotlinx.coroutines.C15257y0.C15258a) r0
            int r1 = r0.f43451b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f43451b = r1
            goto L18
        L13:
            kotlinx.coroutines.y0$a r0 = new kotlinx.coroutines.y0$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f43450a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f43451b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f43453d
            kotlinx.coroutines.y0 r4 = (kotlinx.coroutines.C15257y0) r4
            kotlin.C14294d0.m8596n(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C14294d0.m8596n(r5)
            r0.f43453d = r4
            r0.f43451b = r3
            java.lang.Object r5 = r4.m4050Z(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C15257y0.m3497s1(kotlinx.coroutines.y0, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.Deferred
    @NotNull
    /* renamed from: D */
    public InterfaceC15195d<T> mo3494D() {
        return this;
    }

    @Override // kotlinx.coroutines.Deferred
    /* renamed from: g */
    public T mo3492g() {
        return (T) m4022p0();
    }

    @Override // kotlinx.coroutines.selects.InterfaceC15195d
    /* renamed from: k */
    public <R> void mo3491k(@NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        m4055W0(interfaceC15197f, interfaceC15284p);
    }

    @Override // kotlinx.coroutines.Deferred
    @Nullable
    /* renamed from: m */
    public Object mo3490m(@NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        return m3497s1(this, interfaceC14268c);
    }
}
