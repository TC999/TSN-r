package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections._ArraysJvm;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.InterfaceC15102t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b0\u0010\u0012J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082\u0010¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\u0002¢\u0006\u0004\b\u0007\u0010\rJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0014J&\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00028\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010$\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0001¢\u0006\u0004\b&\u0010\u001dR \u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00068F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\nR\u0011\u0010/\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00061"}, m12616d2 = {"Lkotlinx/coroutines/internal/s0;", "Lkotlinx/coroutines/internal/t0;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "i", "Lkotlin/f1;", "p", "(I)V", "o", "", "()[Lkotlinx/coroutines/internal/t0;", "j", CampaignEx.JSON_KEY_AD_Q, "(II)V", "d", "()V", "h", "()Lkotlinx/coroutines/internal/t0;", "m", "Lkotlin/Function1;", "", "predicate", C7304t.f25048d, "(Ll1/l;)Lkotlinx/coroutines/internal/t0;", "node", "b", "(Lkotlinx/coroutines/internal/t0;)V", "cond", "c", "(Lkotlinx/coroutines/internal/t0;Ll1/l;)Z", "(Lkotlinx/coroutines/internal/t0;)Z", "e", "index", "k", "(I)Lkotlinx/coroutines/internal/t0;", "a", "[Lkotlinx/coroutines/internal/t0;", DomainCampaignEx.LOOPBACK_VALUE, "f", "()I", "n", "size", "g", "()Z", "isEmpty", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.s0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ThreadSafeHeap<T extends InterfaceC15102t0 & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a */
    private T[] f43099a;

    /* renamed from: i */
    private final T[] m4179i() {
        T[] tArr = this.f43099a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new InterfaceC15102t0[4];
            this.f43099a = tArr2;
            return tArr2;
        } else if (m4182f() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, m4182f() * 2);
            C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((InterfaceC15102t0[]) copyOf);
            this.f43099a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    /* renamed from: n */
    private final void m4174n(int i) {
        this._size = i;
    }

    /* renamed from: o */
    private final void m4173o(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= m4182f()) {
                return;
            }
            T[] tArr = this.f43099a;
            C14342f0.m8187m(tArr);
            int i3 = i2 + 1;
            if (i3 < m4182f()) {
                T t = tArr[i3];
                C14342f0.m8187m(t);
                T t2 = tArr[i2];
                C14342f0.m8187m(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            C14342f0.m8187m(t3);
            T t4 = tArr[i2];
            C14342f0.m8187m(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m4171q(i, i2);
            i = i2;
        }
    }

    /* renamed from: p */
    private final void m4172p(int i) {
        while (i > 0) {
            T[] tArr = this.f43099a;
            C14342f0.m8187m(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            C14342f0.m8187m(t);
            T t2 = tArr[i];
            C14342f0.m8187m(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m4171q(i, i2);
            i = i2;
        }
    }

    /* renamed from: q */
    private final void m4171q(int i, int i2) {
        T[] tArr = this.f43099a;
        C14342f0.m8187m(tArr);
        T t = tArr[i2];
        C14342f0.m8187m(t);
        T t2 = tArr[i];
        C14342f0.m8187m(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.mo3556d(i);
        t2.mo3556d(i2);
    }

    @PublishedApi
    /* renamed from: a */
    public final void m4187a(@NotNull T t) {
        t.mo3559a(this);
        T[] m4179i = m4179i();
        int m4182f = m4182f();
        m4174n(m4182f + 1);
        m4179i[m4182f] = t;
        t.mo3556d(m4182f);
        m4172p(m4182f);
    }

    /* renamed from: b */
    public final void m4186b(@NotNull T t) {
        synchronized (this) {
            m4187a(t);
            Unit unit = Unit.f41048a;
        }
    }

    /* renamed from: c */
    public final boolean m4185c(@NotNull T t, @NotNull InterfaceC15280l<? super T, Boolean> interfaceC15280l) {
        boolean z;
        synchronized (this) {
            try {
                if (interfaceC15280l.invoke(m4183e()).booleanValue()) {
                    m4187a(t);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.m8228d(1);
            } catch (Throwable th) {
                InlineMarker.m8228d(1);
                InlineMarker.m8229c(1);
                throw th;
            }
        }
        InlineMarker.m8229c(1);
        return z;
    }

    /* renamed from: d */
    public final void m4184d() {
        synchronized (this) {
            T[] tArr = this.f43099a;
            if (tArr != null) {
                _ArraysJvm.m11519w2(tArr, null, 0, 0, 6, null);
            }
            this._size = 0;
            Unit unit = Unit.f41048a;
        }
    }

    @PublishedApi
    @Nullable
    /* renamed from: e */
    public final T m4183e() {
        T[] tArr = this.f43099a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* renamed from: f */
    public final int m4182f() {
        return this._size;
    }

    /* renamed from: g */
    public final boolean m4181g() {
        return m4182f() == 0;
    }

    @Nullable
    /* renamed from: h */
    public final T m4180h() {
        T m4183e;
        synchronized (this) {
            m4183e = m4183e();
        }
        return m4183e;
    }

    /* renamed from: j */
    public final boolean m4178j(@NotNull T t) {
        boolean z;
        synchronized (this) {
            if (t.mo3557c() == null) {
                z = false;
            } else {
                m4177k(t.mo3558b());
                z = true;
            }
        }
        return z;
    }

    @PublishedApi
    @NotNull
    /* renamed from: k */
    public final T m4177k(int i) {
        T[] tArr = this.f43099a;
        C14342f0.m8187m(tArr);
        m4174n(m4182f() - 1);
        if (i < m4182f()) {
            m4171q(i, m4182f());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                C14342f0.m8187m(t);
                T t2 = tArr[i2];
                C14342f0.m8187m(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m4171q(i, i2);
                    m4172p(i2);
                }
            }
            m4173o(i);
        }
        T t3 = tArr[m4182f()];
        C14342f0.m8187m(t3);
        t3.mo3559a(null);
        t3.mo3556d(-1);
        tArr[m4182f()] = null;
        return t3;
    }

    @Nullable
    /* renamed from: l */
    public final T m4176l(@NotNull InterfaceC15280l<? super T, Boolean> interfaceC15280l) {
        synchronized (this) {
            try {
                T m4183e = m4183e();
                if (m4183e != null) {
                    T m4177k = interfaceC15280l.invoke(m4183e).booleanValue() ? m4177k(0) : null;
                    InlineMarker.m8228d(1);
                    InlineMarker.m8229c(1);
                    return m4177k;
                }
                InlineMarker.m8228d(2);
                InlineMarker.m8229c(2);
                return null;
            } catch (Throwable th) {
                InlineMarker.m8228d(1);
                InlineMarker.m8229c(1);
                throw th;
            }
        }
    }

    @Nullable
    /* renamed from: m */
    public final T m4175m() {
        T m4177k;
        synchronized (this) {
            m4177k = m4182f() > 0 ? m4177k(0) : null;
        }
        return m4177k;
    }
}
