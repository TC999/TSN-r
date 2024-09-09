package com.bxkj.student.home.teaching.leave;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.leave.SelectLessenListActivity;
import com.bxkj.student.home.teaching.leave.recorder.LeaveRecordListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SelectLessenListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f21071k;

    /* renamed from: l  reason: collision with root package name */
    private SmartRefreshLayout f21072l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21073m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21074n;

    /* renamed from: o  reason: collision with root package name */
    private int f21075o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f21076p = 10;

    /* renamed from: q  reason: collision with root package name */
    private int f21077q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(ViewHolder viewHolder, Map map, View view) {
            Intent intent = new Intent(this.f1707a, LeaveActivity.class);
            intent.putExtra("position", viewHolder.f());
            intent.putExtra("id", u.O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Map map, View view) {
            Intent intent = new Intent(this.f1707a, LeaveRecordListActivity.class);
            intent.putExtra("id", u.O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233195, u.O(stringObjectMap, "termName"));
            holder.J(2131233198, u.O(stringObjectMap, "schoolTimeName"));
            holder.J(2131233191, u.O(stringObjectMap, "teacherName"));
            holder.J(2131233011, u.O(stringObjectMap, "curriculumName"));
            holder.w(2131230982, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.a.this.p(holder, stringObjectMap, view);
                }
            });
            holder.w(2131231001, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.a.this.q(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            SelectLessenListActivity.this.f21075o = 1;
            SelectLessenListActivity.this.t0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SelectLessenListActivity.this.f21077q / SelectLessenListActivity.this.f21076p;
            int i5 = SelectLessenListActivity.this.f21075o;
            if (SelectLessenListActivity.this.f21077q % SelectLessenListActivity.this.f21076p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SelectLessenListActivity.this.f21072l.h();
                SelectLessenListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            SelectLessenListActivity.n0(SelectLessenListActivity.this);
            SelectLessenListActivity.this.t0();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            SelectLessenListActivity.this.f21072l.y();
            SelectLessenListActivity.this.f21072l.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessenListActivity.this.f21077q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (SelectLessenListActivity.this.f21075o == 1) {
                SelectLessenListActivity.this.f21073m = list;
            } else {
                SelectLessenListActivity.this.f21073m.addAll(list);
            }
            SelectLessenListActivity.this.f21074n.g(SelectLessenListActivity.this.f21073m);
        }
    }

    static /* synthetic */ int n0(SelectLessenListActivity selectLessenListActivity) {
        int i4 = selectLessenListActivity.f21075o;
        selectLessenListActivity.f21075o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).q1(LoginUser.getLoginUser().getUserId())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21071k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21071k.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427712, this.f21073m);
        this.f21074n = aVar;
        this.f21071k.setAdapter(aVar);
        this.f21072l.n1(new b());
        this.f21072l.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u8981\u8bf7\u5047\u7684\u8bfe\u7a0b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21071k = (RecyclerView) findViewById(2131232481);
        this.f21072l = (SmartRefreshLayout) findViewById(2131232482);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void u0(int position) {
        CommonAdapter<Map<String, Object>> commonAdapter = this.f21074n;
        if (commonAdapter == null || position >= commonAdapter.getItemCount() || position < 0) {
            return;
        }
        this.f21074n.getItem(position).put("status", "\u5f85\u5ba1\u6838");
        this.f21074n.notifyItemChanged(position);
    }
}
