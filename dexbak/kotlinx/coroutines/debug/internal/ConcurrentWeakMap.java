package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges._Ranges;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p620m1.InterfaceC15298d;
import p620m1.InterfaceC15301g;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u0017'\u001fB\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0007R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010 ¨\u0006("}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/a;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/h;", "Lkotlin/f1;", "i", "()V", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "j", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/h;", IAdInterListener.AdReqParam.WIDTH, "h", "(Lkotlinx/coroutines/debug/internal/h;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "remove", "clear", "k", "Ljava/lang/ref/ReferenceQueue;", "a", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "d", "()I", "size", "", "c", "()Ljava/util/Set;", "keys", "", "entries", "", "<init>", "(Z)V", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.debug.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* renamed from: b */
    private static final AtomicIntegerFieldUpdater f42203b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile int _size;

    /* renamed from: a */
    private final ReferenceQueue<K> f42204a;
    volatile Object core;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\"\u0004\b\u0002\u0010\u00182\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001f¨\u0006%"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/a$a;", "", "", "hash", "d", "(I)I", "index", "Lkotlin/f1;", "i", "(I)V", DomainCampaignEx.LOOPBACK_KEY, "c", "(Ljava/lang/Object;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/debug/internal/h;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/h;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/a;", "h", "()Lkotlinx/coroutines/debug/internal/a$a;", "weakRef", "b", "(Lkotlinx/coroutines/debug/internal/h;)V", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function2;", "factory", "", "e", "(Ll1/p;)Ljava/util/Iterator;", "a", "I", "shift", "threshold", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/a;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C14753a {

        /* renamed from: g */
        private static final AtomicIntegerFieldUpdater f42205g = AtomicIntegerFieldUpdater.newUpdater(C14753a.class, "load");

        /* renamed from: a */
        private final int f42206a;

        /* renamed from: b */
        private final int f42207b;

        /* renamed from: c */
        AtomicReferenceArray f42208c;

        /* renamed from: d */
        AtomicReferenceArray f42209d;

        /* renamed from: e */
        private final int f42210e;
        private volatile int load = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ConcurrentWeakMap.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0002J\u0010\u0010\u0007\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u0010\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00028\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/a$a$a;", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/f1;", "a", "", "hasNext", "next", "()Ljava/lang/Object;", "", "c", "", "I", "index", "b", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/a$a;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.debug.internal.a$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C14754a<E> implements Iterator<E>, InterfaceC15298d {

            /* renamed from: a */
            private int f42212a = -1;

            /* renamed from: b */
            private K f42213b;

            /* renamed from: c */
            private V f42214c;

            /* renamed from: d */
            private final InterfaceC15284p<K, V, E> f42215d;

            /* JADX WARN: Multi-variable type inference failed */
            public C14754a(@NotNull InterfaceC15284p<? super K, ? super V, ? extends E> interfaceC15284p) {
                this.f42215d = interfaceC15284p;
                m5123a();
            }

            /* renamed from: a */
            private final void m5123a() {
                K k;
                while (true) {
                    int i = this.f42212a + 1;
                    this.f42212a = i;
                    if (i >= C14753a.this.f42210e) {
                        return;
                    }
                    C14771h c14771h = (C14771h) C14753a.this.f42208c.get(this.f42212a);
                    if (c14771h != null && (k = (K) c14771h.get()) != null) {
                        this.f42213b = k;
                        V v = (V) C14753a.this.f42209d.get(this.f42212a);
                        if (v instanceof C14772i) {
                            v = (V) ((C14772i) v).f42275a;
                        }
                        if (v != null) {
                            this.f42214c = v;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: c */
            public Void remove() {
                C14759b.m5115e();
                throw new ExceptionsH();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f42212a < C14753a.this.f42210e;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f42212a < C14753a.this.f42210e) {
                    InterfaceC15284p<K, V, E> interfaceC15284p = this.f42215d;
                    K k = this.f42213b;
                    if (k == null) {
                        C14342f0.m8200S(DomainCampaignEx.LOOPBACK_KEY);
                    }
                    V v = this.f42214c;
                    if (v == null) {
                        C14342f0.m8200S(DomainCampaignEx.LOOPBACK_VALUE);
                    }
                    E invoke = interfaceC15284p.invoke(k, v);
                    m5123a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public C14753a(int i) {
            this.f42210e = i;
            this.f42206a = Integer.numberOfLeadingZeros(i) + 1;
            this.f42207b = (i * 2) / 3;
            this.f42208c = new AtomicReferenceArray(i);
            this.f42209d = new AtomicReferenceArray(i);
        }

        /* renamed from: d */
        private final int m5129d(int i) {
            return (i * (-1640531527)) >>> this.f42206a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: g */
        public static /* synthetic */ Object m5126g(C14753a c14753a, Object obj, Object obj2, C14771h c14771h, int i, Object obj3) {
            if ((i & 4) != 0) {
                c14771h = null;
            }
            return c14753a.m5127f(obj, obj2, c14771h);
        }

        /* renamed from: i */
        private final void m5124i(int i) {
            Object obj;
            do {
                obj = this.f42209d.get(i);
                if (obj == null || (obj instanceof C14772i)) {
                    return;
                }
            } while (!this.f42209d.compareAndSet(i, obj, null));
            ConcurrentWeakMap.this.m5135i();
        }

        /* renamed from: b */
        public final void m5131b(@NotNull C14771h<?> c14771h) {
            int m5129d = m5129d(c14771h.f42274a);
            while (true) {
                C14771h<?> c14771h2 = (C14771h) this.f42208c.get(m5129d);
                if (c14771h2 == null) {
                    return;
                }
                if (c14771h2 == c14771h) {
                    m5124i(m5129d);
                    return;
                }
                if (m5129d == 0) {
                    m5129d = this.f42210e;
                }
                m5129d--;
            }
        }

        @Nullable
        /* renamed from: c */
        public final V m5130c(@NotNull K k) {
            int m5129d = m5129d(k.hashCode());
            while (true) {
                C14771h c14771h = (C14771h) this.f42208c.get(m5129d);
                if (c14771h == null) {
                    return null;
                }
                T t = c14771h.get();
                if (C14342f0.m8193g(k, t)) {
                    V v = (V) this.f42209d.get(m5129d);
                    return v instanceof C14772i ? (V) ((C14772i) v).f42275a : v;
                }
                if (t == 0) {
                    m5124i(m5129d);
                }
                if (m5129d == 0) {
                    m5129d = this.f42210e;
                }
                m5129d--;
            }
        }

        @NotNull
        /* renamed from: e */
        public final <E> Iterator<E> m5128e(@NotNull InterfaceC15284p<? super K, ? super V, ? extends E> interfaceC15284p) {
            return new C14754a(interfaceC15284p);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.f42209d.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof kotlinx.coroutines.debug.internal.C14772i) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = kotlinx.coroutines.debug.internal.C14759b.f42225c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.f42209d.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        @org.jetbrains.annotations.Nullable
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object m5127f(@org.jetbrains.annotations.NotNull K r6, @org.jetbrains.annotations.Nullable V r7, @org.jetbrains.annotations.Nullable kotlinx.coroutines.debug.internal.C14771h<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.m5129d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f42208c
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.h r2 = (kotlinx.coroutines.debug.internal.C14771h) r2
                if (r2 != 0) goto L45
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L2f
            L19:
                int r1 = r5.load
                int r3 = r5.f42207b
                if (r1 < r3) goto L24
                kotlinx.coroutines.internal.j0 r6 = kotlinx.coroutines.debug.internal.C14759b.m5119a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C14753a.f42205g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 == 0) goto L19
                r1 = 1
            L2f:
                if (r8 != 0) goto L3c
                kotlinx.coroutines.debug.internal.h r8 = new kotlinx.coroutines.debug.internal.h
                kotlinx.coroutines.debug.internal.a r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.m5137g(r3)
                r8.<init>(r6, r3)
            L3c:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f42208c
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 == 0) goto L9
                goto L56
            L45:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.C14342f0.m8193g(r6, r2)
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C14753a.f42205g
                r6.decrementAndGet(r5)
            L56:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f42209d
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.C14772i
                if (r8 == 0) goto L65
                kotlinx.coroutines.internal.j0 r6 = kotlinx.coroutines.debug.internal.C14759b.m5119a()
                return r6
            L65:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f42209d
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L56
                return r6
            L6e:
                if (r2 != 0) goto L73
                r5.m5124i(r0)
            L73:
                if (r0 != 0) goto L77
                int r0 = r5.f42210e
            L77:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.C14753a.m5127f(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.h):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        /* renamed from: h */
        public final ConcurrentWeakMap<K, V>.C14753a m5125h() {
            int m7481n;
            Object obj;
            Symbol symbol;
            C14772i m5116d;
            while (true) {
                m7481n = _Ranges.m7481n(ConcurrentWeakMap.this.size(), 4);
                ConcurrentWeakMap<K, V>.C14753a c14753a = (ConcurrentWeakMap<K, V>.C14753a) new C14753a(Integer.highestOneBit(m7481n) * 4);
                int i = this.f42210e;
                for (int i2 = 0; i2 < i; i2++) {
                    C14771h c14771h = (C14771h) this.f42208c.get(i2);
                    Object obj2 = c14771h != null ? c14771h.get() : null;
                    if (c14771h != null && obj2 == null) {
                        m5124i(i2);
                    }
                    while (true) {
                        obj = this.f42209d.get(i2);
                        if (obj instanceof C14772i) {
                            obj = ((C14772i) obj).f42275a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f42209d;
                        m5116d = C14759b.m5116d(obj);
                        if (atomicReferenceArray.compareAndSet(i2, obj, m5116d)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object m5127f = c14753a.m5127f(obj2, obj, c14771h);
                        symbol = C14759b.f42225c;
                        if (m5127f == symbol) {
                            break;
                        }
                    }
                }
                return c14753a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/a$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "b", "getValue", DomainCampaignEx.LOOPBACK_VALUE, "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14755b<K, V> implements Map.Entry<K, V>, InterfaceC15301g.InterfaceC15302a {

        /* renamed from: a */
        private final K f42217a;

        /* renamed from: b */
        private final V f42218b;

        public C14755b(K k, V v) {
            this.f42217a = k;
            this.f42218b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f42217a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f42218b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            C14759b.m5115e();
            throw new ExceptionsH();
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/a$c;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/i;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "", "a", "()I", "size", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/a;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private final class C14756c<E> extends AbstractMutableSet<E> {

        /* renamed from: a */
        private final InterfaceC15284p<K, V, E> f42219a;

        /* JADX WARN: Multi-variable type inference failed */
        public C14756c(@NotNull InterfaceC15284p<? super K, ? super V, ? extends E> interfaceC15284p) {
            this.f42219a = interfaceC15284p;
        }

        @Override // kotlin.collections.AbstractMutableSet
        /* renamed from: a */
        public int mo5121a() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            C14759b.m5115e();
            throw new ExceptionsH();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((C14753a) ConcurrentWeakMap.this.core).m5128e(this.f42219a);
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "k", "v", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14757d extends Lambda implements InterfaceC15284p<K, V, Map.Entry<K, V>> {

        /* renamed from: a */
        public static final C14757d f42221a = new C14757d();

        C14757d() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        /* renamed from: a */
        public final Map.Entry<K, V> invoke(@NotNull K k, @NotNull V v) {
            return new C14755b(k, v);
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {"<anonymous>", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "k", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14758e extends Lambda implements InterfaceC15284p<K, V, K> {

        /* renamed from: a */
        public static final C14758e f42222a = new C14758e();

        C14758e() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        public final K invoke(@NotNull K k, @NotNull V v) {
            return k;
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    /* renamed from: h */
    private final void m5136h(C14771h<?> c14771h) {
        ((C14753a) this.core).m5131b(c14771h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public final void m5135i() {
        f42203b.decrementAndGet(this);
    }

    /* renamed from: j */
    private final synchronized V m5134j(K k, V v) {
        V v2;
        Symbol symbol;
        C14753a c14753a = (C14753a) this.core;
        while (true) {
            v2 = (V) C14753a.m5126g(c14753a, k, v, null, 4, null);
            symbol = C14759b.f42225c;
            if (v2 == symbol) {
                c14753a = c14753a.m5125h();
                this.core = c14753a;
            }
        }
        return v2;
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    /* renamed from: a */
    public Set<Map.Entry<K, V>> mo5141a() {
        return new C14756c(C14757d.f42221a);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    /* renamed from: c */
    public Set<K> mo5140c() {
        return new C14756c(C14758e.f42222a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k : keySet()) {
            remove(k);
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    /* renamed from: d */
    public int mo5139d() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@NotNull Object obj) {
        if (obj != null) {
            return (V) ((C14753a) this.core).m5130c(obj);
        }
        return null;
    }

    /* renamed from: k */
    public final void m5133k() {
        if (!(this.f42204a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.f42204a.remove();
                if (remove == null) {
                    break;
                }
                m5136h((C14771h) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        Symbol symbol;
        V v2 = (V) C14753a.m5126g((C14753a) this.core, k, v, null, 4, null);
        symbol = C14759b.f42225c;
        if (v2 == symbol) {
            v2 = m5134j(k, v);
        }
        if (v2 == null) {
            f42203b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@NotNull Object obj) {
        Symbol symbol;
        if (obj != 0) {
            V v = (V) C14753a.m5126g((C14753a) this.core, obj, null, null, 4, null);
            symbol = C14759b.f42225c;
            if (v == symbol) {
                v = m5134j(obj, null);
            }
            if (v != null) {
                f42203b.decrementAndGet(this);
            }
            return v;
        }
        return null;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new C14753a(16);
        this.f42204a = z ? new ReferenceQueue<>() : null;
    }
}
