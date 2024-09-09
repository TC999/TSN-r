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
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamLessonDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f21320k;

    /* renamed from: l  reason: collision with root package name */
    private SmartWebView f21321l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.separateexam.ExamLessonDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0250a extends CountDownTimer {
            CountDownTimerC0250a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ExamLessonDescriptionActivity.this.f21320k.setEnabled(true);
                ExamLessonDescriptionActivity.this.f21320k.setText("\u5f00\u59cb\u7ea6\u8003");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = ExamLessonDescriptionActivity.this.f21320k;
                button.setText("\u5f00\u59cb\u7ea6\u8003(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamLessonDescriptionActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamLessonDescriptionActivity.this.R().setVisibility(0);
            ExamLessonDescriptionActivity.this.f21321l.h(JsonParse.getString(data, "data"));
            ExamLessonDescriptionActivity.this.f21321l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            ExamLessonDescriptionActivity.this.f21320k.setEnabled(false);
            new CountDownTimerC0250a(4000L, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21320k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).L0()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ea6\u8003\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21320k = (Button) findViewById(2131231012);
        this.f21321l = (SmartWebView) findViewById(2131232694);
        R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1656h, AppointExamListActivity.class));
        finish();
    }
}
