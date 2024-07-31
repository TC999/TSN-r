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
import com.bxkj.student.C4215R;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BookingDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16624k;

    /* renamed from: l */
    private TextView f16625l;

    /* renamed from: m */
    private TextView f16626m;

    /* renamed from: n */
    private TextView f16627n;

    /* renamed from: o */
    private TextView f16628o;

    /* renamed from: p */
    private TextView f16629p;

    /* renamed from: q */
    private TextView f16630q;

    /* renamed from: r */
    private TextView f16631r;

    /* renamed from: s */
    private TextView f16632s;

    /* renamed from: t */
    private TextView f16633t;

    /* renamed from: u */
    private Button f16634u;

    /* renamed from: v */
    private String f16635v;

    /* renamed from: w */
    private String f16636w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.BookingDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4405a extends HttpCallBack {
        C4405a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.m57932R().setVisibility(0);
            BookingDetailActivity.this.f16636w = JsonParse.getString(data, "activityId");
            BookingDetailActivity.this.f16624k.setText(JsonParse.getString(data, "name"));
            BookingDetailActivity.this.f16625l.setText(JsonParse.getString(data, "term"));
            BookingDetailActivity.this.f16626m.setText(JsonParse.getString(data, "totalNum"));
            BookingDetailActivity.this.f16627n.setText(JsonParse.getString(data, "defaultRoleScore"));
            BookingDetailActivity.this.f16628o.setText(JsonParse.getString(data, "defaultCourseNum"));
            BookingDetailActivity.this.f16629p.setText(JsonParse.getString(data, "type"));
            BookingDetailActivity.this.f16630q.setText(JsonParse.getString(data, "address"));
            TextView textView = BookingDetailActivity.this.f16631r;
            textView.setText(JsonParse.getString(data, "appointmentBeginTime") + "-" + JsonParse.getString(data, "appointmentEndTime"));
            TextView textView2 = BookingDetailActivity.this.f16632s;
            textView2.setText(JsonParse.getString(data, "actBeginTime") + "-" + JsonParse.getString(data, "actEndTime"));
            BookingDetailActivity.this.f16633t.setText(Html.fromHtml(JsonParse.getString(data, "memo")));
            if (JsonParse.getInt(data, "zhuangtai") == 0) {
                BookingDetailActivity.this.f16634u.setEnabled(true);
                BookingDetailActivity.this.f16634u.setText("预约");
            } else if (JsonParse.getInt(data, "zhuangtai") == 1) {
                BookingDetailActivity.this.f16634u.setEnabled(true);
                BookingDetailActivity.this.f16634u.setText("取消预约");
            } else if (JsonParse.getInt(data, "zhuangtai") == 2) {
                BookingDetailActivity.this.f16634u.setEnabled(false);
                BookingDetailActivity.this.f16634u.setText("人数已满");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.BookingDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4406b extends HttpCallBack {
        C4406b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                BookingDetailActivity.this.startActivity(new Intent(((BaseActivity) BookingDetailActivity.this).f1669h, BookingLessonActivity.class).putExtra("id", BookingDetailActivity.this.f16635v));
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.f16634u.setText("取消预约");
            BookingDetailActivity.this.m42454B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.BookingDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4407c extends HttpCallBack {
        C4407c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.f16634u.setText("预约");
            BookingDetailActivity.this.m42454B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m42453C0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m171G(LoginUser.getLoginUser().getUserId(), this.f16636w)).setDataListener(new C4407c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m42454B0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m57y(LoginUser.getLoginUser().getUserId(), this.f16635v)).setDataListener(new C4405a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void m42452D0(View view) {
        if (this.f16634u.getText().toString().trim().equals("预约")) {
            m42434z0();
        } else if (this.f16634u.getText().toString().trim().equals("取消预约")) {
            new iOSTwoButtonDialog(this.f1669h).setMessage("确定要取消预约吗?").setLeftButtonText("我再想想").setRightButtonText("直接取消").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.activity.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    BookingDetailActivity.this.m42453C0();
                }
            }).show();
        }
    }

    /* renamed from: z0 */
    private void m42434z0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m97k1(LoginUser.getLoginUser().getUserId(), this.f16635v)).setDataListener(new C4406b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16634u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookingDetailActivity.this.m42452D0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_booking_activity_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f16635v = getIntent().getStringExtra("id");
        }
        m57932R().setVisibility(4);
        m42454B0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("活动详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16624k = (TextView) findViewById(C4215R.C4219id.tv1);
        this.f16625l = (TextView) findViewById(C4215R.C4219id.tv2);
        this.f16626m = (TextView) findViewById(C4215R.C4219id.tv3);
        this.f16627n = (TextView) findViewById(C4215R.C4219id.tv4);
        this.f16628o = (TextView) findViewById(C4215R.C4219id.tv5);
        this.f16629p = (TextView) findViewById(C4215R.C4219id.tv6);
        this.f16630q = (TextView) findViewById(C4215R.C4219id.tv7);
        this.f16631r = (TextView) findViewById(C4215R.C4219id.tv8);
        this.f16632s = (TextView) findViewById(C4215R.C4219id.tv9);
        this.f16633t = (TextView) findViewById(C4215R.C4219id.tv10);
        this.f16634u = (Button) findViewById(C4215R.C4219id.f15992bt);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m42454B0();
    }
}
