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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.life.info.InfoAdapter;
import com.bxkj.student.life.lost.LostHomeActivity;
import com.bxkj.student.life.mall.MallHomeActivity;
import com.bxkj.student.life.secondhand.SecondHandHomeActivity;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LifeFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SmartRefreshLayout f21931h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f21932i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView f21933j;

    /* renamed from: k  reason: collision with root package name */
    private RadioGroup f21934k;

    /* renamed from: l  reason: collision with root package name */
    private ViewFlipper f21935l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21936m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter f21937n;

    /* renamed from: o  reason: collision with root package name */
    private int f21938o;

    /* renamed from: p  reason: collision with root package name */
    private GridLayoutManager f21939p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ((LinearLayout) holder.h(2131232217)).setLayoutParams(new GridLayoutManager.LayoutParams(LifeFragment.this.f21938o / 5, -2));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.r(2131231433, JsonParse.getInt(stringObjectMap, RewardPlus.ICON));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                LifeFragment.this.f21934k.check(LifeFragment.this.f21934k.getChildAt(LifeFragment.this.f21939p.findFirstCompletelyVisibleItemPosition() / 8).getId());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            String string = JsonParse.getString((Map) LifeFragment.this.f21936m.get(position), "name");
            if ("\u4e8c\u624b".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1665e, SecondHandHomeActivity.class));
            } else if ("\u5931\u7269\u5bfb\u7269".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1665e, LostHomeActivity.class));
            } else if ("\u5546\u57ce".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1665e, MallHomeActivity.class));
            } else if ("\u4fe1\u7528\u5361".equals(string)) {
                LifeFragment.this.startActivity(new Intent(((BaseFragment) LifeFragment.this).f1665e, H5DetailActivity.class).putExtra("title", "\u4fe1\u7528\u5361").putExtra("url", "https://creditcard.cmbc.com.cn/wsv2/?enstr=mSlA1zunTrPHh1CNz0K26zHw9V4feo2mlV1iATEE7Om%2fRx%2bHsklTDhmmcRO8Spw%2fVNOSkibHiNRP4zHyQCMkYWagHJgFtpZReRk3CXCdInmujzIcAVgLR2YbcigxNezwK98LyuBxEd6v9lR6pXeUYFmHqWtkAkYnClJ3qMsNz%2fg1rumE1ZWWqvLhQvudXiusJphdDwavqBkDd5zkNBX5NjwSNUdkp39ETXOSUvw1%2fFkFhSi%2f5NEuBauZCSWLx2eblhb4dhkfmk3gCyxuIGmKBl4FMYVUPtz10QxgfcJSfODLI0nyOvZwP8C81spE1BHd1u%2bxf7QdhQawfkIzwOUs9Q%3d%3d"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements s0.d {
        d() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            LifeFragment.this.a0();
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
            if (LifeFragment.this.f21931h == null || !LifeFragment.this.f21931h.S()) {
                return;
            }
            LifeFragment.this.f21931h.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            LifeFragment.this.f21933j.setLayoutManager(new LinearLayoutManager(((BaseFragment) LifeFragment.this).f1665e));
            LifeFragment.this.f21933j.setAdapter(new InfoAdapter(((BaseFragment) LifeFragment.this).f1665e, list));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f extends CommonAdapter<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((q.c) Http.getApiService(q.c.class)).e(10, 1)).setDataListener(new e());
    }

    private void b0() {
        this.f21931h.O(false);
        this.f21931h.m1(new d());
    }

    private void c0() {
        this.f21933j.setLayoutManager(new GridLayoutManager(this.f1665e, 2));
        this.f21933j.setAdapter(new f(this.f1665e, 2131427695, this.f21936m));
        this.f21933j.addItemDecoration(new DividerItemDecoration(this.f1665e, 0));
        this.f21933j.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
    }

    private void d0() {
        for (int i4 = 0; i4 < 5; i4++) {
            this.f21935l.addView(View.inflate(this.f1665e, 2131427716, null));
        }
    }

    private void e0() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u8d44\u8baf");
        arrayMap.put(RewardPlus.ICON, 2131558701);
        this.f21936m.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u5546\u57ce");
        arrayMap2.put(RewardPlus.ICON, 2131558713);
        this.f21936m.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u4e8c\u624b");
        arrayMap3.put(RewardPlus.ICON, 2131558725);
        this.f21936m.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u8dd1\u817f");
        arrayMap4.put(RewardPlus.ICON, 2131558740);
        this.f21936m.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "\u5931\u7269\u5bfb\u7269");
        arrayMap5.put(RewardPlus.ICON, 2131558667);
        this.f21936m.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "\u62db\u8058\u6c42\u804c");
        arrayMap6.put(RewardPlus.ICON, 2131558702);
        this.f21936m.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "\u6350\u8d60\u5bc4\u5356");
        arrayMap7.put(RewardPlus.ICON, 2131558661);
        this.f21936m.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "\u76f4\u64ad");
        arrayMap8.put(RewardPlus.ICON, 2131558704);
        this.f21936m.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "\u4fe1\u7528\u5361");
        arrayMap9.put(RewardPlus.ICON, 2131558737);
        this.f21936m.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "\u5708\u5b50");
        arrayMap10.put(RewardPlus.ICON, 2131558670);
        this.f21936m.add(arrayMap10);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f1665e, 2, 0, false);
        this.f21939p = gridLayoutManager;
        this.f21932i.setLayoutManager(gridLayoutManager);
        a aVar = new a(this.f1665e, 2131427717, this.f21936m);
        this.f21937n = aVar;
        this.f21932i.setAdapter(aVar);
        int i4 = 0;
        while (true) {
            if (i4 < (this.f21937n.getItemCount() / 10) + (this.f21937n.getItemCount() % 10 == 0 ? 0 : 1)) {
                RadioButton radioButton = new RadioButton(this.f1665e);
                radioButton.setButtonDrawable(2131165910);
                radioButton.setClickable(false);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(u.a(5.0f, this.f1665e), u.a(5.0f, this.f1665e));
                layoutParams.rightMargin = u.a(5.0f, this.f1665e);
                radioButton.setLayoutParams(layoutParams);
                this.f21934k.addView(radioButton);
                i4++;
            } else {
                RadioGroup radioGroup = this.f21934k;
                radioGroup.check(radioGroup.getChildAt(0).getId());
                this.f21932i.addOnScrollListener(new b());
                return;
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21937n.k(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        e0();
        d0();
        b0();
        this.f21931h.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21931h = (SmartRefreshLayout) c(2131232630);
        this.f21932i = (RecyclerView) c(2131232550);
        this.f21934k = (RadioGroup) c(2131232492);
        this.f21935l = (ViewFlipper) c(2131233285);
        this.f21933j = (RecyclerView) c(2131232543);
        this.f21938o = u.K(this.f1665e)[0];
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427634;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
