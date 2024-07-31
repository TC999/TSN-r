package cn.bluemobi.dylan.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.base.utils.AppManager;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    protected boolean f1674a = false;

    /* renamed from: b */
    protected boolean f1675b = false;

    /* renamed from: c */
    protected final String f1676c = "LazyLoadFragment";

    /* renamed from: d */
    private View f1677d;

    /* renamed from: e */
    protected Context f1678e;

    /* renamed from: f */
    protected Activity f1679f;

    /* renamed from: g */
    private Toast f1680g;

    /* renamed from: g */
    private void m57914g() {
        if (this.f1674a) {
            if (getUserVisibleHint()) {
                m57913h();
                this.f1675b = true;
            } else if (this.f1675b) {
                m57917H();
            }
        }
    }

    /* renamed from: D */
    public void m57918D(CharSequence charSequence) {
        Toast toast = this.f1680g;
        if (toast == null) {
            this.f1680g = Toast.makeText(getContext(), charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        this.f1680g.show();
    }

    /* renamed from: H */
    protected void m57917H() {
    }

    /* renamed from: b */
    public abstract void mo39445b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public <T extends View> T m57916c(int i) {
        return (T) m57915d().findViewById(i);
    }

    /* renamed from: d */
    protected View m57915d() {
        return this.f1677d;
    }

    /* renamed from: e */
    protected abstract void mo39444e();

    /* renamed from: f */
    protected abstract void mo39443f(View view);

    /* renamed from: h */
    protected void m57913h() {
        if (this.f1675b) {
            return;
        }
        mo39444e();
    }

    /* renamed from: i */
    protected abstract int mo39442i();

    /* renamed from: j */
    protected void m57912j(GridView gridView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("暂无数据！");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    /* renamed from: k */
    protected void m57911k(GridView gridView, String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    /* renamed from: l */
    protected void m57910l(ListView listView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("暂无数据！");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(textView);
        listView.setEmptyView(textView);
        listView.setVisibility(0);
    }

    /* renamed from: m */
    protected void m57909m(ListView listView, String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(textView);
        listView.setEmptyView(textView);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f1677d = layoutInflater.inflate(mo39442i(), viewGroup, false);
        AppManager.m57776n().m57786d(this);
        this.f1674a = true;
        this.f1678e = getContext();
        this.f1679f = getActivity();
        mo39443f(this.f1677d);
        m57914g();
        mo39445b();
        return this.f1677d;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppManager.m57776n().m57770t(this);
        super.onDestroyView();
        this.f1674a = false;
        this.f1675b = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Toast toast = this.f1680g;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        m57914g();
    }
}
