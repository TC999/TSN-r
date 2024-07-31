package cn.bluemobi.dylan.base.adapter.common.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    protected Context f1721a;

    /* renamed from: b */
    protected int f1722b;

    /* renamed from: c */
    protected List<T> f1723c;

    /* renamed from: d */
    protected LayoutInflater f1724d;

    /* renamed from: e */
    private OnItemClickListener f1725e;

    /* renamed from: f */
    private OnItemLongClickClickListener f1726f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class View$OnClickListenerC1122a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ViewHolder f1727a;

        /* renamed from: b */
        final /* synthetic */ ViewGroup f1728b;

        View$OnClickListenerC1122a(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1727a = viewHolder;
            this.f1728b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int mo57829e;
            List<T> list;
            if (CommonAdapter.this.f1725e == null || (mo57829e = CommonAdapter.this.mo57829e(this.f1727a)) == -1 || (list = CommonAdapter.this.f1723c) == null || mo57829e >= list.size()) {
                return;
            }
            CommonAdapter.this.f1725e.mo39403a(this.f1728b, view, CommonAdapter.this.f1723c.get(mo57829e), mo57829e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class View$OnLongClickListenerC1123b implements View.OnLongClickListener {

        /* renamed from: a */
        final /* synthetic */ ViewHolder f1730a;

        /* renamed from: b */
        final /* synthetic */ ViewGroup f1731b;

        View$OnLongClickListenerC1123b(ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f1730a = viewHolder;
            this.f1731b = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int mo57829e;
            List<T> list;
            if (CommonAdapter.this.f1726f == null || (mo57829e = CommonAdapter.this.mo57829e(this.f1730a)) == -1 || (list = CommonAdapter.this.f1723c) == null || mo57829e >= list.size()) {
                return false;
            }
            return CommonAdapter.this.f1726f.m57830a(this.f1731b, view, CommonAdapter.this.f1723c.get(mo57829e), mo57829e);
        }
    }

    public CommonAdapter(Context context, int i, List<T> list) {
        this.f1721a = context;
        this.f1724d = LayoutInflater.from(context);
        this.f1722b = i;
        this.f1723c = list;
    }

    /* renamed from: c */
    public abstract void mo39408c(ViewHolder viewHolder, T t);

    /* renamed from: d */
    public List<T> m57837d() {
        return this.f1723c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public int mo57829e(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo57828f(int i) {
        return true;
    }

    /* renamed from: g */
    public void m57836g(List<T> list) {
        this.f1723c = list;
        notifyDataSetChanged();
    }

    public T getItem(int i) {
        return this.f1723c.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.f1723c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.m57848v(i);
        mo39408c(viewHolder, this.f1723c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder m57869a = ViewHolder.m57869a(this.f1721a, null, viewGroup, this.f1722b);
        m57835j(viewGroup, m57869a, i);
        return m57869a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public void m57835j(ViewGroup viewGroup, ViewHolder viewHolder, int i) {
        if (mo57828f(i)) {
            viewHolder.m57868b().setOnClickListener(new View$OnClickListenerC1122a(viewHolder, viewGroup));
            viewHolder.m57868b().setOnLongClickListener(new View$OnLongClickListenerC1123b(viewHolder, viewGroup));
        }
    }

    /* renamed from: k */
    public void m57834k(OnItemClickListener onItemClickListener) {
        this.f1725e = onItemClickListener;
    }

    /* renamed from: l */
    public void m57833l(OnItemLongClickClickListener onItemLongClickClickListener) {
        this.f1726f = onItemLongClickClickListener;
    }
}
