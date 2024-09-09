package com.qq.e.dl.f;

import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, d> f46881a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final TimeInterpolator f46882b = new LinearInterpolator();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements d {
        private b() {
        }

        @Override // com.qq.e.dl.f.q.d
        public TimeInterpolator a(JSONArray jSONArray) {
            int length;
            if (Build.VERSION.SDK_INT < 21 || jSONArray == null || (length = jSONArray.length()) < 2) {
                return null;
            }
            if (length > 3) {
                return new PathInterpolator((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1), (float) jSONArray.optDouble(2), (float) jSONArray.optDouble(3));
            }
            return new PathInterpolator((float) jSONArray.optDouble(0), (float) jSONArray.optDouble(1));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c extends BounceInterpolator implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f46883a;

        c(int i4) {
            this.f46883a = i4;
        }

        @Override // com.qq.e.dl.f.q.d
        public TimeInterpolator a(JSONArray jSONArray) {
            return this;
        }

        @Override // android.view.animation.BounceInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            int i4 = this.f46883a;
            if (i4 != 1) {
                if (i4 != 2) {
                    return super.getInterpolation(f4);
                }
                if (f4 < 0.5d) {
                    return (1.0f - super.getInterpolation(1.0f - (f4 * 2.0f))) / 2.0f;
                }
                return (super.getInterpolation((f4 * 2.0f) - 1.0f) + 1.0f) / 2.0f;
            }
            return 1.0f - super.getInterpolation(1.0f - f4);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private interface d {
        TimeInterpolator a(JSONArray jSONArray);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class e implements d, TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private final int f46884a;

        e(int i4) {
            this.f46884a = i4;
        }

        private float a(float f4, float f5, int i4) {
            if (f4 == 0.0f || f4 == 1.0f) {
                return f4;
            }
            double d4 = ((i4 * f4) - 1.0f) * 10.0f;
            double d5 = f5;
            Double.isNaN(d5);
            Double.isNaN(d4);
            Double.isNaN(d5);
            return (float) ((-Math.pow(2.0d, d4)) * Math.sin(((d4 - (0.25d * d5)) * 6.283185307179586d) / d5));
        }

        private float b(float f4, float f5, int i4) {
            if (f4 == 0.0f || f4 == 1.0f) {
                return f4;
            }
            float f6 = i4;
            double d4 = (((f4 * f6) + 1.0f) - f6) * 10.0f;
            Double.isNaN(d4);
            double pow = Math.pow(2.0d, -d4);
            double d5 = f5;
            Double.isNaN(d5);
            Double.isNaN(d4);
            Double.isNaN(d5);
            return (float) ((pow * Math.sin(((d4 - (0.25d * d5)) * 6.283185307179586d) / d5)) + 1.0d);
        }

        @Override // com.qq.e.dl.f.q.d
        public TimeInterpolator a(JSONArray jSONArray) {
            return this;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            int i4 = this.f46884a;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return f4;
                    }
                    return (((double) f4) < 0.5d ? a(f4, 4.5f, 2) : b(f4, 4.5f, 2)) / 2.0f;
                }
                return a(f4, 3.0f, 1);
            }
            return b(f4, 3.0f, 1);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class f implements d {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements TimeInterpolator {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ double f46885a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ double f46886b;

            a(f fVar, double d4, double d5) {
                this.f46885a = d4;
                this.f46886b = d5;
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f4) {
                double d4 = f4;
                double d5 = this.f46885a;
                Double.isNaN(d4);
                return (float) Math.sin(((d4 * d5) + this.f46886b) * 3.141592653589793d);
            }
        }

        private f() {
        }

        @Override // com.qq.e.dl.f.q.d
        public TimeInterpolator a(JSONArray jSONArray) {
            double d4 = 0.0d;
            double d5 = 1.0d;
            if (jSONArray != null && jSONArray.length() >= 2) {
                d4 = jSONArray.optDouble(0, 0.0d);
                d5 = jSONArray.optDouble(1, 1.0d);
            }
            double d6 = d4;
            return new a(this, d5 - d6, d6);
        }
    }

    static {
        f46881a.put(25, new e(1));
        f46881a.put(26, new e(0));
        f46881a.put(27, new e(2));
        f46881a.put(28, new c(1));
        f46881a.put(29, new c(0));
        f46881a.put(30, new c(2));
        f46881a.put(31, new b());
        f46881a.put(32, new f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeInterpolator a(com.qq.e.dl.i.a aVar) {
        int i4 = aVar.f46916i;
        if (i4 > 0 && i4 < 25) {
            i4 = 31;
        }
        d dVar = f46881a.get(Integer.valueOf(i4));
        return dVar == null ? f46882b : dVar.a(aVar.f46917j);
    }
}
