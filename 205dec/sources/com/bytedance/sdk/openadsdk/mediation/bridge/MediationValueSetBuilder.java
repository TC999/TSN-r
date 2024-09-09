package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationValueSetBuilder {

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Object> f36063c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class ValueSetImpl implements ValueSet {

        /* renamed from: c  reason: collision with root package name */
        private final SparseArray<Object> f36064c;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i4, Class<T> cls) {
            Object obj = this.f36064c.get(i4);
            if (obj == null) {
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
            return this.f36064c.indexOfKey(i4) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i4) {
            Object obj = this.f36064c.get(i4);
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
            int size = this.f36064c.size();
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < size; i4++) {
                hashSet.add(Integer.valueOf(i4));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i4) {
            return longValue(i4, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i4, Class<T> cls) {
            Object obj = this.f36064c.get(i4);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.f36064c.get(i4);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f36064c;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i4) {
            return stringValue(i4, null);
        }

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.f36064c = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i4, boolean z3) {
            Object obj = this.f36064c.get(i4);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i4, float f4) {
            Object obj = this.f36064c.get(i4);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f4;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i4, int i5) {
            Object obj = this.f36064c.get(i4);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i5;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i4, long j4) {
            Object obj = this.f36064c.get(i4);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j4;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i4, String str) {
            Object obj = this.f36064c.get(i4);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f36063c = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i4, Object obj) {
        this.f36063c.put(i4, obj);
        return this;
    }

    public <T> MediationValueSetBuilder addArray(int i4, T[] tArr) {
        this.f36063c.put(i4, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f36063c);
    }

    public static final MediationValueSetBuilder create(ValueSet valueSet) {
        if (valueSet != null && !valueSet.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            for (Integer num : valueSet.keys()) {
                sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
            }
            return new MediationValueSetBuilder(sparseArray);
        }
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i4, String str) {
        this.f36063c.put(i4, str);
        return this;
    }

    public MediationValueSetBuilder add(int i4, int i5) {
        this.f36063c.put(i4, Integer.valueOf(i5));
        return this;
    }

    public MediationValueSetBuilder add(int i4, double d4) {
        this.f36063c.put(i4, Double.valueOf(d4));
        return this;
    }

    public MediationValueSetBuilder add(int i4, boolean z3) {
        this.f36063c.put(i4, Boolean.valueOf(z3));
        return this;
    }

    public MediationValueSetBuilder add(int i4, long j4) {
        this.f36063c.put(i4, Long.valueOf(j4));
        return this;
    }

    public MediationValueSetBuilder add(int i4, float f4) {
        this.f36063c.put(i4, Float.valueOf(f4));
        return this;
    }

    public MediationValueSetBuilder add(int i4, ObjectGetter objectGetter) {
        this.f36063c.put(i4, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, StringGetter stringGetter) {
        this.f36063c.put(i4, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, DoubleGetter doubleGetter) {
        this.f36063c.put(i4, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, IntGetter intGetter) {
        this.f36063c.put(i4, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, BooleanGetter booleanGetter) {
        this.f36063c.put(i4, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, LongGetter longGetter) {
        this.f36063c.put(i4, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i4, FloatGetter floatGetter) {
        this.f36063c.put(i4, floatGetter);
        return this;
    }
}
