package com.bxkj.student.personal.bind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bumptech.glide.Glide;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p653w.InterfaceC16236a;

/* compiled from: BindWechatQQActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00063"}, m12616d2 = {"Lcom/bxkj/student/personal/bind/BindWechatQQActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "", "finalLoginType", "login_id", "login_nickname", "login_avatar", "Lkotlin/f1;", "u0", "U", "", "P", "Landroid/os/Bundle;", C7202bq.f24604g, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "N", "Landroid/view/View;", "v", "onClick", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "iv_head", "Landroid/widget/TextView;", C7304t.f25048d, "Landroid/widget/TextView;", "tv_name", "m", "tv_user_number", "Landroid/widget/Button;", "n", "Landroid/widget/Button;", "bt_wechat_bind", "o", "bt_qq_bind", "Lcom/umeng/socialize/UMAuthListener;", "p", "Lcom/umeng/socialize/UMAuthListener;", "r0", "()Lcom/umeng/socialize/UMAuthListener;", "t0", "(Lcom/umeng/socialize/UMAuthListener;)V", "umAuthListener", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BindWechatQQActivity extends BaseActivity {
    @Nullable

    /* renamed from: k */
    private ImageView f18792k;
    @Nullable

    /* renamed from: l */
    private TextView f18793l;
    @Nullable

    /* renamed from: m */
    private TextView f18794m;
    @Nullable

    /* renamed from: n */
    private Button f18795n;
    @Nullable

    /* renamed from: o */
    private Button f18796o;
    @NotNull

    /* renamed from: p */
    private UMAuthListener f18797p = new UMAuthListener() { // from class: com.bxkj.student.personal.bind.BindWechatQQActivity$umAuthListener$1
        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(@NotNull SHARE_MEDIA platform, int i) {
            Context context;
            Button button;
            Button button2;
            C14342f0.m8184p(platform, "platform");
            context = ((BaseActivity) BindWechatQQActivity.this).f1669h;
            Toast.makeText(context, "您取消了登录", 1).show();
            button = BindWechatQQActivity.this.f18795n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f18796o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(@NotNull SHARE_MEDIA platform, int i, @NotNull Map<String, String> data) {
            Button button;
            Button button2;
            String str;
            C14342f0.m8184p(platform, "platform");
            C14342f0.m8184p(data, "data");
            String str2 = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            String str3 = data.get("openid");
            if (str3 != null) {
                BindWechatQQActivity bindWechatQQActivity = BindWechatQQActivity.this;
                String str4 = data.get("name");
                if (str4 != null && (str = data.get("iconurl")) != null) {
                    bindWechatQQActivity.m40492u0(str2, str3, str4, str);
                }
            }
            button = BindWechatQQActivity.this.f18795n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f18796o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(@NotNull SHARE_MEDIA platform, int i, @NotNull Throwable t) {
            Context context;
            Button button;
            Button button2;
            C14342f0.m8184p(platform, "platform");
            C14342f0.m8184p(t, "t");
            C11792j.m20470c(t.getMessage());
            C11792j.m20469d(C14342f0.m8216C("action=", Integer.valueOf(i)), new Object[0]);
            context = ((BaseActivity) BindWechatQQActivity.this).f1669h;
            Toast.makeText(context, "登录失败,请稍后再试", 1).show();
            button = BindWechatQQActivity.this.f18795n;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f18796o;
            if (button2 == null) {
                return;
            }
            button2.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(@NotNull SHARE_MEDIA platform) {
            C14342f0.m8184p(platform, "platform");
        }
    };

    /* compiled from: BindWechatQQActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/personal/bind/BindWechatQQActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.personal.bind.BindWechatQQActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5133a extends HttpCallBack {
        C5133a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            BindWechatQQActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public static final void m40497p0(BindWechatQQActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        UMShareAPI uMShareAPI = UMShareAPI.get(this$0.f1669h);
        FragmentActivity fragmentActivity = this$0.f1670i;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            this$0.m57919h0("您还未安装微信或微信版本过低");
            return;
        }
        Button button = this$0.f18795n;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(this$0.f1669h).getPlatformInfo(this$0.f1670i, share_media, this$0.m40495r0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public static final void m40496q0(BindWechatQQActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        UMShareAPI uMShareAPI = UMShareAPI.get(this$0.f1669h);
        FragmentActivity fragmentActivity = this$0.f1670i;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            this$0.m57919h0("您还未安装QQ或QQ版本过低");
            return;
        }
        Button button = this$0.f18796o;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(this$0.f1669h).getPlatformInfo(this$0.f1670i, share_media, this$0.m40495r0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public static final void m40494s0(BindWechatQQActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public final void m40492u0(String str, String str2, String str3, String str4) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m173F0(LoginUser.getLoginUser().getUserId(), str, str2, str3, str4)).setDataListener(new C5133a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        Button button = this.f18795n;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindWechatQQActivity.m40497p0(BindWechatQQActivity.this, view);
                }
            });
        }
        Button button2 = this.f18796o;
        if (button2 == null) {
            return;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindWechatQQActivity.m40496q0(BindWechatQQActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_bind_wechat_qq2;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        ImageView imageView;
        TextView textView = this.f18793l;
        if (textView != null) {
            textView.setText(LoginUser.getLoginUser().getRealName());
        }
        TextView textView2 = this.f18794m;
        if (textView2 != null) {
            textView2.setText(LoginUser.getLoginUser().getAccount());
        }
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        if (headImageUrl == null || (imageView = this.f18792k) == null) {
            return;
        }
        Glide.m45751C(this.f1669h).mo45507a(headImageUrl).m45551i1(imageView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("请绑定微信或QQ");
        m57923d0("跳过", new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.personal.bind.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                BindWechatQQActivity.m40494s0(BindWechatQQActivity.this);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        this.f18792k = (ImageView) findViewById(2131231426);
        this.f18793l = (TextView) findViewById(2131233040);
        this.f18794m = (TextView) findViewById(C4215R.C4219id.tv_user_number);
        this.f18795n = (Button) findViewById(C4215R.C4219id.bt_wechat_bind);
        this.f18796o = (Button) findViewById(C4215R.C4219id.bt_qq_bind);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        UMShareAPI.get(this).onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    @NotNull
    /* renamed from: r0 */
    public final UMAuthListener m40495r0() {
        return this.f18797p;
    }

    /* renamed from: t0 */
    public final void m40493t0(@NotNull UMAuthListener uMAuthListener) {
        C14342f0.m8184p(uMAuthListener, "<set-?>");
        this.f18797p = uMAuthListener;
    }
}
