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
import cn.bluemobi.dylan.base.adapter.FragmentRadioAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3912s;
import com.bxkj.base.util.NotificationsUtils;
import com.bxkj.student.common.utils.C4249g;
import com.bxkj.student.common.versionupdate.VersionUpdate;
import com.bxkj.student.home.message.MessageActivity;
import com.bxkj.student.main.HomeFragment;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.bind.BindWechatQQActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.login.LoginUtils;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.umeng.socialize.UMShareAPI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p635q.MainApiService;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MainActivity extends BaseActivity {

    /* renamed from: l */
    private Fragment f15966l;

    /* renamed from: m */
    private FragmentRadioAdapter f15967m;

    /* renamed from: n */
    private Fragment f15968n;

    /* renamed from: o */
    private C3912s.InterfaceC3915c f15969o;

    /* renamed from: p */
    private iOSTwoButtonDialog f15970p;

    /* renamed from: q */
    public Dialog f15971q;

    /* renamed from: r */
    private FrameLayout f15972r;

    /* renamed from: s */
    private TextView f15973s;

    /* renamed from: t */
    private RadioGroup f15974t;

    /* renamed from: v */
    private ImageView f15976v;

    /* renamed from: x */
    private int f15978x;

    /* renamed from: k */
    private int f15965k = 0;

    /* renamed from: u */
    private List<Fragment> f15975u = new ArrayList();

    /* renamed from: w */
    private int f15977w = 0;

    /* renamed from: y */
    private boolean f15979y = false;

    /* renamed from: z */
    private long f15980z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4208a implements View.OnClickListener {
        View$OnClickListenerC4208a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LoginUtils.m40419c();
            MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1669h, LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4209b implements VersionUpdate.InterfaceC4268d {

        /* renamed from: a */
        final /* synthetic */ VersionUpdate f15982a;

        C4209b(final VersionUpdate val$versionUpdate) {
            this.f15982a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: a */
        public void mo38646a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            MainActivity.this.f15979y = true;
            if (hasNewVersion) {
                MainActivity.this.f15971q = this.f15982a.m42763d(versionName, downLoadUrl, instruction);
            }
            MainActivity.this.m42988A0();
        }

        @Override // com.bxkj.student.common.versionupdate.VersionUpdate.InterfaceC4268d
        /* renamed from: b */
        public void mo38645b() {
            MainActivity.this.f15979y = false;
            MainActivity.this.m42988A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4210c extends HttpCallBack {
        C4210c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.m42964v0();
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
                    MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1669h, H5AppActivity.class).putExtra("title", LoginUser.getLoginUser().getSchoolName()).putExtra("url", LoginUser.getLoginUser().getServerUrl()));
                    MainActivity.this.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4211d extends HttpCallBack {
        C4211d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MainActivity.this.m42960z0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            MainActivity.this.m42987B0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            MainActivity.this.m42982G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4212e extends HttpCallBack {
        C4212e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            if (JsonParse.getString(data, "weixinId").isEmpty() && JsonParse.getString(data, "qqId").isEmpty()) {
                MainActivity.this.startActivity(new Intent(((BaseActivity) MainActivity.this).f1669h, BindWechatQQActivity.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4213f extends HttpCallBack {
        C4213f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MainActivity.this.f15965k = JsonParse.getInt(data, "data");
            MainActivity.this.m42979J0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.MainActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4214g extends HttpCallBack {
        C4214g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    /* renamed from: C0 */
    private String m42986C0() {
        try {
            return this.f1669h.getPackageManager().getPackageInfo(this.f1669h.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void m42985D0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void m42984E0() {
        NotificationsUtils.m44050b(this.f1670i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void m42983F0(RadioGroup radioGroup, int i) {
        this.f15978x = i;
        this.f15977w = radioGroup.indexOfChild(radioGroup.findViewById(i));
        m42978K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public void m42982G0() {
        startActivity(new Intent(this.f1669h, UpdatePasswordActivity.class).putExtra("msg", getString(C4215R.C4224string.update_password_msg)));
    }

    /* renamed from: H0 */
    private void m42981H0() {
        this.f15978x = this.f15974t.getChildAt(0).getId();
        this.f15974t.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                MainActivity.this.m42983F0(radioGroup, i);
            }
        });
    }

    /* renamed from: I0 */
    private void m42980I0() {
        this.f15974t.getChildAt(1).setVisibility(LoginUser.getLoginUser().getIsOpenLive() == 1 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public void m42979J0() {
        if (this.f15965k > 0) {
            this.f15976v.setVisibility(0);
        } else {
            this.f15976v.setVisibility(8);
        }
    }

    /* renamed from: K0 */
    private void m42978K0() {
        for (int i = 0; i < this.f15975u.size(); i++) {
            Fragment fragment = this.f15975u.get(i);
            if (i == this.f15977w) {
                if (fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().add(2131232182, fragment, String.valueOf(i)).commitAllowingStateLoss();
                }
            } else if (fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
            }
        }
    }

    /* renamed from: s0 */
    private void m42967s0() {
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2260q(Integer.valueOf(Integer.parseInt(LoginUser.getLoginUser().getSchoolId())), 1, C4249g.m42833a(this.f1669h), m42962x0(), m42961y0(), LoginUser.getLoginUser().getUserId(), m42986C0())).setDataListener(new C4214g());
    }

    /* renamed from: t0 */
    private String m42966t0(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char charAt = s.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return s;
        }
        return Character.toUpperCase(charAt) + s.substring(1);
    }

    /* renamed from: u0 */
    private void m42965u0() {
        long currentTimeMillis = System.currentTimeMillis() - LoginUser.getLoginUser().getLastLoginTime();
        if (!LoginUser.getLoginUser().isLogin() || currentTimeMillis <= 2592000000L) {
            return;
        }
        iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
        iosonebuttondialog.setCancelable(false);
        iosonebuttondialog.setCanceledOnTouchOutside(false);
        iosonebuttondialog.setButtonOnClickListener(new View$OnClickListenerC4208a());
        iosonebuttondialog.setMessage("登录过期,请重新登录").show();
    }

    /* renamed from: w0 */
    private void m42963w0() {
        VersionUpdate versionUpdate = new VersionUpdate(this.f1669h);
        versionUpdate.m42765b(new C4209b(versionUpdate));
    }

    /* renamed from: x0 */
    private String m42962x0() {
        return m42966t0(Build.MANUFACTURER);
    }

    /* renamed from: y0 */
    private String m42961y0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? m42966t0(str2) : str2;
    }

    /* renamed from: A0 */
    public void m42988A0() {
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2266k(LoginUser.getLoginUser().getSchoolId())).setDataListener(new C4210c());
    }

    /* renamed from: B0 */
    public void m42987B0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m162J0()).setDataListener(new C4212e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15972r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_main;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (!TsnSecret.f13210a.checkSignature(this.f1669h)) {
            iOSOneButtonDialog message = new iOSOneButtonDialog(this.f1669h).setMessage("非官方正版应用，请卸载后从正规渠道下载使用");
            message.setClickAutoCancel(false);
            message.setCancelable(false);
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m42985D0(view);
                }
            });
            message.show();
        }
        m42965u0();
        this.f15975u.add(this.f15968n);
        this.f15975u.add(this.f15966l);
        m42981H0();
        m42978K0();
        try {
            m42967s0();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m42963w0();
        if (Build.VERSION.SDK_INT < 19 || NotificationsUtils.m44051a(this.f1669h)) {
            return;
        }
        new iOSTwoButtonDialog(this.f1669h).setMessage("为了能够让你不错过重要的通知消息,强烈建议你开始允许推送通知功能").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                MainActivity.this.m42984E0();
            }
        }).setLeftButtonText("不了").setRightButtonText("去开启").show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("currentIndex")) {
                this.f15977w = savedInstanceState.getInt("currentIndex");
            }
            this.f15968n = getSupportFragmentManager().findFragmentByTag("0");
            this.f15966l = getSupportFragmentManager().findFragmentByTag("2");
        }
        if (this.f15968n == null) {
            this.f15968n = new HomeFragment();
        }
        if (this.f15966l == null) {
            this.f15966l = new MyFragment();
        }
        this.f15974t = (RadioGroup) findViewById(2131232489);
        this.f15973s = (TextView) findViewById(2131233204);
        this.f15976v = (ImageView) findViewById(C4215R.C4219id.iv_red_dot);
        this.f15972r = (FrameLayout) findViewById(C4215R.C4219id.fm_message);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.f1669h).onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.f15980z > 2000) {
            m57919h0("再按一次退出程序");
            this.f15980z = System.currentTimeMillis();
            return;
        }
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1669h, LoginActivity.class));
            return;
        }
        switch (v.getId()) {
            case C4215R.C4219id.fm_message /* 2131231318 */:
                startActivity(new Intent(this.f1669h, MessageActivity.class));
                return;
            case C4215R.C4219id.fm_qrcode /* 2131231319 */:
                startActivity(new Intent(this.f1669h, MyQRCodeActivity.class));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f15970p;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f15970p.dismiss();
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
        if (this.f15979y) {
            return;
        }
        m42963w0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f15973s.setText(LoginUser.getLoginUser().getSchoolName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentIndex", this.f15977w);
        super.onSaveInstanceState(outState);
    }

    /* renamed from: v0 */
    public void m42964v0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1669h).hideLoadingDialog().hideFailMessage().hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m83p0(LoginUser.getLoginUser().getAccount())).setDataListener(new C4211d());
        }
    }

    /* renamed from: z0 */
    public void m42960z0() {
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m138V0(LoginUser.getLoginUser().getUserId(), "0")).setDataListener(new C4213f());
    }
}
