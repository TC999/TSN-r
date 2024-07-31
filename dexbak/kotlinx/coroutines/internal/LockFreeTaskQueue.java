package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import io.netty.channel.C13675a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0001\u0010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, m12616d2 = {"Lkotlinx/coroutines/internal/u;", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/f1;", "b", "()V", "element", "", "a", "(Ljava/lang/Object;)Z", "g", "()Ljava/lang/Object;", "R", "Lkotlin/Function1;", "transform", "", "f", "(Ll1/l;)Ljava/util/List;", "d", "()Z", "e", "isEmpty", "", "c", "()I", "size", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.u */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class LockFreeTaskQueue<E> {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f43101a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile Object _cur;

    public LockFreeTaskQueue(boolean z) {
        this._cur = new C15104v(8, z);
    }

    /* renamed from: a */
    public final boolean m4169a(@NotNull E e) {
        while (true) {
            C15104v c15104v = (C15104v) this._cur;
            int m4159a = c15104v.m4159a(e);
            if (m4159a == 0) {
                return true;
            }
            if (m4159a == 1) {
                C13675a.m12692a(f43101a, this, c15104v, c15104v.m4149k());
            } else if (m4159a == 2) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m4168b() {
        while (true) {
            C15104v c15104v = (C15104v) this._cur;
            if (c15104v.m4156d()) {
                return;
            }
            C13675a.m12692a(f43101a, this, c15104v, c15104v.m4149k());
        }
    }

    /* renamed from: c */
    public final int m4167c() {
        return ((C15104v) this._cur).m4154f();
    }

    /* renamed from: d */
    public final boolean m4166d() {
        return ((C15104v) this._cur).m4153g();
    }

    /* renamed from: e */
    public final boolean m4165e() {
        return ((C15104v) this._cur).m4152h();
    }

    @NotNull
    /* renamed from: f */
    public final <R> List<R> m4164f(@NotNull InterfaceC15280l<? super E, ? extends R> interfaceC15280l) {
        return ((C15104v) this._cur).m4151i(interfaceC15280l);
    }

    @Nullable
    /* renamed from: g */
    public final E m4163g() {
        while (true) {
            C15104v c15104v = (C15104v) this._cur;
            E e = (E) c15104v.m4148l();
            if (e != C15104v.f43119s) {
                return e;
            }
            C13675a.m12692a(f43101a, this, c15104v, c15104v.m4149k());
        }
    }
}
