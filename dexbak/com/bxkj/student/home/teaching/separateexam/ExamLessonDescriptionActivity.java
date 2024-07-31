package com.bxkj.student.home.teaching.separateexam;

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
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamLessonDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private Button f17982k;

    /* renamed from: l */
    private SmartWebView f17983l;

    /* renamed from: com.bxkj.student.home.teaching.separateexam.ExamLessonDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4867a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.separateexam.ExamLessonDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC4868a extends CountDownTimer {
            CountDownTimerC4868a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ExamLessonDescriptionActivity.this.f17982k.setEnabled(true);
                ExamLessonDescriptionActivity.this.f17982k.setText("开始约考");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = ExamLessonDescriptionActivity.this.f17982k;
                button.setText("开始约考(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C4867a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamLessonDescriptionActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamLessonDescriptionActivity.this.m57932R().setVisibility(0);
            ExamLessonDescriptionActivity.this.f17983l.m57495h(JsonParse.getString(data, "data"));
            ExamLessonDescriptionActivity.this.f17983l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            ExamLessonDescriptionActivity.this.f17982k.setEnabled(false);
            new CountDownTimerC4868a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17982k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m158L0()).setDataListener(new C4867a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("约考说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17982k = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f17983l = (SmartWebView) findViewById(2131232694);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1669h, AppointExamListActivity.class));
        finish();
    }
}
