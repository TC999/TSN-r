package com.acse.ottn.animator.p033c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.c.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1386f extends AbstractC1379b {

    /* renamed from: b */
    private static final long f2468b = -1;

    /* renamed from: c */
    private final WeakReference<ViewPropertyAnimator> f2469c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1386f(View view) {
        this.f2469c = new WeakReference<>(view.animate());
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56896a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56892a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56891a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public AbstractC1379b mo56890a(AbstractC1334a.InterfaceC1335a interfaceC1335a) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            if (interfaceC1335a == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new C1385e(this, interfaceC1335a));
            }
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: a */
    public void mo56897a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public long mo56886b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56885b(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: b */
    public AbstractC1379b mo56883b(long j) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public long mo56881c() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: c */
    public AbstractC1379b mo56880c(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public AbstractC1379b mo56876d(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: d */
    public void mo56877d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: e */
    public AbstractC1379b mo56873e(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: f */
    public AbstractC1379b mo56872f(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: g */
    public AbstractC1379b mo56871g(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: h */
    public AbstractC1379b mo56870h(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: i */
    public AbstractC1379b mo56869i(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: j */
    public AbstractC1379b mo56868j(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: k */
    public AbstractC1379b mo56867k(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: l */
    public AbstractC1379b mo56866l(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: m */
    public AbstractC1379b mo56865m(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: n */
    public AbstractC1379b mo56864n(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: o */
    public AbstractC1379b mo56863o(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: p */
    public AbstractC1379b mo56862p(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: q */
    public AbstractC1379b mo56861q(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: r */
    public AbstractC1379b mo56860r(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: s */
    public AbstractC1379b mo56859s(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    @Override // com.acse.ottn.animator.p033c.AbstractC1379b
    /* renamed from: t */
    public AbstractC1379b mo56858t(float f) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2469c.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }
}
