package com.bxkj.student.run.app.keep;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: KeepAuthH5Activity.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001a\u0010\u0015\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/bxkj/student/run/app/keep/KeepAuthH5Activity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Landroid/view/View;", "v", "Lkotlin/f1;", "onClick", "U", "", "P", "Landroid/os/Bundle;", "savedInstanceState", "V", "T", "", "token", "getKeepToken", "N", "k", "Ljava/lang/String;", "k0", "()Ljava/lang/String;", "url", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "l", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "smartWebView", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class KeepAuthH5Activity extends BaseActivity {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final String f22391k = "https://open.gotokeep.com/v1/oauth2/authorize?client_id=6005515ea85bc94dde5e3df7&redirect_uri=https://keep.boxkj.com/redirect&response_type=code&state=STATE";

    /* renamed from: l  reason: collision with root package name */
    private SmartWebView f22392l;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(KeepAuthH5Activity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427418;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        SmartWebView smartWebView = this.f22392l;
        SmartWebView smartWebView2 = null;
        if (smartWebView == null) {
            f0.S("smartWebView");
            smartWebView = null;
        }
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        SmartWebView smartWebView3 = this.f22392l;
        if (smartWebView3 == null) {
            f0.S("smartWebView");
        } else {
            smartWebView2 = smartWebView3;
        }
        smartWebView2.j(this.f22391k);
        webView.addJavascriptInterface(this, "keep");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ed1\u5b9aKeep\u8d26\u53f7");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131232631);
        f0.o(findViewById, "findViewById(R.id.smartWebView)");
        this.f22392l = (SmartWebView) findViewById;
    }

    @JavascriptInterface
    public final void getKeepToken(@NotNull String token) {
        f0.p(token, "token");
        j.d(f0.C("token=", token), new Object[0]);
        LoginUser.getLoginUser().setKeepToken(token);
        new iOSOneButtonDialog(this.f1656h).setMessage("\u7ed1\u5b9akeep\u8d26\u53f7\u6210\u529f\uff01").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeepAuthH5Activity.j0(KeepAuthH5Activity.this, view);
            }
        }).show();
    }

    @NotNull
    public final String k0() {
        return this.f22391k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
