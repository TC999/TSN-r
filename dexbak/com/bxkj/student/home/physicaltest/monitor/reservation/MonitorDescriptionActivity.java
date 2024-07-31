package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MonitorDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private SmartWebView f16518k;

    /* renamed from: l */
    private Button f16519l;

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4370a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC4371a extends CountDownTimer {
            CountDownTimerC4371a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MonitorDescriptionActivity.this.f16519l.setEnabled(true);
                MonitorDescriptionActivity.this.f16519l.setText("开始预约");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = MonitorDescriptionActivity.this.f16519l;
                button.setText("开始预约(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C4370a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorDescriptionActivity.this.m57932R().setVisibility(0);
            MonitorDescriptionActivity.this.f16518k.m57495h(JsonParse.getString(data, "content"));
            MonitorDescriptionActivity.this.f16518k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            MonitorDescriptionActivity.this.f16519l.setEnabled(false);
            new CountDownTimerC4371a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16519l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        this.f16519l.setText("开始预约");
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m149Q("6", LoginUser.getLoginUser().getUserId())).setDataListener(new C4370a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预约说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16519l = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f16518k = (SmartWebView) findViewById(2131232694);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1669h, MonitorReservationListActivity.class));
        finish();
    }
}
