package com.bykv.c.c.c.c;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final ValueSet f24740c = b(0).l();

    /* renamed from: d  reason: collision with root package name */
    public static final Bridge f24741d = new C0328b();

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Object> f24742a;

    /* renamed from: b  reason: collision with root package name */
    private ValueSet f24743b;

    /* renamed from: com.bykv.c.c.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static final class C0328b implements Bridge {
        private C0328b() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class) {
                return (T) Boolean.FALSE;
            }
            if (cls != Integer.TYPE && cls != Integer.class) {
                if (cls != Long.TYPE && cls != Long.class) {
                    if (cls != Double.TYPE && cls != Double.class) {
                        if (cls == Float.TYPE || cls == Float.class) {
                            return (T) new Float(0.0f);
                        }
                        return null;
                    }
                    return (T) new Double(0.0d);
                }
                return (T) new Long(0L);
            }
            return (T) new Integer(0);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return b.f24740c;
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public interface c extends ValueSet.ValueGetter<Integer> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class d implements ValueSet {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Object> f24744a;

        /* renamed from: b  reason: collision with root package name */
        private ValueSet f24745b;

        /* renamed from: c  reason: collision with root package name */
        private int f24746c;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i4, Class<T> cls) {
            Object obj = this.f24744a.get(i4);
            if (obj == null) {
                ValueSet valueSet = this.f24745b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i4, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i4) {
            return booleanValue(i4, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i4) {
            ValueSet valueSet;
            int indexOfKey = this.f24744a.indexOfKey(i4);
            if (indexOfKey >= 0 || (valueSet = this.f24745b) == null) {
                return indexOfKey >= 0;
            }
            return valueSet.containsKey(i4);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i4) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj == null && (valueSet = this.f24745b) != null) {
                return valueSet.doubleValue(i4);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i4) {
            return floatValue(i4, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i4) {
            return intValue(i4, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f24744a.size();
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < size; i4++) {
                hashSet.add(Integer.valueOf(this.f24744a.keyAt(i4)));
            }
            ValueSet valueSet = this.f24745b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f24746c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i4) {
            return longValue(i4, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i4, Class<T> cls) {
            Object obj = this.f24744a.get(i4);
            if (obj == null) {
                ValueSet valueSet = this.f24745b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i4, cls);
                }
                return null;
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) obj;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f24746c < 0) {
                keys();
            }
            return this.f24746c;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i4) {
            return stringValue(i4, null);
        }

        private d(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f24746c = -1;
            this.f24744a = sparseArray;
            this.f24745b = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i4, boolean z3) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj == null && (valueSet = this.f24745b) != null) {
                return valueSet.booleanValue(i4, z3);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i4, float f4) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj == null && (valueSet = this.f24745b) != null) {
                return valueSet.floatValue(i4, f4);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f4;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i4, int i5) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj == null && (valueSet = this.f24745b) != null) {
                return valueSet.intValue(i4, i5);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i5;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i4, long j4) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj == null && (valueSet = this.f24745b) != null) {
                return valueSet.longValue(i4, j4);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j4;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i4, String str) {
            ValueSet valueSet;
            Object obj = this.f24744a.get(i4);
            if (obj != null || (valueSet = this.f24745b) == null) {
                return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
            }
            return valueSet.stringValue(i4, str);
        }
    }

    private b(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.f24742a = sparseArray;
        this.f24743b = valueSet;
    }

    public static final b a() {
        return new b(new SparseArray());
    }

    public static final b b(int i4) {
        return new b(new SparseArray(i4));
    }

    public static final b k(ValueSet valueSet) {
        return new b(new SparseArray(), valueSet);
    }

    public b c(int i4, double d4) {
        this.f24742a.put(i4, Double.valueOf(d4));
        return this;
    }

    public b d(int i4, float f4) {
        this.f24742a.put(i4, Float.valueOf(f4));
        return this;
    }

    public b e(int i4, int i5) {
        this.f24742a.put(i4, Integer.valueOf(i5));
        return this;
    }

    public b f(int i4, long j4) {
        this.f24742a.put(i4, Long.valueOf(j4));
        return this;
    }

    public b g(int i4, c cVar) {
        this.f24742a.put(i4, cVar);
        return this;
    }

    public b h(int i4, Object obj) {
        this.f24742a.put(i4, obj);
        return this;
    }

    public b i(int i4, String str) {
        this.f24742a.put(i4, str);
        return this;
    }

    public b j(int i4, boolean z3) {
        this.f24742a.put(i4, Boolean.valueOf(z3));
        return this;
    }

    public ValueSet l() {
        return new d(this.f24742a, this.f24743b);
    }

    private b(SparseArray<Object> sparseArray) {
        this.f24742a = sparseArray;
    }
}
