package com.bxkj.student.life.mall.address;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ChooseCityActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f21641k;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21643m;

    /* renamed from: o  reason: collision with root package name */
    private String f21645o;

    /* renamed from: p  reason: collision with root package name */
    private String f21646p;

    /* renamed from: q  reason: collision with root package name */
    private String f21647q;

    /* renamed from: r  reason: collision with root package name */
    private String f21648r;

    /* renamed from: s  reason: collision with root package name */
    private String f21649s;

    /* renamed from: t  reason: collision with root package name */
    private String f21650t;

    /* renamed from: l  reason: collision with root package name */
    private List<Map<String, Object>> f21642l = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private String f21644n = "\u8bf7\u9009\u62e9\u7701";

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
            Resources resources;
            int i4;
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            if (holder.f() % 2 == 0) {
                resources = ChooseCityActivity.this.getResources();
                i4 = 2131034196;
            } else {
                resources = ChooseCityActivity.this.getResources();
                i4 = 2131034187;
            }
            holder.k(2131232217, resources.getColor(i4));
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
            String string = JsonParse.getString((Map) ChooseCityActivity.this.f21643m.getItem(position), "id");
            String string2 = JsonParse.getString((Map) ChooseCityActivity.this.f21643m.getItem(position), "name");
            if (ChooseCityActivity.this.f21644n.equals("\u8bf7\u9009\u62e9\u7701")) {
                ChooseCityActivity.this.f21644n = "\u8bf7\u9009\u62e9\u5e02";
                ChooseCityActivity.this.f21645o = string;
                ChooseCityActivity.this.f21646p = string2;
                ChooseCityActivity chooseCityActivity = ChooseCityActivity.this;
                chooseCityActivity.A0(chooseCityActivity.f21645o);
            } else if (ChooseCityActivity.this.f21644n.equals("\u8bf7\u9009\u62e9\u5e02")) {
                ChooseCityActivity.this.f21644n = "\u8bf7\u9009\u62e9\u533a";
                ChooseCityActivity.this.f21647q = string;
                ChooseCityActivity.this.f21648r = string2;
                ChooseCityActivity.this.A0(string);
            } else if (ChooseCityActivity.this.f21644n.equals("\u8bf7\u9009\u62e9\u533a")) {
                ChooseCityActivity.this.f21649s = string;
                ChooseCityActivity.this.f21650t = string2;
                Intent intent = new Intent();
                intent.putExtra("provinceId", ChooseCityActivity.this.f21645o);
                intent.putExtra("provinceName", ChooseCityActivity.this.f21646p);
                intent.putExtra("cityId", ChooseCityActivity.this.f21647q);
                intent.putExtra("cityName", ChooseCityActivity.this.f21648r);
                intent.putExtra("areaId", ChooseCityActivity.this.f21649s);
                intent.putExtra("areaName", ChooseCityActivity.this.f21650t);
                ChooseCityActivity.this.setResult(-1, intent);
                ChooseCityActivity.this.finish();
            }
            ChooseCityActivity chooseCityActivity2 = ChooseCityActivity.this;
            chooseCityActivity2.setTitle(chooseCityActivity2.f21644n);
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
            ChooseCityActivity.this.f21642l = JsonParse.getList(data, "data");
            ChooseCityActivity.this.f21643m.g(ChooseCityActivity.this.f21642l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String parentId) {
        Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).e(parentId)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21643m.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428023;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21641k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427679, this.f21642l);
        this.f21643m = aVar;
        this.f21641k.setAdapter(aVar);
        A0(null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle(this.f21644n);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21641k = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
