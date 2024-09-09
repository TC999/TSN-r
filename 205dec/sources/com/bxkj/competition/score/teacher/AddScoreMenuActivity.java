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
import com.bxkj.competition.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AddScoreMenuActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f19036k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f19037l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19038m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.competition.score.teacher.AddScoreMenuActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0209a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f19040a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19041b;

            View$OnClickListenerC0209a(final String val$type, final int val$name) {
                this.f19040a = val$type;
                this.f19041b = val$name;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                AddScoreMenuActivity addScoreMenuActivity = AddScoreMenuActivity.this;
                addScoreMenuActivity.startActivity(addScoreMenuActivity.getIntent().setClass(((CommonAdapter) a.this).f1707a, TrackScoreListActivity.class).putExtra("menu", this.f19040a).putExtra("type", this.f19041b));
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "name");
            int i4 = JsonParse.getInt(stringObjectMap, "type");
            int i5 = R.id.bt_name;
            holder.J(i5, string);
            holder.w(i5, new View$OnClickListenerC0209a(string, i4));
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
        this.f19036k = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", 1);
        arrayMap.put("name", "\u8d77\u70b9");
        this.f19036k.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("type", 1);
        arrayMap2.put("name", "\u68c0\u67e5");
        this.f19036k.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("type", 0);
        arrayMap3.put("name", "\u540d\u6b21");
        this.f19036k.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("type", 0);
        arrayMap4.put("name", "\u65f6\u95f4");
        this.f19036k.add(arrayMap4);
        this.f19037l.setLayoutManager(new GridLayoutManager(this.f1656h, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19037l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, R.layout.item_for_menu_list, this.f19036k);
        this.f19038m = aVar;
        this.f19037l.setAdapter(aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u8981\u5f55\u5165\u7684\u5185\u5bb9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19037l = (RecyclerView) findViewById(R.id.rv);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
