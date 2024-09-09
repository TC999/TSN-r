package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class FocusStrategy {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t3, Rect rect);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface CollectionAdapter<T, V> {
        V get(T t3, int i4);

        int size(T t3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        SequentialComparator(boolean z3, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z3;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t3, T t4) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t3, rect);
            this.mAdapter.obtainBounds(t4, rect2);
            int i4 = rect.top;
            int i5 = rect2.top;
            if (i4 < i5) {
                return -1;
            }
            if (i4 > i5) {
                return 1;
            }
            int i6 = rect.left;
            int i7 = rect2.left;
            if (i6 < i7) {
                return this.mIsLayoutRtl ? 1 : -1;
            } else if (i6 > i7) {
                return this.mIsLayoutRtl ? -1 : 1;
            } else {
                int i8 = rect.bottom;
                int i9 = rect2.bottom;
                if (i8 < i9) {
                    return -1;
                }
                if (i8 > i9) {
                    return 1;
                }
                int i10 = rect.right;
                int i11 = rect2.right;
                if (i10 < i11) {
                    return this.mIsLayoutRtl ? 1 : -1;
                } else if (i10 > i11) {
                    return this.mIsLayoutRtl ? -1 : 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i4, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i4, rect, rect2);
        if (beamsOverlap(i4, rect, rect3) || !beamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i4, rect, rect3) || i4 == 17 || i4 == 66 || majorAxisDistance(i4, rect, rect2) < majorAxisDistanceToFarEdge(i4, rect, rect3);
    }

    private static boolean beamsOverlap(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l4, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, @NonNull Rect rect, int i4) {
        Rect rect2 = new Rect(rect);
        if (i4 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i4 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i4 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i4 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t4 = null;
        int size = collectionAdapter.size(l4);
        Rect rect3 = new Rect();
        for (int i5 = 0; i5 < size; i5++) {
            T t5 = collectionAdapter.get(l4, i5);
            if (t5 != t3) {
                boundsAdapter.obtainBounds(t5, rect3);
                if (isBetterCandidate(i4, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t4 = t5;
                }
            }
        }
        return t4;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l4, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, int i4, boolean z3, boolean z4) {
        int size = collectionAdapter.size(l4);
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(collectionAdapter.get(l4, i5));
        }
        Collections.sort(arrayList, new SequentialComparator(z3, boundsAdapter));
        if (i4 != 1) {
            if (i4 == 2) {
                return (T) getNextFocusable(t3, arrayList, z4);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return (T) getPreviousFocusable(t3, arrayList, z4);
    }

    private static <T> T getNextFocusable(T t3, ArrayList<T> arrayList, boolean z3) {
        int size = arrayList.size();
        int lastIndexOf = (t3 == null ? -1 : arrayList.lastIndexOf(t3)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z3 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t3, ArrayList<T> arrayList, boolean z3) {
        int size = arrayList.size();
        int indexOf = (t3 == null ? size : arrayList.indexOf(t3)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z3 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i4, int i5) {
        return (i4 * 13 * i4) + (i5 * i5);
    }

    private static boolean isBetterCandidate(int i4, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (isCandidate(rect, rect2, i4)) {
            if (isCandidate(rect, rect3, i4) && !beamBeats(i4, rect, rect2, rect3)) {
                return !beamBeats(i4, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i4, rect, rect2), minorAxisDistance(i4, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i4, rect, rect3), minorAxisDistance(i4, rect, rect3));
            }
            return true;
        }
        return false;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i4) {
        if (i4 == 17) {
            int i5 = rect.right;
            int i6 = rect2.right;
            return (i5 > i6 || rect.left >= i6) && rect.left > rect2.left;
        } else if (i4 == 33) {
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            return (i7 > i8 || rect.top >= i8) && rect.top > rect2.top;
        } else if (i4 == 66) {
            int i9 = rect.left;
            int i10 = rect2.left;
            return (i9 < i10 || rect.right <= i10) && rect.right < rect2.right;
        } else if (i4 == 130) {
            int i11 = rect.top;
            int i12 = rect2.top;
            return (i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean isToDirectionOf(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i4 == 17) {
            return rect.left >= rect2.right;
        } else if (i4 == 33) {
            return rect.top >= rect2.bottom;
        } else if (i4 == 66) {
            return rect.right <= rect2.left;
        } else if (i4 == 130) {
            return rect.bottom <= rect2.top;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int majorAxisDistance(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i4, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i4 == 17) {
            i5 = rect.left;
            i6 = rect2.right;
        } else if (i4 == 33) {
            i5 = rect.top;
            i6 = rect2.bottom;
        } else if (i4 == 66) {
            i5 = rect2.left;
            i6 = rect.right;
        } else if (i4 == 130) {
            i5 = rect2.top;
            i6 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i5 - i6;
    }

    private static int majorAxisDistanceToFarEdge(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i4, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i4 == 17) {
            i5 = rect.left;
            i6 = rect2.left;
        } else if (i4 == 33) {
            i5 = rect.top;
            i6 = rect2.top;
        } else if (i4 == 66) {
            i5 = rect2.right;
            i6 = rect.right;
        } else if (i4 == 130) {
            i5 = rect2.bottom;
            i6 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i5 - i6;
    }

    private static int minorAxisDistance(int i4, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
