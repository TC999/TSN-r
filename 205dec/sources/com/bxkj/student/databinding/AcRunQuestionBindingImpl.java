package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.app.exam.QuestionActivity;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcRunQuestionBindingImpl extends AcRunQuestionBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback8;
    private long mDirtyFlags;
    @NonNull
    private final RelativeLayout mboundView0;
    @NonNull
    private final ScrollView mboundView1;
    @NonNull
    private final RadioButton mboundView3;
    @NonNull
    private final RadioButton mboundView4;
    @NonNull
    private final RadioButton mboundView5;
    @NonNull
    private final RadioButton mboundView6;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"pub_title"}, new int[]{9}, new int[]{2131428029});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233211, 10);
        sparseIntArray.put(2131233146, 11);
        sparseIntArray.put(2131233112, 12);
        sparseIntArray.put(2131232490, 13);
    }

    public AcRunQuestionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private boolean onChangeLayoutTitle(PubTitleBinding LayoutTitle, int fieldId) {
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
        QuestionActivity questionActivity = this.mActivity;
        if (questionActivity != null) {
            questionActivity.N();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        int i4;
        CharSequence charSequence;
        long j5;
        String str;
        String str2;
        String str3;
        String str4;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map5 = this.mData;
        List<Map<String, Object>> list = this.mAnswer;
        QuestionActivity questionActivity = this.mActivity;
        long j6 = j4 & 72;
        if (j6 != 0) {
            charSequence = map5 != null ? map5.get("questionName") : null;
            boolean z3 = map5 == null;
            if (j6 != 0) {
                j4 |= z3 ? 256L : 128L;
            }
            i4 = z3 ? 8 : 0;
        } else {
            i4 = 0;
            charSequence = null;
        }
        long j7 = 80 & j4;
        if (j7 != 0) {
            if (list != null) {
                map4 = (Map) ViewDataBinding.getFromList(list, 3);
                map2 = (Map) ViewDataBinding.getFromList(list, 2);
                map3 = (Map) ViewDataBinding.getFromList(list, 1);
                map = (Map) ViewDataBinding.getFromList(list, 0);
            } else {
                map = null;
                map2 = null;
                map3 = null;
                map4 = null;
            }
            if (map4 != null) {
                obj = map4.get("answerOption");
                obj2 = map4.get(DomainCampaignEx.ROVER_KEY_MARK);
            } else {
                obj = null;
                obj2 = null;
            }
            if (map2 != null) {
                obj4 = map2.get(DomainCampaignEx.ROVER_KEY_MARK);
                obj3 = map2.get("answerOption");
            } else {
                obj3 = null;
                obj4 = null;
            }
            if (map3 != null) {
                obj5 = map3.get("answerOption");
                obj6 = map3.get(DomainCampaignEx.ROVER_KEY_MARK);
            } else {
                obj5 = null;
                obj6 = null;
            }
            if (map != null) {
                Object obj9 = map.get(DomainCampaignEx.ROVER_KEY_MARK);
                obj8 = map.get("answerOption");
                j5 = j7;
                obj7 = obj9;
            } else {
                j5 = j7;
                obj7 = null;
                obj8 = null;
            }
            String str5 = obj4 + ".";
            str = str5 + obj3;
            str2 = (obj6 + ".") + obj5;
            str4 = (obj7 + ".") + obj8;
            str3 = (obj2 + ".") + obj;
        } else {
            j5 = j7;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if ((96 & j4) != 0) {
            this.layoutTitle.setActivity(questionActivity);
        }
        if ((64 & j4) != 0) {
            this.layoutTitle.setTitle("\u8dd1\u6b65\u7b54\u9898");
            this.tbCommit.setOnClickListener(this.mCallback8);
        }
        if ((j4 & 72) != 0) {
            this.mboundView1.setVisibility(i4);
            this.tbCommit.setVisibility(i4);
            CharSequence charSequence2 = charSequence;
            TextViewBindingAdapter.setText(this.tvIndex, charSequence2);
            TextViewBindingAdapter.setText(this.tvRightAnswer, charSequence2);
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str4);
            TextViewBindingAdapter.setText(this.mboundView4, str2);
            TextViewBindingAdapter.setText(this.mboundView5, str);
            TextViewBindingAdapter.setText(this.mboundView6, str3);
        }
        ViewDataBinding.executeBindingsOn(this.layoutTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.layoutTitle.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
        }
        this.layoutTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeLayoutTitle((PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setActivity(@Nullable QuestionActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setAnswer(@Nullable List<Map<String, Object>> Answer) {
        this.mAnswer = Answer;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setCheckedId(@Nullable Integer CheckedId) {
        this.mCheckedId = CheckedId;
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setData(@Nullable Map<String, Object> Data) {
        this.mData = Data;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcRunQuestionBinding
    public void setIsShowRightAnswer(@Nullable Boolean IsShowRightAnswer) {
        this.mIsShowRightAnswer = IsShowRightAnswer;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.layoutTitle.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (4 == variableId) {
            setCheckedId((Integer) variable);
            return true;
        } else if (11 == variableId) {
            setIsShowRightAnswer((Boolean) variable);
            return true;
        } else if (6 == variableId) {
            setData((Map) variable);
            return true;
        } else if (2 == variableId) {
            setAnswer((List) variable);
            return true;
        } else if (1 == variableId) {
            setActivity((QuestionActivity) variable);
            return true;
        } else {
            return false;
        }
    }

    private AcRunQuestionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (PubTitleBinding) bindings[9], (RadioGroup) bindings[13], (Button) bindings[8], (TextView) bindings[2], (TextView) bindings[12], (TextView) bindings[7], (TextView) bindings[11], (TextView) bindings[10]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.layoutTitle);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        ScrollView scrollView = (ScrollView) bindings[1];
        this.mboundView1 = scrollView;
        scrollView.setTag(null);
        RadioButton radioButton = (RadioButton) bindings[3];
        this.mboundView3 = radioButton;
        radioButton.setTag(null);
        RadioButton radioButton2 = (RadioButton) bindings[4];
        this.mboundView4 = radioButton2;
        radioButton2.setTag(null);
        RadioButton radioButton3 = (RadioButton) bindings[5];
        this.mboundView5 = radioButton3;
        radioButton3.setTag(null);
        RadioButton radioButton4 = (RadioButton) bindings[6];
        this.mboundView6 = radioButton4;
        radioButton4.setTag(null);
        this.tbCommit.setTag(null);
        this.tvIndex.setTag(null);
        this.tvRightAnswer.setTag(null);
        setRootTag(root);
        this.mCallback8 = new a(this, 1);
        invalidateAll();
    }
}
