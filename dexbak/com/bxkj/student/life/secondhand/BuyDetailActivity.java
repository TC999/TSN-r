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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.lost.MyLostGoodsActivity;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.tencent.open.SocialConstants;
import com.tencent.p562mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p635q.SecondHandApiService;
import p640rx.Observable;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BuyDetailActivity extends BaseActivity {

    /* renamed from: A */
    private String f18508A;

    /* renamed from: B */
    private String f18509B;

    /* renamed from: k */
    private TextView f18510k;

    /* renamed from: l */
    private TextView f18511l;

    /* renamed from: m */
    private TextView f18512m;

    /* renamed from: n */
    private MyGridView f18513n;

    /* renamed from: o */
    private TextView f18514o;

    /* renamed from: p */
    private TextView f18515p;

    /* renamed from: q */
    private TextView f18516q;

    /* renamed from: r */
    private TextView f18517r;

    /* renamed from: s */
    private TextView f18518s;

    /* renamed from: t */
    private Button f18519t;

    /* renamed from: u */
    private RelativeLayout f18520u;

    /* renamed from: v */
    private String f18521v;

    /* renamed from: w */
    private Map<String, Object> f18522w;

    /* renamed from: x */
    private List<String> f18523x;

    /* renamed from: y */
    private CommonAdapter<String> f18524y;

    /* renamed from: z */
    private int f18525z;

    /* renamed from: com.bxkj.student.life.secondhand.BuyDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5042a extends CommonAdapter<String> {
        C5042a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String s) {
            holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.BuyDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5043b implements AdapterView.OnItemClickListener {
        C5043b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            BuyDetailActivity buyDetailActivity = BuyDetailActivity.this;
            buyDetailActivity.m40750u0((String[]) buyDetailActivity.f18523x.toArray(new String[BuyDetailActivity.this.f18523x.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.BuyDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5044c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ Observable f18528a;

        /* renamed from: com.bxkj.student.life.secondhand.BuyDetailActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5045a extends HttpCallBack {
            C5045a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyLostGoodsActivity myLostGoodsActivity = (MyLostGoodsActivity) AppManager.m57776n().getActivity(MyLostGoodsActivity.class);
                if (myLostGoodsActivity != null) {
                    myLostGoodsActivity.m41031w0();
                }
                if (BuyDetailActivity.this.f18519t.getText().toString().trim().equals("删除")) {
                    BuyDetailActivity.this.m57919h0("删除成功");
                    SecondHandListFragment secondHandListFragment = (SecondHandListFragment) AppManager.m57776n().m57775o(SecondHandListFragment.class);
                    if (secondHandListFragment != null) {
                        secondHandListFragment.m40701g0();
                    }
                    BuyDetailActivity.this.finish();
                    return;
                }
                BuyDetailActivity.this.m57919h0("已关闭");
                BuyDetailActivity.this.m40753r0();
            }
        }

        C5044c(final Observable val$observable) {
            this.f18528a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) BuyDetailActivity.this).f1669h).setObservable(this.f18528a).setDataListener(new C5045a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.BuyDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5046d extends HttpCallBack {
        C5046d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BuyDetailActivity.this.f18520u.setVisibility(0);
            BuyDetailActivity.this.f18522w = data;
            BuyDetailActivity.this.m40752s0();
        }
    }

    /* renamed from: q0 */
    private void m40754q0() {
        Observable<Response<ResponseBody>> m2198b;
        if (this.f18519t.getText().toString().trim().equals("删除")) {
            m2198b = ((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2199a(this.f18521v, LoginUser.getLoginUser().getOpenId());
        } else {
            m2198b = ((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2198b(this.f18521v, LoginUser.getLoginUser().getOpenId());
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("确定要" + this.f18519t.getText().toString().trim() + "吗？").setRightButtonOnClickListener(new C5044c(m2198b)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void m40753r0() {
        Http.with(this.f1669h).setObservable(((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2193g(this.f18521v, this.f18508A)).setDataListener(new C5046d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m40752s0() {
        this.f18510k.setText(JsonParse.getString(this.f18522w, "publishTime"));
        this.f18511l.setText(JsonParse.getString(this.f18522w, "goodsTypeName"));
        this.f18512m.setText(JsonParse.getString(this.f18522w, SocialConstants.PARAM_COMMENT));
        this.f18514o.setText(JsonParse.getString(this.f18522w, BidResponsed.KEY_PRICE));
        List<String> list = JsonParse.getList(this.f18522w, SocialConstants.PARAM_IMG_URL, String.class);
        this.f18523x = list;
        this.f18524y.m57842c(list);
        MyGridView myGridView = this.f18513n;
        List<String> list2 = this.f18523x;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        String string = JsonParse.getString(this.f18522w, "myMotice");
        this.f18509B = string;
        if (string.equals("Y")) {
            String string2 = JsonParse.getString(this.f18522w, "status");
            this.f18519t.setVisibility(0);
            if ("0".equals(string2)) {
                this.f18519t.setEnabled(true);
                this.f18519t.setText("删除");
            } else if ("1".equals(string2)) {
                this.f18519t.setEnabled(true);
                this.f18519t.setText("关闭");
            } else if ("2".equals(string2)) {
                this.f18519t.setEnabled(false);
                this.f18519t.setText("审核不通过");
            } else {
                this.f18519t.setEnabled(false);
                this.f18519t.setText("已关闭");
            }
        }
        m40751t0();
    }

    /* renamed from: t0 */
    private void m40751t0() {
        String string = JsonParse.getString(this.f18522w, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f18515p.getParent()).setVisibility(8);
        } else {
            ((View) this.f18515p.getParent()).setVisibility(0);
            this.f18515p.setText(string);
        }
        String string2 = JsonParse.getString(this.f18522w, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f18516q.getParent()).setVisibility(8);
        } else {
            ((View) this.f18516q.getParent()).setVisibility(0);
            this.f18516q.setText(string2);
        }
        String string3 = JsonParse.getString(this.f18522w, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.f18518s.getParent()).setVisibility(8);
            return;
        }
        ((View) this.f18518s.getParent()).setVisibility(0);
        this.f18518s.setText(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m40750u0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18519t.setOnClickListener(this);
        this.f18513n.setOnItemClickListener(new C5043b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_buy_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.f18508A = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.f18521v = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("buyType")) {
            int intExtra = getIntent().getIntExtra("buyType", 0);
            this.f18525z = intExtra;
            if (intExtra == 0) {
                setTitle("求购信息");
            } else {
                setTitle("出售信息");
            }
        }
        C5042a c5042a = new C5042a(this.f1669h, C4215R.C4221layout.item_for_lost_img, this.f18523x);
        this.f18524y = c5042a;
        this.f18513n.setAdapter((ListAdapter) c5042a);
        m40753r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("物品详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18510k = (TextView) findViewById(2131232926);
        this.f18511l = (TextView) findViewById(2131233211);
        this.f18512m = (TextView) findViewById(2131232938);
        this.f18513n = (MyGridView) findViewById(2131231335);
        this.f18514o = (TextView) findViewById(2131233101);
        this.f18515p = (TextView) findViewById(2131233089);
        this.f18516q = (TextView) findViewById(C4215R.C4219id.tv_wechat);
        this.f18518s = (TextView) findViewById(C4215R.C4219id.tv_qq);
        this.f18519t = (Button) findViewById(C4215R.C4219id.bt_close);
        this.f18517r = (TextView) findViewById(C4215R.C4219id.tv_notice);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232527);
        this.f18520u = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131230965) {
            return;
        }
        m40754q0();
    }
}
