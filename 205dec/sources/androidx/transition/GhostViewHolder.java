package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;
    @NonNull
    private ViewGroup mParent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i4 = 0;
        while (i4 <= childCount) {
            int i5 = (i4 + childCount) / 2;
            getParents(((GhostViewPort) getChildAt(i5)).mView, arrayList2);
            if (isOnTop(arrayList, arrayList2)) {
                i4 = i5 + 1;
            } else {
                childCount = i5 - 1;
            }
            arrayList2.clear();
        }
        return i4;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i4 = 1; i4 < min; i4++) {
            View view = arrayList.get(i4);
            View view2 = arrayList2.get(i4);
            if (view != view2) {
                return isOnTop(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<>();
        getParents(ghostViewPort.mView, arrayList);
        int insertIndex = getInsertIndex(arrayList);
        if (insertIndex >= 0 && insertIndex < getChildCount()) {
            addView(ghostViewPort, insertIndex);
        } else {
            addView(ghostViewPort);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.mAttached) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.mParent.setTag(R.id.ghost_view_holder, null);
            ViewGroupUtils.getOverlay(this.mParent).remove(this);
            this.mAttached = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popToOverlayTop() {
        if (this.mAttached) {
            ViewGroupUtils.getOverlay(this.mParent).remove(this);
            ViewGroupUtils.getOverlay(this.mParent).add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    private static boolean isOnTop(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i4));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }
}
