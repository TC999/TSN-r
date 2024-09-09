package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FmV3RecordListTotalBindingImpl extends FmV3RecordListTotalBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232721, 1);
        sparseIntArray.put(2131231061, 2);
        sparseIntArray.put(2131230720, 3);
        sparseIntArray.put(2131231067, 4);
        sparseIntArray.put(2131232942, 5);
        sparseIntArray.put(2131232941, 6);
        sparseIntArray.put(2131232945, 7);
        sparseIntArray.put(2131232158, 8);
        sparseIntArray.put(2131232928, 9);
        sparseIntArray.put(2131232927, 10);
        sparseIntArray.put(2131232929, 11);
        sparseIntArray.put(2131232860, 12);
        sparseIntArray.put(2131232859, 13);
        sparseIntArray.put(2131232861, 14);
        sparseIntArray.put(2131232136, 15);
        sparseIntArray.put(2131232157, 16);
        sparseIntArray.put(2131232857, 17);
        sparseIntArray.put(2131232856, 18);
        sparseIntArray.put(2131232858, 19);
        sparseIntArray.put(2131232871, 20);
        sparseIntArray.put(2131232870, 21);
        sparseIntArray.put(2131232872, 22);
        sparseIntArray.put(2131232135, 23);
        sparseIntArray.put(2131232159, 24);
        sparseIntArray.put(2131232916, 25);
        sparseIntArray.put(2131232914, 26);
        sparseIntArray.put(2131232919, 27);
        sparseIntArray.put(2131233200, 28);
        sparseIntArray.put(2131233198, 29);
        sparseIntArray.put(2131233203, 30);
        sparseIntArray.put(2131232134, 31);
        sparseIntArray.put(2131232160, 32);
        sparseIntArray.put(2131232986, 33);
        sparseIntArray.put(2131232985, 34);
        sparseIntArray.put(2131232987, 35);
        sparseIntArray.put(2131233064, 36);
        sparseIntArray.put(2131233062, 37);
        sparseIntArray.put(2131233067, 38);
        sparseIntArray.put(2131232138, 39);
        sparseIntArray.put(2131233178, 40);
        sparseIntArray.put(2131233170, 41);
        sparseIntArray.put(2131233184, 42);
        sparseIntArray.put(2131233175, 43);
        sparseIntArray.put(2131233174, 44);
        sparseIntArray.put(2131233176, 45);
    }

    public FmV3RecordListTotalBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 46, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        return true;
    }

    private FmV3RecordListTotalBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AAChartView) bindings[3], (MaterialCardView) bindings[2], (MaterialCardView) bindings[4], (View) bindings[31], (View) bindings[23], (View) bindings[15], (View) bindings[39], (LinearLayout) bindings[16], (LinearLayout) bindings[8], (LinearLayout) bindings[24], (LinearLayout) bindings[32], (TabLayout) bindings[1], (TextView) bindings[18], (TextView) bindings[17], (TextView) bindings[19], (TextView) bindings[13], (TextView) bindings[12], (TextView) bindings[14], (TextView) bindings[21], (TextView) bindings[20], (TextView) bindings[22], (TextView) bindings[26], (TextView) bindings[25], (TextView) bindings[27], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[11], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[7], (TextView) bindings[34], (TextView) bindings[33], (TextView) bindings[35], (TextView) bindings[37], (TextView) bindings[36], (TextView) bindings[38], (TextView) bindings[41], (TextView) bindings[44], (TextView) bindings[43], (TextView) bindings[45], (TextView) bindings[40], (TextView) bindings[42], (TextView) bindings[29], (TextView) bindings[28], (TextView) bindings[30]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
