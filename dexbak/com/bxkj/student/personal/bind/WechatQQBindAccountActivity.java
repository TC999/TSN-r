package com.bxkj.student.personal.bind;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bumptech.glide.Glide;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.student.C4215R;
import com.bxkj.student.personal.login.LoginUtils;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p653w.InterfaceC16236a;

/* compiled from: WechatQQBindAccountActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015¨\u0006\u001d"}, m12616d2 = {"Lcom/bxkj/student/personal/bind/WechatQQBindAccountActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "l0", "U", "", "P", "Landroid/os/Bundle;", C7202bq.f24604g, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "N", "Landroid/view/View;", "v", "onClick", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "iv_head", "Landroid/widget/TextView;", C7304t.f25048d, "Landroid/widget/TextView;", "tv_nick_name", "m", "et_name", "n", "et_account", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WechatQQBindAccountActivity extends BaseActivity {
    @Nullable

    /* renamed from: k */
    private ImageView f18800k;
    @Nullable

    /* renamed from: l */
    private TextView f18801l;
    @Nullable

    /* renamed from: m */
    private TextView f18802m;
    @Nullable

    /* renamed from: n */
    private TextView f18803n;

    /* compiled from: WechatQQBindAccountActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000f"}, m12616d2 = {"com/bxkj/student/personal/bind/WechatQQBindAccountActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "status", "msg", "netOnOtherStatus", "", "ex", "netOnFailure", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.personal.bind.WechatQQBindAccountActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5134a extends HttpCallBack {
        C5134a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(@NotNull Throwable ex) {
            C14342f0.m8184p(ex, "ex");
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i, @NotNull String msg) {
            C14342f0.m8184p(msg, "msg");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            LoginUtils.m40420b(((BaseActivity) WechatQQBindAccountActivity.this).f1670i, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public static final void m40489k0(WechatQQBindAccountActivity this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m40488l0();
    }

    /* renamed from: l0 */
    private final void m40488l0() {
        CharSequence m6523E5;
        String obj;
        CharSequence m6523E52;
        TextView textView = this.f18802m;
        String str = "";
        if (textView == null) {
            obj = "";
        } else {
            String obj2 = textView.getText().toString();
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            m6523E5 = C14579x.m6523E5(obj2);
            obj = m6523E5.toString();
        }
        TextView textView2 = this.f18803n;
        if (textView2 != null) {
            String obj3 = textView2.getText().toString();
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            m6523E52 = C14579x.m6523E5(obj3);
            str = m6523E52.toString();
        }
        String str2 = str;
        if ((TextUtils.isEmpty(obj) ? this : null) == null) {
            if ((TextUtils.isEmpty(str2) ? this : null) == null) {
                Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m166H1(str2, obj, getIntent().getStringExtra("login_type"), getIntent().getStringExtra("openid"), getIntent().getStringExtra("name"), getIntent().getStringExtra("iconurl"))).setDataListener(new C5134a());
                return;
            }
            Context mContext = this.f1669h;
            C14342f0.m8185o(mContext, "mContext");
            ContextExt.m43851m(mContext, "请输入学号！");
            return;
        }
        Context mContext2 = this.f1669h;
        C14342f0.m8185o(mContext2, "mContext");
        ContextExt.m43851m(mContext2, "请输入姓名！");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        ((Button) findViewById(C4215R.C4219id.bt_login)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WechatQQBindAccountActivity.m40489k0(WechatQQBindAccountActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_bind_wechat_qq;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        TextView textView;
        ImageView imageView;
        if ((getIntent().hasExtra("iconurl") ? this : null) != null && (imageView = this.f18800k) != null) {
            Glide.m45751C(this.f1669h).mo45507a(getIntent().getStringExtra("iconurl")).m45551i1(imageView);
        }
        if ((getIntent().hasExtra("name") ? this : null) == null || (textView = this.f18801l) == null) {
            return;
        }
        textView.setText(getIntent().getStringExtra("name"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("绑定账号");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        this.f18800k = (ImageView) findViewById(2131231426);
        this.f18801l = (TextView) findViewById(C4215R.C4219id.tv_nick_name);
        this.f18802m = (TextView) findViewById(C4215R.C4219id.et_name);
        this.f18803n = (TextView) findViewById(C4215R.C4219id.et_account);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
