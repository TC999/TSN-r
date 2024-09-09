package cn.bluemobi.dylan.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.R;
import com.bumptech.glide.Priority;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import java.io.File;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GridViewAddImagesAdapter.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f1684a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1685b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f1686c;

    /* renamed from: d  reason: collision with root package name */
    private int f1687d;

    /* renamed from: e  reason: collision with root package name */
    private int f1688e = R.drawable.image_add;

    /* renamed from: f  reason: collision with root package name */
    private int f1689f = 9;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GridViewAddImagesAdapter.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f1690a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1691b;

        a(File file, int i4) {
            this.f1690a = file;
            this.f1691b = i4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1690a.exists()) {
                this.f1690a.delete();
            }
            c.this.f1684a.remove(this.f1691b);
            c.this.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: GridViewAddImagesAdapter.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final ImageView f1693a;

        /* renamed from: b  reason: collision with root package name */
        public final Button f1694b;

        /* renamed from: c  reason: collision with root package name */
        public final View f1695c;

        public b(View view) {
            this.f1693a = (ImageView) view.findViewById(R.id.iv_image);
            this.f1694b = (Button) view.findViewById(R.id.bt_del);
            this.f1695c = view;
        }
    }

    public c(List<String> list, Context context, int i4, int i5) {
        this.f1684a = list;
        this.f1685b = context;
        this.f1687d = (context.getResources().getDisplayMetrics().widthPixels - (i5 * (i4 + 1))) / i4;
        this.f1686c = LayoutInflater.from(context);
    }

    public int b() {
        return this.f1689f;
    }

    public void c(List<String> list) {
        this.f1684a = list;
        notifyDataSetChanged();
    }

    public c d(int i4) {
        this.f1688e = i4;
        return this;
    }

    public c e(int i4) {
        this.f1689f = i4;
        return this;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f1684a;
        int size = list != null ? 1 + list.size() : 1;
        return size > this.f1689f ? this.f1684a.size() : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f1686c.inflate(R.layout.pub_item_grid_add_image, viewGroup, false);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1687d));
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        List<String> list = this.f1684a;
        if (list != null && i4 < list.size()) {
            File file = new File(this.f1684a.get(i4));
            ((i) d.C(this.f1685b).o(this.f1684a.get(i4).startsWith("http") ? this.f1684a.get(i4) : file).z0(Priority.HIGH)).j1(bVar.f1693a);
            bVar.f1694b.setVisibility(0);
            bVar.f1694b.setOnClickListener(new a(file, i4));
        } else {
            ((i) d.C(this.f1685b).p(Integer.valueOf(this.f1688e)).z0(Priority.HIGH)).j1(bVar.f1693a);
            bVar.f1693a.setScaleType(ImageView.ScaleType.FIT_XY);
            bVar.f1694b.setVisibility(8);
        }
        return view;
    }
}
