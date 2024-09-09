package com.bxkj.student.home.teaching.lesson;

import android.content.Intent;
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
import com.bxkj.base.user.LoginUser;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LessonDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f21141k;

    /* renamed from: l  reason: collision with root package name */
    private Button f21142l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0244a extends CountDownTimer {
            CountDownTimerC0244a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LessonDescriptionActivity.this.f21142l.setEnabled(true);
                Button button = LessonDescriptionActivity.this.f21142l;
                button.setText("\u5f00\u59cb\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = LessonDescriptionActivity.this.f21142l;
                button.setText("\u5f00\u59cb\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName() + "(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            LessonDescriptionActivity.this.f21142l.setEnabled(false);
            new iOSOneButtonDialog(((BaseActivity) LessonDescriptionActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LessonDescriptionActivity.this.R().setVisibility(0);
            LessonDescriptionActivity.this.f21141k.i(JsonParse.getString(data, "content"), LoginUser.getLoginUser().getServerUrl());
            LessonDescriptionActivity.this.f21141k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            LessonDescriptionActivity.this.f21142l.setEnabled(false);
            new CountDownTimerC0244a(4000L, 1000L).start();
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
            int i4 = JsonParse.getInt(data, "data");
            if (i4 == 0) {
                ((BaseActivity) LessonDescriptionActivity.this).f1656h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1656h, OnLineLessonActivity.class));
            } else if (i4 == 1) {
                ((BaseActivity) LessonDescriptionActivity.this).f1656h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1656h, ChooseTimeActivity.class));
            } else if (i4 == 2) {
                ((BaseActivity) LessonDescriptionActivity.this).f1656h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1656h, ChooseLessonActivity.class));
            } else {
                ((BaseActivity) LessonDescriptionActivity.this).f1656h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1656h, ChooseTimeActivity.class));
            }
            LessonDescriptionActivity.this.finish();
        }
    }

    private void t0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).c0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21142l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).Q("2", LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName() + "\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21142l = (Button) findViewById(2131231012);
        this.f21141k = (SmartWebView) findViewById(2131232694);
        R().setVisibility(8);
        Button button = this.f21142l;
        button.setText("\u5f00\u59cb\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        t0();
    }
}
