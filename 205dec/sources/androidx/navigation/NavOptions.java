package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavOptions {
    @AnimRes
    @AnimatorRes
    private int mEnterAnim;
    @AnimRes
    @AnimatorRes
    private int mExitAnim;
    @AnimRes
    @AnimatorRes
    private int mPopEnterAnim;
    @AnimRes
    @AnimatorRes
    private int mPopExitAnim;
    @IdRes
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class Builder {
        boolean mPopUpToInclusive;
        boolean mSingleTop;
        @IdRes
        int mPopUpTo = -1;
        @AnimRes
        @AnimatorRes
        int mEnterAnim = -1;
        @AnimRes
        @AnimatorRes
        int mExitAnim = -1;
        @AnimRes
        @AnimatorRes
        int mPopEnterAnim = -1;
        @AnimRes
        @AnimatorRes
        int mPopExitAnim = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i4) {
            this.mEnterAnim = i4;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i4) {
            this.mExitAnim = i4;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z3) {
            this.mSingleTop = z3;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i4) {
            this.mPopEnterAnim = i4;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i4) {
            this.mPopExitAnim = i4;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i4, boolean z3) {
            this.mPopUpTo = i4;
            this.mPopUpToInclusive = z3;
            return this;
        }
    }

    NavOptions(boolean z3, @IdRes int i4, boolean z4, @AnimRes @AnimatorRes int i5, @AnimRes @AnimatorRes int i6, @AnimRes @AnimatorRes int i7, @AnimRes @AnimatorRes int i8) {
        this.mSingleTop = z3;
        this.mPopUpTo = i4;
        this.mPopUpToInclusive = z4;
        this.mEnterAnim = i5;
        this.mExitAnim = i6;
        this.mPopEnterAnim = i7;
        this.mPopExitAnim = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavOptions.class != obj.getClass()) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        return this.mSingleTop == navOptions.mSingleTop && this.mPopUpTo == navOptions.mPopUpTo && this.mPopUpToInclusive == navOptions.mPopUpToInclusive && this.mEnterAnim == navOptions.mEnterAnim && this.mExitAnim == navOptions.mExitAnim && this.mPopEnterAnim == navOptions.mPopEnterAnim && this.mPopExitAnim == navOptions.mPopExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.mExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    @IdRes
    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public int hashCode() {
        return ((((((((((((shouldLaunchSingleTop() ? 1 : 0) * 31) + getPopUpTo()) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + getEnterAnim()) * 31) + getExitAnim()) * 31) + getPopEnterAnim()) * 31) + getPopExitAnim();
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }
}
