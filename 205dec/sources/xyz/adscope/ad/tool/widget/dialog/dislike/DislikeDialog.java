package xyz.adscope.ad.tool.widget.dialog.dislike;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.tool.widget.dialog.base.CustomDialog;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DislikeDialog extends CustomDialog {
    private static RvAdapter myAdapter;
    private int VIEW_TYPE_1;
    private int VIEW_TYPE_2;
    private List<DislikeBean> list;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        private DialogItemCallback dialogItemCallback;
        private RecyclerView dislikeListRecycleView;
        private DislikeDialog mDialog;
        private View mLayout;

        public Builder(Context context) {
            this.mDialog = new DislikeDialog(context, R.style.adscope_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.asnp_dislike_dialog, (ViewGroup) null, false);
            this.mLayout = inflate;
            this.mDialog.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.dislikeListRecycleView = (RecyclerView) this.mLayout.findViewById(R.id.dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.dislikeListRecycleView.setLayoutManager(linearLayoutManager);
            DislikeDialog.myAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.Builder.1
                @Override // xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.OnItemClickListener
                public void onItemClick(View view, int i4) {
                    if (Builder.this.dialogItemCallback != null) {
                        Builder.this.dialogItemCallback.onDialogItemClick();
                    }
                    if (Builder.this.mDialog != null) {
                        Builder.this.mDialog.dismiss();
                    }
                }
            });
            this.dislikeListRecycleView.setAdapter(DislikeDialog.myAdapter);
        }

        public DislikeDialog create() {
            this.mDialog.setContentView(this.mLayout);
            this.mDialog.setCancelable(true);
            this.mDialog.setCanceledOnTouchOutside(true);
            return this.mDialog;
        }

        public Builder setDialogItemCallback(DialogItemCallback dialogItemCallback) {
            this.dialogItemCallback = dialogItemCallback;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface DialogItemCallback {
        void onDialogItemClick();
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class DislikeBean {
        public String dislikeReason;
        public List<ItemBean> itemBeanList;
        public int type;

        public DislikeBean() {
        }

        public String getDislikeReason() {
            return this.dislikeReason;
        }

        public List<ItemBean> getItemBeanList() {
            return this.itemBeanList;
        }

        public int getType() {
            return this.type;
        }

        public void setDislikeReason(String str) {
            this.dislikeReason = str;
        }

        public void setItemBeanList(List<ItemBean> list) {
            this.itemBeanList = list;
        }

        public void setType(int i4) {
            this.type = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class ItemBean {
        public String reportReason;

        public ItemBean() {
        }

        public String getReportReason() {
            return this.reportReason;
        }

        public void setReportReason(String str) {
            this.reportReason = str;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i4);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface OnReportItemClickListener {
        void onItemClick(View view, int i4);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class RecyAdapter extends RecyclerView.Adapter {
        private Context context;
        private List<ItemBean> mData;
        private OnReportItemClickListener onReportItemClickListener;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public class VH extends RecyclerView.ViewHolder {
            public TextView mText;

            public VH(@NonNull View view) {
                super(view);
                this.mText = (TextView) view.findViewById(R.id.dislike_item_multi_two_recycleview_item);
            }
        }

        public RecyAdapter(Context context, List<ItemBean> list) {
            this.context = context;
            this.mData = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i4) {
            VH vh = (VH) viewHolder;
            vh.mText.setText(this.mData.get(i4).getReportReason());
            ShapeUtil.setViewBackGround(vh.itemView, "#33333333", 0, "", 5);
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.RecyAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RecyAdapter.this.onReportItemClickListener != null) {
                        RecyAdapter.this.onReportItemClickListener.onItemClick(view, i4);
                    }
                    Context context = RecyAdapter.this.context;
                    Toast.makeText(context, "\u70b9\u51fb\u4e86\u4f4d\u7f6e\uff1a" + ((ItemBean) RecyAdapter.this.mData.get(i4)).getReportReason(), 1).show();
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asnp_dislike_item_multi_two_recycle_item, viewGroup, false));
        }

        public void setOnReportItemClickListener(OnReportItemClickListener onReportItemClickListener) {
            this.onReportItemClickListener = onReportItemClickListener;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class RvAdapter extends RecyclerView.Adapter {
        private Context mContext;
        public OnItemClickListener mOnItemClickListener;
        private List<DislikeBean> mlist;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public class Holder1 extends RecyclerView.ViewHolder {
            private TextView Tvtitle;

            public Holder1(@NonNull View view) {
                super(view);
                this.Tvtitle = (TextView) view.findViewById(R.id.dislike_item_multi_one_title);
            }
        }

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public class Holder2 extends RecyclerView.ViewHolder {
            private TextView Tvtitle;
            private RecyclerView recyclerViewTwo;

            public Holder2(@NonNull View view) {
                super(view);
                this.Tvtitle = (TextView) view.findViewById(R.id.dislike_item_multi_two_title);
                this.recyclerViewTwo = (RecyclerView) view.findViewById(R.id.dislike_item_multi_two_recycleview);
            }
        }

        public RvAdapter(Context context, List<DislikeBean> list) {
            this.mContext = context;
            this.mlist = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mlist.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            if (this.mlist.get(i4).getItemBeanList() != null && this.mlist.get(i4).getItemBeanList().size() > 0) {
                return DislikeDialog.this.VIEW_TYPE_2;
            }
            return DislikeDialog.this.VIEW_TYPE_1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i4) {
            if (viewHolder instanceof Holder1) {
                ((Holder1) viewHolder).Tvtitle.setText(this.mlist.get(i4).getDislikeReason());
            } else {
                Holder2 holder2 = (Holder2) viewHolder;
                holder2.Tvtitle.setText(this.mlist.get(i4).getDislikeReason());
                holder2.recyclerViewTwo.setLayoutManager(new FlowLayoutManager());
                DislikeDialog dislikeDialog = DislikeDialog.this;
                RecyAdapter recyAdapter = new RecyAdapter(dislikeDialog.getContext(), this.mlist.get(i4).getItemBeanList());
                holder2.recyclerViewTwo.setAdapter(recyAdapter);
                recyAdapter.setOnReportItemClickListener(new OnReportItemClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.RvAdapter.1
                    @Override // xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.OnReportItemClickListener
                    public void onItemClick(View view, int i5) {
                        OnItemClickListener onItemClickListener = RvAdapter.this.mOnItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(view, i5);
                        }
                    }
                });
                holder2.recyclerViewTwo.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.RvAdapter.2
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        super.getItemOffsets(rect, view, recyclerView, state);
                        rect.bottom = 30;
                        rect.left = 30;
                    }
                });
            }
            if (this.mOnItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.RvAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int layoutPosition = viewHolder.getLayoutPosition();
                        if (DislikeDialog.this.VIEW_TYPE_2 != RvAdapter.this.getItemViewType(layoutPosition)) {
                            RvAdapter.this.mOnItemClickListener.onItemClick(viewHolder.itemView, layoutPosition);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            if (i4 == DislikeDialog.this.VIEW_TYPE_1) {
                return new Holder1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asnp_dislike_item_multi_one, viewGroup, false));
            }
            return new Holder2(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asnp_dislike_item_multi_two, viewGroup, false));
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public DislikeDialog(@NonNull Context context) {
        super(context);
        this.list = null;
        this.VIEW_TYPE_1 = 1;
        this.VIEW_TYPE_2 = 2;
    }

    private List<DislikeBean> getDislikeBeanList() {
        ArrayList arrayList = new ArrayList();
        DislikeBean dislikeBean = new DislikeBean();
        dislikeBean.setDislikeReason("\u5185\u5bb9\u65e0\u6cd5\u6b63\u5e38\u5c55\u793a\uff08\u5361\u987f\u3001\u9ed1\u767d\u5c4f\uff09");
        dislikeBean.setType(this.VIEW_TYPE_1);
        arrayList.add(dislikeBean);
        DislikeBean dislikeBean2 = new DislikeBean();
        dislikeBean2.setDislikeReason("\u4e0d\u611f\u5174\u8da3");
        dislikeBean2.setType(this.VIEW_TYPE_1);
        arrayList.add(dislikeBean2);
        DislikeBean dislikeBean3 = new DislikeBean();
        dislikeBean3.setDislikeReason("\u65e0\u6cd5\u5173\u95ed");
        dislikeBean3.setType(this.VIEW_TYPE_1);
        arrayList.add(dislikeBean3);
        ArrayList arrayList2 = new ArrayList();
        ItemBean itemBean = new ItemBean();
        itemBean.setReportReason("\u7591\u4f3c\u6284\u88ad");
        arrayList2.add(itemBean);
        ItemBean itemBean2 = new ItemBean();
        itemBean2.setReportReason("\u865a\u5047\u6b3a\u8bc8");
        arrayList2.add(itemBean2);
        ItemBean itemBean3 = new ItemBean();
        itemBean3.setReportReason("\u8fdd\u6cd5\u8fdd\u89c4");
        arrayList2.add(itemBean3);
        ItemBean itemBean4 = new ItemBean();
        itemBean4.setReportReason("\u4f4e\u4fd7\u8272\u60c5");
        arrayList2.add(itemBean4);
        DislikeBean dislikeBean4 = new DislikeBean();
        dislikeBean4.setDislikeReason("\u4e3e\u62a5\u5e7f\u544a");
        dislikeBean4.setItemBeanList(arrayList2);
        dislikeBean4.setType(this.VIEW_TYPE_1);
        arrayList.add(dislikeBean4);
        return arrayList;
    }

    public DislikeDialog(@NonNull Context context, int i4) {
        super(context, i4);
        this.list = null;
        this.VIEW_TYPE_1 = 1;
        this.VIEW_TYPE_2 = 2;
        List<DislikeBean> dislikeBeanList = getDislikeBeanList();
        this.list = dislikeBeanList;
        myAdapter = new RvAdapter(context, dislikeBeanList);
    }
}
