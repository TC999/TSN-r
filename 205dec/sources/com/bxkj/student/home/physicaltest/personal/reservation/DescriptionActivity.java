package com.bxkj.student.home.physicaltest.personal.reservation;

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
public class DescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f19961k;

    /* renamed from: l  reason: collision with root package name */
    private Button f19962l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.DescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0226a extends CountDownTimer {
            CountDownTimerC0226a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                DescriptionActivity.this.f19962l.setEnabled(true);
                DescriptionActivity.this.f19962l.setText("\u5f00\u59cb\u9884\u7ea6");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = DescriptionActivity.this.f19962l;
                button.setText("\u5f00\u59cb\u9884\u7ea6(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            DescriptionActivity.this.R().setVisibility(0);
            DescriptionActivity.this.f19961k.h(JsonParse.getString(data, "content"));
            DescriptionActivity.this.f19961k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            DescriptionActivity.this.f19962l.setEnabled(false);
            new CountDownTimerC0226a(4000L, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19962l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        this.f19962l.setText("\u5f00\u59cb\u9884\u7ea6");
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).Q("1", LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19962l = (Button) findViewById(2131231012);
        this.f19961k = (SmartWebView) findViewById(2131232694);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        startActivity(getIntent().setClass(this.f1656h, ReservationListActivity.class));
        finish();
    }
}
