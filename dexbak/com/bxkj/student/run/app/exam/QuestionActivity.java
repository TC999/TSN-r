package com.bxkj.student.run.app.exam;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.databinding.AcRunQuestionBinding;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.Nullable;
import p653w.InterfaceC16236a;

/* compiled from: QuestionActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m12616d2 = {"Lcom/bxkj/student/run/app/exam/QuestionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "P", "Lkotlin/f1;", "O", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "N", "Lcom/bxkj/student/databinding/AcRunQuestionBinding;", "a", "Lcom/bxkj/student/databinding/AcRunQuestionBinding;", "mDataBinding", "Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "b", "Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "mViewModel", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class QuestionActivity extends AppCompatActivity {

    /* renamed from: a */
    private AcRunQuestionBinding f19092a;

    /* renamed from: b */
    private QuestionVieModel f19093b;

    /* compiled from: QuestionActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/run/app/exam/QuestionActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.run.app.exam.QuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5224a extends HttpCallBack {
        C5224a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list == null || list.size() <= 0) {
                return;
            }
            QuestionVieModel questionVieModel = QuestionActivity.this.f19093b;
            QuestionVieModel questionVieModel2 = null;
            if (questionVieModel == null) {
                C14342f0.m8200S("mViewModel");
                questionVieModel = null;
            }
            questionVieModel.m40058c().putAll(list.get(0));
            QuestionVieModel questionVieModel3 = QuestionActivity.this.f19093b;
            if (questionVieModel3 == null) {
                C14342f0.m8200S("mViewModel");
                questionVieModel3 = null;
            }
            questionVieModel3.m40060a().addAll(JsonParse.getList(list.get(0), "answers"));
            AcRunQuestionBinding acRunQuestionBinding = QuestionActivity.this.f19092a;
            if (acRunQuestionBinding == null) {
                C14342f0.m8200S("mDataBinding");
                acRunQuestionBinding = null;
            }
            QuestionVieModel questionVieModel4 = QuestionActivity.this.f19093b;
            if (questionVieModel4 == null) {
                C14342f0.m8200S("mViewModel");
                questionVieModel4 = null;
            }
            acRunQuestionBinding.setData(questionVieModel4.m40058c());
            AcRunQuestionBinding acRunQuestionBinding2 = QuestionActivity.this.f19092a;
            if (acRunQuestionBinding2 == null) {
                C14342f0.m8200S("mDataBinding");
                acRunQuestionBinding2 = null;
            }
            QuestionVieModel questionVieModel5 = QuestionActivity.this.f19093b;
            if (questionVieModel5 == null) {
                C14342f0.m8200S("mViewModel");
            } else {
                questionVieModel2 = questionVieModel5;
            }
            acRunQuestionBinding2.setAnswer(questionVieModel2.m40060a());
        }
    }

    static {
        StubApp.interface11(11912);
    }

    /* renamed from: O */
    private final void m40066O() {
        Http.with(this).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m106h1()).setDataListener(new C5224a());
    }

    /* renamed from: P */
    private final String m40065P() {
        QuestionVieModel questionVieModel = this.f19093b;
        if (questionVieModel == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel = null;
        }
        String str = "";
        for (Map<String, Object> map : questionVieModel.m40060a()) {
            if (JsonParse.getInt(map, "isRight") == 0) {
                str = C14342f0.m8216C("正确答案：", JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK));
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public static final void m40064Q(QuestionActivity this$0, RadioGroup radioGroup, int i) {
        C14342f0.m8184p(this$0, "this$0");
        QuestionVieModel questionVieModel = this$0.f19093b;
        AcRunQuestionBinding acRunQuestionBinding = null;
        if (questionVieModel == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel = null;
        }
        questionVieModel.m40056e(Integer.valueOf(i));
        AcRunQuestionBinding acRunQuestionBinding2 = this$0.f19092a;
        if (acRunQuestionBinding2 == null) {
            C14342f0.m8200S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding3 = this$0.f19092a;
        if (acRunQuestionBinding3 == null) {
            C14342f0.m8200S("mDataBinding");
            acRunQuestionBinding3 = null;
        }
        RadioGroup radioGroup3 = acRunQuestionBinding3.rgAnswer;
        QuestionVieModel questionVieModel2 = this$0.f19093b;
        if (questionVieModel2 == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel2 = null;
        }
        Integer m40059b = questionVieModel2.m40059b();
        C14342f0.m8187m(m40059b);
        int indexOfChild = radioGroup2.indexOfChild(radioGroup3.findViewById(m40059b.intValue()));
        QuestionVieModel questionVieModel3 = this$0.f19093b;
        if (questionVieModel3 == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel3 = null;
        }
        if (Integer.parseInt(String.valueOf(questionVieModel3.m40060a().get(indexOfChild).get("isRight"))) == 1) {
            AcRunQuestionBinding acRunQuestionBinding4 = this$0.f19092a;
            if (acRunQuestionBinding4 == null) {
                C14342f0.m8200S("mDataBinding");
                acRunQuestionBinding4 = null;
            }
            acRunQuestionBinding4.tvRightAnswer.setText(this$0.m40065P());
            AcRunQuestionBinding acRunQuestionBinding5 = this$0.f19092a;
            if (acRunQuestionBinding5 == null) {
                C14342f0.m8200S("mDataBinding");
            } else {
                acRunQuestionBinding = acRunQuestionBinding5;
            }
            acRunQuestionBinding.tvRightAnswer.setVisibility(0);
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding6 = this$0.f19092a;
        if (acRunQuestionBinding6 == null) {
            C14342f0.m8200S("mDataBinding");
        } else {
            acRunQuestionBinding = acRunQuestionBinding6;
        }
        acRunQuestionBinding.tvRightAnswer.setVisibility(8);
    }

    /* renamed from: N */
    public final void m40067N() {
        QuestionVieModel questionVieModel = this.f19093b;
        QuestionVieModel questionVieModel2 = null;
        if (questionVieModel == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel = null;
        }
        if (questionVieModel.m40059b() == null) {
            new iOSOneButtonDialog(this).setMessage("请选择答案").show();
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding = this.f19092a;
        if (acRunQuestionBinding == null) {
            C14342f0.m8200S("mDataBinding");
            acRunQuestionBinding = null;
        }
        RadioGroup radioGroup = acRunQuestionBinding.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding2 = this.f19092a;
        if (acRunQuestionBinding2 == null) {
            C14342f0.m8200S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        QuestionVieModel questionVieModel3 = this.f19093b;
        if (questionVieModel3 == null) {
            C14342f0.m8200S("mViewModel");
            questionVieModel3 = null;
        }
        Integer m40059b = questionVieModel3.m40059b();
        C14342f0.m8187m(m40059b);
        int indexOfChild = radioGroup.indexOfChild(radioGroup2.findViewById(m40059b.intValue()));
        C11792j.m20469d(C14342f0.m8216C("indexOfChild=", Integer.valueOf(indexOfChild)), new Object[0]);
        QuestionVieModel questionVieModel4 = this.f19093b;
        if (questionVieModel4 == null) {
            C14342f0.m8200S("mViewModel");
        } else {
            questionVieModel2 = questionVieModel4;
        }
        ObservableArrayList<Map<String, Object>> m40060a = questionVieModel2.m40060a();
        if (m40060a == null) {
            return;
        }
        if (Integer.parseInt(String.valueOf(m40060a.get(indexOfChild).get("isRight"))) == 1) {
            new iOSOneButtonDialog(this).setMessage("答案错误").show();
            return;
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);
}
