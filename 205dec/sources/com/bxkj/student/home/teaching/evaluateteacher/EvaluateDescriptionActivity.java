package com.bxkj.student.home.teaching.evaluateteacher;

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
public class EvaluateDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f20078k;

    /* renamed from: l  reason: collision with root package name */
    private Button f20079l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0230a extends CountDownTimer {
            CountDownTimerC0230a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                EvaluateDescriptionActivity.this.f20079l.setEnabled(true);
                EvaluateDescriptionActivity.this.f20079l.setText("\u5f00\u59cb\u8bc4\u4ef7");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = EvaluateDescriptionActivity.this.f20079l;
                button.setText("\u5f00\u59cb\u8bc4\u4ef7(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateDescriptionActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateDescriptionActivity.this.R().setVisibility(0);
            EvaluateDescriptionActivity.this.f20078k.h(JsonParse.getString(data, "data"));
            EvaluateDescriptionActivity.this.f20078k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            EvaluateDescriptionActivity.this.f20079l.setEnabled(false);
            new CountDownTimerC0230a(4000L, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20079l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).D()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bc4\u4ef7\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20079l = (Button) findViewById(2131231012);
        this.f20078k = (SmartWebView) findViewById(2131232694);
        R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1656h, EvaluateActivity.class));
        finish();
    }
}
