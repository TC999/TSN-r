package com.bxkj.student.home.physicaltest.scanscore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TestScoreListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16603k;

    /* renamed from: l */
    private EmptyRecyclerView f16604l;

    /* renamed from: m */
    private List<Map<String, Object>> f16605m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16606n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4398a extends CommonAdapter<Map<String, Object>> {
        C4398a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m42470o(String str, Map map, View view) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TestScoreListActivity.this.startActivity(new Intent(this.f1721a, TestProjectScoreListActivity.class).putExtra("meaScoreId", str).putExtra("stuName", JsonParse.getString(map, "stuName")).putExtra("stuNum", JsonParse.getString(map, "stuNum")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "meaScoreId");
            holder.m57870N(C4215R.C4219id.tv_rule, TextUtils.isEmpty(string));
            if (TextUtils.isEmpty(string)) {
                holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "year"));
                holder.m57874J(C4215R.C4219id.tv_rule, JsonParse.getString(stringObjectMap, "gradeType"));
            } else {
                holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "year") + "年" + JsonParse.getString(stringObjectMap, "gradeType"));
            }
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "stuName"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "totalScore") + "分");
            holder.m57874J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "meaStatus"));
            holder.m57870N(2131231389, TextUtils.isEmpty(string) ^ true);
            holder.m57847w(2131231055, new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.scanscore.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestScoreListActivity.C4398a.this.m42470o(string, stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4399b extends HttpCallBack {
        C4399b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestScoreListActivity.this.f16605m = (List) data.get("data");
            TestScoreListActivity.this.f16606n.m57836g(TestScoreListActivity.this.f16605m);
        }
    }

    /* renamed from: l0 */
    private void m42473l0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m52z1(LoginUser.getLoginUser().getUserId())).setDataListener(new C4399b());
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
        this.f16604l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16604l.setLayoutAnimation(layoutAnimationController);
        C4398a c4398a = new C4398a(this.f1669h, C4215R.C4221layout.item_for_test_score_list, this.f16605m);
        this.f16606n = c4398a;
        this.f16604l.setAdapter(c4398a);
        this.f16603k.mo2050b0(false);
        this.f16603k.mo2064P(false);
        this.f16603k.setOverScrollMode(2);
        this.f16604l.setEmptyView(findViewById(2131232952));
        m42473l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测成绩汇总");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16603k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16604l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
