package com.bxkj.student.home.teaching.learning.ready;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SelectLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f21039k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21040l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21041m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21042n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f21043o;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21044p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21045q;

    /* renamed from: r  reason: collision with root package name */
    private int f21046r = 0;

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
            ((TextView) holder.h(2131233040)).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.q(2131231382, holder.f() == SelectLessonActivity.this.f21046r ? SelectLessonActivity.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            SelectLessonActivity.this.B0(JsonParse.getString(map, "id"), JsonParse.getString(map, "typeName"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.w(2131231055, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.ready.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessonActivity.b.this.o(stringObjectMap, view);
                }
            });
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.f21039k = (List) data.get("data");
            SelectLessonActivity.this.f21041m.g(SelectLessonActivity.this.f21039k);
            if (SelectLessonActivity.this.f21039k == null || SelectLessonActivity.this.f21039k.size() <= 0) {
                return;
            }
            Map map = (Map) SelectLessonActivity.this.f21039k.get(0);
            if (JsonParse.getInt(map, "isCurriculum") == 0) {
                SelectLessonActivity.this.y0(JsonParse.getString(map, "id"));
                return;
            }
            SelectLessonActivity.this.f21043o.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 5.0f;
            SelectLessonActivity.this.f21040l.setLayoutParams(layoutParams);
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.f21042n = (List) data.get("data");
            SelectLessonActivity.this.f21044p.g(SelectLessonActivity.this.f21042n);
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.startActivity(new Intent(((BaseActivity) SelectLessonActivity.this).f1656h, LearnHomeListActivity.class));
            SelectLessonActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(String str) {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).s(str)).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final String id, String name) {
        iOSTwoButtonDialog title = new iOSTwoButtonDialog(this.f1656h).setTitle("\u63d0\u793a");
        title.setMessage("\u786e\u5b9a\u60a8\u8981\u9009\u62e9" + name + "\u5417?").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.ready.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                SelectLessonActivity.this.A0(id);
            }
        }).show();
    }

    private void w0() {
        this.f21043o = (RecyclerView) findViewById(2131232540);
        this.f21040l = (RecyclerView) findViewById(2131232548);
        this.f21045q = (TextView) findViewById(2131233060);
    }

    private void x0() {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).j()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String pid) {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).f(pid)).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(ViewGroup viewGroup, View view, Object obj, int i4) {
        this.f21046r = i4;
        this.f21041m.notifyDataSetChanged();
        this.f21042n.clear();
        this.f21044p.notifyDataSetChanged();
        Map<String, Object> item = this.f21041m.getItem(i4);
        String string = JsonParse.getString(item, "id");
        String string2 = JsonParse.getString(item, "typeName");
        if (JsonParse.getInt(item, "isCurriculum") == 0) {
            y0(string);
        } else {
            B0(string, string2);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21041m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.ready.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                SelectLessonActivity.this.z0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427490;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21039k = new ArrayList();
        this.f21040l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21040l.setLayoutAnimation(layoutAnimationController);
        this.f21040l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        a aVar = new a(this.f1656h, 2131427760, this.f21039k);
        this.f21041m = aVar;
        this.f21040l.setAdapter(aVar);
        this.f21042n = new ArrayList();
        this.f21043o.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f21043o.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.f1656h, 2131427756, this.f21042n);
        this.f21044p = bVar;
        this.f21043o.setAdapter(bVar);
        x0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        a0(false);
        setTitle("\u9009\u62e9\u8bfe\u7a0b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        w0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
