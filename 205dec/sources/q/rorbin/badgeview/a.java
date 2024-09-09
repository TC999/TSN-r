package q.rorbin.badgeview;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Badge.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Badge.java */
    /* renamed from: q.rorbin.badgeview.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface InterfaceC1256a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f61977a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f61978b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f61979c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f61980d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f61981e = 5;

        void a(int i4, a aVar, View view);
    }

    float a(boolean z3);

    boolean b();

    a c(View view);

    float d(boolean z3);

    a e(String str);

    float f(boolean z3);

    a g(int i4);

    Drawable getBadgeBackground();

    int getBadgeBackgroundColor();

    int getBadgeGravity();

    int getBadgeNumber();

    String getBadgeText();

    int getBadgeTextColor();

    PointF getDragCenter();

    View getTargetView();

    void h(boolean z3);

    boolean i();

    a j(InterfaceC1256a interfaceC1256a);

    float k(boolean z3);

    boolean l();

    a m(int i4);

    a n(float f4, boolean z3);

    a o(int i4, float f4, boolean z3);

    a p(int i4);

    a q(Drawable drawable);

    a r(int i4);

    a s(float f4, float f5, boolean z3);

    a t(boolean z3);

    a u(boolean z3);

    a v(float f4, boolean z3);

    a w(float f4, boolean z3);

    a x(Drawable drawable, boolean z3);
}
