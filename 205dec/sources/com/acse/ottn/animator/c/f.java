package com.acse.ottn.animator.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1361a;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final long f5010b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ViewPropertyAnimator> f5011c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(View view) {
        this.f5011c = new WeakReference<>(view.animate());
    }

    @Override // com.acse.ottn.animator.c.b
    public b a(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b a(long j4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b a(AbstractC1361a.InterfaceC0082a interfaceC0082a) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            if (interfaceC0082a == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new e(this, interfaceC0082a));
            }
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public void a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.acse.ottn.animator.c.b
    public long b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.acse.ottn.animator.c.b
    public b b(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b b(long j4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public long c() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.acse.ottn.animator.c.b
    public b c(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b d(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public void d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.acse.ottn.animator.c.b
    public b e(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b f(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b g(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b h(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b i(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b j(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b k(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b l(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b m(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b n(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b o(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b p(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b q(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b r(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b s(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f4);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.c.b
    public b t(float f4) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5011c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f4);
        }
        return this;
    }
}
