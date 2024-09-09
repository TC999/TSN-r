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
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.competition.score.CompetitionProjectListActivity;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MenuActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f18903k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f18904l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18905m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.competition.MenuActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0208a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f18907a;

            View$OnClickListenerC0208a(final ViewHolder val$holder) {
                this.f18907a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MenuActivity.this.j0(this.f18907a.g(R.id.bt_name));
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            int i4 = R.id.bt_name;
            holder.J(i4, u.O(stringObjectMap, "name"));
            holder.w(i4, new View$OnClickListenerC0208a(holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String text) {
        if (text.equals("\u7ade\u8d5b\u62a5\u540d")) {
            startActivity(getIntent().setClass(this.f1656h, CompetitionDetailActivity.class));
        } else if (text.equals("\u5f55\u5165\u6210\u7ee9")) {
            startActivity(getIntent().setClass(this.f1656h, CompetitionProjectListActivity.class));
        } else if (text.equals("\u7b7e\u5230")) {
            startActivity(getIntent().setClassName("com.bxkj.teacher", "com.bxkj.teacher.completion.signin.ProjectActivity"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.pub_recycleview;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18903k = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u7ade\u8d5b\u62a5\u540d");
        this.f18903k.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u5f55\u5165\u6210\u7ee9");
        this.f18903k.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u7b7e\u5230");
        this.f18903k.add(arrayMap3);
        this.f18904l.setLayoutManager(new GridLayoutManager(this.f1656h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f18904l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, R.layout.item_for_menu_list, this.f18903k);
        this.f18905m = aVar;
        this.f18904l.setAdapter(aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18904l = (RecyclerView) findViewById(R.id.rv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
