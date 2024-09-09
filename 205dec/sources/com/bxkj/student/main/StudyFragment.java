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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.study.VideoPlayActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StudyFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f21972h;

    /* renamed from: i  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21973i;

    /* renamed from: j  reason: collision with root package name */
    private List<Map<String, Object>> f21974j;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21975k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21976l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21977m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21978n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f21979o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f21980p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f21981q = 10;

    /* renamed from: r  reason: collision with root package name */
    private int f21982r = 1;

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
            holder.N(2131231509, JsonParse.getString(stringObjectMap, "name").equals("\u63a8\u8350"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.q(2131231382, holder.f() == StudyFragment.this.f21979o ? StudyFragment.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "title"));
            holder.J(2131233096, JsonParse.getString(stringObjectMap, "playNum"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "uploadDate"));
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "coverImg"), 2131558727, 2131558727);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements s0.e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            StudyFragment.this.f21980p = 1;
            if (StudyFragment.this.f21978n.isEmpty()) {
                StudyFragment.this.g0();
            } else {
                StudyFragment.this.f0();
            }
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = StudyFragment.this.f21982r / StudyFragment.this.f21981q;
            int i5 = StudyFragment.this.f21980p;
            if (StudyFragment.this.f21982r % StudyFragment.this.f21981q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                StudyFragment.this.f21975k.h();
                StudyFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            StudyFragment.X(StudyFragment.this);
            StudyFragment.this.f0();
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
            if (StudyFragment.this.f21975k.S()) {
                StudyFragment.this.f21975k.y();
            }
            if (StudyFragment.this.f21975k.z()) {
                StudyFragment.this.f21975k.h();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f21974j = JsonParse.getList(data, "data");
            StudyFragment.this.i0();
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
            StudyFragment.this.f21975k.y();
            StudyFragment.this.f21975k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudyFragment.this.f21982r = JsonParse.getInt(data, "total");
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (StudyFragment.this.f21980p == 1) {
                StudyFragment.this.f21978n = list;
            } else {
                StudyFragment.this.f21978n.addAll(list);
            }
            StudyFragment.this.f21977m.g(StudyFragment.this.f21978n);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        f() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            StudyFragment.this.f21973i.notifyItemChanged(StudyFragment.this.f21979o);
            StudyFragment.this.f21979o = position;
            StudyFragment.this.f21973i.notifyItemChanged(StudyFragment.this.f21979o);
            StudyFragment.this.f21975k.a0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class g implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            StudyFragment.this.startActivity(new Intent(((BaseFragment) StudyFragment.this).f1665e, VideoPlayActivity.class).putExtra("videoId", JsonParse.getString((Map) StudyFragment.this.f21977m.getItem(position), "id")).putExtra("videoName", JsonParse.getString((Map) StudyFragment.this.f21977m.getItem(position), "title")));
        }
    }

    static /* synthetic */ int X(StudyFragment studyFragment) {
        int i4 = studyFragment.f21980p;
        studyFragment.f21980p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        if (this.f21973i.getItemCount() > 0) {
            Http.with(this.f1665e).hideLoadingDialog().setObservable(((q.f) Http.getApiService(q.f.class)).e(LoginUser.getLoginUser().getSchoolId(), "", JsonParse.getString(this.f21973i.getItem(this.f21979o), "id"), this.f21980p, this.f21981q)).setDataListener(new e());
            return;
        }
        this.f21975k.y();
        this.f21975k.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((q.f) Http.getApiService(q.f.class)).j(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    private void h0() {
        this.f21975k.n1(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        HashMap hashMap = new HashMap(10);
        hashMap.put("id", "groom");
        hashMap.put("name", "\u63a8\u8350");
        this.f21974j.add(0, hashMap);
        this.f21973i.g(this.f21974j);
        f0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21973i.k(new f());
        this.f21977m.k(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f21972h.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21972h.setLayoutAnimation(layoutAnimationController);
        this.f21972h.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
        a aVar = new a(this.f1665e, 2131427776, this.f21974j);
        this.f21973i = aVar;
        this.f21972h.setAdapter(aVar);
        this.f21976l.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f21976l.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.f1665e, 2131427775, this.f21978n);
        this.f21977m = bVar;
        this.f21976l.setAdapter(bVar);
        h0();
        g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21972h = (RecyclerView) c(2131232561);
        this.f21976l = (RecyclerView) c(2131232563);
        this.f21975k = (SmartRefreshLayout) c(2131232483);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427625;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
