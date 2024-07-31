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
import com.beizi.fusion.C3025R;
import com.beizi.fusion.p072g.ShapeUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.beizi.fusion.widget.dialog.dislike.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DislikeDialog extends Dialog {

    /* renamed from: b */
    private static C3245h f11750b;

    /* renamed from: a */
    private List<C3237b> f11751a;

    /* renamed from: c */
    private int f11752c;

    /* renamed from: d */
    private int f11753d;

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3235a {

        /* renamed from: a */
        private RecyclerView f11754a;

        /* renamed from: b */
        private View f11755b;

        /* renamed from: c */
        private DislikeDialog f11756c;

        /* renamed from: d */
        private InterfaceC3238c f11757d;

        public C3235a(Context context) {
            this.f11756c = new DislikeDialog(context, C3025R.C3031style.beizi_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C3025R.C3029layout.beizi_dislike_dialog, (ViewGroup) null, false);
            this.f11755b = inflate;
            this.f11756c.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f11754a = (RecyclerView) this.f11755b.findViewById(C3025R.C3028id.beizi_dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f11754a.setLayoutManager(linearLayoutManager);
            DislikeDialog.f11750b.m47998a(new InterfaceC3240e() { // from class: com.beizi.fusion.widget.dialog.dislike.a.a.1
                @Override // com.beizi.fusion.widget.dialog.dislike.DislikeDialog.InterfaceC3240e
                /* renamed from: a */
                public void mo48001a(View view, int i) {
                    if (C3235a.this.f11756c != null) {
                        C3235a.this.f11756c.dismiss();
                    }
                    if (C3235a.this.f11757d != null) {
                        C3235a.this.f11757d.mo46798a();
                    }
                }
            });
            this.f11754a.setAdapter(DislikeDialog.f11750b);
            WindowManager.LayoutParams attributes = this.f11756c.getWindow().getAttributes();
            Point point = new Point();
            this.f11756c.getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            double d = point.x;
            Double.isNaN(d);
            attributes.width = (int) (d * 0.85d);
            attributes.gravity = 17;
            this.f11756c.getWindow().setAttributes(attributes);
        }

        /* renamed from: a */
        public C3235a m48010a(InterfaceC3238c interfaceC3238c) {
            this.f11757d = interfaceC3238c;
            return this;
        }

        /* renamed from: a */
        public DislikeDialog m48012a() {
            this.f11756c.setContentView(this.f11755b);
            this.f11756c.setCancelable(true);
            this.f11756c.setCanceledOnTouchOutside(true);
            return this.f11756c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3237b {

        /* renamed from: a */
        int f11759a;

        /* renamed from: b */
        String f11760b;

        /* renamed from: c */
        List<C3239d> f11761c;

        C3237b() {
        }

        /* renamed from: a */
        public List<C3239d> m48008a() {
            return this.f11761c;
        }

        /* renamed from: b */
        public String m48004b() {
            return this.f11760b;
        }

        /* renamed from: a */
        public void m48005a(List<C3239d> list) {
            this.f11761c = list;
        }

        /* renamed from: a */
        public void m48007a(int i) {
            this.f11759a = i;
        }

        /* renamed from: a */
        public void m48006a(String str) {
            this.f11760b = str;
        }
    }

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3238c {
        /* renamed from: a */
        void mo46798a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3239d {

        /* renamed from: a */
        String f11763a;

        C3239d() {
        }

        /* renamed from: a */
        public String m48003a() {
            return this.f11763a;
        }

        /* renamed from: a */
        public void m48002a(String str) {
            this.f11763a = str;
        }
    }

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3240e {
        /* renamed from: a */
        void mo48001a(View view, int i);
    }

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3241f {
        /* renamed from: a */
        void mo47997a(View view, int i);
    }

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3242g extends RecyclerView.Adapter {

        /* renamed from: b */
        private List<C3239d> f11766b;

        /* renamed from: c */
        private Context f11767c;

        /* renamed from: d */
        private InterfaceC3241f f11768d;

        /* compiled from: DislikeDialog.java */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$g$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3244a extends RecyclerView.ViewHolder {

            /* renamed from: a */
            TextView f11771a;

            public C3244a(View view) {
                super(view);
                this.f11771a = (TextView) view.findViewById(C3025R.C3028id.beizi_dislike_item_multi_two_recycleview_item);
            }
        }

        public C3242g(Context context, List<C3239d> list) {
            this.f11767c = context;
            this.f11766b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11766b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i) {
            C3244a c3244a = (C3244a) viewHolder;
            c3244a.f11771a.setText(this.f11766b.get(i).m48003a());
            ShapeUtil.m48318a(c3244a.itemView, "#FFFAF6F6", 0, "", 10);
            c3244a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C3242g.this.f11768d != null) {
                        C3242g.this.f11768d.mo47997a(view, i);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new C3244a(LayoutInflater.from(viewGroup.getContext()).inflate(C3025R.C3029layout.beizi_dislike_item_multi_two_recycle_item, viewGroup, false));
        }

        /* renamed from: a */
        public void m48000a(InterfaceC3241f interfaceC3241f) {
            this.f11768d = interfaceC3241f;
        }
    }

    /* compiled from: DislikeDialog.java */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3245h extends RecyclerView.Adapter {

        /* renamed from: a */
        public InterfaceC3240e f11773a;

        /* renamed from: c */
        private Context f11775c;

        /* renamed from: d */
        private List<C3237b> f11776d;

        /* compiled from: DislikeDialog.java */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$h$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public class C3249a extends RecyclerView.ViewHolder {

            /* renamed from: b */
            private TextView f11782b;

            public C3249a(View view) {
                super(view);
                this.f11782b = (TextView) view.findViewById(C3025R.C3028id.beizi_dislike_item_multi_one_title);
            }
        }

        /* compiled from: DislikeDialog.java */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$h$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public class C3250b extends RecyclerView.ViewHolder {

            /* renamed from: b */
            private TextView f11784b;

            /* renamed from: c */
            private RecyclerView f11785c;

            public C3250b(View view) {
                super(view);
                this.f11784b = (TextView) view.findViewById(C3025R.C3028id.beizi_dislike_item_multi_two_title);
                this.f11785c = (RecyclerView) view.findViewById(C3025R.C3028id.beizi_dislike_item_multi_two_recycleview);
            }
        }

        public C3245h(Context context, List<C3237b> list) {
            this.f11775c = context;
            this.f11776d = list;
        }

        /* renamed from: a */
        public void m47998a(InterfaceC3240e interfaceC3240e) {
            this.f11773a = interfaceC3240e;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11776d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (this.f11776d.get(i).m48008a() == null || this.f11776d.get(i).m48008a().size() <= 0) ? DislikeDialog.this.f11752c : DislikeDialog.this.f11753d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof C3249a) {
                ((C3249a) viewHolder).f11782b.setText(this.f11776d.get(i).m48004b());
            } else {
                C3250b c3250b = (C3250b) viewHolder;
                c3250b.f11784b.setText(this.f11776d.get(i).m48004b());
                c3250b.f11785c.setLayoutManager(new FlowLayoutManager());
                DislikeDialog dislikeDialog = DislikeDialog.this;
                C3242g c3242g = new C3242g(dislikeDialog.getContext(), this.f11776d.get(i).m48008a());
                c3250b.f11785c.setAdapter(c3242g);
                c3242g.m48000a(new InterfaceC3241f() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.1
                    @Override // com.beizi.fusion.widget.dialog.dislike.DislikeDialog.InterfaceC3241f
                    /* renamed from: a */
                    public void mo47997a(View view, int i2) {
                        InterfaceC3240e interfaceC3240e = C3245h.this.f11773a;
                        if (interfaceC3240e != null) {
                            interfaceC3240e.mo48001a(view, i2);
                        }
                    }
                });
                c3250b.f11785c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.2
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        super.getItemOffsets(rect, view, recyclerView, state);
                        rect.bottom = 30;
                        rect.left = 60;
                    }
                });
            }
            if (this.f11773a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int layoutPosition = viewHolder.getLayoutPosition();
                        if (DislikeDialog.this.f11753d != C3245h.this.getItemViewType(layoutPosition)) {
                            C3245h.this.f11773a.mo48001a(viewHolder.itemView, layoutPosition);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            if (i == DislikeDialog.this.f11752c) {
                return new C3249a(LayoutInflater.from(viewGroup.getContext()).inflate(C3025R.C3029layout.beizi_dislike_item_multi_one, viewGroup, false));
            }
            return new C3250b(LayoutInflater.from(viewGroup.getContext()).inflate(C3025R.C3029layout.beizi_dislike_item_multi_two, viewGroup, false));
        }
    }

    public DislikeDialog(@NonNull Context context, int i) {
        super(context, i);
        this.f11751a = null;
        this.f11752c = 1;
        this.f11753d = 2;
        List<C3237b> m48014b = m48014b();
        this.f11751a = m48014b;
        f11750b = new C3245h(context, m48014b);
    }

    /* renamed from: b */
    private List<C3237b> m48014b() {
        ArrayList arrayList = new ArrayList();
        C3237b c3237b = new C3237b();
        c3237b.m48006a("内容无法正常展示（卡顿、黑白屏）");
        c3237b.m48007a(this.f11752c);
        arrayList.add(c3237b);
        C3237b c3237b2 = new C3237b();
        c3237b2.m48006a("不感兴趣");
        c3237b2.m48007a(this.f11752c);
        arrayList.add(c3237b2);
        C3237b c3237b3 = new C3237b();
        c3237b3.m48006a("无法关闭");
        c3237b3.m48007a(this.f11752c);
        arrayList.add(c3237b3);
        ArrayList arrayList2 = new ArrayList();
        C3239d c3239d = new C3239d();
        c3239d.m48002a("疑似抄袭");
        arrayList2.add(c3239d);
        C3239d c3239d2 = new C3239d();
        c3239d2.m48002a("虚假欺诈");
        arrayList2.add(c3239d2);
        C3239d c3239d3 = new C3239d();
        c3239d3.m48002a("违法违规");
        arrayList2.add(c3239d3);
        C3239d c3239d4 = new C3239d();
        c3239d4.m48002a("低俗色情");
        arrayList2.add(c3239d4);
        C3237b c3237b4 = new C3237b();
        c3237b4.m48006a("举报广告");
        c3237b4.m48005a(arrayList2);
        c3237b4.m48007a(this.f11752c);
        arrayList.add(c3237b4);
        return arrayList;
    }
}
