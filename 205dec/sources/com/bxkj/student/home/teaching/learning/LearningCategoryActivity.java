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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LearningCategoryActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Map<String, Object>> f20543k;

    /* renamed from: l  reason: collision with root package name */
    private SmartRefreshLayout f20544l;

    /* renamed from: m  reason: collision with root package name */
    private EmptyRecyclerView f20545m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20546n;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20547o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.learning.LearningCategoryActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0236a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f20549a;

            View$OnClickListenerC0236a(final ViewHolder val$holder) {
                this.f20549a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                Intent intent = new Intent();
                intent.putExtra("index", a.this.e(this.f20549a));
                LearningCategoryActivity.this.setResult(-1, intent);
                LearningCategoryActivity.this.finish();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.w(2131231055, new View$OnClickListenerC0236a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("list")) {
            this.f20543k = (ArrayList) getIntent().getSerializableExtra("list");
        }
        this.f20545m.setLayoutManager(new GridLayoutManager(this.f1656h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20545m.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427756, this.f20543k);
        this.f20547o = aVar;
        this.f20545m.setAdapter(aVar);
        this.f20545m.setEmptyView(this.f20546n);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5168\u90e8\u9891\u9053");
        a0(false);
        b0(2131558602, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.n
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearningCategoryActivity.this.j0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20544l = (SmartRefreshLayout) findViewById(2131232482);
        this.f20545m = (EmptyRecyclerView) findViewById(2131232481);
        this.f20546n = (TextView) findViewById(2131232952);
        this.f20544l.b0(false);
        this.f20544l.O(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
