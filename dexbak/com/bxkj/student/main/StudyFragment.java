package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.study.VideoPlayActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p635q.MainApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StudyFragment extends BaseFragment {

    /* renamed from: h */
    private RecyclerView f18672h;

    /* renamed from: i */
    private CommonAdapter<Map<String, Object>> f18673i;

    /* renamed from: j */
    private List<Map<String, Object>> f18674j;

    /* renamed from: k */
    private SmartRefreshLayout f18675k;

    /* renamed from: l */
    private RecyclerView f18676l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f18677m;

    /* renamed from: n */
    private List<Map<String, Object>> f18678n = new ArrayList();

    /* renamed from: o */
    private int f18679o = 0;

    /* renamed from: p */
    private int f18680p = 1;

    /* renamed from: q */
    private int f18681q = 10;

    /* renamed from: r */
    private int f18682r = 1;

    /* renamed from: com.bxkj.student.main.StudyFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5093a extends CommonAdapter<Map<String, Object>> {
        C5093a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57870N(C4215R.C4219id.iv_zan, JsonParse.getString(stringObjectMap, "name").equals("推荐"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57853q(C4215R.C4219id.f15999iv, holder.m57864f() == StudyFragment.this.f18679o ? StudyFragment.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* renamed from: com.bxkj.student.main.StudyFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5094b extends CommonAdapter<Map<String, Object>> {
        C5094b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "title"));
            holder.m57874J(C4215R.C4219id.tv_play_num, JsonParse.getString(stringObjectMap, "playNum"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "uploadDate"));
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "coverImg"), C4215R.mipmap.icon_play2, C4215R.mipmap.icon_play2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.StudyFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5095c implements OnRefreshLoadmoreListener {
        C5095c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            StudyFragment.this.f18680p = 1;
            if (StudyFragment.this.f18678n.isEmpty()) {
                StudyFragment.this.m40594g0();
            } else {
                StudyFragment.this.m40595f0();
            }
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = StudyFragment.this.f18682r / StudyFragment.this.f18681q;
            int i2 = StudyFragment.this.f18680p;
            if (StudyFragment.this.f18682r % StudyFragment.this.f18681q != 0) {
                i++;
            }
            if (i2 >= i) {
                StudyFragment.this.f18675k.mo2041g();
                StudyFragment.this.m57918D("没有了");
                return;
            }
            StudyFragment.m40603X(StudyFragment.this);
            StudyFragment.this.m40595f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.StudyFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5096d extends HttpCallBack {
        C5096d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (StudyFragment.this.f18675k.mo2061S()) {
                StudyFragment.this.f18675k.mo2078B();
            }
            if (StudyFragment.this.f18675k.mo2015z()) {
                StudyFragment.this.f18675k.mo2041g();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f18674j = JsonParse.getList(data, "data");
            StudyFragment.this.m40592i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.StudyFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5097e extends HttpCallBack {
        C5097e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            StudyFragment.this.f18675k.mo2078B();
            StudyFragment.this.f18675k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f18682r = JsonParse.getInt(data, "total");
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (StudyFragment.this.f18680p == 1) {
                StudyFragment.this.f18678n = list;
            } else {
                StudyFragment.this.f18678n.addAll(list);
            }
            StudyFragment.this.f18677m.m57836g(StudyFragment.this.f18678n);
        }
    }

    /* renamed from: com.bxkj.student.main.StudyFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5098f implements OnItemClickListener {
        C5098f() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            StudyFragment.this.f18673i.notifyItemChanged(StudyFragment.this.f18679o);
            StudyFragment.this.f18679o = position;
            StudyFragment.this.f18673i.notifyItemChanged(StudyFragment.this.f18679o);
            StudyFragment.this.f18675k.mo2052a0();
        }
    }

    /* renamed from: com.bxkj.student.main.StudyFragment$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5099g implements OnItemClickListener {
        C5099g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            StudyFragment.this.startActivity(new Intent(((BaseFragment) StudyFragment.this).f1678e, VideoPlayActivity.class).putExtra("videoId", JsonParse.getString((Map) StudyFragment.this.f18677m.getItem(position), "id")).putExtra("videoName", JsonParse.getString((Map) StudyFragment.this.f18677m.getItem(position), "title")));
        }
    }

    /* renamed from: X */
    static /* synthetic */ int m40603X(StudyFragment studyFragment) {
        int i = studyFragment.f18680p;
        studyFragment.f18680p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public void m40595f0() {
        if (this.f18673i.getItemCount() > 0) {
            Http.with(this.f1678e).hideLoadingDialog().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2272e(LoginUser.getLoginUser().getSchoolId(), "", JsonParse.getString(this.f18673i.getItem(this.f18679o), "id"), this.f18680p, this.f18681q)).setDataListener(new C5097e());
            return;
        }
        this.f18675k.mo2078B();
        this.f18675k.mo2041g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public void m40594g0() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2267j(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new C5096d());
    }

    /* renamed from: h0 */
    private void m40593h0() {
        this.f18675k.mo2019v(new C5095c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public void m40592i0() {
        HashMap hashMap = new HashMap(10);
        hashMap.put("id", "groom");
        hashMap.put("name", "推荐");
        this.f18674j.add(0, hashMap);
        this.f18673i.m57836g(this.f18674j);
        m40595f0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18673i.m57834k(new C5098f());
        this.f18677m.m57834k(new C5099g());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        this.f18672h.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18672h.setLayoutAnimation(layoutAnimationController);
        this.f18672h.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
        C5093a c5093a = new C5093a(this.f1678e, C4215R.C4221layout.item_for_video_type_list, this.f18674j);
        this.f18673i = c5093a;
        this.f18672h.setAdapter(c5093a);
        this.f18676l.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f18676l.setLayoutAnimation(layoutAnimationController2);
        C5094b c5094b = new C5094b(this.f1678e, C4215R.C4221layout.item_for_video_list, this.f18678n);
        this.f18677m = c5094b;
        this.f18676l.setAdapter(c5094b);
        m40593h0();
        m40594g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18672h = (RecyclerView) m57916c(C4215R.C4219id.rv_type);
        this.f18676l = (RecyclerView) m57916c(C4215R.C4219id.rv_video_list);
        this.f18675k = (SmartRefreshLayout) m57916c(2131232483);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_discover;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
