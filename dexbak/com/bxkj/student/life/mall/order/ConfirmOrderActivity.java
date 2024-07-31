package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.mall.CartActivity;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ConfirmOrderActivity extends BaseActivity {

    /* renamed from: A */
    private String f18394A;

    /* renamed from: B */
    private final int f18395B = 170;

    /* renamed from: k */
    private LinearLayout f18396k;

    /* renamed from: l */
    private LinearLayout f18397l;

    /* renamed from: m */
    private RecyclerView f18398m;

    /* renamed from: n */
    private TextView f18399n;

    /* renamed from: o */
    private TextView f18400o;

    /* renamed from: p */
    private TextView f18401p;

    /* renamed from: q */
    private TextView f18402q;

    /* renamed from: r */
    private TextView f18403r;

    /* renamed from: s */
    private TextView f18404s;

    /* renamed from: t */
    private TextView f18405t;

    /* renamed from: u */
    private EditText f18406u;

    /* renamed from: v */
    private Button f18407v;

    /* renamed from: w */
    private Map<String, Object> f18408w;

    /* renamed from: x */
    private List<Map<String, Object>> f18409x;

    /* renamed from: y */
    private double f18410y;

    /* renamed from: z */
    private double f18411z;

    /* renamed from: com.bxkj.student.life.mall.order.ConfirmOrderActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5012a extends CommonAdapter<Map<String, Object>> {
        C5012a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), C4215R.mipmap.icon_smal, C4215R.mipmap.icon_smal);
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            holder.m57874J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
            holder.m57874J(C4215R.C4219id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.ConfirmOrderActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5013b extends HttpCallBack {
        C5013b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ConfirmOrderActivity.this.startActivity(new Intent(((BaseActivity) ConfirmOrderActivity.this).f1669h, OrderPayActivity.class).putExtra("orderId", JsonParse.getString(data, "orderId")).putExtra("orderNo", JsonParse.getString(data, "orderNum")).putExtra("payPrice", JsonParse.getDouble(data, "prize")));
            CartActivity cartActivity = (CartActivity) AppManager.m57776n().getActivity(CartActivity.class);
            if (cartActivity != null) {
                cartActivity.m41008G0();
            }
            ConfirmOrderActivity.this.finish();
        }
    }

    /* renamed from: j0 */
    private void m40826j0() {
        Map<String, Object> map = this.f18408w;
        if (map != null && map.size() > 0) {
            String str = null;
            if (TextUtils.isEmpty(this.f18394A)) {
                ArrayList<Map> arrayList = new ArrayList();
                arrayList.addAll(this.f18409x);
                try {
                    for (Map map2 : arrayList) {
                        map2.remove("commName");
                        map2.remove("commPrize");
                        map2.remove("showImg");
                        map2.remove("modelName");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str = JSON.toJSONString(arrayList);
            }
            Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2227u(this.f18394A, JsonParse.getString(this.f18408w, "id"), this.f18406u.getText().toString().trim(), str)).setDataListener(new C5013b());
            return;
        }
        m57919h0("请选择地址");
    }

    /* renamed from: k0 */
    private void m40825k0() {
        Map<String, Object> map = this.f18408w;
        if (map != null && map.size() > 0) {
            this.f18397l.setVisibility(0);
            this.f18396k.setVisibility(8);
            this.f18399n.setText(JsonParse.getString(this.f18408w, "receiverName"));
            this.f18400o.setText(JsonParse.getString(this.f18408w, "receiverPhone"));
            this.f18401p.setText(JsonParse.getString(this.f18408w, "detailAddress"));
            return;
        }
        this.f18397l.setVisibility(8);
        this.f18396k.setVisibility(0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18396k.setOnClickListener(this);
        this.f18397l.setOnClickListener(this);
        this.f18407v.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_confirm_order;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("map")) {
            Map<String, Object> map = ((SeralizableMap) getIntent().getSerializableExtra("map")).getMap();
            this.f18408w = JsonParse.getMap(map, "address");
            this.f18409x = JsonParse.getList(map, "goodsList");
            this.f18410y = JsonParse.getDouble(map, "goodsPrice");
            this.f18411z = JsonParse.getDouble(map, "postFee");
            this.f18394A = JsonParse.getString(map, "ids");
        }
        m40825k0();
        this.f18398m.setLayoutManager(new LinearLayoutManager(this.f1669h));
        this.f18398m.setAdapter(new C5012a(this.f1669h, C4215R.C4221layout.item_for_order_goods_list, this.f18409x));
        this.f18398m.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        TextView textView = this.f18402q;
        textView.setText("￥" + new DecimalFormat("0.00").format(this.f18410y));
        TextView textView2 = this.f18403r;
        textView2.setText("￥" + new DecimalFormat("0.00").format(this.f18411z));
        TextView textView3 = this.f18404s;
        textView3.setText("￥" + new DecimalFormat("0.00").format(this.f18410y + this.f18411z));
        TextView textView4 = this.f18405t;
        textView4.setText("实付款：￥" + new DecimalFormat("0.00").format(this.f18410y + this.f18411z));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("确认订单");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18396k = (LinearLayout) findViewById(C4215R.C4219id.ll_choose_address);
        this.f18397l = (LinearLayout) findViewById(C4215R.C4219id.ll_address);
        this.f18398m = (RecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f18407v = (Button) findViewById(2131230967);
        this.f18402q = (TextView) findViewById(C4215R.C4219id.tv_goods_price);
        this.f18403r = (TextView) findViewById(C4215R.C4219id.tv_post_price);
        this.f18404s = (TextView) findViewById(C4215R.C4219id.tv_total_price);
        this.f18405t = (TextView) findViewById(C4215R.C4219id.tv_pay_price);
        this.f18399n = (TextView) findViewById(2131233040);
        this.f18400o = (TextView) findViewById(2131233089);
        this.f18401p = (TextView) findViewById(2131232841);
        this.f18406u = (EditText) findViewById(C4215R.C4219id.et_note);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.f18408w.put("id", data.getStringExtra("id"));
            this.f18408w.put("receiverName", data.getStringExtra("receiverName"));
            this.f18408w.put("receiverPhone", data.getStringExtra("receiverPhone"));
            this.f18408w.put("detailAddress", data.getStringExtra("detailAddress"));
            m40825k0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230967) {
            m40826j0();
            return;
        }
        if (id == 2131232165) {
            startActivityForResult(new Intent(this.f1669h, MyAddressListActivity.class).putExtra("addressId", JsonParse.getString(this.f18408w, "id").isEmpty() ? "-1" : JsonParse.getString(this.f18408w, "id")), 170);
        } else if (id != 2131232174) {
        } else {
            startActivityForResult(new Intent(this.f1669h, MyAddressListActivity.class).putExtra("addressId", JsonParse.getString(this.f18408w, "id").isEmpty() ? "-1" : JsonParse.getString(this.f18408w, "id")), 170);
        }
    }
}
