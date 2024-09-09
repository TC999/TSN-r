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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CartActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21488k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21489l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21490m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21491n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21492o;

    /* renamed from: p  reason: collision with root package name */
    private Button f21493p;

    /* renamed from: q  reason: collision with root package name */
    private CheckBox f21494q;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21495r;

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f21496s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private Map<String, Object> f21497t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    private String f21498u = "\u7f16\u8f91";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            if (CartActivity.this.f21498u.equals("\u7f16\u8f91")) {
                CartActivity.this.f21498u = "\u5b8c\u6210";
                CartActivity.this.f21490m.setVisibility(8);
                CartActivity.this.f21491n.setVisibility(8);
                CartActivity.this.f21492o.setVisibility(8);
                CartActivity.this.f21493p.setText("\u5220\u9664");
            } else {
                CartActivity.this.f21498u = "\u7f16\u8f91";
                CartActivity.this.f21490m.setVisibility(0);
                CartActivity.this.f21491n.setVisibility(0);
                CartActivity.this.f21492o.setVisibility(0);
                CartActivity.this.f21493p.setText("\u7ed3\u7b97");
            }
            CartActivity.this.H0();
            CartActivity.this.invalidateOptionsMenu();
            CartActivity.this.f21495r.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements NumberButton.OnWarnListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21501a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f21502b;

            a(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f21501a = val$holder;
                this.f21502b = val$stringObjectMap;
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onNumberChanged(int number) {
                CartActivity.this.D0(this.f21501a.f(), JsonParse.getString(this.f21502b, "id"), String.valueOf(number));
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForBuyMax(int max) {
            }

            @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
            public void onWarningForInventory(int inventory) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.mall.CartActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0256b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f21504a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f21505b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21506c;

            View$OnClickListenerC0256b(final String val$id, final boolean val$finalIsCheck, final ViewHolder val$holder) {
                this.f21504a = val$id;
                this.f21505b = val$finalIsCheck;
                this.f21506c = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                CartActivity.this.f21497t.put(this.f21504a, Boolean.valueOf(!this.f21505b));
                b.this.notifyItemChanged(this.f21506c.f());
                CartActivity.this.C0();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.t(2131231466, JsonParse.getString(stringObjectMap, "showImg"), 2131558744, 2131558744);
            if ("1".equals(JsonParse.getString(stringObjectMap, "downState"))) {
                holder.K(2131233040, CartActivity.this.getResources().getColor(2131034191));
                holder.J(2131233101, "\u8be5\u5546\u54c1\u5df2\u4e0b\u67b6");
            } else {
                holder.K(2131233040, CartActivity.this.getResources().getColor(2131034190));
                holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            }
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.J(2131233033, JsonParse.getString(stringObjectMap, "modelName"));
            holder.J(2131232914, "x" + JsonParse.getString(stringObjectMap, "commNum"));
            if (CartActivity.this.f21498u.equals("\u7f16\u8f91")) {
                holder.N(2131232914, true);
                holder.N(2131232411, false);
            } else {
                holder.N(2131232914, false);
                holder.N(2131232411, true);
            }
            NumberButton numberButton = (NumberButton) holder.h(2131232411);
            numberButton.setCurrentNumber(JsonParse.getInt(stringObjectMap, "commNum"));
            numberButton.setOnWarnListener(new a(holder, stringObjectMap));
            String string = JsonParse.getString(stringObjectMap, "id");
            boolean z3 = CartActivity.this.f21497t.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.f21497t, string) : false;
            holder.m(2131231082, z3);
            holder.w(2131231082, new View$OnClickListenerC0256b(string, z3, holder));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements s0.e {
        c() {
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            CartActivity.this.E0();
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).f1656h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CartActivity.this.f21495r.getItem(position), "commId")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CartActivity.this.f21488k == null || !CartActivity.this.f21488k.S()) {
                return;
            }
            CartActivity.this.f21488k.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CartActivity.this.f21496s = JsonParse.getList(data, "data");
            CartActivity.this.f21495r.g(CartActivity.this.f21496s);
            CartActivity.this.F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f21511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21512b;

        f(final int val$position, final String val$cartNumber) {
            this.f21511a = val$position;
            this.f21512b = val$cartNumber;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) CartActivity.this.f21495r.getItem(this.f21511a)).put("commNum", this.f21512b);
            CartActivity.this.f21495r.notifyItemChanged(this.f21511a);
            CartActivity.this.F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = 0;
            while (i4 < CartActivity.this.f21496s.size()) {
                Map map = (Map) CartActivity.this.f21496s.get(i4);
                String string = JsonParse.getString(map, "id");
                if (CartActivity.this.f21497t.containsKey(string) ? JsonParse.getBoolean(CartActivity.this.f21497t, string) : false) {
                    CartActivity.this.f21496s.remove(map);
                    CartActivity.this.f21495r.notifyItemRemoved(i4);
                    i4--;
                }
                i4++;
            }
            GoodsListFragment goodsListFragment = (GoodsListFragment) cn.bluemobi.dylan.base.utils.a.n().o(GoodsListFragment.class);
            if (goodsListFragment != null) {
                goodsListFragment.g0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CartActivity.this).f1656h).setMessage(msg).show();
            CartActivity.this.E0();
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
                CartActivity.this.startActivity(new Intent(((BaseActivity) CartActivity.this).f1656h, ConfirmOrderActivity.class).putExtra("map", seralizableMap));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private void B0() {
        for (Map<String, Object> map : this.f21496s) {
            this.f21497t.put(JsonParse.getString(map, "id"), Boolean.valueOf(this.f21494q.isChecked()));
        }
        this.f21495r.notifyDataSetChanged();
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.f21496s.size(); i5++) {
            String string = JsonParse.getString(this.f21496s.get(i5), "id");
            if (this.f21497t.containsKey(string) ? JsonParse.getBoolean(this.f21497t, string) : false) {
                i4++;
            }
        }
        this.f21494q.setChecked(i4 == this.f21496s.size());
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(final int position, String cartId, final String cartNumber) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", cartId);
        hashMap.put("commNum", cartNumber);
        arrayList.add(hashMap);
        Http.with(this.f1656h).setObservable(((q.g) Http.getApiService(q.g.class)).g(JSON.toJSONString(arrayList))).setDataListener(new f(position, cartNumber));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.g) Http.getApiService(q.g.class)).E(LoginUser.getLoginUser().getOpenId())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (Map<String, Object> map : this.f21496s) {
            String string = JsonParse.getString(map, "id");
            if (this.f21497t.containsKey(string) ? JsonParse.getBoolean(this.f21497t, string) : false) {
                bigDecimal = bigDecimal.add(new BigDecimal(JsonParse.getDouble(map, "commPrize")).multiply(new BigDecimal(JsonParse.getInt(map, "commNum"))));
            }
        }
        this.f21492o.setText(new DecimalFormat("0.00").format(bigDecimal.setScale(2, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        d0(this.f21498u, new a());
    }

    private void I0() {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f21496s) {
            String string = JsonParse.getString(map, "id");
            if (this.f21497t.containsKey(string) ? JsonParse.getBoolean(this.f21497t, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            h0("\u8bf7\u9009\u62e9\u5546\u54c1\u8fdb\u884c\u7ed3\u7b97");
        } else {
            Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((q.g) Http.getApiService(q.g.class)).D(LoginUser.getLoginUser().getOpenId(), sb.toString())).setDataListener(new h());
        }
    }

    private void delete() {
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f21496s) {
            String string = JsonParse.getString(map, "id");
            if (this.f21497t.containsKey(string) ? JsonParse.getBoolean(this.f21497t, string) : false) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        if (TextUtils.isEmpty(sb)) {
            h0("\u8bf7\u9009\u62e9\u5546\u54c1\u8fdb\u884c\u5220\u9664");
        } else {
            Http.with(this.f1656h).setObservable(((q.g) Http.getApiService(q.g.class)).i(sb.toString())).setDataListener(new g());
        }
    }

    public void G0() {
        this.f21488k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21493p.setOnClickListener(this);
        this.f21494q.setOnClickListener(this);
        this.f21495r.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427376;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21489l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21489l.setLayoutAnimation(layoutAnimationController);
        this.f21489l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        b bVar = new b(this.f1656h, 2131427763, this.f21496s);
        this.f21495r = bVar;
        this.f21489l.setAdapter(bVar);
        this.f21489l.setEmptyView(findViewById(2131232952));
        this.f21488k.O(false);
        this.f21488k.n1(new c());
        G0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8d2d\u7269\u8f66");
        H0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21489l = (EmptyRecyclerView) findViewById(2131232540);
        this.f21491n = (TextView) findViewById(2131232914);
        this.f21490m = (TextView) findViewById(2131232916);
        this.f21492o = (TextView) findViewById(2131233101);
        this.f21493p = (Button) findViewById(2131230988);
        this.f21494q = (CheckBox) findViewById(2131231082);
        this.f21488k = (SmartRefreshLayout) findViewById(2131232483);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id != 2131230988) {
            if (id != 2131231082) {
                return;
            }
            B0();
        } else if (this.f21493p.getText().toString().trim().equals("\u5220\u9664")) {
            delete();
        } else {
            I0();
        }
    }
}
