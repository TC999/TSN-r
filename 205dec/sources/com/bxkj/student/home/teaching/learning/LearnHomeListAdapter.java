package com.bxkj.student.home.teaching.learning;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.learning.detail.LearnDetailActivity;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LearnHomeListAdapter extends CommonAdapter<Map<String, Object>> {
    public LearnHomeListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, 2131427709, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Map map, View view) {
        this.f1707a.startActivity(new Intent(this.f1707a, LearnDetailActivity.class).putExtra("title", JsonParse.getString(map, "title")).putExtra("id", JsonParse.getString(map, "id")));
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: n */
    public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
        int color;
        int i4;
        holder.J(2131233040, JsonParse.getString(stringObjectMap, "title"));
        if (JsonParse.getInt(stringObjectMap, "isOk") == 1) {
            color = ContextCompat.getColor(this.f1707a, 2131034485);
        } else {
            color = ContextCompat.getColor(this.f1707a, 2131034190);
        }
        holder.K(2131233040, color);
        holder.J(2131233096, JsonParse.getString(stringObjectMap, "pv"));
        holder.J(2131233198, JsonParse.getString(stringObjectMap, "publishTime"));
        if (JsonParse.getInt(stringObjectMap, "type") == 2) {
            i4 = 2131166050;
        } else if (JsonParse.getInt(stringObjectMap, "type") == 3) {
            i4 = 2131558898;
        } else {
            i4 = JsonParse.getInt(stringObjectMap, "type") == 4 ? 2131166049 : 2131165501;
        }
        holder.t(2131231451, JsonParse.getString(stringObjectMap, "indexImg"), i4, i4);
        holder.N(2131231501, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.N(2131231169, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.b().setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListAdapter.this.o(stringObjectMap, view);
            }
        });
    }
}
