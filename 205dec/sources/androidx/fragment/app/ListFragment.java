package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ListFragment extends Fragment {
    static final int INTERNAL_EMPTY_ID = 16711681;
    static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
    static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
    ListAdapter mAdapter;
    CharSequence mEmptyText;
    View mEmptyView;
    ListView mList;
    View mListContainer;
    boolean mListShown;
    View mProgressContainer;
    TextView mStandardEmptyView;
    private final Handler mHandler = new Handler();
    private final Runnable mRequestFocus = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.mList;
            listView.focusableViewAvailable(listView);
        }
    };
    private final AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i4, j4);
        }
    };

    private void ensureList() {
        if (this.mList != null) {
            return;
        }
        View view = getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.mList = (ListView) view;
            } else {
                TextView textView = (TextView) view.findViewById(16711681);
                this.mStandardEmptyView = textView;
                if (textView == null) {
                    this.mEmptyView = view.findViewById(16908292);
                } else {
                    textView.setVisibility(8);
                }
                this.mProgressContainer = view.findViewById(16711682);
                this.mListContainer = view.findViewById(16711683);
                View findViewById = view.findViewById(16908298);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                ListView listView = (ListView) findViewById;
                this.mList = listView;
                View view2 = this.mEmptyView;
                if (view2 != null) {
                    listView.setEmptyView(view2);
                } else {
                    CharSequence charSequence = this.mEmptyText;
                    if (charSequence != null) {
                        this.mStandardEmptyView.setText(charSequence);
                        this.mList.setEmptyView(this.mStandardEmptyView);
                    }
                }
            }
            this.mListShown = true;
            this.mList.setOnItemClickListener(this.mOnClickListener);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                this.mAdapter = null;
                setListAdapter(listAdapter);
            } else if (this.mProgressContainer != null) {
                setListShown(false, false);
            }
            this.mHandler.post(this.mRequestFocus);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    @Nullable
    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    @NonNull
    public ListView getListView() {
        ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        ensureList();
        return this.mList.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i4, long j4) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        ensureList();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        ensureList();
        TextView textView = this.mStandardEmptyView;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.mEmptyText == null) {
                this.mList.setEmptyView(this.mStandardEmptyView);
            }
            this.mEmptyText = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z3 = this.mAdapter != null;
        this.mAdapter = listAdapter;
        ListView listView = this.mList;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.mListShown || z3) {
                return;
            }
            setListShown(true, requireView().getWindowToken() != null);
        }
    }

    public void setListShown(boolean z3) {
        setListShown(z3, true);
    }

    public void setListShownNoAnimation(boolean z3) {
        setListShown(z3, false);
    }

    public void setSelection(int i4) {
        ensureList();
        this.mList.setSelection(i4);
    }

    private void setListShown(boolean z3, boolean z4) {
        ensureList();
        View view = this.mProgressContainer;
        if (view != null) {
            if (this.mListShown == z3) {
                return;
            }
            this.mListShown = z3;
            if (z3) {
                if (z4) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.mListContainer.clearAnimation();
                }
                this.mProgressContainer.setVisibility(8);
                this.mListContainer.setVisibility(0);
                return;
            }
            if (z4) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.mListContainer.clearAnimation();
            }
            this.mProgressContainer.setVisibility(0);
            this.mListContainer.setVisibility(8);
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }
}
