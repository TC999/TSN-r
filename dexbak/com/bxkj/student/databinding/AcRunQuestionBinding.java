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
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.exam.QuestionActivity;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        return (AcRunQuestionBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_run_question);
    }

    @NonNull
    @Deprecated
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcRunQuestionBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_run_question, root, attachToRoot, component);
    }

    @NonNull
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcRunQuestionBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcRunQuestionBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_run_question, null, false, component);
    }
}
