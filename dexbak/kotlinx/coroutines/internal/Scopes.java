package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.C15063i0;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/internal/f0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "", "state", "Lkotlin/f1;", "Y", "k1", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "uCont", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "", "E0", "()Z", "isScopedCoroutine", "Lkotlinx/coroutines/e2;", "s1", "()Lkotlinx/coroutines/e2;", "parent", "Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Scopes<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    public final InterfaceC14268c<T> f43040d;

    /* JADX WARN: Multi-variable type inference failed */
    public Scopes(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        super(coroutineContext, true);
        this.f43040d = interfaceC14268c;
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: E0 */
    protected final boolean mo4075E0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: Y */
    public void mo4052Y(@Nullable Object obj) {
        InterfaceC14268c m8650d;
        m8650d = IntrinsicsJvm.m8650d(this.f43040d);
        C15080k.m4293g(m8650d, C15063i0.m4406a(obj, this.f43040d), null, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final CoroutineStackFrame getCallerFrame() {
        return (CoroutineStackFrame) this.f43040d;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: k1 */
    protected void mo3590k1(@Nullable Object obj) {
        InterfaceC14268c<T> interfaceC14268c = this.f43040d;
        interfaceC14268c.resumeWith(C15063i0.m4406a(obj, interfaceC14268c));
    }

    @Nullable
    /* renamed from: s1 */
    public final Job m4359s1() {
        return (Job) this.f41687c.get(Job.f42281m0);
    }
}
