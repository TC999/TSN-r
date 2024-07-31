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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SelectExamLessonActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f16728k;

    /* renamed from: l */
    private RecyclerView f16729l;

    /* renamed from: m */
    private Button f16730m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16731n;

    /* renamed from: o */
    private int f16732o;

    /* renamed from: p */
    private int f16733p;

    /* renamed from: q */
    private int f16734q = 8;

    /* renamed from: r */
    private int f16735r = 2;

    /* renamed from: s */
    private HashSet<String> f16736s = new HashSet<>();

    /* renamed from: t */
    private HashSet<String> f16737t = new HashSet<>();

    /* renamed from: com.bxkj.student.home.teaching.exam.SelectExamLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4449a extends CommonAdapter<Map<String, Object>> {
        C4449a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            String string = JsonParse.getString(stringObjectMap, "teachingCurriculumId");
            holder.m57857m(2131231079, SelectExamLessonActivity.this.f16736s.contains(string) || SelectExamLessonActivity.this.f16737t.contains(string));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.SelectExamLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4450b extends HttpCallBack {
        C4450b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectExamLessonActivity.this.f16728k = (List) data.get("teachingCurriculumArray");
            SelectExamLessonActivity.this.f16731n.m57836g(SelectExamLessonActivity.this.f16728k);
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.SelectExamLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC4451c implements View.OnClickListener {
        View$OnClickListenerC4451c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SelectExamLessonActivity.this.m42328s0();
        }
    }

    /* renamed from: p0 */
    private void m42331p0() {
        this.f16729l = (RecyclerView) findViewById(2131232540);
        this.f16730m = (Button) findViewById(2131230989);
    }

    /* renamed from: q0 */
    private void m42330q0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m144S0()).setDataListener(new C4450b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m42329r0(ViewGroup viewGroup, View view, Object obj, int i) {
        String string = JsonParse.getString(this.f16731n.getItem(i), "teachingCurriculumId");
        int i2 = JsonParse.getInt(this.f16731n.getItem(i), "type");
        if (i2 == 1) {
            if (this.f16736s.contains(string)) {
                this.f16736s.remove(string);
            } else if (this.f16736s.size() < this.f16734q) {
                this.f16736s.add(string);
            } else {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
                iosonebuttondialog.setMessage("最多只能选择" + this.f16734q + "门A题型课程").show();
            }
        } else if (i2 == 2) {
            if (this.f16737t.contains(string)) {
                this.f16737t.remove(string);
            } else if (this.f16737t.size() < this.f16735r) {
                this.f16737t.add(string);
            } else {
                iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(this.f1669h);
                iosonebuttondialog2.setMessage("最多只能选择" + this.f16735r + "门B题型课程").show();
            }
        }
        this.f16731n.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m42328s0() {
        if (this.f16736s.size() != this.f16734q) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
            iosonebuttondialog.setMessage("请选择" + this.f16734q + "门A题型课程").show();
        } else if (this.f16737t.size() != this.f16735r) {
            iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(this.f1669h);
            iosonebuttondialog2.setMessage("请选择" + this.f16735r + "门B题型课程").show();
        } else {
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(this.f16736s);
            hashSet.addAll(this.f16737t);
            StringBuilder sb = new StringBuilder();
            for (String str : hashSet) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(str);
            }
            Intent intent = getIntent();
            intent.putExtra("onlineType", this.f16733p);
            intent.putExtra("selectIds", sb.toString());
            if (this.f16733p == 0) {
                intent.setClass(this.f1669h, ExamActivity.class);
            } else {
                intent.setClass(this.f1669h, NewExamActivity.class);
            }
            startActivity(intent);
            finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16731n.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.exam.f
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                SelectExamLessonActivity.this.m42329r0(viewGroup, view, obj, i);
            }
        });
        this.f16730m.setOnClickListener(new View$OnClickListenerC4451c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_exam_select_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16728k = new ArrayList();
        this.f16729l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16729l.setLayoutAnimation(layoutAnimationController);
        this.f16729l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C4449a c4449a = new C4449a(this.f1669h, C4215R.C4221layout.item_for_select_exam_lesson_list, this.f16728k);
        this.f16731n = c4449a;
        this.f16729l.setAdapter(c4449a);
        m42330q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择考试课程");
        if (getIntent().hasExtra("courseNum")) {
            this.f16732o = getIntent().getIntExtra("courseNum", 1);
            setTitle("请选择" + this.f16732o + "门考试课程");
        }
        if (getIntent().hasExtra("onlineType")) {
            this.f16733p = getIntent().getIntExtra("onlineType", 0);
        }
        setTitle("请选择8门A题型和2门B题型考试课程");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        m42331p0();
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
