package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    private WeakReference<View> mView;
    Runnable mStartAction = null;
    Runnable mEndAction = null;
    int mOldLayerType = -1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.mVpa = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View view) {
            int i4 = this.mVpa.mOldLayerType;
            if (i4 > -1) {
                view.setLayerType(i4, null);
                this.mVpa.mOldLayerType = -1;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mEndAction = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            this.mAnimEndCalled = false;
            if (this.mVpa.mOldLayerType > -1) {
                view.setLayerType(2, null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mStartAction = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f4);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        return (Interpolator) view.animate().getInterpolator();
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.ViewPropertyAnimatorCompat.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            } : null);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f4) {
        View view = this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZ(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f4) {
        View view = this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f4) {
        View view = this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().z(f4);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f4) {
        View view = this.mView.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().zBy(f4);
        }
        return this;
    }
}
