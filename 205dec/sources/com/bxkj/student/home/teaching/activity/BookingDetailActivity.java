package com.bxkj.student.home.teaching.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BookingDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20014k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20015l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20016m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20017n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20018o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f20019p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20020q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20021r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20022s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f20023t;

    /* renamed from: u  reason: collision with root package name */
    private Button f20024u;

    /* renamed from: v  reason: collision with root package name */
    private String f20025v;

    /* renamed from: w  reason: collision with root package name */
    private String f20026w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.R().setVisibility(0);
            BookingDetailActivity.this.f20026w = JsonParse.getString(data, "activityId");
            BookingDetailActivity.this.f20014k.setText(JsonParse.getString(data, "name"));
            BookingDetailActivity.this.f20015l.setText(JsonParse.getString(data, "term"));
            BookingDetailActivity.this.f20016m.setText(JsonParse.getString(data, "totalNum"));
            BookingDetailActivity.this.f20017n.setText(JsonParse.getString(data, "defaultRoleScore"));
            BookingDetailActivity.this.f20018o.setText(JsonParse.getString(data, "defaultCourseNum"));
            BookingDetailActivity.this.f20019p.setText(JsonParse.getString(data, "type"));
            BookingDetailActivity.this.f20020q.setText(JsonParse.getString(data, "address"));
            TextView textView = BookingDetailActivity.this.f20021r;
            textView.setText(JsonParse.getString(data, "appointmentBeginTime") + "-" + JsonParse.getString(data, "appointmentEndTime"));
            TextView textView2 = BookingDetailActivity.this.f20022s;
            textView2.setText(JsonParse.getString(data, "actBeginTime") + "-" + JsonParse.getString(data, "actEndTime"));
            BookingDetailActivity.this.f20023t.setText(Html.fromHtml(JsonParse.getString(data, "memo")));
            if (JsonParse.getInt(data, "zhuangtai") == 0) {
                BookingDetailActivity.this.f20024u.setEnabled(true);
                BookingDetailActivity.this.f20024u.setText("\u9884\u7ea6");
            } else if (JsonParse.getInt(data, "zhuangtai") == 1) {
                BookingDetailActivity.this.f20024u.setEnabled(true);
                BookingDetailActivity.this.f20024u.setText("\u53d6\u6d88\u9884\u7ea6");
            } else if (JsonParse.getInt(data, "zhuangtai") == 2) {
                BookingDetailActivity.this.f20024u.setEnabled(false);
                BookingDetailActivity.this.f20024u.setText("\u4eba\u6570\u5df2\u6ee1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                BookingDetailActivity.this.startActivity(new Intent(((BaseActivity) BookingDetailActivity.this).f1656h, BookingLessonActivity.class).putExtra("id", BookingDetailActivity.this.f20025v));
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.f20024u.setText("\u53d6\u6d88\u9884\u7ea6");
            BookingDetailActivity.this.B0();
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.f20024u.setText("\u9884\u7ea6");
            BookingDetailActivity.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void C0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).G(LoginUser.getLoginUser().getUserId(), this.f20026w)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).y(LoginUser.getLoginUser().getUserId(), this.f20025v)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        if (this.f20024u.getText().toString().trim().equals("\u9884\u7ea6")) {
            z0();
        } else if (this.f20024u.getText().toString().trim().equals("\u53d6\u6d88\u9884\u7ea6")) {
            new iOSTwoButtonDialog(this.f1656h).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u9884\u7ea6\u5417?").setLeftButtonText("\u6211\u518d\u60f3\u60f3").setRightButtonText("\u76f4\u63a5\u53d6\u6d88").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.activity.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    BookingDetailActivity.this.C0();
                }
            }).show();
        }
    }

    private void z0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).k1(LoginUser.getLoginUser().getUserId(), this.f20025v)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20024u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookingDetailActivity.this.D0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427373;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f20025v = getIntent().getStringExtra("id");
        }
        R().setVisibility(4);
        B0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6d3b\u52a8\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20014k = (TextView) findViewById(2131232819);
        this.f20015l = (TextView) findViewById(2131232822);
        this.f20016m = (TextView) findViewById(2131232824);
        this.f20017n = (TextView) findViewById(2131232826);
        this.f20018o = (TextView) findViewById(2131232827);
        this.f20019p = (TextView) findViewById(2131232828);
        this.f20020q = (TextView) findViewById(2131232829);
        this.f20021r = (TextView) findViewById(2131232830);
        this.f20022s = (TextView) findViewById(2131232831);
        this.f20023t = (TextView) findViewById(2131232820);
        this.f20024u = (Button) findViewById(2131230949);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        B0();
    }
}
