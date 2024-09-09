package com.bxkj.student.personal.bind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BindWechatQQActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/bxkj/student/personal/bind/BindWechatQQActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "", "finalLoginType", "login_id", "login_nickname", "login_avatar", "Lkotlin/f1;", "u0", "U", "", "P", "Landroid/os/Bundle;", "p0", "V", "T", "N", "Landroid/view/View;", "v", "onClick", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "iv_head", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "tv_name", "m", "tv_user_number", "Landroid/widget/Button;", "n", "Landroid/widget/Button;", "bt_wechat_bind", "o", "bt_qq_bind", "Lcom/umeng/socialize/UMAuthListener;", "p", "Lcom/umeng/socialize/UMAuthListener;", "r0", "()Lcom/umeng/socialize/UMAuthListener;", "t0", "(Lcom/umeng/socialize/UMAuthListener;)V", "umAuthListener", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BindWechatQQActivity extends BaseActivity {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ImageView f22076k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TextView f22077l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextView f22078m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Button f22079n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Button f22080o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private UMAuthListener f22081p = new UMAuthListener() { // from class: com.bxkj.student.personal.bind.BindWechatQQActivity$umAuthListener$1
        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(@NotNull SHARE_MEDIA platform, int i4) {
            Context context;
            Button button;
            Button button2;
            f0.p(platform, "platform");
            context = ((BaseActivity) BindWechatQQActivity.this).f1656h;
            Toast.makeText(context, "\u60a8\u53d6\u6d88\u4e86\u767b\u5f55", 1).show();
            button = BindWechatQQActivity.this.f22079n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f22080o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(@NotNull SHARE_MEDIA platform, int i4, @NotNull Map<String, String> data) {
            Button button;
            Button button2;
            String str;
            f0.p(platform, "platform");
            f0.p(data, "data");
            String str2 = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            String str3 = data.get("openid");
            if (str3 != null) {
                BindWechatQQActivity bindWechatQQActivity = BindWechatQQActivity.this;
                String str4 = data.get("name");
                if (str4 != null && (str = data.get("iconurl")) != null) {
                    bindWechatQQActivity.u0(str2, str3, str4, str);
                }
            }
            button = BindWechatQQActivity.this.f22079n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f22080o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(@NotNull SHARE_MEDIA platform, int i4, @NotNull Throwable t3) {
            Context context;
            Button button;
            Button button2;
            f0.p(platform, "platform");
            f0.p(t3, "t");
            j.c(t3.getMessage());
            j.d(f0.C("action=", Integer.valueOf(i4)), new Object[0]);
            context = ((BaseActivity) BindWechatQQActivity.this).f1656h;
            Toast.makeText(context, "\u767b\u5f55\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
            button = BindWechatQQActivity.this.f22079n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f22080o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(@NotNull SHARE_MEDIA platform) {
            f0.p(platform, "platform");
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BindWechatQQActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/personal/bind/BindWechatQQActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            BindWechatQQActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(BindWechatQQActivity this$0, View view) {
        f0.p(this$0, "this$0");
        UMShareAPI uMShareAPI = UMShareAPI.get(this$0.f1656h);
        FragmentActivity fragmentActivity = this$0.f1657i;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            this$0.h0("\u60a8\u8fd8\u672a\u5b89\u88c5\u5fae\u4fe1\u6216\u5fae\u4fe1\u7248\u672c\u8fc7\u4f4e");
            return;
        }
        Button button = this$0.f22079n;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(this$0.f1656h).getPlatformInfo(this$0.f1657i, share_media, this$0.r0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(BindWechatQQActivity this$0, View view) {
        f0.p(this$0, "this$0");
        UMShareAPI uMShareAPI = UMShareAPI.get(this$0.f1656h);
        FragmentActivity fragmentActivity = this$0.f1657i;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            this$0.h0("\u60a8\u8fd8\u672a\u5b89\u88c5QQ\u6216QQ\u7248\u672c\u8fc7\u4f4e");
            return;
        }
        Button button = this$0.f22080o;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(this$0.f1656h).getPlatformInfo(this$0.f1657i, share_media, this$0.r0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BindWechatQQActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(String str, String str2, String str3, String str4) {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).F0(LoginUser.getLoginUser().getUserId(), str, str2, str3, str4)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        Button button = this.f22079n;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindWechatQQActivity.p0(BindWechatQQActivity.this, view);
                }
            });
        }
        Button button2 = this.f22080o;
        if (button2 == null) {
            return;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindWechatQQActivity.q0(BindWechatQQActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427372;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        ImageView imageView;
        TextView textView = this.f22077l;
        if (textView != null) {
            textView.setText(LoginUser.getLoginUser().getRealName());
        }
        TextView textView2 = this.f22078m;
        if (textView2 != null) {
            textView2.setText(LoginUser.getLoginUser().getAccount());
        }
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        if (headImageUrl == null || (imageView = this.f22076k) == null) {
            return;
        }
        com.bumptech.glide.d.C(this.f1656h).a(headImageUrl).i1(imageView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bf7\u7ed1\u5b9a\u5fae\u4fe1\u6216QQ");
        d0("\u8df3\u8fc7", new BaseActivity.c() { // from class: com.bxkj.student.personal.bind.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                BindWechatQQActivity.s0(BindWechatQQActivity.this);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        this.f22076k = (ImageView) findViewById(2131231426);
        this.f22077l = (TextView) findViewById(2131233040);
        this.f22078m = (TextView) findViewById(2131233219);
        this.f22079n = (Button) findViewById(2131231021);
        this.f22080o = (Button) findViewById(2131230996);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        UMShareAPI.get(this).onActivityResult(i4, i5, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    @NotNull
    public final UMAuthListener r0() {
        return this.f22081p;
    }

    public final void t0(@NotNull UMAuthListener uMAuthListener) {
        f0.p(uMAuthListener, "<set-?>");
        this.f22081p = uMAuthListener;
    }
}
