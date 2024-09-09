package com.kwad.components.ad.j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a<L extends h> {
    public AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.j.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 extends com.kwad.components.ad.widget.tailframe.appbar.b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(final Animator animator) {
            if (a.a(a.this)) {
                return;
            }
            if (a.b(a.this) == null) {
                a.a(a.this, new Runnable() { // from class: com.kwad.components.ad.j.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        animator.start();
                    }
                });
            }
            bo.a(a.b(a.this), null, 1600L);
        }
    }

    /* renamed from: com.kwad.components.ad.j.a$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass2 extends com.kwad.components.ad.widget.tailframe.appbar.b {
        final /* synthetic */ View HP;

        AnonymousClass2(View view) {
            this.HP = view;
        }

        @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.HP.setAlpha(1.0f);
            ViewGroup.LayoutParams layoutParams = this.HP.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = 0;
                layoutParams.height = 0;
                this.HP.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.j.a$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float HQ;
        final /* synthetic */ float HR;
        final /* synthetic */ float HS;
        final /* synthetic */ View fo;

        AnonymousClass3(float f4, float f5, float f6, View view) {
            this.HQ = f4;
            this.HR = f5;
            this.HS = f6;
            this.fo = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f4 = this.HQ * floatValue;
            float f5 = this.HR;
            if (f5 != 0.0f) {
                float f6 = (floatValue / f5) * this.HS;
                View view = this.fo;
                if (view instanceof TextView) {
                    ((TextView) view).setTextSize(0, f6);
                }
            }
            ViewGroup.LayoutParams layoutParams = this.fo.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) floatValue;
                layoutParams.width = (int) f4;
                this.fo.setLayoutParams(layoutParams);
            }
        }
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public abstract void a(L l4);

    @MainThread
    public abstract void b(L l4);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean jH() {
        return false;
    }

    public abstract void pause();

    @WorkerThread
    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z3, boolean z4) {
    }

    public void skipToEnd() {
    }
}
