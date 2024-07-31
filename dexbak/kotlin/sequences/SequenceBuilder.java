package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00060\u0017j\u0002`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m12616d2 = {"Lkotlin/sequences/n;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/o;", "", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "k", "()Ljava/lang/Object;", "", "i", "", "hasNext", "next", DomainCampaignEx.LOOPBACK_VALUE, "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "iterator", "g", "(Ljava/util/Iterator;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Result;", CommonNetImpl.RESULT, "resumeWith", "(Ljava/lang/Object;)V", "", "Lkotlin/sequences/State;", "a", "I", "state", "b", "Ljava/lang/Object;", "nextValue", "Ljava/util/Iterator;", "nextIterator", "d", "Lkotlin/coroutines/c;", "j", "()Lkotlin/coroutines/c;", C7304t.f25048d, "(Lkotlin/coroutines/c;)V", "nextStep", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SequenceBuilder<T> extends AbstractC14514o<T> implements Iterator<T>, InterfaceC14268c<Unit>, KMarkers {

    /* renamed from: a */
    private int f41467a;

    /* renamed from: b */
    private T f41468b;

    /* renamed from: c */
    private Iterator<? extends T> f41469c;
    @Nullable

    /* renamed from: d */
    private InterfaceC14268c<? super Unit> f41470d;

    /* renamed from: i */
    private final Throwable m7022i() {
        int i = this.f41467a;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.f41467a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    /* renamed from: k */
    private final T m7020k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.AbstractC14514o
    @Nullable
    /* renamed from: c */
    public Object mo7018c(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        this.f41468b = t;
        this.f41467a = 3;
        this.f41470d = interfaceC14268c;
        m8642h = C14287b.m8642h();
        m8642h2 = C14287b.m8642h();
        if (m8642h == m8642h2) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        m8642h3 = C14287b.m8642h();
        return m8642h == m8642h3 ? m8642h : Unit.f41048a;
    }

    @Override // kotlin.sequences.AbstractC14514o
    @Nullable
    /* renamed from: g */
    public Object mo7016g(@NotNull Iterator<? extends T> it, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m8642h2;
        Object m8642h3;
        if (it.hasNext()) {
            this.f41469c = it;
            this.f41467a = 2;
            this.f41470d = interfaceC14268c;
            m8642h = C14287b.m8642h();
            m8642h2 = C14287b.m8642h();
            if (m8642h == m8642h2) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            m8642h3 = C14287b.m8642h();
            return m8642h == m8642h3 ? m8642h : Unit.f41048a;
        }
        return Unit.f41048a;
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.f41467a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw m7022i();
                }
                Iterator<? extends T> it = this.f41469c;
                C14342f0.m8187m(it);
                if (it.hasNext()) {
                    this.f41467a = 2;
                    return true;
                }
                this.f41469c = null;
            }
            this.f41467a = 5;
            InterfaceC14268c<? super Unit> interfaceC14268c = this.f41470d;
            C14342f0.m8187m(interfaceC14268c);
            this.f41470d = null;
            Unit unit = Unit.f41048a;
            Result.C14124a c14124a = Result.Companion;
            interfaceC14268c.resumeWith(Result.m60148constructorimpl(unit));
        }
    }

    @Nullable
    /* renamed from: j */
    public final InterfaceC14268c<Unit> m7021j() {
        return this.f41470d;
    }

    /* renamed from: l */
    public final void m7019l(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
        this.f41470d = interfaceC14268c;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.f41467a;
        if (i == 0 || i == 1) {
            return m7020k();
        }
        if (i == 2) {
            this.f41467a = 1;
            Iterator<? extends T> it = this.f41469c;
            C14342f0.m8187m(it);
            return it.next();
        } else if (i == 3) {
            this.f41467a = 0;
            T t = this.f41468b;
            this.f41468b = null;
            return t;
        } else {
            throw m7022i();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.InterfaceC14268c
    public void resumeWith(@NotNull Object obj) {
        C14294d0.m8596n(obj);
        this.f41467a = 4;
    }
}
