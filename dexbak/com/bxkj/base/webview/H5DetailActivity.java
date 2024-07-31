package com.bxkj.base.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bxkj.base.C3801R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4229c;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class H5DetailActivity extends BaseActivity {

    /* renamed from: m */
    public static boolean f15313m;

    /* renamed from: k */
    private SmartWebView f15314k;

    /* renamed from: l */
    private String f15315l;

    /* renamed from: com.bxkj.base.webview.H5DetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4007a implements BaseActivity.InterfaceC1107c {
        C4007a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            H5DetailActivity.this.onBackPressed();
        }
    }

    /* renamed from: com.bxkj.base.webview.H5DetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4008b {
        C4008b() {
        }

        @JavascriptInterface
        public void jsinvoke(String str) {
            H5DetailActivity.this.startActivity(new Intent().setClassName(C4229c.f16086b, "com.bxkj.student.life.mall.GoodsDetailActivity").putExtra("goodsId", str));
        }
    }

    static {
        StubApp.interface11(10263);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f15315l = "http://www.boxkj.com";
        String stringExtra = getIntent().hasExtra("title") ? getIntent().getStringExtra("title") : "消息详情";
        if (getIntent().hasExtra("url")) {
            this.f15315l = getIntent().getStringExtra("url");
            C11792j.m20470c("smartWebView.url=" + this.f15315l);
            this.f15314k.m57493j(this.f15315l);
        } else if (getIntent().hasExtra("content")) {
            String stringExtra2 = getIntent().getStringExtra("content");
            C11792j.m20470c("smartWebView.content=" + stringExtra2);
            this.f15314k.m57495h(stringExtra2);
        }
        this.f15314k.getWebView().addJavascriptInterface(new C4008b(), FaceEnvironment.f8430OS);
        setTitle(stringExtra);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57927Z(new C4007a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f15314k = (SmartWebView) findViewById(C3801R.C3805id.smartWebView);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f15314k.getWebView().canGoBack()) {
            this.f15314k.getWebView().goBack();
        } else if (AppManager.m57776n().m57777m().size() == 1) {
            if (!Tools.m57617b0(LoginUser.getLoginUser().getSchoolName()) && !Tools.m57617b0(LoginUser.getLoginUser().getServerUrl())) {
                startActivity(new Intent().setClassName(C4229c.f16086b, "com.bxkj.student.MainActivity"));
                finish();
            } else {
                startActivity(new Intent().setClassName(C4229c.f16086b, "com.bxkj.student.splash.SelectSchoolActivity"));
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
        SmartWebView smartWebView = this.f15314k;
        if (smartWebView != null && (parent = smartWebView.getParent()) != null) {
            ((ViewGroup) parent).removeView(this.f15314k);
        }
        this.f15314k.getWebView().stopLoading();
        this.f15314k.getWebView().getSettings().setJavaScriptEnabled(false);
        this.f15314k.getWebView().clearHistory();
        this.f15314k.removeAllViews();
        this.f15314k.getWebView().destroy();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f15314k.getWebView().canGoBack()) {
                this.f15314k.getWebView().goBack();
                return true;
            } else if (AppManager.m57776n().m57777m() != null && AppManager.m57776n().m57777m().size() == 1) {
                startActivity(new Intent().setClassName(C4229c.f16086b, "com.bxkj.student.MainActivity"));
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        f15313m = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        f15313m = true;
        super.onResume();
    }
}
