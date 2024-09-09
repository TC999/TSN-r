package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class ObservableListAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final int mDropDownResourceId;
    private final LayoutInflater mLayoutInflater;
    private List<T> mList;
    private ObservableList.OnListChangedCallback mListChangedCallback;
    private final int mResourceId;
    private final int mTextViewResourceId;

    public ObservableListAdapter(Context context, List<T> list, int i4, int i5, int i6) {
        this.mContext = context;
        this.mResourceId = i4;
        this.mDropDownResourceId = i5;
        this.mTextViewResourceId = i6;
        this.mLayoutInflater = i4 == 0 ? null : (LayoutInflater) context.getSystemService("layout_inflater");
        setList(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mDropDownResourceId, i4, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.mList.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        return getViewForResource(this.mResourceId, i4, view, viewGroup);
    }

    public View getViewForResource(int i4, int i5, View view, ViewGroup viewGroup) {
        CharSequence valueOf;
        if (view == null) {
            if (i4 == 0) {
                view = new TextView(this.mContext);
            } else {
                view = this.mLayoutInflater.inflate(i4, viewGroup, false);
            }
        }
        int i6 = this.mTextViewResourceId;
        TextView textView = (TextView) (i6 == 0 ? view : view.findViewById(i6));
        T t3 = this.mList.get(i5);
        if (t3 instanceof CharSequence) {
            valueOf = (CharSequence) t3;
        } else {
            valueOf = String.valueOf(t3);
        }
        textView.setText(valueOf);
        return view;
    }

    public void setList(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof ObservableList) {
            ((ObservableList) list2).removeOnListChangedCallback(this.mListChangedCallback);
        }
        this.mList = list;
        if (list instanceof ObservableList) {
            if (this.mListChangedCallback == null) {
                this.mListChangedCallback = new ObservableList.OnListChangedCallback() { // from class: androidx.databinding.adapters.ObservableListAdapter.1
                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onChanged(ObservableList observableList) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeChanged(ObservableList observableList, int i4, int i5) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeInserted(ObservableList observableList, int i4, int i5) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeMoved(ObservableList observableList, int i4, int i5, int i6) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // androidx.databinding.ObservableList.OnListChangedCallback
                    public void onItemRangeRemoved(ObservableList observableList, int i4, int i5) {
                        ObservableListAdapter.this.notifyDataSetChanged();
                    }
                };
            }
            ((ObservableList) this.mList).addOnListChangedCallback(this.mListChangedCallback);
        }
        notifyDataSetChanged();
    }
}
