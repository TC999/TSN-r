package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.util.SparseArray;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationValueSetBuilder {

    /* renamed from: ok */
    private final SparseArray<Object> f22718ok;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class ValueSetImpl implements ValueSet {

        /* renamed from: ok */
        private final SparseArray<Object> f22719ok;

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f22719ok.get(i);
            if (obj == null) {
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
            return this.f22719ok.indexOfKey(i) >= 0;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.f22719ok.get(i);
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
            int size = this.f22719ok.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(i));
            }
            return hashSet;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.f22719ok.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.f22719ok.get(i);
            }
            return null;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f22719ok;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.f22719ok = sparseArray;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.f22719ok.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.f22719ok.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.f22719ok.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.f22719ok.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.f22719ok.get(i);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f22718ok = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i, Object obj) {
        this.f22718ok.put(i, obj);
        return this;
    }

    public <T> MediationValueSetBuilder addArray(int i, T[] tArr) {
        this.f22718ok.put(i, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f22718ok);
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

    public MediationValueSetBuilder add(int i, String str) {
        this.f22718ok.put(i, str);
        return this;
    }

    public MediationValueSetBuilder add(int i, int i2) {
        this.f22718ok.put(i, Integer.valueOf(i2));
        return this;
    }

    public MediationValueSetBuilder add(int i, double d) {
        this.f22718ok.put(i, Double.valueOf(d));
        return this;
    }

    public MediationValueSetBuilder add(int i, boolean z) {
        this.f22718ok.put(i, Boolean.valueOf(z));
        return this;
    }

    public MediationValueSetBuilder add(int i, long j) {
        this.f22718ok.put(i, Long.valueOf(j));
        return this;
    }

    public MediationValueSetBuilder add(int i, float f) {
        this.f22718ok.put(i, Float.valueOf(f));
        return this;
    }

    public MediationValueSetBuilder add(int i, ObjectGetter objectGetter) {
        this.f22718ok.put(i, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, StringGetter stringGetter) {
        this.f22718ok.put(i, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, DoubleGetter doubleGetter) {
        this.f22718ok.put(i, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, IntGetter intGetter) {
        this.f22718ok.put(i, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, BooleanGetter booleanGetter) {
        this.f22718ok.put(i, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, LongGetter longGetter) {
        this.f22718ok.put(i, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, FloatGetter floatGetter) {
        this.f22718ok.put(i, floatGetter);
        return this;
    }
}
