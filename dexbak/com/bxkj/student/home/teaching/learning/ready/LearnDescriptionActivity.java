package com.bxkj.student.home.teaching.learning.ready;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LearnDescriptionActivity extends BaseActivity {

    /* renamed from: k */
    private Button f17695k;

    /* renamed from: l */
    private SmartWebView f17696l;

    /* renamed from: com.bxkj.student.home.teaching.learning.ready.LearnDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4755a extends HttpCallBack {
        C4755a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDescriptionActivity.this.m57932R().setVisibility(0);
            LearnDescriptionActivity.this.f17696l.m57495h(JsonParse.getString(data, "content"));
            LearnDescriptionActivity.this.f17696l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.ready.LearnDescriptionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4756b extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.learning.ready.LearnDescriptionActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4757a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17699a;

            View$OnClickListenerC4757a(final Map val$data) {
                this.f17699a = val$data;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LearnDescriptionActivity.this.m41437l0(this.f17699a);
            }
        }

        C4756b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (!TextUtils.isEmpty(msg) && !"null".equalsIgnoreCase(msg)) {
                new iOSOneButtonDialog(((BaseActivity) LearnDescriptionActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View$OnClickListenerC4757a(data)).show();
            } else {
                LearnDescriptionActivity.this.m41437l0(data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public void m41437l0(Map<String, Object> data) {
        Intent intent;
        if (JsonParse.getInt(data, "data") == 1) {
            intent = getIntent().setClass(this.f1669h, SelectLessonActivity.class);
        } else {
            intent = getIntent().setClass(this.f1669h, LearnHomeListActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17695k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41626p()).setDataListener(new C4755a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("在线学习说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17695k = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f17696l = (SmartWebView) findViewById(2131232694);
        this.f17695k.setText("开始学习");
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231012) {
            return;
        }
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41628n()).setDataListener(new C4756b());
    }
}
