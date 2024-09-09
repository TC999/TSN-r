package com.bxkj.student.personal.bind;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: WechatQQBindAccountActivity.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/bxkj/student/personal/bind/WechatQQBindAccountActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "l0", "U", "", "P", "Landroid/os/Bundle;", "p0", "V", "T", "N", "Landroid/view/View;", "v", "onClick", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "iv_head", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "tv_nick_name", "m", "et_name", "n", "et_account", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class WechatQQBindAccountActivity extends BaseActivity {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ImageView f22084k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TextView f22085l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextView f22086m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private TextView f22087n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: WechatQQBindAccountActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/bxkj/student/personal/bind/WechatQQBindAccountActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "status", "msg", "netOnOtherStatus", "", "ex", "netOnFailure", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(@NotNull Throwable ex) {
            f0.p(ex, "ex");
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i4, @NotNull String msg) {
            f0.p(msg, "msg");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            com.bxkj.student.personal.login.c.b(((BaseActivity) WechatQQBindAccountActivity.this).f1657i, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(WechatQQBindAccountActivity this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.l0();
    }

    private final void l0() {
        CharSequence E5;
        String obj;
        CharSequence E52;
        TextView textView = this.f22086m;
        String str = "";
        if (textView == null) {
            obj = "";
        } else {
            String obj2 = textView.getText().toString();
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            E5 = x.E5(obj2);
            obj = E5.toString();
        }
        TextView textView2 = this.f22087n;
        if (textView2 != null) {
            String obj3 = textView2.getText().toString();
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            E52 = x.E5(obj3);
            str = E52.toString();
        }
        String str2 = str;
        if ((TextUtils.isEmpty(obj) ? this : null) == null) {
            if ((TextUtils.isEmpty(str2) ? this : null) == null) {
                Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).H1(str2, obj, getIntent().getStringExtra("login_type"), getIntent().getStringExtra("openid"), getIntent().getStringExtra("name"), getIntent().getStringExtra("iconurl"))).setDataListener(new a());
                return;
            }
            Context mContext = this.f1656h;
            f0.o(mContext, "mContext");
            ContextExtKt.m(mContext, "\u8bf7\u8f93\u5165\u5b66\u53f7\uff01");
            return;
        }
        Context mContext2 = this.f1656h;
        f0.o(mContext2, "mContext");
        ContextExtKt.m(mContext2, "\u8bf7\u8f93\u5165\u59d3\u540d\uff01");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        ((Button) findViewById(2131230984)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WechatQQBindAccountActivity.k0(WechatQQBindAccountActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427371;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        TextView textView;
        ImageView imageView;
        if ((getIntent().hasExtra("iconurl") ? this : null) != null && (imageView = this.f22084k) != null) {
            com.bumptech.glide.d.C(this.f1656h).a(getIntent().getStringExtra("iconurl")).i1(imageView);
        }
        if ((getIntent().hasExtra("name") ? this : null) == null || (textView = this.f22085l) == null) {
            return;
        }
        textView.setText(getIntent().getStringExtra("name"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ed1\u5b9a\u8d26\u53f7");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        this.f22084k = (ImageView) findViewById(2131231426);
        this.f22085l = (TextView) findViewById(2131233044);
        this.f22086m = (TextView) findViewById(2131231260);
        this.f22087n = (TextView) findViewById(2131231250);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
