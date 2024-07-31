package com.acse.ottn.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.acse.ottn.banner.p036a.InterfaceC1445b;
import com.acse.ottn.banner.p039d.InterfaceC1455a;
import com.acse.ottn.banner.util.C1468b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.acse.ottn.banner.adapter.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1446a<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements InterfaceC1445b<T, VH> {

    /* renamed from: b */
    private InterfaceC1455a f2642b;

    /* renamed from: c */
    private VH f2643c;

    /* renamed from: a */
    protected List<T> f2641a = new ArrayList();

    /* renamed from: d */
    private int f2644d = 2;

    public AbstractC1446a(List<T> list) {
        m56738a(list);
    }

    /* renamed from: a */
    public int m56742a() {
        List<T> list = this.f2641a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public T m56741a(int i) {
        return this.f2641a.get(i);
    }

    /* renamed from: a */
    public void m56739a(InterfaceC1455a interfaceC1455a) {
        this.f2642b = interfaceC1455a;
    }

    /* renamed from: a */
    public void m56738a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f2641a = list;
    }

    /* renamed from: b */
    public int m56736b(int i) {
        return C1468b.m56700a(this.f2644d == 2, i, m56742a());
    }

    /* renamed from: b */
    public VH m56737b() {
        return this.f2643c;
    }

    /* renamed from: c */
    public void m56735c(int i) {
        this.f2644d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return m56742a() > 1 ? m56742a() + this.f2644d : m56742a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i) {
        this.f2643c = vh;
        final int m56736b = m56736b(i);
        m56743a(vh, this.f2641a.get(m56736b), m56736b, m56742a());
        if (this.f2642b != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.acse.ottn.banner.adapter.BannerAdapter$1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InterfaceC1455a interfaceC1455a;
                    interfaceC1455a = AbstractC1446a.this.f2642b;
                    interfaceC1455a.m56707a(AbstractC1446a.this.f2641a.get(m56736b), m56736b);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return (VH) mo56734a(viewGroup, i);
    }
}
