package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.run.app.exam.QuestionActivity;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcRunQuestionBinding extends ViewDataBinding {
    @NonNull
    public final PubTitleBinding layoutTitle;
    @Bindable
    protected QuestionActivity mActivity;
    @Bindable
    protected List<Map<String, Object>> mAnswer;
    @Bindable
    protected Integer mCheckedId;
    @Bindable
    protected Map<String, Object> mData;
    @Bindable
    protected Boolean mIsShowRightAnswer;
    @NonNull
    public final RadioGroup rgAnswer;
    @NonNull
    public final Button tbCommit;
    @NonNull
    public final TextView tvIndex;
    @NonNull
    public final TextView tvQuestion;
    @NonNull
    public final TextView tvRightAnswer;
    @NonNull
    public final TextView tvScore;
    @NonNull
    public final TextView tvType;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcRunQuestionBinding(Object _bindingComponent, View _root, int _localFieldCount, PubTitleBinding layoutTitle, RadioGroup rgAnswer, Button tbCommit, TextView tvIndex, TextView tvQuestion, TextView tvRightAnswer, TextView tvScore, TextView tvType) {
        super(_bindingComponent, _root, _localFieldCount);
        this.layoutTitle = layoutTitle;
        this.rgAnswer = rgAnswer;
        this.tbCommit = tbCommit;
        this.tvIndex = tvIndex;
        this.tvQuestion = tvQuestion;
        this.tvRightAnswer = tvRightAnswer;
        this.tvScore = tvScore;
        this.tvType = tvType;
    }

    public static AcRunQuestionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public QuestionActivity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public List<Map<String, Object>> getAnswer() {
        return this.mAnswer;
    }

    @Nullable
    public Integer getCheckedId() {
        return this.mCheckedId;
    }

    @Nullable
    public Map<String, Object> getData() {
        return this.mData;
    }

    @Nullable
    public Boolean getIsShowRightAnswer() {
        return this.mIsShowRightAnswer;
    }

    public abstract void setActivity(@Nullable QuestionActivity activity);

    public abstract void setAnswer(@Nullable List<Map<String, Object>> answer);

    public abstract void setCheckedId(@Nullable Integer checkedId);

    public abstract void setData(@Nullable Map<String, Object> data);

    public abstract void setIsShowRightAnswer(@Nullable Boolean isShowRightAnswer);

    @Deprecated
    public static AcRunQuestionBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcRunQuestionBinding) ViewDataBinding.bind(component, view, 2131427476);
    }

    @NonNull
    @Deprecated
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcRunQuestionBinding) ViewDataBinding.inflateInternal(inflater, 2131427476, root, attachToRoot, component);
    }

    @NonNull
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcRunQuestionBinding) ViewDataBinding.inflateInternal(inflater, 2131427476, null, false, component);
    }
}
