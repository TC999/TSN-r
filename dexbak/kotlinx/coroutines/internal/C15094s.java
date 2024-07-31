package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: LockFreeLinkedList.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001:\u0005JKLMNB\u0007¢\u0006\u0004\bI\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0016\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0081\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u001a\u0010\fJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\f\b\u0000\u0010\u001b*\u00060\u0000j\u0002`\u00052\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b\u001f\u0010 J4\u0010#\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!H\u0086\b¢\u0006\u0004\b#\u0010$JD\u0010%\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b'\u0010(J/\u0010+\u001a\u00020*2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010)\u001a\u00020\u0015H\u0001¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0013H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0001¢\u0006\u0004\b3\u00102J\u0015\u00104\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b4\u00100J\u0017\u00106\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000505¢\u0006\u0004\b6\u00107J.\u00108\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001b\u0018\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130!H\u0086\b¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0014¢\u0006\u0004\b:\u00100J'\u0010<\u001a\u00020\n2\n\u0010;\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0000¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010.R\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0015\u0010F\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\bE\u00100R\u0015\u0010H\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\bG\u00100¨\u0006O"}, m12616d2 = {"Lkotlinx/coroutines/internal/s;", "", "Lkotlinx/coroutines/internal/e0;", "c0", "()Lkotlinx/coroutines/internal/e0;", "Lkotlinx/coroutines/internal/Node;", "current", "M", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/internal/s;", "next", "Lkotlin/f1;", "O", "(Lkotlinx/coroutines/internal/s;)V", "Lkotlinx/coroutines/internal/c0;", "op", "H", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/s$c;", ExifInterface.LONGITUDE_WEST, "(Lkotlinx/coroutines/internal/s;Ll1/a;)Lkotlinx/coroutines/internal/s$c;", "G", "(Lkotlinx/coroutines/internal/s;)Z", "B", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/s$b;", "K", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/internal/s$b;", "C", "(Lkotlinx/coroutines/internal/s;Ll1/a;)Z", "Lkotlin/Function1;", "predicate", "D", "(Lkotlinx/coroutines/internal/s;Ll1/l;)Z", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/internal/s;Ll1/l;Ll1/a;)Z", "F", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Z", "condAdd", "", "d0", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s$c;)I", "Y", "()Z", "b0", "()Lkotlinx/coroutines/internal/s;", ExifInterface.LATITUDE_SOUTH, "()V", "U", "a0", "Lkotlinx/coroutines/internal/s$e;", "L", "()Lkotlinx/coroutines/internal/s$e;", "Z", "(Ll1/l;)Ljava/lang/Object;", "X", "prev", "e0", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "", "toString", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "isRemoved", "P", "()Ljava/lang/Object;", "Q", "nextNode", "R", "prevNode", "<init>", "a", "b", "c", "d", "e", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.s */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15094s {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater f43083a = AtomicReferenceFieldUpdater.newUpdater(C15094s.class, Object.class, "_next");

    /* renamed from: b */
    static final AtomicReferenceFieldUpdater f43084b = AtomicReferenceFieldUpdater.newUpdater(C15094s.class, Object.class, "_prev");

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f43085c = AtomicReferenceFieldUpdater.newUpdater(C15094s.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0014J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\n\u001a\u00020\bH\u0014J \u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H$J \u0010\u000f\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0014\u0010\u0014\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0015J\u001c\u0010\u0018\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u001c\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006 "}, m12616d2 = {"Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/c0;", "op", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "m", "affected", "", "e", "next", "", C7304t.f25048d, "Lkotlin/f1;", "f", "n", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "g", "j", "k", "Lkotlinx/coroutines/internal/d;", "c", "failure", "a", "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.s$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15095a extends Atomic {
        @Override // kotlinx.coroutines.internal.Atomic
        /* renamed from: a */
        public final void mo3623a(@NotNull AbstractC15074d<?> abstractC15074d, @Nullable Object obj) {
            C15094s mo4194i;
            boolean z = obj == null;
            C15094s mo4195h = mo4195h();
            if (mo4195h == null || (mo4194i = mo4194i()) == null) {
                return;
            }
            if (C13675a.m12692a(C15094s.f43083a, mo4195h, abstractC15074d, z ? mo4191n(mo4195h, mo4194i) : mo4194i) && z) {
                mo4197f(mo4195h, mo4194i);
            }
        }

        @Override // kotlinx.coroutines.internal.Atomic
        @Nullable
        /* renamed from: c */
        public final Object mo3622c(@NotNull AbstractC15074d<?> abstractC15074d) {
            while (true) {
                C15094s mo4192m = mo4192m(abstractC15074d);
                if (mo4192m != null) {
                    Object obj = mo4192m._next;
                    if (obj == abstractC15074d || abstractC15074d.m4371h()) {
                        return null;
                    }
                    if (obj instanceof AbstractC15073c0) {
                        AbstractC15073c0 abstractC15073c0 = (AbstractC15073c0) obj;
                        if (abstractC15074d.m4374b(abstractC15073c0)) {
                            return C15072c.f43034b;
                        }
                        abstractC15073c0.mo3620c(mo4192m);
                    } else {
                        Object mo4198e = mo4198e(mo4192m);
                        if (mo4198e != null) {
                            return mo4198e;
                        }
                        if (mo4193l(mo4192m, obj)) {
                            continue;
                        } else if (obj != null) {
                            C15098d c15098d = new C15098d(mo4192m, (C15094s) obj, this);
                            if (C13675a.m12692a(C15094s.f43083a, mo4192m, obj, c15098d)) {
                                try {
                                    if (c15098d.mo3620c(mo4192m) != C15101t.f43100a) {
                                        return null;
                                    }
                                } catch (Throwable th) {
                                    C13675a.m12692a(C15094s.f43083a, mo4192m, c15098d, obj);
                                    throw th;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    }
                } else {
                    return C15072c.f43034b;
                }
            }
        }

        @Nullable
        /* renamed from: e */
        protected Object mo4198e(@NotNull C15094s c15094s) {
            return null;
        }

        /* renamed from: f */
        protected abstract void mo4197f(@NotNull C15094s c15094s, @NotNull C15094s c15094s2);

        /* renamed from: g */
        public abstract void mo4196g(@NotNull C15098d c15098d);

        @Nullable
        /* renamed from: h */
        protected abstract C15094s mo4195h();

        @Nullable
        /* renamed from: i */
        protected abstract C15094s mo4194i();

        @Nullable
        /* renamed from: j */
        public Object mo4202j(@NotNull C15098d c15098d) {
            mo4196g(c15098d);
            return null;
        }

        /* renamed from: k */
        public void mo4201k(@NotNull C15094s c15094s) {
        }

        /* renamed from: l */
        protected boolean mo4193l(@NotNull C15094s c15094s, @NotNull Object obj) {
            return false;
        }

        @Nullable
        /* renamed from: m */
        protected C15094s mo4192m(@NotNull AbstractC15073c0 abstractC15073c0) {
            C15094s mo4195h = mo4195h();
            C14342f0.m8187m(mo4195h);
            return mo4195h;
        }

        @NotNull
        /* renamed from: n */
        public abstract Object mo4191n(@NotNull C15094s c15094s, @NotNull C15094s c15094s2);
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010\u0017J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00112\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001f\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006#"}, m12616d2 = {"Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/c0;", "op", "m", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "affected", "", "next", "", C7304t.f25048d, "(Lkotlinx/coroutines/internal/s;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/internal/s$d;)V", "n", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "b", "Lkotlinx/coroutines/internal/s;", "queue", "c", "node", "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.s$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15096b<T extends C15094s> extends AbstractC15095a {

        /* renamed from: d */
        private static final AtomicReferenceFieldUpdater f43086d = AtomicReferenceFieldUpdater.newUpdater(C15096b.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode = null;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final C15094s f43087b;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: c */
        public final T f43088c;

        public C15096b(@NotNull C15094s c15094s, @NotNull T t) {
            this.f43087b = c15094s;
            this.f43088c = t;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: f */
        protected void mo4197f(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
            this.f43088c.m4220O(this.f43087b);
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: g */
        public void mo4196g(@NotNull C15098d c15098d) {
            C13675a.m12692a(f43086d, this, null, c15098d.f43091a);
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: h */
        protected final C15094s mo4195h() {
            return (C15094s) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: i */
        protected final C15094s mo4194i() {
            return this.f43087b;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: l */
        protected boolean mo4193l(@NotNull C15094s c15094s, @NotNull Object obj) {
            return obj != this.f43087b;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: m */
        protected final C15094s mo4192m(@NotNull AbstractC15073c0 abstractC15073c0) {
            return this.f43087b.m4224H(abstractC15073c0);
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @NotNull
        /* renamed from: n */
        public Object mo4191n(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
            T t = this.f43088c;
            C13675a.m12692a(C15094s.f43084b, t, t, c15094s);
            T t2 = this.f43088c;
            C13675a.m12692a(C15094s.f43083a, t2, t2, this.f43087b);
            return this.f43088c;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001e\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "Lkotlin/f1;", "j", "b", "Lkotlinx/coroutines/internal/s;", "oldNext", "c", "newNode", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    @PublishedApi
    /* renamed from: kotlinx.coroutines.internal.s$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15097c extends AbstractC15074d<C15094s> {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: b */
        public C15094s f43089b;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: c */
        public final C15094s f43090c;

        public AbstractC15097c(@NotNull C15094s c15094s) {
            this.f43090c = c15094s;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        /* renamed from: j */
        public void mo3619d(@NotNull C15094s c15094s, @Nullable Object obj) {
            boolean z = obj == null;
            C15094s c15094s2 = z ? this.f43090c : this.f43089b;
            if (c15094s2 != null && C13675a.m12692a(C15094s.f43083a, c15094s, this, c15094s2) && z) {
                C15094s c15094s3 = this.f43090c;
                C15094s c15094s4 = this.f43089b;
                C14342f0.m8187m(c15094s4);
                c15094s3.m4220O(c15094s4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u000e\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u0003\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlin/f1;", "d", "", "toString", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/s;", "b", "next", "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/s$a;", "desc", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s$a;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.s$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15098d extends AbstractC15073c0 {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: a */
        public final C15094s f43091a;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final C15094s f43092b;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: c */
        public final AbstractC15095a f43093c;

        public C15098d(@NotNull C15094s c15094s, @NotNull C15094s c15094s2, @NotNull AbstractC15095a abstractC15095a) {
            this.f43091a = c15094s;
            this.f43092b = c15094s2;
            this.f43093c = abstractC15095a;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @NotNull
        /* renamed from: a */
        public AbstractC15074d<?> mo3621a() {
            return this.f43093c.m4382b();
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @Nullable
        /* renamed from: c */
        public Object mo3620c(@Nullable Object obj) {
            Object m4372f;
            Object obj2;
            if (obj != null) {
                C15094s c15094s = (C15094s) obj;
                Object mo4202j = this.f43093c.mo4202j(this);
                Object obj3 = C15101t.f43100a;
                if (mo4202j == obj3) {
                    C15094s c15094s2 = this.f43092b;
                    if (C13675a.m12692a(C15094s.f43083a, c15094s, this, c15094s2.m4207c0())) {
                        this.f43093c.mo4201k(c15094s);
                        c15094s2.m4224H(null);
                    }
                    return obj3;
                }
                if (mo4202j != null) {
                    m4372f = mo3621a().m4373e(mo4202j);
                } else {
                    m4372f = mo3621a().m4372f();
                }
                if (m4372f == C15072c.f43033a) {
                    obj2 = mo3621a();
                } else if (m4372f == null) {
                    obj2 = this.f43093c.mo4191n(c15094s, this.f43092b);
                } else {
                    obj2 = this.f43092b;
                }
                C13675a.m12692a(C15094s.f43083a, c15094s, this, obj2);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        /* renamed from: d */
        public final void m4199d() {
            this.f43093c.mo4196g(this);
        }

        @Override // kotlinx.coroutines.internal.AbstractC15073c0
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + mo3621a() + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u0005j\u0002`\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006)"}, m12616d2 = {"Lkotlinx/coroutines/internal/s$e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/c0;", "op", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "m", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "affected", "", "e", "(Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "next", "", C7304t.f25048d, "(Lkotlinx/coroutines/internal/s;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/internal/s$d;)V", "n", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "b", "Lkotlinx/coroutines/internal/s;", "queue", "o", "()Ljava/lang/Object;", "getResult$annotations", "()V", CommonNetImpl.RESULT, "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.s$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15099e<T> extends AbstractC15095a {

        /* renamed from: c */
        private static final AtomicReferenceFieldUpdater f43094c = AtomicReferenceFieldUpdater.newUpdater(C15099e.class, Object.class, "_affectedNode");

        /* renamed from: d */
        private static final AtomicReferenceFieldUpdater f43095d = AtomicReferenceFieldUpdater.newUpdater(C15099e.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: b */
        public final C15094s f43096b;

        public C15099e(@NotNull C15094s c15094s) {
            this.f43096b = c15094s;
        }

        /* renamed from: p */
        public static /* synthetic */ void m4189p() {
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: e */
        protected Object mo4198e(@NotNull C15094s c15094s) {
            if (c15094s == this.f43096b) {
                return C15093r.m4237d();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: f */
        protected final void mo4197f(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
            c15094s2.m4224H(null);
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: g */
        public void mo4196g(@NotNull C15098d c15098d) {
            C13675a.m12692a(f43094c, this, null, c15098d.f43091a);
            C13675a.m12692a(f43095d, this, null, c15098d.f43092b);
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: h */
        protected final C15094s mo4195h() {
            return (C15094s) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: i */
        protected final C15094s mo4194i() {
            return (C15094s) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        /* renamed from: l */
        protected final boolean mo4193l(@NotNull C15094s c15094s, @NotNull Object obj) {
            if (obj instanceof LockFreeLinkedList) {
                ((LockFreeLinkedList) obj).f43037a.m4215U();
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @Nullable
        /* renamed from: m */
        protected final C15094s mo4192m(@NotNull AbstractC15073c0 abstractC15073c0) {
            C15094s c15094s = this.f43096b;
            while (true) {
                Object obj = c15094s._next;
                if (!(obj instanceof AbstractC15073c0)) {
                    if (obj != null) {
                        return (C15094s) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                AbstractC15073c0 abstractC15073c02 = (AbstractC15073c0) obj;
                if (abstractC15073c0.m4374b(abstractC15073c02)) {
                    return null;
                }
                abstractC15073c02.mo3620c(this.f43096b);
            }
        }

        @Override // kotlinx.coroutines.internal.C15094s.AbstractC15095a
        @NotNull
        /* renamed from: n */
        public final Object mo4191n(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
            return c15094s2.m4207c0();
        }

        /* renamed from: o */
        public final T m4190o() {
            T t = (T) mo4195h();
            C14342f0.m8187m(t);
            return t;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.s$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15100f extends AbstractC15097c {

        /* renamed from: d */
        final /* synthetic */ InterfaceC15269a f43097d;

        /* renamed from: e */
        final /* synthetic */ C15094s f43098e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15100f(InterfaceC15269a interfaceC15269a, C15094s c15094s, C15094s c15094s2) {
            super(c15094s2);
            this.f43097d = interfaceC15269a;
            this.f43098e = c15094s;
        }

        @Override // kotlinx.coroutines.internal.AbstractC15074d
        @Nullable
        /* renamed from: k */
        public Object mo3615i(@NotNull C15094s c15094s) {
            if (((Boolean) this.f43097d.invoke()).booleanValue()) {
                return null;
            }
            return C15093r.m4240a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (io.netty.channel.C13675a.m12692a(kotlinx.coroutines.internal.C15094s.f43083a, r3, r2, ((kotlinx.coroutines.internal.LockFreeLinkedList) r4).f43037a) != false) goto L28;
     */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.C15094s m4224H(kotlinx.coroutines.internal.AbstractC15073c0 r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.s r0 = (kotlinx.coroutines.internal.C15094s) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.C15094s.f43084b
            boolean r0 = io.netty.channel.C13675a.m12692a(r1, r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.mo4214V()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.AbstractC15073c0
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.c0 r0 = (kotlinx.coroutines.internal.AbstractC15073c0) r0
            boolean r0 = r7.m4374b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.c0 r4 = (kotlinx.coroutines.internal.AbstractC15073c0) r4
            r4.mo3620c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.LockFreeLinkedList
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.C15094s.f43083a
            kotlinx.coroutines.internal.e0 r4 = (kotlinx.coroutines.internal.LockFreeLinkedList) r4
            kotlinx.coroutines.internal.s r4 = r4.f43037a
            boolean r2 = io.netty.channel.C13675a.m12692a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.s r2 = (kotlinx.coroutines.internal.C15094s) r2
            goto L7
        L52:
            if (r4 == 0) goto L59
            kotlinx.coroutines.internal.s r4 = (kotlinx.coroutines.internal.C15094s) r4
            r3 = r2
            r2 = r4
            goto L7
        L59:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r0)
            goto L62
        L61:
            throw r7
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C15094s.m4224H(kotlinx.coroutines.internal.c0):kotlinx.coroutines.internal.s");
    }

    /* renamed from: M */
    private final C15094s m4221M(C15094s c15094s) {
        while (c15094s.mo4214V()) {
            c15094s = (C15094s) c15094s._prev;
        }
        return c15094s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public final void m4220O(C15094s c15094s) {
        C15094s c15094s2;
        do {
            c15094s2 = (C15094s) c15094s._prev;
            if (m4219P() != c15094s) {
                return;
            }
        } while (!C13675a.m12692a(f43084b, c15094s, c15094s2, this));
        if (mo4214V()) {
            c15094s.m4224H(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public final LockFreeLinkedList m4207c0() {
        LockFreeLinkedList lockFreeLinkedList = (LockFreeLinkedList) this._removedRef;
        if (lockFreeLinkedList != null) {
            return lockFreeLinkedList;
        }
        LockFreeLinkedList lockFreeLinkedList2 = new LockFreeLinkedList(this);
        f43085c.lazySet(this, lockFreeLinkedList2);
        return lockFreeLinkedList2;
    }

    /* renamed from: B */
    public final void m4230B(@NotNull C15094s c15094s) {
        do {
        } while (!m4217R().m4226F(c15094s, this));
    }

    /* renamed from: C */
    public final boolean m4229C(@NotNull C15094s c15094s, @NotNull InterfaceC15269a<Boolean> interfaceC15269a) {
        int m4206d0;
        C15100f c15100f = new C15100f(interfaceC15269a, c15094s, c15094s);
        do {
            m4206d0 = m4217R().m4206d0(c15094s, this, c15100f);
            if (m4206d0 == 1) {
                return true;
            }
        } while (m4206d0 != 2);
        return false;
    }

    /* renamed from: D */
    public final boolean m4228D(@NotNull C15094s c15094s, @NotNull InterfaceC15280l<? super C15094s, Boolean> interfaceC15280l) {
        C15094s m4217R;
        do {
            m4217R = m4217R();
            if (!interfaceC15280l.invoke(m4217R).booleanValue()) {
                return false;
            }
        } while (!m4217R.m4226F(c15094s, this));
        return true;
    }

    /* renamed from: E */
    public final boolean m4227E(@NotNull C15094s c15094s, @NotNull InterfaceC15280l<? super C15094s, Boolean> interfaceC15280l, @NotNull InterfaceC15269a<Boolean> interfaceC15269a) {
        int m4206d0;
        C15100f c15100f = new C15100f(interfaceC15269a, c15094s, c15094s);
        do {
            C15094s m4217R = m4217R();
            if (!interfaceC15280l.invoke(m4217R).booleanValue()) {
                return false;
            }
            m4206d0 = m4217R.m4206d0(c15094s, this, c15100f);
            if (m4206d0 == 1) {
                return true;
            }
        } while (m4206d0 != 2);
        return false;
    }

    @PublishedApi
    /* renamed from: F */
    public final boolean m4226F(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
        f43084b.lazySet(c15094s, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43083a;
        atomicReferenceFieldUpdater.lazySet(c15094s, c15094s2);
        if (C13675a.m12692a(atomicReferenceFieldUpdater, this, c15094s2, c15094s)) {
            c15094s.m4220O(c15094s2);
            return true;
        }
        return false;
    }

    /* renamed from: G */
    public final boolean m4225G(@NotNull C15094s c15094s) {
        f43084b.lazySet(c15094s, this);
        f43083a.lazySet(c15094s, this);
        while (m4219P() == this) {
            if (C13675a.m12692a(f43083a, this, this, c15094s)) {
                c15094s.m4220O(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: K */
    public final <T extends C15094s> C15096b<T> m4223K(@NotNull T t) {
        return new C15096b<>(this, t);
    }

    @NotNull
    /* renamed from: L */
    public final C15099e<C15094s> m4222L() {
        return new C15099e<>(this);
    }

    @NotNull
    /* renamed from: P */
    public final Object m4219P() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof AbstractC15073c0)) {
                return obj;
            }
            ((AbstractC15073c0) obj).mo3620c(this);
        }
    }

    @NotNull
    /* renamed from: Q */
    public final C15094s m4218Q() {
        return C15093r.m4233h(m4219P());
    }

    @NotNull
    /* renamed from: R */
    public final C15094s m4217R() {
        C15094s m4224H = m4224H(null);
        return m4224H != null ? m4224H : m4221M((C15094s) this._prev);
    }

    /* renamed from: S */
    public final void m4216S() {
        Object m4219P = m4219P();
        if (m4219P == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
        ((LockFreeLinkedList) m4219P).f43037a.m4224H(null);
    }

    @PublishedApi
    /* renamed from: U */
    public final void m4215U() {
        C15094s c15094s = this;
        while (true) {
            Object m4219P = c15094s.m4219P();
            if (!(m4219P instanceof LockFreeLinkedList)) {
                c15094s.m4224H(null);
                return;
            }
            c15094s = ((LockFreeLinkedList) m4219P).f43037a;
        }
    }

    /* renamed from: V */
    public boolean mo4214V() {
        return m4219P() instanceof LockFreeLinkedList;
    }

    @PublishedApi
    @NotNull
    /* renamed from: W */
    public final AbstractC15097c m4213W(@NotNull C15094s c15094s, @NotNull InterfaceC15269a<Boolean> interfaceC15269a) {
        return new C15100f(interfaceC15269a, c15094s, c15094s);
    }

    @Nullable
    /* renamed from: X */
    protected C15094s mo4212X() {
        Object m4219P = m4219P();
        if (!(m4219P instanceof LockFreeLinkedList)) {
            m4219P = null;
        }
        LockFreeLinkedList lockFreeLinkedList = (LockFreeLinkedList) m4219P;
        if (lockFreeLinkedList != null) {
            return lockFreeLinkedList.f43037a;
        }
        return null;
    }

    /* renamed from: Y */
    public boolean mo4211Y() {
        return m4208b0() == null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.internal.s, T, java.lang.Object] */
    @Nullable
    /* renamed from: Z */
    public final /* synthetic */ <T> T m4210Z(@NotNull InterfaceC15280l<? super T, Boolean> interfaceC15280l) {
        C15094s m4208b0;
        while (true) {
            Object m4219P = m4219P();
            if (m4219P == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            C15094s c15094s = (C15094s) m4219P;
            if (c15094s == this) {
                return null;
            }
            C14342f0.m8175y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if ((interfaceC15280l.invoke(c15094s).booleanValue() && !c15094s.mo4214V()) || (m4208b0 = c15094s.m4208b0()) == null) {
                return c15094s;
            }
            m4208b0.m4215U();
        }
    }

    @Nullable
    /* renamed from: a0 */
    public final C15094s m4209a0() {
        while (true) {
            Object m4219P = m4219P();
            if (m4219P == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            C15094s c15094s = (C15094s) m4219P;
            if (c15094s == this) {
                return null;
            }
            if (c15094s.mo4211Y()) {
                return c15094s;
            }
            c15094s.m4216S();
        }
    }

    @PublishedApi
    @Nullable
    /* renamed from: b0 */
    public final C15094s m4208b0() {
        Object m4219P;
        C15094s c15094s;
        do {
            m4219P = m4219P();
            if (m4219P instanceof LockFreeLinkedList) {
                return ((LockFreeLinkedList) m4219P).f43037a;
            }
            if (m4219P == this) {
                return (C15094s) m4219P;
            }
            if (m4219P != null) {
                c15094s = (C15094s) m4219P;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!C13675a.m12692a(f43083a, this, m4219P, c15094s.m4207c0()));
        c15094s.m4224H(null);
        return null;
    }

    @PublishedApi
    /* renamed from: d0 */
    public final int m4206d0(@NotNull C15094s c15094s, @NotNull C15094s c15094s2, @NotNull AbstractC15097c abstractC15097c) {
        f43084b.lazySet(c15094s, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43083a;
        atomicReferenceFieldUpdater.lazySet(c15094s, c15094s2);
        abstractC15097c.f43089b = c15094s2;
        if (C13675a.m12692a(atomicReferenceFieldUpdater, this, c15094s2, abstractC15097c)) {
            return abstractC15097c.mo3620c(this) == null ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: e0 */
    public final void m4205e0(@NotNull C15094s c15094s, @NotNull C15094s c15094s2) {
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
