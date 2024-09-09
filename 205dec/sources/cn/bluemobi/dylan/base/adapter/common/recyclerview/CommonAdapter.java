package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1707a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1708b;

    /* renamed from: c  reason: collision with root package name */
    protected List<T> f1709c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f1710d;

    /* renamed from: e  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.b f1711e;

    /* renamed from: f  reason: collision with root package name */
    private c f1712f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewHolder f1713a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1714b;

        a(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1713a = viewHolder;
            this.f1714b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int e4;
            List<T> list;
            if (CommonAdapter.this.f1711e == null || (e4 = CommonAdapter.this.e(this.f1713a)) == -1 || (list = CommonAdapter.this.f1709c) == null || e4 >= list.size()) {
                return;
            }
            CommonAdapter.this.f1711e.a(this.f1714b, view, CommonAdapter.this.f1709c.get(e4), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewHolder f1716a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1717b;

        b(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1716a = viewHolder;
            this.f1717b = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int e4;
            List<T> list;
            if (CommonAdapter.this.f1712f == null || (e4 = CommonAdapter.this.e(this.f1716a)) == -1 || (list = CommonAdapter.this.f1709c) == null || e4 >= list.size()) {
                return false;
            }
            return CommonAdapter.this.f1712f.a(this.f1717b, view, CommonAdapter.this.f1709c.get(e4), e4);
        }
    }

    public CommonAdapter(Context context, int i4, List<T> list) {
        this.f1707a = context;
        this.f1710d = LayoutInflater.from(context);
        this.f1708b = i4;
        this.f1709c = list;
    }

    public abstract void c(ViewHolder viewHolder, T t3);

    public List<T> d() {
        return this.f1709c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(int i4) {
        return true;
    }

    public void g(List<T> list) {
        this.f1709c = list;
        notifyDataSetChanged();
    }

    public T getItem(int i4) {
        return this.f1709c.get(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f1709c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i4) {
        viewHolder.v(i4);
        c(viewHolder, this.f1709c.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        ViewHolder a4 = ViewHolder.a(this.f1707a, null, viewGroup, this.f1708b);
        j(viewGroup, a4, i4);
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(ViewGroup viewGroup, ViewHolder viewHolder, int i4) {
        if (f(i4)) {
            viewHolder.b().setOnClickListener(new a(viewHolder, viewGroup));
            viewHolder.b().setOnLongClickListener(new b(viewHolder, viewGroup));
        }
    }

    public void k(cn.bluemobi.dylan.base.adapter.common.recyclerview.b bVar) {
        this.f1711e = bVar;
    }

    public void l(c cVar) {
        this.f1712f = cVar;
    }
}
