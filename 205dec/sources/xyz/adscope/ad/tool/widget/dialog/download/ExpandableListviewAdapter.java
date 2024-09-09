package xyz.adscope.ad.tool.widget.dialog.download;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.tool.widget.AdscopeWebView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ExpandableListviewAdapter extends BaseExpandableListAdapter {
    private List<ExpandableGroupBean> dataList;
    private Context mContext;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class ExpandChildViewHolder {
        public TextView contentTv;
        public AdscopeWebView contentWb;

        public ExpandChildViewHolder() {
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class ExpandGroupViewHolder {
        public View dividerView;
        public ImageView foldIv;
        public TextView titleTv;

        public ExpandGroupViewHolder() {
        }
    }

    public ExpandableListviewAdapter(Context context, List<ExpandableGroupBean> list) {
        ArrayList arrayList = new ArrayList();
        this.dataList = arrayList;
        this.mContext = context;
        arrayList.clear();
        this.dataList.addAll(list);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i4, int i5) {
        return this.dataList.get(i4).getChildContent();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i4, int i5) {
        return i5;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i4, int i5, boolean z3, View view, ViewGroup viewGroup) {
        ExpandChildViewHolder expandChildViewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.adscope_download_dialog_expand_child_item, (ViewGroup) null);
            expandChildViewHolder = new ExpandChildViewHolder();
            expandChildViewHolder.contentTv = (TextView) view.findViewById(R.id.addeci_content_tv);
            expandChildViewHolder.contentWb = (AdscopeWebView) view.findViewById(R.id.addeci_content_wb);
            view.setTag(expandChildViewHolder);
        } else {
            expandChildViewHolder = (ExpandChildViewHolder) view.getTag();
        }
        String childContent = this.dataList.get(i4).getChildContent();
        if (!TextUtils.isEmpty(childContent)) {
            if ("text".equals(this.dataList.get(i4).getChildType())) {
                expandChildViewHolder.contentTv.setVisibility(0);
                expandChildViewHolder.contentWb.setVisibility(8);
                expandChildViewHolder.contentTv.setText(childContent);
            } else if ("h5".equals(this.dataList.get(i4).getChildType())) {
                expandChildViewHolder.contentTv.setVisibility(8);
                expandChildViewHolder.contentWb.setVisibility(0);
                expandChildViewHolder.contentWb.loadUrl(childContent);
            }
            try {
                expandChildViewHolder.contentTv.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#8C8C8C")));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else {
            expandChildViewHolder.contentTv.setVisibility(8);
            expandChildViewHolder.contentWb.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i4) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i4) {
        return this.dataList.get(i4);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.dataList.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i4) {
        return i4;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i4, boolean z3, View view, ViewGroup viewGroup) {
        ExpandGroupViewHolder expandGroupViewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.adscope_download_dialog_expand_parent_item, (ViewGroup) null);
            expandGroupViewHolder = new ExpandGroupViewHolder();
            expandGroupViewHolder.titleTv = (TextView) view.findViewById(R.id.addep_title_tv);
            expandGroupViewHolder.foldIv = (ImageView) view.findViewById(R.id.addep_fold_iv);
            expandGroupViewHolder.dividerView = view.findViewById(R.id.addep_item_divider_view);
            view.setTag(expandGroupViewHolder);
        } else {
            expandGroupViewHolder = (ExpandGroupViewHolder) view.getTag();
        }
        expandGroupViewHolder.titleTv.setText(this.dataList.get(i4).getGroupName());
        if (z3) {
            expandGroupViewHolder.titleTv.setTextColor(Color.parseColor("#FF8E15"));
            expandGroupViewHolder.foldIv.setBackgroundResource(R.mipmap.adscope_icon_arrow_unfold);
        } else {
            try {
                expandGroupViewHolder.titleTv.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#333333")));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            expandGroupViewHolder.foldIv.setBackgroundResource(R.mipmap.adscope_icon_arrow_fold);
        }
        if (i4 == 0) {
            expandGroupViewHolder.dividerView.setVisibility(8);
        } else {
            expandGroupViewHolder.dividerView.setVisibility(0);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i4, int i5) {
        return false;
    }
}
