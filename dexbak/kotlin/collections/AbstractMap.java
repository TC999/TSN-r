package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p620m1.KMarkers;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u000f\b'\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u001eB\t\b\u0004¢\u0006\u0004\b.\u0010/J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0013\u001a\u00020\u000e2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0096\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010!8\b@\bX\u0088\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, m12616d2 = {"Lkotlin/collections/e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "entry", "", "j", "", "o", "i", DomainCampaignEx.LOOPBACK_KEY, "h", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "", "containsKey", "(Ljava/lang/Object;)Z", DomainCampaignEx.LOOPBACK_VALUE, "containsValue", "c", "(Ljava/util/Map$Entry;)Z", AdnName.OTHER, "equals", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", TTDownloadField.TT_HASHCODE, "isEmpty", "toString", "", "a", "Ljava/util/Set;", "_keys", "", "b", "Ljava/util/Collection;", "_values", "f", "()I", "size", "e", "()Ljava/util/Set;", "keys", "g", "()Ljava/util/Collection;", "values", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractMap<K, V> implements Map<K, V>, KMarkers {
    @NotNull

    /* renamed from: c */
    public static final C14148a f40879c = new C14148a(null);

    /* renamed from: a */
    private volatile Set<? extends K> f40880a;

    /* renamed from: b */
    private volatile Collection<? extends V> f40881b;

    /* compiled from: AbstractMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, m12616d2 = {"Lkotlin/collections/e$a;", "", "", "e", "", "b", "(Ljava/util/Map$Entry;)I", "", "c", "(Ljava/util/Map$Entry;)Ljava/lang/String;", AdnName.OTHER, "", "a", "(Ljava/util/Map$Entry;Ljava/lang/Object;)Z", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14148a {
        private C14148a() {
        }

        /* renamed from: a */
        public final boolean m12281a(@NotNull Map.Entry<?, ?> e, @Nullable Object obj) {
            C14342f0.m8184p(e, "e");
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return C14342f0.m8193g(e.getKey(), entry.getKey()) && C14342f0.m8193g(e.getValue(), entry.getValue());
            }
            return false;
        }

        /* renamed from: b */
        public final int m12280b(@NotNull Map.Entry<?, ?> e) {
            C14342f0.m8184p(e, "e");
            Object key = e.getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = e.getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @NotNull
        /* renamed from: c */
        public final String m12279c(@NotNull Map.Entry<?, ?> e) {
            C14342f0.m8184p(e, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(e.getKey());
            sb.append('=');
            sb.append(e.getValue());
            return sb.toString();
        }

        public /* synthetic */ C14148a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AbstractMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m12616d2 = {"kotlin/collections/e$b", "Lkotlin/collections/j;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14149b extends AbstractSet<K> {

        /* compiled from: AbstractMap.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"kotlin/collections/e$b$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.collections.e$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14150a implements Iterator<K>, KMarkers {

            /* renamed from: a */
            final /* synthetic */ Iterator f40883a;

            C14150a(Iterator it) {
                this.f40883a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f40883a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return (K) ((Map.Entry) this.f40883a.next()).getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        C14149b() {
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractMap.this.containsKey(obj);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return AbstractMap.this.size();
        }

        @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<K> iterator() {
            return new C14150a(AbstractMap.this.entrySet().iterator());
        }
    }

    /* compiled from: AbstractMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "it", "", "a", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.e$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14151c extends Lambda implements InterfaceC15280l<Map.Entry<? extends K, ? extends V>, CharSequence> {
        C14151c() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull Map.Entry<? extends K, ? extends V> it) {
            C14342f0.m8184p(it, "it");
            return AbstractMap.this.m12282j(it);
        }
    }

    /* compiled from: AbstractMap.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0002R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m12616d2 = {"kotlin/collections/e$d", "Lkotlin/collections/a;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "", "getSize", "()I", "size", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.e$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14152d extends AbstractCollection<V> {

        /* compiled from: AbstractMap.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"kotlin/collections/e$d$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: kotlin.collections.e$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14153a implements Iterator<V>, KMarkers {

            /* renamed from: a */
            final /* synthetic */ Iterator f40886a;

            C14153a(Iterator it) {
                this.f40886a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f40886a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((Map.Entry) this.f40886a.next()).getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        C14152d() {
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractMap.this.containsValue(obj);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return AbstractMap.this.size();
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<V> iterator() {
            return new C14153a(AbstractMap.this.entrySet().iterator());
        }
    }

    protected AbstractMap() {
    }

    /* renamed from: h */
    private final Map.Entry<K, V> m12284h(K k) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (C14342f0.m8193g(((Map.Entry) obj).getKey(), k)) {
                break;
            }
        }
        return (Map.Entry) obj;
    }

    /* renamed from: i */
    private final String m12283i(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public final String m12282j(Map.Entry<? extends K, ? extends V> entry) {
        return m12283i(entry.getKey()) + "=" + m12283i(entry.getValue());
    }

    /* renamed from: c */
    public final boolean m12289c(@Nullable Map.Entry<?, ?> entry) {
        if (entry instanceof Map.Entry) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            V v = get(key);
            if (!C14342f0.m8193g(value, v)) {
                return false;
            }
            return v != null || containsKey(key);
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
        return m12284h(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (C14342f0.m8193g(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public abstract Set m12288d();

    @NotNull
    /* renamed from: e */
    public Set<K> m12287e() {
        if (this.f40880a == null) {
            this.f40880a = new C14149b();
        }
        Set set = (Set<? extends K>) this.f40880a;
        C14342f0.m8187m(set);
        return set;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m12288d();
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
                if (!m12289c((Map.Entry) it.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int m12286f() {
        return entrySet().size();
    }

    @NotNull
    /* renamed from: g */
    public Collection<V> m12285g() {
        if (this.f40881b == null) {
            this.f40881b = new C14152d();
        }
        Collection collection = (Collection<? extends V>) this.f40881b;
        C14342f0.m8187m(collection);
        return collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        Map.Entry<K, V> m12284h = m12284h(obj);
        if (m12284h != null) {
            return m12284h.getValue();
        }
        return null;
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
        return m12287e();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
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
        return m12286f();
    }

    @NotNull
    public String toString() {
        String m12151Z2;
        m12151Z2 = _Collections.m12151Z2(entrySet(), ", ", "{", "}", 0, null, new C14151c(), 24, null);
        return m12151Z2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m12285g();
    }
}
