package com.bxkj.student.home.teaching.exam;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f20098k;

    /* renamed from: l  reason: collision with root package name */
    private SmartWebView f20099l;

    /* renamed from: m  reason: collision with root package name */
    private int f20100m = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.exam.ExamDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0232a extends CountDownTimer {
            CountDownTimerC0232a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ExamDescriptionActivity.this.f20098k.setEnabled(true);
                ExamDescriptionActivity.this.f20098k.setText("\u5f00\u59cb\u8003\u8bd5");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = ExamDescriptionActivity.this.f20098k;
                button.setText("\u5f00\u59cb\u8003\u8bd5(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamDescriptionActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDescriptionActivity.this.R().setVisibility(0);
            ExamDescriptionActivity.this.f20099l.h(JsonParse.getString(data, "data"));
            ExamDescriptionActivity.this.f20099l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            ExamDescriptionActivity.this.f20098k.setEnabled(false);
            new CountDownTimerC0232a(4000L, 1000L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isMoreCourses") == 0) {
                int i4 = JsonParse.getInt(data, "courseNum");
                ExamDescriptionActivity examDescriptionActivity = ExamDescriptionActivity.this;
                examDescriptionActivity.startActivity(examDescriptionActivity.getIntent().putExtra("courseNum", i4).setClass(((BaseActivity) ExamDescriptionActivity.this).f1656h, SelectExamLessonActivity.class));
            } else if (ExamDescriptionActivity.this.f20100m == 0) {
                ExamDescriptionActivity examDescriptionActivity2 = ExamDescriptionActivity.this;
                examDescriptionActivity2.startActivity(examDescriptionActivity2.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).f1656h, ExamActivity.class));
            } else {
                ExamDescriptionActivity examDescriptionActivity3 = ExamDescriptionActivity.this;
                examDescriptionActivity3.startActivity(examDescriptionActivity3.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).f1656h, NewExamActivity.class));
            }
            ExamDescriptionActivity.this.finish();
        }
    }

    private void p0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).z0(getIntent().getStringExtra("stuTeacherCurriculumId"), this.f20100m)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20098k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f20100m = getIntent().getIntExtra("onlineType", 0);
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).g0(this.f20100m)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        if (getIntent().hasExtra("title")) {
            String stringExtra = getIntent().getStringExtra("title");
            setTitle(stringExtra + "\u8bf4\u660e");
            return;
        }
        setTitle("\u8003\u8bd5\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20098k = (Button) findViewById(2131231012);
        this.f20099l = (SmartWebView) findViewById(2131232694);
        R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        p0();
    }
}
