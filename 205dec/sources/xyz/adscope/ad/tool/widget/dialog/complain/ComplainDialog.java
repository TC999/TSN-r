package xyz.adscope.ad.tool.widget.dialog.complain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.ad.R;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.tool.widget.dialog.base.CustomDialog;
import xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ComplainDialog extends CustomDialog {
    private static RvAdapter myAdapter;
    private List<ComplainBean> list;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder {
        private ImageView complaintCloseView;
        private EditText complaintEditText;
        private RecyclerView complaintListRecycleView;
        private RelativeLayout complaintNormalLayout;
        private TextView complaintNumberView;
        private TextView complaintSubmitButton;
        private RelativeLayout complaintSuggestLayout;
        private TextView complaintTextTitleView;
        private TextView complaintTextView;
        private RelativeLayout containerRl;
        private DialogCloseCallback dialogCloseCallback;
        private DialogItemCallback dialogItemCallback;
        private boolean isShowSuggestView;
        private ComplainDialog mDialog;
        private View mLayout;

        public Builder(final Context context) {
            this.mDialog = new ComplainDialog(context, R.style.adscope_complaint_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.asnp_complain_dialog, (ViewGroup) null, false);
            this.mLayout = inflate;
            this.mDialog.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.containerRl = (RelativeLayout) this.mLayout.findViewById(R.id.complain_dialog_container_rl);
            this.complaintListRecycleView = (RecyclerView) this.mLayout.findViewById(R.id.complain_reasons_list_recycleview);
            this.complaintCloseView = (ImageView) this.mLayout.findViewById(R.id.complain_dialog_close_view);
            this.complaintTextView = (TextView) this.mLayout.findViewById(R.id.complain_other_suggest_view);
            this.complaintTextTitleView = (TextView) this.mLayout.findViewById(R.id.complain_other_suggest_title);
            this.complaintNormalLayout = (RelativeLayout) this.mLayout.findViewById(R.id.complain_normal_ui);
            this.complaintSuggestLayout = (RelativeLayout) this.mLayout.findViewById(R.id.complain_other_suggest_layout);
            this.complaintEditText = (EditText) this.mLayout.findViewById(R.id.complain_input_other_edittext);
            this.complaintNumberView = (TextView) this.mLayout.findViewById(R.id.complain_other_suggest_number_textview);
            this.complaintSubmitButton = (TextView) this.mLayout.findViewById(R.id.complain_other_suggest_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.complaintListRecycleView.setLayoutManager(linearLayoutManager);
            try {
                if (UIAdapterUtil.getInstance().isDarkMode()) {
                    this.containerRl.setBackground(context.getDrawable(R.drawable.asnp_complaint_dialog_shape_black));
                } else {
                    this.containerRl.setBackground(context.getDrawable(R.drawable.asnp_complaint_dialog_shape));
                }
                this.complaintTextView.setHintTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#666666")));
                this.complaintEditText.setHintTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#0A0A0A")));
                this.complaintEditText.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
                this.complaintTextTitleView.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
                ShapeUtil.setViewBackGround(this.complaintSubmitButton, UIAdapterUtil.getInstance().autoInterfaceStyleColor("#B4B4B4"), 0, "", 10);
                ShapeUtil.setViewBackGround(this.complaintEditText, UIAdapterUtil.getInstance().autoInterfaceStyleColor("#F3F3F3"), 0, "", 3);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            ComplainDialog.myAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.1
                @Override // xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.OnItemClickListener
                public void onItemClick(View view, int i4, String str) {
                    Builder.this.itemClickEvent(str);
                }
            });
            this.complaintListRecycleView.setAdapter(ComplainDialog.myAdapter);
            this.complaintTextView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.isShowSuggestView = true;
                    Builder builder = Builder.this;
                    builder.showSuggestInputLayout(context, builder.complaintEditText);
                }
            });
            this.complaintCloseView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Builder.this.isShowSuggestView) {
                        Builder.this.isShowSuggestView = false;
                        Builder builder = Builder.this;
                        builder.showSuggestInputLayout(context, builder.complaintEditText);
                        return;
                    }
                    if (Builder.this.mDialog != null) {
                        Builder.this.mDialog.dismiss();
                    }
                    if (Builder.this.dialogCloseCallback != null) {
                        Builder.this.dialogCloseCallback.onCloseClick();
                    }
                }
            });
            this.complaintEditText.addTextChangedListener(new TextWatcher() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    String charSequence2 = charSequence.toString();
                    int length = charSequence.length();
                    try {
                        if (!charSequence2.isEmpty()) {
                            ShapeUtil.setViewBackGround(Builder.this.complaintSubmitButton, "#3380FF", 0, "", 10);
                        } else {
                            ShapeUtil.setViewBackGround(Builder.this.complaintSubmitButton, UIAdapterUtil.getInstance().autoInterfaceStyleColor("#B4B4B4"), 0, "", 10);
                        }
                        Builder.this.complaintSubmitButton.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
                    } catch (Resources.NotFoundException e5) {
                        e5.printStackTrace();
                    }
                    Builder.this.complaintNumberView.setText(String.valueOf(length));
                }
            });
            this.complaintSubmitButton.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String obj = Builder.this.complaintEditText.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        return;
                    }
                    Builder.this.itemClickEvent(obj);
                }
            });
        }

        private void hideOrShowInputKeyboard(final Context context, boolean z3, final EditText editText) {
            if (z3) {
                editText.requestFocus();
                new Timer().schedule(new TimerTask() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.Builder.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                        inputMethodManager.showSoftInput(editText, 2);
                        inputMethodManager.toggleSoftInput(2, 1);
                    }
                }, 100L);
                return;
            }
            editText.clearFocus();
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void itemClickEvent(String str) {
            DialogItemCallback dialogItemCallback;
            if (!TextUtils.isEmpty(str) && (dialogItemCallback = this.dialogItemCallback) != null) {
                dialogItemCallback.onDialogItemClick(str);
            }
            ComplainDialog complainDialog = this.mDialog;
            if (complainDialog != null) {
                complainDialog.dismiss();
            }
            RvAdapter unused = ComplainDialog.myAdapter = null;
            String str2 = Constants.TAG;
            LogUtil.i(str2, str + " \u88ab\u70b9\u51fb\u4e86");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showSuggestInputLayout(Context context, EditText editText) {
            if (this.isShowSuggestView) {
                this.complaintNormalLayout.setVisibility(8);
                this.complaintSuggestLayout.setVisibility(0);
                hideOrShowInputKeyboard(context, true, editText);
                return;
            }
            this.complaintNormalLayout.setVisibility(0);
            this.complaintSuggestLayout.setVisibility(8);
            hideOrShowInputKeyboard(context, false, editText);
        }

        public ComplainDialog create() {
            this.mDialog.setContentView(this.mLayout);
            this.mDialog.setCancelable(true);
            this.mDialog.setCanceledOnTouchOutside(false);
            return this.mDialog;
        }

        public Builder setDialogCloseCallback(DialogCloseCallback dialogCloseCallback) {
            this.dialogCloseCallback = dialogCloseCallback;
            return this;
        }

        public Builder setDialogItemCallback(DialogItemCallback dialogItemCallback) {
            this.dialogItemCallback = dialogItemCallback;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class ComplainBean {
        public String complainReason;
        public int type;

        public ComplainBean() {
        }

        public String getComplainReason() {
            return this.complainReason;
        }

        public int getType() {
            return this.type;
        }

        public void setComplainReason(String str) {
            this.complainReason = str;
        }

        public void setType(int i4) {
            this.type = i4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface DialogCloseCallback {
        void onCloseClick();
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface DialogItemCallback {
        void onDialogItemClick(String str);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i4, String str);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class RvAdapter extends RecyclerView.Adapter {
        public OnItemClickListener mOnItemClickListener;
        private List<ComplainBean> mlist;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public class Holder1 extends RecyclerView.ViewHolder {
            private TextView Tvtitle;
            private View reasonItemDivider;

            public Holder1(@NonNull View view) {
                super(view);
                this.Tvtitle = (TextView) view.findViewById(R.id.complain_item_multi_one_title);
                this.reasonItemDivider = view.findViewById(R.id.complain_reason_item_divider);
            }
        }

        public RvAdapter(Context context, List<ComplainBean> list) {
            this.mlist = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(RecyclerView.ViewHolder viewHolder, String str, View view) {
            int layoutPosition = viewHolder.getLayoutPosition();
            OnItemClickListener onItemClickListener = this.mOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(viewHolder.itemView, layoutPosition, str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mlist.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i4) {
            final String complainReason = this.mlist.get(i4).getComplainReason();
            if (viewHolder instanceof Holder1) {
                Holder1 holder1 = (Holder1) viewHolder;
                holder1.Tvtitle.setText(complainReason);
                if (this.mlist.size() > 0 && i4 == this.mlist.size() - 1) {
                    holder1.reasonItemDivider.setVisibility(8);
                }
                try {
                    holder1.Tvtitle.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#000000")));
                    holder1.reasonItemDivider.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor("#E8E9EB")));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.tool.widget.dialog.complain.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ComplainDialog.RvAdapter.this.lambda$onBindViewHolder$0(viewHolder, complainReason, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return new Holder1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asnp_complain_item_multi_one, viewGroup, false));
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public ComplainDialog(@NonNull Context context) {
        super(context);
        this.list = null;
    }

    private List<ComplainBean> getComplainBeanList() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"\u5783\u573e\u5e7f\u544a", "\u611f\u89c9\u6709\u88ab\u5192\u72af\u6216\u88ab\u6b67\u89c6", "\u5e7f\u544a\u6d89\u53ca\u6b3a\u8bc8\u9020\u5047", "\u5e7f\u544a\u6d89\u53ca\u8272\u60c5\u66b4\u529b", "\u5e7f\u544a\u6d89\u53ca\u8fdd\u5efa\u5546\u54c1/\u670d\u52a1", "\u5bf9\u5e7f\u544a\u5185\u5bb9\u4e0d\u611f\u5174\u8da3"};
        for (int i4 = 0; i4 < 6; i4++) {
            String str = strArr[i4];
            ComplainBean complainBean = new ComplainBean();
            complainBean.setComplainReason(str);
            arrayList.add(complainBean);
        }
        return arrayList;
    }

    public ComplainDialog(@NonNull Context context, int i4) {
        super(context, i4);
        this.list = null;
        List<ComplainBean> complainBeanList = getComplainBeanList();
        this.list = complainBeanList;
        myAdapter = new RvAdapter(context, complainBeanList);
    }
}
