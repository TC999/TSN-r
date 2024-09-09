package com.qq.e.dl.k;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.dl.j.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f47029a = "n";

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f47030b = {48, 80, 3, 5, 16, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int f47031c = 6;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f47032d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements b.InterfaceC0917b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f47033a;

        a(c cVar) {
            this.f47033a = cVar;
        }

        @Override // com.qq.e.dl.j.b.InterfaceC0917b
        public void a(int i4) {
            this.f47033a.a(i4);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SparseIntArray f47034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f47035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f47036c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONArray f47037d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f47038e;

        b(SparseIntArray sparseIntArray, int i4, int i5, JSONArray jSONArray, d dVar) {
            this.f47034a = sparseIntArray;
            this.f47035b = i4;
            this.f47036c = i5;
            this.f47037d = jSONArray;
            this.f47038e = dVar;
        }

        @Override // com.qq.e.dl.k.n.c
        public void a(int i4) {
            this.f47034a.put(this.f47035b, i4);
            int size = this.f47034a.size();
            int i5 = this.f47036c;
            if (size != i5) {
                return;
            }
            int[] iArr = new int[i5];
            int i6 = 0;
            while (true) {
                int i7 = this.f47036c;
                if (i6 >= i7) {
                    n.b(this.f47037d, iArr, i7, this.f47038e);
                    return;
                } else {
                    iArr[i6] = this.f47034a.valueAt(i6);
                    i6++;
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(int i4);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a(Object[] objArr);
    }

    public static int b(g gVar) {
        int i4 = 0;
        int i5 = 0;
        for (int b4 = gVar.b(new JSONObject[0]); b4 > 0 && i4 < f47031c; b4 >>= 1) {
            if ((b4 & 1) > 0) {
                i5 |= f47030b[i4];
            }
            i4++;
        }
        return i5;
    }

    public static Pair<Float, Float> c(g gVar) {
        Object c4 = gVar.c(new JSONObject[0]);
        if (c4 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) c4;
            if (jSONArray.length() == 0) {
                return null;
            }
            return new Pair<>(Float.valueOf((float) jSONArray.optDouble(0, 1.0d)), Float.valueOf((float) jSONArray.optDouble(1, 1.0d)));
        }
        float d4 = gVar.d(new JSONObject[0]);
        return new Pair<>(Float.valueOf(d4), Float.valueOf(d4));
    }

    public static Pair<Float, Float> d(g gVar) {
        Object c4 = gVar.c(new JSONObject[0]);
        if (c4 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) c4;
            if (jSONArray.length() == 0) {
                return null;
            }
            return new Pair<>(Float.valueOf(l.c(jSONArray.opt(0)).f(new JSONObject[0]).d()), Float.valueOf(l.c(jSONArray.opt(1)).f(new JSONObject[0]).d()));
        }
        Float valueOf = Float.valueOf(gVar.f(new JSONObject[0]).d());
        return new Pair<>(valueOf, valueOf);
    }

    public static int a(g gVar) {
        Integer num;
        String obj = gVar.toString();
        if (TextUtils.isEmpty(obj)) {
            num = null;
        } else if (f47032d.size() <= 0 || (num = f47032d.get(obj)) == null) {
            num = Integer.valueOf(Color.parseColor(obj));
            f47032d.put(obj, num);
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONArray jSONArray, int[] iArr, int i4, d dVar) {
        int length;
        int optInt = jSONArray.optInt(1);
        JSONArray optJSONArray = jSONArray.optJSONArray(2);
        int length2 = optJSONArray == null ? 0 : optJSONArray.length();
        float[] fArr = null;
        float[] fArr2 = (length2 == 0 || length2 != i4) ? null : new float[length2];
        if (fArr2 != null) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr2[i5] = (float) optJSONArray.optDouble(i5);
            }
        }
        JSONArray optJSONArray2 = jSONArray.optJSONArray(3);
        if (optJSONArray2 != null && (length = optJSONArray2.length()) >= 0) {
            fArr = new float[length];
            for (int i6 = 0; i6 < length; i6++) {
                fArr[i6] = (float) optJSONArray2.optDouble(i6);
            }
        }
        dVar.a(new Object[]{iArr, Integer.valueOf(optInt), fArr2, fArr});
    }

    public static void a(g gVar, com.qq.e.dl.b bVar, c cVar) {
        String obj = gVar.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        Integer num = f47032d.get(obj);
        if (num != null) {
            cVar.a(num.intValue());
            return;
        }
        try {
            if ('#' != obj.charAt(0)) {
                if (bVar == null) {
                    return;
                }
                com.qq.e.dl.j.b.a(bVar, obj, new a(cVar));
                return;
            }
            Integer valueOf = Integer.valueOf(Color.parseColor(obj));
            if (valueOf != null) {
                f47032d.put(obj, valueOf);
                cVar.a(valueOf.intValue());
            }
        } catch (Exception e4) {
            d1.a(f47029a, e4.getMessage());
        } finally {
            cVar.a(0);
        }
    }

    public static int[] b(g gVar, int i4, int i5) {
        int[] iArr = new int[4];
        Object c4 = gVar.c(new JSONObject[0]);
        if (c4 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) c4;
            if (jSONArray.length() != 4) {
                return null;
            }
            for (int i6 = 0; i6 < 3; i6++) {
                iArr[i6] = l.c(jSONArray.opt(i6)).f(new JSONObject[0]).a(i4, i5);
            }
            iArr[3] = a(l.c(jSONArray.opt(3)));
            return iArr;
        }
        return null;
    }

    public static void a(g gVar, com.qq.e.dl.b bVar, d dVar) {
        int length;
        Object c4 = gVar.c(new JSONObject[0]);
        if (c4 instanceof String) {
            try {
                c4 = new JSONArray(c4.toString());
            } catch (Throwable unused) {
                d1.b(f47029a, "not a JSONArray");
            }
        }
        if (!(c4 instanceof JSONArray)) {
            dVar.a(null);
            return;
        }
        JSONArray jSONArray = (JSONArray) c4;
        if (jSONArray.length() < 2) {
            dVar.a(null);
        }
        JSONArray optJSONArray = jSONArray.optJSONArray(0);
        if (optJSONArray != null && (length = optJSONArray.length()) >= 2) {
            SparseIntArray sparseIntArray = new SparseIntArray(length);
            for (int i4 = 0; i4 < length; i4++) {
                Object opt = optJSONArray.opt(i4);
                if (opt == null) {
                    dVar.a(null);
                    return;
                }
                a(l.c(opt), bVar, new b(sparseIntArray, i4, length, jSONArray, dVar));
            }
            return;
        }
        dVar.a(null);
    }

    public static int[] a(g gVar, int i4, int i5) {
        int[] iArr = new int[4];
        boolean z3 = false;
        if (gVar.c(new JSONObject[0]) instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) gVar.c(new JSONObject[0]);
            int min = Math.min(4, jSONArray.length());
            boolean z4 = false;
            for (int i6 = 0; i6 < min; i6++) {
                int a4 = l.c(jSONArray.opt(i6)).f(new JSONObject[0]).a(i4, i5);
                if (a4 > 0) {
                    iArr[i6] = a4;
                    z4 = true;
                }
            }
            z3 = z4;
        } else {
            int a5 = gVar.f(new JSONObject[0]).a(i4, i5);
            if (a5 > 0) {
                iArr[3] = a5;
                iArr[2] = a5;
                iArr[1] = a5;
                iArr[0] = a5;
                z3 = true;
            }
        }
        if (z3) {
            return iArr;
        }
        return null;
    }
}
