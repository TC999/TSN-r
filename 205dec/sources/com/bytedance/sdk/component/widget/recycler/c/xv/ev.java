package com.bytedance.sdk.component.widget.recycler.c.xv;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev {
    public static boolean c(ViewParent viewParent, View view, View view2, int i4, int i5) {
        if (viewParent instanceof f) {
            return ((f) viewParent).c(view, view2, i4, i5);
        }
        if (i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i4);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e4);
                    return false;
                }
            } else if (viewParent instanceof ux) {
                return ((ux) viewParent).onStartNestedScroll(view, view2, i4);
            } else {
                return false;
            }
        }
        return false;
    }

    public static void w(ViewParent viewParent, View view, View view2, int i4, int i5) {
        if (viewParent instanceof f) {
            ((f) viewParent).w(view, view2, i4, i5);
        } else if (i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i4);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e4);
                }
            } else if (viewParent instanceof ux) {
                ((ux) viewParent).onNestedScrollAccepted(view, view2, i4);
            }
        }
    }

    public static void c(ViewParent viewParent, View view, int i4) {
        if (viewParent instanceof f) {
            ((f) viewParent).c(view, i4);
        } else if (i4 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e4);
                }
            } else if (viewParent instanceof ux) {
                ((ux) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void c(ViewParent viewParent, View view, int i4, int i5, int i6, int i7, int i8) {
        if (viewParent instanceof f) {
            ((f) viewParent).c(view, i4, i5, i6, i7, i8);
        } else if (i8 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i4, i5, i6, i7);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e4);
                }
            } else if (viewParent instanceof ux) {
                ((ux) viewParent).onNestedScroll(view, i4, i5, i6, i7);
            }
        }
    }

    public static void c(ViewParent viewParent, View view, int i4, int i5, int[] iArr, int i6) {
        if (viewParent instanceof f) {
            ((f) viewParent).c(view, i4, i5, iArr, i6);
        } else if (i6 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i4, i5, iArr);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e4);
                }
            } else if (viewParent instanceof ux) {
                ((ux) viewParent).onNestedPreScroll(view, i4, i5, iArr);
            }
        }
    }

    public static boolean c(ViewParent viewParent, View view, float f4, float f5, boolean z3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f4, f5, z3);
            } catch (AbstractMethodError e4) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e4);
                return false;
            }
        } else if (viewParent instanceof ux) {
            return ((ux) viewParent).onNestedFling(view, f4, f5, z3);
        } else {
            return false;
        }
    }

    public static boolean c(ViewParent viewParent, View view, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f4, f5);
            } catch (AbstractMethodError e4) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e4);
                return false;
            }
        } else if (viewParent instanceof ux) {
            return ((ux) viewParent).onNestedPreFling(view, f4, f5);
        } else {
            return false;
        }
    }
}
