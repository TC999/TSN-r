package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i4 = snake.f156x - snake2.f156x;
            return i4 == 0 ? snake.f157y - snake2.f157y : i4;
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i4, int i5);

        public abstract boolean areItemsTheSame(int i4, int i5);

        @Nullable
        public Object getChangePayload(int i4, int i5) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z3) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z3;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.f156x == 0 && snake.f157y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f156x = 0;
            snake2.f157y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i4, int i5, int i6) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i4, i5);
                return;
            }
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                int[] iArr = this.mNewItemStatuses;
                int i8 = i6 + i7;
                int i9 = iArr[i8] & 31;
                if (i9 == 0) {
                    listUpdateCallback.onInserted(i4, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos++;
                    }
                } else if (i9 == 4 || i9 == 8) {
                    int i10 = iArr[i8] >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i10, true).currentPos, i4);
                    if (i9 == 4) {
                        listUpdateCallback.onChanged(i4, 1, this.mCallback.getChangePayload(i10, i8));
                    }
                } else if (i9 == 16) {
                    list.add(new PostponedUpdate(i8, i4, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i8 + " " + Long.toBinaryString(i9));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i4, int i5, int i6) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i4, i5);
                return;
            }
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                int[] iArr = this.mOldItemStatuses;
                int i8 = i6 + i7;
                int i9 = iArr[i8] & 31;
                if (i9 == 0) {
                    listUpdateCallback.onRemoved(i4 + i7, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos--;
                    }
                } else if (i9 == 4 || i9 == 8) {
                    int i10 = iArr[i8] >> 5;
                    PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i10, false);
                    listUpdateCallback.onMoved(i4 + i7, removePostponedUpdate.currentPos - 1);
                    if (i9 == 4) {
                        listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i8, i10));
                    }
                } else if (i9 == 16) {
                    list.add(new PostponedUpdate(i8, i4 + i7, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i8 + " " + Long.toBinaryString(i9));
                }
            }
        }

        private void findAddition(int i4, int i5, int i6) {
            if (this.mOldItemStatuses[i4 - 1] != 0) {
                return;
            }
            findMatchingItem(i4, i5, i6, false);
        }

        private boolean findMatchingItem(int i4, int i5, int i6, boolean z3) {
            int i7;
            int i8;
            int i9;
            if (z3) {
                i5--;
                i8 = i4;
                i7 = i5;
            } else {
                i7 = i4 - 1;
                i8 = i7;
            }
            while (i6 >= 0) {
                Snake snake = this.mSnakes.get(i6);
                int i10 = snake.f156x;
                int i11 = snake.size;
                int i12 = i10 + i11;
                int i13 = snake.f157y + i11;
                if (z3) {
                    for (int i14 = i8 - 1; i14 >= i12; i14--) {
                        if (this.mCallback.areItemsTheSame(i14, i7)) {
                            i9 = this.mCallback.areContentsTheSame(i14, i7) ? 8 : 4;
                            this.mNewItemStatuses[i7] = (i14 << 5) | 16;
                            this.mOldItemStatuses[i14] = (i7 << 5) | i9;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i15 = i5 - 1; i15 >= i13; i15--) {
                        if (this.mCallback.areItemsTheSame(i7, i15)) {
                            i9 = this.mCallback.areContentsTheSame(i7, i15) ? 8 : 4;
                            int i16 = i4 - 1;
                            this.mOldItemStatuses[i16] = (i15 << 5) | 16;
                            this.mNewItemStatuses[i15] = (i16 << 5) | i9;
                            return true;
                        }
                    }
                    continue;
                }
                i8 = snake.f156x;
                i5 = snake.f157y;
                i6--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i4 = this.mOldListSize;
            int i5 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i6 = snake.f156x;
                int i7 = snake.size;
                int i8 = i6 + i7;
                int i9 = snake.f157y + i7;
                if (this.mDetectMoves) {
                    while (i4 > i8) {
                        findAddition(i4, i5, size);
                        i4--;
                    }
                    while (i5 > i9) {
                        findRemoval(i4, i5, size);
                        i5--;
                    }
                }
                for (int i10 = 0; i10 < snake.size; i10++) {
                    int i11 = snake.f156x + i10;
                    int i12 = snake.f157y + i10;
                    int i13 = this.mCallback.areContentsTheSame(i11, i12) ? 1 : 2;
                    this.mOldItemStatuses[i11] = (i12 << 5) | i13;
                    this.mNewItemStatuses[i12] = (i11 << 5) | i13;
                }
                i4 = snake.f156x;
                i5 = snake.f157y;
            }
        }

        private void findRemoval(int i4, int i5, int i6) {
            if (this.mNewItemStatuses[i5 - 1] != 0) {
                return;
            }
            findMatchingItem(i4, i5, i6, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i4, boolean z3) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i4 && postponedUpdate.removal == z3) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z3 ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i4) {
            if (i4 >= 0 && i4 < this.mNewListSize) {
                int i5 = this.mNewItemStatuses[i4];
                if ((i5 & 31) == 0) {
                    return -1;
                }
                return i5 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i4 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i4) {
            if (i4 >= 0 && i4 < this.mOldListSize) {
                int i5 = this.mOldItemStatuses[i4];
                if ((i5 & 31) == 0) {
                    return -1;
                }
                return i5 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i4 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i4 = this.mOldListSize;
            int i5 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i6 = snake.size;
                int i7 = snake.f156x + i6;
                int i8 = snake.f157y + i6;
                if (i7 < i4) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i7, i4 - i7, i7);
                }
                if (i8 < i5) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i7, i5 - i8, i8);
                }
                for (int i9 = i6 - 1; i9 >= 0; i9--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i10 = snake.f156x;
                    if ((iArr[i10 + i9] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i10 + i9, 1, this.mCallback.getChangePayload(i10 + i9, snake.f157y + i9));
                    }
                }
                i4 = snake.f156x;
                i5 = snake.f157y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t3, @NonNull T t4);

        public abstract boolean areItemsTheSame(@NonNull T t3, @NonNull T t4);

        @Nullable
        public Object getChangePayload(@NonNull T t3, @NonNull T t4) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i4, int i5, boolean z3) {
            this.posInOwnerList = i4;
            this.currentPos = i5;
            this.removal = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i4, int i5, int i6, int i7) {
            this.oldListStart = i4;
            this.oldListEnd = i5;
            this.newListStart = i6;
            this.newListEnd = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* renamed from: x  reason: collision with root package name */
        int f156x;

        /* renamed from: y  reason: collision with root package name */
        int f157y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r24[r13 - 1] < r24[r13 + r5]) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
        if (r25[r12 - 1] < r25[r12 + 1]) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1 A[LOOP:4: B:52:0x00cd->B:56:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec A[EDGE_INSN: B:89:0x00ec->B:58:0x00ec ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake diffPartial(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.diffPartial(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z3) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i4 = abs * 2;
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.f156x += range.oldListStart;
                diffPartial.f157y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.f156x;
                    range2.newListEnd = diffPartial.f157y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.f156x - 1;
                    range2.newListEnd = diffPartial.f157y;
                } else {
                    range2.oldListEnd = diffPartial.f156x;
                    range2.newListEnd = diffPartial.f157y - 1;
                }
                arrayList2.add(range2);
                if (diffPartial.reverse) {
                    if (diffPartial.removal) {
                        int i5 = diffPartial.f156x;
                        int i6 = diffPartial.size;
                        range.oldListStart = i5 + i6 + 1;
                        range.newListStart = diffPartial.f157y + i6;
                    } else {
                        int i7 = diffPartial.f156x;
                        int i8 = diffPartial.size;
                        range.oldListStart = i7 + i8;
                        range.newListStart = diffPartial.f157y + i8 + 1;
                    }
                } else {
                    int i9 = diffPartial.f156x;
                    int i10 = diffPartial.size;
                    range.oldListStart = i9 + i10;
                    range.newListStart = diffPartial.f157y + i10;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z3);
    }
}
