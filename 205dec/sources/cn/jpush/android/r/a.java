package cn.jpush.android.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import cn.jpush.android.helper.Logger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: cn.jpush.android.r.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface InterfaceC0072a {
        void a();
    }

    public static void a(View view, Point point, long j4, final InterfaceC0072a interfaceC0072a) {
        if (view == null) {
            Logger.w("InAppAnimator", "[slideOutOfView] view is null");
        } else {
            view.animate().translationX(point.x).translationY(point.y).setDuration(j4).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    try {
                        InterfaceC0072a interfaceC0072a2 = InterfaceC0072a.this;
                        if (interfaceC0072a2 != null) {
                            interfaceC0072a2.a();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void a(final View view, Point point, final Point point2, final long j4, final InterfaceC0072a interfaceC0072a) {
        if (view == null) {
            Logger.w("InAppAnimator", "[slideIntoView] view is null");
            return;
        }
        view.setAlpha(0.0f);
        view.animate().translationX(point.x).translationY(point.y).setDuration(10L).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                try {
                    view.animate().translationX(point2.x).translationY(point2.y).alpha(1.0f).setDuration(j4).setListener(null);
                    InterfaceC0072a interfaceC0072a2 = interfaceC0072a;
                    if (interfaceC0072a2 != null) {
                        interfaceC0072a2.a();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
