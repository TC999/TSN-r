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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.HomeMenu;
import com.bxkj.student.home.MenuOperate;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.orhanobut.logger.C11792j;
import com.p518qq.p519e.comm.constants.Constants;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p635q.MainApiService;
import p638r0.RefreshLayout;
import p640rx.Subscriber;
import p640rx.android.schedulers.AndroidSchedulers;
import p640rx.schedulers.Schedulers;
import p642s0.OnRefreshListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HomeFragment extends BaseFragment {

    /* renamed from: i */
    private SmartRefreshLayout f18607i;

    /* renamed from: j */
    private ViewFlipper f18608j;

    /* renamed from: k */
    private RecyclerView f18609k;

    /* renamed from: l */
    private CycleViewPager f18610l;

    /* renamed from: m */
    private RecyclerView f18611m;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f18613o;

    /* renamed from: h */
    private final String f18606h = "groupType";

    /* renamed from: n */
    private List<Map<String, Object>> f18612n = new ArrayList();

    /* renamed from: com.bxkj.student.main.HomeFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5072a extends CommonAdapter<Map<String, Object>> {
        C5072a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57852r(2131231433, HomeFragment.this.m40661Y(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.HomeFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5073b extends HttpCallBack {
        C5073b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (HomeFragment.this.f18607i == null || !HomeFragment.this.f18607i.mo2061S()) {
                return;
            }
            HomeFragment.this.f18607i.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.m40658b0(JsonParse.getList(data, "data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.HomeFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5074c extends HttpCallBack {

        /* renamed from: com.bxkj.student.main.HomeFragment$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC5075a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18617a;

            View$OnClickListenerC5075a(final Map val$stringObjectMap) {
                this.f18617a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1678e, H5DetailActivity.class);
                intent.putExtra("title", Tools.m57632O(this.f18617a, "title"));
                intent.putExtra("url", Tools.m57632O(this.f18617a, "url"));
                HomeFragment.this.startActivity(intent);
            }
        }

        C5074c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeFragment.this.f18608j.removeAllViews();
            for (Map map : (List) data.get("data")) {
                View inflate = View.inflate(((BaseFragment) HomeFragment.this).f1678e, C4215R.C4221layout.item_notice, null);
                ImageView imageView = (ImageView) inflate.findViewById(C4215R.C4219id.iv_not_read);
                int i = 8;
                inflate.findViewById(2131231389).setVisibility(8);
                ((TextView) inflate.findViewById(2131233204)).setText(Tools.m57632O(map, "title"));
                if (Tools.m57632O(map, "isread").equals("0")) {
                    i = 0;
                }
                imageView.setVisibility(i);
                inflate.setOnClickListener(new View$OnClickListenerC5075a(map));
                HomeFragment.this.f18608j.addView(inflate);
            }
        }
    }

    /* renamed from: com.bxkj.student.main.HomeFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5076d implements OnItemClickListener {
        C5076d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            new MenuOperate(HomeFragment.this.getActivity(), JsonParse.getString((Map) HomeFragment.this.f18613o.getItem(position), RewardPlus.ICON), JsonParse.getString((Map) HomeFragment.this.f18613o.getItem(position), "name")).m42712f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.HomeFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5077e implements OnRefreshListener {
        C5077e() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            HomeFragment.this.m40663W();
            HomeFragment.this.m40662X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.HomeFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5078f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a */
        final /* synthetic */ List f18621a;

        /* renamed from: com.bxkj.student.main.HomeFragment$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5079a extends Subscriber<ResponseBody> {
            C5079a() {
            }

            @Override // p640rx.Observer
            /* renamed from: F */
            public void onNext(ResponseBody responseBody) {
                C11792j.m20470c("onNext=" + responseBody.toString());
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C11792j.m20470c("onCompleted");
            }

            @Override // p640rx.Observer
            public void onError(Throwable e) {
                e.printStackTrace();
                C11792j.m20470c("Throwable");
            }
        }

        C5078f(final List val$ads) {
            this.f18621a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f18621a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseFragment) HomeFragment.this).f1678e, H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f18621a.get(position), Constants.KEYS.EXPOSED_CLICK_URL_KEY));
            intent.putExtra("title", JsonParse.getString((Map) this.f18621a.get(position), "titleName"));
            HomeFragment.this.startActivity(intent);
            ((MainApiService) Http.getApiService(MainApiService.class)).m2261p(JsonParse.getString((Map) this.f18621a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).m1511v5(Schedulers.m475e()).m1833H3(AndroidSchedulers.m1982b()).m1551q5(new C5079a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public void m40663W() {
        Http.with(this.f1678e).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m175E1()).setDataListener(new C5073b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public void m40662X() {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f18608j.removeAllViews();
        } else {
            Http.with(this.f1678e).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m152O0(LoginUser.getLoginUser().getUserId(), "0", 1, 10)).setDataListener(new C5074c());
        }
    }

    /* renamed from: a0 */
    private void m40659a0() {
        this.f18607i.mo2064P(false);
        this.f18607i.mo2035j(new C5077e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m40658b0(final List<Map<String, Object>> ads) {
        ArrayList arrayList = new ArrayList();
        if (ads != null && ads.size() != 0) {
            for (Map<String, Object> map : ads) {
                arrayList.add(JsonParse.getString(map, "announcementUrl"));
            }
            this.f18610l.setData(arrayList, new C5078f(ads));
        }
        this.f18610l.setIndicators(2131165429, 2131165430);
    }

    /* renamed from: Y */
    public int m40661Y(String imageName) {
        return imageName.equals("ic_home_word") ? getResources().getIdentifier(imageName, "drawable", this.f1678e.getPackageName()) : getResources().getIdentifier(imageName, "mipmap", this.f1678e.getPackageName());
    }

    /* renamed from: Z */
    public void m40660Z() {
        this.f18612n = HomeMenu.m42720b().m42719c();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "更多");
        arrayMap.put(RewardPlus.ICON, "icon_more2");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        this.f18612n.add(arrayMap);
        this.f18613o.m57836g(this.f18612n);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18613o.m57834k(new C5076d());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        try {
            m40663W();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f18609k.setLayoutManager(new GridLayoutManager(this.f1678e, 4));
        C5072a c5072a = new C5072a(this.f1678e, C4215R.C4221layout.item_for_home_menu, this.f18612n);
        this.f18613o = c5072a;
        this.f18609k.setAdapter(c5072a);
        m40660Z();
        m40659a0();
        m40662X();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18608j = (ViewFlipper) m57916c(2131233285);
        this.f18607i = (SmartRefreshLayout) m57916c(2131232483);
        this.f18609k = (RecyclerView) m57916c(2131232481);
        this.f18610l = (CycleViewPager) m57916c(2131231170);
        this.f18611m = (RecyclerView) m57916c(C4215R.C4219id.rv_info);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18609k.setLayoutAnimation(layoutAnimationController);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_home;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f18608j.stopFlipping();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m40662X();
        this.f18608j.startFlipping();
    }
}
