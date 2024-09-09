package com.acse.ottn;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class t<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements m1<T, VH> {

    /* renamed from: b  reason: collision with root package name */
    public r2 f6601b;

    /* renamed from: c  reason: collision with root package name */
    public VH f6602c;

    /* renamed from: a  reason: collision with root package name */
    public List<T> f6600a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f6603d = 2;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f6604a;

        public a(int i4) {
            this.f6604a = i4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.this.f6601b.a(t.this.f6600a.get(this.f6604a), this.f6604a);
        }
    }

    public t(List<T> list) {
        a(list);
    }

    public int b(int i4) {
        return y.a(this.f6603d == 2, i4, a());
    }

    public void c(int i4) {
        this.f6603d = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return a() > 1 ? a() + this.f6603d : a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i4) {
        this.f6602c = vh;
        int b4 = b(i4);
        a(vh, this.f6600a.get(b4), b4, a());
        if (this.f6601b != null) {
            vh.itemView.setOnClickListener(new a(b4));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        return (VH) a(viewGroup, i4);
    }

    public void a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f6600a = list;
    }

    public VH b() {
        return this.f6602c;
    }

    public T a(int i4) {
        return this.f6600a.get(i4);
    }

    public int a() {
        List<T> list = this.f6600a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(r2 r2Var) {
        this.f6601b = r2Var;
    }
}
