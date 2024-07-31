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
import com.bxkj.student.C4215R;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class EvaluateDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private SmartWebView f16688k;

    /* renamed from: l */
    private Button f16689l;

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4432a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC4433a extends CountDownTimer {
            CountDownTimerC4433a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                EvaluateDescriptionActivity.this.f16689l.setEnabled(true);
                EvaluateDescriptionActivity.this.f16689l.setText("开始评价");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = EvaluateDescriptionActivity.this.f16689l;
                button.setText("开始评价(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C4432a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateDescriptionActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateDescriptionActivity.this.m57932R().setVisibility(0);
            EvaluateDescriptionActivity.this.f16688k.m57495h(JsonParse.getString(data, "data"));
            EvaluateDescriptionActivity.this.f16688k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            EvaluateDescriptionActivity.this.f16689l.setEnabled(false);
            new CountDownTimerC4433a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16689l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m180D()).setDataListener(new C4432a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("评价说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16689l = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f16688k = (SmartWebView) findViewById(2131232694);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1669h, EvaluateActivity.class));
        finish();
    }
}
