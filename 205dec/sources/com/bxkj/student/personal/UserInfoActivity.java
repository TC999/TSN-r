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
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bigkoo.pickerview.b;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.v;
import com.bxkj.student.common.view.ToggleButton;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.UserInfoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.yalantis.ucrop.b;
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
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class UserInfoActivity extends BaseActivity {
    private static final int P = 221;
    private static final String Q = "temp_photo.jpg";
    private ToggleButton A;
    private ImageView B;
    private ImageView C;
    private TextView D;
    private TextView E;
    private ImageView F;
    private TextView G;
    private File I;
    private String J;
    private String K;

    /* renamed from: L  reason: collision with root package name */
    private String f22033L;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22034k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22035l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22036m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22037n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22038o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22039p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22040q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22041r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f22042s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f22043t;

    /* renamed from: u  reason: collision with root package name */
    private EditText f22044u;

    /* renamed from: v  reason: collision with root package name */
    private EditText f22045v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f22046w;

    /* renamed from: x  reason: collision with root package name */
    private EditText f22047x;

    /* renamed from: y  reason: collision with root package name */
    private Button f22048y;

    /* renamed from: z  reason: collision with root package name */
    private ToggleButton f22049z;
    private final int H = 204;
    private List<Map<String, Object>> M = new ArrayList();
    private List<Map<String, Object>> N = new ArrayList();
    UMAuthListener O = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.A.toggle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.f22049z.toggle();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage("\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
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
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage("\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.h1(userInfoActivity.F, LoginUser.getLoginUser().getHeadImageUrl());
            MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
            if (myFragment != null) {
                myFragment.f0();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements UMAuthListener {
        e() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) UserInfoActivity.this).f1656h, "\u60a8\u53d6\u6d88\u4e86\u7ed1\u5b9a", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            com.orhanobut.logger.j.c("platform=" + platform.name());
            com.orhanobut.logger.j.c("data=" + data);
            UserInfoActivity.this.m1(platform == SHARE_MEDIA.WEIXIN ? "1" : "0", data.get("openid"), data.get("name"), data.get("iconurl"));
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t3) {
            com.orhanobut.logger.j.c(t3.getMessage());
            com.orhanobut.logger.j.c("action=" + action);
            Toast.makeText(((BaseActivity) UserInfoActivity.this).f1656h, "\u7ed1\u5b9a\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22055a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22056b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22057c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f22058d;

        f(final String val$finalLoginType, final String val$login_id, final String val$login_avatar, final String val$login_nickname) {
            this.f22055a = val$finalLoginType;
            this.f22056b = val$login_id;
            this.f22057c = val$login_avatar;
            this.f22058d = val$login_nickname;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            if (this.f22055a.equals("0")) {
                UserInfoActivity.this.o1();
            } else if (this.f22055a.equals("1")) {
                UserInfoActivity.this.p1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (this.f22055a.equals("0")) {
                UserInfoActivity.this.o1();
            } else if (this.f22055a.equals("1")) {
                UserInfoActivity.this.p1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f22055a.equals("0")) {
                UserInfoActivity.this.A.setTag(this.f22056b);
                UserInfoActivity userInfoActivity = UserInfoActivity.this;
                userInfoActivity.h1(userInfoActivity.B, this.f22057c);
                UserInfoActivity.this.E.setText(this.f22058d);
            } else if (this.f22055a.equals("1")) {
                UserInfoActivity.this.f22049z.setTag(this.f22056b);
                UserInfoActivity userInfoActivity2 = UserInfoActivity.this;
                userInfoActivity2.h1(userInfoActivity2.C, this.f22057c);
                UserInfoActivity.this.D.setText(this.f22058d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22060a;

        g(final String val$type) {
            this.f22060a = val$type;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if ("1".equals(this.f22060a)) {
                UserInfoActivity.this.p1();
            } else if ("0".equals(this.f22060a)) {
                UserInfoActivity.this.o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if ("1".equals(this.f22060a)) {
                UserInfoActivity.this.p1();
            } else if ("0".equals(this.f22060a)) {
                UserInfoActivity.this.o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(this.f22060a)) {
                UserInfoActivity.this.f22049z.setTag(null);
                UserInfoActivity.this.C.setImageBitmap(null);
                UserInfoActivity.this.D.setText("");
            } else if ("0".equals(this.f22060a)) {
                UserInfoActivity.this.A.setTag(null);
                UserInfoActivity.this.B.setImageBitmap(null);
                UserInfoActivity.this.E.setText("");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.R().setVisibility(0);
            UserInfoActivity.this.i1(data);
            UserInfoActivity.this.J = JsonParse.getString(data, "photoUploaded");
            UserInfoActivity.this.K = JsonParse.getString(data, "suspId");
            UserInfoActivity.this.f22033L = JsonParse.getString(data, "sysStuDetailId");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            com.orhanobut.logger.j.c("tag_qq=" + isChecked);
            if (isChecked) {
                UserInfoActivity.this.c1();
            } else {
                UserInfoActivity.this.q1("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                UserInfoActivity.this.d1();
            } else {
                UserInfoActivity.this.q1("1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class k extends HttpCallBack {
        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ f1 b(File file) {
            com.bumptech.glide.d.C(((BaseActivity) UserInfoActivity.this).f1656h).f(file).i1(UserInfoActivity.this.F);
            UserInfoActivity.this.X0(Uri.fromFile(file));
            return null;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(UserInfoActivity.this.J)) {
                com.bxkj.base.v2.common.utils.k.f18613a.p(((BaseActivity) UserInfoActivity.this).f1657i, new l1.l() { // from class: com.bxkj.student.personal.a
                    @Override // l1.l
                    public final Object invoke(Object obj) {
                        f1 b4;
                        b4 = UserInfoActivity.k.this.b((File) obj);
                        return b4;
                    }
                });
            } else {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage("\u4e0d\u5141\u8bb8\u91cd\u590d\u4e0a\u4f20\uff0c\u5982\u6709\u7591\u95ee\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class l extends HttpCallBack {
        l() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (TextUtils.isEmpty(msg)) {
                msg = "\u670d\u52a1\u5668\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458";
            }
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class m implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f22067a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                m.this.f22067a.dismiss();
            }
        }

        m(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f22067a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f22067a.show();
            String trim = ((EditText) this.f22067a.findViewById(2131231264)).getText().toString().trim();
            if (trim.isEmpty()) {
                UserInfoActivity.this.h0("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            try {
                Http.with(((BaseActivity) UserInfoActivity.this).f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).K(LoginUser.getLoginUser().getUserId(), new v().a(trim))).setDataListener(new a());
            } catch (Exception e4) {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).f1656h).setMessage("\u9a8c\u8bc1\u5bc6\u7801\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class n extends HttpCallBack {
        n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.M = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.l1(userInfoActivity.M, UserInfoActivity.this.f22042s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class o extends HttpCallBack {
        o() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.N = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.l1(userInfoActivity.N, UserInfoActivity.this.f22043t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class p implements b.InterfaceC0157b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f22072a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f22073b;

        p(final TextView val$textView, final List val$datas) {
            this.f22072a = val$textView;
            this.f22073b = val$datas;
        }

        @Override // com.bigkoo.pickerview.b.InterfaceC0157b
        public void a(int options1, int option2, int options3, View v3) {
            this.f22072a.setTag(JsonParse.getString((Map) this.f22073b.get(options1), "id"));
            this.f22072a.setText(JsonParse.getString((Map) this.f22073b.get(options1), "name"));
        }
    }

    private void U0() {
        this.f22034k = (TextView) findViewById(2131233040);
        this.f22035l = (TextView) findViewById(2131232838);
        this.f22036m = (TextView) findViewById(2131233144);
        this.f22038o = (TextView) findViewById(2131232937);
        this.f22039p = (TextView) findViewById(2131233027);
        this.f22041r = (TextView) findViewById(2131232903);
        this.f22042s = (TextView) findViewById(2131233043);
        this.f22043t = (TextView) findViewById(2131232881);
        this.f22044u = (EditText) findViewById(2131232993);
        this.f22045v = (EditText) findViewById(2131232835);
        this.f22046w = (TextView) findViewById(2131233089);
        this.f22047x = (EditText) findViewById(2131232950);
        this.f22048y = (Button) findViewById(2131230967);
        this.f22040q = (TextView) findViewById(2131232981);
        this.f22037n = (TextView) findViewById(2131233152);
        this.f22049z = (ToggleButton) findViewById(2131232707);
        this.A = (ToggleButton) findViewById(2131232702);
        this.B = (ImageView) findViewById(2131231473);
        this.C = (ImageView) findViewById(2131231506);
        this.D = (TextView) findViewById(2131233229);
        this.E = (TextView) findViewById(2131233110);
        this.G = (TextView) findViewById(2131232948);
        this.F = (ImageView) findViewById(2131231426);
    }

    private void V0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u7ed1\u5b9a\u624b\u673a\u53f7\u9700\u8981\u9a8c\u8bc1\u4f60\u7684\u8eab\u4efd\uff0c\u8bf7\u8f93\u5165\u767b\u5f55\u5bc6\u7801\u8fdb\u884c\u9a8c\u8bc1").setCenterCustomView(2131427593).setRightButtonOnClickListener(new m(iostwobuttondialog)).show();
    }

    private void W0() {
        String trim = this.f22047x.getText().toString().trim();
        if (!trim.isEmpty() && !u.U(trim)) {
            h0("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u90ae\u7bb1");
        } else {
            Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).B0(LoginUser.getLoginUser().getUserId(), trim, this.f22042s.getTag(), this.f22043t.getTag(), this.f22044u.getText().toString().trim(), (this.f22045v.isEnabled() ? this.f22045v.getText() : this.f22045v.getTag()).toString().trim(), this.K, this.f22033L)).setDataListener(new l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(Uri uri) {
        if (uri == null) {
            return;
        }
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file = this.f1656h.getExternalCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (file == null || !file.exists()) {
            file = this.f1656h.getCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(file, "avatar");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Uri fromFile = Uri.fromFile(new File(file2, System.currentTimeMillis() + "_temp_photo.jpg"));
        b.a aVar = new b.a();
        aVar.D(ContextCompat.getColor(this.f1656h, 2131034196));
        aVar.A(ContextCompat.getColor(this.f1656h, 2131034194));
        aVar.y(ContextCompat.getColor(this.f1656h, 2131034195));
        aVar.c(ContextCompat.getColor(this.f1656h, 2131034190));
        com.yalantis.ucrop.b.i(uri, fromFile).s(aVar).q(9.0f, 16.0f).r(MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 413).k(this, 69);
    }

    private Bitmap Y0(Uri uri) {
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void Z0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).p1()).setDataListener(new n());
    }

    private void a1() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).n1()).setDataListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f1656h);
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(this, share_media)) {
            h0("\u60a8\u8fd8\u672a\u5b89\u88c5QQ\u6216QQ\u7248\u672c\u8fc7\u4f4e");
            new Thread(new a()).start();
            return;
        }
        UMShareAPI.get(this.f1656h).getPlatformInfo(this, share_media, this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f1656h);
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(this, share_media)) {
            h0("\u60a8\u8fd8\u672a\u5b89\u88c5\u5fae\u4fe1\u6216\u5fae\u4fe1\u7248\u672c\u8fc7\u4f4e");
            new Thread(new b()).start();
            return;
        }
        UMShareAPI.get(this.f1656h).getPlatformInfo(this, share_media, this.O);
    }

    private void g1() {
        this.A.setOnCheckedChangeListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(Map<String, Object> data) {
        String string = JsonParse.getString(data, "phone");
        LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
        LoginUser.getLoginUser().setRealName(JsonParse.getString(data, "name"));
        LoginUser.getLoginUser().setPhone(string);
        LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
        LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
        LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
        h1(this.F, LoginUser.getLoginUser().getHeadImageUrl());
        this.f22034k.setText(LoginUser.getLoginUser().getRealName());
        this.f22035l.setText(LoginUser.getLoginUser().getAccount());
        this.f22037n.setText("1".equals(JsonParse.getString(data, "sex")) ? "\u7537" : "\u5973");
        this.f22036m.setText(LoginUser.getLoginUser().getSchoolName());
        this.f22046w.setText(LoginUser.getLoginUser().getPhone());
        this.f22038o.setText(JsonParse.getString(data, "faculty"));
        this.f22039p.setText(JsonParse.getString(data, "profession"));
        this.f22040q.setText(JsonParse.getString(data, "grade"));
        this.f22041r.setText(JsonParse.getString(data, "class"));
        this.f22042s.setTag(JsonParse.getString(data, "nationId"));
        this.f22042s.setText(JsonParse.getString(data, "nationName"));
        this.f22043t.setTag(JsonParse.getString(data, "sourceId"));
        this.f22043t.setText(JsonParse.getString(data, "sourceName"));
        this.f22044u.setText(JsonParse.getString(data, "address"));
        this.f22045v.setText(JsonParse.getString(data, "certificate"));
        this.f22047x.setText(JsonParse.getString(data, "email"));
        if (!TextUtils.isEmpty(string)) {
            TextView textView = this.f22046w;
            textView.setText(string.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(\u66f4\u6362)");
        }
        if (!JsonParse.getString(data, "weixinId").isEmpty()) {
            this.f22049z.setTag(JsonParse.getString(data, "weixinId"));
            this.f22049z.toggle();
            h1(this.C, JsonParse.getString(data, "weixinImg"));
            this.D.setText(JsonParse.getString(data, "weixinNickName"));
        }
        if (!JsonParse.getString(data, "qqId").isEmpty()) {
            this.A.setTag(JsonParse.getString(data, "qqId"));
            this.A.toggle();
            h1(this.B, JsonParse.getString(data, "qqImg"));
            this.E.setText(JsonParse.getString(data, "qqNickName"));
        }
        j1();
        g1();
    }

    private void j1() {
        this.f22049z.setOnCheckedChangeListener(new j());
    }

    private void k1(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(final List<Map<String, Object>> datas, final TextView textView) {
        com.bigkoo.pickerview.b H = new b.a(this.f1656h, new p(textView, datas)).H();
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : datas) {
            arrayList.add(JsonParse.getString(map, "name"));
        }
        H.A(arrayList);
        H.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(final String finalLoginType, final String login_id, final String login_nickname, final String login_avatar) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).F0(LoginUser.getLoginUser().getUserId(), finalLoginType, login_id, login_nickname, login_avatar)).setDataListener(new f(finalLoginType, login_id, login_avatar, login_nickname));
    }

    public static byte[] n1(String filename) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(filename, "r").getChannel();
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        ToggleButton toggleButton = this.A;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.A.toggle();
            g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        ToggleButton toggleButton = this.f22049z;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.f22049z.toggle();
            j1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(final String type) {
        if ("1".equals(type)) {
            if (this.f22049z.getTag() == null || u.b0((String) this.f22049z.getTag())) {
                return;
            }
        } else if ("0".equals(type) && (this.A.getTag() == null || u.b0((String) this.A.getTag()))) {
            return;
        }
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).w0(type, LoginUser.getLoginUser().getUserId())).setDataListener(new g(type));
    }

    private void r1(Uri uri) {
        this.I = new File(com.bxkj.base.util.j.c(StubApp.getOrigApplicationContext(getApplicationContext()), uri));
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).s0(LoginUser.getLoginUser().getUserId(), com.bxkj.base.util.j.b(this.I.getPath()))).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22042s.setOnClickListener(this);
        this.f22043t.setOnClickListener(this);
        this.f22046w.setOnClickListener(this);
        this.f22048y.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.F.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427505;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).J0()).setDataListener(new h());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e2a\u4eba\u8d44\u6599");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        U0();
    }

    public void b1(Context context, Intent intent, Uri uri, boolean writeAble) {
        int i4 = writeAble ? 3 : 1;
        intent.addFlags(i4);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, i4);
        }
    }

    public void e1(final File file) {
        com.bumptech.glide.d.C(this.f1656h).f(file).i1(this.F);
    }

    public File f1(Context context, Bitmap bmp) {
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
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + ".png");
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

    public void h1(ImageView imageView, String url) {
        cn.bluemobi.dylan.base.utils.o.f(this.f1656h, url, imageView, 2131558617, 2131558617);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if (requestCode == 204 && resultCode == -1) {
            Bitmap Y0 = Y0(Uri.fromFile(this.I));
            this.F.setImageBitmap(Y0);
            this.I = f1(this.f1656h, Y0);
            com.bumptech.glide.d.C(this.f1656h).f(this.I).i1(this.F);
            Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).s0(LoginUser.getLoginUser().getUserId(), com.bxkj.base.util.j.b(this.I.getPath()))).setDataListener(new c());
        } else if (requestCode == 221 && resultCode == -1) {
            Uri data2 = data.getData();
            if (data2 == null) {
                return;
            }
            r1(data2);
        } else if (resultCode == -1 && requestCode == 69) {
            r1(com.yalantis.ucrop.b.e(data));
        } else if (resultCode == 96) {
            com.yalantis.ucrop.b.a(data).printStackTrace();
            new iOSOneButtonDialog(this.f1656h).setMessage("\u5934\u50cf\u88c1\u526a\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131230967:
                W0();
                return;
            case 2131231426:
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                if (TextUtils.isEmpty(headImageUrl)) {
                    return;
                }
                k1(new String[]{headImageUrl}, 1);
                return;
            case 2131232881:
                if (this.N.size() == 0) {
                    a1();
                    return;
                } else {
                    l1(this.N, this.f22043t);
                    return;
                }
            case 2131232948:
                Http.with(this.f1656h).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).y0("3")).setDataListener(new k());
                return;
            case 2131233043:
                if (this.M.size() == 0) {
                    Z0();
                    return;
                } else {
                    l1(this.M, this.f22042s);
                    return;
                }
            case 2131233089:
                V0();
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
        TextView textView = this.f22046w;
        textView.setText(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(\u66f4\u6362)");
    }
}
