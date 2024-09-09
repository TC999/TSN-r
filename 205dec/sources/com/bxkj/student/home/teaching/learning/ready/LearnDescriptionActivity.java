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
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LearnDescriptionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f21033k;

    /* renamed from: l  reason: collision with root package name */
    private SmartWebView f21034l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDescriptionActivity.this.R().setVisibility(0);
            LearnDescriptionActivity.this.f21034l.h(JsonParse.getString(data, "content"));
            LearnDescriptionActivity.this.f21034l.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21037a;

            a(final Map val$data) {
                this.f21037a = val$data;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                LearnDescriptionActivity.this.l0(this.f21037a);
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (!TextUtils.isEmpty(msg) && !"null".equalsIgnoreCase(msg)) {
                new iOSOneButtonDialog(((BaseActivity) LearnDescriptionActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new a(data)).show();
            } else {
                LearnDescriptionActivity.this.l0(data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Map<String, Object> data) {
        Intent intent;
        if (JsonParse.getInt(data, "data") == 1) {
            intent = getIntent().setClass(this.f1656h, SelectLessonActivity.class);
        } else {
            intent = getIntent().setClass(this.f1656h, LearnHomeListActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21033k.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427459;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).p()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5728\u7ebf\u5b66\u4e60\u8bf4\u660e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21033k = (Button) findViewById(2131231012);
        this.f21034l = (SmartWebView) findViewById(2131232694);
        this.f21033k.setText("\u5f00\u59cb\u5b66\u4e60");
        R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231012) {
            return;
        }
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((m) Http.getApiService(m.class)).n()).setDataListener(new b());
    }
}
