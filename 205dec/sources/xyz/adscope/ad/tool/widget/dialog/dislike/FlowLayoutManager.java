package xyz.adscope.ad.tool.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = "FlowLayoutManager";
    public int height;
    private int left;
    private int right;

    /* renamed from: top  reason: collision with root package name */
    private int f64544top;
    private int usedMaxWidth;
    public int width;
    public final FlowLayoutManager self = this;
    private int verticalScrollOffset = 0;
    public int totalHeight = 0;
    private Row row = new Row();
    private List<Row> lineRows = new ArrayList();
    private SparseArray<Rect> allItemFrames = new SparseArray<>();

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class Item {
        public Rect rect;
        public int useHeight;
        public View view;

        public Item(int i4, View view, Rect rect) {
            this.useHeight = i4;
            this.view = view;
            this.rect = rect;
        }

        public void setRect(Rect rect) {
            this.rect = rect;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class Row {
        public float cuTop;
        public float maxHeight;
        public List<Item> views = new ArrayList();

        public Row() {
        }

        public void addViews(Item item) {
            this.views.add(item);
        }

        public void setCuTop(float f4) {
            this.cuTop = f4;
        }

        public void setMaxHeight(float f4) {
            this.maxHeight = f4;
        }
    }

    private void fillLayout(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.verticalScrollOffset, getWidth() - getPaddingRight(), this.verticalScrollOffset + (getHeight() - getPaddingBottom()));
        for (int i4 = 0; i4 < this.lineRows.size(); i4++) {
            Row row = this.lineRows.get(i4);
            float f4 = row.cuTop;
            List<Item> list = row.views;
            for (int i5 = 0; i5 < list.size(); i5++) {
                View view = list.get(i5).view;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i5).rect;
                int i6 = rect.left;
                int i7 = rect.top;
                int i8 = this.verticalScrollOffset;
                layoutDecoratedWithMargins(view, i6, i7 - i8, rect.right, rect.bottom - i8);
            }
        }
    }

    private void formatAboveRow() {
        List<Item> list = this.row.views;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Item item = list.get(i4);
            View view = item.view;
            int position = getPosition(view);
            Row row = this.row;
            if (this.allItemFrames.get(position).top < row.cuTop + ((row.maxHeight - list.get(i4).useHeight) / 2.0f)) {
                Rect rect = this.allItemFrames.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i5 = this.allItemFrames.get(position).left;
                Row row2 = this.row;
                int i6 = (int) (row2.cuTop + ((row2.maxHeight - list.get(i4).useHeight) / 2.0f));
                int i7 = this.allItemFrames.get(position).right;
                Row row3 = this.row;
                rect.set(i5, i6, i7, (int) (row3.cuTop + ((row3.maxHeight - list.get(i4).useHeight) / 2.0f) + getDecoratedMeasuredHeight(view)));
                this.allItemFrames.put(position, rect);
                item.setRect(rect);
                list.set(i4, item);
            }
        }
        Row row4 = this.row;
        row4.views = list;
        this.lineRows.add(row4);
        this.row = new Row();
    }

    private int getVerticalSpace() {
        return (this.self.getHeight() - this.self.getPaddingBottom()) - this.self.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getHorizontalSpace() {
        return (this.self.getWidth() - this.self.getPaddingLeft()) - this.self.getPaddingRight();
    }

    public int getRowCounts() {
        return this.lineRows.size();
    }

    public int getTotalHeight() {
        return this.totalHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.totalHeight = 0;
        int i4 = this.f64544top;
        this.row = new Row();
        this.lineRows.clear();
        this.allItemFrames.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.verticalScrollOffset = 0;
        } else if (getChildCount() != 0 || !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            if (getChildCount() == 0) {
                this.width = getWidth();
                this.height = getHeight();
                this.left = getPaddingLeft();
                this.right = getPaddingRight();
                this.f64544top = getPaddingTop();
                this.usedMaxWidth = (this.width - this.left) - this.right;
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < getItemCount(); i7++) {
                View viewForPosition = recycler.getViewForPosition(i7);
                if (8 != viewForPosition.getVisibility()) {
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                    int i8 = i5 + decoratedMeasuredWidth;
                    if (i8 <= this.usedMaxWidth) {
                        int i9 = this.left + i5;
                        Rect rect = this.allItemFrames.get(i7);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        rect.set(i9, i4, decoratedMeasuredWidth + i9, i4 + decoratedMeasuredHeight);
                        this.allItemFrames.put(i7, rect);
                        i6 = Math.max(i6, decoratedMeasuredHeight);
                        this.row.addViews(new Item(decoratedMeasuredHeight, viewForPosition, rect));
                        this.row.setCuTop(i4);
                        this.row.setMaxHeight(i6);
                        i5 = i8;
                    } else {
                        formatAboveRow();
                        i4 += i6;
                        this.totalHeight += i6;
                        int i10 = this.left;
                        Rect rect2 = this.allItemFrames.get(i7);
                        if (rect2 == null) {
                            rect2 = new Rect();
                        }
                        rect2.set(i10, i4, i10 + decoratedMeasuredWidth, i4 + decoratedMeasuredHeight);
                        this.allItemFrames.put(i7, rect2);
                        this.row.addViews(new Item(decoratedMeasuredHeight, viewForPosition, rect2));
                        this.row.setCuTop(i4);
                        this.row.setMaxHeight(decoratedMeasuredHeight);
                        i5 = decoratedMeasuredWidth;
                        i6 = decoratedMeasuredHeight;
                    }
                    if (i7 == getItemCount() - 1) {
                        formatAboveRow();
                        this.totalHeight += i6;
                    }
                }
            }
            this.totalHeight = Math.max(this.totalHeight, getVerticalSpace());
            fillLayout(recycler, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5 = this.verticalScrollOffset;
        int i6 = i5 + i4;
        if (i6 < 0) {
            i4 = -i5;
        } else if (i6 > this.totalHeight - getVerticalSpace()) {
            i4 = (this.totalHeight - getVerticalSpace()) - this.verticalScrollOffset;
        }
        this.verticalScrollOffset += i4;
        offsetChildrenVertical(-i4);
        fillLayout(recycler, state);
        return i4;
    }
}
