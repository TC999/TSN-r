package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@RequiresApi(21)
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i4) {
        this.slideEdge = i4;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i4, @Px int i5) {
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 48) {
                    if (i4 != 80) {
                        if (i4 == 8388611) {
                            return createTranslationXAnimator(view2, isRtl(view) ? i5 : -i5, 0.0f);
                        } else if (i4 == 8388613) {
                            return createTranslationXAnimator(view2, isRtl(view) ? -i5 : i5, 0.0f);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i4);
                        }
                    }
                    return createTranslationYAnimator(view2, i5, 0.0f);
                }
                return createTranslationYAnimator(view2, -i5, 0.0f);
            }
            return createTranslationXAnimator(view2, -i5, 0.0f);
        }
        return createTranslationXAnimator(view2, i5, 0.0f);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i4, @Px int i5) {
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 48) {
                    if (i4 != 80) {
                        if (i4 == 8388611) {
                            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i5 : i5);
                        } else if (i4 == 8388613) {
                            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i5 : -i5);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i4);
                        }
                    }
                    return createTranslationYAnimator(view2, 0.0f, -i5);
                }
                return createTranslationYAnimator(view2, 0.0f, i5);
            }
            return createTranslationXAnimator(view2, 0.0f, i5);
        }
        return createTranslationXAnimator(view2, 0.0f, -i5);
    }

    private static Animator createTranslationXAnimator(View view, float f4, float f5) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f4, f5));
    }

    private static Animator createTranslationYAnimator(View view, float f4, float f5) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f4, f5));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i4 = this.slideDistance;
        return i4 != -1 ? i4 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i4) {
        if (i4 >= 0) {
            this.slideDistance = i4;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i4) {
        this.slideEdge = i4;
    }
}
