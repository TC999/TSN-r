package com.bxkj.student.life.info;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InfoAdapter extends MultiItemCommonAdapter<Map<String, Object>> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            List list = JsonParse.getList(InfoAdapter.this.getItem(position), "titleImg", String.class);
            ((CommonAdapter) InfoAdapter.this).f1707a.startActivity(new Intent(((CommonAdapter) InfoAdapter.this).f1707a, InfoDetailActivity.class).putExtra("infoId", JsonParse.getString(InfoAdapter.this.getItem(position), "id")).putExtra("inforTitle", JsonParse.getString(InfoAdapter.this.getItem(position), "inforTitle")).putExtra("imageUrl", (list == null || list.size() <= 0) ? "" : (String) list.get(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, String url) {
            holder.t(2131231436, url, 2131558617, 2131558744);
        }
    }

    public InfoAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, datas, new com.bxkj.student.life.info.a());
        k(new a());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: o */
    public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        holder.J(2131233004, JsonParse.getString(stringObjectMap, "inforTitle"));
        holder.J(2131233216, JsonParse.getString(stringObjectMap, "inforSource"));
        holder.J(2131233198, JsonParse.getString(stringObjectMap, "publishTime"));
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (getItemViewType(holder.f()) == 1) {
            holder.t(2131231382, (String) list.get(0), 2131558617, 2131558744);
        } else if (getItemViewType(holder.f()) == 2) {
            holder.t(2131231383, (String) list.get(0), 2131558617, 2131558744);
            holder.t(2131231384, (String) list.get(1), 2131558617, 2131558744);
        } else {
            if (list.size() > 3) {
                list = list.subList(0, 3);
            }
            GridView gridView = (GridView) holder.h(2131231336);
            if (list != null && list.size() != 0) {
                gridView.setVisibility(0);
                gridView.setEnabled(false);
                gridView.setPressed(false);
                gridView.setClickable(false);
                gridView.setAdapter((ListAdapter) new b(this.f1707a, 2131427721, list));
                return;
            }
            gridView.setVisibility(8);
        }
    }
}
