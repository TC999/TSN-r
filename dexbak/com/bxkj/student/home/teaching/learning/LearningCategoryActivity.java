package com.bxkj.student.home.teaching.learning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LearningCategoryActivity extends BaseActivity {

    /* renamed from: k */
    private ArrayList<Map<String, Object>> f17188k;

    /* renamed from: l */
    private SmartRefreshLayout f17189l;

    /* renamed from: m */
    private EmptyRecyclerView f17190m;

    /* renamed from: n */
    private TextView f17191n;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f17192o;

    /* renamed from: com.bxkj.student.home.teaching.learning.LearningCategoryActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4588a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.learning.LearningCategoryActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4589a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f17194a;

            View$OnClickListenerC4589a(final ViewHolder val$holder) {
                this.f17194a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("index", C4588a.this.mo57829e(this.f17194a));
                LearningCategoryActivity.this.setResult(-1, intent);
                LearningCategoryActivity.this.finish();
            }
        }

        C4588a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.m57847w(2131231055, new View$OnClickListenerC4589a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m41916j0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("list")) {
            this.f17188k = (ArrayList) getIntent().getSerializableExtra("list");
        }
        this.f17190m.setLayoutManager(new GridLayoutManager(this.f1669h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17190m.setLayoutAnimation(layoutAnimationController);
        C4588a c4588a = new C4588a(this.f1669h, C4215R.C4221layout.item_for_school_list, this.f17188k);
        this.f17192o = c4588a;
        this.f17190m.setAdapter(c4588a);
        this.f17190m.setEmptyView(this.f17191n);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("全部频道");
        m57926a0(false);
        m57925b0(2131558602, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.learning.n
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                LearningCategoryActivity.this.m41916j0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17189l = (SmartRefreshLayout) findViewById(2131232482);
        this.f17190m = (EmptyRecyclerView) findViewById(2131232481);
        this.f17191n = (TextView) findViewById(2131232952);
        this.f17189l.mo2050b0(false);
        this.f17189l.mo2064P(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
