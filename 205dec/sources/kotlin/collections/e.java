package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractMutableCollection.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lkotlin/collections/e;", "E", "", "Ljava/util/AbstractCollection;", "element", "", "add", "(Ljava/lang/Object;)Z", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, e2.b {

    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lkotlin/collections/e$a;", "", "", "e", "", "b", "(Ljava/util/Map$Entry;)I", "", "c", "(Ljava/util/Map$Entry;)Ljava/lang/String;", "other", "", "a", "(Ljava/util/Map$Entry;Ljava/lang/Object;)Z", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a {
        private a() {
        }

        public final boolean a(@NotNull Map.Entry<?, ?> e4, @Nullable Object obj) {
            kotlin.jvm.internal.f0.p(e4, "e");
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return kotlin.jvm.internal.f0.g(e4.getKey(), entry.getKey()) && kotlin.jvm.internal.f0.g(e4.getValue(), entry.getValue());
            }
            return false;
        }

        public final int b(@NotNull Map.Entry<?, ?> e4) {
            kotlin.jvm.internal.f0.p(e4, "e");
            Object key = e4.getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = e4.getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @NotNull
        public final String c(@NotNull Map.Entry<?, ?> e4) {
            kotlin.jvm.internal.f0.p(e4, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(e4.getKey());
            sb.append('=');
            sb.append(e4.getValue());
            return sb.toString();
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"kotlin/collections/e$b", "Lkotlin/collections/j;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<K> extends j<K> {

        /* compiled from: AbstractMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"kotlin/collections/e$b$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public static final class a implements Iterator<K>, m1.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f55306a;

            a(Iterator it) {
                this.f55306a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f55306a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) this.f55306a.next()).getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        b() {
        }

        @Override // kotlin.collections.j, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.containsKey(obj);
        }

        public int getSize() {
            return e.this.size();
        }

        @Override // kotlin.collections.j, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<K> iterator() {
            return new a(e.this.entrySet().iterator());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", "V", "", "it", "", "a", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class c<K, V> extends Lambda implements l1.l<Map.Entry<? extends K, ? extends V>, CharSequence> {
        c() {
            super(1);
        }

        @Override // l1.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull Map.Entry<? extends K, ? extends V> it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return e.a(e.this, it);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"kotlin/collections/e$d", "Lkotlin/collections/a;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class d<V> extends kotlin.collections.a<V> {

        /* compiled from: AbstractMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"kotlin/collections/e$d$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public static final class a implements Iterator<V>, m1.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f55309a;

            a(Iterator it) {
                this.f55309a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f55309a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((Map.Entry) this.f55309a.next()).getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        d() {
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.containsValue(obj);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return e.this.size();
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<V> iterator() {
            return new a(e.this.entrySet().iterator());
        }
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e4);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
