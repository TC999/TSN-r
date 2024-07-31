package p635q.rorbin.badgeview;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: q.rorbin.badgeview.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Badge {

    /* compiled from: Badge.java */
    /* renamed from: q.rorbin.badgeview.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15475a {

        /* renamed from: a */
        public static final int f44573a = 1;

        /* renamed from: b */
        public static final int f44574b = 2;

        /* renamed from: c */
        public static final int f44575c = 3;

        /* renamed from: d */
        public static final int f44576d = 4;

        /* renamed from: e */
        public static final int f44577e = 5;

        /* renamed from: a */
        void m2149a(int i, Badge badge, View view);
    }

    /* renamed from: a */
    float mo2173a(boolean z);

    /* renamed from: b */
    boolean mo2172b();

    /* renamed from: c */
    Badge mo2171c(View view);

    /* renamed from: d */
    float mo2170d(boolean z);

    /* renamed from: e */
    Badge mo2169e(String str);

    /* renamed from: f */
    float mo2168f(boolean z);

    /* renamed from: g */
    Badge mo2167g(int i);

    Drawable getBadgeBackground();

    int getBadgeBackgroundColor();

    int getBadgeGravity();

    int getBadgeNumber();

    String getBadgeText();

    int getBadgeTextColor();

    PointF getDragCenter();

    View getTargetView();

    /* renamed from: h */
    void mo2166h(boolean z);

    /* renamed from: i */
    boolean mo2165i();

    /* renamed from: j */
    Badge mo2164j(InterfaceC15475a interfaceC15475a);

    /* renamed from: k */
    float mo2163k(boolean z);

    /* renamed from: l */
    boolean mo2162l();

    /* renamed from: m */
    Badge mo2161m(int i);

    /* renamed from: n */
    Badge mo2160n(float f, boolean z);

    /* renamed from: o */
    Badge mo2159o(int i, float f, boolean z);

    /* renamed from: p */
    Badge mo2158p(int i);

    /* renamed from: q */
    Badge mo2157q(Drawable drawable);

    /* renamed from: r */
    Badge mo2156r(int i);

    /* renamed from: s */
    Badge mo2155s(float f, float f2, boolean z);

    /* renamed from: t */
    Badge mo2154t(boolean z);

    /* renamed from: u */
    Badge mo2153u(boolean z);

    /* renamed from: v */
    Badge mo2152v(float f, boolean z);

    /* renamed from: w */
    Badge mo2151w(float f, boolean z);

    /* renamed from: x */
    Badge mo2150x(Drawable drawable, boolean z);
}
