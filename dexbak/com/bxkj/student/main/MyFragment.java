package com.bxkj.student.main;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.MyImageLoader;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.p094v2.p098ui.p101my.AdSwitchActivity;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.SystemSetActivity;
import com.bxkj.student.personal.UserInfoActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.login.LoginUtils;
import com.bxkj.student.personal.sign.SignInActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.orhanobut.logger.C11792j;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import p617l1.InterfaceC15269a;
import p618m.StartActivityForResult;
import p635q.MainApiService;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyFragment extends BaseFragment {

    /* renamed from: A */
    private Button f18639A;

    /* renamed from: B */
    private LinearLayout f18640B;

    /* renamed from: C */
    private LinearLayout f18641C;

    /* renamed from: D */
    private LinearLayout f18642D;

    /* renamed from: E */
    private LinearLayout f18643E;

    /* renamed from: F */
    private LinearLayout f18644F;

    /* renamed from: G */
    private LinearLayout f18645G;

    /* renamed from: h */
    private Button f18646h;

    /* renamed from: i */
    private TextView f18647i;

    /* renamed from: j */
    private TextView f18648j;

    /* renamed from: k */
    private TextView f18649k;

    /* renamed from: l */
    private TextView f18650l;

    /* renamed from: m */
    private TextView f18651m;

    /* renamed from: n */
    private TextView f18652n;

    /* renamed from: o */
    private TextView f18653o;

    /* renamed from: p */
    private TextView f18654p;

    /* renamed from: q */
    private ImageView f18655q;

    /* renamed from: r */
    private LinearLayout f18656r;

    /* renamed from: s */
    private LinearLayout f18657s;

    /* renamed from: t */
    private boolean f18658t = false;

    /* renamed from: u */
    private ImageView f18659u;

    /* renamed from: v */
    private LinearLayout f18660v;

    /* renamed from: w */
    private LinearLayout f18661w;

    /* renamed from: x */
    private LinearLayout f18662x;

    /* renamed from: y */
    private TextView f18663y;

    /* renamed from: z */
    private TextView f18664z;

    /* renamed from: com.bxkj.student.main.MyFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5086a implements iOSTwoButtonDialog.RightButtonOnClick {
        C5086a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            LoginUtils.m40419c();
            MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1678e, LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.MyFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5087b extends HttpCallBack {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.main.MyFragment$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5088a extends HttpCallBack {
            C5088a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public /* synthetic */ Unit m40614b() {
                MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1678e, FaceDetect5ExpActivity.class));
                return null;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                PermissionExt.m43841c(MyFragment.this.getActivity(), "人脸采集", new InterfaceC15269a() { // from class: com.bxkj.student.main.f
                    @Override // p617l1.InterfaceC15269a
                    public final Object invoke() {
                        Unit m40614b;
                        m40614b = MyFragment.C5087b.C5088a.this.m40614b();
                        return m40614b;
                    }
                });
            }
        }

        C5087b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Http.with(((BaseFragment) MyFragment.this).f1678e).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m63w(LoginUser.getLoginUser().getUserId())).setDataListener(new C5088a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.MyFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5089c implements ShareBoardlistener {

        /* renamed from: com.bxkj.student.main.MyFragment$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5090a implements UMShareListener {
            C5090a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) MyFragment.this).f1678e, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t) {
                t.printStackTrace();
                Toast.makeText(((BaseFragment) MyFragment.this).f1678e, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        C5089c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
            uMWeb.setTitle("校园生活如此简单");
            uMWeb.setThumb(new UMImage(((BaseFragment) MyFragment.this).f1678e, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(MyFragment.this.getString(C4215R.C4224string.welcome_user_app));
            new ShareAction(MyFragment.this.getActivity()).setPlatform(share_media).setCallback(new C5090a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.MyFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5091d extends HttpCallBack {
        C5091d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyFragment.this.f18655q.setVisibility(JsonParse.getInt(data, "data") > 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.MyFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5092e extends HttpCallBack {
        C5092e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
            LoginUser.getLoginUser().setRealName(JsonParse.getString(data, "name"));
            LoginUser.getLoginUser().setPhone(JsonParse.getString(data, "phone"));
            LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
            LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            MyFragment.this.m40617f0();
        }
    }

    /* renamed from: X */
    private void m40625X() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=884165111")));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1678e).setMessage("请先安装QQ！").show();
        }
    }

    /* renamed from: Y */
    private void m40624Y() {
        Http.with(this.f1678e).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m56y0("2")).setDataListener(new C5087b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ void m40621b0(View view) {
        startActivity(new Intent(this.f1678e, AdSwitchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void m40620c0(int i, Intent intent) {
        C11792j.m20470c("人脸识别回调resultCode=" + i);
        if (i == -1) {
            new iOSOneButtonDialog(this.f1678e).setMessage("人脸验证成功").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ Unit m40619d0() {
        Intent intent = new Intent(this.f1678e, FaceDetectExpActivity.class);
        intent.putExtra("identify", UUID.randomUUID().toString());
        intent.putExtra("isShowSuccessMessage", false);
        new StartActivityForResult(this).startActivityForResult(intent).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.student.main.e
            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public final void mo3459a(int i, Intent intent2) {
                MyFragment.this.m40620c0(i, intent2);
            }
        });
        return null;
    }

    /* renamed from: e0 */
    private void m40618e0() {
        if (this.f18658t) {
            if (LoginUser.getLoginUser().isLogin()) {
                m40617f0();
                this.f18639A.setText("退出");
                return;
            }
            MyImageLoader.m57719f(this.f1678e, LoginUser.getLoginUser().getHeadImageUrl(), this.f18659u, 2131558617, 2131558617);
            this.f18663y.setText("未登录");
            this.f18664z.setText("请登录");
            this.f18639A.setText("登录");
        }
    }

    /* renamed from: g0 */
    private void m40616g0() {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new C5089c()).open();
    }

    /* renamed from: Z */
    public void m40623Z() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1678e).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2269h(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new C5091d());
        }
    }

    /* renamed from: a0 */
    public void m40622a0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1678e).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m162J0()).setDataListener(new C5092e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18646h.setOnClickListener(this);
        this.f18647i.setOnClickListener(this);
        this.f18648j.setOnClickListener(this);
        this.f18649k.setOnClickListener(this);
        this.f18650l.setOnClickListener(this);
        this.f18651m.setOnClickListener(this);
        this.f18652n.setOnClickListener(this);
        this.f18653o.setOnClickListener(this);
        this.f18654p.setOnClickListener(this);
        this.f18659u.setOnClickListener(this);
        this.f18663y.setOnClickListener(this);
        this.f18664z.setOnClickListener(this);
        this.f18639A.setOnClickListener(this);
        this.f18640B.setOnClickListener(this);
        this.f18642D.setOnClickListener(this);
        this.f18641C.setOnClickListener(this);
        this.f18643E.setOnClickListener(this);
        this.f18656r.setOnClickListener(this);
        this.f18644F.setOnClickListener(this);
        this.f18645G.setOnClickListener(this);
        this.f18660v.setOnClickListener(this);
        this.f18661w.setOnClickListener(this);
        this.f18657s.setOnClickListener(this);
        this.f18662x.setOnClickListener(this);
        m57916c(C4215R.C4219id.ll_privacy_set).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.main.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment.this.m40621b0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        m40622a0();
        m40618e0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18646h = (Button) m57916c(C4215R.C4219id.bt_login_out);
        this.f18647i = (TextView) m57916c(C4215R.C4219id.tv_user_info);
        this.f18648j = (TextView) m57916c(C4215R.C4219id.tv_safe_set);
        this.f18649k = (TextView) m57916c(C4215R.C4219id.tv_system_set);
        this.f18650l = (TextView) m57916c(C4215R.C4219id.about_us);
        this.f18651m = (TextView) m57916c(C4215R.C4219id.tv_help_center);
        this.f18652n = (TextView) m57916c(C4215R.C4219id.tv_share);
        this.f18653o = (TextView) m57916c(C4215R.C4219id.tv_my_qrcode);
        this.f18654p = (TextView) m57916c(C4215R.C4219id.tv_feedback);
        this.f18659u = (ImageView) m57916c(2131231426);
        this.f18663y = (TextView) m57916c(2131233040);
        this.f18664z = (TextView) m57916c(2131233051);
        this.f18639A = (Button) m57916c(C4215R.C4219id.bt_logout);
        this.f18640B = (LinearLayout) m57916c(C4215R.C4219id.ll_feedback);
        this.f18642D = (LinearLayout) m57916c(C4215R.C4219id.ll_share);
        this.f18641C = (LinearLayout) m57916c(C4215R.C4219id.ll_set);
        this.f18643E = (LinearLayout) m57916c(C4215R.C4219id.ll_myinfo);
        this.f18656r = (LinearLayout) m57916c(C4215R.C4219id.ll_collect);
        this.f18644F = (LinearLayout) m57916c(C4215R.C4219id.ll_integral);
        this.f18645G = (LinearLayout) m57916c(C4215R.C4219id.ll_qr_code);
        this.f18660v = (LinearLayout) m57916c(C4215R.C4219id.ll_face);
        this.f18661w = (LinearLayout) m57916c(C4215R.C4219id.ll_agreement);
        this.f18657s = (LinearLayout) m57916c(C4215R.C4219id.ll_face_confirm);
        this.f18662x = (LinearLayout) m57916c(C4215R.C4219id.ll_privacy_policy);
        this.f18655q = (ImageView) m57916c(C4215R.C4219id.iv_not_read);
        this.f18658t = true;
        m40623Z();
    }

    /* renamed from: f0 */
    public void m40617f0() {
        MyImageLoader.m57719f(this.f1678e, LoginUser.getLoginUser().getHeadImageUrl(), this.f18659u, 2131558617, 2131558617);
        this.f18663y.setText(LoginUser.getLoginUser().getRealName());
        this.f18664z.setText(LoginUser.getLoginUser().getAccount());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_my;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == 2131232166) {
            startActivity(new Intent(this.f1678e, H5DetailActivity.class).putExtra("title", "用户协议").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
        } else if (v.getId() == 2131232211) {
            startActivity(new Intent(this.f1678e, H5DetailActivity.class).putExtra("title", "隐私政策").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
        } else if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1678e, LoginActivity.class));
        } else {
            switch (v.getId()) {
                case C4215R.C4219id.bt_logout /* 2131230986 */:
                    new iOSTwoButtonDialog(this.f1678e).setTitle("提示").setMessage("您确定要退出登录吗？").setRightButtonOnClickListener(new C5086a()).show();
                    return;
                case 2131231426:
                case 2131233040:
                case 2131233051:
                    startActivity(new Intent(this.f1678e, UserInfoActivity.class));
                    return;
                case C4215R.C4219id.ll_face /* 2131232187 */:
                    m40624Y();
                    return;
                case C4215R.C4219id.ll_face_confirm /* 2131232188 */:
                    PermissionExt.m43841c(getActivity(), "人脸验证", new InterfaceC15269a() { // from class: com.bxkj.student.main.d
                        @Override // p617l1.InterfaceC15269a
                        public final Object invoke() {
                            Unit m40619d0;
                            m40619d0 = MyFragment.this.m40619d0();
                            return m40619d0;
                        }
                    });
                    return;
                case C4215R.C4219id.ll_feedback /* 2131232189 */:
                    m40625X();
                    return;
                case C4215R.C4219id.ll_integral /* 2131232199 */:
                    startActivity(new Intent(this.f1678e, SignInActivity.class));
                    return;
                case C4215R.C4219id.ll_myinfo /* 2131232206 */:
                case C4215R.C4219id.tv_user_info /* 2131233218 */:
                    startActivity(new Intent(this.f1678e, UserInfoActivity.class));
                    return;
                case C4215R.C4219id.ll_qr_code /* 2131232214 */:
                case C4215R.C4219id.tv_my_qrcode /* 2131233037 */:
                    startActivity(new Intent(this.f1678e, MyQRCodeActivity.class));
                    return;
                case C4215R.C4219id.ll_set /* 2131232224 */:
                    startActivity(new Intent(this.f1678e, SystemSetActivity.class));
                    return;
                case C4215R.C4219id.ll_share /* 2131232226 */:
                    m40616g0();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m40618e0();
    }
}
