package com.bxkj.student.run.app.utils;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Shader;
import com.bxkj.student.App;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.ArrayList;

/* renamed from: com.bxkj.student.run.app.utils.q */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RecordPathAnimUtil {

    /* renamed from: h */
    private PathMeasure f19700h;

    /* renamed from: i */
    private Path f19701i;

    /* renamed from: a */
    private final long f19693a = 5000;

    /* renamed from: b */
    private final long f19694b = 2000;

    /* renamed from: c */
    private final int f19695c = PredefinedCaptureConfigurations.f24409s;

    /* renamed from: e */
    private long f19697e = 2000;

    /* renamed from: f */
    private final float f19698f = 2000.0f;

    /* renamed from: g */
    private ArrayList<C5404a> f19699g = new ArrayList<>();

    /* renamed from: d */
    private int f19696d = ScreenUtil.m39534e(App.m43005o());

    /* compiled from: RecordPathAnimUtil.java */
    /* renamed from: com.bxkj.student.run.app.utils.q$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5404a {

        /* renamed from: a */
        private Path f19702a;

        /* renamed from: b */
        private Shader f19703b;

        /* renamed from: c */
        private float f19704c;

        /* renamed from: d */
        private int f19705d;

        /* renamed from: e */
        private Point f19706e;

        /* renamed from: f */
        private int f19707f;

        public C5404a(Path path, float pathLength, Shader shader) {
            this.f19702a = path;
            this.f19704c = pathLength;
            this.f19703b = shader;
        }

        /* renamed from: a */
        public int m39547a() {
            return this.f19707f;
        }

        /* renamed from: b */
        public Point m39546b() {
            return this.f19706e;
        }

        /* renamed from: c */
        public int m39545c() {
            return this.f19705d;
        }

        /* renamed from: d */
        public Path m39544d() {
            return this.f19702a;
        }

        /* renamed from: e */
        public float m39543e() {
            return this.f19704c;
        }

        /* renamed from: f */
        public Shader m39542f() {
            return this.f19703b;
        }

        /* renamed from: g */
        public void m39541g(int endColor) {
            this.f19707f = endColor;
        }

        /* renamed from: h */
        public void m39540h(Point endPoint) {
            this.f19706e = endPoint;
        }

        /* renamed from: i */
        public void m39539i(int index) {
            this.f19705d = index;
        }
    }

    /* renamed from: b */
    private void m39553b(float pathLength) {
        float f = pathLength / ((this.f19696d * 2000.0f) / 1080.0f);
        if (f <= 1.0f) {
            return;
        }
        long j = f * 2000.0f;
        if (j >= 5000) {
            m39548g(5000L);
        } else {
            m39548g(j);
        }
    }

    /* renamed from: a */
    public void m39554a(Point start, Point end, int startColor, int endColor) {
        if (this.f19701i == null) {
            Path path = new Path();
            this.f19701i = path;
            path.moveTo(start.x, start.y);
            this.f19701i.lineTo(end.x, end.y);
        }
        this.f19701i.lineTo(end.x, end.y);
        Path path2 = new Path();
        path2.moveTo(start.x, start.y);
        path2.lineTo(end.x, end.y);
        this.f19700h = new PathMeasure(path2, false);
        C5404a c5404a = new C5404a(path2, this.f19700h.getLength(), new LinearGradient(start.x, start.y, end.x, end.y, new int[]{startColor, endColor}, (float[]) null, Shader.TileMode.CLAMP));
        c5404a.m39540h(end);
        c5404a.m39541g(endColor);
        this.f19699g.add(c5404a);
        c5404a.m39539i(this.f19699g.size() - 1);
    }

    /* renamed from: c */
    public long m39552c() {
        return this.f19697e;
    }

    /* renamed from: d */
    public float m39551d() {
        ArrayList<C5404a> arrayList = this.f19699g;
        float f = 0.0f;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f += this.f19699g.get(i).m39543e();
            }
        }
        m39553b(f);
        return f;
    }

    /* renamed from: e */
    public ArrayList<C5404a> m39550e() {
        return this.f19699g;
    }

    /* renamed from: f */
    public Path m39549f() {
        return this.f19701i;
    }

    /* renamed from: g */
    public void m39548g(long ANIM_DURATION) {
        this.f19697e = ANIM_DURATION;
    }
}
