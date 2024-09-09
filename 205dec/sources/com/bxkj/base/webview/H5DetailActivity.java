package com.bxkj.base.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class H5DetailActivity extends BaseActivity {

    /* renamed from: m  reason: collision with root package name */
    public static boolean f18883m;

    /* renamed from: k  reason: collision with root package name */
    private SmartWebView f18884k;

    /* renamed from: l  reason: collision with root package name */
    private String f18885l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            H5DetailActivity.this.onBackPressed();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b {
        b() {
        }

        @JavascriptInterface
        public void jsinvoke(String str) {
            H5DetailActivity.this.startActivity(new Intent().setClassName("com.bxkj.student", "com.bxkj.student.life.mall.GoodsDetailActivity").putExtra("goodsId", str));
        }
    }

    static {
        StubApp.interface11(10263);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18885l = "http://www.boxkj.com";
        String stringExtra = getIntent().hasExtra("title") ? getIntent().getStringExtra("title") : "\u6d88\u606f\u8be6\u60c5";
        if (getIntent().hasExtra("url")) {
            this.f18885l = getIntent().getStringExtra("url");
            j.c("smartWebView.url=" + this.f18885l);
            this.f18884k.j(this.f18885l);
        } else if (getIntent().hasExtra("content")) {
            String stringExtra2 = getIntent().getStringExtra("content");
            j.c("smartWebView.content=" + stringExtra2);
            this.f18884k.h(stringExtra2);
        }
        this.f18884k.getWebView().addJavascriptInterface(new b(), "android");
        setTitle(stringExtra);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        Z(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18884k = (SmartWebView) findViewById(R.id.smartWebView);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f18884k.getWebView().canGoBack()) {
            this.f18884k.getWebView().goBack();
        } else if (cn.bluemobi.dylan.base.utils.a.n().m().size() == 1) {
            if (!u.b0(LoginUser.getLoginUser().getSchoolName()) && !u.b0(LoginUser.getLoginUser().getServerUrl())) {
                startActivity(new Intent().setClassName("com.bxkj.student", "com.bxkj.student.MainActivity"));
                finish();
            } else {
                startActivity(new Intent().setClassName("com.bxkj.student", "com.bxkj.student.splash.SelectSchoolActivity"));
            }
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ViewParent parent;
        SmartWebView smartWebView = this.f18884k;
        if (smartWebView != null && (parent = smartWebView.getParent()) != null) {
            ((ViewGroup) parent).removeView(this.f18884k);
        }
        this.f18884k.getWebView().stopLoading();
        this.f18884k.getWebView().getSettings().setJavaScriptEnabled(false);
        this.f18884k.getWebView().clearHistory();
        this.f18884k.removeAllViews();
        this.f18884k.getWebView().destroy();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            if (this.f18884k.getWebView().canGoBack()) {
                this.f18884k.getWebView().goBack();
                return true;
            } else if (cn.bluemobi.dylan.base.utils.a.n().m() != null && cn.bluemobi.dylan.base.utils.a.n().m().size() == 1) {
                startActivity(new Intent().setClassName("com.bxkj.student", "com.bxkj.student.MainActivity"));
                finish();
                return true;
            }
        }
        return super.onKeyDown(i4, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        f18883m = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        f18883m = true;
        super.onResume();
    }
}
