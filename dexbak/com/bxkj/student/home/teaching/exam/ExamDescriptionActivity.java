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
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private Button f16708k;

    /* renamed from: l */
    private SmartWebView f16709l;

    /* renamed from: m */
    private int f16710m = 0;

    /* renamed from: com.bxkj.student.home.teaching.exam.ExamDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4440a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.exam.ExamDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC4441a extends CountDownTimer {
            CountDownTimerC4441a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ExamDescriptionActivity.this.f16708k.setEnabled(true);
                ExamDescriptionActivity.this.f16708k.setText("开始考试");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = ExamDescriptionActivity.this.f16708k;
                button.setText("开始考试(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C4440a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamDescriptionActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDescriptionActivity.this.m57932R().setVisibility(0);
            ExamDescriptionActivity.this.f16709l.m57495h(JsonParse.getString(data, "data"));
            ExamDescriptionActivity.this.f16709l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            ExamDescriptionActivity.this.f16708k.setEnabled(false);
            new CountDownTimerC4441a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.ExamDescriptionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4442b extends HttpCallBack {
        C4442b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isMoreCourses") == 0) {
                int i = JsonParse.getInt(data, "courseNum");
                ExamDescriptionActivity examDescriptionActivity = ExamDescriptionActivity.this;
                examDescriptionActivity.startActivity(examDescriptionActivity.getIntent().putExtra("courseNum", i).setClass(((BaseActivity) ExamDescriptionActivity.this).f1669h, SelectExamLessonActivity.class));
            } else if (ExamDescriptionActivity.this.f16710m == 0) {
                ExamDescriptionActivity examDescriptionActivity2 = ExamDescriptionActivity.this;
                examDescriptionActivity2.startActivity(examDescriptionActivity2.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).f1669h, ExamActivity.class));
            } else {
                ExamDescriptionActivity examDescriptionActivity3 = ExamDescriptionActivity.this;
                examDescriptionActivity3.startActivity(examDescriptionActivity3.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).f1669h, NewExamActivity.class));
            }
            ExamDescriptionActivity.this.finish();
        }
    }

    /* renamed from: p0 */
    private void m42369p0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m53z0(getIntent().getStringExtra("stuTeacherCurriculumId"), this.f16710m)).setDataListener(new C4442b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16708k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f16710m = getIntent().getIntExtra("onlineType", 0);
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m110g0(this.f16710m)).setDataListener(new C4440a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        if (getIntent().hasExtra("title")) {
            String stringExtra = getIntent().getStringExtra("title");
            setTitle(stringExtra + "说明");
            return;
        }
        setTitle("考试说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16708k = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f16709l = (SmartWebView) findViewById(2131232694);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        m42369p0();
    }
}
