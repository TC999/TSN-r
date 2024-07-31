package com.bxkj.student.personal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.MyImageLoader;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3905j;
import com.bxkj.base.util.RSAUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.ToggleButton;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.UserInfoActivity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.orhanobut.logger.C11792j;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.stub.StubApp;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class UserInfoActivity extends BaseActivity {

    /* renamed from: P */
    private static final int f18733P = 221;

    /* renamed from: Q */
    private static final String f18734Q = "temp_photo.jpg";

    /* renamed from: A */
    private ToggleButton f18735A;

    /* renamed from: B */
    private ImageView f18736B;

    /* renamed from: C */
    private ImageView f18737C;

    /* renamed from: D */
    private TextView f18738D;

    /* renamed from: E */
    private TextView f18739E;

    /* renamed from: F */
    private ImageView f18740F;

    /* renamed from: G */
    private TextView f18741G;

    /* renamed from: I */
    private File f18743I;

    /* renamed from: J */
    private String f18744J;

    /* renamed from: K */
    private String f18745K;

    /* renamed from: L */
    private String f18746L;

    /* renamed from: k */
    private TextView f18750k;

    /* renamed from: l */
    private TextView f18751l;

    /* renamed from: m */
    private TextView f18752m;

    /* renamed from: n */
    private TextView f18753n;

    /* renamed from: o */
    private TextView f18754o;

    /* renamed from: p */
    private TextView f18755p;

    /* renamed from: q */
    private TextView f18756q;

    /* renamed from: r */
    private TextView f18757r;

    /* renamed from: s */
    private TextView f18758s;

    /* renamed from: t */
    private TextView f18759t;

    /* renamed from: u */
    private EditText f18760u;

    /* renamed from: v */
    private EditText f18761v;

    /* renamed from: w */
    private TextView f18762w;

    /* renamed from: x */
    private EditText f18763x;

    /* renamed from: y */
    private Button f18764y;

    /* renamed from: z */
    private ToggleButton f18765z;

    /* renamed from: H */
    private final int f18742H = AdEventType.VIDEO_PAUSE;

    /* renamed from: M */
    private List<Map<String, Object>> f18747M = new ArrayList();

    /* renamed from: N */
    private List<Map<String, Object>> f18748N = new ArrayList();

    /* renamed from: O */
    UMAuthListener f18749O = new C5119e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC5115a implements Runnable {
        RunnableC5115a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.f18735A.toggle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC5116b implements Runnable {
        RunnableC5116b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.f18765z.toggle();
        }
    }

    /* renamed from: com.bxkj.student.personal.UserInfoActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5117c extends HttpCallBack {
        C5117c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage("上传失败，请重新再试").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5118d extends HttpCallBack {
        C5118d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage("上传失败，请重新再试").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40536h1(userInfoActivity.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
            MyFragment myFragment = (MyFragment) AppManager.m57776n().m57775o(MyFragment.class);
            if (myFragment != null) {
                myFragment.m40617f0();
            }
        }
    }

    /* renamed from: com.bxkj.student.personal.UserInfoActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5119e implements UMAuthListener {
        C5119e() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) UserInfoActivity.this).f1669h, "您取消了绑定", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            C11792j.m20470c("platform=" + platform.name());
            C11792j.m20470c("data=" + data);
            UserInfoActivity.this.m40526m1(platform == SHARE_MEDIA.WEIXIN ? "1" : "0", data.get("openid"), data.get("name"), data.get("iconurl"));
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            C11792j.m20470c(t.getMessage());
            C11792j.m20470c("action=" + action);
            Toast.makeText(((BaseActivity) UserInfoActivity.this).f1669h, "绑定失败,请稍后再试", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5120f extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f18771a;

        /* renamed from: b */
        final /* synthetic */ String f18772b;

        /* renamed from: c */
        final /* synthetic */ String f18773c;

        /* renamed from: d */
        final /* synthetic */ String f18774d;

        C5120f(final String val$finalLoginType, final String val$login_id, final String val$login_avatar, final String val$login_nickname) {
            this.f18771a = val$finalLoginType;
            this.f18772b = val$login_id;
            this.f18773c = val$login_avatar;
            this.f18774d = val$login_nickname;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            if (this.f18771a.equals("0")) {
                UserInfoActivity.this.m40522o1();
            } else if (this.f18771a.equals("1")) {
                UserInfoActivity.this.m40520p1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (this.f18771a.equals("0")) {
                UserInfoActivity.this.m40522o1();
            } else if (this.f18771a.equals("1")) {
                UserInfoActivity.this.m40520p1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f18771a.equals("0")) {
                UserInfoActivity.this.f18735A.setTag(this.f18772b);
                UserInfoActivity userInfoActivity = UserInfoActivity.this;
                userInfoActivity.m40536h1(userInfoActivity.f18736B, this.f18773c);
                UserInfoActivity.this.f18739E.setText(this.f18774d);
            } else if (this.f18771a.equals("1")) {
                UserInfoActivity.this.f18765z.setTag(this.f18772b);
                UserInfoActivity userInfoActivity2 = UserInfoActivity.this;
                userInfoActivity2.m40536h1(userInfoActivity2.f18737C, this.f18773c);
                UserInfoActivity.this.f18738D.setText(this.f18774d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5121g extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f18776a;

        C5121g(final String val$type) {
            this.f18776a = val$type;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if ("1".equals(this.f18776a)) {
                UserInfoActivity.this.m40520p1();
            } else if ("0".equals(this.f18776a)) {
                UserInfoActivity.this.m40522o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if ("1".equals(this.f18776a)) {
                UserInfoActivity.this.m40520p1();
            } else if ("0".equals(this.f18776a)) {
                UserInfoActivity.this.m40522o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(this.f18776a)) {
                UserInfoActivity.this.f18765z.setTag(null);
                UserInfoActivity.this.f18737C.setImageBitmap(null);
                UserInfoActivity.this.f18738D.setText("");
            } else if ("0".equals(this.f18776a)) {
                UserInfoActivity.this.f18735A.setTag(null);
                UserInfoActivity.this.f18736B.setImageBitmap(null);
                UserInfoActivity.this.f18739E.setText("");
            }
        }
    }

    /* renamed from: com.bxkj.student.personal.UserInfoActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5122h extends HttpCallBack {
        C5122h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.m57932R().setVisibility(0);
            UserInfoActivity.this.m40534i1(data);
            UserInfoActivity.this.f18744J = JsonParse.getString(data, "photoUploaded");
            UserInfoActivity.this.f18745K = JsonParse.getString(data, "suspId");
            UserInfoActivity.this.f18746L = JsonParse.getString(data, "sysStuDetailId");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5123i implements CompoundButton.OnCheckedChangeListener {
        C5123i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            C11792j.m20470c("tag_qq=" + isChecked);
            if (isChecked) {
                UserInfoActivity.this.m40541c1();
            } else {
                UserInfoActivity.this.m40518q1("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5124j implements CompoundButton.OnCheckedChangeListener {
        C5124j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                UserInfoActivity.this.m40540d1();
            } else {
                UserInfoActivity.this.m40518q1("1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5125k extends HttpCallBack {
        C5125k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ Unit m40506b(File file) {
            Glide.m45751C(((BaseActivity) UserInfoActivity.this).f1669h).mo45503f(file).m45551i1(UserInfoActivity.this.f18740F);
            UserInfoActivity.this.m40546X0(Uri.fromFile(file));
            return null;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(UserInfoActivity.this.f18744J)) {
                ImageSelectUtils.f15123a.m43786p(((BaseActivity) UserInfoActivity.this).f1670i, new InterfaceC15280l() { // from class: com.bxkj.student.personal.a
                    @Override // p617l1.InterfaceC15280l
                    public final Object invoke(Object obj) {
                        Unit m40506b;
                        m40506b = UserInfoActivity.C5125k.this.m40506b((File) obj);
                        return m40506b;
                    }
                });
            } else {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage("不允许重复上传，如有疑问请联系管理员").show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5126l extends HttpCallBack {
        C5126l() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (TextUtils.isEmpty(msg)) {
                msg = "服务器异常，请联系管理员";
            }
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5127m implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ iOSTwoButtonDialog f18783a;

        /* renamed from: com.bxkj.student.personal.UserInfoActivity$m$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5128a extends HttpCallBack {
            C5128a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                C5127m.this.f18783a.dismiss();
            }
        }

        C5127m(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f18783a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f18783a.show();
            String trim = ((EditText) this.f18783a.findViewById(C4215R.C4219id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                UserInfoActivity.this.m57919h0("密码不能为空");
                return;
            }
            try {
                Http.with(((BaseActivity) UserInfoActivity.this).f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m161K(LoginUser.getLoginUser().getUserId(), new RSAUtils().m44022a(trim))).setDataListener(new C5128a());
            } catch (Exception e) {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1669h).setMessage("验证密码异常，请联系管理员").show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5129n extends HttpCallBack {
        C5129n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.f18747M = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40528l1(userInfoActivity.f18747M, UserInfoActivity.this.f18758s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5130o extends HttpCallBack {
        C5130o() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.f18748N = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.m40528l1(userInfoActivity.f18748N, UserInfoActivity.this.f18759t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.UserInfoActivity$p */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5131p implements OptionsPickerView.InterfaceC3512b {

        /* renamed from: a */
        final /* synthetic */ TextView f18788a;

        /* renamed from: b */
        final /* synthetic */ List f18789b;

        C5131p(final TextView val$textView, final List val$datas) {
            this.f18788a = val$textView;
            this.f18789b = val$datas;
        }

        @Override // com.bigkoo.pickerview.OptionsPickerView.InterfaceC3512b
        /* renamed from: a */
        public void mo40505a(int options1, int option2, int options3, View v) {
            this.f18788a.setTag(JsonParse.getString((Map) this.f18789b.get(options1), "id"));
            this.f18788a.setText(JsonParse.getString((Map) this.f18789b.get(options1), "name"));
        }
    }

    /* renamed from: U0 */
    private void m40549U0() {
        this.f18750k = (TextView) findViewById(2131233040);
        this.f18751l = (TextView) findViewById(C4215R.C4219id.tv_account);
        this.f18752m = (TextView) findViewById(C4215R.C4219id.tv_school_name);
        this.f18754o = (TextView) findViewById(C4215R.C4219id.tv_department);
        this.f18755p = (TextView) findViewById(2131233027);
        this.f18757r = (TextView) findViewById(C4215R.C4219id.tv_class_name);
        this.f18758s = (TextView) findViewById(C4215R.C4219id.tv_nation);
        this.f18759t = (TextView) findViewById(C4215R.C4219id.tv_birthplace);
        this.f18760u = (EditText) findViewById(C4215R.C4219id.tv_home_address);
        this.f18761v = (EditText) findViewById(C4215R.C4219id.tv_ID_number);
        this.f18762w = (TextView) findViewById(2131233089);
        this.f18763x = (EditText) findViewById(C4215R.C4219id.tv_email);
        this.f18764y = (Button) findViewById(2131230967);
        this.f18756q = (TextView) findViewById(2131232981);
        this.f18753n = (TextView) findViewById(2131233152);
        this.f18765z = (ToggleButton) findViewById(C4215R.C4219id.tag_wechat);
        this.f18735A = (ToggleButton) findViewById(C4215R.C4219id.tag_qq);
        this.f18736B = (ImageView) findViewById(C4215R.C4219id.iv_qq_head);
        this.f18737C = (ImageView) findViewById(C4215R.C4219id.iv_wechat_head);
        this.f18738D = (TextView) findViewById(C4215R.C4219id.tv_wechat_nick_name);
        this.f18739E = (TextView) findViewById(C4215R.C4219id.tv_qq_nick_name);
        this.f18741G = (TextView) findViewById(C4215R.C4219id.tv_edit_head);
        this.f18740F = (ImageView) findViewById(2131231426);
    }

    /* renamed from: V0 */
    private void m40548V0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("绑定手机号需要验证你的身份，请输入登录密码进行验证").setCenterCustomView(C4215R.C4221layout.dialog_confim_password).setRightButtonOnClickListener(new C5127m(iostwobuttondialog)).show();
    }

    /* renamed from: W0 */
    private void m40547W0() {
        String trim = this.f18763x.getText().toString().trim();
        if (!trim.isEmpty() && !Tools.m57626U(trim)) {
            m57919h0("请输入正确的邮箱");
        } else {
            Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m185B0(LoginUser.getLoginUser().getUserId(), trim, this.f18758s.getTag(), this.f18759t.getTag(), this.f18760u.getText().toString().trim(), (this.f18761v.isEnabled() ? this.f18761v.getText() : this.f18761v.getTag()).toString().trim(), this.f18745K, this.f18746L)).setDataListener(new C5126l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public void m40546X0(Uri uri) {
        if (uri == null) {
            return;
        }
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file = this.f1669h.getExternalCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (file == null || !file.exists()) {
            file = this.f1669h.getCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(file, "avatar");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Uri fromFile = Uri.fromFile(new File(file2, System.currentTimeMillis() + "_" + f18734Q));
        UCrop.C13523a c13523a = new UCrop.C13523a();
        c13523a.m13084D(ContextCompat.getColor(this.f1669h, 2131034196));
        c13523a.m13087A(ContextCompat.getColor(this.f1669h, 2131034194));
        c13523a.m13056y(ContextCompat.getColor(this.f1669h, 2131034195));
        c13523a.m13078c(ContextCompat.getColor(this.f1669h, 2131034190));
        UCrop.m13098i(uri, fromFile).m13088s(c13523a).m13090q(9.0f, 16.0f).m13089r(295, TTAdConstant.VIDEO_INFO_CODE).m13096k(this, 69);
    }

    /* renamed from: Y0 */
    private Bitmap m40545Y0(Uri uri) {
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: Z0 */
    private void m40544Z0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m82p1()).setDataListener(new C5129n());
    }

    /* renamed from: a1 */
    private void m40543a1() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m88n1()).setDataListener(new C5130o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public void m40541c1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f1669h);
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(this, share_media)) {
            m57919h0("您还未安装QQ或QQ版本过低");
            new Thread(new RunnableC5115a()).start();
            return;
        }
        UMShareAPI.get(this.f1669h).getPlatformInfo(this, share_media, this.f18749O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1 */
    public void m40540d1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f1669h);
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(this, share_media)) {
            m57919h0("您还未安装微信或微信版本过低");
            new Thread(new RunnableC5116b()).start();
            return;
        }
        UMShareAPI.get(this.f1669h).getPlatformInfo(this, share_media, this.f18749O);
    }

    /* renamed from: g1 */
    private void m40537g1() {
        this.f18735A.setOnCheckedChangeListener(new C5123i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public void m40534i1(Map<String, Object> data) {
        String string = JsonParse.getString(data, "phone");
        LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
        LoginUser.getLoginUser().setRealName(JsonParse.getString(data, "name"));
        LoginUser.getLoginUser().setPhone(string);
        LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
        LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
        LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
        m40536h1(this.f18740F, LoginUser.getLoginUser().getHeadImageUrl());
        this.f18750k.setText(LoginUser.getLoginUser().getRealName());
        this.f18751l.setText(LoginUser.getLoginUser().getAccount());
        this.f18753n.setText("1".equals(JsonParse.getString(data, "sex")) ? "男" : "女");
        this.f18752m.setText(LoginUser.getLoginUser().getSchoolName());
        this.f18762w.setText(LoginUser.getLoginUser().getPhone());
        this.f18754o.setText(JsonParse.getString(data, "faculty"));
        this.f18755p.setText(JsonParse.getString(data, "profession"));
        this.f18756q.setText(JsonParse.getString(data, "grade"));
        this.f18757r.setText(JsonParse.getString(data, "class"));
        this.f18758s.setTag(JsonParse.getString(data, "nationId"));
        this.f18758s.setText(JsonParse.getString(data, "nationName"));
        this.f18759t.setTag(JsonParse.getString(data, "sourceId"));
        this.f18759t.setText(JsonParse.getString(data, "sourceName"));
        this.f18760u.setText(JsonParse.getString(data, "address"));
        this.f18761v.setText(JsonParse.getString(data, "certificate"));
        this.f18763x.setText(JsonParse.getString(data, NotificationCompat.CATEGORY_EMAIL));
        if (!TextUtils.isEmpty(string)) {
            TextView textView = this.f18762w;
            textView.setText(string.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(更换)");
        }
        if (!JsonParse.getString(data, "weixinId").isEmpty()) {
            this.f18765z.setTag(JsonParse.getString(data, "weixinId"));
            this.f18765z.toggle();
            m40536h1(this.f18737C, JsonParse.getString(data, "weixinImg"));
            this.f18738D.setText(JsonParse.getString(data, "weixinNickName"));
        }
        if (!JsonParse.getString(data, "qqId").isEmpty()) {
            this.f18735A.setTag(JsonParse.getString(data, "qqId"));
            this.f18735A.toggle();
            m40536h1(this.f18736B, JsonParse.getString(data, "qqImg"));
            this.f18739E.setText(JsonParse.getString(data, "qqNickName"));
        }
        m40532j1();
        m40537g1();
    }

    /* renamed from: j1 */
    private void m40532j1() {
        this.f18765z.setOnCheckedChangeListener(new C5124j());
    }

    /* renamed from: k1 */
    private void m40530k1(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public void m40528l1(final List<Map<String, Object>> datas, final TextView textView) {
        OptionsPickerView m45945H = new OptionsPickerView.C3511a(this.f1669h, new C5131p(textView, datas)).m45945H();
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : datas) {
            arrayList.add(JsonParse.getString(map, "name"));
        }
        m45945H.m45962A(arrayList);
        m45945H.m45858t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public void m40526m1(final String finalLoginType, final String login_id, final String login_nickname, final String login_avatar) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m173F0(LoginUser.getLoginUser().getUserId(), finalLoginType, login_id, login_nickname, login_avatar)).setDataListener(new C5120f(finalLoginType, login_id, login_avatar, login_nickname));
    }

    /* renamed from: n1 */
    public static byte[] m40524n1(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e) {
            e = e;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                C11792j.m20470c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public void m40522o1() {
        ToggleButton toggleButton = this.f18735A;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.f18735A.toggle();
            m40537g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public void m40520p1() {
        ToggleButton toggleButton = this.f18765z;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.f18765z.toggle();
            m40532j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public void m40518q1(final String type) {
        if ("1".equals(type)) {
            if (this.f18765z.getTag() == null || Tools.m57617b0((String) this.f18765z.getTag())) {
                return;
            }
        } else if ("0".equals(type) && (this.f18735A.getTag() == null || Tools.m57617b0((String) this.f18735A.getTag()))) {
            return;
        }
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m62w0(type, LoginUser.getLoginUser().getUserId())).setDataListener(new C5121g(type));
    }

    /* renamed from: r1 */
    private void m40516r1(Uri uri) {
        this.f18743I = new File(C3905j.m44076c(StubApp.getOrigApplicationContext(getApplicationContext()), uri));
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m74s0(LoginUser.getLoginUser().getUserId(), C3905j.m44077b(this.f18743I.getPath()))).setDataListener(new C5118d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18758s.setOnClickListener(this);
        this.f18759t.setOnClickListener(this);
        this.f18762w.setOnClickListener(this);
        this.f18764y.setOnClickListener(this);
        this.f18741G.setOnClickListener(this);
        this.f18740F.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_user_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m162J0()).setDataListener(new C5122h());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("个人资料");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m40549U0();
    }

    /* renamed from: b1 */
    public void m40542b1(Context context, Intent intent, Uri uri, boolean writeAble) {
        int i = writeAble ? 3 : 1;
        intent.addFlags(i);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, i);
        }
    }

    /* renamed from: e1 */
    public void m40539e1(final File file) {
        Glide.m45751C(this.f1669h).mo45503f(file).m45551i1(this.f18740F);
    }

    /* renamed from: f1 */
    public File m40538f1(Context context, Bitmap bmp) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bmp != null && !bmp.isRecycled()) {
            File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                externalCacheDir = context.getCacheDir();
            }
            File file = new File(externalCacheDir, "avatar");
            boolean exists = file.exists();
            if (!exists) {
                exists = file.mkdirs();
            }
            if (exists) {
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + PhotoBitmapUtils.f15141c);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                        return file2;
                    } catch (FileNotFoundException unused2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused5) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    /* renamed from: h1 */
    public void m40536h1(ImageView imageView, String url) {
        MyImageLoader.m57719f(this.f1669h, url, imageView, 2131558617, 2131558617);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if (requestCode == 204 && resultCode == -1) {
            Bitmap m40545Y0 = m40545Y0(Uri.fromFile(this.f18743I));
            this.f18740F.setImageBitmap(m40545Y0);
            this.f18743I = m40538f1(this.f1669h, m40545Y0);
            Glide.m45751C(this.f1669h).mo45503f(this.f18743I).m45551i1(this.f18740F);
            Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m74s0(LoginUser.getLoginUser().getUserId(), C3905j.m44077b(this.f18743I.getPath()))).setDataListener(new C5117c());
        } else if (requestCode == f18733P && resultCode == -1) {
            Uri data2 = data.getData();
            if (data2 == null) {
                return;
            }
            m40516r1(data2);
        } else if (resultCode == -1 && requestCode == 69) {
            m40516r1(UCrop.m13102e(data));
        } else if (resultCode == 96) {
            UCrop.m13106a(data).printStackTrace();
            new iOSOneButtonDialog(this.f1669h).setMessage("头像裁剪失败，请重新再试").show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case 2131230967:
                m40547W0();
                return;
            case 2131231426:
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                if (TextUtils.isEmpty(headImageUrl)) {
                    return;
                }
                m40530k1(new String[]{headImageUrl}, 1);
                return;
            case C4215R.C4219id.tv_birthplace /* 2131232881 */:
                if (this.f18748N.size() == 0) {
                    m40543a1();
                    return;
                } else {
                    m40528l1(this.f18748N, this.f18759t);
                    return;
                }
            case C4215R.C4219id.tv_edit_head /* 2131232948 */:
                Http.with(this.f1669h).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m56y0("3")).setDataListener(new C5125k());
                return;
            case C4215R.C4219id.tv_nation /* 2131233043 */:
                if (this.f18747M.size() == 0) {
                    m40544Z0();
                    return;
                } else {
                    m40528l1(this.f18747M, this.f18758s);
                    return;
                }
            case 2131233089:
                m40548V0();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String phone = LoginUser.getLoginUser().getPhone();
        if (TextUtils.isEmpty(phone)) {
            return;
        }
        TextView textView = this.f18762w;
        textView.setText(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(更换)");
    }
}
