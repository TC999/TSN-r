package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Trace;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.n;
import com.bytedance.adsdk.lottie.xv.w;
import com.bytedance.adsdk.lottie.xv.w.fz;
import com.bytedance.adsdk.lottie.xv.w.gd;
import com.bytedance.adsdk.lottie.xv.w.p;
import com.bytedance.adsdk.lottie.xv.w.s;
import com.bytedance.adsdk.lottie.xv.xv.sr;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f25706a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f25707b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f25708c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f25709d = true;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f25710e;

    /* renamed from: f  reason: collision with root package name */
    private static long[] f25711f;

    /* renamed from: g  reason: collision with root package name */
    private static int f25712g;

    /* renamed from: h  reason: collision with root package name */
    private static int f25713h;

    /* renamed from: i  reason: collision with root package name */
    private static com.bytedance.adsdk.lottie.sr.c f25714i;

    /* renamed from: j  reason: collision with root package name */
    private static com.bytedance.adsdk.lottie.sr.f f25715j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile com.bytedance.adsdk.lottie.sr.b f25716k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile com.bytedance.adsdk.lottie.sr.d f25717l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a implements com.bytedance.adsdk.lottie.sr.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f25718a;

        a(Context context) {
            this.f25718a = context;
        }

        @Override // com.bytedance.adsdk.lottie.sr.f
        public File c() {
            return new File(com.bytedance.sdk.openadsdk.api.plugin.w.w(this.f25718a), "lottie_network_cache");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a0 implements t<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final a0 f25719a = new a0();

        private a0() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public Integer a(JsonReader jsonReader, float f4) throws IOException {
            return Integer.valueOf(Math.round(l.e(jsonReader) * f4));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b implements t<Float> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f25720a = new b();

        private b() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public Float a(JsonReader jsonReader, float f4) throws IOException {
            return Float.valueOf(l.e(jsonReader) * f4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b0 {
        public static com.bytedance.adsdk.lottie.xv.c.m a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return b(jsonReader, eVar, true);
        }

        public static com.bytedance.adsdk.lottie.xv.c.m b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, boolean z3) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.m(d(jsonReader, z3 ? com.bytedance.adsdk.lottie.f.b.a() : 1.0f, eVar, b.f25720a));
        }

        static com.bytedance.adsdk.lottie.xv.c.n c(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, int i4) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.n(e(jsonReader, eVar, new m0(i4)));
        }

        private static <T> List<n.h<T>> d(JsonReader jsonReader, float f4, com.bytedance.adsdk.lottie.e eVar, t<T> tVar) throws IOException {
            return o.a(jsonReader, eVar, f4, tVar, false);
        }

        private static <T> List<n.h<T>> e(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, t<T> tVar) throws IOException {
            return o.a(jsonReader, eVar, 1.0f, tVar, false);
        }

        static com.bytedance.adsdk.lottie.xv.c.h f(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.h(d(jsonReader, com.bytedance.adsdk.lottie.f.b.a(), eVar, n.f25728a));
        }

        static com.bytedance.adsdk.lottie.xv.c.c g(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.c(e(jsonReader, eVar, z.f25741a));
        }

        static com.bytedance.adsdk.lottie.xv.c.i h(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.i(e(jsonReader, eVar, g0.f25724a));
        }

        static com.bytedance.adsdk.lottie.xv.c.d i(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.d(d(jsonReader, com.bytedance.adsdk.lottie.f.b.a(), eVar, j0.f25725a));
        }

        static com.bytedance.adsdk.lottie.xv.c.j j(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.j(e(jsonReader, eVar, a0.f25719a));
        }

        static com.bytedance.adsdk.lottie.xv.c.e k(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.xv.c.e(o.a(jsonReader, eVar, com.bytedance.adsdk.lottie.f.b.a(), o0.f25729a, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {
        static com.bytedance.adsdk.lottie.xv.w.p a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, int i4) throws IOException {
            boolean z3 = i4 == 3;
            String str = null;
            p.c cVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar3 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar4 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar5 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar6 = null;
            boolean z4 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3369:
                        if (nextName.equals("ir")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3370:
                        if (nextName.equals("is")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3555:
                        if (nextName.equals("or")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 3556:
                        if (nextName.equals("os")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 3588:
                        if (nextName.equals("pt")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                    case 3686:
                        if (nextName.equals("sy")) {
                            c4 = '\n';
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextInt() == 3;
                        break;
                    case 1:
                        bVar = f.b(jsonReader, eVar);
                        break;
                    case 2:
                        mVar2 = b0.b(jsonReader, eVar, false);
                        break;
                    case 3:
                        z4 = jsonReader.nextBoolean();
                        break;
                    case 4:
                        mVar3 = b0.a(jsonReader, eVar);
                        break;
                    case 5:
                        mVar5 = b0.b(jsonReader, eVar, false);
                        break;
                    case 6:
                        str = jsonReader.nextString();
                        break;
                    case 7:
                        mVar4 = b0.a(jsonReader, eVar);
                        break;
                    case '\b':
                        mVar6 = b0.b(jsonReader, eVar, false);
                        break;
                    case '\t':
                        mVar = b0.b(jsonReader, eVar, false);
                        break;
                    case '\n':
                        cVar = p.c.c(jsonReader.nextInt());
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.p(str, cVar, mVar, bVar, mVar2, mVar3, mVar4, mVar5, mVar6, z4, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c0 {
        static com.bytedance.adsdk.lottie.xv.f a(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            float f4 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case -1866931350:
                        if (nextName.equals("fFamily")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1408684838:
                        if (nextName.equals("ascent")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -1294566165:
                        if (nextName.equals("fStyle")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 96619537:
                        if (nextName.equals("fName")) {
                            c4 = 3;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        str = jsonReader.nextString();
                        break;
                    case 1:
                        f4 = (float) jsonReader.nextDouble();
                        break;
                    case 2:
                        str3 = jsonReader.nextString();
                        break;
                    case 3:
                        str2 = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return new com.bytedance.adsdk.lottie.xv.f(str, str2, str3, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class d {
        static com.bytedance.adsdk.lottie.xv.d a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            double d4 = 0.0d;
            double d5 = 0.0d;
            char c4 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c5 = '\uffff';
                switch (nextName.hashCode()) {
                    case -1866931350:
                        if (nextName.equals("fFamily")) {
                            c5 = 0;
                            break;
                        }
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c5 = 1;
                            break;
                        }
                        break;
                    case 3173:
                        if (nextName.equals("ch")) {
                            c5 = 2;
                            break;
                        }
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c5 = 3;
                            break;
                        }
                        break;
                    case 3530753:
                        if (nextName.equals("size")) {
                            c5 = 4;
                            break;
                        }
                        break;
                    case 109780401:
                        if (nextName.equals("style")) {
                            c5 = 5;
                            break;
                        }
                        break;
                }
                switch (c5) {
                    case 0:
                        str2 = jsonReader.nextString();
                        break;
                    case 1:
                        d5 = jsonReader.nextDouble();
                        break;
                    case 2:
                        c4 = jsonReader.nextString().charAt(0);
                        break;
                    case 3:
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if ("shapes".equals(jsonReader.nextName())) {
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    arrayList.add((com.bytedance.adsdk.lottie.xv.w.e) i.a(jsonReader, eVar));
                                }
                                jsonReader.endArray();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        break;
                    case 4:
                        d4 = jsonReader.nextDouble();
                        break;
                    case 5:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return new com.bytedance.adsdk.lottie.xv.d(arrayList, c4, d4, d5, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class d0 {

        /* renamed from: a  reason: collision with root package name */
        private static final Interpolator f25721a = new LinearInterpolator();

        /* renamed from: b  reason: collision with root package name */
        private static SparseArray<WeakReference<Interpolator>> f25722b;

        d0() {
        }

        private static SparseArray<WeakReference<Interpolator>> a() {
            if (f25722b == null) {
                f25722b = new SparseArray<>();
            }
            return f25722b;
        }

        private static Interpolator b(PointF pointF, PointF pointF2) {
            Interpolator linearInterpolator;
            pointF.x = com.bytedance.adsdk.lottie.f.d.h(pointF.x, -1.0f, 1.0f);
            pointF.y = com.bytedance.adsdk.lottie.f.d.h(pointF.y, -100.0f, 100.0f);
            pointF2.x = com.bytedance.adsdk.lottie.f.d.h(pointF2.x, -1.0f, 1.0f);
            float h4 = com.bytedance.adsdk.lottie.f.d.h(pointF2.y, -100.0f, 100.0f);
            pointF2.y = h4;
            int d4 = com.bytedance.adsdk.lottie.f.b.d(pointF.x, pointF.y, pointF2.x, h4);
            WeakReference<Interpolator> f4 = s.c() ? null : f(d4);
            Interpolator interpolator = f4 != null ? f4.get() : null;
            if (f4 == null || interpolator == null) {
                try {
                    linearInterpolator = com.bytedance.adsdk.lottie.g.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
                } catch (IllegalArgumentException e4) {
                    if ("The Path cannot loop back on itself.".equals(e4.getMessage())) {
                        linearInterpolator = com.bytedance.adsdk.lottie.g.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                    } else {
                        linearInterpolator = new LinearInterpolator();
                    }
                }
                interpolator = linearInterpolator;
                if (!s.c()) {
                    try {
                        g(d4, new WeakReference(interpolator));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            return interpolator;
        }

        private static <T> n.h<T> c(JsonReader jsonReader, float f4, t<T> tVar) throws IOException {
            return new n.h<>(tVar.a(jsonReader, f4));
        }

        static <T> n.h<T> d(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, float f4, t<T> tVar, boolean z3, boolean z4) throws IOException {
            if (z3 && z4) {
                return h(eVar, jsonReader, f4, tVar);
            }
            if (z3) {
                return e(eVar, jsonReader, f4, tVar);
            }
            return c(jsonReader, f4, tVar);
        }

        private static <T> n.h<T> e(com.bytedance.adsdk.lottie.e eVar, JsonReader jsonReader, float f4, t<T> tVar) throws IOException {
            Interpolator interpolator;
            Interpolator interpolator2;
            T t3;
            jsonReader.beginObject();
            PointF pointF = null;
            PointF pointF2 = null;
            T t4 = null;
            T t5 = null;
            PointF pointF3 = null;
            PointF pointF4 = null;
            boolean z3 = false;
            float f5 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 101:
                        if (nextName.equals("e")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 105:
                        if (nextName.equals("i")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3701:
                        if (nextName.equals("ti")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3707:
                        if (nextName.equals("to")) {
                            c4 = 7;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        t4 = tVar.a(jsonReader, f4);
                        break;
                    case 1:
                        if (jsonReader.nextInt() != 1) {
                            z3 = false;
                            break;
                        } else {
                            z3 = true;
                            break;
                        }
                    case 2:
                        pointF2 = l.f(jsonReader, 1.0f);
                        break;
                    case 3:
                        pointF = l.f(jsonReader, 1.0f);
                        break;
                    case 4:
                        t5 = tVar.a(jsonReader, f4);
                        break;
                    case 5:
                        f5 = (float) jsonReader.nextDouble();
                        break;
                    case 6:
                        pointF4 = l.f(jsonReader, f4);
                        break;
                    case 7:
                        pointF3 = l.f(jsonReader, f4);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (z3) {
                interpolator2 = f25721a;
                t3 = t5;
            } else {
                if (pointF != null && pointF2 != null) {
                    interpolator = b(pointF, pointF2);
                } else {
                    interpolator = f25721a;
                }
                interpolator2 = interpolator;
                t3 = t4;
            }
            n.h<T> hVar = new n.h<>(eVar, t5, t3, interpolator2, f5, null);
            hVar.f25679o = pointF3;
            hVar.f25680p = pointF4;
            return hVar;
        }

        private static WeakReference<Interpolator> f(int i4) {
            WeakReference<Interpolator> weakReference;
            synchronized (d0.class) {
                weakReference = a().get(i4);
            }
            return weakReference;
        }

        private static void g(int i4, WeakReference<Interpolator> weakReference) {
            synchronized (d0.class) {
                f25722b.put(i4, weakReference);
            }
        }

        private static <T> n.h<T> h(com.bytedance.adsdk.lottie.e eVar, JsonReader jsonReader, float f4, t<T> tVar) throws IOException {
            Interpolator interpolator;
            Interpolator b4;
            Interpolator b5;
            T t3;
            PointF pointF;
            n.h<T> hVar;
            float f5;
            PointF pointF2;
            PointF pointF3;
            T t4;
            String str;
            String str2;
            T t5;
            jsonReader.beginObject();
            PointF pointF4 = null;
            boolean z3 = false;
            PointF pointF5 = null;
            PointF pointF6 = null;
            PointF pointF7 = null;
            T t6 = null;
            PointF pointF8 = null;
            PointF pointF9 = null;
            PointF pointF10 = null;
            float f6 = 0.0f;
            PointF pointF11 = null;
            T t7 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 101:
                        if (nextName.equals("e")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 105:
                        if (nextName.equals("i")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3701:
                        if (nextName.equals("ti")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3707:
                        if (nextName.equals("to")) {
                            c4 = 7;
                            break;
                        }
                        break;
                }
                String str3 = "y";
                String str4 = "x";
                switch (c4) {
                    case 0:
                        f5 = f6;
                        t7 = tVar.a(jsonReader, f4);
                        break;
                    case 1:
                        pointF2 = pointF4;
                        f5 = f6;
                        pointF3 = pointF11;
                        t4 = t6;
                        z3 = jsonReader.nextInt() == 1;
                        t6 = t4;
                        pointF11 = pointF3;
                        pointF4 = pointF2;
                        break;
                    case 2:
                        pointF2 = pointF4;
                        f5 = f6;
                        pointF3 = pointF11;
                        t4 = t6;
                        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                            jsonReader.beginObject();
                            float f7 = 0.0f;
                            float f8 = 0.0f;
                            float f9 = 0.0f;
                            float f10 = 0.0f;
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                nextName2.hashCode();
                                if (nextName2.equals(str4)) {
                                    str = str3;
                                    str2 = str4;
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        f7 = (float) jsonReader.nextDouble();
                                        f9 = f7;
                                    } else {
                                        jsonReader.beginArray();
                                        f7 = (float) jsonReader.nextDouble();
                                        f9 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f7;
                                        jsonReader.endArray();
                                    }
                                } else if (!nextName2.equals(str3)) {
                                    jsonReader.skipValue();
                                    str = str3;
                                    str2 = str4;
                                } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                    str = str3;
                                    str2 = str4;
                                    f8 = (float) jsonReader.nextDouble();
                                    f10 = f8;
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    jsonReader.beginArray();
                                    f8 = (float) jsonReader.nextDouble();
                                    f10 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f8;
                                    jsonReader.endArray();
                                }
                                str3 = str;
                                str4 = str2;
                            }
                            PointF pointF12 = new PointF(f7, f8);
                            PointF pointF13 = new PointF(f9, f10);
                            jsonReader.endObject();
                            pointF10 = pointF13;
                            pointF9 = pointF12;
                        } else {
                            pointF6 = l.f(jsonReader, f4);
                        }
                        t6 = t4;
                        pointF11 = pointF3;
                        pointF4 = pointF2;
                        break;
                    case 3:
                        pointF3 = pointF11;
                        pointF2 = pointF4;
                        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                            jsonReader.beginObject();
                            float f11 = 0.0f;
                            float f12 = 0.0f;
                            float f13 = 0.0f;
                            float f14 = 0.0f;
                            while (jsonReader.hasNext()) {
                                float f15 = f6;
                                String nextName3 = jsonReader.nextName();
                                nextName3.hashCode();
                                if (!nextName3.equals("x")) {
                                    if (!nextName3.equals("y")) {
                                        jsonReader.skipValue();
                                    } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                        f12 = (float) jsonReader.nextDouble();
                                        f14 = f12;
                                    } else {
                                        jsonReader.beginArray();
                                        f12 = (float) jsonReader.nextDouble();
                                        f14 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f12;
                                        jsonReader.endArray();
                                    }
                                    t5 = t6;
                                } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                    t5 = t6;
                                    f11 = (float) jsonReader.nextDouble();
                                    f13 = f11;
                                } else {
                                    t5 = t6;
                                    jsonReader.beginArray();
                                    f11 = (float) jsonReader.nextDouble();
                                    f13 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : f11;
                                    jsonReader.endArray();
                                }
                                t6 = t5;
                                f6 = f15;
                            }
                            f5 = f6;
                            PointF pointF14 = new PointF(f11, f12);
                            PointF pointF15 = new PointF(f13, f14);
                            jsonReader.endObject();
                            pointF8 = pointF15;
                            pointF7 = pointF14;
                        } else {
                            f5 = f6;
                            pointF5 = l.f(jsonReader, f4);
                        }
                        pointF11 = pointF3;
                        pointF4 = pointF2;
                        break;
                    case 4:
                        t6 = tVar.a(jsonReader, f4);
                        continue;
                    case 5:
                        f6 = (float) jsonReader.nextDouble();
                        continue;
                    case 6:
                        pointF4 = l.f(jsonReader, f4);
                        continue;
                    case 7:
                        pointF11 = l.f(jsonReader, f4);
                        continue;
                    default:
                        jsonReader.skipValue();
                        continue;
                }
                f6 = f5;
            }
            PointF pointF16 = pointF4;
            float f16 = f6;
            PointF pointF17 = pointF11;
            T t8 = t6;
            jsonReader.endObject();
            if (z3) {
                interpolator = f25721a;
                t3 = t8;
            } else {
                if (pointF5 != null && pointF6 != null) {
                    interpolator = b(pointF5, pointF6);
                } else if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b4 = b(pointF7, pointF9);
                    b5 = b(pointF8, pointF10);
                    t3 = t7;
                    interpolator = null;
                    if (b4 == null && b5 != null) {
                        pointF = pointF17;
                        hVar = new n.h<>(eVar, t8, t3, b4, b5, f16, null);
                    } else {
                        pointF = pointF17;
                        hVar = new n.h<>(eVar, t8, t3, interpolator, f16, null);
                    }
                    hVar.f25679o = pointF;
                    hVar.f25680p = pointF16;
                    return hVar;
                } else {
                    interpolator = f25721a;
                }
                t3 = t7;
            }
            b4 = null;
            b5 = null;
            if (b4 == null) {
            }
            pointF = pointF17;
            hVar = new n.h<>(eVar, t8, t3, interpolator, f16, null);
            hVar.f25679o = pointF;
            hVar.f25680p = pointF16;
            return hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class e {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        static com.bytedance.adsdk.lottie.xv.w.s a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            char c4;
            char c5;
            ArrayList arrayList = new ArrayList();
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.c cVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            s.c cVar2 = null;
            s.w wVar = null;
            float f4 = 0.0f;
            boolean z3 = false;
            com.bytedance.adsdk.lottie.xv.c.j jVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case 99:
                        if (nextName.equals("c")) {
                            c4 = 0;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 100:
                        if (nextName.equals("d")) {
                            c4 = 1;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 2;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c4 = 3;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 4;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3447:
                        if (nextName.equals("lc")) {
                            c4 = 5;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3454:
                        if (nextName.equals("lj")) {
                            c4 = 6;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3487:
                        if (nextName.equals("ml")) {
                            c4 = 7;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = '\b';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    default:
                        c4 = '\uffff';
                        break;
                }
                switch (c4) {
                    case 0:
                        cVar = b0.g(jsonReader, eVar);
                        continue;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            String str2 = null;
                            com.bytedance.adsdk.lottie.xv.c.m mVar3 = null;
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                nextName2.hashCode();
                                if (nextName2.equals("n")) {
                                    str2 = jsonReader.nextString();
                                } else if (!nextName2.equals("v")) {
                                    jsonReader.skipValue();
                                } else {
                                    mVar3 = b0.a(jsonReader, eVar);
                                }
                            }
                            jsonReader.endObject();
                            str2.hashCode();
                            switch (str2.hashCode()) {
                                case 100:
                                    if (str2.equals("d")) {
                                        c5 = 0;
                                        break;
                                    }
                                    c5 = '\uffff';
                                    break;
                                case 103:
                                    if (str2.equals("g")) {
                                        c5 = 1;
                                        break;
                                    }
                                    c5 = '\uffff';
                                    break;
                                case 111:
                                    if (str2.equals("o")) {
                                        c5 = 2;
                                        break;
                                    }
                                    c5 = '\uffff';
                                    break;
                                default:
                                    c5 = '\uffff';
                                    break;
                            }
                            switch (c5) {
                                case 0:
                                case 1:
                                    eVar.h(true);
                                    arrayList.add(mVar3);
                                    break;
                                case 2:
                                    mVar = mVar3;
                                    break;
                            }
                        }
                        jsonReader.endArray();
                        if (arrayList.size() != 1) {
                            break;
                        } else {
                            arrayList.add(arrayList.get(0));
                            continue;
                        }
                        break;
                    case 2:
                        jVar = b0.j(jsonReader, eVar);
                        break;
                    case 3:
                        mVar2 = b0.a(jsonReader, eVar);
                        break;
                    case 4:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 5:
                        cVar2 = s.c.values()[jsonReader.nextInt() - 1];
                        break;
                    case 6:
                        wVar = s.w.values()[jsonReader.nextInt() - 1];
                        break;
                    case 7:
                        f4 = (float) jsonReader.nextDouble();
                        break;
                    case '\b':
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            if (jVar == null) {
                jVar = new com.bytedance.adsdk.lottie.xv.c.j(Collections.singletonList(new n.h(100)));
            }
            return new com.bytedance.adsdk.lottie.xv.w.s(str, mVar, arrayList, cVar, jVar, mVar2, cVar2, wVar, f4, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class e0 {
        static com.bytedance.adsdk.lottie.xv.w.c a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            com.bytedance.adsdk.lottie.xv.w.c cVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("ef")) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.xv.w.c b4 = b(jsonReader, eVar);
                        if (b4 != null) {
                            cVar = b4;
                        }
                    }
                    jsonReader.endArray();
                }
            }
            return cVar;
        }

        private static com.bytedance.adsdk.lottie.xv.w.c b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            jsonReader.beginObject();
            com.bytedance.adsdk.lottie.xv.w.c cVar = null;
            while (true) {
                boolean z3 = false;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    nextName.hashCode();
                    if (nextName.equals("v")) {
                        if (z3) {
                            cVar = new com.bytedance.adsdk.lottie.xv.w.c(b0.a(jsonReader, eVar));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (!nextName.equals("ty")) {
                        jsonReader.skipValue();
                    } else if (jsonReader.nextInt() == 0) {
                        z3 = true;
                    }
                }
                jsonReader.endObject();
                return cVar;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f {
        public static com.bytedance.adsdk.lottie.xv.c.l a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(v.a(jsonReader, eVar));
                }
                jsonReader.endArray();
                o.b(arrayList);
            } else {
                arrayList.add(new n.h(l.f(jsonReader, com.bytedance.adsdk.lottie.f.b.a())));
            }
            return new com.bytedance.adsdk.lottie.xv.c.l(arrayList);
        }

        static com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            jsonReader.beginObject();
            com.bytedance.adsdk.lottie.xv.c.l lVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            boolean z3 = false;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 107:
                        if (nextName.equals("k")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 120:
                        if (nextName.equals("x")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 121:
                        if (nextName.equals("y")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        lVar = a(jsonReader, eVar);
                        continue;
                    case 1:
                        if (jsonReader.peek() == JsonToken.STRING) {
                            jsonReader.skipValue();
                            break;
                        } else {
                            mVar = b0.a(jsonReader, eVar);
                            continue;
                        }
                    case 2:
                        if (jsonReader.peek() == JsonToken.STRING) {
                            jsonReader.skipValue();
                            break;
                        } else {
                            mVar2 = b0.a(jsonReader, eVar);
                            continue;
                        }
                    default:
                        jsonReader.skipValue();
                        continue;
                }
                z3 = true;
            }
            jsonReader.endObject();
            if (z3) {
                eVar.g("Lottie doesn't support expressions.");
            }
            return lVar != null ? lVar : new com.bytedance.adsdk.lottie.xv.c.f(mVar, mVar2);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f0 {
        public static com.bytedance.adsdk.lottie.xv.c.g a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            jsonReader.beginObject();
            com.bytedance.adsdk.lottie.xv.c.g gVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("a")) {
                    jsonReader.skipValue();
                } else {
                    gVar = b(jsonReader, eVar);
                }
            }
            jsonReader.endObject();
            return gVar == null ? new com.bytedance.adsdk.lottie.xv.c.g(null, null, null, null) : gVar;
        }

        private static com.bytedance.adsdk.lottie.xv.c.g b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            jsonReader.beginObject();
            com.bytedance.adsdk.lottie.xv.c.c cVar = null;
            com.bytedance.adsdk.lottie.xv.c.c cVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3261:
                        if (nextName.equals("fc")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3664:
                        if (nextName.equals("sc")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3684:
                        if (nextName.equals("sw")) {
                            c4 = 3;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        mVar2 = b0.a(jsonReader, eVar);
                        break;
                    case 1:
                        cVar = b0.g(jsonReader, eVar);
                        break;
                    case 2:
                        cVar2 = b0.g(jsonReader, eVar);
                        break;
                    case 3:
                        mVar = b0.a(jsonReader, eVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return new com.bytedance.adsdk.lottie.xv.c.g(cVar, cVar2, mVar, mVar2);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class g implements t<PointF> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f25723a = new g();

        private g() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public PointF a(JsonReader jsonReader, float f4) throws IOException {
            return l.f(jsonReader, f4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class g0 implements t<n.i> {

        /* renamed from: a  reason: collision with root package name */
        public static final g0 f25724a = new g0();

        private g0() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public n.i a(JsonReader jsonReader, float f4) throws IOException {
            boolean z3 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
            if (z3) {
                jsonReader.beginArray();
            }
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            if (z3) {
                jsonReader.endArray();
            }
            return new n.i((nextDouble / 100.0f) * f4, (nextDouble2 / 100.0f) * f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h {
        static com.bytedance.adsdk.lottie.xv.w.a a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.a aVar = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 99:
                        if (nextName.equals("c")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3710:
                        if (nextName.equals("tr")) {
                            c4 = 4;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        mVar = b0.b(jsonReader, eVar, false);
                        break;
                    case 1:
                        mVar2 = b0.b(jsonReader, eVar, false);
                        break;
                    case 2:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 3:
                        str = jsonReader.nextString();
                        break;
                    case 4:
                        aVar = k0.a(jsonReader, eVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.a(str, mVar, mVar2, aVar, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h0 {
        static com.bytedance.adsdk.lottie.xv.w.e a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            String str = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3371:
                        if (nextName.equals("it")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.xv.w.l a4 = i.a(jsonReader, eVar);
                            if (a4 != null) {
                                arrayList.add(a4);
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case 2:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.e(str, arrayList, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class i {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00cb, code lost:
            if (r2.equals("gf") == false) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static com.bytedance.adsdk.lottie.xv.w.l a(android.util.JsonReader r6, com.bytedance.adsdk.lottie.e r7) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 432
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.s.i.a(android.util.JsonReader, com.bytedance.adsdk.lottie.e):com.bytedance.adsdk.lottie.xv.w.l");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class i0 {
        static fz a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            String str = null;
            fz.c cVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar3 = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 101:
                        if (nextName.equals("e")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 109:
                        if (nextName.equals("m")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 5;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        mVar2 = b0.b(jsonReader, eVar, false);
                        break;
                    case 1:
                        cVar = fz.c.c(jsonReader.nextInt());
                        break;
                    case 2:
                        mVar3 = b0.b(jsonReader, eVar, false);
                        break;
                    case 3:
                        mVar = b0.b(jsonReader, eVar, false);
                        break;
                    case 4:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 5:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new fz(str, cVar, mVar, mVar2, mVar3, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class j {
        static com.bytedance.adsdk.lottie.xv.w.k a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, int i4) throws IOException {
            boolean z3 = i4 == 3;
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar2 = null;
            boolean z4 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 4;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextInt() == 3;
                        break;
                    case 1:
                        bVar = f.b(jsonReader, eVar);
                        break;
                    case 2:
                        eVar2 = b0.k(jsonReader, eVar);
                        break;
                    case 3:
                        z4 = jsonReader.nextBoolean();
                        break;
                    case 4:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.k(str, bVar, eVar2, z3, z4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class j0 implements t<com.bytedance.adsdk.lottie.xv.w.i> {

        /* renamed from: a  reason: collision with root package name */
        public static final j0 f25725a = new j0();

        private j0() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
            if (r5.equals("i") == false) goto L9;
         */
        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.adsdk.lottie.xv.w.i a(android.util.JsonReader r13, float r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.s.j0.a(android.util.JsonReader, float):com.bytedance.adsdk.lottie.xv.w.i");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class k {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        static com.bytedance.adsdk.lottie.xv.w.j a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            char c4;
            com.bytedance.adsdk.lottie.xv.c.j jVar = null;
            Path.FillType fillType = Path.FillType.WINDING;
            String str = null;
            com.bytedance.adsdk.lottie.xv.w.r rVar = null;
            com.bytedance.adsdk.lottie.xv.c.n nVar = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar3 = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                int i4 = -1;
                switch (nextName.hashCode()) {
                    case 101:
                        if (nextName.equals("e")) {
                            c4 = 0;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 103:
                        if (nextName.equals("g")) {
                            c4 = 1;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 2;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 3;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 4;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 5;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 6;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 7;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    default:
                        c4 = '\uffff';
                        break;
                }
                switch (c4) {
                    case 0:
                        eVar3 = b0.k(jsonReader, eVar);
                        break;
                    case 1:
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("k")) {
                                nVar = b0.c(jsonReader, eVar, i4);
                            } else if (!nextName2.equals("p")) {
                                jsonReader.skipValue();
                            } else {
                                i4 = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endObject();
                        break;
                    case 2:
                        jVar = b0.j(jsonReader, eVar);
                        break;
                    case 3:
                        fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                        break;
                    case 4:
                        eVar2 = b0.k(jsonReader, eVar);
                        break;
                    case 5:
                        rVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.xv.w.r.LINEAR : com.bytedance.adsdk.lottie.xv.w.r.RADIAL;
                        break;
                    case 6:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 7:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.j(str, rVar, fillType, nVar, jVar == null ? new com.bytedance.adsdk.lottie.xv.c.j(Collections.singletonList(new n.h(100))) : jVar, eVar2, eVar3, null, null, z3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class k0 {
        public static com.bytedance.adsdk.lottie.xv.c.a a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            boolean z3 = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
            if (z3) {
                jsonReader.beginObject();
            }
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.c.l lVar = null;
            com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar = null;
            com.bytedance.adsdk.lottie.xv.c.i iVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar3 = null;
            com.bytedance.adsdk.lottie.xv.c.j jVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar4 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar5 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 97:
                        if (nextName.equals("a")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3242:
                        if (nextName.equals("eo")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3656:
                        if (nextName.equals("rz")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3662:
                        if (nextName.equals("sa")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 3672:
                        if (nextName.equals("sk")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 3676:
                        if (nextName.equals("so")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (!nextName2.equals("k")) {
                                jsonReader.skipValue();
                            } else {
                                lVar = f.a(jsonReader, eVar);
                            }
                        }
                        jsonReader.endObject();
                        continue;
                    case 1:
                        jVar = b0.j(jsonReader, eVar);
                        continue;
                    case 2:
                        bVar = f.b(jsonReader, eVar);
                        continue;
                    case 3:
                        break;
                    case 4:
                        iVar = b0.h(jsonReader, eVar);
                        continue;
                    case 5:
                        mVar5 = b0.b(jsonReader, eVar, false);
                        continue;
                    case 6:
                        eVar.g("Lottie doesn't support 3D layers.");
                        break;
                    case 7:
                        mVar3 = b0.b(jsonReader, eVar, false);
                        continue;
                    case '\b':
                        mVar2 = b0.b(jsonReader, eVar, false);
                        continue;
                    case '\t':
                        mVar4 = b0.b(jsonReader, eVar, false);
                        continue;
                    default:
                        jsonReader.skipValue();
                        continue;
                }
                com.bytedance.adsdk.lottie.xv.c.m b4 = b0.b(jsonReader, eVar, false);
                if (b4.xv().isEmpty()) {
                    b4.xv().add(new n.h(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar.o())));
                } else if (((n.h) b4.xv().get(0)).f25666b == null) {
                    b4.xv().set(0, new n.h(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar.o())));
                }
                mVar = b4;
            }
            if (z3) {
                jsonReader.endObject();
            }
            if (d(lVar)) {
                lVar = null;
            }
            return new com.bytedance.adsdk.lottie.xv.c.a(lVar, b(bVar) ? null : bVar, c(iVar) ? null : iVar, e(mVar) ? null : mVar, jVar, mVar4, mVar5, f(mVar2) ? null : mVar2, g(mVar3) ? null : mVar3);
        }

        private static boolean b(com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar) {
            return bVar == null || (!(bVar instanceof com.bytedance.adsdk.lottie.xv.c.f) && bVar.w() && bVar.xv().get(0).f25666b.equals(0.0f, 0.0f));
        }

        private static boolean c(com.bytedance.adsdk.lottie.xv.c.i iVar) {
            return iVar == null || (iVar.w() && ((n.i) ((n.h) iVar.xv().get(0)).f25666b).d(1.0f, 1.0f));
        }

        private static boolean d(com.bytedance.adsdk.lottie.xv.c.l lVar) {
            return lVar == null || (lVar.w() && lVar.xv().get(0).f25666b.equals(0.0f, 0.0f));
        }

        private static boolean e(com.bytedance.adsdk.lottie.xv.c.m mVar) {
            return mVar == null || (mVar.w() && ((Float) ((n.h) mVar.xv().get(0)).f25666b).floatValue() == 0.0f);
        }

        private static boolean f(com.bytedance.adsdk.lottie.xv.c.m mVar) {
            return mVar == null || (mVar.w() && ((Float) ((n.h) mVar.xv().get(0)).f25666b).floatValue() == 0.0f);
        }

        private static boolean g(com.bytedance.adsdk.lottie.xv.c.m mVar) {
            return mVar == null || (mVar.w() && ((Float) ((n.h) mVar.xv().get(0)).f25666b).floatValue() == 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class l {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ int[] f25726a;

            static {
                int[] iArr = new int[JsonToken.values().length];
                f25726a = iArr;
                try {
                    iArr[JsonToken.NUMBER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f25726a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f25726a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
            }
        }

        @ColorInt
        static int a(JsonReader jsonReader) throws IOException {
            jsonReader.beginArray();
            int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
        }

        static List<PointF> b(JsonReader jsonReader, float f4) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                arrayList.add(f(jsonReader, f4));
                jsonReader.endArray();
            }
            jsonReader.endArray();
            return arrayList;
        }

        private static PointF c(JsonReader jsonReader, float f4) throws IOException {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != JsonToken.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(nextDouble * f4, nextDouble2 * f4);
        }

        private static PointF d(JsonReader jsonReader, float f4) throws IOException {
            jsonReader.beginObject();
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("x")) {
                    f5 = e(jsonReader);
                } else if (!nextName.equals("y")) {
                    jsonReader.skipValue();
                } else {
                    f6 = e(jsonReader);
                }
            }
            jsonReader.endObject();
            return new PointF(f5 * f4, f6 * f4);
        }

        static float e(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            int i4 = a.f25726a[peek.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    jsonReader.beginArray();
                    float nextDouble = (float) jsonReader.nextDouble();
                    while (jsonReader.hasNext()) {
                        jsonReader.skipValue();
                    }
                    jsonReader.endArray();
                    return nextDouble;
                }
                throw new IllegalArgumentException("Unknown value for token of type " + peek);
            }
            return (float) jsonReader.nextDouble();
        }

        static PointF f(JsonReader jsonReader, float f4) throws IOException {
            int i4 = a.f25726a[jsonReader.peek().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return d(jsonReader, f4);
                    }
                    throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
                }
                return c(jsonReader, f4);
            }
            return g(jsonReader, f4);
        }

        private static PointF g(JsonReader jsonReader, float f4) throws IOException {
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(nextDouble * f4, nextDouble2 * f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class l0 {
        static com.bytedance.adsdk.lottie.xv.w.g a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 112:
                        if (nextName.equals("p")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 4;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        bVar = f.b(jsonReader, eVar);
                        break;
                    case 1:
                        mVar = b0.a(jsonReader, eVar);
                        break;
                    case 2:
                        eVar2 = b0.k(jsonReader, eVar);
                        break;
                    case 3:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 4:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.g(str, bVar, eVar2, mVar, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class m {
        static gd a(JsonReader jsonReader) throws IOException {
            String str = null;
            gd.c cVar = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3488:
                        if (nextName.equals("mm")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 1:
                        cVar = gd.c.c(jsonReader.nextInt());
                        break;
                    case 2:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new gd(str, cVar, z3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class m0 implements t<com.bytedance.adsdk.lottie.xv.w.h> {

        /* renamed from: a  reason: collision with root package name */
        private int f25727a;

        public m0(int i4) {
            this.f25727a = i4;
        }

        private int c(float f4, int i4, float[] fArr, float[] fArr2) {
            float a4;
            if (fArr2.length >= 2 && f4 > fArr[0]) {
                for (int i5 = 1; i5 < fArr.length; i5++) {
                    float f5 = fArr[i5];
                    if (f5 >= f4 || i5 == fArr.length - 1) {
                        if (f5 <= f4) {
                            a4 = fArr2[i5];
                        } else {
                            int i6 = i5 - 1;
                            a4 = com.bytedance.adsdk.lottie.f.d.a(fArr2[i6], fArr2[i5], (f4 - fArr[i6]) / (fArr[i5] - fArr[i6]));
                        }
                        return Color.argb((int) (a4 * 255.0f), Color.red(i4), Color.green(i4), Color.blue(i4));
                    }
                }
                throw new IllegalArgumentException("Unreachable code.");
            }
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i4), Color.green(i4), Color.blue(i4));
        }

        private com.bytedance.adsdk.lottie.xv.w.h e(com.bytedance.adsdk.lottie.xv.w.h hVar, List<Float> list) {
            int i4 = this.f25727a * 4;
            if (list.size() <= i4) {
                return hVar;
            }
            float[] d4 = hVar.d();
            int[] e4 = hVar.e();
            int size = (list.size() - i4) / 2;
            float[] fArr = new float[size];
            float[] fArr2 = new float[size];
            int i5 = 0;
            while (i4 < list.size()) {
                if (i4 % 2 == 0) {
                    fArr[i5] = list.get(i4).floatValue();
                } else {
                    fArr2[i5] = list.get(i4).floatValue();
                    i5++;
                }
                i4++;
            }
            float[] f4 = f(hVar.d(), fArr);
            int length = f4.length;
            int[] iArr = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                float f5 = f4[i6];
                int binarySearch = Arrays.binarySearch(d4, f5);
                int binarySearch2 = Arrays.binarySearch(fArr, f5);
                if (binarySearch >= 0 && binarySearch2 <= 0) {
                    iArr[i6] = c(f5, e4[binarySearch], fArr, fArr2);
                } else {
                    if (binarySearch2 < 0) {
                        binarySearch2 = -(binarySearch2 + 1);
                    }
                    iArr[i6] = b(f5, fArr2[binarySearch2], d4, e4);
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.h(f4, iArr);
        }

        protected static float[] f(float[] fArr, float[] fArr2) {
            if (fArr.length == 0) {
                return fArr2;
            }
            if (fArr2.length == 0) {
                return fArr;
            }
            int length = fArr.length + fArr2.length;
            float[] fArr3 = new float[length];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                float f4 = i5 < fArr.length ? fArr[i5] : Float.NaN;
                float f5 = i6 < fArr2.length ? fArr2[i6] : Float.NaN;
                if (!Float.isNaN(f5) && f4 >= f5) {
                    if (!Float.isNaN(f4) && f5 >= f4) {
                        fArr3[i7] = f4;
                        i5++;
                        i6++;
                        i4++;
                    } else {
                        fArr3[i7] = f5;
                        i6++;
                    }
                } else {
                    fArr3[i7] = f4;
                    i5++;
                }
            }
            return i4 == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i4);
        }

        int b(float f4, float f5, float[] fArr, int[] iArr) {
            if (iArr.length >= 2 && f4 != fArr[0]) {
                for (int i4 = 1; i4 < fArr.length; i4++) {
                    if (fArr[i4] >= f4 || i4 == fArr.length - 1) {
                        int i5 = i4 - 1;
                        float f6 = (f4 - fArr[i5]) / (fArr[i4] - fArr[i5]);
                        int i6 = iArr[i4];
                        int i7 = iArr[i5];
                        return Color.argb((int) (f5 * 255.0f), com.bytedance.adsdk.lottie.f.g.b(f6, Color.red(i7), Color.red(i6)), com.bytedance.adsdk.lottie.f.g.b(f6, Color.green(i7), Color.green(i6)), com.bytedance.adsdk.lottie.f.g.b(f6, Color.blue(i7), Color.blue(i6)));
                    }
                }
                throw new IllegalArgumentException("Unreachable code.");
            }
            return iArr[0];
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: d */
        public com.bytedance.adsdk.lottie.xv.w.h a(JsonReader jsonReader, float f4) throws IOException {
            ArrayList arrayList = new ArrayList();
            boolean z3 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
            if (z3) {
                jsonReader.beginArray();
            }
            while (jsonReader.hasNext()) {
                arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
            }
            if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
                arrayList.set(0, Float.valueOf(0.0f));
                arrayList.add(Float.valueOf(1.0f));
                arrayList.add(arrayList.get(1));
                arrayList.add(arrayList.get(2));
                arrayList.add(arrayList.get(3));
                this.f25727a = 2;
            }
            if (z3) {
                jsonReader.endArray();
            }
            if (this.f25727a == -1) {
                this.f25727a = arrayList.size() / 4;
            }
            int i4 = this.f25727a;
            float[] fArr = new float[i4];
            int[] iArr = new int[i4];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.f25727a * 4; i7++) {
                int i8 = i7 / 4;
                double floatValue = arrayList.get(i7).floatValue();
                int i9 = i7 % 4;
                if (i9 == 0) {
                    if (i8 > 0) {
                        float f5 = (float) floatValue;
                        if (fArr[i8 - 1] >= f5) {
                            fArr[i8] = f5 + 0.01f;
                        }
                    }
                    fArr[i8] = (float) floatValue;
                } else if (i9 == 1) {
                    Double.isNaN(floatValue);
                    i5 = (int) (floatValue * 255.0d);
                } else if (i9 == 2) {
                    Double.isNaN(floatValue);
                    i6 = (int) (floatValue * 255.0d);
                } else if (i9 == 3) {
                    Double.isNaN(floatValue);
                    iArr[i8] = Color.argb(255, i5, i6, (int) (floatValue * 255.0d));
                }
            }
            return e(new com.bytedance.adsdk.lottie.xv.w.h(fArr, iArr), arrayList);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class n implements t<com.bytedance.adsdk.lottie.xv.w> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f25728a = new n();

        private n() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public com.bytedance.adsdk.lottie.xv.w a(JsonReader jsonReader, float f4) throws IOException {
            w.c cVar = w.c.CENTER;
            jsonReader.beginObject();
            w.c cVar2 = cVar;
            String str = null;
            String str2 = null;
            PointF pointF = null;
            PointF pointF2 = null;
            float f5 = 0.0f;
            int i4 = 0;
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i5 = 0;
            int i6 = 0;
            float f8 = 0.0f;
            boolean z3 = true;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 102:
                        if (nextName.equals("f")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 106:
                        if (nextName.equals("j")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3261:
                        if (nextName.equals("fc")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3452:
                        if (nextName.equals("lh")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3463:
                        if (nextName.equals("ls")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3543:
                        if (nextName.equals("of")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 3587:
                        if (nextName.equals("ps")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 3664:
                        if (nextName.equals("sc")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                    case 3684:
                        if (nextName.equals("sw")) {
                            c4 = '\n';
                            break;
                        }
                        break;
                    case 3687:
                        if (nextName.equals("sz")) {
                            c4 = 11;
                            break;
                        }
                        break;
                    case 3710:
                        if (nextName.equals("tr")) {
                            c4 = '\f';
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        str2 = jsonReader.nextString();
                        break;
                    case 1:
                        int nextInt = jsonReader.nextInt();
                        w.c cVar3 = w.c.CENTER;
                        if (nextInt <= cVar3.ordinal() && nextInt >= 0) {
                            cVar2 = w.c.values()[nextInt];
                            break;
                        } else {
                            cVar2 = cVar3;
                            break;
                        }
                        break;
                    case 2:
                        f5 = (float) jsonReader.nextDouble();
                        break;
                    case 3:
                        str = jsonReader.nextString();
                        break;
                    case 4:
                        i5 = l.a(jsonReader);
                        break;
                    case 5:
                        f6 = (float) jsonReader.nextDouble();
                        break;
                    case 6:
                        f7 = (float) jsonReader.nextDouble();
                        break;
                    case 7:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case '\b':
                        jsonReader.beginArray();
                        PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
                        jsonReader.endArray();
                        pointF = pointF3;
                        break;
                    case '\t':
                        i6 = l.a(jsonReader);
                        break;
                    case '\n':
                        f8 = (float) jsonReader.nextDouble();
                        break;
                    case 11:
                        jsonReader.beginArray();
                        PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
                        jsonReader.endArray();
                        pointF2 = pointF4;
                        break;
                    case '\f':
                        i4 = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return new com.bytedance.adsdk.lottie.xv.w(str, str2, f5, cVar2, i4, f6, f7, i5, i6, f8, z3, pointF, pointF2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class n0 {
        static com.bytedance.adsdk.lottie.xv.w.m a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            com.bytedance.adsdk.lottie.xv.c.j jVar = null;
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.c cVar = null;
            int i4 = 1;
            boolean z3 = false;
            boolean z4 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case -396065730:
                        if (nextName.equals("fillEnabled")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 99:
                        if (nextName.equals("c")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 5;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 1:
                        cVar = b0.g(jsonReader, eVar);
                        break;
                    case 2:
                        jVar = b0.j(jsonReader, eVar);
                        break;
                    case 3:
                        i4 = jsonReader.nextInt();
                        break;
                    case 4:
                        z4 = jsonReader.nextBoolean();
                        break;
                    case 5:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            if (jVar == null) {
                jVar = new com.bytedance.adsdk.lottie.xv.c.j(Collections.singletonList(new n.h(100)));
            }
            return new com.bytedance.adsdk.lottie.xv.w.m(str, z3, i4 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, cVar, jVar, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class o {
        static <T> List<n.h<T>> a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, float f4, t<T> tVar, boolean z3) throws IOException {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonToken.STRING) {
                eVar.g("Lottie doesn't support expressions.");
                return arrayList;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("k")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(d0.d(jsonReader, eVar, f4, tVar, false, z3));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(d0.d(jsonReader, eVar, f4, tVar, true, z3));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(d0.d(jsonReader, eVar, f4, tVar, false, z3));
                }
            }
            jsonReader.endObject();
            b(arrayList);
            return arrayList;
        }

        public static <T> void b(List<? extends n.h<T>> list) {
            int i4;
            T t3;
            int size = list.size();
            int i5 = 0;
            while (true) {
                i4 = size - 1;
                if (i5 >= i4) {
                    break;
                }
                n.h<T> hVar = list.get(i5);
                i5++;
                n.h<T> hVar2 = list.get(i5);
                hVar.f25672h = Float.valueOf(hVar2.f25671g);
                if (hVar.f25667c == null && (t3 = hVar2.f25666b) != null) {
                    hVar.f25667c = t3;
                    if (hVar instanceof com.bytedance.adsdk.lottie.c.w.g) {
                        ((com.bytedance.adsdk.lottie.c.w.g) hVar).j();
                    }
                }
            }
            n.h<T> hVar3 = list.get(i4);
            if ((hVar3.f25666b == null || hVar3.f25667c == null) && list.size() > 1) {
                list.remove(hVar3);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class o0 implements t<PointF> {

        /* renamed from: a  reason: collision with root package name */
        public static final o0 f25729a = new o0();

        private o0() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public PointF a(JsonReader jsonReader, float f4) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.BEGIN_ARRAY) {
                return l.f(jsonReader, f4);
            }
            if (peek == JsonToken.BEGIN_OBJECT) {
                return l.f(jsonReader, f4);
            }
            if (peek == JsonToken.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f4, ((float) jsonReader.nextDouble()) * f4);
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class p {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        static com.bytedance.adsdk.lottie.xv.w.d a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            char c4;
            ArrayList arrayList = new ArrayList();
            String str = null;
            com.bytedance.adsdk.lottie.xv.w.r rVar = null;
            com.bytedance.adsdk.lottie.xv.c.n nVar = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar2 = null;
            com.bytedance.adsdk.lottie.xv.c.e eVar3 = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            s.c cVar = null;
            s.w wVar = null;
            float f4 = 0.0f;
            com.bytedance.adsdk.lottie.xv.c.m mVar2 = null;
            boolean z3 = false;
            com.bytedance.adsdk.lottie.xv.c.j jVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                boolean z4 = z3;
                com.bytedance.adsdk.lottie.xv.c.m mVar3 = mVar2;
                float f5 = f4;
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            c4 = 0;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 101:
                        if (nextName.equals("e")) {
                            c4 = 1;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 103:
                        if (nextName.equals("g")) {
                            c4 = 2;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c4 = 3;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c4 = 4;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 5;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c4 = 6;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 7;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3447:
                        if (nextName.equals("lc")) {
                            c4 = '\b';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3454:
                        if (nextName.equals("lj")) {
                            c4 = '\t';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3487:
                        if (nextName.equals("ml")) {
                            c4 = '\n';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 11;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    default:
                        c4 = '\uffff';
                        break;
                }
                switch (c4) {
                    case 0:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            com.bytedance.adsdk.lottie.xv.c.m mVar4 = null;
                            String str2 = null;
                            while (jsonReader.hasNext()) {
                                s.w wVar2 = wVar;
                                String nextName2 = jsonReader.nextName();
                                nextName2.hashCode();
                                s.c cVar2 = cVar;
                                if (nextName2.equals("n")) {
                                    str2 = jsonReader.nextString();
                                } else if (!nextName2.equals("v")) {
                                    jsonReader.skipValue();
                                } else {
                                    mVar4 = b0.a(jsonReader, eVar);
                                }
                                wVar = wVar2;
                                cVar = cVar2;
                            }
                            s.c cVar3 = cVar;
                            s.w wVar3 = wVar;
                            jsonReader.endObject();
                            if (str2.equals("o")) {
                                mVar3 = mVar4;
                            } else if (str2.equals("d") || str2.equals("g")) {
                                eVar.h(true);
                                arrayList.add(mVar4);
                                wVar = wVar3;
                                cVar = cVar3;
                            }
                            wVar = wVar3;
                            cVar = cVar3;
                        }
                        s.c cVar4 = cVar;
                        s.w wVar4 = wVar;
                        jsonReader.endArray();
                        if (arrayList.size() == 1) {
                            arrayList.add(arrayList.get(0));
                        }
                        z3 = z4;
                        mVar2 = mVar3;
                        wVar = wVar4;
                        f4 = f5;
                        cVar = cVar4;
                        continue;
                        break;
                    case 1:
                        eVar3 = b0.k(jsonReader, eVar);
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 2:
                        jsonReader.beginObject();
                        int i4 = -1;
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.hashCode();
                            if (nextName3.equals("k")) {
                                nVar = b0.c(jsonReader, eVar, i4);
                            } else if (!nextName3.equals("p")) {
                                jsonReader.skipValue();
                            } else {
                                i4 = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endObject();
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 3:
                        jVar = b0.j(jsonReader, eVar);
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 4:
                        eVar2 = b0.k(jsonReader, eVar);
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 5:
                        rVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.xv.w.r.LINEAR : com.bytedance.adsdk.lottie.xv.w.r.RADIAL;
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 6:
                        mVar = b0.a(jsonReader, eVar);
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case 7:
                        z3 = jsonReader.nextBoolean();
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case '\b':
                        cVar = s.c.values()[jsonReader.nextInt() - 1];
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case '\t':
                        wVar = s.w.values()[jsonReader.nextInt() - 1];
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    case '\n':
                        f4 = (float) jsonReader.nextDouble();
                        z3 = z4;
                        mVar2 = mVar3;
                        break;
                    case 11:
                        str = jsonReader.nextString();
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                    default:
                        jsonReader.skipValue();
                        z3 = z4;
                        mVar2 = mVar3;
                        f4 = f5;
                        break;
                }
            }
            s.c cVar5 = cVar;
            s.w wVar5 = wVar;
            float f6 = f4;
            com.bytedance.adsdk.lottie.xv.c.m mVar5 = mVar2;
            boolean z5 = z3;
            if (jVar == null) {
                jVar = new com.bytedance.adsdk.lottie.xv.c.j(Collections.singletonList(new n.h(100)));
            }
            return new com.bytedance.adsdk.lottie.xv.w.d(str, rVar, nVar, jVar, eVar2, eVar3, mVar, cVar5, wVar5, f6, arrayList, mVar5, z5);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class q {
        public static com.bytedance.adsdk.lottie.e a(JsonReader jsonReader) throws IOException {
            float f4;
            HashMap hashMap;
            ArrayList arrayList;
            float a4 = com.bytedance.adsdk.lottie.f.b.a();
            LongSparseArray<sr> longSparseArray = new LongSparseArray<>();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            SparseArray<com.bytedance.adsdk.lottie.xv.d> sparseArray = new SparseArray<>();
            com.bytedance.adsdk.lottie.e eVar = new com.bytedance.adsdk.lottie.e();
            jsonReader.beginObject();
            int i4 = 0;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i5 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case -1408207997:
                        f4 = f7;
                        if (nextName.equals("assets")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1109732030:
                        f4 = f7;
                        if (nextName.equals("layers")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 104:
                        f4 = f7;
                        if (nextName.equals("h")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 118:
                        f4 = f7;
                        if (nextName.equals("v")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 119:
                        f4 = f7;
                        if (nextName.equals("w")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 3276:
                        f4 = f7;
                        if (nextName.equals("fr")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 3367:
                        f4 = f7;
                        if (nextName.equals("ip")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 3553:
                        f4 = f7;
                        if (nextName.equals("op")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 94623709:
                        f4 = f7;
                        if (nextName.equals("chars")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 97615364:
                        f4 = f7;
                        if (nextName.equals("fonts")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                    case 839250809:
                        f4 = f7;
                        if (nextName.equals("markers")) {
                            c4 = '\n';
                            break;
                        }
                        break;
                    default:
                        f4 = f7;
                        break;
                }
                switch (c4) {
                    case 0:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        d(jsonReader, eVar, hashMap2, hashMap3);
                        break;
                    case 1:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        c(jsonReader, eVar, arrayList2, longSparseArray);
                        break;
                    case 2:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        i5 = jsonReader.nextInt();
                        break;
                    case 3:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        String[] split = jsonReader.nextString().split("\\.");
                        if (!com.bytedance.adsdk.lottie.f.b.l(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                            eVar.g("Lottie only supports bodymovin >= 4.4.0");
                            break;
                        }
                        break;
                    case 4:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        i4 = jsonReader.nextInt();
                        break;
                    case 5:
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        f7 = (float) jsonReader.nextDouble();
                        continue;
                        hashMap4 = hashMap;
                        arrayList3 = arrayList;
                    case 6:
                        f5 = (float) jsonReader.nextDouble();
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case 7:
                        f6 = ((float) jsonReader.nextDouble()) - 0.01f;
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case '\b':
                        b(jsonReader, eVar, sparseArray);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case '\t':
                        f(jsonReader, hashMap4);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    case '\n':
                        e(jsonReader, arrayList3);
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                    default:
                        jsonReader.skipValue();
                        hashMap = hashMap4;
                        arrayList = arrayList3;
                        break;
                }
                f7 = f4;
                hashMap4 = hashMap;
                arrayList3 = arrayList;
            }
            jsonReader.endObject();
            eVar.f(new Rect(0, 0, (int) (i4 * a4), (int) (i5 * a4)), f5, f6, f7, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArray, hashMap4, arrayList3);
            return eVar;
        }

        private static void b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, SparseArray<com.bytedance.adsdk.lottie.xv.d> sparseArray) throws IOException {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                com.bytedance.adsdk.lottie.xv.d a4 = d.a(jsonReader, eVar);
                sparseArray.put(a4.hashCode(), a4);
            }
            jsonReader.endArray();
        }

        private static void c(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, List<sr> list, LongSparseArray<sr> longSparseArray) throws IOException {
            jsonReader.beginArray();
            int i4 = 0;
            while (jsonReader.hasNext()) {
                sr a4 = y.a(jsonReader, eVar);
                if (a4.m() == sr.c.IMAGE) {
                    i4++;
                }
                list.add(a4);
                longSparseArray.put(a4.v(), a4);
                if (i4 > 4) {
                    com.bytedance.adsdk.lottie.f.e.c("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                }
            }
            jsonReader.endArray();
        }

        private static void d(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar, Map<String, List<sr>> map, Map<String, com.bytedance.adsdk.lottie.h> map2) throws IOException {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                ArrayList arrayList = new ArrayList();
                LongSparseArray longSparseArray = new LongSparseArray();
                jsonReader.beginObject();
                String str = null;
                String str2 = null;
                String str3 = null;
                int i4 = 0;
                int i5 = 0;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    nextName.hashCode();
                    char c4 = '\uffff';
                    switch (nextName.hashCode()) {
                        case -1109732030:
                            if (nextName.equals("layers")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 104:
                            if (nextName.equals("h")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 112:
                            if (nextName.equals("p")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 117:
                            if (nextName.equals("u")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case 119:
                            if (nextName.equals("w")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 3355:
                            if (nextName.equals("id")) {
                                c4 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                sr a4 = y.a(jsonReader, eVar);
                                longSparseArray.put(a4.v(), a4);
                                arrayList.add(a4);
                            }
                            jsonReader.endArray();
                            break;
                        case 1:
                            i5 = jsonReader.nextInt();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            str3 = jsonReader.nextString();
                            break;
                        case 4:
                            i4 = jsonReader.nextInt();
                            break;
                        case 5:
                            str = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                if (str2 != null) {
                    com.bytedance.adsdk.lottie.h hVar = new com.bytedance.adsdk.lottie.h(i4, i5, str, str2, str3);
                    map2.put(hVar.f(), hVar);
                } else {
                    map.put(str, arrayList);
                }
            }
            jsonReader.endArray();
        }

        private static void e(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.xv.b> list) throws IOException {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                String str = null;
                jsonReader.beginObject();
                float f4 = 0.0f;
                float f5 = 0.0f;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    nextName.hashCode();
                    char c4 = '\uffff';
                    switch (nextName.hashCode()) {
                        case 3178:
                            if (nextName.equals("cm")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 3214:
                            if (nextName.equals(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE)) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 3705:
                            if (nextName.equals("tm")) {
                                c4 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            f5 = (float) jsonReader.nextDouble();
                            break;
                        case 2:
                            f4 = (float) jsonReader.nextDouble();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                list.add(new com.bytedance.adsdk.lottie.xv.b(str, f4, f5));
            }
            jsonReader.endArray();
        }

        private static void f(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.xv.f> map) throws IOException {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("list")) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.xv.f a4 = c0.a(jsonReader);
                        map.put(a4.d(), a4);
                    }
                    jsonReader.endArray();
                }
            }
            jsonReader.endObject();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class r {

        /* renamed from: a  reason: collision with root package name */
        private com.bytedance.adsdk.lottie.xv.c.c f25730a;

        /* renamed from: b  reason: collision with root package name */
        private com.bytedance.adsdk.lottie.xv.c.m f25731b;

        /* renamed from: c  reason: collision with root package name */
        private com.bytedance.adsdk.lottie.xv.c.m f25732c;

        /* renamed from: d  reason: collision with root package name */
        private com.bytedance.adsdk.lottie.xv.c.m f25733d;

        /* renamed from: e  reason: collision with root package name */
        private com.bytedance.adsdk.lottie.xv.c.m f25734e;

        private void b(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            jsonReader.beginObject();
            String str = "";
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (nextName.equals("v")) {
                    str.hashCode();
                    char c4 = '\uffff';
                    switch (str.hashCode()) {
                        case 353103893:
                            if (str.equals("Distance")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case 397447147:
                            if (str.equals("Opacity")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case 1041377119:
                            if (str.equals("Direction")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case 1379387491:
                            if (str.equals("Shadow Color")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case 1383710113:
                            if (str.equals("Softness")) {
                                c4 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            this.f25733d = b0.a(jsonReader, eVar);
                            continue;
                        case 1:
                            this.f25731b = b0.b(jsonReader, eVar, false);
                            continue;
                        case 2:
                            this.f25732c = b0.b(jsonReader, eVar, false);
                            continue;
                        case 3:
                            this.f25730a = b0.g(jsonReader, eVar);
                            continue;
                        case 4:
                            this.f25734e = b0.a(jsonReader, eVar);
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                    }
                } else if (!nextName.equals("nm")) {
                    jsonReader.skipValue();
                } else {
                    str = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
        }

        w a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            com.bytedance.adsdk.lottie.xv.c.m mVar;
            com.bytedance.adsdk.lottie.xv.c.m mVar2;
            com.bytedance.adsdk.lottie.xv.c.m mVar3;
            com.bytedance.adsdk.lottie.xv.c.m mVar4;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("ef")) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        b(jsonReader, eVar);
                    }
                    jsonReader.endArray();
                }
            }
            com.bytedance.adsdk.lottie.xv.c.c cVar = this.f25730a;
            if (cVar == null || (mVar = this.f25731b) == null || (mVar2 = this.f25732c) == null || (mVar3 = this.f25733d) == null || (mVar4 = this.f25734e) == null) {
                return null;
            }
            return new w(cVar, mVar, mVar2, mVar3, mVar4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.lottie.s$s  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0353s {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
            if (r1.equals("s") == false) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static com.bytedance.adsdk.lottie.xv.w.ev a(android.util.JsonReader r11, com.bytedance.adsdk.lottie.e r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 282
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.s.C0353s.a(android.util.JsonReader, com.bytedance.adsdk.lottie.e):com.bytedance.adsdk.lottie.xv.w.ev");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface t<V> {
        V a(JsonReader jsonReader, float f4) throws IOException;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class u {
        static com.bytedance.adsdk.lottie.xv.w.b a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 114:
                        if (nextName.equals("r")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 2;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        mVar = b0.b(jsonReader, eVar, true);
                        break;
                    case 1:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 2:
                        str = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            if (z3) {
                return null;
            }
            return new com.bytedance.adsdk.lottie.xv.w.b(str, mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class v {
        static com.bytedance.adsdk.lottie.c.w.g a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            return new com.bytedance.adsdk.lottie.c.w.g(eVar, d0.d(jsonReader, eVar, com.bytedance.adsdk.lottie.f.b.a(), g.f25723a, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class w {

        /* renamed from: a  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.xv.c.c f25735a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.xv.c.m f25736b;

        /* renamed from: c  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.xv.c.m f25737c;

        /* renamed from: d  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.xv.c.m f25738d;

        /* renamed from: e  reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.xv.c.m f25739e;

        w(com.bytedance.adsdk.lottie.xv.c.c cVar, com.bytedance.adsdk.lottie.xv.c.m mVar, com.bytedance.adsdk.lottie.xv.c.m mVar2, com.bytedance.adsdk.lottie.xv.c.m mVar3, com.bytedance.adsdk.lottie.xv.c.m mVar4) {
            this.f25735a = cVar;
            this.f25736b = mVar;
            this.f25737c = mVar2;
            this.f25738d = mVar3;
            this.f25739e = mVar4;
        }

        public com.bytedance.adsdk.lottie.xv.c.c a() {
            return this.f25735a;
        }

        public com.bytedance.adsdk.lottie.xv.c.m b() {
            return this.f25738d;
        }

        public com.bytedance.adsdk.lottie.xv.c.m c() {
            return this.f25739e;
        }

        public com.bytedance.adsdk.lottie.xv.c.m d() {
            return this.f25736b;
        }

        public com.bytedance.adsdk.lottie.xv.c.m e() {
            return this.f25737c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class x {
        static com.bytedance.adsdk.lottie.xv.w.f a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.d dVar = null;
            int i4 = 0;
            boolean z3 = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c4 = '\uffff';
                switch (nextName.hashCode()) {
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case 3432:
                        if (nextName.equals("ks")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 104415:
                        if (nextName.equals("ind")) {
                            c4 = 3;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case 1:
                        dVar = b0.i(jsonReader, eVar);
                        break;
                    case 2:
                        str = jsonReader.nextString();
                        break;
                    case 3:
                        i4 = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            return new com.bytedance.adsdk.lottie.xv.w.f(str, i4, dVar, z3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class y {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ int[] f25740a;

            static {
                int[] iArr = new int[sr.w.values().length];
                f25740a = iArr;
                try {
                    iArr[sr.w.LUMA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f25740a[sr.w.LUMA_INVERTED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static sr a(JsonReader jsonReader, com.bytedance.adsdk.lottie.e eVar) throws IOException {
            ArrayList arrayList;
            char c4;
            sr.w wVar = sr.w.NONE;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            jsonReader.beginObject();
            Float valueOf = Float.valueOf(1.0f);
            Float valueOf2 = Float.valueOf(0.0f);
            sr.w wVar2 = wVar;
            sr.c cVar = null;
            String str = null;
            com.bytedance.adsdk.lottie.xv.c.a aVar = null;
            com.bytedance.adsdk.lottie.xv.c.h hVar = null;
            com.bytedance.adsdk.lottie.xv.c.g gVar = null;
            com.bytedance.adsdk.lottie.xv.c.m mVar = null;
            com.bytedance.adsdk.lottie.xv.w.c cVar2 = null;
            w wVar3 = null;
            long j4 = -1;
            float f4 = 0.0f;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            float f5 = 1.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            boolean z3 = false;
            float f9 = 0.0f;
            long j5 = 0;
            String str2 = null;
            String str3 = "UNSET";
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case -995424086:
                        if (nextName.equals("parent")) {
                            c4 = 0;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case -903568142:
                        if (nextName.equals("shapes")) {
                            c4 = 1;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c4 = 2;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c4 = 3;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c4 = 4;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3177:
                        if (nextName.equals("cl")) {
                            c4 = 5;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3233:
                        if (nextName.equals("ef")) {
                            c4 = 6;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3324:
                        if (nextName.equals(LiveConfigKey.HIGH)) {
                            c4 = 7;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3367:
                        if (nextName.equals("ip")) {
                            c4 = '\b';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3432:
                        if (nextName.equals("ks")) {
                            c4 = '\t';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3519:
                        if (nextName.equals("nm")) {
                            c4 = '\n';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3553:
                        if (nextName.equals("op")) {
                            c4 = 11;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3664:
                        if (nextName.equals("sc")) {
                            c4 = '\f';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3669:
                        if (nextName.equals("sh")) {
                            c4 = '\r';
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3679:
                        if (nextName.equals("sr")) {
                            c4 = 14;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3681:
                        if (nextName.equals("st")) {
                            c4 = 15;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3684:
                        if (nextName.equals("sw")) {
                            c4 = 16;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3705:
                        if (nextName.equals("tm")) {
                            c4 = 17;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3712:
                        if (nextName.equals("tt")) {
                            c4 = 18;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 3717:
                        if (nextName.equals("ty")) {
                            c4 = 19;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 104415:
                        if (nextName.equals("ind")) {
                            c4 = 20;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 108390670:
                        if (nextName.equals("refId")) {
                            c4 = 21;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    case 1441620890:
                        if (nextName.equals("masksProperties")) {
                            c4 = 22;
                            break;
                        }
                        c4 = '\uffff';
                        break;
                    default:
                        c4 = '\uffff';
                        break;
                }
                switch (c4) {
                    case 0:
                        j4 = jsonReader.nextInt();
                        break;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.xv.w.l a4 = i.a(jsonReader, eVar);
                            if (a4 != null) {
                                arrayList3.add(a4);
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case 2:
                        double nextDouble = jsonReader.nextDouble();
                        double a5 = com.bytedance.adsdk.lottie.f.b.a();
                        Double.isNaN(a5);
                        f8 = (float) (nextDouble * a5);
                        break;
                    case 3:
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("a")) {
                                jsonReader.beginArray();
                                if (jsonReader.hasNext()) {
                                    gVar = f0.a(jsonReader, eVar);
                                }
                                while (jsonReader.hasNext()) {
                                    jsonReader.skipValue();
                                }
                                jsonReader.endArray();
                            } else if (!nextName2.equals("d")) {
                                jsonReader.skipValue();
                            } else {
                                hVar = b0.f(jsonReader, eVar);
                            }
                        }
                        jsonReader.endObject();
                        break;
                    case 4:
                        double nextDouble2 = jsonReader.nextDouble();
                        double a6 = com.bytedance.adsdk.lottie.f.b.a();
                        Double.isNaN(a6);
                        f7 = (float) (nextDouble2 * a6);
                        break;
                    case 5:
                        str2 = jsonReader.nextString();
                        break;
                    case 6:
                        jsonReader.beginArray();
                        ArrayList arrayList4 = new ArrayList();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String nextName3 = jsonReader.nextName();
                                nextName3.hashCode();
                                if (nextName3.equals("nm")) {
                                    arrayList4.add(jsonReader.nextString());
                                } else if (!nextName3.equals("ty")) {
                                    jsonReader.skipValue();
                                } else {
                                    int nextInt = jsonReader.nextInt();
                                    if (nextInt == 29) {
                                        cVar2 = e0.a(jsonReader, eVar);
                                    } else if (nextInt == 25) {
                                        wVar3 = new r().a(jsonReader, eVar);
                                    }
                                }
                            }
                            jsonReader.endObject();
                        }
                        jsonReader.endArray();
                        eVar.g("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                        break;
                    case 7:
                        z3 = jsonReader.nextBoolean();
                        break;
                    case '\b':
                        f4 = (float) jsonReader.nextDouble();
                        break;
                    case '\t':
                        aVar = k0.a(jsonReader, eVar);
                        break;
                    case '\n':
                        str3 = jsonReader.nextString();
                        break;
                    case 11:
                        f9 = (float) jsonReader.nextDouble();
                        break;
                    case '\f':
                        i6 = Color.parseColor(jsonReader.nextString());
                        break;
                    case '\r':
                        i5 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.f.b.a());
                        break;
                    case 14:
                        f5 = (float) jsonReader.nextDouble();
                        break;
                    case 15:
                        f6 = (float) jsonReader.nextDouble();
                        break;
                    case 16:
                        i4 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.f.b.a());
                        break;
                    case 17:
                        mVar = b0.b(jsonReader, eVar, false);
                        break;
                    case 18:
                        int nextInt2 = jsonReader.nextInt();
                        if (nextInt2 >= sr.w.values().length) {
                            eVar.g("Unsupported matte type: " + nextInt2);
                            break;
                        } else {
                            wVar2 = sr.w.values()[nextInt2];
                            int i7 = a.f25740a[wVar2.ordinal()];
                            if (i7 == 1) {
                                eVar.g("Unsupported matte type: Luma");
                            } else if (i7 == 2) {
                                eVar.g("Unsupported matte type: Luma Inverted");
                            }
                            eVar.e(1);
                            break;
                        }
                    case 19:
                        int nextInt3 = jsonReader.nextInt();
                        cVar = sr.c.UNKNOWN;
                        if (nextInt3 >= cVar.ordinal()) {
                            break;
                        } else {
                            cVar = sr.c.values()[nextInt3];
                            break;
                        }
                    case 20:
                        j5 = jsonReader.nextInt();
                        break;
                    case 21:
                        str = jsonReader.nextString();
                        break;
                    case 22:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList2.add(C0353s.a(jsonReader, eVar));
                        }
                        eVar.e(arrayList2.size());
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            ArrayList arrayList5 = new ArrayList();
            if (f4 > 0.0f) {
                arrayList = arrayList2;
                arrayList5.add(new n.h(eVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f4)));
            } else {
                arrayList = arrayList2;
            }
            if (f9 <= 0.0f) {
                f9 = eVar.o();
            }
            arrayList5.add(new n.h(eVar, valueOf, valueOf, null, f4, Float.valueOf(f9)));
            arrayList5.add(new n.h(eVar, valueOf2, valueOf2, null, f9, Float.valueOf(Float.MAX_VALUE)));
            if (str3.endsWith(".ai") || "ai".equals(str2)) {
                eVar.g("Convert your Illustrator layers to shape layers.");
            }
            return new sr(arrayList3, eVar, str3, j5, cVar, j4, str, arrayList, aVar, i4, i5, i6, f5, f6, f7, f8, hVar, gVar, arrayList5, wVar2, mVar, z3, cVar2, wVar3);
        }

        public static sr b(com.bytedance.adsdk.lottie.e eVar) {
            Rect p3 = eVar.p();
            return new sr(Collections.emptyList(), eVar, "__container", -1L, sr.c.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.lottie.xv.c.a(), 0, 0, 0, 0.0f, 0.0f, p3.width(), p3.height(), null, null, Collections.emptyList(), sr.w.NONE, null, false, null, null);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class z implements t<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final z f25741a = new z();

        private z() {
        }

        @Override // com.bytedance.adsdk.lottie.s.t
        /* renamed from: b */
        public Integer a(JsonReader jsonReader, float f4) throws IOException {
            boolean z3 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
            if (z3) {
                jsonReader.beginArray();
            }
            double nextDouble = jsonReader.nextDouble();
            double nextDouble2 = jsonReader.nextDouble();
            double nextDouble3 = jsonReader.nextDouble();
            double nextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? jsonReader.nextDouble() : 1.0d;
            if (z3) {
                jsonReader.endArray();
            }
            if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d) {
                nextDouble *= 255.0d;
                nextDouble2 *= 255.0d;
                nextDouble3 *= 255.0d;
                if (nextDouble4 <= 1.0d) {
                    nextDouble4 *= 255.0d;
                }
            }
            return Integer.valueOf(Color.argb((int) nextDouble4, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
        }
    }

    public static com.bytedance.adsdk.lottie.sr.b a(Context context) {
        com.bytedance.adsdk.lottie.sr.b bVar = f25716k;
        if (bVar == null) {
            synchronized (com.bytedance.adsdk.lottie.sr.b.class) {
                bVar = f25716k;
                if (bVar == null) {
                    com.bytedance.adsdk.lottie.sr.d e4 = e(context);
                    com.bytedance.adsdk.lottie.sr.c cVar = f25714i;
                    if (cVar == null) {
                        cVar = new com.bytedance.adsdk.lottie.sr.g();
                    }
                    bVar = new com.bytedance.adsdk.lottie.sr.b(e4, cVar);
                    f25716k = bVar;
                }
            }
        }
        return bVar;
    }

    public static void b(String str) {
        if (f25707b) {
            int i4 = f25712g;
            if (i4 == 20) {
                f25713h++;
                return;
            }
            f25710e[i4] = str;
            f25711f[i4] = System.nanoTime();
            Trace.beginSection(str);
            f25712g++;
        }
    }

    public static boolean c() {
        return f25709d;
    }

    public static float d(String str) {
        int i4 = f25713h;
        if (i4 > 0) {
            f25713h = i4 - 1;
            return 0.0f;
        } else if (f25707b) {
            int i5 = f25712g - 1;
            f25712g = i5;
            if (i5 != -1) {
                if (str.equals(f25710e[i5])) {
                    Trace.endSection();
                    return ((float) (System.nanoTime() - f25711f[f25712g])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f25710e[f25712g] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }

    public static com.bytedance.adsdk.lottie.sr.d e(Context context) {
        if (f25708c) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            com.bytedance.adsdk.lottie.sr.d dVar = f25717l;
            if (dVar == null) {
                synchronized (com.bytedance.adsdk.lottie.sr.d.class) {
                    dVar = f25717l;
                    if (dVar == null) {
                        com.bytedance.adsdk.lottie.sr.f fVar = f25715j;
                        if (fVar == null) {
                            fVar = new a(origApplicationContext);
                        }
                        dVar = new com.bytedance.adsdk.lottie.sr.d(fVar);
                        f25717l = dVar;
                    }
                }
            }
            return dVar;
        }
        return null;
    }
}
