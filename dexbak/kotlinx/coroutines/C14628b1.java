package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlinx.coroutines.internal.C15080k;
import kotlinx.coroutines.internal.Scopes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m12616d2 = {"Lkotlinx/coroutines/b1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/f0;", "", "v1", "()Z", "u1", "", "state", "Lkotlin/f1;", "Y", "(Ljava/lang/Object;)V", "k1", "t1", "()Ljava/lang/Object;", "Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.b1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14628b1<T> extends Scopes<T> {

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f41711e = AtomicIntegerFieldUpdater.newUpdater(C14628b1.class, "_decision");
    private volatile int _decision;

    public C14628b1(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        super(coroutineContext, interfaceC14268c);
        this._decision = 0;
    }

    /* renamed from: u1 */
    private final boolean m5722u1() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f41711e.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: v1 */
    private final boolean m5721v1() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f41711e.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.Scopes, kotlinx.coroutines.C15125l2
    /* renamed from: Y */
    public void mo4052Y(@Nullable Object obj) {
        mo3590k1(obj);
    }

    @Override // kotlinx.coroutines.internal.Scopes, kotlinx.coroutines.AbstractCoroutine
    /* renamed from: k1 */
    protected void mo3590k1(@Nullable Object obj) {
        InterfaceC14268c m8650d;
        if (m5722u1()) {
            return;
        }
        m8650d = IntrinsicsJvm.m8650d(this.f43040d);
        C15080k.m4293g(m8650d, C15063i0.m4406a(obj, this.f43040d), null, 2, null);
    }

    @Nullable
    /* renamed from: t1 */
    public final Object m5723t1() {
        Object m8642h;
        if (m5721v1()) {
            m8642h = C14287b.m8642h();
            return m8642h;
        }
        Object m3973o = C15134m2.m3973o(m4014y0());
        if (m3973o instanceof CompletionState) {
            throw ((CompletionState) m3973o).f42189a;
        }
        return m3973o;
    }
}
