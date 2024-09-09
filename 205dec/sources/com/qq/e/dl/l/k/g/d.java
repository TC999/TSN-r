package com.qq.e.dl.l.k.g;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.dl.l.g;
import com.qq.e.dl.l.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f47211a;

    /* renamed from: b  reason: collision with root package name */
    private final g f47212b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.dl.i.g[] f47213c;

    /* renamed from: d  reason: collision with root package name */
    private final c f47214d;

    /* renamed from: f  reason: collision with root package name */
    private JSONArray f47216f;

    /* renamed from: g  reason: collision with root package name */
    private int f47217g;

    /* renamed from: i  reason: collision with root package name */
    private h.d f47219i;

    /* renamed from: e  reason: collision with root package name */
    private final List<JSONObject> f47215e = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f47218h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(boolean z3, com.qq.e.dl.i.g[] gVarArr, g gVar, c cVar) {
        this.f47211a = z3;
        this.f47213c = gVarArr;
        this.f47212b = gVar;
        this.f47214d = cVar;
        if (z3) {
            return;
        }
        this.f47217g = gVarArr.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i4 = this.f47217g;
        if (i4 > 0) {
            if (this.f47218h) {
                return Integer.MAX_VALUE;
            }
            return i4;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        int i5 = this.f47217g;
        if (i5 <= 0) {
            return -1;
        }
        int i6 = i4 % i5;
        return this.f47211a ? this.f47216f.optJSONObject(i6).optInt("childIndex") : i6;
    }

    public void a(boolean z3) {
        this.f47218h = z3;
    }

    public boolean a() {
        return this.f47211a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final h f47220a;

        /* renamed from: b  reason: collision with root package name */
        public final h.d f47221b;

        /* renamed from: c  reason: collision with root package name */
        public h.d f47222c;

        public a(h hVar) {
            super(hVar.m());
            this.f47221b = new C0919a();
            this.f47220a = hVar;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.dl.l.k.g.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class C0919a implements h.d {
            C0919a() {
            }

            @Override // com.qq.e.dl.l.d
            public void a(h hVar, com.qq.e.dl.l.j.c cVar) {
                if (a.this.f47222c == null) {
                    return;
                }
                cVar.a("viewIndex", Integer.valueOf(a()));
                a.this.f47222c.a(hVar, cVar);
            }

            @Override // com.qq.e.dl.l.d
            public boolean b(h hVar, com.qq.e.dl.l.j.c cVar) {
                if (a.this.f47222c == null) {
                    return false;
                }
                cVar.a("viewIndex", Integer.valueOf(a()));
                return a.this.f47222c.b(hVar, cVar);
            }

            @Override // com.qq.e.dl.l.d
            public void c(h hVar, com.qq.e.dl.l.j.c cVar) {
                if (a.this.f47222c == null) {
                    return;
                }
                cVar.a("viewIndex", Integer.valueOf(a()));
                a.this.f47222c.c(hVar, cVar);
            }

            @Override // com.qq.e.dl.l.d
            public void a(h hVar, com.qq.e.dl.l.j.c cVar, float f4) {
                if (a.this.f47222c == null) {
                    return;
                }
                cVar.a("viewIndex", Integer.valueOf(a()));
                a.this.f47222c.a(hVar, cVar, f4);
            }

            private int a() {
                return a.this.getLayoutPosition() % ((d) ((RecyclerView) a.this.itemView.getParent()).getAdapter()).f47217g;
            }
        }

        public a(View view) {
            super(view);
            this.f47221b = new C0919a();
            this.f47220a = null;
        }
    }

    public void a(Object obj) {
        if (this.f47211a) {
            JSONArray jSONArray = (JSONArray) obj;
            this.f47216f = jSONArray;
            this.f47217g = jSONArray == null ? 0 : jSONArray.length();
        } else {
            this.f47215e.add((JSONObject) obj);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        h a4;
        if (i4 >= 0 && (a4 = this.f47212b.a(this.f47214d.a(), this.f47214d.p(), this.f47213c[i4], null)) != null) {
            this.f47214d.b(a4);
            a4.i().b(viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
            return new a(a4);
        }
        return new a(new View(viewGroup.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i4) {
        h hVar = aVar.f47220a;
        if (hVar == null) {
            return;
        }
        int i5 = this.f47217g;
        if (i5 > 0) {
            if (this.f47211a) {
                hVar.c(this.f47216f.optJSONObject(i4 % i5));
            } else {
                for (JSONObject jSONObject : this.f47215e) {
                    aVar.f47220a.c(jSONObject);
                }
            }
        }
        h.d dVar = this.f47219i;
        aVar.f47222c = dVar;
        if (dVar != null) {
            aVar.f47220a.a(aVar.f47221b);
        }
    }

    public void a(h.d dVar) {
        if (dVar == this.f47219i) {
            return;
        }
        this.f47219i = dVar;
        notifyDataSetChanged();
    }
}
