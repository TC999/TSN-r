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
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: QuestionActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/bxkj/student/run/app/exam/QuestionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "P", "Lkotlin/f1;", "O", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "N", "Lcom/bxkj/student/databinding/AcRunQuestionBinding;", "a", "Lcom/bxkj/student/databinding/AcRunQuestionBinding;", "mDataBinding", "Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "b", "Lcom/bxkj/student/run/app/exam/QuestionVieModel;", "mViewModel", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class QuestionActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private AcRunQuestionBinding f22338a;

    /* renamed from: b  reason: collision with root package name */
    private QuestionVieModel f22339b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: QuestionActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/run/app/exam/QuestionActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@Nullable Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list == null || list.size() <= 0) {
                return;
            }
            QuestionVieModel questionVieModel = QuestionActivity.this.f22339b;
            QuestionVieModel questionVieModel2 = null;
            if (questionVieModel == null) {
                f0.S("mViewModel");
                questionVieModel = null;
            }
            questionVieModel.c().putAll(list.get(0));
            QuestionVieModel questionVieModel3 = QuestionActivity.this.f22339b;
            if (questionVieModel3 == null) {
                f0.S("mViewModel");
                questionVieModel3 = null;
            }
            questionVieModel3.a().addAll(JsonParse.getList(list.get(0), "answers"));
            AcRunQuestionBinding acRunQuestionBinding = QuestionActivity.this.f22338a;
            if (acRunQuestionBinding == null) {
                f0.S("mDataBinding");
                acRunQuestionBinding = null;
            }
            QuestionVieModel questionVieModel4 = QuestionActivity.this.f22339b;
            if (questionVieModel4 == null) {
                f0.S("mViewModel");
                questionVieModel4 = null;
            }
            acRunQuestionBinding.setData(questionVieModel4.c());
            AcRunQuestionBinding acRunQuestionBinding2 = QuestionActivity.this.f22338a;
            if (acRunQuestionBinding2 == null) {
                f0.S("mDataBinding");
                acRunQuestionBinding2 = null;
            }
            QuestionVieModel questionVieModel5 = QuestionActivity.this.f22339b;
            if (questionVieModel5 == null) {
                f0.S("mViewModel");
            } else {
                questionVieModel2 = questionVieModel5;
            }
            acRunQuestionBinding2.setAnswer(questionVieModel2.a());
        }
    }

    static {
        StubApp.interface11(11912);
    }

    private final void O() {
        Http.with(this).setObservable(((w.a) Http.getApiService(w.a.class)).h1()).setDataListener(new a());
    }

    private final String P() {
        QuestionVieModel questionVieModel = this.f22339b;
        if (questionVieModel == null) {
            f0.S("mViewModel");
            questionVieModel = null;
        }
        String str = "";
        for (Map<String, Object> map : questionVieModel.a()) {
            if (JsonParse.getInt(map, "isRight") == 0) {
                str = f0.C("\u6b63\u786e\u7b54\u6848\uff1a", JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK));
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(QuestionActivity this$0, RadioGroup radioGroup, int i4) {
        f0.p(this$0, "this$0");
        QuestionVieModel questionVieModel = this$0.f22339b;
        AcRunQuestionBinding acRunQuestionBinding = null;
        if (questionVieModel == null) {
            f0.S("mViewModel");
            questionVieModel = null;
        }
        questionVieModel.e(Integer.valueOf(i4));
        AcRunQuestionBinding acRunQuestionBinding2 = this$0.f22338a;
        if (acRunQuestionBinding2 == null) {
            f0.S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding3 = this$0.f22338a;
        if (acRunQuestionBinding3 == null) {
            f0.S("mDataBinding");
            acRunQuestionBinding3 = null;
        }
        RadioGroup radioGroup3 = acRunQuestionBinding3.rgAnswer;
        QuestionVieModel questionVieModel2 = this$0.f22339b;
        if (questionVieModel2 == null) {
            f0.S("mViewModel");
            questionVieModel2 = null;
        }
        Integer b4 = questionVieModel2.b();
        f0.m(b4);
        int indexOfChild = radioGroup2.indexOfChild(radioGroup3.findViewById(b4.intValue()));
        QuestionVieModel questionVieModel3 = this$0.f22339b;
        if (questionVieModel3 == null) {
            f0.S("mViewModel");
            questionVieModel3 = null;
        }
        if (Integer.parseInt(String.valueOf(questionVieModel3.a().get(indexOfChild).get("isRight"))) == 1) {
            AcRunQuestionBinding acRunQuestionBinding4 = this$0.f22338a;
            if (acRunQuestionBinding4 == null) {
                f0.S("mDataBinding");
                acRunQuestionBinding4 = null;
            }
            acRunQuestionBinding4.tvRightAnswer.setText(this$0.P());
            AcRunQuestionBinding acRunQuestionBinding5 = this$0.f22338a;
            if (acRunQuestionBinding5 == null) {
                f0.S("mDataBinding");
            } else {
                acRunQuestionBinding = acRunQuestionBinding5;
            }
            acRunQuestionBinding.tvRightAnswer.setVisibility(0);
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding6 = this$0.f22338a;
        if (acRunQuestionBinding6 == null) {
            f0.S("mDataBinding");
        } else {
            acRunQuestionBinding = acRunQuestionBinding6;
        }
        acRunQuestionBinding.tvRightAnswer.setVisibility(8);
    }

    public final void N() {
        QuestionVieModel questionVieModel = this.f22339b;
        QuestionVieModel questionVieModel2 = null;
        if (questionVieModel == null) {
            f0.S("mViewModel");
            questionVieModel = null;
        }
        if (questionVieModel.b() == null) {
            new iOSOneButtonDialog(this).setMessage("\u8bf7\u9009\u62e9\u7b54\u6848").show();
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding = this.f22338a;
        if (acRunQuestionBinding == null) {
            f0.S("mDataBinding");
            acRunQuestionBinding = null;
        }
        RadioGroup radioGroup = acRunQuestionBinding.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding2 = this.f22338a;
        if (acRunQuestionBinding2 == null) {
            f0.S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        QuestionVieModel questionVieModel3 = this.f22339b;
        if (questionVieModel3 == null) {
            f0.S("mViewModel");
            questionVieModel3 = null;
        }
        Integer b4 = questionVieModel3.b();
        f0.m(b4);
        int indexOfChild = radioGroup.indexOfChild(radioGroup2.findViewById(b4.intValue()));
        j.d(f0.C("indexOfChild=", Integer.valueOf(indexOfChild)), new Object[0]);
        QuestionVieModel questionVieModel4 = this.f22339b;
        if (questionVieModel4 == null) {
            f0.S("mViewModel");
        } else {
            questionVieModel2 = questionVieModel4;
        }
        ObservableArrayList<Map<String, Object>> a4 = questionVieModel2.a();
        if (a4 == null) {
            return;
        }
        if (Integer.parseInt(String.valueOf(a4.get(indexOfChild).get("isRight"))) == 1) {
            new iOSOneButtonDialog(this).setMessage("\u7b54\u6848\u9519\u8bef").show();
            return;
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);
}
