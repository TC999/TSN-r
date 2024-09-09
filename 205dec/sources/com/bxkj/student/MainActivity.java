package com.bxkj.student;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.r;
import com.bxkj.base.util.s;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.home.message.MessageActivity;
import com.bxkj.student.main.HomeFragment;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.bind.BindWechatQQActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.umeng.socialize.UMShareAPI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MainActivity extends BaseActivity {

    /* renamed from: l  reason: collision with root package name */
    private Fragment f19421l;

    /* renamed from: m  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.a f19422m;

    /* renamed from: n  reason: collision with root package name */
    private Fragment f19423n;

    /* renamed from: o  reason: collision with root package name */
    private s.c f19424o;

    /* renamed from: p  reason: collision with root package name */
    private iOSTwoButtonDialog f19425p;

    /* renamed from: q  reason: collision with root package name */
    public Dialog f19426q;

    /* renamed from: r  reason: collision with root package name */
    private FrameLayout f19427r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f19428s;

    /* renamed from: t  reason: collision with root package name */
    private RadioGroup f19429t;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f19431v;

    /* renamed from: x  reason: collision with root package name */
    private int f19433x;

    /* renamed from: k  reason: collision with root package name */
    private int f19420k = 0;

    /* renamed from: u  reason: collision with root package name */
    private List<Fragment> f19430u = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private int f19432w = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f19434y = false;

    /* renamed from: z  reason: collision with root package name */
    private long f19435z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            com.bxkj.student.personal.login.c.c();
            MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1656h, LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements a.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f19437a;

        b(final com.bxkj.student.common.versionupdate.a val$versionUpdate) {
            this.f19437a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            MainActivity.this.f19434y = true;
            if (hasNewVersion) {
                MainActivity.this.f19426q = this.f19437a.d(versionName, downLoadUrl, instruction);
            }
            MainActivity.this.A0();
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
            MainActivity.this.f19434y = false;
            MainActivity.this.A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.v0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schName"));
                LoginUser.getLoginUser().setServerUrl(JsonParse.getString(data, "urlSite"));
                LoginUser.getLoginUser().setIsOpenEncry(JsonParse.getString(data, "isOpenEncry"));
                LoginUser.getLoginUser().setAppId(JsonParse.getString(data, "openId"));
                LoginUser.getLoginUser().setSysType(JsonParse.getInt(data, "sysType"));
                LoginUser.getLoginUser().setIsOpenKeep(JsonParse.getInt(data, "isOpenKeep"));
                LoginUser.getLoginUser().setIsOpenLive(JsonParse.getInt(data, "isOpenLive", 1));
                Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                new HashSet().add(LoginUser.getLoginUser().getSchoolName());
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1656h, H5AppActivity.class).putExtra("title", LoginUser.getLoginUser().getSchoolName()).putExtra("url", LoginUser.getLoginUser().getServerUrl()));
                    MainActivity.this.finish();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.z0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            MainActivity.this.B0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            MainActivity.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            if (JsonParse.getString(data, "weixinId").isEmpty() && JsonParse.getString(data, "qqId").isEmpty()) {
                MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1656h, BindWechatQQActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MainActivity.this.f19420k = JsonParse.getInt(data, "data");
            MainActivity.this.J0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    private String C0() {
        try {
            return this.f1656h.getPackageManager().getPackageInfo(this.f1656h.getPackageName(), 0).versionName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "1.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        r.b(this.f1657i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(RadioGroup radioGroup, int i4) {
        this.f19433x = i4;
        this.f19432w = radioGroup.indexOfChild(radioGroup.findViewById(i4));
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        startActivity(new Intent(this.f1656h, UpdatePasswordActivity.class).putExtra("msg", getString(2131821532)));
    }

    private void H0() {
        this.f19433x = this.f19429t.getChildAt(0).getId();
        this.f19429t.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i4) {
                MainActivity.this.F0(radioGroup, i4);
            }
        });
    }

    private void I0() {
        this.f19429t.getChildAt(1).setVisibility(LoginUser.getLoginUser().getIsOpenLive() == 1 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.f19420k > 0) {
            this.f19431v.setVisibility(0);
        } else {
            this.f19431v.setVisibility(8);
        }
    }

    private void K0() {
        for (int i4 = 0; i4 < this.f19430u.size(); i4++) {
            Fragment fragment = this.f19430u.get(i4);
            if (i4 == this.f19432w) {
                if (fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().add(2131232182, fragment, String.valueOf(i4)).commitAllowingStateLoss();
                }
            } else if (fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
            }
        }
    }

    private void s0() {
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((q.f) Http.getApiService(q.f.class)).q(Integer.valueOf(Integer.parseInt(LoginUser.getLoginUser().getSchoolId())), 1, com.bxkj.student.common.utils.g.a(this.f1656h), x0(), y0(), LoginUser.getLoginUser().getUserId(), C0())).setDataListener(new g());
    }

    private String t0(String s3) {
        if (s3 == null || s3.length() == 0) {
            return "";
        }
        char charAt = s3.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return s3;
        }
        return Character.toUpperCase(charAt) + s3.substring(1);
    }

    private void u0() {
        long currentTimeMillis = System.currentTimeMillis() - LoginUser.getLoginUser().getLastLoginTime();
        if (!LoginUser.getLoginUser().isLogin() || currentTimeMillis <= 2592000000L) {
            return;
        }
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
        iosonebuttondialog.setCancelable(false);
        iosonebuttondialog.setCanceledOnTouchOutside(false);
        iosonebuttondialog.setButtonOnClickListener(new a());
        iosonebuttondialog.setMessage("\u767b\u5f55\u8fc7\u671f,\u8bf7\u91cd\u65b0\u767b\u5f55").show();
    }

    private void w0() {
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(this.f1656h);
        aVar.b(new b(aVar));
    }

    private String x0() {
        return t0(Build.MANUFACTURER);
    }

    private String y0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? t0(str2) : str2;
    }

    public void A0() {
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((q.f) Http.getApiService(q.f.class)).k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new c());
    }

    public void B0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).J0()).setDataListener(new e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19427r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427434;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (!TsnSecret.f16433a.checkSignature(this.f1656h)) {
            iOSOneButtonDialog message = new iOSOneButtonDialog(this.f1656h).setMessage("\u975e\u5b98\u65b9\u6b63\u7248\u5e94\u7528\uff0c\u8bf7\u5378\u8f7d\u540e\u4ece\u6b63\u89c4\u6e20\u9053\u4e0b\u8f7d\u4f7f\u7528");
            message.setClickAutoCancel(false);
            message.setCancelable(false);
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.D0(view);
                }
            });
            message.show();
        }
        u0();
        this.f19430u.add(this.f19423n);
        this.f19430u.add(this.f19421l);
        H0();
        K0();
        try {
            s0();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        w0();
        if (Build.VERSION.SDK_INT < 19 || r.a(this.f1656h)) {
            return;
        }
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u4e3a\u4e86\u80fd\u591f\u8ba9\u4f60\u4e0d\u9519\u8fc7\u91cd\u8981\u7684\u901a\u77e5\u6d88\u606f,\u5f3a\u70c8\u5efa\u8bae\u4f60\u5f00\u59cb\u5141\u8bb8\u63a8\u9001\u901a\u77e5\u529f\u80fd").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                MainActivity.this.E0();
            }
        }).setLeftButtonText("\u4e0d\u4e86").setRightButtonText("\u53bb\u5f00\u542f").show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("currentIndex")) {
                this.f19432w = savedInstanceState.getInt("currentIndex");
            }
            this.f19423n = getSupportFragmentManager().findFragmentByTag("0");
            this.f19421l = getSupportFragmentManager().findFragmentByTag("2");
        }
        if (this.f19423n == null) {
            this.f19423n = new HomeFragment();
        }
        if (this.f19421l == null) {
            this.f19421l = new MyFragment();
        }
        this.f19429t = (RadioGroup) findViewById(2131232489);
        this.f19428s = (TextView) findViewById(2131233204);
        this.f19431v = (ImageView) findViewById(2131231477);
        this.f19427r = (FrameLayout) findViewById(2131231318);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1656h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f19435z > 2000) {
            h0("\u518d\u6309\u4e00\u6b21\u9000\u51fa\u7a0b\u5e8f");
            this.f19435z = System.currentTimeMillis();
            return;
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1656h, LoginActivity.class));
            return;
        }
        switch (v3.getId()) {
            case 2131231318:
                startActivity(new Intent(this.f1656h, MessageActivity.class));
                return;
            case 2131231319:
                startActivity(new Intent(this.f1656h, MyQRCodeActivity.class));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f19425p;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f19425p.dismiss();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.f19434y) {
            return;
        }
        w0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19428s.setText(LoginUser.getLoginUser().getSchoolName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentIndex", this.f19432w);
        super.onSaveInstanceState(outState);
    }

    public void v0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1656h).hideLoadingDialog().hideFailMessage().hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).p0(LoginUser.getLoginUser().getAccount())).setDataListener(new d());
        }
    }

    public void z0() {
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).V0(LoginUser.getLoginUser().getUserId(), "0")).setDataListener(new f());
    }
}
