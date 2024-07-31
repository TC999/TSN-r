package com.bxkj.student.run.app.ready;

import android.content.Intent;
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
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.exam.QuestionActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Map;
import kotlin.Unit;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import p617l1.InterfaceC15269a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private Button f19255k;

    /* renamed from: l */
    private SmartWebView f19256l;

    /* renamed from: m */
    private RunRoleSetBean.DataBean f19257m;

    /* renamed from: n */
    private final int f19258n = 255;

    /* renamed from: o */
    private final int f19259o = 170;

    /* renamed from: com.bxkj.student.run.app.ready.RunDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5301a extends HttpCallBack {

        /* renamed from: com.bxkj.student.run.app.ready.RunDescriptionActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class CountDownTimerC5302a extends CountDownTimer {
            CountDownTimerC5302a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                RunDescriptionActivity.this.f19255k.setEnabled(true);
                RunDescriptionActivity.this.f19255k.setText("开始跑步");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = RunDescriptionActivity.this.f19255k;
                button.setText("开始跑步(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        C5301a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunDescriptionActivity.this.m57932R().setVisibility(0);
            RunDescriptionActivity.this.f19256l.m57495h(JsonParse.getString(data, "data"));
            RunDescriptionActivity.this.f19256l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            RunDescriptionActivity.this.f19255k.setEnabled(false);
            new CountDownTimerC5302a(DanmakuFactory.f43786r, 1000L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.ready.RunDescriptionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5303b extends HttpCallBack {
        C5303b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = RunDescriptionActivity.this.getIntent().setClass(((BaseActivity) RunDescriptionActivity.this).f1669h, ThreeTwoOneActivity.class);
            intent.putExtra(AnalyticsConfig.RTD_START_TIME, JsonParse.getLong(data, AnalyticsConfig.RTD_START_TIME));
            RunDescriptionActivity.this.startActivity(intent);
            RunDescriptionActivity.this.overridePendingTransition(2130771987, 2130771986);
            RunDescriptionActivity.this.finish();
        }
    }

    /* renamed from: m0 */
    private void m39919m0() {
        if (this.f19257m.getIsStartFace() == 1) {
            PermissionExt.m43841c(this.f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.run.app.ready.a
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m39918n0;
                    m39918n0 = RunDescriptionActivity.this.m39918n0();
                    return m39918n0;
                }
            });
        } else {
            m39917o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ Unit m39918n0() {
        Intent intent = getIntent().setClass(this.f1669h, FaceDetectExpActivity.class);
        intent.putExtra("identify", this.f19257m.getIdentify());
        startActivityForResult(intent, 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* renamed from: o0 */
    private void m39917o0() {
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40114g(this.f19257m.getIdentify())).setDataListener(new C5303b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19255k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("dataBean")) {
            this.f19257m = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
        }
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40115f(this.f19257m.getRunType())).setDataListener(new C5301a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19255k = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f19256l = (SmartWebView) findViewById(2131232694);
        this.f19255k.setText("开始跑步");
        m57932R().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 255 && resultCode == -1) {
            m39917o0();
        } else if (requestCode == 255 && resultCode == 170) {
            Intent intent = getIntent().setClass(this.f1669h, FaceDetectExpActivity.class);
            intent.putExtra("identify", this.f19257m.getIdentify());
            startActivityForResult(intent, 255);
            overridePendingTransition(2130771987, 2130771986);
        } else if (requestCode == 170 && resultCode == -1) {
            m39919m0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        if (this.f19257m.getIsQuestion() == 1) {
            startActivityForResult(getIntent().setClass(this.f1669h, QuestionActivity.class), 170);
            overridePendingTransition(2130771987, 2130771986);
            return;
        }
        m39919m0();
    }
}
