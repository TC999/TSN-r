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
import com.bxkj.student.run.app.exam.QuestionActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import java.util.Map;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f22492k;

    /* renamed from: l  reason: collision with root package name */
    private SmartWebView f22493l;

    /* renamed from: m  reason: collision with root package name */
    private RunRoleSetBean.DataBean f22494m;

    /* renamed from: n  reason: collision with root package name */
    private final int f22495n = 255;

    /* renamed from: o  reason: collision with root package name */
    private final int f22496o = 170;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.run.app.ready.RunDescriptionActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class CountDownTimerC0281a extends CountDownTimer {
            CountDownTimerC0281a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                RunDescriptionActivity.this.f22492k.setEnabled(true);
                RunDescriptionActivity.this.f22492k.setText("\u5f00\u59cb\u8dd1\u6b65");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button = RunDescriptionActivity.this.f22492k;
                button.setText("\u5f00\u59cb\u8dd1\u6b65(" + (millisUntilFinished / 1000) + "\u79d2)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunDescriptionActivity.this.R().setVisibility(0);
            RunDescriptionActivity.this.f22493l.h(JsonParse.getString(data, "data"));
            RunDescriptionActivity.this.f22493l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            RunDescriptionActivity.this.f22492k.setEnabled(false);
            new CountDownTimerC0281a(4000L, 1000L).start();
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
            Intent intent = RunDescriptionActivity.this.getIntent().setClass(((BaseActivity) RunDescriptionActivity.this).f1656h, ThreeTwoOneActivity.class);
            intent.putExtra("startTime", JsonParse.getLong(data, "startTime"));
            RunDescriptionActivity.this.startActivity(intent);
            RunDescriptionActivity.this.overridePendingTransition(2130771987, 2130771986);
            RunDescriptionActivity.this.finish();
        }
    }

    private void m0() {
        if (this.f22494m.getIsStartFace() == 1) {
            com.bxkj.base.v2.common.ext.g.c(this.f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.run.app.ready.a
                public final Object invoke() {
                    f1 n02;
                    n02 = RunDescriptionActivity.this.n0();
                    return n02;
                }
            });
        } else {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 n0() {
        Intent intent = getIntent().setClass(this.f1656h, FaceDetectExpActivity.class);
        intent.putExtra("identify", this.f22494m.getIdentify());
        startActivityForResult(intent, 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    private void o0() {
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).g(this.f22494m.getIdentify())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22492k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("dataBean")) {
            this.f22494m = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
        }
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).f(this.f22494m.getRunType())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22492k = (Button) findViewById(2131231012);
        this.f22493l = (SmartWebView) findViewById(2131232694);
        this.f22492k.setText("\u5f00\u59cb\u8dd1\u6b65");
        R().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 255 && resultCode == -1) {
            o0();
        } else if (requestCode == 255 && resultCode == 170) {
            Intent intent = getIntent().setClass(this.f1656h, FaceDetectExpActivity.class);
            intent.putExtra("identify", this.f22494m.getIdentify());
            startActivityForResult(intent, 255);
            overridePendingTransition(2130771987, 2130771986);
        } else if (requestCode == 170 && resultCode == -1) {
            m0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        if (this.f22494m.getIsQuestion() == 1) {
            startActivityForResult(getIntent().setClass(this.f1656h, QuestionActivity.class), 170);
            overridePendingTransition(2130771987, 2130771986);
            return;
        }
        m0();
    }
}
