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
import com.bxkj.student.C4215R;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LessonDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private SmartWebView f17803k;

    /* renamed from: l */
    private Button f17804l;

    /* renamed from: com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4793a extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC4794a extends CountDownTimer {
            CountDownTimerC4794a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LessonDescriptionActivity.this.f17804l.setEnabled(true);
                Button button = LessonDescriptionActivity.this.f17804l;
                button.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = LessonDescriptionActivity.this.f17804l;
                button.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName() + "(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C4793a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            LessonDescriptionActivity.this.f17804l.setEnabled(false);
            new iOSOneButtonDialog(((BaseActivity) LessonDescriptionActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LessonDescriptionActivity.this.m57932R().setVisibility(0);
            LessonDescriptionActivity.this.f17803k.m57494i(JsonParse.getString(data, "content"), LoginUser.getLoginUser().getServerUrl());
            LessonDescriptionActivity.this.f17803k.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            LessonDescriptionActivity.this.f17804l.setEnabled(false);
            new CountDownTimerC4794a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4795b extends HttpCallBack {
        C4795b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            if (i == 0) {
                ((BaseActivity) LessonDescriptionActivity.this).f1669h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1669h, OnLineLessonActivity.class));
            } else if (i == 1) {
                ((BaseActivity) LessonDescriptionActivity.this).f1669h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1669h, ChooseTimeActivity.class));
            } else if (i == 2) {
                ((BaseActivity) LessonDescriptionActivity.this).f1669h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1669h, ChooseLessonActivity.class));
            } else {
                ((BaseActivity) LessonDescriptionActivity.this).f1669h.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).f1669h, ChooseTimeActivity.class));
            }
            LessonDescriptionActivity.this.finish();
        }
    }

    /* renamed from: t0 */
    private void m41318t0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m122c0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4795b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17804l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m149Q("2", LoginUser.getLoginUser().getUserId())).setDataListener(new C4793a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选" + LoginUser.getLoginUser().getXuanAfterLabelName() + "说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17804l = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f17803k = (SmartWebView) findViewById(2131232694);
        m57932R().setVisibility(8);
        Button button = this.f17804l;
        button.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        m41318t0();
    }
}
