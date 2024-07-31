package com.bxkj.student.home.teaching.learning;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.detail.LearnDetailActivity;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LearnHomeListAdapter extends CommonAdapter<Map<String, Object>> {
    public LearnHomeListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, C4215R.C4221layout.item_for_learn_list, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m41918o(Map map, View view) {
        this.f1721a.startActivity(new Intent(this.f1721a, LearnDetailActivity.class).putExtra("title", JsonParse.getString(map, "title")).putExtra("id", JsonParse.getString(map, "id")));
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: n */
    public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
        int color;
        int i;
        holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "title"));
        if (JsonParse.getInt(stringObjectMap, "isOk") == 1) {
            color = ContextCompat.getColor(this.f1721a, C4215R.C4217color.tab_normal);
        } else {
            color = ContextCompat.getColor(this.f1721a, 2131034190);
        }
        holder.m57873K(2131233040, color);
        holder.m57874J(C4215R.C4219id.tv_play_num, JsonParse.getString(stringObjectMap, "pv"));
        holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "publishTime"));
        if (JsonParse.getInt(stringObjectMap, "type") == 2) {
            i = 2131166050;
        } else if (JsonParse.getInt(stringObjectMap, "type") == 3) {
            i = C4215R.mipmap.pdf;
        } else {
            i = JsonParse.getInt(stringObjectMap, "type") == 4 ? 2131166049 : 2131165501;
        }
        holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "indexImg"), i, i);
        holder.m57870N(C4215R.C4219id.iv_type, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.m57870N(C4215R.C4219id.cv_video_flag, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.m57868b().setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListAdapter.this.m41918o(stringObjectMap, view);
            }
        });
    }
}
