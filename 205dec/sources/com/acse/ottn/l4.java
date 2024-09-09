package com.acse.ottn;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l4 extends j4 {

    /* renamed from: c  reason: collision with root package name */
    public static final long f5898c = -1;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<ViewPropertyAnimator> f5899b;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i.a f5900a;

        public a(i.a aVar) {
            this.f5900a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5900a.d(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5900a.b(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f5900a.c(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f5900a.a(null);
        }
    }

    public l4(View view) {
        this.f5899b = new WeakReference<>(view.animate());
    }

    @Override // com.acse.ottn.j4
    public j4 a(long j4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public long b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.acse.ottn.j4
    public long c() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.acse.ottn.j4
    public void d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.acse.ottn.j4
    public j4 e(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 f(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 g(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 h(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 i(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 j(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 k(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 l(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 m(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 n(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 o(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 p(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 q(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 r(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 s(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 t(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 b(long j4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 c(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 d(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 a(i.a aVar) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            if (aVar == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new a(aVar));
            }
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public j4 b(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.j4
    public void a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.acse.ottn.j4
    public j4 a(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5899b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f4);
        }
        return this;
    }
}
