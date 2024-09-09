package com.beizi.ad.internal.view.complaint;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.ad.R;
import com.beizi.ad.lance.a.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ComplaintDialog extends Dialog {
    private static RvAdapter myAdapter;
    private int VIEW_TYPE_1;
    private List<DislikeBean> list;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private ImageView complaintCloseView;
        private EditText complaintEditText;
        private RecyclerView complaintListRecycleView;
        private RelativeLayout complaintNormalLayout;
        private TextView complaintNumberView;
        private Button complaintSubmitButton;
        private RelativeLayout complaintSuggestLayout;
        private TextView complaintTextView;
        private DialogItemCallback dialogItemCallback;
        private boolean isShowSuggestView;
        private ComplaintDialog mDialog;
        private View mLayout;

        public Builder(final Context context) {
            this.mDialog = new ComplaintDialog(context, R.style.beizi_ad_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_complaint_dialog, (ViewGroup) null, false);
            this.mLayout = inflate;
            this.mDialog.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.complaintListRecycleView = (RecyclerView) this.mLayout.findViewById(R.id.dislike_reasons_list_recycleview);
            this.complaintCloseView = (ImageView) this.mLayout.findViewById(R.id.complaint_dialog_close_view);
            this.complaintTextView = (TextView) this.mLayout.findViewById(R.id.complaint_other_suggest_view);
            this.complaintNormalLayout = (RelativeLayout) this.mLayout.findViewById(R.id.complaint_normal_ui);
            this.complaintSuggestLayout = (RelativeLayout) this.mLayout.findViewById(R.id.complaint_other_suggest_layout);
            this.complaintEditText = (EditText) this.mLayout.findViewById(R.id.complaint_input_other_edittext);
            this.complaintNumberView = (TextView) this.mLayout.findViewById(R.id.complaint_other_suggest_number_textview);
            this.complaintSubmitButton = (Button) this.mLayout.findViewById(R.id.complaint_other_suggest_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.complaintListRecycleView.setLayoutManager(linearLayoutManager);
            ComplaintDialog.myAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.1
                @Override // com.beizi.ad.internal.view.complaint.ComplaintDialog.OnItemClickListener
                public void onItemClick(View view, int i4, String str) {
                    Builder.this.itemClickEvent(str);
                }
            });
            this.complaintListRecycleView.setAdapter(ComplaintDialog.myAdapter);
            this.complaintTextView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.isShowSuggestView = true;
                    Builder builder = Builder.this;
                    builder.showSuggestInputLayout(context, builder.complaintEditText);
                }
            });
            this.complaintCloseView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.3
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
                    if (Builder.this.dialogItemCallback != null) {
                        Builder.this.dialogItemCallback.onDialogCloseClick();
                    }
                }
            });
            this.complaintEditText.addTextChangedListener(new TextWatcher() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.4
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
                    if (!charSequence2.isEmpty()) {
                        Builder.this.complaintSubmitButton.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_enable_shape));
                        Builder.this.complaintSubmitButton.setTextColor(context.getResources().getColor(17170444));
                        Builder.this.complaintSubmitButton.setEnabled(true);
                    } else {
                        Builder.this.complaintSubmitButton.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_disable_shape));
                        Builder.this.complaintSubmitButton.setTextColor(context.getResources().getColor(17170443));
                        Builder.this.complaintSubmitButton.setEnabled(false);
                    }
                    Builder.this.complaintNumberView.setText(String.valueOf(length));
                }
            });
            this.complaintSubmitButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.itemClickEvent(Builder.this.complaintEditText.getText().toString());
                }
            });
        }

        private void hideOrShowInputKeyboard(final Context context, boolean z3, final EditText editText) {
            if (z3) {
                editText.requestFocus();
                new Timer().schedule(new TimerTask() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.Builder.6
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
            ComplaintDialog complaintDialog = this.mDialog;
            if (complaintDialog != null) {
                complaintDialog.dismiss();
            }
            l.b("BeiZisAd", str + " \u88ab\u70b9\u51fb\u4e86");
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

        public ComplaintDialog create() {
            this.mDialog.setContentView(this.mLayout);
            this.mDialog.setCancelable(true);
            this.mDialog.setCanceledOnTouchOutside(false);
            return this.mDialog;
        }

        public Builder setDialogItemCallback(DialogItemCallback dialogItemCallback) {
            this.dialogItemCallback = dialogItemCallback;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface DialogItemCallback {
        void onDialogCloseClick();

        void onDialogItemClick(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class DislikeBean {
        String dislikeReason;
        int type;

        DislikeBean() {
        }

        public String getDislikeReason() {
            return this.dislikeReason;
        }

        public int getType() {
            return this.type;
        }

        public void setDislikeReason(String str) {
            this.dislikeReason = str;
        }

        public void setType(int i4) {
            this.type = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i4, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class RvAdapter extends RecyclerView.Adapter {
        public OnItemClickListener mOnItemClickListener;
        private List<DislikeBean> mlist;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public class Holder1 extends RecyclerView.ViewHolder {
            private TextView Tvtitle;
            private View reasonItemDivider;

            public Holder1(View view) {
                super(view);
                this.Tvtitle = (TextView) view.findViewById(R.id.dislike_item_multi_one_title);
                this.reasonItemDivider = view.findViewById(R.id.complaint_reason_item_divider);
            }
        }

        public RvAdapter(Context context, List<DislikeBean> list) {
            this.mlist = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mlist.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            return ComplaintDialog.this.VIEW_TYPE_1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i4) {
            final String dislikeReason = this.mlist.get(i4).getDislikeReason();
            if (viewHolder instanceof Holder1) {
                Holder1 holder1 = (Holder1) viewHolder;
                holder1.Tvtitle.setText(dislikeReason);
                if (this.mlist.size() > 0 && i4 == this.mlist.size() - 1) {
                    holder1.reasonItemDivider.setVisibility(8);
                }
            }
            if (this.mOnItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.complaint.ComplaintDialog.RvAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RvAdapter.this.mOnItemClickListener.onItemClick(viewHolder.itemView, viewHolder.getLayoutPosition(), dislikeReason);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return new Holder1(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_complaint_item_multi_one, viewGroup, false));
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }
    }

    public ComplaintDialog(@NonNull Context context) {
        super(context);
        this.list = null;
        this.VIEW_TYPE_1 = 1;
    }

    private List<DislikeBean> getDislikeBeanList() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"\u5783\u573e\u5e7f\u544a", "\u611f\u89c9\u6709\u88ab\u5192\u72af\u6216\u88ab\u6b67\u89c6", "\u5e7f\u544a\u6d89\u53ca\u6b3a\u8bc8\u9020\u5047", "\u5e7f\u544a\u6d89\u53ca\u8272\u60c5\u66b4\u529b", "\u5e7f\u544a\u6d89\u53ca\u8fdd\u7981\u5546\u54c1/\u670d\u52a1", "\u5bf9\u5e7f\u544a\u5185\u5bb9\u4e0d\u611f\u5174\u8da3"};
        for (int i4 = 0; i4 < 6; i4++) {
            String str = strArr[i4];
            DislikeBean dislikeBean = new DislikeBean();
            dislikeBean.setDislikeReason(str);
            dislikeBean.setType(this.VIEW_TYPE_1);
            arrayList.add(dislikeBean);
        }
        return arrayList;
    }

    public ComplaintDialog(@NonNull Context context, int i4) {
        super(context, i4);
        this.list = null;
        this.VIEW_TYPE_1 = 1;
        List<DislikeBean> dislikeBeanList = getDislikeBeanList();
        this.list = dislikeBeanList;
        myAdapter = new RvAdapter(context, dislikeBeanList);
    }

    protected ComplaintDialog(@NonNull Context context, boolean z3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z3, onCancelListener);
        this.list = null;
        this.VIEW_TYPE_1 = 1;
    }
}
