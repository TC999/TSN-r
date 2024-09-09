package kotlinx.coroutines.debug.internal;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.p;
import e2.g;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import kotlinx.coroutines.internal.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ConcurrentWeakMap.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\u0017'\u001fB\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020$\u00a2\u0006\u0004\b%\u0010&J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0007J\r\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0007R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R&\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010 \u00a8\u0006("}, d2 = {"Lkotlinx/coroutines/debug/internal/a;", "", "K", "V", "Lkotlin/collections/g;", "Lkotlin/f1;", "j", "()V", DomainCampaignEx.LOOPBACK_KEY, "value", "k", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/h;", "w", "h", "(Lkotlinx/coroutines/debug/internal/h;)V", f3.f5657f, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "remove", "clear", "l", "Ljava/lang/ref/ReferenceQueue;", "a", "Ljava/lang/ref/ReferenceQueue;", "weakRefQueue", "", "d", "()I", "size", "", "c", "()Ljava/util/Set;", "keys", "", "entries", "", "<init>", "(Z)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a<K, V> extends kotlin.collections.g<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f59548b = AtomicIntegerFieldUpdater.newUpdater(a.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    private final ReferenceQueue<K> f59549a;
    volatile Object core;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\"\u0004\b\u0002\u0010\u00182\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0019\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001f\u00a8\u0006%"}, d2 = {"Lkotlinx/coroutines/debug/internal/a$a;", "", "", "hash", "d", "(I)I", "index", "Lkotlin/f1;", "i", "(I)V", DomainCampaignEx.LOOPBACK_KEY, "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Lkotlinx/coroutines/debug/internal/h;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/h;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/a;", "h", "()Lkotlinx/coroutines/debug/internal/a$a;", "weakRef", "b", "(Lkotlinx/coroutines/debug/internal/h;)V", "E", "Lkotlin/Function2;", "factory", "", "e", "(Ld2/p;)Ljava/util/Iterator;", "a", "I", "shift", "threshold", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/a;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.debug.internal.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class C1202a {

        /* renamed from: g  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f59550g = AtomicIntegerFieldUpdater.newUpdater(C1202a.class, "load");

        /* renamed from: a  reason: collision with root package name */
        private final int f59551a;

        /* renamed from: b  reason: collision with root package name */
        private final int f59552b;

        /* renamed from: c  reason: collision with root package name */
        AtomicReferenceArray f59553c;

        /* renamed from: d  reason: collision with root package name */
        AtomicReferenceArray f59554d;

        /* renamed from: e  reason: collision with root package name */
        private final int f59555e;
        private volatile int load = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: ConcurrentWeakMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0002J\u0010\u0010\u0007\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u0010\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00028\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/debug/internal/a$a$a;", "E", "", "Lkotlin/f1;", "a", "", "hasNext", "next", "()Ljava/lang/Object;", "", "d", "", "I", "index", "b", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "c", "value", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/a$a;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.debug.internal.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1203a<E> implements Iterator<E>, e2.d {

            /* renamed from: a  reason: collision with root package name */
            private int f59557a = -1;

            /* renamed from: b  reason: collision with root package name */
            private K f59558b;

            /* renamed from: c  reason: collision with root package name */
            private V f59559c;

            /* renamed from: d  reason: collision with root package name */
            private final p<K, V, E> f59560d;

            /* JADX WARN: Multi-variable type inference failed */
            public C1203a(@NotNull p<? super K, ? super V, ? extends E> pVar) {
                this.f59560d = pVar;
                a();
            }

            private final void a() {
                K k4;
                while (true) {
                    int i4 = this.f59557a + 1;
                    this.f59557a = i4;
                    if (i4 >= C1202a.this.f59555e) {
                        return;
                    }
                    h hVar = (h) C1202a.this.f59553c.get(this.f59557a);
                    if (hVar != null && (k4 = (K) hVar.get()) != null) {
                        this.f59558b = k4;
                        V v3 = (V) C1202a.this.f59554d.get(this.f59557a);
                        if (v3 instanceof i) {
                            v3 = (V) ((i) v3).f59620a;
                        }
                        if (v3 != null) {
                            this.f59559c = v3;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: d */
            public Void remove() {
                kotlinx.coroutines.debug.internal.b.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f59557a < C1202a.this.f59555e;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f59557a < C1202a.this.f59555e) {
                    p<K, V, E> pVar = this.f59560d;
                    K k4 = this.f59558b;
                    if (k4 == null) {
                        f0.S(DomainCampaignEx.LOOPBACK_KEY);
                    }
                    V v3 = this.f59559c;
                    if (v3 == null) {
                        f0.S("value");
                    }
                    E invoke = pVar.invoke(k4, v3);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public C1202a(int i4) {
            this.f59555e = i4;
            this.f59551a = Integer.numberOfLeadingZeros(i4) + 1;
            this.f59552b = (i4 * 2) / 3;
            this.f59553c = new AtomicReferenceArray(i4);
            this.f59554d = new AtomicReferenceArray(i4);
        }

        private final int d(int i4) {
            return (i4 * (-1640531527)) >>> this.f59551a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(C1202a c1202a, Object obj, Object obj2, h hVar, int i4, Object obj3) {
            if ((i4 & 4) != 0) {
                hVar = null;
            }
            return c1202a.f(obj, obj2, hVar);
        }

        private final void i(int i4) {
            Object obj;
            do {
                obj = this.f59554d.get(i4);
                if (obj == null || (obj instanceof i)) {
                    return;
                }
            } while (!this.f59554d.compareAndSet(i4, obj, null));
            a.this.j();
        }

        public final void b(@NotNull h<?> hVar) {
            int d4 = d(hVar.f59619a);
            while (true) {
                h<?> hVar2 = (h) this.f59553c.get(d4);
                if (hVar2 == null) {
                    return;
                }
                if (hVar2 == hVar) {
                    i(d4);
                    return;
                }
                if (d4 == 0) {
                    d4 = this.f59555e;
                }
                d4--;
            }
        }

        @Nullable
        public final V c(@NotNull K k4) {
            int d4 = d(k4.hashCode());
            while (true) {
                h hVar = (h) this.f59553c.get(d4);
                if (hVar == null) {
                    return null;
                }
                Object obj = hVar.get();
                if (f0.g(k4, obj)) {
                    V v3 = (V) this.f59554d.get(d4);
                    return v3 instanceof i ? (V) ((i) v3).f59620a : v3;
                }
                if (obj == null) {
                    i(d4);
                }
                if (d4 == 0) {
                    d4 = this.f59555e;
                }
                d4--;
            }
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull p<? super K, ? super V, ? extends E> pVar) {
            return new C1203a(pVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.f59554d.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof kotlinx.coroutines.debug.internal.i) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = kotlinx.coroutines.debug.internal.b.f59570c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.f59554d.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object f(@org.jetbrains.annotations.NotNull K r6, @org.jetbrains.annotations.Nullable V r7, @org.jetbrains.annotations.Nullable kotlinx.coroutines.debug.internal.h<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f59553c
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.h r2 = (kotlinx.coroutines.debug.internal.h) r2
                if (r2 != 0) goto L45
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L2f
            L19:
                int r1 = r5.load
                int r3 = r5.f59552b
                if (r1 < r3) goto L24
                kotlinx.coroutines.internal.j0 r6 = kotlinx.coroutines.debug.internal.b.a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.a.C1202a.f59550g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 == 0) goto L19
                r1 = 1
            L2f:
                if (r8 != 0) goto L3c
                kotlinx.coroutines.debug.internal.h r8 = new kotlinx.coroutines.debug.internal.h
                kotlinx.coroutines.debug.internal.a r3 = kotlinx.coroutines.debug.internal.a.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.a.g(r3)
                r8.<init>(r6, r3)
            L3c:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f59553c
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 == 0) goto L9
                goto L56
            L45:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.f0.g(r6, r2)
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.a.C1202a.f59550g
                r6.decrementAndGet(r5)
            L56:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f59554d
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.i
                if (r8 == 0) goto L65
                kotlinx.coroutines.internal.j0 r6 = kotlinx.coroutines.debug.internal.b.a()
                return r6
            L65:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f59554d
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L56
                return r6
            L6e:
                if (r2 != 0) goto L73
                r5.i(r0)
            L73:
                if (r0 != 0) goto L77
                int r0 = r5.f59555e
            L77:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.a.C1202a.f(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.h):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final a<K, V>.C1202a h() {
            int n4;
            Object obj;
            j0 j0Var;
            i d4;
            while (true) {
                n4 = q.n(a.this.size(), 4);
                a<K, V>.C1202a c1202a = (a<K, V>.C1202a) new C1202a(Integer.highestOneBit(n4) * 4);
                int i4 = this.f59555e;
                for (int i5 = 0; i5 < i4; i5++) {
                    h hVar = (h) this.f59553c.get(i5);
                    Object obj2 = hVar != null ? hVar.get() : null;
                    if (hVar != null && obj2 == null) {
                        i(i5);
                    }
                    while (true) {
                        obj = this.f59554d.get(i5);
                        if (obj instanceof i) {
                            obj = ((i) obj).f59620a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f59554d;
                        d4 = kotlinx.coroutines.debug.internal.b.d(obj);
                        if (atomicReferenceArray.compareAndSet(i5, obj, d4)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object f4 = c1202a.f(obj2, obj, hVar);
                        j0Var = kotlinx.coroutines.debug.internal.b.f59570c;
                        if (f4 == j0Var) {
                            break;
                        }
                    }
                }
                return c1202a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0002\u0012\u0006\u0010\u000e\u001a\u00028\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00028\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/a$b;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "b", "getValue", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<K, V> implements Map.Entry<K, V>, g.a {

        /* renamed from: a  reason: collision with root package name */
        private final K f59562a;

        /* renamed from: b  reason: collision with root package name */
        private final V f59563b;

        public b(K k4, V v3) {
            this.f59562a = k4;
            this.f59563b = v3;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f59562a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f59563b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0096\u0002R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/a$c;", "E", "Lkotlin/collections/h;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/a;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class c<E> extends kotlin.collections.h<E> {

        /* renamed from: a  reason: collision with root package name */
        private final p<K, V, E> f59564a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull p<? super K, ? super V, ? extends E> pVar) {
            this.f59564a = pVar;
        }

        @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e4) {
            kotlinx.coroutines.debug.internal.b.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.h
        public int getSize() {
            return a.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((C1202a) a.this.core).e(this.f59564a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010'\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "K", "V", "k", "v", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements p<K, V, Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f59566a = new d();

        d() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Map.Entry<K, V> invoke(@NotNull K k4, @NotNull V v3) {
            return new b(k4, v3);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ConcurrentWeakMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0005\u001a\u0002H\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "K", "", "V", "k", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements p<K, V, K> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f59567a = new e();

        e() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        public final K invoke(@NotNull K k4, @NotNull V v3) {
            return k4;
        }
    }

    public a() {
        this(false, 1, null);
    }

    public /* synthetic */ a(boolean z3, int i4, u uVar) {
        this((i4 & 1) != 0 ? false : z3);
    }

    private final void h(h<?> hVar) {
        ((C1202a) this.core).b(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f59548b.decrementAndGet(this);
    }

    private final synchronized V k(K k4, V v3) {
        V v4;
        j0 j0Var;
        C1202a c1202a = (C1202a) this.core;
        while (true) {
            v4 = (V) C1202a.g(c1202a, k4, v3, null, 4, null);
            j0Var = kotlinx.coroutines.debug.internal.b.f59570c;
            if (v4 == j0Var) {
                c1202a = c1202a.h();
                this.core = c1202a;
            }
        }
        return v4;
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new c(d.f59566a);
    }

    @Override // kotlin.collections.g
    @NotNull
    public Set<K> c() {
        return new c(e.f59567a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k4 : keySet()) {
            remove(k4);
        }
    }

    @Override // kotlin.collections.g
    public int d() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@NotNull Object obj) {
        if (obj != null) {
            return (V) ((C1202a) this.core).c(obj);
        }
        return null;
    }

    public final void l() {
        if (!(this.f59549a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.f59549a.remove();
                if (remove == null) {
                    break;
                }
                h((h) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // kotlin.collections.g, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k4, @NotNull V v3) {
        j0 j0Var;
        V v4 = (V) C1202a.g((C1202a) this.core, k4, v3, null, 4, null);
        j0Var = kotlinx.coroutines.debug.internal.b.f59570c;
        if (v4 == j0Var) {
            v4 = k(k4, v3);
        }
        if (v4 == null) {
            f59548b.incrementAndGet(this);
        }
        return v4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@NotNull Object obj) {
        j0 j0Var;
        if (obj != 0) {
            V v3 = (V) C1202a.g((C1202a) this.core, obj, null, null, 4, null);
            j0Var = kotlinx.coroutines.debug.internal.b.f59570c;
            if (v3 == j0Var) {
                v3 = k(obj, null);
            }
            if (v3 != null) {
                f59548b.decrementAndGet(this);
            }
            return v3;
        }
        return null;
    }

    public a(boolean z3) {
        this._size = 0;
        this.core = new C1202a(16);
        this.f59549a = z3 ? new ReferenceQueue<>() : null;
    }
}
