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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.leave.SelectLessenListActivity;
import com.bxkj.student.home.teaching.leave.recorder.LeaveRecordListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SelectLessenListActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f17733k;

    /* renamed from: l */
    private SmartRefreshLayout f17734l;

    /* renamed from: m */
    private List<Map<String, Object>> f17735m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17736n;

    /* renamed from: o */
    private int f17737o = 1;

    /* renamed from: p */
    private int f17738p = 10;

    /* renamed from: q */
    private int f17739q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.leave.SelectLessenListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4769a extends CommonAdapter<Map<String, Object>> {
        C4769a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m41387p(ViewHolder viewHolder, Map map, View view) {
            Intent intent = new Intent(this.f1721a, LeaveActivity.class);
            intent.putExtra("position", viewHolder.m57864f());
            intent.putExtra("id", Tools.m57632O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m41386q(Map map, View view) {
            Intent intent = new Intent(this.f1721a, LeaveRecordListActivity.class);
            intent.putExtra("id", Tools.m57632O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_term, Tools.m57632O(stringObjectMap, "termName"));
            holder.m57874J(2131233198, Tools.m57632O(stringObjectMap, "schoolTimeName"));
            holder.m57874J(C4215R.C4219id.tv_teacher, Tools.m57632O(stringObjectMap, "teacherName"));
            holder.m57874J(C4215R.C4219id.tv_lessen_name, Tools.m57632O(stringObjectMap, "curriculumName"));
            holder.m57847w(C4215R.C4219id.bt_leave, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.C4769a.this.m41387p(holder, stringObjectMap, view);
                }
            });
            holder.m57847w(C4215R.C4219id.bt_recorder, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.C4769a.this.m41386q(stringObjectMap, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.leave.SelectLessenListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4770b implements OnRefreshLoadmoreListener {
        C4770b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SelectLessenListActivity.this.f17737o = 1;
            SelectLessenListActivity.this.m41392t0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SelectLessenListActivity.this.f17739q / SelectLessenListActivity.this.f17738p;
            int i2 = SelectLessenListActivity.this.f17737o;
            if (SelectLessenListActivity.this.f17739q % SelectLessenListActivity.this.f17738p != 0) {
                i++;
            }
            if (i2 >= i) {
                SelectLessenListActivity.this.f17734l.mo2041g();
                SelectLessenListActivity.this.m57919h0("没有了");
                return;
            }
            SelectLessenListActivity.m41398n0(SelectLessenListActivity.this);
            SelectLessenListActivity.this.m41392t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.leave.SelectLessenListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4771c extends HttpCallBack {
        C4771c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            SelectLessenListActivity.this.f17734l.mo2078B();
            SelectLessenListActivity.this.f17734l.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessenListActivity.this.f17739q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (SelectLessenListActivity.this.f17737o == 1) {
                SelectLessenListActivity.this.f17735m = list;
            } else {
                SelectLessenListActivity.this.f17735m.addAll(list);
            }
            SelectLessenListActivity.this.f17736n.m57836g(SelectLessenListActivity.this.f17735m);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m41398n0(SelectLessenListActivity selectLessenListActivity) {
        int i = selectLessenListActivity.f17737o;
        selectLessenListActivity.f17737o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m41392t0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m79q1(LoginUser.getLoginUser().getUserId())).setDataListener(new C4771c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17733k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17733k.setLayoutAnimation(layoutAnimationController);
        C4769a c4769a = new C4769a(this.f1669h, C4215R.C4221layout.item_for_leave_list, this.f17735m);
        this.f17736n = c4769a;
        this.f17733k.setAdapter(c4769a);
        this.f17734l.mo2019v(new C4770b());
        this.f17734l.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择要请假的课程");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17733k = (RecyclerView) findViewById(2131232481);
        this.f17734l = (SmartRefreshLayout) findViewById(2131232482);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: u0 */
    public void m41391u0(int position) {
        CommonAdapter<Map<String, Object>> commonAdapter = this.f17736n;
        if (commonAdapter == null || position >= commonAdapter.getItemCount() || position < 0) {
            return;
        }
        this.f17736n.getItem(position).put("status", "待审核");
        this.f17736n.notifyItemChanged(position);
    }
}
