package cn.bluemobi.dylan.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.C1108R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import java.io.File;
import java.util.List;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: cn.bluemobi.dylan.base.adapter.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class GridViewAddImagesAdapter extends BaseAdapter {

    /* renamed from: a */
    private List<String> f1698a;

    /* renamed from: b */
    private Context f1699b;

    /* renamed from: c */
    private LayoutInflater f1700c;

    /* renamed from: d */
    private int f1701d;

    /* renamed from: e */
    private int f1702e = C1108R.C1111drawable.image_add;

    /* renamed from: f */
    private int f1703f = 9;

    /* compiled from: GridViewAddImagesAdapter.java */
    /* renamed from: cn.bluemobi.dylan.base.adapter.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class View$OnClickListenerC1120a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ File f1704a;

        /* renamed from: b */
        final /* synthetic */ int f1705b;

        View$OnClickListenerC1120a(File file, int i) {
            this.f1704a = file;
            this.f1705b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1704a.exists()) {
                this.f1704a.delete();
            }
            GridViewAddImagesAdapter.this.f1698a.remove(this.f1705b);
            GridViewAddImagesAdapter.this.notifyDataSetChanged();
        }
    }

    /* compiled from: GridViewAddImagesAdapter.java */
    /* renamed from: cn.bluemobi.dylan.base.adapter.c$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1121b {

        /* renamed from: a */
        public final ImageView f1707a;

        /* renamed from: b */
        public final Button f1708b;

        /* renamed from: c */
        public final View f1709c;

        public C1121b(View view) {
            this.f1707a = (ImageView) view.findViewById(C1108R.C1112id.iv_image);
            this.f1708b = (Button) view.findViewById(C1108R.C1112id.bt_del);
            this.f1709c = view;
        }
    }

    public GridViewAddImagesAdapter(List<String> list, Context context, int i, int i2) {
        this.f1698a = list;
        this.f1699b = context;
        this.f1701d = (context.getResources().getDisplayMetrics().widthPixels - (i2 * (i + 1))) / i;
        this.f1700c = LayoutInflater.from(context);
    }

    /* renamed from: b */
    public int m57887b() {
        return this.f1703f;
    }

    /* renamed from: c */
    public void m57886c(List<String> list) {
        this.f1698a = list;
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public GridViewAddImagesAdapter m57885d(int i) {
        this.f1702e = i;
        return this;
    }

    /* renamed from: e */
    public GridViewAddImagesAdapter m57884e(int i) {
        this.f1703f = i;
        return this;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f1698a;
        int size = list != null ? 1 + list.size() : 1;
        return size > this.f1703f ? this.f1698a.size() : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1121b c1121b;
        if (view == null) {
            view = this.f1700c.inflate(C1108R.C1113layout.pub_item_grid_add_image, viewGroup, false);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1701d));
            c1121b = new C1121b(view);
            view.setTag(c1121b);
        } else {
            c1121b = (C1121b) view.getTag();
        }
        List<String> list = this.f1698a;
        if (list != null && i < list.size()) {
            File file = new File(this.f1698a.get(i));
            Glide.m45751C(this.f1699b).mo45500o(this.f1698a.get(i).startsWith(IDataSource.f43971a) ? this.f1698a.get(i) : file).m44597y0(Priority.HIGH).m45551i1(c1121b.f1707a);
            c1121b.f1708b.setVisibility(0);
            c1121b.f1708b.setOnClickListener(new View$OnClickListenerC1120a(file, i));
        } else {
            Glide.m45751C(this.f1699b).mo45499p(Integer.valueOf(this.f1702e)).m44597y0(Priority.HIGH).m45551i1(c1121b.f1707a);
            c1121b.f1707a.setScaleType(ImageView.ScaleType.FIT_XY);
            c1121b.f1708b.setVisibility(8);
        }
        return view;
    }
}
