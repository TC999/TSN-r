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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InfoAdapter extends MultiItemCommonAdapter<Map<String, Object>> {

    /* renamed from: com.bxkj.student.life.info.InfoAdapter$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4879a implements OnItemClickListener {
        C4879a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            List list = JsonParse.getList(InfoAdapter.this.getItem(position), "titleImg", String.class);
            ((CommonAdapter) InfoAdapter.this).f1721a.startActivity(new Intent(((CommonAdapter) InfoAdapter.this).f1721a, InfoDetailActivity.class).putExtra("infoId", JsonParse.getString(InfoAdapter.this.getItem(position), "id")).putExtra("inforTitle", JsonParse.getString(InfoAdapter.this.getItem(position), "inforTitle")).putExtra("imageUrl", (list == null || list.size() <= 0) ? "" : (String) list.get(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.info.InfoAdapter$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4880b extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<String> {
        C4880b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String url) {
            holder.m57850t(C4215R.C4219id.iv_img, url, 2131558617, C4215R.mipmap.icon_smal);
        }
    }

    public InfoAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, datas, new InfoMultiSupport());
        m57834k(new C4879a());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: o */
    public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, "inforTitle"));
        holder.m57874J(2131233216, JsonParse.getString(stringObjectMap, "inforSource"));
        holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "publishTime"));
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (getItemViewType(holder.m57864f()) == 1) {
            holder.m57850t(C4215R.C4219id.f15999iv, (String) list.get(0), 2131558617, C4215R.mipmap.icon_smal);
        } else if (getItemViewType(holder.m57864f()) == 2) {
            holder.m57850t(C4215R.C4219id.iv1, (String) list.get(0), 2131558617, C4215R.mipmap.icon_smal);
            holder.m57850t(C4215R.C4219id.iv2, (String) list.get(1), 2131558617, C4215R.mipmap.icon_smal);
        } else {
            if (list.size() > 3) {
                list = list.subList(0, 3);
            }
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_img);
            if (list != null && list.size() != 0) {
                gridView.setVisibility(0);
                gridView.setEnabled(false);
                gridView.setPressed(false);
                gridView.setClickable(false);
                gridView.setAdapter((ListAdapter) new C4880b(this.f1721a, C4215R.C4221layout.item_for_lost_img, list));
                return;
            }
            gridView.setVisibility(8);
        }
    }
}
