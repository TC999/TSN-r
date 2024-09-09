package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmallSortedMap.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f57699a;

    /* renamed from: b  reason: collision with root package name */
    private List<s<K, V>.c> f57700b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f57701c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57702d;

    /* renamed from: e  reason: collision with root package name */
    private volatile s<K, V>.e f57703e;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a<FieldDescriptorType> extends s<FieldDescriptorType, Object> {
        a(int i4) {
            super(i4, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        public void m() {
            if (!l()) {
                for (int i4 = 0; i4 < i(); i4++) {
                    Map.Entry<FieldDescriptorType, Object> h4 = h(i4);
                    if (((g.b) h4.getKey()).v()) {
                        h4.setValue(Collections.unmodifiableList((List) h4.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : j()) {
                    if (((g.b) entry.getKey()).v()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.m();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((g.b) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final Iterator<Object> f57704a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f57705b = new C1160b();

        /* compiled from: SmallSortedMap.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.s$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class C1160b implements Iterable<Object> {
            C1160b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f57704a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f57705b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c implements Comparable<s<K, V>.c>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final K f57706a;

        /* renamed from: b  reason: collision with root package name */
        private V f57707b;

        c(s sVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(s<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: d */
        public K getKey() {
            return this.f57706a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return b(this.f57706a, entry.getKey()) && b(this.f57707b, entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f57707b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k4 = this.f57706a;
            int hashCode = k4 == null ? 0 : k4.hashCode();
            V v3 = this.f57707b;
            return hashCode ^ (v3 != null ? v3.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            s.this.f();
            V v4 = this.f57707b;
            this.f57707b = v3;
            return v4;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f57706a);
            String valueOf2 = String.valueOf(this.f57707b);
            StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb.append(valueOf);
            sb.append("=");
            sb.append(valueOf2);
            return sb.toString();
        }

        c(K k4, V v3) {
            this.f57706a = k4;
            this.f57707b = v3;
        }
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            s.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = s.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(s.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                s.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s.this.size();
        }

        /* synthetic */ e(s sVar, a aVar) {
            this();
        }
    }

    /* synthetic */ s(int i4, a aVar) {
        this(i4);
    }

    private int e(K k4) {
        int size = this.f57700b.size() - 1;
        if (size >= 0) {
            int compareTo = k4.compareTo(this.f57700b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i4 = 0;
        while (i4 <= size) {
            int i5 = (i4 + size) / 2;
            int compareTo2 = k4.compareTo(this.f57700b.get(i5).getKey());
            if (compareTo2 < 0) {
                size = i5 - 1;
            } else if (compareTo2 <= 0) {
                return i5;
            } else {
                i4 = i5 + 1;
            }
        }
        return -(i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f57702d) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.f57700b.isEmpty() || (this.f57700b instanceof ArrayList)) {
            return;
        }
        this.f57700b = new ArrayList(this.f57699a);
    }

    private SortedMap<K, V> k() {
        f();
        if (this.f57701c.isEmpty() && !(this.f57701c instanceof TreeMap)) {
            this.f57701c = new TreeMap();
        }
        return (SortedMap) this.f57701c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends g.b<FieldDescriptorType>> s<FieldDescriptorType, Object> n(int i4) {
        return new a(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V p(int i4) {
        f();
        V value = this.f57700b.remove(i4).getValue();
        if (!this.f57701c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = k().entrySet().iterator();
            this.f57700b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f57700b.isEmpty()) {
            this.f57700b.clear();
        }
        if (this.f57701c.isEmpty()) {
            return;
        }
        this.f57701c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f57701c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f57703e == null) {
            this.f57703e = new e(this, null);
        }
        return this.f57703e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e4 = e(comparable);
        if (e4 >= 0) {
            return this.f57700b.get(e4).getValue();
        }
        return this.f57701c.get(comparable);
    }

    public Map.Entry<K, V> h(int i4) {
        return this.f57700b.get(i4);
    }

    public int i() {
        return this.f57700b.size();
    }

    public Iterable<Map.Entry<K, V>> j() {
        return this.f57701c.isEmpty() ? b.b() : this.f57701c.entrySet();
    }

    public boolean l() {
        return this.f57702d;
    }

    public void m() {
        if (this.f57702d) {
            return;
        }
        this.f57701c = this.f57701c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f57701c);
        this.f57702d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: o */
    public V put(K k4, V v3) {
        f();
        int e4 = e(k4);
        if (e4 >= 0) {
            return this.f57700b.get(e4).setValue(v3);
        }
        g();
        int i4 = -(e4 + 1);
        if (i4 >= this.f57699a) {
            return k().put(k4, v3);
        }
        int size = this.f57700b.size();
        int i5 = this.f57699a;
        if (size == i5) {
            s<K, V>.c remove = this.f57700b.remove(i5 - 1);
            k().put((K) remove.getKey(), remove.getValue());
        }
        this.f57700b.add(i4, new c(k4, v3));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e4 = e(comparable);
        if (e4 >= 0) {
            return (V) p(e4);
        }
        if (this.f57701c.isEmpty()) {
            return null;
        }
        return this.f57701c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f57700b.size() + this.f57701c.size();
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        private int f57709a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f57710b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f57711c;

        private d() {
            this.f57709a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f57711c == null) {
                this.f57711c = s.this.f57701c.entrySet().iterator();
            }
            return this.f57711c;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f57710b = true;
            int i4 = this.f57709a + 1;
            this.f57709a = i4;
            if (i4 < s.this.f57700b.size()) {
                return (Map.Entry) s.this.f57700b.get(this.f57709a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57709a + 1 < s.this.f57700b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f57710b) {
                this.f57710b = false;
                s.this.f();
                if (this.f57709a < s.this.f57700b.size()) {
                    s sVar = s.this;
                    int i4 = this.f57709a;
                    this.f57709a = i4 - 1;
                    sVar.p(i4);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(s sVar, a aVar) {
            this();
        }
    }

    private s(int i4) {
        this.f57699a = i4;
        this.f57700b = Collections.emptyList();
        this.f57701c = Collections.emptyMap();
    }
}
