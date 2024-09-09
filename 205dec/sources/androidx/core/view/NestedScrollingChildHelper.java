package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8, @Nullable int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i9;
        int i10;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i8)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            i9 = iArr[0];
            i10 = iArr[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr2 == null) {
            int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
            tempNestedScrollConsumed[0] = 0;
            tempNestedScrollConsumed[1] = 0;
            iArr3 = tempNestedScrollConsumed;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i4, i5, i6, i7, i8, iArr3);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i9;
            iArr[1] = iArr[1] - i10;
        }
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return null;
            }
            return this.mNestedScrollingParentNonTouch;
        }
        return this.mNestedScrollingParentTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i4, ViewParent viewParent) {
        if (i4 == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else if (i4 != 1) {
        } else {
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f4, f5, z3);
    }

    public boolean dispatchNestedPreFling(float f4, float f5) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f4, f5);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i4, i5, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z3) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z3;
    }

    public boolean startNestedScroll(int i4) {
        return startNestedScroll(i4, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6) {
        ViewParent nestedScrollingParentForType;
        int i7;
        int i8;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i8 = iArr2[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i4, i5, iArr, i6);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i8;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8) {
        return dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, i8, null);
    }

    public boolean hasNestedScrollingParent(int i4) {
        return getNestedScrollingParentForType(i4) != null;
    }

    public boolean startNestedScroll(int i4, int i5) {
        if (hasNestedScrollingParent(i5)) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i4, i5)) {
                    setNestedScrollingParentForType(i5, parent);
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i4, i5);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void stopNestedScroll(int i4) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i4);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i4);
            setNestedScrollingParentForType(i4, null);
        }
    }

    public void dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, i8, iArr2);
    }
}
