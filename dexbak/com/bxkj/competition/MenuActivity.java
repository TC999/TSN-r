package com.bxkj.competition;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.competition.score.CompetitionProjectListActivity;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MenuActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f15333k;

    /* renamed from: l */
    private RecyclerView f15334l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f15335m;

    /* renamed from: com.bxkj.competition.MenuActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4015a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.MenuActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4016a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f15337a;

            View$OnClickListenerC4016a(final ViewHolder val$holder) {
                this.f15337a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MenuActivity.this.m43457j0(this.f15337a.m57863g(C4017R.C4021id.bt_name));
            }
        }

        C4015a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.bt_name;
            holder.m57874J(i, Tools.m57632O(stringObjectMap, "name"));
            holder.m57847w(i, new View$OnClickListenerC4016a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public void m43457j0(String text) {
        if (text.equals("竞赛报名")) {
            startActivity(getIntent().setClass(this.f1669h, CompetitionDetailActivity.class));
        } else if (text.equals("录入成绩")) {
            startActivity(getIntent().setClass(this.f1669h, CompetitionProjectListActivity.class));
        } else if (text.equals("签到")) {
            startActivity(getIntent().setClassName("com.bxkj.teacher", "com.bxkj.teacher.completion.signin.ProjectActivity"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.pub_recycleview;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f15333k = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "竞赛报名");
        this.f15333k.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "录入成绩");
        this.f15333k.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "签到");
        this.f15333k.add(arrayMap3);
        this.f15334l.setLayoutManager(new GridLayoutManager(this.f1669h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15334l.setLayoutAnimation(layoutAnimationController);
        C4015a c4015a = new C4015a(this.f1669h, C4017R.C4023layout.item_for_menu_list, this.f15333k);
        this.f15335m = c4015a;
        this.f15334l.setAdapter(c4015a);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15334l = (RecyclerView) findViewById(C4017R.C4021id.f15344rv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
