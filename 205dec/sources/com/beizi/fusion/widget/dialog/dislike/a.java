package com.beizi.fusion.widget.dialog.dislike;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.fusion.R;
import com.beizi.fusion.g.at;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DislikeDialog.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    private static h f15328b;

    /* renamed from: a  reason: collision with root package name */
    private List<b> f15329a;

    /* renamed from: c  reason: collision with root package name */
    private int f15330c;

    /* renamed from: d  reason: collision with root package name */
    private int f15331d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0149a {

        /* renamed from: a  reason: collision with root package name */
        private RecyclerView f15332a;

        /* renamed from: b  reason: collision with root package name */
        private View f15333b;

        /* renamed from: c  reason: collision with root package name */
        private a f15334c;

        /* renamed from: d  reason: collision with root package name */
        private c f15335d;

        public C0149a(Context context) {
            this.f15334c = new a(context, R.style.beizi_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_dislike_dialog, (ViewGroup) null, false);
            this.f15333b = inflate;
            this.f15334c.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f15332a = (RecyclerView) this.f15333b.findViewById(R.id.beizi_dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f15332a.setLayoutManager(linearLayoutManager);
            a.f15328b.a(new e() { // from class: com.beizi.fusion.widget.dialog.dislike.a.a.1
                @Override // com.beizi.fusion.widget.dialog.dislike.a.e
                public void a(View view, int i4) {
                    if (C0149a.this.f15334c != null) {
                        C0149a.this.f15334c.dismiss();
                    }
                    if (C0149a.this.f15335d != null) {
                        C0149a.this.f15335d.a();
                    }
                }
            });
            this.f15332a.setAdapter(a.f15328b);
            WindowManager.LayoutParams attributes = this.f15334c.getWindow().getAttributes();
            Point point = new Point();
            this.f15334c.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            double d4 = point.x;
            Double.isNaN(d4);
            attributes.width = (int) (d4 * 0.85d);
            attributes.gravity = 17;
            this.f15334c.getWindow().setAttributes(attributes);
        }

        public C0149a a(c cVar) {
            this.f15335d = cVar;
            return this;
        }

        public a a() {
            this.f15334c.setContentView(this.f15333b);
            this.f15334c.setCancelable(true);
            this.f15334c.setCanceledOnTouchOutside(true);
            return this.f15334c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f15337a;

        /* renamed from: b  reason: collision with root package name */
        String f15338b;

        /* renamed from: c  reason: collision with root package name */
        List<d> f15339c;

        b() {
        }

        public List<d> a() {
            return this.f15339c;
        }

        public String b() {
            return this.f15338b;
        }

        public void a(List<d> list) {
            this.f15339c = list;
        }

        public void a(int i4) {
            this.f15337a = i4;
        }

        public void a(String str) {
            this.f15338b = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        String f15341a;

        d() {
        }

        public String a() {
            return this.f15341a;
        }

        public void a(String str) {
            this.f15341a = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface e {
        void a(View view, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface f {
        void a(View view, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class g extends RecyclerView.Adapter {

        /* renamed from: b  reason: collision with root package name */
        private List<d> f15344b;

        /* renamed from: c  reason: collision with root package name */
        private Context f15345c;

        /* renamed from: d  reason: collision with root package name */
        private f f15346d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DislikeDialog.java */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$g$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        class C0150a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f15349a;

            public C0150a(View view) {
                super(view);
                this.f15349a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview_item);
            }
        }

        public g(Context context, List<d> list) {
            this.f15345c = context;
            this.f15344b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f15344b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i4) {
            C0150a c0150a = (C0150a) viewHolder;
            c0150a.f15349a.setText(this.f15344b.get(i4).a());
            at.a(c0150a.itemView, "#FFFAF6F6", 0, "", 10);
            c0150a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.f15346d != null) {
                        g.this.f15346d.a(view, i4);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            return new C0150a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two_recycle_item, viewGroup, false));
        }

        public void a(f fVar) {
            this.f15346d = fVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DislikeDialog.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class h extends RecyclerView.Adapter {

        /* renamed from: a  reason: collision with root package name */
        public e f15351a;

        /* renamed from: c  reason: collision with root package name */
        private Context f15353c;

        /* renamed from: d  reason: collision with root package name */
        private List<b> f15354d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DislikeDialog.java */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$h$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public class C0151a extends RecyclerView.ViewHolder {

            /* renamed from: b  reason: collision with root package name */
            private TextView f15360b;

            public C0151a(View view) {
                super(view);
                this.f15360b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_one_title);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DislikeDialog.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public class b extends RecyclerView.ViewHolder {

            /* renamed from: b  reason: collision with root package name */
            private TextView f15362b;

            /* renamed from: c  reason: collision with root package name */
            private RecyclerView f15363c;

            public b(View view) {
                super(view);
                this.f15362b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_title);
                this.f15363c = (RecyclerView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview);
            }
        }

        public h(Context context, List<b> list) {
            this.f15353c = context;
            this.f15354d = list;
        }

        public void a(e eVar) {
            this.f15351a = eVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f15354d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i4) {
            return (this.f15354d.get(i4).a() == null || this.f15354d.get(i4).a().size() <= 0) ? a.this.f15330c : a.this.f15331d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i4) {
            if (viewHolder instanceof C0151a) {
                ((C0151a) viewHolder).f15360b.setText(this.f15354d.get(i4).b());
            } else {
                b bVar = (b) viewHolder;
                bVar.f15362b.setText(this.f15354d.get(i4).b());
                bVar.f15363c.setLayoutManager(new FlowLayoutManager());
                a aVar = a.this;
                g gVar = new g(aVar.getContext(), this.f15354d.get(i4).a());
                bVar.f15363c.setAdapter(gVar);
                gVar.a(new f() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.1
                    @Override // com.beizi.fusion.widget.dialog.dislike.a.f
                    public void a(View view, int i5) {
                        e eVar = h.this.f15351a;
                        if (eVar != null) {
                            eVar.a(view, i5);
                        }
                    }
                });
                bVar.f15363c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.2
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        super.getItemOffsets(rect, view, recyclerView, state);
                        rect.bottom = 30;
                        rect.left = 60;
                    }
                });
            }
            if (this.f15351a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int layoutPosition = viewHolder.getLayoutPosition();
                        if (a.this.f15331d != h.this.getItemViewType(layoutPosition)) {
                            h.this.f15351a.a(viewHolder.itemView, layoutPosition);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            if (i4 == a.this.f15330c) {
                return new C0151a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_one, viewGroup, false));
            }
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two, viewGroup, false));
        }
    }

    public a(@NonNull Context context, int i4) {
        super(context, i4);
        this.f15329a = null;
        this.f15330c = 1;
        this.f15331d = 2;
        List<b> b4 = b();
        this.f15329a = b4;
        f15328b = new h(context, b4);
    }

    private List<b> b() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a("\u5185\u5bb9\u65e0\u6cd5\u6b63\u5e38\u5c55\u793a\uff08\u5361\u987f\u3001\u9ed1\u767d\u5c4f\uff09");
        bVar.a(this.f15330c);
        arrayList.add(bVar);
        b bVar2 = new b();
        bVar2.a("\u4e0d\u611f\u5174\u8da3");
        bVar2.a(this.f15330c);
        arrayList.add(bVar2);
        b bVar3 = new b();
        bVar3.a("\u65e0\u6cd5\u5173\u95ed");
        bVar3.a(this.f15330c);
        arrayList.add(bVar3);
        ArrayList arrayList2 = new ArrayList();
        d dVar = new d();
        dVar.a("\u7591\u4f3c\u6284\u88ad");
        arrayList2.add(dVar);
        d dVar2 = new d();
        dVar2.a("\u865a\u5047\u6b3a\u8bc8");
        arrayList2.add(dVar2);
        d dVar3 = new d();
        dVar3.a("\u8fdd\u6cd5\u8fdd\u89c4");
        arrayList2.add(dVar3);
        d dVar4 = new d();
        dVar4.a("\u4f4e\u4fd7\u8272\u60c5");
        arrayList2.add(dVar4);
        b bVar4 = new b();
        bVar4.a("\u4e3e\u62a5\u5e7f\u544a");
        bVar4.a(arrayList2);
        bVar4.a(this.f15330c);
        arrayList.add(bVar4);
        return arrayList;
    }
}
