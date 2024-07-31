package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Atomic.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m12616d2 = {"Lkotlinx/coroutines/internal/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/c0;", "", "decision", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "i", "failure", "Lkotlin/f1;", "d", "(Ljava/lang/Object;Ljava/lang/Object;)V", "c", "f", "()Ljava/lang/Object;", "consensus", "", "h", "()Z", "isDecided", "", "g", "()J", "opSequence", "a", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15074d<T> extends AbstractC15073c0 {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f43035a = AtomicReferenceFieldUpdater.newUpdater(AbstractC15074d.class, Object.class, "_consensus");
    private volatile Object _consensus = C15072c.f43033a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC15073c0
    @NotNull
    /* renamed from: a */
    public AbstractC15074d<?> mo3621a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC15073c0
    @Nullable
    /* renamed from: c */
    public final Object mo3620c(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == C15072c.f43033a) {
            obj2 = m4373e(mo3615i(obj));
        }
        mo3619d(obj, obj2);
        return obj2;
    }

    /* renamed from: d */
    public abstract void mo3619d(T t, @Nullable Object obj);

    @Nullable
    /* renamed from: e */
    public final Object m4373e(@Nullable Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = C15072c.f43033a;
        return obj2 != obj3 ? obj2 : C13675a.m12692a(f43035a, this, obj3, obj) ? obj : this._consensus;
    }

    @Nullable
    /* renamed from: f */
    public final Object m4372f() {
        return this._consensus;
    }

    /* renamed from: g */
    public long mo3711g() {
        return 0L;
    }

    /* renamed from: h */
    public final boolean m4371h() {
        return this._consensus != C15072c.f43033a;
    }

    @Nullable
    /* renamed from: i */
    public abstract Object mo3615i(T t);
}
