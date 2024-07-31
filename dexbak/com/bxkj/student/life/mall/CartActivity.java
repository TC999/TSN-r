package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CartActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18162k;

    /* renamed from: l */
    private EmptyRecyclerView f18163l;

    /* renamed from: m */
    private TextView f18164m;

    /* renamed from: n */
    private TextView f18165n;

    /* renamed from: o */
    private TextView f18166o;

    /* renamed from: p */
    private Button f18167p;

    /* renamed from: q */
    private CheckBox f18168q;

    /* renamed from: r */
    private CommonAdapter<Map<String, Object>> f18169r;

    /* renamed from: s */
    private List<Map<String, Object>> f18170s = new ArrayList();

    /* renamed from: t */
    private Map<String, Object> f18171t = new HashMap();

    /* renamed from: u */
    private String f18172u = "编辑";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.CartActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4927a implements BaseActivity.InterfaceC1107c {
        C4927a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            if (CartActivity.this.f18172u.equals("编辑")) {
                CartActivity.this.f18172u = "完成";
                CartActivity.this.f18164m.setVisibility(8);
                CartActivity.this.f18165n.setVisibility(8);
                CartActivity.this.f18166o.setVisibility(8);
                CartActivity.this.f18167p.setText("删除");
            } else {
                CartActivity.this.f18172u = "编辑";
                CartActivity.this.f18164m.setVisibility(0);
                CartActivity.this.f18165n.setVisibility(0);
                CartActivity.this.f18166o.setVisibility(0);
                CartActivity.this.f18167p.setText("结算");
            }
            CartActivity.this.m41007H0();
            CartActivity.this.invalidateOptionsMenu();
            CartActivity.this.f18169r.notifyDataSetChanged();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.CartActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4928b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.CartActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4929a implements NumberButton.OnWarnListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f18175a;

            /* renamed from: b */
            final /* synthetic */ Map f18176b;

            C4929a(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f18175a = val$holder;
                this.f18176b = val$stringObjectMap;
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onNumberChanged(int number) {
                CartActivity.this.m41011D0(this.f18175a.m57864f(), JsonParse.getString(this.f18176b, "id"), String.valueOf(number));
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForBuyMax(int max) {
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForInventory(int inventory) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.CartActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4930b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ String f18178a;

            /* renamed from: b */
            final /* synthetic */ boolean f18179b;

            /* renamed from: c */
            final /* synthetic */ ViewHolder f18180c;

            View$OnClickListenerC4930b(final String val$id, final boolean val$finalIsCheck, final ViewHolder val$holder) {
                this.f18178a = val$id;
                this.f18179b = val$finalIsCheck;
                this.f18180c = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CartActivity.this.f18171t.put(this.f18178a, Boolean.valueOf(!this.f18179b));
                C4928b.this.notifyItemChanged(this.f18180c.m57864f());
                CartActivity.this.m41012C0();
            }
        }

        C4928b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57850t(C4215R.C4219id.iv_pic, JsonParse.getString(stringObjectMap, "showImg"), C4215R.mipmap.icon_smal, C4215R.mipmap.icon_smal);
            if ("1".equals(JsonParse.getString(stringObjectMap, "downState"))) {
                holder.m57873K(2131233040, CartActivity.this.getResources().getColor(2131034191));
                holder.m57874J(2131233101, "该商品已下架");
            } else {
                holder.m57873K(2131233040, CartActivity.this.getResources().getColor(2131034190));
                holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            }
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.m57874J(C4215R.C4219id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
            holder.m57874J(2131232914, "x" + JsonParse.getString(stringObjectMap, "commNum"));
            if (CartActivity.this.f18172u.equals("编辑")) {
                holder.m57870N(2131232914, true);
                holder.m57870N(2131232411, false);
            } else {
                holder.m57870N(2131232914, false);
                holder.m57870N(2131232411, true);
            }
            NumberButton numberButton = (NumberButton) holder.m57862h(2131232411);
            numberButton.setCurrentNumber(JsonParse.getInt(stringObjectMap, "commNum"));
            numberButton.setOnWarnListener(new C4929a(holder, stringObjectMap));
            String string = JsonParse.getString(stringObjectMap, "id");
            boolean z = CartActivity.this.f18171t.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.f18171t, string) : false;
            holder.m57857m(C4215R.C4219id.cb_all, z);
            holder.m57847w(C4215R.C4219id.cb_all, new View$OnClickListenerC4930b(string, z, holder));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.CartActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4931c implements OnRefreshLoadmoreListener {
        C4931c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CartActivity.this.m41010E0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
        }
    }

    /* renamed from: com.bxkj.student.life.mall.CartActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4932d implements OnItemClickListener {
        C4932d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).f1669h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CartActivity.this.f18169r.getItem(position), "commId")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.CartActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4933e extends HttpCallBack {
        C4933e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CartActivity.this.f18162k == null || !CartActivity.this.f18162k.mo2061S()) {
                return;
            }
            CartActivity.this.f18162k.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CartActivity.this.f18170s = JsonParse.getList(data, "data");
            CartActivity.this.f18169r.m57836g(CartActivity.this.f18170s);
            CartActivity.this.m41009F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.CartActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4934f extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f18185a;

        /* renamed from: b */
        final /* synthetic */ String f18186b;

        C4934f(final int val$position, final String val$cartNumber) {
            this.f18185a = val$position;
            this.f18186b = val$cartNumber;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) CartActivity.this.f18169r.getItem(this.f18185a)).put("commNum", this.f18186b);
            CartActivity.this.f18169r.notifyItemChanged(this.f18185a);
            CartActivity.this.m41009F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.CartActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4935g extends HttpCallBack {
        C4935g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = 0;
            while (i < CartActivity.this.f18170s.size()) {
                Map map = (Map) CartActivity.this.f18170s.get(i);
                String string = JsonParse.getString(map, "id");
                if (CartActivity.this.f18171t.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.f18171t, string) : false) {
                    CartActivity.this.f18170s.remove(map);
                    CartActivity.this.f18169r.notifyItemRemoved(i);
                    i--;
                }
                i++;
            }
            GoodsListFragment goodsListFragment = (GoodsListFragment) AppManager.m57776n().m57775o(GoodsListFragment.class);
            if (goodsListFragment != null) {
                goodsListFragment.m40929g0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.CartActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4936h extends HttpCallBack {
        C4936h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CartActivity.this).f1669h).setMessage(msg).show();
            CartActivity.this.m41010E0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                HashMap hashMap = new HashMap(3);
                HashMap hashMap2 = new HashMap(3);
                hashMap2.putAll(JsonParse.getMap(data, "address"));
                hashMap.put("address", hashMap2);
                hashMap.put("goodsList", JsonParse.getList(data, "comms"));
                hashMap.put("postFee", Double.valueOf(JsonParse.getDouble(data, "postFee")));
                hashMap.put("goodsPrice", Double.valueOf(JsonParse.getDouble(data, "totalPrize")));
                hashMap.put("ids", JsonParse.getString(data, "ids"));
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(hashMap);
                CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).f1669h, ConfirmOrderActivity.class).putExtra("map", seralizableMap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: B0 */
    private void m41013B0() {
        for (Map<String, Object> map : this.f18170s) {
            this.f18171t.put(JsonParse.getString(map, "id"), Boolean.valueOf(this.f18168q.isChecked()));
        }
        this.f18169r.notifyDataSetChanged();
        m41009F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public void m41012C0() {
        int i = 0;
        for (int i2 = 0; i2 < this.f18170s.size(); i2++) {
            String string = JsonParse.getString(this.f18170s.get(i2), "id");
            if (this.f18171t.containsKey(string) ? JsonParse.getBoolean(this.f18171t, string) : false) {
                i++;
            }
        }
        this.f18168q.setChecked(i == this.f18170s.size());
        m41009F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public void m41011D0(final int position, String cartId, final String cartNumber) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", cartId);
        hashMap.put("commNum", cartNumber);
        arrayList.add(hashMap);
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2241g(JSON.toJSONString(arrayList))).setDataListener(new C4934f(position, cartNumber));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public void m41010E0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2248E(LoginUser.getLoginUser().getOpenId())).setDataListener(new C4933e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public void m41009F0() {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (Map<String, Object> map : this.f18170s) {
            String string = JsonParse.getString(map, "id");
            if (this.f18171t.containsKey(string) ? JsonParse.getBoolean(this.f18171t, string) : false) {
                bigDecimal = bigDecimal.add(new BigDecimal(JsonParse.getDouble(map, "commPrize")).multiply(new BigDecimal(JsonParse.getInt(map, "commNum"))));
            }
        }
        this.f18166o.setText(new DecimalFormat("0.00").format(bigDecimal.setScale(2, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m41007H0() {
        m57923d0(this.f18172u, new C4927a());
    }

    /* renamed from: I0 */
    private void m41006I0() {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f18170s) {
            String string = JsonParse.getString(map, "id");
            if (this.f18171t.containsKey(string) ? JsonParse.getBoolean(this.f18171t, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            m57919h0("请选择商品进行结算");
        } else {
            Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2249D(LoginUser.getLoginUser().getOpenId(), sb.toString())).setDataListener(new C4936h());
        }
    }

    private void delete() {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f18170s) {
            String string = JsonParse.getString(map, "id");
            if (this.f18171t.containsKey(string) ? JsonParse.getBoolean(this.f18171t, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            m57919h0("请选择商品进行删除");
        } else {
            Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2239i(sb.toString())).setDataListener(new C4935g());
        }
    }

    /* renamed from: G0 */
    public void m41008G0() {
        this.f18162k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18167p.setOnClickListener(this);
        this.f18168q.setOnClickListener(this);
        this.f18169r.m57834k(new C4932d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_cart_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18163l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18163l.setLayoutAnimation(layoutAnimationController);
        this.f18163l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C4928b c4928b = new C4928b(this.f1669h, C4215R.C4221layout.item_for_shopping_cart_goods_number, this.f18170s);
        this.f18169r = c4928b;
        this.f18163l.setAdapter(c4928b);
        this.f18163l.setEmptyView(findViewById(2131232952));
        this.f18162k.mo2064P(false);
        this.f18162k.mo2019v(new C4931c());
        m41008G0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("购物车");
        m41007H0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18163l = (EmptyRecyclerView) findViewById(2131232540);
        this.f18165n = (TextView) findViewById(2131232914);
        this.f18164m = (TextView) findViewById(C4215R.C4219id.tv_count_hint);
        this.f18166o = (TextView) findViewById(2131233101);
        this.f18167p = (Button) findViewById(C4215R.C4219id.bt_next);
        this.f18168q = (CheckBox) findViewById(C4215R.C4219id.cb_all);
        this.f18162k = (SmartRefreshLayout) findViewById(2131232483);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id != 2131230988) {
            if (id != 2131231082) {
                return;
            }
            m41013B0();
        } else if (this.f18167p.getText().toString().trim().equals("删除")) {
            delete();
        } else {
            m41006I0();
        }
    }
}
