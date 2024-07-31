package com.bxkj.student.home.teaching.homework.question.list;

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
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.bxkj.student.home.teaching.homework.question.CheckboxQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.ImageActivity;
import com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.RadioQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.TextQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QuestionListAdapter extends CommonAdapter<Map<String, Object>> {

    /* renamed from: g */
    private InterfaceC4561b f17133g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4560a extends HttpCallBack {
        C4560a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (QuestionListAdapter.this.f17133g != null) {
                QuestionListAdapter.this.f17133g.onRefresh();
            }
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4561b {
        void onRefresh();
    }

    public QuestionListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, C4215R.C4221layout.item_for_homework_question_list, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void m41984r(Map map) {
        Http.with(this.f1721a).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42108e(JsonParse.getString(map, "questionId"))).setDataListener(new C4560a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void m41983s(final Map map, View view) {
        new iOSTwoButtonDialog(this.f1721a).setMessage("确定要删除本次答案吗?删除后不可恢复,请谨慎操作").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.homework.question.list.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                QuestionListAdapter.this.m41984r(map);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void m41982t(ViewHolder viewHolder, View view) {
        m41980v(viewHolder.m57864f());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: q */
    public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
        int color;
        holder.m57874J(C4215R.C4219id.tv_index, (holder.m57864f() + 1) + ".");
        holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "questionTypeName"));
        holder.m57874J(2131233212, JsonParse.getString(stringObjectMap, "workTypeName"));
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
        int i2 = JsonParse.getInt(stringObjectMap, "isShow", 1);
        holder.m57856n(C4215R.C4219id.bt_answer, i2 == 1);
        if (i2 == 0) {
            holder.m57870N(C4215R.C4219id.bt_reAnswer, false);
            holder.m57874J(C4215R.C4219id.bt_answer, "时间已过");
        } else if (i2 == 1) {
            if (JsonParse.getBoolean(stringObjectMap, "isFlag")) {
                holder.m57874J(C4215R.C4219id.bt_answer, i == 0 ? "开始答题" : "查看答案");
                holder.m57870N(C4215R.C4219id.bt_reAnswer, i == 2);
                holder.m57847w(C4215R.C4219id.bt_reAnswer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestionListAdapter.this.m41983s(stringObjectMap, view);
                    }
                });
            } else {
                holder.m57874J(C4215R.C4219id.bt_answer, "查看答案");
                holder.m57870N(C4215R.C4219id.bt_reAnswer, false);
            }
            holder.m57847w(C4215R.C4219id.bt_answer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestionListAdapter.this.m41982t(holder, view);
                }
            });
        } else {
            holder.m57870N(C4215R.C4219id.bt_reAnswer, false);
            holder.m57874J(C4215R.C4219id.bt_answer, "时间未到");
        }
    }

    /* renamed from: u */
    public void m41981u(InterfaceC4561b refreshListListener) {
        this.f17133g = refreshListListener;
    }

    /* renamed from: v */
    public void m41980v(int position) {
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
        } else if (6 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1721a, PdfQuestionActivity.class);
        }
        this.f1721a.startActivity(intent);
    }
}
