package com.bxkj.student.run.app.utils;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Shader;
import com.bxkj.student.App;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RecordPathAnimUtil.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class q {

    /* renamed from: h  reason: collision with root package name */
    private PathMeasure f22930h;

    /* renamed from: i  reason: collision with root package name */
    private Path f22931i;

    /* renamed from: a  reason: collision with root package name */
    private final long f22923a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private final long f22924b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private final int f22925c = 1080;

    /* renamed from: e  reason: collision with root package name */
    private long f22927e = 2000;

    /* renamed from: f  reason: collision with root package name */
    private final float f22928f = 2000.0f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<a> f22929g = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private int f22926d = r.e(App.o());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RecordPathAnimUtil.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private Path f22932a;

        /* renamed from: b  reason: collision with root package name */
        private Shader f22933b;

        /* renamed from: c  reason: collision with root package name */
        private float f22934c;

        /* renamed from: d  reason: collision with root package name */
        private int f22935d;

        /* renamed from: e  reason: collision with root package name */
        private Point f22936e;

        /* renamed from: f  reason: collision with root package name */
        private int f22937f;

        public a(Path path, float pathLength, Shader shader) {
            this.f22932a = path;
            this.f22934c = pathLength;
            this.f22933b = shader;
        }

        public int a() {
            return this.f22937f;
        }

        public Point b() {
            return this.f22936e;
        }

        public int c() {
            return this.f22935d;
        }

        public Path d() {
            return this.f22932a;
        }

        public float e() {
            return this.f22934c;
        }

        public Shader f() {
            return this.f22933b;
        }

        public void g(int endColor) {
            this.f22937f = endColor;
        }

        public void h(Point endPoint) {
            this.f22936e = endPoint;
        }

        public void i(int index) {
            this.f22935d = index;
        }
    }

    private void b(float pathLength) {
        float f4 = pathLength / ((this.f22926d * 2000.0f) / 1080.0f);
        if (f4 <= 1.0f) {
            return;
        }
        long j4 = f4 * 2000.0f;
        if (j4 >= 5000) {
            g(5000L);
        } else {
            g(j4);
        }
    }

    public void a(Point start, Point end, int startColor, int endColor) {
        if (this.f22931i == null) {
            Path path = new Path();
            this.f22931i = path;
            path.moveTo(start.x, start.y);
            this.f22931i.lineTo(end.x, end.y);
        }
        this.f22931i.lineTo(end.x, end.y);
        Path path2 = new Path();
        path2.moveTo(start.x, start.y);
        path2.lineTo(end.x, end.y);
        this.f22930h = new PathMeasure(path2, false);
        a aVar = new a(path2, this.f22930h.getLength(), new LinearGradient(start.x, start.y, end.x, end.y, new int[]{startColor, endColor}, (float[]) null, Shader.TileMode.CLAMP));
        aVar.h(end);
        aVar.g(endColor);
        this.f22929g.add(aVar);
        aVar.i(this.f22929g.size() - 1);
    }

    public long c() {
        return this.f22927e;
    }

    public float d() {
        ArrayList<a> arrayList = this.f22929g;
        float f4 = 0.0f;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                f4 += this.f22929g.get(i4).e();
            }
        }
        b(f4);
        return f4;
    }

    public ArrayList<a> e() {
        return this.f22929g;
    }

    public Path f() {
        return this.f22931i;
    }

    public void g(long ANIM_DURATION) {
        this.f22927e = ANIM_DURATION;
    }
}
