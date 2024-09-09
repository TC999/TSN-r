package com.bxkj.student.home.teaching.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SelectExamLessonActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f20118k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20119l;

    /* renamed from: m  reason: collision with root package name */
    private Button f20120m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20121n;

    /* renamed from: o  reason: collision with root package name */
    private int f20122o;

    /* renamed from: p  reason: collision with root package name */
    private int f20123p;

    /* renamed from: q  reason: collision with root package name */
    private int f20124q = 8;

    /* renamed from: r  reason: collision with root package name */
    private int f20125r = 2;

    /* renamed from: s  reason: collision with root package name */
    private HashSet<String> f20126s = new HashSet<>();

    /* renamed from: t  reason: collision with root package name */
    private HashSet<String> f20127t = new HashSet<>();

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            String string = JsonParse.getString(stringObjectMap, "teachingCurriculumId");
            holder.m(2131231079, SelectExamLessonActivity.this.f20126s.contains(string) || SelectExamLessonActivity.this.f20127t.contains(string));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectExamLessonActivity.this.f20118k = (List) data.get("teachingCurriculumArray");
            SelectExamLessonActivity.this.f20121n.g(SelectExamLessonActivity.this.f20118k);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            SelectExamLessonActivity.this.s0();
        }
    }

    private void p0() {
        this.f20119l = (RecyclerView) findViewById(2131232540);
        this.f20120m = (Button) findViewById(2131230989);
    }

    private void q0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).S0()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(ViewGroup viewGroup, View view, Object obj, int i4) {
        String string = JsonParse.getString(this.f20121n.getItem(i4), "teachingCurriculumId");
        int i5 = JsonParse.getInt(this.f20121n.getItem(i4), "type");
        if (i5 == 1) {
            if (this.f20126s.contains(string)) {
                this.f20126s.remove(string);
            } else if (this.f20126s.size() < this.f20124q) {
                this.f20126s.add(string);
            } else {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
                iosonebuttondialog.setMessage("\u6700\u591a\u53ea\u80fd\u9009\u62e9" + this.f20124q + "\u95e8A\u9898\u578b\u8bfe\u7a0b").show();
            }
        } else if (i5 == 2) {
            if (this.f20127t.contains(string)) {
                this.f20127t.remove(string);
            } else if (this.f20127t.size() < this.f20125r) {
                this.f20127t.add(string);
            } else {
                iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(this.f1656h);
                iosonebuttondialog2.setMessage("\u6700\u591a\u53ea\u80fd\u9009\u62e9" + this.f20125r + "\u95e8B\u9898\u578b\u8bfe\u7a0b").show();
            }
        }
        this.f20121n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (this.f20126s.size() != this.f20124q) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
            iosonebuttondialog.setMessage("\u8bf7\u9009\u62e9" + this.f20124q + "\u95e8A\u9898\u578b\u8bfe\u7a0b").show();
        } else if (this.f20127t.size() != this.f20125r) {
            iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(this.f1656h);
            iosonebuttondialog2.setMessage("\u8bf7\u9009\u62e9" + this.f20125r + "\u95e8B\u9898\u578b\u8bfe\u7a0b").show();
        } else {
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(this.f20126s);
            hashSet.addAll(this.f20127t);
            StringBuilder sb = new StringBuilder();
            for (String str : hashSet) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(str);
            }
            Intent intent = getIntent();
            intent.putExtra("onlineType", this.f20123p);
            intent.putExtra("selectIds", sb.toString());
            if (this.f20123p == 0) {
                intent.setClass(this.f1656h, ExamActivity.class);
            } else {
                intent.setClass(this.f1656h, NewExamActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20121n.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.exam.f
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                SelectExamLessonActivity.this.r0(viewGroup, view, obj, i4);
            }
        });
        this.f20120m.setOnClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427397;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20118k = new ArrayList();
        this.f20119l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20119l.setLayoutAnimation(layoutAnimationController);
        this.f20119l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        a aVar = new a(this.f1656h, 2131427759, this.f20118k);
        this.f20121n = aVar;
        this.f20119l.setAdapter(aVar);
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u8003\u8bd5\u8bfe\u7a0b");
        if (getIntent().hasExtra("courseNum")) {
            this.f20122o = getIntent().getIntExtra("courseNum", 1);
            setTitle("\u8bf7\u9009\u62e9" + this.f20122o + "\u95e8\u8003\u8bd5\u8bfe\u7a0b");
        }
        if (getIntent().hasExtra("onlineType")) {
            this.f20123p = getIntent().getIntExtra("onlineType", 0);
        }
        setTitle("\u8bf7\u9009\u62e98\u95e8A\u9898\u578b\u548c2\u95e8B\u9898\u578b\u8003\u8bd5\u8bfe\u7a0b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        p0();
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
