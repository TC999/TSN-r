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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ChooseCityActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f18326k;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f18328m;

    /* renamed from: o */
    private String f18330o;

    /* renamed from: p */
    private String f18331p;

    /* renamed from: q */
    private String f18332q;

    /* renamed from: r */
    private String f18333r;

    /* renamed from: s */
    private String f18334s;

    /* renamed from: t */
    private String f18335t;

    /* renamed from: l */
    private List<Map<String, Object>> f18327l = new ArrayList();

    /* renamed from: n */
    private String f18329n = "请选择省";

    /* renamed from: com.bxkj.student.life.mall.address.ChooseCityActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4986a extends CommonAdapter<Map<String, Object>> {
        C4986a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            Resources resources;
            int i;
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            if (holder.m57864f() % 2 == 0) {
                resources = ChooseCityActivity.this.getResources();
                i = 2131034196;
            } else {
                resources = ChooseCityActivity.this.getResources();
                i = C4215R.C4217color.city_bg;
            }
            holder.m57859k(2131232217, resources.getColor(i));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.address.ChooseCityActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4987b implements OnItemClickListener {
        C4987b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            String string = JsonParse.getString((Map) ChooseCityActivity.this.f18328m.getItem(position), "id");
            String string2 = JsonParse.getString((Map) ChooseCityActivity.this.f18328m.getItem(position), "name");
            if (ChooseCityActivity.this.f18329n.equals("请选择省")) {
                ChooseCityActivity.this.f18329n = "请选择市";
                ChooseCityActivity.this.f18330o = string;
                ChooseCityActivity.this.f18331p = string2;
                ChooseCityActivity chooseCityActivity = ChooseCityActivity.this;
                chooseCityActivity.m40889A0(chooseCityActivity.f18330o);
            } else if (ChooseCityActivity.this.f18329n.equals("请选择市")) {
                ChooseCityActivity.this.f18329n = "请选择区";
                ChooseCityActivity.this.f18332q = string;
                ChooseCityActivity.this.f18333r = string2;
                ChooseCityActivity.this.m40889A0(string);
            } else if (ChooseCityActivity.this.f18329n.equals("请选择区")) {
                ChooseCityActivity.this.f18334s = string;
                ChooseCityActivity.this.f18335t = string2;
                Intent intent = new Intent();
                intent.putExtra("provinceId", ChooseCityActivity.this.f18330o);
                intent.putExtra("provinceName", ChooseCityActivity.this.f18331p);
                intent.putExtra("cityId", ChooseCityActivity.this.f18332q);
                intent.putExtra("cityName", ChooseCityActivity.this.f18333r);
                intent.putExtra("areaId", ChooseCityActivity.this.f18334s);
                intent.putExtra("areaName", ChooseCityActivity.this.f18335t);
                ChooseCityActivity.this.setResult(-1, intent);
                ChooseCityActivity.this.finish();
            }
            ChooseCityActivity chooseCityActivity2 = ChooseCityActivity.this;
            chooseCityActivity2.setTitle(chooseCityActivity2.f18329n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.address.ChooseCityActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4988c extends HttpCallBack {
        C4988c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseCityActivity.this.f18327l = JsonParse.getList(data, "data");
            ChooseCityActivity.this.f18328m.m57836g(ChooseCityActivity.this.f18327l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m40889A0(String parentId) {
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2243e(parentId)).setDataListener(new C4988c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18328m.m57834k(new C4987b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18326k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4986a c4986a = new C4986a(this.f1669h, C4215R.C4221layout.item_for_city_list, this.f18327l);
        this.f18328m = c4986a;
        this.f18326k.setAdapter(c4986a);
        m40889A0(null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle(this.f18329n);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18326k = (RecyclerView) findViewById(2131232540);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
