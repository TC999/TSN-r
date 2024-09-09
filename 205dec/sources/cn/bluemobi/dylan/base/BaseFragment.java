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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f1661a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f1662b = false;

    /* renamed from: c  reason: collision with root package name */
    protected final String f1663c = "LazyLoadFragment";

    /* renamed from: d  reason: collision with root package name */
    private View f1664d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f1665e;

    /* renamed from: f  reason: collision with root package name */
    protected Activity f1666f;

    /* renamed from: g  reason: collision with root package name */
    private Toast f1667g;

    private void g() {
        if (this.f1661a) {
            if (getUserVisibleHint()) {
                h();
                this.f1662b = true;
            } else if (this.f1662b) {
                H();
            }
        }
    }

    public void D(CharSequence charSequence) {
        Toast toast = this.f1667g;
        if (toast == null) {
            this.f1667g = Toast.makeText(getContext(), charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        this.f1667g.show();
    }

    protected void H() {
    }

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends View> T c(int i4) {
        return (T) d().findViewById(i4);
    }

    protected View d() {
        return this.f1664d;
    }

    protected abstract void e();

    protected abstract void f(View view);

    protected void h() {
        if (this.f1662b) {
            return;
        }
        e();
    }

    protected abstract int i();

    protected void j(GridView gridView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("\u6682\u65e0\u6570\u636e\uff01");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    protected void k(GridView gridView, String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    protected void l(ListView listView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("\u6682\u65e0\u6570\u636e\uff01");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(textView);
        listView.setEmptyView(textView);
        listView.setVisibility(0);
    }

    protected void m(ListView listView, String str) {
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
        this.f1664d = layoutInflater.inflate(i(), viewGroup, false);
        cn.bluemobi.dylan.base.utils.a.n().d(this);
        this.f1661a = true;
        this.f1665e = getContext();
        this.f1666f = getActivity();
        f(this.f1664d);
        g();
        b();
        return this.f1664d;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        cn.bluemobi.dylan.base.utils.a.n().t(this);
        super.onDestroyView();
        this.f1661a = false;
        this.f1662b = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Toast toast = this.f1667g;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z3) {
        super.setUserVisibleHint(z3);
        g();
    }
}
