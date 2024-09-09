package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import r0.h;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class HomeFragment extends BaseFragment {

    /* renamed from: i  reason: collision with root package name */
    private SmartRefreshLayout f21914i;

    /* renamed from: j  reason: collision with root package name */
    private ViewFlipper f21915j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f21916k;

    /* renamed from: l  reason: collision with root package name */
    private CycleViewPager f21917l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f21918m;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21920o;

    /* renamed from: h  reason: collision with root package name */
    private final String f21913h = "groupType";

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21919n = new ArrayList();

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.r(2131231433, HomeFragment.this.Y(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (HomeFragment.this.f21914i == null || !HomeFragment.this.f21914i.S()) {
                return;
            }
            HomeFragment.this.f21914i.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.b0(JsonParse.getList(data, "data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21924a;

            a(final Map val$stringObjectMap) {
                this.f21924a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1665e, H5DetailActivity.class);
                intent.putExtra("title", u.O(this.f21924a, "title"));
                intent.putExtra("url", u.O(this.f21924a, "url"));
                HomeFragment.this.startActivity(intent);
            }
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.f21915j.removeAllViews();
            for (Map map : (List) data.get("data")) {
                View inflate = View.inflate(((BaseFragment) HomeFragment.this).f1665e, 2131427778, null);
                ImageView imageView = (ImageView) inflate.findViewById(2131231460);
                int i4 = 8;
                inflate.findViewById(2131231389).setVisibility(8);
                ((TextView) inflate.findViewById(2131233204)).setText(u.O(map, "title"));
                if (u.O(map, "isread").equals("0")) {
                    i4 = 0;
                }
                imageView.setVisibility(i4);
                inflate.setOnClickListener(new a(map));
                HomeFragment.this.f21915j.addView(inflate);
            }
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
            new com.bxkj.student.home.d(HomeFragment.this.getActivity(), JsonParse.getString((Map) HomeFragment.this.f21920o.getItem(position), RewardPlus.ICON), JsonParse.getString((Map) HomeFragment.this.f21920o.getItem(position), "name")).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements s0.d {
        e() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            HomeFragment.this.W();
            HomeFragment.this.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f21928a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends l<ResponseBody> {
            a() {
            }

            @Override // rx.f
            /* renamed from: F */
            public void onNext(ResponseBody responseBody) {
                j.c("onNext=" + responseBody.toString());
            }

            @Override // rx.f
            public void onCompleted() {
                j.c("onCompleted");
            }

            @Override // rx.f
            public void onError(Throwable e4) {
                e4.printStackTrace();
                j.c("Throwable");
            }
        }

        f(final List val$ads) {
            this.f21928a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f21928a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1665e, H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f21928a.get(position), "clickUrl"));
            intent.putExtra("title", JsonParse.getString((Map) this.f21928a.get(position), "titleName"));
            HomeFragment.this.startActivity(intent);
            ((q.f) Http.getApiService(q.f.class)).p(JsonParse.getString((Map) this.f21928a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).v5(rx.schedulers.c.e()).H3(rx.android.schedulers.a.b()).q5(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Http.with(this.f1665e).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).E1()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f21915j.removeAllViews();
        } else {
            Http.with(this.f1665e).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).O0(LoginUser.getLoginUser().getUserId(), "0", 1, 10)).setDataListener(new c());
        }
    }

    private void a0() {
        this.f21914i.O(false);
        this.f21914i.m1(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(final List<Map<String, Object>> ads) {
        ArrayList arrayList = new ArrayList();
        if (ads != null && ads.size() != 0) {
            for (Map<String, Object> map : ads) {
                arrayList.add(JsonParse.getString(map, "announcementUrl"));
            }
            this.f21917l.setData(arrayList, new f(ads));
        }
        this.f21917l.setIndicators(2131165429, 2131165430);
    }

    public int Y(String imageName) {
        return imageName.equals("ic_home_word") ? getResources().getIdentifier(imageName, "drawable", this.f1665e.getPackageName()) : getResources().getIdentifier(imageName, "mipmap", this.f1665e.getPackageName());
    }

    public void Z() {
        this.f21919n = com.bxkj.student.home.a.b().c();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u66f4\u591a");
        arrayMap.put(RewardPlus.ICON, "icon_more2");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        this.f21919n.add(arrayMap);
        this.f21920o.g(this.f21919n);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21920o.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        try {
            W();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f21916k.setLayoutManager(new GridLayoutManager(this.f1665e, 4));
        a aVar = new a(this.f1665e, 2131427701, this.f21919n);
        this.f21920o = aVar;
        this.f21916k.setAdapter(aVar);
        Z();
        a0();
        X();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21915j = (ViewFlipper) c(2131233285);
        this.f21914i = (SmartRefreshLayout) c(2131232483);
        this.f21916k = (RecyclerView) c(2131232481);
        this.f21917l = (CycleViewPager) c(2131231170);
        this.f21918m = (RecyclerView) c(2131232547);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21916k.setLayoutAnimation(layoutAnimationController);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427629;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f21915j.stopFlipping();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        X();
        this.f21915j.startFlipping();
    }
}
