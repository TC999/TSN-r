package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12896i {

    /* renamed from: a */
    private StringBuilder f36879a;

    /* renamed from: b */
    private int f36880b;

    public C12896i(StringBuilder sb, int i) {
        this.f36879a = sb;
        this.f36880b = i;
    }

    /* renamed from: a */
    private void m15646a(String str) {
        for (int i = 0; i < this.f36880b; i++) {
            this.f36879a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f36879a;
            sb.append(str);
            sb.append(": ");
        }
    }

    /* renamed from: a */
    public final C12896i m15641a(boolean z, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C12896i m15654a(byte b, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    private C12896i m15653a(char c, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(c);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C12896i m15642a(short s, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C12896i m15650a(int i, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C12896i m15649a(long j, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    private C12896i m15651a(float f, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(f);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    private C12896i m15652a(double d, String str) {
        m15646a(str);
        StringBuilder sb = this.f36879a;
        sb.append(d);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C12896i m15645a(String str, String str2) {
        m15646a(str2);
        if (str == null) {
            this.f36879a.append("null\n");
        } else {
            StringBuilder sb = this.f36879a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public final C12896i m15640a(byte[] bArr, String str) {
        m15646a(str);
        if (bArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (byte b : bArr) {
                c12896i.m15654a(b, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private C12896i m15634a(short[] sArr, String str) {
        m15646a(str);
        if (sArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(sArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (short s : sArr) {
                c12896i.m15642a(s, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private C12896i m15637a(int[] iArr, String str) {
        m15646a(str);
        if (iArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(iArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (int i : iArr) {
                c12896i.m15650a(i, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private C12896i m15636a(long[] jArr, String str) {
        m15646a(str);
        if (jArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(jArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (long j : jArr) {
                c12896i.m15649a(j, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private C12896i m15638a(float[] fArr, String str) {
        m15646a(str);
        if (fArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(fArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (float f : fArr) {
                c12896i.m15651a(f, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private C12896i m15639a(double[] dArr, String str) {
        m15646a(str);
        if (dArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(dArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (double d : dArr) {
                c12896i.m15652a(d, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    public final <K, V> C12896i m15643a(Map<K, V> map, String str) {
        m15646a(str);
        if (map == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f36879a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(map.size());
            sb2.append(", {\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            C12896i c12896i2 = new C12896i(this.f36879a, this.f36880b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                c12896i.m15653a('(', (String) null);
                c12896i2.m15647a((C12896i) entry.getKey(), (String) null);
                c12896i2.m15647a((C12896i) entry.getValue(), (String) null);
                c12896i.m15653a(')', (String) null);
            }
            m15653a('}', (String) null);
            return this;
        }
    }

    /* renamed from: a */
    private <T> C12896i m15635a(T[] tArr, String str) {
        m15646a(str);
        if (tArr == null) {
            this.f36879a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f36879a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f36879a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            C12896i c12896i = new C12896i(this.f36879a, this.f36880b + 1);
            for (T t : tArr) {
                c12896i.m15647a((C12896i) t, (String) null);
            }
            m15653a(']', (String) null);
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> C12896i m15644a(Collection<T> collection, String str) {
        if (collection == null) {
            m15646a(str);
            this.f36879a.append("null\t");
            return this;
        }
        return m15635a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> C12896i m15647a(T t, String str) {
        if (t == null) {
            this.f36879a.append("null\n");
        } else if (t instanceof Byte) {
            m15654a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            m15641a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            m15642a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            m15650a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            m15649a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            m15651a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            m15652a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            m15645a((String) t, str);
        } else if (t instanceof Map) {
            m15643a((Map) t, str);
        } else if (t instanceof List) {
            m15644a((Collection) ((List) t), str);
        } else if (t instanceof AbstractC12901m) {
            m15648a((AbstractC12901m) t, str);
        } else if (t instanceof byte[]) {
            m15640a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m15647a((C12896i) ((boolean[]) t), str);
        } else if (t instanceof short[]) {
            m15634a((short[]) t, str);
        } else if (t instanceof int[]) {
            m15637a((int[]) t, str);
        } else if (t instanceof long[]) {
            m15636a((long[]) t, str);
        } else if (t instanceof float[]) {
            m15638a((float[]) t, str);
        } else if (t instanceof double[]) {
            m15639a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            m15635a((Object[]) t, str);
        } else {
            throw new C12897j("write object error: unsupport type.");
        }
        return this;
    }

    /* renamed from: a */
    public final C12896i m15648a(AbstractC12901m abstractC12901m, String str) {
        m15653a('{', str);
        if (abstractC12901m == null) {
            StringBuilder sb = this.f36879a;
            sb.append('\t');
            sb.append("null");
        } else {
            abstractC12901m.mo15577a(this.f36879a, this.f36880b + 1);
        }
        m15653a('}', (String) null);
        return this;
    }
}
