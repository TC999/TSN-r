package kotlin.collections;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractMap.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u000f\b'\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u001eB\t\b\u0004\u00a2\u0006\u0004\b.\u0010/J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0013\u001a\u00020\u000e2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0096\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010!8\b@\bX\u0088\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lkotlin/collections/d;", "K", "V", "", "", "entry", "", "k", "", "o", "j", DomainCampaignEx.LOOPBACK_KEY, "h", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "c", "(Ljava/util/Map$Entry;)Z", "other", "equals", f3.f5657f, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hashCode", "isEmpty", "toString", "", "a", "Ljava/util/Set;", "_keys", "", "b", "Ljava/util/Collection;", "_values", "f", "()I", "size", "e", "()Ljava/util/Set;", "keys", "g", "()Ljava/util/Collection;", "values", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d<K, V> implements Map<K, V>, e2.a {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f55295c = new a(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<? extends K> f55296a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile Collection<? extends V> f55297b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lkotlin/collections/d$a;", "", "", "e", "", "b", "(Ljava/util/Map$Entry;)I", "", "c", "(Ljava/util/Map$Entry;)Ljava/lang/String;", "other", "", "a", "(Ljava/util/Map$Entry;Ljava/lang/Object;)Z", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
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
            int hashCode = key == null ? 0 : key.hashCode();
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
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"kotlin/collections/d$b", "Lkotlin/collections/i;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends i<K> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d<K, V> f55298b;

        /* compiled from: AbstractMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"kotlin/collections/d$b$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a implements Iterator<K>, e2.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f55299a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f55299a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f55299a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f55299a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(d<K, ? extends V> dVar) {
            this.f55298b = dVar;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean contains(Object obj) {
            return this.f55298b.containsKey(obj);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.f55298b.size();
        }

        @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<K> iterator() {
            return new a(this.f55298b.entrySet().iterator());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", "V", "", "it", "", "a", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<Map.Entry<? extends K, ? extends V>, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d<K, V> f55300a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(d<K, ? extends V> dVar) {
            super(1);
            this.f55300a = dVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull Map.Entry<? extends K, ? extends V> it) {
            kotlin.jvm.internal.f0.p(it, "it");
            return this.f55300a.k(it);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractMap.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"kotlin/collections/d$d", "Lkotlin/collections/a;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.collections.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1091d extends kotlin.collections.a<V> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d<K, V> f55301a;

        /* compiled from: AbstractMap.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"kotlin/collections/d$d$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.collections.d$d$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a implements Iterator<V>, e2.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f55302a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f55302a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f55302a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f55302a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C1091d(d<K, ? extends V> dVar) {
            this.f55301a = dVar;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean contains(Object obj) {
            return this.f55301a.containsValue(obj);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.f55301a.size();
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<V> iterator() {
            return new a(this.f55301a.entrySet().iterator());
        }
    }

    protected d() {
    }

    private final Map.Entry<K, V> h(K k4) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.f0.g(((Map.Entry) obj).getKey(), k4)) {
                break;
            }
        }
        return (Map.Entry) obj;
    }

    private final String j(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(Map.Entry<? extends K, ? extends V> entry) {
        return j(entry.getKey()) + '=' + j(entry.getValue());
    }

    public final boolean c(@Nullable Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        V v3 = get(key);
        if (kotlin.jvm.internal.f0.g(value, v3)) {
            return v3 != null || containsKey(key);
        }
        return false;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return h(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.f0.g(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Set d();

    @NotNull
    public Set<K> e() {
        if (this.f55296a == null) {
            this.f55296a = new b(this);
        }
        Set set = (Set<? extends K>) this.f55296a;
        kotlin.jvm.internal.f0.m(set);
        return set;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            Set<Map.Entry<K, V>> entrySet = map.entrySet();
            if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
                return true;
            }
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                if (!c((Map.Entry) it.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        return entrySet().size();
    }

    @NotNull
    public Collection<V> g() {
        if (this.f55297b == null) {
            this.f55297b = new C1091d(this);
        }
        Collection collection = (Collection<? extends V>) this.f55297b;
        kotlin.jvm.internal.f0.m(collection);
        return collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        Map.Entry<K, V> h4 = h(obj);
        if (h4 == null) {
            return null;
        }
        return h4.getValue();
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return e();
    }

    @Override // java.util.Map
    public V put(K k4, V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @NotNull
    public String toString() {
        String X2;
        X2 = f0.X2(entrySet(), ", ", "{", "}", 0, null, new c(this), 24, null);
        return X2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return g();
    }
}
