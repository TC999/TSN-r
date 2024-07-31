package com.bykv.p106ok.p107ok.p108ok.p109ok;

import android.util.SparseArray;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bykv.ok.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C5930a {

    /* renamed from: c */
    public static final ValueSet f21279c = m37924c(0).m37926a();

    /* renamed from: d */
    public static final Bridge f21280d = new C5933c();

    /* renamed from: a */
    private final SparseArray<Object> f21281a;

    /* renamed from: b */
    private ValueSet f21282b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bykv.ok.ok.ok.ok.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5932b implements ValueSet {

        /* renamed from: a */
        private final SparseArray<Object> f21283a;

        /* renamed from: b */
        private ValueSet f21284b;

        /* renamed from: c */
        private int f21285c;

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f21283a.get(i);
            if (obj == null) {
                ValueSet valueSet = this.f21284b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int indexOfKey = this.f21283a.indexOfKey(i);
            if (indexOfKey >= 0 || (valueSet = this.f21284b) == null) {
                return indexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj == null && (valueSet = this.f21284b) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : Utils.DOUBLE_EPSILON;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f21283a.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f21283a.keyAt(i)));
            }
            ValueSet valueSet = this.f21284b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f21285c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.f21283a.get(i);
            if (obj == null) {
                ValueSet valueSet = this.f21284b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
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

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f21285c < 0) {
                keys();
            }
            return this.f21285c;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        private C5932b(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f21285c = -1;
            this.f21283a = sparseArray;
            this.f21284b = valueSet;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj == null && (valueSet = this.f21284b) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj == null && (valueSet = this.f21284b) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj == null && (valueSet = this.f21284b) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj == null && (valueSet = this.f21284b) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.f21283a.get(i);
            if (obj != null || (valueSet = this.f21284b) == null) {
                return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
            }
            return valueSet.stringValue(i, str);
        }
    }

    /* renamed from: com.bykv.ok.ok.ok.ok.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class C5933c implements Bridge {
        private C5933c() {
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
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
                    return (T) new Double((double) Utils.DOUBLE_EPSILON);
                }
                return (T) new Long(0L);
            }
            return (T) new Integer(0);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return C5930a.f21279c;
        }
    }

    private C5930a(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.f21281a = sparseArray;
        this.f21282b = valueSet;
    }

    /* renamed from: b */
    public static final C5930a m37925b() {
        return new C5930a(new SparseArray());
    }

    /* renamed from: c */
    public static final C5930a m37924c(int i) {
        return new C5930a(new SparseArray(i));
    }

    /* renamed from: k */
    public static final C5930a m37916k(ValueSet valueSet) {
        return new C5930a(new SparseArray(), valueSet);
    }

    /* renamed from: a */
    public ValueSet m37926a() {
        return new C5932b(this.f21281a, this.f21282b);
    }

    /* renamed from: d */
    public C5930a m37923d(int i, double d) {
        this.f21281a.put(i, Double.valueOf(d));
        return this;
    }

    /* renamed from: e */
    public C5930a m37922e(int i, float f) {
        this.f21281a.put(i, Float.valueOf(f));
        return this;
    }

    /* renamed from: f */
    public C5930a m37921f(int i, int i2) {
        this.f21281a.put(i, Integer.valueOf(i2));
        return this;
    }

    /* renamed from: g */
    public C5930a m37920g(int i, long j) {
        this.f21281a.put(i, Long.valueOf(j));
        return this;
    }

    /* renamed from: h */
    public C5930a m37919h(int i, Object obj) {
        this.f21281a.put(i, obj);
        return this;
    }

    /* renamed from: i */
    public C5930a m37918i(int i, String str) {
        this.f21281a.put(i, str);
        return this;
    }

    /* renamed from: j */
    public C5930a m37917j(int i, boolean z) {
        this.f21281a.put(i, Boolean.valueOf(z));
        return this;
    }

    private C5930a(SparseArray<Object> sparseArray) {
        this.f21281a = sparseArray;
    }
}
