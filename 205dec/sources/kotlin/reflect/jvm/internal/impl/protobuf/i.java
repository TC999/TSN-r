package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i extends j {

    /* renamed from: e  reason: collision with root package name */
    private final n f57664e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyField.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, i> f57665a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f57665a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            i value = this.f57665a.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof n) {
                return this.f57665a.getValue().d((n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, i> entry) {
            this.f57665a = entry;
        }
    }

    /* compiled from: LazyField.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f57666a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f57666a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f57666a.next();
            return next.getValue() instanceof i ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57666a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f57666a.remove();
        }
    }

    public n e() {
        return c(this.f57664e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
