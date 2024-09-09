package com.bxkj.student.life.mall.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyAddressListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21654k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f21655l;

    /* renamed from: m  reason: collision with root package name */
    private Button f21656m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21657n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f21658o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f21659p = 15;

    /* renamed from: q  reason: collision with root package name */
    private int f21660q = 0;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21661r;

    /* renamed from: s  reason: collision with root package name */
    private String f21662s;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0260a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21664a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f21665b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f21666c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f21667d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f21668e;

            View$OnClickListenerC0260a(final Map val$stringObjectMap, final String val$name, final String val$phone, final String val$city, final String val$address) {
                this.f21664a = val$stringObjectMap;
                this.f21665b = val$name;
                this.f21666c = val$phone;
                this.f21667d = val$city;
                this.f21668e = val$address;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MyAddressListActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, AddAddressActivity.class).putExtra("addressId", JsonParse.getString(this.f21664a, "id")).putExtra("name", this.f21665b).putExtra("phone", this.f21666c).putExtra("city", this.f21667d).putExtra("areaId", JsonParse.getString(this.f21664a, "cityId")).putExtra("address", this.f21668e));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21670a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21671b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0261a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
                /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\5141176.dex */
                class C0262a extends HttpCallBack {
                    C0262a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        a.this.d().remove(b.this.f21670a);
                        b bVar = b.this;
                        a.this.notifyItemRemoved(bVar.f21671b.f());
                    }
                }

                C0261a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) a.this).f1707a).setObservable(((g) Http.getApiService(g.class)).f(JsonParse.getString(b.this.f21670a, "id"))).setDataListener(new C0262a());
                }
            }

            b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f21670a = val$stringObjectMap;
                this.f21671b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                new iOSTwoButtonDialog(((CommonAdapter) a.this).f1707a).setMessage("\u786e\u5b9a\u8981\u5220\u9664\u5417\uff1f").setRightButtonOnClickListener(new C0261a()).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21675a;

            c(final ViewHolder val$holder) {
                this.f21675a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MyAddressListActivity.this.x0(this.f21675a.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21677a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$d$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0263a extends HttpCallBack {
                C0263a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    for (Map map : MyAddressListActivity.this.f21657n) {
                        if (d.this.f21677a.equals(map)) {
                            map.put("firstFlag", 1);
                        } else {
                            map.put("firstFlag", 0);
                        }
                    }
                    a.this.notifyDataSetChanged();
                }
            }

            d(final Map val$stringObjectMap) {
                this.f21677a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                Http.with(((CommonAdapter) a.this).f1707a).setObservable(((g) Http.getApiService(g.class)).w(JsonParse.getString(this.f21677a, "id"))).setDataListener(new C0263a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "receiverName");
            holder.J(2131233040, string);
            String string2 = JsonParse.getString(stringObjectMap, "receiverPhone");
            holder.J(2131233089, string2);
            String string3 = JsonParse.getString(stringObjectMap, "provenceStr");
            String string4 = JsonParse.getString(stringObjectMap, "detailAddress");
            holder.J(2131232841, string3 + string4);
            holder.w(2131231412, new View$OnClickListenerC0260a(stringObjectMap, string, string2, string3, string4));
            holder.w(2131231403, new b(stringObjectMap, holder));
            if (!TextUtils.isEmpty(MyAddressListActivity.this.f21662s)) {
                holder.J(2131231083, "\u9009\u62e9\u8be5\u5730\u5740");
                holder.N(2131233008, true);
                holder.N(2131233008, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
                holder.m(2131231083, MyAddressListActivity.this.f21662s.equals(JsonParse.getString(stringObjectMap, "id")));
                holder.w(2131232225, new c(holder));
                return;
            }
            holder.J(2131231083, "\u8bbe\u4e3a\u9ed8\u8ba4\u5730\u5740");
            holder.N(2131233008, false);
            holder.m(2131231083, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
            holder.w(2131232225, new d(stringObjectMap));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            MyAddressListActivity.this.x0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MyAddressListActivity.this.f21658o = 1;
            MyAddressListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyAddressListActivity.this.f21660q / MyAddressListActivity.this.f21659p;
            int i5 = MyAddressListActivity.this.f21658o;
            if (MyAddressListActivity.this.f21660q % MyAddressListActivity.this.f21659p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyAddressListActivity.this.f21654k.h();
                MyAddressListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyAddressListActivity.t0(MyAddressListActivity.this);
            MyAddressListActivity.this.u0();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyAddressListActivity.this.f21654k != null && MyAddressListActivity.this.f21654k.S()) {
                MyAddressListActivity.this.f21654k.y();
            }
            if (MyAddressListActivity.this.f21654k == null || !MyAddressListActivity.this.f21654k.z()) {
                return;
            }
            MyAddressListActivity.this.f21654k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAddressListActivity.this.f21660q = JsonParse.getInt(data, "total");
            if (MyAddressListActivity.this.f21658o == 1) {
                MyAddressListActivity.this.f21657n.clear();
            }
            MyAddressListActivity.this.f21657n.addAll(JsonParse.getList(data, "data"));
            MyAddressListActivity.this.f21661r.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int t0(MyAddressListActivity myAddressListActivity) {
        int i4 = myAddressListActivity.f21658o;
        myAddressListActivity.f21658o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).d(LoginUser.getLoginUser().getOpenId(), this.f21658o, this.f21659p)).setDataListener(new d());
    }

    private void v0() {
        this.f21654k.n1(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int position) {
        Intent intent = new Intent();
        intent.putExtra("id", JsonParse.getString(this.f21661r.getItem(position), "id"));
        intent.putExtra("receiverName", JsonParse.getString(this.f21661r.getItem(position), "receiverName"));
        intent.putExtra("receiverPhone", JsonParse.getString(this.f21661r.getItem(position), "receiverPhone"));
        intent.putExtra("detailAddress", JsonParse.getString(this.f21661r.getItem(position), "provenceStr") + JsonParse.getString(this.f21661r.getItem(position), "detailAddress"));
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21656m.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f21662s)) {
            return;
        }
        this.f21661r.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427359;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("addressId")) {
            this.f21662s = getIntent().getStringExtra("addressId");
        }
        this.f21655l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427666, this.f21657n);
        this.f21661r = aVar;
        this.f21655l.setAdapter(aVar);
        this.f21655l.setEmptyView(findViewById(2131232952));
        v0();
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6536\u8d27\u5730\u5740");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21654k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21655l = (EmptyRecyclerView) findViewById(2131232541);
        this.f21656m = (Button) findViewById(2131230950);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131230950) {
            return;
        }
        startActivity(new Intent(this.f1656h, AddAddressActivity.class));
    }

    public void w0() {
        this.f21654k.a0();
    }
}
