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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SelectLessonActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f17701k;

    /* renamed from: l */
    private RecyclerView f17702l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f17703m;

    /* renamed from: n */
    private List<Map<String, Object>> f17704n;

    /* renamed from: o */
    private RecyclerView f17705o;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f17706p;

    /* renamed from: q */
    private TextView f17707q;

    /* renamed from: r */
    private int f17708r = 0;

    /* renamed from: com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4758a extends CommonAdapter<Map<String, Object>> {
        C4758a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ((TextView) holder.m57862h(2131233040)).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.m57853q(C4215R.C4219id.f15999iv, holder.m57864f() == SelectLessonActivity.this.f17708r ? SelectLessonActivity.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4759b extends CommonAdapter<Map<String, Object>> {
        C4759b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m41413o(Map map, View view) {
            SelectLessonActivity.this.m41435B0(JsonParse.getString(map, "id"), JsonParse.getString(map, "typeName"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "typeName"));
            holder.m57847w(2131231055, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.ready.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessonActivity.C4759b.this.m41413o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4760c extends HttpCallBack {
        C4760c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.f17701k = (List) data.get("data");
            SelectLessonActivity.this.f17703m.m57836g(SelectLessonActivity.this.f17701k);
            if (SelectLessonActivity.this.f17701k == null || SelectLessonActivity.this.f17701k.size() <= 0) {
                return;
            }
            Map map = (Map) SelectLessonActivity.this.f17701k.get(0);
            if (JsonParse.getInt(map, "isCurriculum") == 0) {
                SelectLessonActivity.this.m41418y0(JsonParse.getString(map, "id"));
                return;
            }
            SelectLessonActivity.this.f17705o.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 5.0f;
            SelectLessonActivity.this.f17702l.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4761d extends HttpCallBack {
        C4761d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.f17704n = (List) data.get("data");
            SelectLessonActivity.this.f17706p.m57836g(SelectLessonActivity.this.f17704n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4762e extends HttpCallBack {
        C4762e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.startActivity(new Intent(((BaseActivity) SelectLessonActivity.this).f1669h, LearnHomeListActivity.class));
            SelectLessonActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void m41436A0(String str) {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41623s(str)).setDataListener(new C4762e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public void m41435B0(final String id, String name) {
        iOSTwoButtonDialog title = new iOSTwoButtonDialog(this.f1669h).setTitle("提示");
        title.setMessage("确定您要选择" + name + "吗?").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.ready.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                SelectLessonActivity.this.m41436A0(id);
            }
        }).show();
    }

    /* renamed from: w0 */
    private void m41420w0() {
        this.f17705o = (RecyclerView) findViewById(2131232540);
        this.f17702l = (RecyclerView) findViewById(2131232548);
        this.f17707q = (TextView) findViewById(C4215R.C4219id.tv_other);
    }

    /* renamed from: x0 */
    private void m41419x0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41632j()).setDataListener(new C4760c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m41418y0(String pid) {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41636f(pid)).setDataListener(new C4761d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void m41417z0(ViewGroup viewGroup, View view, Object obj, int i) {
        this.f17708r = i;
        this.f17703m.notifyDataSetChanged();
        this.f17704n.clear();
        this.f17706p.notifyDataSetChanged();
        Map<String, Object> item = this.f17703m.getItem(i);
        String string = JsonParse.getString(item, "id");
        String string2 = JsonParse.getString(item, "typeName");
        if (JsonParse.getInt(item, "isCurriculum") == 0) {
            m41418y0(string);
        } else {
            m41435B0(string, string2);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17703m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.ready.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                SelectLessonActivity.this.m41417z0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_select_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17701k = new ArrayList();
        this.f17702l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17702l.setLayoutAnimation(layoutAnimationController);
        this.f17702l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C4758a c4758a = new C4758a(this.f1669h, C4215R.C4221layout.item_for_select_learn_lesson_list, this.f17701k);
        this.f17703m = c4758a;
        this.f17702l.setAdapter(c4758a);
        this.f17704n = new ArrayList();
        this.f17705o.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController2.setOrder(0);
        this.f17705o.setLayoutAnimation(layoutAnimationController2);
        C4759b c4759b = new C4759b(this.f1669h, C4215R.C4221layout.item_for_school_list, this.f17704n);
        this.f17706p = c4759b;
        this.f17705o.setAdapter(c4759b);
        m41419x0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57926a0(false);
        setTitle("选择课程");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m41420w0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
