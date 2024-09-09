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
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MonitorDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f19908k;

    /* renamed from: l  reason: collision with root package name */
    private Button f19909l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0223a extends CountDownTimer {
            CountDownTimerC0223a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MonitorDescriptionActivity.this.f19909l.setEnabled(true);
                MonitorDescriptionActivity.this.f19909l.setText("\u5f00\u59cb\u9884\u7ea6");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = MonitorDescriptionActivity.this.f19909l;
                button.setText("\u5f00\u59cb\u9884\u7ea6(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorDescriptionActivity.this.R().setVisibility(0);
            MonitorDescriptionActivity.this.f19908k.h(JsonParse.getString(data, "content"));
            MonitorDescriptionActivity.this.f19908k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            MonitorDescriptionActivity.this.f19909l.setEnabled(false);
            new CountDownTimerC0223a(4000L, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19909l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        this.f19909l.setText("\u5f00\u59cb\u9884\u7ea6");
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).Q("6", LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19909l = (Button) findViewById(2131231012);
        this.f19908k = (SmartWebView) findViewById(2131232694);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1656h, MonitorReservationListActivity.class));
        finish();
    }
}
