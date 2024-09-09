package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV2SportsDescriptionBindingImpl extends AcV2SportsDescriptionBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback30;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{3}, new int[]{2131427995});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232694, 4);
    }

    public AcV2SportsDescriptionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleLayout(NewPubTitleBinding TitleLayout, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        SportsDescriptionActivity sportsDescriptionActivity = this.mMActivity;
        if (sportsDescriptionActivity != null) {
            sportsDescriptionActivity.N();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Boolean bool = this.mStartButtonEnable;
        Boolean bool2 = this.mShowBottom;
        SportsDescriptionActivity sportsDescriptionActivity = this.mMActivity;
        int i4 = 0;
        boolean safeUnbox = (j4 & 18) != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j5 = j4 & 20;
        if (j5 != 0) {
            boolean safeUnbox2 = ViewDataBinding.safeUnbox(bool2);
            if (j5 != 0) {
                j4 |= safeUnbox2 ? 64L : 32L;
            }
            if (!safeUnbox2) {
                i4 = 8;
            }
        }
        long j6 = 24 & j4;
        if ((20 & j4) != 0) {
            this.btStart.setVisibility(i4);
            this.cbIgnore.setVisibility(i4);
        }
        if ((16 & j4) != 0) {
            this.btStart.setOnClickListener(this.mCallback30);
            this.titleLayout.setTitle("\u953b\u70bc\u8bf4\u660e");
        }
        if ((j4 & 18) != 0) {
            this.btStart.setEnabled(safeUnbox);
        }
        if (j6 != 0) {
            this.titleLayout.setActivity(sportsDescriptionActivity);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.titleLayout.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((NewPubTitleBinding) object, fieldId);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setMActivity(@Nullable SportsDescriptionActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setShowBottom(@Nullable Boolean ShowBottom) {
        this.mShowBottom = ShowBottom;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV2SportsDescriptionBinding
    public void setStartButtonEnable(@Nullable Boolean StartButtonEnable) {
        this.mStartButtonEnable = StartButtonEnable;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (26 == variableId) {
            setStartButtonEnable((Boolean) variable);
        } else if (23 == variableId) {
            setShowBottom((Boolean) variable);
        } else if (15 != variableId) {
            return false;
        } else {
            setMActivity((SportsDescriptionActivity) variable);
        }
        return true;
    }

    private AcV2SportsDescriptionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[2], (CheckBox) bindings[1], (SmartWebView) bindings[4], (NewPubTitleBinding) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btStart.setTag(null);
        this.cbIgnore.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        setRootTag(root);
        this.mCallback30 = new a(this, 1);
        invalidateAll();
    }
}
