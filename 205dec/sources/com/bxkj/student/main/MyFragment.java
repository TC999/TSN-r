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
import cn.bluemobi.dylan.base.utils.o;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.SystemSetActivity;
import com.bxkj.student.personal.UserInfoActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.sign.SignInActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.bxkj.student.v2.ui.my.AdSwitchActivity;
import com.orhanobut.logger.j;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import java.util.UUID;
import kotlin.f1;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyFragment extends BaseFragment {
    private Button A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;

    /* renamed from: h  reason: collision with root package name */
    private Button f21946h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f21947i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f21948j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f21949k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21950l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21951m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21952n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21953o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21954p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f21955q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f21956r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f21957s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f21958t = false;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f21959u;

    /* renamed from: v  reason: collision with root package name */
    private LinearLayout f21960v;

    /* renamed from: w  reason: collision with root package name */
    private LinearLayout f21961w;

    /* renamed from: x  reason: collision with root package name */
    private LinearLayout f21962x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f21963y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f21964z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements iOSTwoButtonDialog.RightButtonOnClick {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            com.bxkj.student.personal.login.c.c();
            MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1665e, LoginActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a extends HttpCallBack {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ f1 b() {
                MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1665e, FaceDetect5ExpActivity.class));
                return null;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                g.c(MyFragment.this.getActivity(), "\u4eba\u8138\u91c7\u96c6", new l1.a() { // from class: com.bxkj.student.main.f
                    public final Object invoke() {
                        f1 b4;
                        b4 = MyFragment.b.a.this.b();
                        return b4;
                    }
                });
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Http.with(((BaseFragment) MyFragment.this).f1665e).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).w(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements ShareBoardlistener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseFragment) MyFragment.this).f1665e, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t3) {
                t3.printStackTrace();
                Toast.makeText(((BaseFragment) MyFragment.this).f1665e, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
            uMWeb.setTitle("\u6821\u56ed\u751f\u6d3b\u5982\u6b64\u7b80\u5355");
            uMWeb.setThumb(new UMImage(((BaseFragment) MyFragment.this).f1665e, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(MyFragment.this.getString(2131821569));
            new ShareAction(MyFragment.this.getActivity()).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyFragment.this.f21955q.setVisibility(JsonParse.getInt(data, "data") > 0 ? 0 : 8);
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
            LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
            LoginUser.getLoginUser().setRealName(JsonParse.getString(data, "name"));
            LoginUser.getLoginUser().setPhone(JsonParse.getString(data, "phone"));
            LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
            LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            MyFragment.this.f0();
        }
    }

    private void X() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=884165111")));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1665e).setMessage("\u8bf7\u5148\u5b89\u88c5QQ\uff01").show();
        }
    }

    private void Y() {
        Http.with(this.f1665e).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).y0("2")).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        startActivity(new Intent(this.f1665e, AdSwitchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i4, Intent intent) {
        j.c("\u4eba\u8138\u8bc6\u522b\u56de\u8c03resultCode=" + i4);
        if (i4 == -1) {
            new iOSOneButtonDialog(this.f1665e).setMessage("\u4eba\u8138\u9a8c\u8bc1\u6210\u529f").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 d0() {
        Intent intent = new Intent(this.f1665e, FaceDetectExpActivity.class);
        intent.putExtra("identify", UUID.randomUUID().toString());
        intent.putExtra("isShowSuccessMessage", false);
        new m.b(this).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.main.e
            @Override // m.b.a
            public final void a(int i4, Intent intent2) {
                MyFragment.this.c0(i4, intent2);
            }
        });
        return null;
    }

    private void e0() {
        if (this.f21958t) {
            if (LoginUser.getLoginUser().isLogin()) {
                f0();
                this.A.setText("\u9000\u51fa");
                return;
            }
            o.f(this.f1665e, LoginUser.getLoginUser().getHeadImageUrl(), this.f21959u, 2131558617, 2131558617);
            this.f21963y.setText("\u672a\u767b\u5f55");
            this.f21964z.setText("\u8bf7\u767b\u5f55");
            this.A.setText("\u767b\u5f55");
        }
    }

    private void g0() {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new c()).open();
    }

    public void Z() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1665e).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((q.f) Http.getApiService(q.f.class)).h(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new d());
        }
    }

    public void a0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1665e).setObservable(((w.a) Http.getApiService(w.a.class)).J0()).setDataListener(new e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21946h.setOnClickListener(this);
        this.f21947i.setOnClickListener(this);
        this.f21948j.setOnClickListener(this);
        this.f21949k.setOnClickListener(this);
        this.f21950l.setOnClickListener(this);
        this.f21951m.setOnClickListener(this);
        this.f21952n.setOnClickListener(this);
        this.f21953o.setOnClickListener(this);
        this.f21954p.setOnClickListener(this);
        this.f21959u.setOnClickListener(this);
        this.f21963y.setOnClickListener(this);
        this.f21964z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.f21956r.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.f21960v.setOnClickListener(this);
        this.f21961w.setOnClickListener(this);
        this.f21957s.setOnClickListener(this);
        this.f21962x.setOnClickListener(this);
        c(2131232212).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.main.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment.this.b0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        a0();
        e0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21946h = (Button) c(2131230985);
        this.f21947i = (TextView) c(2131233218);
        this.f21948j = (TextView) c(2131233140);
        this.f21949k = (TextView) c(2131233189);
        this.f21950l = (TextView) c(2131230743);
        this.f21951m = (TextView) c(2131232990);
        this.f21952n = (TextView) c(2131233153);
        this.f21953o = (TextView) c(2131233037);
        this.f21954p = (TextView) c(2131232965);
        this.f21959u = (ImageView) c(2131231426);
        this.f21963y = (TextView) c(2131233040);
        this.f21964z = (TextView) c(2131233051);
        this.A = (Button) c(2131230986);
        this.B = (LinearLayout) c(2131232189);
        this.D = (LinearLayout) c(2131232226);
        this.C = (LinearLayout) c(2131232224);
        this.E = (LinearLayout) c(2131232206);
        this.f21956r = (LinearLayout) c(2131232177);
        this.F = (LinearLayout) c(2131232199);
        this.G = (LinearLayout) c(2131232214);
        this.f21960v = (LinearLayout) c(2131232187);
        this.f21961w = (LinearLayout) c(2131232166);
        this.f21957s = (LinearLayout) c(2131232188);
        this.f21962x = (LinearLayout) c(2131232211);
        this.f21955q = (ImageView) c(2131231460);
        this.f21958t = true;
        Z();
    }

    public void f0() {
        o.f(this.f1665e, LoginUser.getLoginUser().getHeadImageUrl(), this.f21959u, 2131558617, 2131558617);
        this.f21963y.setText(LoginUser.getLoginUser().getRealName());
        this.f21964z.setText(LoginUser.getLoginUser().getAccount());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427637;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() == 2131232166) {
            startActivity(new Intent(this.f1665e, H5DetailActivity.class).putExtra("title", "\u7528\u6237\u534f\u8bae").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
        } else if (v3.getId() == 2131232211) {
            startActivity(new Intent(this.f1665e, H5DetailActivity.class).putExtra("title", "\u9690\u79c1\u653f\u7b56").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
        } else if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1665e, LoginActivity.class));
        } else {
            switch (v3.getId()) {
                case 2131230986:
                    new iOSTwoButtonDialog(this.f1665e).setTitle("\u63d0\u793a").setMessage("\u60a8\u786e\u5b9a\u8981\u9000\u51fa\u767b\u5f55\u5417\uff1f").setRightButtonOnClickListener(new a()).show();
                    return;
                case 2131231426:
                case 2131233040:
                case 2131233051:
                    startActivity(new Intent(this.f1665e, UserInfoActivity.class));
                    return;
                case 2131232187:
                    Y();
                    return;
                case 2131232188:
                    g.c(getActivity(), "\u4eba\u8138\u9a8c\u8bc1", new l1.a() { // from class: com.bxkj.student.main.d
                        public final Object invoke() {
                            f1 d02;
                            d02 = MyFragment.this.d0();
                            return d02;
                        }
                    });
                    return;
                case 2131232189:
                    X();
                    return;
                case 2131232199:
                    startActivity(new Intent(this.f1665e, SignInActivity.class));
                    return;
                case 2131232206:
                case 2131233218:
                    startActivity(new Intent(this.f1665e, UserInfoActivity.class));
                    return;
                case 2131232214:
                case 2131233037:
                    startActivity(new Intent(this.f1665e, MyQRCodeActivity.class));
                    return;
                case 2131232224:
                    startActivity(new Intent(this.f1665e, SystemSetActivity.class));
                    return;
                case 2131232226:
                    g0();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e0();
    }
}
