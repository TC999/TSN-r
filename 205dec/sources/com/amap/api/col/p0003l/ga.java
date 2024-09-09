package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.col.p0003l.s;
import com.amap.api.col.p0003l.t;
import com.amap.api.col.p0003l.v;
import com.amap.api.col.p0003l.w;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FeatureManager.java */
/* renamed from: com.amap.api.col.3l.ga  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ga {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Boolean> f7898a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f7899b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: FeatureManager.java */
    /* renamed from: com.amap.api.col.3l.ga$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static ga f7900a = new ga((byte) 0);
    }

    /* synthetic */ ga(byte b4) {
        this();
    }

    public static ga a() {
        return a.f7900a;
    }

    private void e() {
        this.f7898a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f7898a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f7898a.put("feature_terrain", bool);
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mvt_able");
        g4.x(optString, true);
        this.f7898a.put("feature_mvt", Boolean.valueOf(g4.x(optString, true)));
        this.f7898a.put("feature_gltf", Boolean.valueOf(g4.x(jSONObject.optString("gltf_able"), false)));
        this.f7898a.put("feature_terrain", Boolean.valueOf(g4.x(jSONObject.optString("terrain_able"), false)));
        this.f7899b.set(true);
    }

    public final boolean c(String str) {
        if (this.f7898a.containsKey(str)) {
            return this.f7898a.get(str).booleanValue();
        }
        return false;
    }

    public final boolean d() {
        return this.f7899b.get();
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class b implements s.a {

        /* renamed from: a  reason: collision with root package name */
        private EAMapPlatformGestureInfo f7901a;

        private b() {
            this.f7901a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final void a(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7901a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ga.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7901a);
                    if (ga.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (ga.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && ga.a(ga.this) > 0) {
                        ga.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    ga.i(ga.this, false);
                    IAMapDelegate iAMapDelegate = ga.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final boolean b(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7901a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z3 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ga.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7901a);
                    if (!ga.this.a.isLockMapCameraDegree(engineIDWithGestureInfo) && ga.k(ga.this) <= 3) {
                        float f4 = sVar.n().x;
                        float f5 = sVar.n().y;
                        if (!ga.q(ga.this)) {
                            PointF k4 = sVar.k(0);
                            PointF k5 = sVar.k(1);
                            float f6 = k4.y;
                            if ((f6 > 10.0f && k5.y > 10.0f) || (f6 < -10.0f && k5.y < -10.0f)) {
                                z3 = true;
                            }
                            if (z3 && Math.abs(f5) > 10.0f && Math.abs(f4) < 10.0f) {
                                ga.i(ga.this, true);
                            }
                        }
                        if (ga.q(ga.this)) {
                            ga.i(ga.this, true);
                            float f7 = f5 / 6.0f;
                            if (Math.abs(f7) > 1.0f) {
                                ga.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f7));
                                ga.u(ga.this);
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003l.s.a
        public final boolean c(s sVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7901a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{sVar.i().getX(), sVar.i().getY()};
            try {
                if (ga.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7901a);
                    if (ga.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    IAMapDelegate iAMapDelegate = ga.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ b(ga gaVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class c implements t.a {

        /* renamed from: a  reason: collision with root package name */
        private EAMapPlatformGestureInfo f7903a;

        private c() {
            this.f7903a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final boolean a(t tVar) {
            try {
                if (ga.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7903a;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                    ga.this.a.addGestureMapMessage(ga.this.a.getEngineIDWithGestureInfo(this.f7903a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, tVar.i().getX(), tVar.i().getY()));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final void b(t tVar) {
            try {
                if (ga.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7903a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                    int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7903a);
                    if (ga.s(ga.this) > 0) {
                        ga.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    ga.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, tVar.i().getX(), tVar.i().getY()));
                }
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.p0003l.t.a
        public final boolean c(t tVar) {
            if (ga.q(ga.this)) {
                return true;
            }
            try {
                if (ga.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!ga.r(ga.this)) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7903a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
                        int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7903a);
                        PointF j4 = tVar.j();
                        float f4 = ga.s(ga.this) == 0 ? 4.0f : 1.0f;
                        if (Math.abs(j4.x) <= f4 && Math.abs(j4.y) <= f4) {
                            return false;
                        }
                        if (ga.s(ga.this) == 0) {
                            ga.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        ga.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, j4.x, j4.y, tVar.i().getX(), tVar.i().getY()));
                        ga.t(ga.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ c(ga gaVar, byte b4) {
            this();
        }
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$e */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class e extends w.b {

        /* renamed from: a  reason: collision with root package name */
        EAMapPlatformGestureInfo f7915a;

        private e() {
            this.f7915a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.p0003l.w.b, com.amap.api.col.p0003l.w.a
        public final void a(w wVar) {
            try {
                if (ga.this.a.getUiSettings().isZoomGesturesEnabled() && Math.abs(wVar.n()) <= 10.0f && Math.abs(wVar.o()) <= 10.0f && wVar.f() < 200) {
                    ga.v(ga.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7915a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{wVar.i().getX(), wVar.i().getY()};
                    int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7915a);
                    ga.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                    ga.this.a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        /* synthetic */ e(ga gaVar, byte b4) {
            this();
        }
    }

    private ga() {
        this.f7898a = new ConcurrentHashMap();
        this.f7899b = new AtomicBoolean(false);
        e();
    }

    /* compiled from: GlMapGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.ga$d */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private class d extends v.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f7905a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7906b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7907c;

        /* renamed from: d  reason: collision with root package name */
        private Point f7908d;

        /* renamed from: e  reason: collision with root package name */
        private float[] f7909e;

        /* renamed from: f  reason: collision with root package name */
        private float f7910f;

        /* renamed from: g  reason: collision with root package name */
        private float[] f7911g;

        /* renamed from: h  reason: collision with root package name */
        private float f7912h;

        /* renamed from: i  reason: collision with root package name */
        private EAMapPlatformGestureInfo f7913i;

        private d() {
            this.f7905a = false;
            this.f7906b = false;
            this.f7907c = false;
            this.f7908d = new Point();
            this.f7909e = new float[10];
            this.f7910f = 0.0f;
            this.f7911g = new float[10];
            this.f7912h = 0.0f;
            this.f7913i = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00f3 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fc A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x00cb, B:33:0x00f3, B:34:0x00fc, B:24:0x00b6), top: B:77:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0124 A[Catch: all -> 0x019c, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x016b A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #2 {all -> 0x019c, blocks: (B:43:0x0116, B:45:0x0124, B:47:0x012e, B:49:0x0132, B:51:0x013c, B:53:0x0144, B:54:0x0146, B:56:0x014a, B:67:0x016b, B:62:0x015c), top: B:80:0x0116 }] */
        @Override // com.amap.api.col.p0003l.v.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean d(com.amap.api.col.p0003l.v r18) {
            /*
                Method dump skipped, instructions count: 421
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ga.d.d(com.amap.api.col.3l.v):boolean");
        }

        @Override // com.amap.api.col.p0003l.v.a
        public final boolean e(v vVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7913i;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{vVar.c().getX(), vVar.c().getY()};
            int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7913i);
            int f4 = (int) vVar.f();
            int i4 = (int) vVar.i();
            this.f7907c = false;
            Point point = this.f7908d;
            point.x = f4;
            point.y = i4;
            this.f7905a = false;
            this.f7906b = false;
            ga.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, f4, i4));
            try {
                if (ga.this.a.getUiSettings().isRotateGesturesEnabled() && !ga.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = ga.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), f4, i4));
                }
            } catch (Throwable th) {
                t5.p(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.p0003l.v.a
        public final void f(v vVar) {
            float f4;
            float f5;
            float f6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f7913i;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z3 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{vVar.c().getX(), vVar.c().getY()};
            int engineIDWithGestureInfo = ga.this.a.getEngineIDWithGestureInfo(this.f7913i);
            this.f7907c = false;
            ga.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (ga.h(ga.this) > 0) {
                int h4 = ga.h(ga.this) > 10 ? 10 : ga.h(ga.this);
                float f7 = 0.0f;
                for (int i4 = 0; i4 < 10; i4++) {
                    float[] fArr = this.f7909e;
                    f7 += fArr[i4];
                    fArr[i4] = 0.0f;
                }
                float f8 = f7 / h4;
                if (0.004f <= f8) {
                    float f9 = f8 * 300.0f;
                    if (f9 >= 1.5f) {
                        f9 = 1.5f;
                    }
                    if (this.f7910f < 0.0f) {
                        f9 = -f9;
                    }
                    f6 = ga.this.a.getPreciseLevel(engineIDWithGestureInfo) + f9;
                } else {
                    f6 = -9999.0f;
                }
                this.f7910f = 0.0f;
                f4 = f6;
            } else {
                f4 = -9999.0f;
            }
            if (ga.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                f5 = -9999.0f;
            } else {
                try {
                    if (ga.this.a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = ga.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    t5.p(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (ga.k(ga.this) > 0) {
                    ga.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int k4 = ga.k(ga.this) > 10 ? 10 : ga.k(ga.this);
                    float f10 = 0.0f;
                    for (int i5 = 0; i5 < 10; i5++) {
                        float[] fArr2 = this.f7911g;
                        f10 += fArr2[i5];
                        fArr2[i5] = 0.0f;
                    }
                    float f11 = f10 / k4;
                    if (0.1f <= f11) {
                        float f12 = f11 * 200.0f;
                        int mapAngle = ((int) ga.this.a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f12 >= 60.0f) {
                            f12 = 60.0f;
                        }
                        if (this.f7912h < 0.0f) {
                            f12 = -f12;
                        }
                        f5 = ((int) (mapAngle + f12)) % 360;
                        this.f7910f = 0.0f;
                    }
                }
                f5 = -9999.0f;
                this.f7910f = 0.0f;
            }
            if ((f4 == -9999.0f && f5 == -9999.0f) ? true : true) {
                ga.this.a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f7908d, f4, (int) f5, 500);
            }
        }

        /* synthetic */ d(ga gaVar, byte b4) {
            this();
        }
    }
}
