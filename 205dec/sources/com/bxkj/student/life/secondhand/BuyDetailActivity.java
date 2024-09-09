package com.bxkj.student.life.secondhand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.life.lost.MyLostGoodsActivity;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import q.i;
import retrofit2.Response;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BuyDetailActivity extends BaseActivity {
    private String A;
    private String B;

    /* renamed from: k  reason: collision with root package name */
    private TextView f21817k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21818l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21819m;

    /* renamed from: n  reason: collision with root package name */
    private MyGridView f21820n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21821o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21822p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21823q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21824r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f21825s;

    /* renamed from: t  reason: collision with root package name */
    private Button f21826t;

    /* renamed from: u  reason: collision with root package name */
    private RelativeLayout f21827u;

    /* renamed from: v  reason: collision with root package name */
    private String f21828v;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Object> f21829w;

    /* renamed from: x  reason: collision with root package name */
    private List<String> f21830x;

    /* renamed from: y  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> f21831y;

    /* renamed from: z  reason: collision with root package name */
    private int f21832z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, String s3) {
            holder.t(2131231436, s3, 2131558617, 2131558617);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            BuyDetailActivity buyDetailActivity = BuyDetailActivity.this;
            buyDetailActivity.u0((String[]) buyDetailActivity.f21830x.toArray(new String[BuyDetailActivity.this.f21830x.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21835a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyLostGoodsActivity myLostGoodsActivity = (MyLostGoodsActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyLostGoodsActivity.class);
                if (myLostGoodsActivity != null) {
                    myLostGoodsActivity.w0();
                }
                if (BuyDetailActivity.this.f21826t.getText().toString().trim().equals("\u5220\u9664")) {
                    BuyDetailActivity.this.h0("\u5220\u9664\u6210\u529f");
                    SecondHandListFragment secondHandListFragment = (SecondHandListFragment) cn.bluemobi.dylan.base.utils.a.n().o(SecondHandListFragment.class);
                    if (secondHandListFragment != null) {
                        secondHandListFragment.g0();
                    }
                    BuyDetailActivity.this.finish();
                    return;
                }
                BuyDetailActivity.this.h0("\u5df2\u5173\u95ed");
                BuyDetailActivity.this.r0();
            }
        }

        c(final e val$observable) {
            this.f21835a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) BuyDetailActivity.this).f1656h).setObservable(this.f21835a).setDataListener(new a());
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
            BuyDetailActivity.this.f21827u.setVisibility(0);
            BuyDetailActivity.this.f21829w = data;
            BuyDetailActivity.this.s0();
        }
    }

    private void q0() {
        e<Response<ResponseBody>> b4;
        if (this.f21826t.getText().toString().trim().equals("\u5220\u9664")) {
            b4 = ((i) Http.getApiService(i.class)).a(this.f21828v, LoginUser.getLoginUser().getOpenId());
        } else {
            b4 = ((i) Http.getApiService(i.class)).b(this.f21828v, LoginUser.getLoginUser().getOpenId());
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u786e\u5b9a\u8981" + this.f21826t.getText().toString().trim() + "\u5417\uff1f").setRightButtonOnClickListener(new c(b4)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Http.with(this.f1656h).setObservable(((i) Http.getApiService(i.class)).g(this.f21828v, this.A)).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.f21817k.setText(JsonParse.getString(this.f21829w, "publishTime"));
        this.f21818l.setText(JsonParse.getString(this.f21829w, "goodsTypeName"));
        this.f21819m.setText(JsonParse.getString(this.f21829w, "description"));
        this.f21821o.setText(JsonParse.getString(this.f21829w, BidResponsed.KEY_PRICE));
        List<String> list = JsonParse.getList(this.f21829w, "img", String.class);
        this.f21830x = list;
        this.f21831y.c(list);
        MyGridView myGridView = this.f21820n;
        List<String> list2 = this.f21830x;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        String string = JsonParse.getString(this.f21829w, "myMotice");
        this.B = string;
        if (string.equals("Y")) {
            String string2 = JsonParse.getString(this.f21829w, "status");
            this.f21826t.setVisibility(0);
            if ("0".equals(string2)) {
                this.f21826t.setEnabled(true);
                this.f21826t.setText("\u5220\u9664");
            } else if ("1".equals(string2)) {
                this.f21826t.setEnabled(true);
                this.f21826t.setText("\u5173\u95ed");
            } else if ("2".equals(string2)) {
                this.f21826t.setEnabled(false);
                this.f21826t.setText("\u5ba1\u6838\u4e0d\u901a\u8fc7");
            } else {
                this.f21826t.setEnabled(false);
                this.f21826t.setText("\u5df2\u5173\u95ed");
            }
        }
        t0();
    }

    private void t0() {
        String string = JsonParse.getString(this.f21829w, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f21822p.getParent()).setVisibility(8);
        } else {
            ((View) this.f21822p.getParent()).setVisibility(0);
            this.f21822p.setText(string);
        }
        String string2 = JsonParse.getString(this.f21829w, "wechat");
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f21823q.getParent()).setVisibility(8);
        } else {
            ((View) this.f21823q.getParent()).setVisibility(0);
            this.f21823q.setText(string2);
        }
        String string3 = JsonParse.getString(this.f21829w, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.f21825s.getParent()).setVisibility(8);
            return;
        }
        ((View) this.f21825s.getParent()).setVisibility(0);
        this.f21825s.setText(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21826t.setOnClickListener(this);
        this.f21820n.setOnItemClickListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427374;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.A = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.f21828v = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("buyType")) {
            int intExtra = getIntent().getIntExtra("buyType", 0);
            this.f21832z = intExtra;
            if (intExtra == 0) {
                setTitle("\u6c42\u8d2d\u4fe1\u606f");
            } else {
                setTitle("\u51fa\u552e\u4fe1\u606f");
            }
        }
        a aVar = new a(this.f1656h, 2131427721, this.f21830x);
        this.f21831y = aVar;
        this.f21820n.setAdapter((ListAdapter) aVar);
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7269\u54c1\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21817k = (TextView) findViewById(2131232926);
        this.f21818l = (TextView) findViewById(2131233211);
        this.f21819m = (TextView) findViewById(2131232938);
        this.f21820n = (MyGridView) findViewById(2131231335);
        this.f21821o = (TextView) findViewById(2131233101);
        this.f21822p = (TextView) findViewById(2131233089);
        this.f21823q = (TextView) findViewById(2131233228);
        this.f21825s = (TextView) findViewById(2131233109);
        this.f21826t = (Button) findViewById(2131230965);
        this.f21824r = (TextView) findViewById(2131233048);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232527);
        this.f21827u = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131230965) {
            return;
        }
        q0();
    }
}
