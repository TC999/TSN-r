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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.student.life.mall.CartActivity;
import com.bxkj.student.life.mall.address.MyAddressListActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ConfirmOrderActivity extends BaseActivity {
    private String A;
    private final int B = 170;

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f21709k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f21710l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f21711m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21712n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21713o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21714p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21715q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21716r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f21717s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f21718t;

    /* renamed from: u  reason: collision with root package name */
    private EditText f21719u;

    /* renamed from: v  reason: collision with root package name */
    private Button f21720v;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Object> f21721w;

    /* renamed from: x  reason: collision with root package name */
    private List<Map<String, Object>> f21722x;

    /* renamed from: y  reason: collision with root package name */
    private double f21723y;

    /* renamed from: z  reason: collision with root package name */
    private double f21724z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558744, 2131558744);
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            holder.J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
            holder.J(2131233033, JsonParse.getString(stringObjectMap, "modelName"));
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ConfirmOrderActivity.this.startActivity(new Intent(((BaseActivity) ConfirmOrderActivity.this).f1656h, OrderPayActivity.class).putExtra("orderId", JsonParse.getString(data, "orderId")).putExtra("orderNo", JsonParse.getString(data, "orderNum")).putExtra("payPrice", JsonParse.getDouble(data, "prize")));
            CartActivity cartActivity = (CartActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(CartActivity.class);
            if (cartActivity != null) {
                cartActivity.G0();
            }
            ConfirmOrderActivity.this.finish();
        }
    }

    private void j0() {
        Map<String, Object> map = this.f21721w;
        if (map != null && map.size() > 0) {
            String str = null;
            if (TextUtils.isEmpty(this.A)) {
                ArrayList<Map> arrayList = new ArrayList();
                arrayList.addAll(this.f21722x);
                try {
                    for (Map map2 : arrayList) {
                        map2.remove("commName");
                        map2.remove("commPrize");
                        map2.remove("showImg");
                        map2.remove("modelName");
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                str = JSON.toJSONString(arrayList);
            }
            Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).u(this.A, JsonParse.getString(this.f21721w, "id"), this.f21719u.getText().toString().trim(), str)).setDataListener(new b());
            return;
        }
        h0("\u8bf7\u9009\u62e9\u5730\u5740");
    }

    private void k0() {
        Map<String, Object> map = this.f21721w;
        if (map != null && map.size() > 0) {
            this.f21710l.setVisibility(0);
            this.f21709k.setVisibility(8);
            this.f21712n.setText(JsonParse.getString(this.f21721w, "receiverName"));
            this.f21713o.setText(JsonParse.getString(this.f21721w, "receiverPhone"));
            this.f21714p.setText(JsonParse.getString(this.f21721w, "detailAddress"));
            return;
        }
        this.f21710l.setVisibility(8);
        this.f21709k.setVisibility(0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21709k.setOnClickListener(this);
        this.f21710l.setOnClickListener(this);
        this.f21720v.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427387;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("map")) {
            Map<String, Object> map = ((SeralizableMap) getIntent().getSerializableExtra("map")).getMap();
            this.f21721w = JsonParse.getMap(map, "address");
            this.f21722x = JsonParse.getList(map, "goodsList");
            this.f21723y = JsonParse.getDouble(map, "goodsPrice");
            this.f21724z = JsonParse.getDouble(map, "postFee");
            this.A = JsonParse.getString(map, "ids");
        }
        k0();
        this.f21711m.setLayoutManager(new LinearLayoutManager(this.f1656h));
        this.f21711m.setAdapter(new a(this.f1656h, 2131427733, this.f21722x));
        this.f21711m.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        TextView textView = this.f21715q;
        textView.setText("\uffe5" + new DecimalFormat("0.00").format(this.f21723y));
        TextView textView2 = this.f21716r;
        textView2.setText("\uffe5" + new DecimalFormat("0.00").format(this.f21724z));
        TextView textView3 = this.f21717s;
        textView3.setText("\uffe5" + new DecimalFormat("0.00").format(this.f21723y + this.f21724z));
        TextView textView4 = this.f21718t;
        textView4.setText("\u5b9e\u4ed8\u6b3e\uff1a\uffe5" + new DecimalFormat("0.00").format(this.f21723y + this.f21724z));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u786e\u8ba4\u8ba2\u5355");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21709k = (LinearLayout) findViewById(2131232174);
        this.f21710l = (LinearLayout) findViewById(2131232165);
        this.f21711m = (RecyclerView) findViewById(2131232545);
        this.f21720v = (Button) findViewById(2131230967);
        this.f21715q = (TextView) findViewById(2131232978);
        this.f21716r = (TextView) findViewById(2131233099);
        this.f21717s = (TextView) findViewById(2131233207);
        this.f21718t = (TextView) findViewById(2131233072);
        this.f21712n = (TextView) findViewById(2131233040);
        this.f21713o = (TextView) findViewById(2131233089);
        this.f21714p = (TextView) findViewById(2131232841);
        this.f21719u = (EditText) findViewById(2131231261);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && data != null && requestCode == 170) {
            this.f21721w.put("id", data.getStringExtra("id"));
            this.f21721w.put("receiverName", data.getStringExtra("receiverName"));
            this.f21721w.put("receiverPhone", data.getStringExtra("receiverPhone"));
            this.f21721w.put("detailAddress", data.getStringExtra("detailAddress"));
            k0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131230967) {
            j0();
            return;
        }
        if (id == 2131232165) {
            startActivityForResult(new Intent(this.f1656h, MyAddressListActivity.class).putExtra("addressId", JsonParse.getString(this.f21721w, "id").isEmpty() ? "-1" : JsonParse.getString(this.f21721w, "id")), 170);
        } else if (id != 2131232174) {
        } else {
            startActivityForResult(new Intent(this.f1656h, MyAddressListActivity.class).putExtra("addressId", JsonParse.getString(this.f21721w, "id").isEmpty() ? "-1" : JsonParse.getString(this.f21721w, "id")), 170);
        }
    }
}
