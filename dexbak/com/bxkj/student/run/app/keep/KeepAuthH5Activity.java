package com.bxkj.student.run.app.keep;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KeepAuthH5Activity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001a\u0010\u0015\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, m12616d2 = {"Lcom/bxkj/student/run/app/keep/KeepAuthH5Activity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Landroid/view/View;", "v", "Lkotlin/f1;", "onClick", "U", "", "P", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", BidResponsed.KEY_TOKEN, "getKeepToken", "N", "k", "Ljava/lang/String;", "k0", "()Ljava/lang/String;", "url", "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", C7304t.f25048d, "Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "smartWebView", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class KeepAuthH5Activity extends BaseActivity {
    @NotNull

    /* renamed from: k */
    private final String f19145k = "https://open.gotokeep.com/v1/oauth2/authorize?client_id=6005515ea85bc94dde5e3df7&redirect_uri=https://keep.boxkj.com/redirect&response_type=code&state=STATE";

    /* renamed from: l */
    private SmartWebView f19146l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public static final void m40019j0(KeepAuthH5Activity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_keep_auth_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        SmartWebView smartWebView = this.f19146l;
        SmartWebView smartWebView2 = null;
        if (smartWebView == null) {
            C14342f0.m8200S("smartWebView");
            smartWebView = null;
        }
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        SmartWebView smartWebView3 = this.f19146l;
        if (smartWebView3 == null) {
            C14342f0.m8200S("smartWebView");
        } else {
            smartWebView2 = smartWebView3;
        }
        smartWebView2.m57493j(this.f19145k);
        webView.addJavascriptInterface(this, "keep");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("绑定Keep账号");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131232631);
        C14342f0.m8185o(findViewById, "findViewById(R.id.smartWebView)");
        this.f19146l = (SmartWebView) findViewById;
    }

    @JavascriptInterface
    public final void getKeepToken(@NotNull String token) {
        C14342f0.m8184p(token, "token");
        C11792j.m20469d(C14342f0.m8216C("token=", token), new Object[0]);
        LoginUser.getLoginUser().setKeepToken(token);
        new iOSOneButtonDialog(this.f1669h).setMessage("绑定keep账号成功！").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeepAuthH5Activity.m40019j0(KeepAuthH5Activity.this, view);
            }
        }).show();
    }

    @NotNull
    /* renamed from: k0 */
    public final String m40018k0() {
        return this.f19145k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
