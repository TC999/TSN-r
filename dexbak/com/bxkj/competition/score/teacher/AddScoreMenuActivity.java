package com.bxkj.competition.score.teacher;

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
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.C4017R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AddScoreMenuActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f15492k;

    /* renamed from: l */
    private RecyclerView f15493l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f15494m;

    /* renamed from: com.bxkj.competition.score.teacher.AddScoreMenuActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4071a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.score.teacher.AddScoreMenuActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4072a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ String f15496a;

            /* renamed from: b */
            final /* synthetic */ int f15497b;

            View$OnClickListenerC4072a(final String val$type, final int val$name) {
                this.f15496a = val$type;
                this.f15497b = val$name;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AddScoreMenuActivity addScoreMenuActivity = AddScoreMenuActivity.this;
                addScoreMenuActivity.startActivity(addScoreMenuActivity.getIntent().setClass(((CommonAdapter) C4071a.this).f1721a, TrackScoreListActivity.class).putExtra("menu", this.f15496a).putExtra("type", this.f15497b));
            }
        }

        C4071a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "name");
            int i = JsonParse.getInt(stringObjectMap, "type");
            int i2 = C4017R.C4021id.bt_name;
            holder.m57874J(i2, string);
            holder.m57847w(i2, new View$OnClickListenerC4072a(string, i));
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
        this.f15492k = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", 1);
        arrayMap.put("name", ScoreMenu.START);
        this.f15492k.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("type", 1);
        arrayMap2.put("name", ScoreMenu.CHECK);
        this.f15492k.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("type", 0);
        arrayMap3.put("name", ScoreMenu.RANK);
        this.f15492k.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("type", 0);
        arrayMap4.put("name", ScoreMenu.TIME);
        this.f15492k.add(arrayMap4);
        this.f15493l.setLayoutManager(new GridLayoutManager(this.f1669h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15493l.setLayoutAnimation(layoutAnimationController);
        C4071a c4071a = new C4071a(this.f1669h, C4017R.C4023layout.item_for_menu_list, this.f15492k);
        this.f15494m = c4071a;
        this.f15493l.setAdapter(c4071a);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择要录入的内容");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15493l = (RecyclerView) findViewById(C4017R.C4021id.f15344rv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
