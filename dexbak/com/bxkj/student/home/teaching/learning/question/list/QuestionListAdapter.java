package com.bxkj.student.home.teaching.learning.question.list;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.HtmlTextUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.question.CheckboxQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.ImageActivity;
import com.bxkj.student.home.teaching.learning.question.RadioQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.TextQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QuestionListAdapter extends CommonAdapter<Map<String, Object>> {

    /* renamed from: g */
    private QuestionListAdapter.InterfaceC4561b f17678g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.list.QuestionListAdapter$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4742a extends HttpCallBack {
        C4742a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (QuestionListAdapter.this.f17678g != null) {
                QuestionListAdapter.this.f17678g.onRefresh();
            }
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.question.list.QuestionListAdapter$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4743b {
        void onRefresh();
    }

    public QuestionListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, C4215R.C4221layout.item_for_lean_question_list, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void m41446r(Map map) {
        Http.with(this.f1721a).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41630l(JsonParse.getString(map, "questionId"))).setDataListener(new C4742a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void m41445s(final Map map, View view) {
        new iOSTwoButtonDialog(this.f1721a).setMessage("确定要删除本次答案吗?删除后不可恢复,请谨慎操作").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.question.list.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                QuestionListAdapter.this.m41446r(map);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void m41444t(ViewHolder viewHolder, View view) {
        m41442v(viewHolder.m57864f());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: q */
    public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
        int color;
        holder.m57874J(C4215R.C4219id.tv_index, (holder.m57864f() + 1) + ".");
        holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "questionTypeName"));
        HtmlTextUtils.m44070a((TextView) holder.m57862h(C4215R.C4219id.tv_question), JsonParse.getString(stringObjectMap, "questions"));
        holder.m57874J(2131233146, "满分：" + JsonParse.getString(stringObjectMap, "socre") + "分");
        int i = JsonParse.getInt(stringObjectMap, "isQualified");
        if (i == 1) {
            color = ContextCompat.getColor(this.f1721a, 2131034190);
        } else {
            color = ContextCompat.getColor(this.f1721a, 2131034189);
        }
        holder.m57873K(C4215R.C4219id.tv_my_score, color);
        holder.m57874J(C4215R.C4219id.tv_my_score, JsonParse.getString(stringObjectMap, "isQualifiedName"));
        holder.m57874J(C4215R.C4219id.bt_answer, i == 0 ? "开始答题" : "查看答案");
        holder.m57870N(C4215R.C4219id.bt_reAnswer, i == 2);
        holder.m57847w(C4215R.C4219id.bt_reAnswer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.list.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListAdapter.this.m41445s(stringObjectMap, view);
            }
        });
        holder.m57847w(C4215R.C4219id.bt_answer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListAdapter.this.m41444t(holder, view);
            }
        });
    }

    /* renamed from: u */
    public void m41443u(QuestionListAdapter.InterfaceC4561b refreshListListener) {
        this.f17678g = refreshListListener;
    }

    /* renamed from: v */
    public void m41442v(int position) {
        Intent intent = new Intent();
        String string = JsonParse.getString(getItem(position), "id");
        String string2 = JsonParse.getString(getItem(position), "questionId");
        if (TextUtils.isEmpty(string)) {
            string = string2;
        }
        intent.putExtra("questionId", string);
        intent.putExtra("isQualified", JsonParse.getInt(getItem(position), "isQualified"));
        if (JsonParse.getInt(getItem(position), "questionType") == 0) {
            intent.setClass(this.f1721a, RadioQuestionActivity.class);
        } else if (1 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, CheckboxQuestionActivity.class);
        } else if (2 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, RadioQuestionActivity.class);
        } else if (3 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, TextQuestionActivity.class);
        } else if (4 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, ImageActivity.class);
        } else if (5 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, VideoQuestionActivity.class);
        }
        this.f1721a.startActivity(intent);
    }
}
