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
import com.bxkj.base.util.l;
import com.bxkj.student.home.teaching.homework.question.CheckboxQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.ImageActivity;
import com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.RadioQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.TextQuestionActivity;
import com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class QuestionListAdapter extends CommonAdapter<Map<String, Object>> {

    /* renamed from: g  reason: collision with root package name */
    private b f20491g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (QuestionListAdapter.this.f20491g != null) {
                QuestionListAdapter.this.f20491g.onRefresh();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface b {
        void onRefresh();
    }

    public QuestionListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, 2131427702, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Map map) {
        Http.with(this.f1707a).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).e(JsonParse.getString(map, "questionId"))).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final Map map, View view) {
        new iOSTwoButtonDialog(this.f1707a).setMessage("\u786e\u5b9a\u8981\u5220\u9664\u672c\u6b21\u7b54\u6848\u5417?\u5220\u9664\u540e\u4e0d\u53ef\u6062\u590d,\u8bf7\u8c28\u614e\u64cd\u4f5c").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.homework.question.list.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                QuestionListAdapter.this.r(map);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ViewHolder viewHolder, View view) {
        v(viewHolder.f());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: q */
    public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
        int color;
        holder.J(2131233002, (holder.f() + 1) + ".");
        holder.J(2131233211, JsonParse.getString(stringObjectMap, "questionTypeName"));
        holder.J(2131233212, JsonParse.getString(stringObjectMap, "workTypeName"));
        l.a((TextView) holder.h(2131233112), JsonParse.getString(stringObjectMap, "questions"));
        holder.J(2131233146, "\u6ee1\u5206\uff1a" + JsonParse.getString(stringObjectMap, "socre") + "\u5206");
        int i4 = JsonParse.getInt(stringObjectMap, "isQualified");
        if (i4 == 1) {
            color = ContextCompat.getColor(this.f1707a, 2131034190);
        } else {
            color = ContextCompat.getColor(this.f1707a, 2131034189);
        }
        holder.K(2131233038, color);
        holder.J(2131233038, JsonParse.getString(stringObjectMap, "isQualifiedName"));
        int i5 = JsonParse.getInt(stringObjectMap, "isShow", 1);
        holder.n(2131230953, i5 == 1);
        if (i5 == 0) {
            holder.N(2131231000, false);
            holder.J(2131230953, "\u65f6\u95f4\u5df2\u8fc7");
        } else if (i5 == 1) {
            if (JsonParse.getBoolean(stringObjectMap, "isFlag")) {
                holder.J(2131230953, i4 == 0 ? "\u5f00\u59cb\u7b54\u9898" : "\u67e5\u770b\u7b54\u6848");
                holder.N(2131231000, i4 == 2);
                holder.w(2131231000, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestionListAdapter.this.s(stringObjectMap, view);
                    }
                });
            } else {
                holder.J(2131230953, "\u67e5\u770b\u7b54\u6848");
                holder.N(2131231000, false);
            }
            holder.w(2131230953, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestionListAdapter.this.t(holder, view);
                }
            });
        } else {
            holder.N(2131231000, false);
            holder.J(2131230953, "\u65f6\u95f4\u672a\u5230");
        }
    }

    public void u(b refreshListListener) {
        this.f20491g = refreshListListener;
    }

    public void v(int position) {
        Intent intent = new Intent();
        String string = JsonParse.getString(getItem(position), "id");
        String string2 = JsonParse.getString(getItem(position), "questionId");
        if (TextUtils.isEmpty(string)) {
            string = string2;
        }
        intent.putExtra("questionId", string);
        intent.putExtra("isQualified", JsonParse.getInt(getItem(position), "isQualified"));
        if (JsonParse.getInt(getItem(position), "questionType") == 0) {
            intent.setClass(this.f1707a, RadioQuestionActivity.class);
        } else if (1 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, CheckboxQuestionActivity.class);
        } else if (2 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, RadioQuestionActivity.class);
        } else if (3 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, TextQuestionActivity.class);
        } else if (4 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, ImageActivity.class);
        } else if (5 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, VideoQuestionActivity.class);
        } else if (6 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1707a, PdfQuestionActivity.class);
        }
        this.f1707a.startActivity(intent);
    }
}
