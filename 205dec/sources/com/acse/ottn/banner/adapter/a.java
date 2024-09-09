package com.acse.ottn.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class a<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements com.acse.ottn.banner.a.b<T, VH> {

    /* renamed from: b  reason: collision with root package name */
    private com.acse.ottn.banner.d.a f5243b;

    /* renamed from: c  reason: collision with root package name */
    private VH f5244c;

    /* renamed from: a  reason: collision with root package name */
    protected List<T> f5242a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f5245d = 2;

    public a(List<T> list) {
        a(list);
    }

    public int a() {
        List<T> list = this.f5242a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T a(int i4) {
        return this.f5242a.get(i4);
    }

    public void a(com.acse.ottn.banner.d.a aVar) {
        this.f5243b = aVar;
    }

    public void a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f5242a = list;
    }

    public int b(int i4) {
        return com.acse.ottn.banner.util.b.a(this.f5245d == 2, i4, a());
    }

    public VH b() {
        return this.f5244c;
    }

    public void c(int i4) {
        this.f5245d = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return a() > 1 ? a() + this.f5245d : a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i4) {
        this.f5244c = vh;
        final int b4 = b(i4);
        a(vh, this.f5242a.get(b4), b4, a());
        if (this.f5243b != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.acse.ottn.banner.adapter.BannerAdapter$1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.acse.ottn.banner.d.a aVar;
                    aVar = a.this.f5243b;
                    aVar.a(a.this.f5242a.get(b4), b4);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        return (VH) a(viewGroup, i4);
    }
}
