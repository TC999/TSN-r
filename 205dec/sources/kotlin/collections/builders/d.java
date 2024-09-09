package kotlin.collections.builders;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.q;
import m1.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\b\u0000\u0012\u0010\u0010\u0017\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016R\u001e\u0010\u0017\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlin/collections/builders/d;", "E", "", "Lkotlin/collections/h;", "", "isEmpty", "element", "contains", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "clear", "add", "", "elements", "addAll", "remove", "", "iterator", "removeAll", "retainAll", "Lkotlin/collections/builders/MapBuilder;", "a", "Lkotlin/collections/builders/MapBuilder;", "backing", "", "getSize", "()I", "size", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d<E> extends kotlin.collections.h<E> implements Set<E>, e2.h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MapBuilder<E, ?> f55278a;

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlin/collections/builders/d$a;", "", "", "capacity", "c", "hashSize", "d", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    private static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i4) {
            int n4;
            n4 = q.n(i4, 1);
            return Integer.highestOneBit(n4 * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i4) {
            return Integer.numberOfLeadingZeros(i4) + 1;
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0096\u0002J\u000f\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u000bj\u0002`\f\u00a8\u0006\u0014"}, d2 = {"Lkotlin/collections/builders/d$b;", "K", "V", "Lkotlin/collections/builders/d$d;", "", "", "Lkotlin/collections/builders/d$c;", "h", "", "j", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lkotlin/f1;", "i", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<K, V> extends C1089d<K, V> implements Iterator<Map.Entry<K, V>>, m1.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull d<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: h */
        public c<K, V> next() {
            if (a() < d.d(d())) {
                int a4 = a();
                f(a4 + 1);
                g(a4);
                c<K, V> cVar = new c<>(d(), c());
                e();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void i(@NotNull StringBuilder sb) {
            f0.p(sb, "sb");
            if (a() < d.d(d())) {
                int a4 = a();
                f(a4 + 1);
                g(a4);
                Object obj = d.c(d())[c()];
                if (f0.g(obj, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] f4 = d.f(d());
                f0.m(f4);
                Object obj2 = f4[c()];
                if (f0.g(obj2, d())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                e();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int j() {
            if (a() < d.d(d())) {
                int a4 = a();
                f(a4 + 1);
                g(a4);
                Object obj = d.c(d())[c()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] f4 = d.f(d());
                f0.m(f4);
                Object obj2 = f4[c()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                e();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00028\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/d$c;", "K", "V", "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/collections/builders/d;", "a", "Lkotlin/collections/builders/d;", "map", "b", "I", "index", "getKey", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "getValue", "value", "<init>", "(Lkotlin/collections/builders/d;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, g.a {

        /* renamed from: a  reason: collision with root package name */
        private final d<K, V> f55279a;

        /* renamed from: b  reason: collision with root package name */
        private final int f55280b;

        public c(@NotNull d<K, V> map, int i4) {
            f0.p(map, "map");
            this.f55279a = map;
            this.f55280b = i4;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (f0.g(entry.getKey(), getKey()) && f0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) d.c(this.f55279a)[this.f55280b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] f4 = d.f(this.f55279a);
            f0.m(f4);
            return (V) f4[this.f55280b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            this.f55279a.o();
            Object[] a4 = d.a(this.f55279a);
            int i4 = this.f55280b;
            V v4 = (V) a4[i4];
            a4[i4] = v3;
            return v4;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0004R\"\u0010\u0010\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00158\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lkotlin/collections/builders/d$d;", "K", "V", "", "Lkotlin/f1;", "e", "()V", "", "hasNext", "remove", "", "a", "I", "()I", "f", "(I)V", "index", "b", "c", "g", "lastIndex", "Lkotlin/collections/builders/d;", "Lkotlin/collections/builders/d;", "d", "()Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: kotlin.collections.builders.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class C1089d<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private int f55281a;

        /* renamed from: b  reason: collision with root package name */
        private int f55282b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final d<K, V> f55283c;

        public C1089d(@NotNull d<K, V> map) {
            f0.p(map, "map");
            this.f55283c = map;
            this.f55282b = -1;
            e();
        }

        public final int a() {
            return this.f55281a;
        }

        public final int c() {
            return this.f55282b;
        }

        @NotNull
        public final d<K, V> d() {
            return this.f55283c;
        }

        public final void e() {
            while (this.f55281a < d.d(this.f55283c)) {
                int[] e4 = d.e(this.f55283c);
                int i4 = this.f55281a;
                if (e4[i4] >= 0) {
                    return;
                }
                this.f55281a = i4 + 1;
            }
        }

        public final void f(int i4) {
            this.f55281a = i4;
        }

        public final void g(int i4) {
            this.f55282b = i4;
        }

        public final boolean hasNext() {
            return this.f55281a < d.d(this.f55283c);
        }

        public final void remove() {
            if (this.f55282b != -1) {
                this.f55283c.o();
                d.g(this.f55283c, this.f55282b);
                this.f55282b = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/d$e;", "K", "V", "Lkotlin/collections/builders/d$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e<K, V> extends C1089d<K, V> implements Iterator<K>, m1.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull d<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < d.d(d())) {
                int a4 = a();
                f(a4 + 1);
                g(a4);
                K k4 = (K) d.c(d())[c()];
                e();
                return k4;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/d$f;", "K", "V", "Lkotlin/collections/builders/d$d;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/d;", "map", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f<K, V> extends C1089d<K, V> implements Iterator<V>, m1.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull d<K, V> map) {
            super(map);
            f0.p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < d.d(d())) {
                int a4 = a();
                f(a4 + 1);
                g(a4);
                Object[] f4 = d.f(d());
                f0.m(f4);
                V v3 = (V) f4[c()];
                e();
                return v3;
            }
            throw new NoSuchElementException();
        }
    }

    public d(@NotNull MapBuilder<E, ?> backing) {
        f0.p(backing, "backing");
        this.f55278a = backing;
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        f0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f55278a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f55278a.containsKey(obj);
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.f55278a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f55278a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return this.f55278a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f55278a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55278a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55278a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(elements);
    }
}
