package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f51246a;

    /* renamed from: b  reason: collision with root package name */
    private int f51247b;

    public i(StringBuilder sb, int i4) {
        this.f51246a = sb;
        this.f51247b = i4;
    }

    private void a(String str) {
        for (int i4 = 0; i4 < this.f51247b; i4++) {
            this.f51246a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f51246a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public final i a(boolean z3, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(z3 ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final i a(byte b4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append((int) b4);
        sb.append('\n');
        return this;
    }

    private i a(char c4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(c4);
        sb.append('\n');
        return this;
    }

    public final i a(short s3, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append((int) s3);
        sb.append('\n');
        return this;
    }

    public final i a(int i4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(i4);
        sb.append('\n');
        return this;
    }

    public final i a(long j4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(j4);
        sb.append('\n');
        return this;
    }

    private i a(float f4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(f4);
        sb.append('\n');
        return this;
    }

    private i a(double d4, String str) {
        a(str);
        StringBuilder sb = this.f51246a;
        sb.append(d4);
        sb.append('\n');
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f51246a.append("null\n");
        } else {
            StringBuilder sb = this.f51246a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (byte b4 : bArr) {
                iVar.a(b4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(sArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(sArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (short s3 : sArr) {
                iVar.a(s3, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(iArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(iArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (int i4 : iArr) {
                iVar.a(i4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(jArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(jArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (long j4 : jArr) {
                iVar.a(j4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(fArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(fArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (float f4 : fArr) {
                iVar.a(f4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(dArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(dArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (double d4 : dArr) {
                iVar.a(d4, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f51246a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(map.size());
            sb2.append(", {\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            i iVar2 = new i(this.f51246a, this.f51247b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                iVar.a('(', (String) null);
                iVar2.a((i) entry.getKey(), (String) null);
                iVar2.a((i) entry.getValue(), (String) null);
                iVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f51246a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f51246a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f51246a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            i iVar = new i(this.f51246a, this.f51247b + 1);
            for (T t3 : tArr) {
                iVar.a((i) t3, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f51246a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t3, String str) {
        if (t3 == null) {
            this.f51246a.append("null\n");
        } else if (t3 instanceof Byte) {
            a(((Byte) t3).byteValue(), str);
        } else if (t3 instanceof Boolean) {
            a(((Boolean) t3).booleanValue(), str);
        } else if (t3 instanceof Short) {
            a(((Short) t3).shortValue(), str);
        } else if (t3 instanceof Integer) {
            a(((Integer) t3).intValue(), str);
        } else if (t3 instanceof Long) {
            a(((Long) t3).longValue(), str);
        } else if (t3 instanceof Float) {
            a(((Float) t3).floatValue(), str);
        } else if (t3 instanceof Double) {
            a(((Double) t3).doubleValue(), str);
        } else if (t3 instanceof String) {
            a((String) t3, str);
        } else if (t3 instanceof Map) {
            a((Map) t3, str);
        } else if (t3 instanceof List) {
            a((Collection) ((List) t3), str);
        } else if (t3 instanceof m) {
            a((m) t3, str);
        } else if (t3 instanceof byte[]) {
            a((byte[]) t3, str);
        } else if (t3 instanceof boolean[]) {
            a((i) ((boolean[]) t3), str);
        } else if (t3 instanceof short[]) {
            a((short[]) t3, str);
        } else if (t3 instanceof int[]) {
            a((int[]) t3, str);
        } else if (t3 instanceof long[]) {
            a((long[]) t3, str);
        } else if (t3 instanceof float[]) {
            a((float[]) t3, str);
        } else if (t3 instanceof double[]) {
            a((double[]) t3, str);
        } else if (t3.getClass().isArray()) {
            a((Object[]) t3, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f51246a;
            sb.append('\t');
            sb.append("null");
        } else {
            mVar.a(this.f51246a, this.f51247b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
