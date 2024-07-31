package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.info.InfoAdapter;
import com.bxkj.student.life.lost.LostHomeActivity;
import com.bxkj.student.life.mall.MallHomeActivity;
import com.bxkj.student.life.secondhand.SecondHandHomeActivity;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.InfoApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LifeFragment extends BaseFragment {

    /* renamed from: h */
    private SmartRefreshLayout f18624h;

    /* renamed from: i */
    private RecyclerView f18625i;

    /* renamed from: j */
    private RecyclerView f18626j;

    /* renamed from: k */
    private RadioGroup f18627k;

    /* renamed from: l */
    private ViewFlipper f18628l;

    /* renamed from: m */
    private List<Map<String, Object>> f18629m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter f18630n;

    /* renamed from: o */
    private int f18631o;

    /* renamed from: p */
    private GridLayoutManager f18632p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.LifeFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5080a extends CommonAdapter<Map<String, Object>> {
        C5080a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ((LinearLayout) holder.m57862h(2131232217)).setLayoutParams(new GridLayoutManager.LayoutParams(LifeFragment.this.f18631o / 5, -2));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57852r(2131231433, JsonParse.getInt(stringObjectMap, RewardPlus.ICON));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.LifeFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5081b extends RecyclerView.OnScrollListener {
        C5081b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                LifeFragment.this.f18627k.check(LifeFragment.this.f18627k.getChildAt(LifeFragment.this.f18632p.findFirstCompletelyVisibleItemPosition() / 8).getId());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    }

    /* renamed from: com.bxkj.student.main.LifeFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5082c implements OnItemClickListener {
        C5082c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            String string = JsonParse.getString((Map) LifeFragment.this.f18629m.get(position), "name");
            if ("二手".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1678e, SecondHandHomeActivity.class));
            } else if ("失物寻物".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1678e, LostHomeActivity.class));
            } else if ("商城".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1678e, MallHomeActivity.class));
            } else if ("信用卡".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1678e, H5DetailActivity.class).putExtra("title", "信用卡").putExtra("url", "https://creditcard.cmbc.com.cn/wsv2/?enstr=mSlA1zunTrPHh1CNz0K26zHw9V4feo2mlV1iATEE7Om%2fRx%2bHsklTDhmmcRO8Spw%2fVNOSkibHiNRP4zHyQCMkYWagHJgFtpZReRk3CXCdInmujzIcAVgLR2YbcigxNezwK98LyuBxEd6v9lR6pXeUYFmHqWtkAkYnClJ3qMsNz%2fg1rumE1ZWWqvLhQvudXiusJphdDwavqBkDd5zkNBX5NjwSNUdkp39ETXOSUvw1%2fFkFhSi%2f5NEuBauZCSWLx2eblhb4dhkfmk3gCyxuIGmKBl4FMYVUPtz10QxgfcJSfODLI0nyOvZwP8C81spE1BHd1u%2bxf7QdhQawfkIzwOUs9Q%3d%3d"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.LifeFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5083d implements OnRefreshListener {
        C5083d() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            LifeFragment.this.m40642a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.LifeFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5084e extends HttpCallBack {
        C5084e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (LifeFragment.this.f18624h == null || !LifeFragment.this.f18624h.mo2061S()) {
                return;
            }
            LifeFragment.this.f18624h.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            LifeFragment.this.f18626j.setLayoutManager(new LinearLayoutManager(((BaseFragment) LifeFragment.this).f1678e));
            LifeFragment.this.f18626j.setAdapter(new InfoAdapter(((BaseFragment) LifeFragment.this).f1678e, list));
        }
    }

    /* renamed from: com.bxkj.student.main.LifeFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5085f extends CommonAdapter<Map<String, Object>> {
        C5085f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public void m40642a0() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((InfoApiService) Http.getApiService(InfoApiService.class)).m2300e(10, 1)).setDataListener(new C5084e());
    }

    /* renamed from: b0 */
    private void m40641b0() {
        this.f18624h.mo2064P(false);
        this.f18624h.mo2035j(new C5083d());
    }

    /* renamed from: c0 */
    private void m40640c0() {
        this.f18626j.setLayoutManager(new GridLayoutManager(this.f1678e, 2));
        this.f18626j.setAdapter(new C5085f(this.f1678e, C4215R.C4221layout.item_for_goods, this.f18629m));
        this.f18626j.addItemDecoration(new DividerItemDecoration(this.f1678e, 0));
        this.f18626j.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
    }

    /* renamed from: d0 */
    private void m40639d0() {
        for (int i = 0; i < 5; i++) {
            this.f18628l.addView(View.inflate(this.f1678e, C4215R.C4221layout.item_for_life_center_ad, null));
        }
    }

    /* renamed from: e0 */
    private void m40638e0() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "资讯");
        arrayMap.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_info));
        this.f18629m.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "商城");
        arrayMap2.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_mall));
        this.f18629m.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "二手");
        arrayMap3.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_pick));
        this.f18629m.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "跑腿");
        arrayMap4.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_runner));
        this.f18629m.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "失物寻物");
        arrayMap5.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_buy));
        this.f18629m.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "招聘求职");
        arrayMap6.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_job));
        this.f18629m.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "捐赠寄卖");
        arrayMap7.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_arts));
        this.f18629m.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "直播");
        arrayMap8.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_live));
        this.f18629m.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "信用卡");
        arrayMap9.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_recharge));
        this.f18629m.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "圈子");
        arrayMap10.put(RewardPlus.ICON, Integer.valueOf((int) C4215R.mipmap.icon_circle));
        this.f18629m.add(arrayMap10);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f1678e, 2, 0, false);
        this.f18632p = gridLayoutManager;
        this.f18625i.setLayoutManager(gridLayoutManager);
        C5080a c5080a = new C5080a(this.f1678e, C4215R.C4221layout.item_for_life_menu, this.f18629m);
        this.f18630n = c5080a;
        this.f18625i.setAdapter(c5080a);
        int i = 0;
        while (true) {
            if (i < (this.f18630n.getItemCount() / 10) + (this.f18630n.getItemCount() % 10 == 0 ? 0 : 1)) {
                RadioButton radioButton = new RadioButton(this.f1678e);
                radioButton.setButtonDrawable(C4215R.C4218drawable.rb_dot);
                radioButton.setClickable(false);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(Tools.m57620a(5.0f, this.f1678e), Tools.m57620a(5.0f, this.f1678e));
                layoutParams.rightMargin = Tools.m57620a(5.0f, this.f1678e);
                radioButton.setLayoutParams(layoutParams);
                this.f18627k.addView(radioButton);
                i++;
            } else {
                RadioGroup radioGroup = this.f18627k;
                radioGroup.check(radioGroup.getChildAt(0).getId());
                this.f18625i.addOnScrollListener(new C5081b());
                return;
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18630n.m57834k(new C5082c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        m40638e0();
        m40639d0();
        m40641b0();
        this.f18624h.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18624h = (SmartRefreshLayout) m57916c(C4215R.C4219id.smartRefresh);
        this.f18625i = (RecyclerView) m57916c(C4215R.C4219id.rv_menu);
        this.f18627k = (RadioGroup) m57916c(C4215R.C4219id.rg_dots);
        this.f18628l = (ViewFlipper) m57916c(2131233285);
        this.f18626j = (RecyclerView) m57916c(C4215R.C4219id.rv_bottom);
        this.f18631o = Tools.m57636K(this.f1678e)[0];
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_life;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
