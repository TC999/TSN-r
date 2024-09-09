package cn.bluemobi.dylan.photoview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.photoview.library.d;
import com.bumptech.glide.i;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ImageDetailFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private String f1846a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f1847b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f1848c;

    /* renamed from: d  reason: collision with root package name */
    private d f1849d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a implements d.f {
        a() {
        }

        @Override // cn.bluemobi.dylan.photoview.library.d.f
        public void a(View view, float f4, float f5) {
            ImageDetailFragment.this.getActivity().finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class b implements g<Drawable> {
        b() {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, p<Drawable> pVar, boolean z3) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        /* renamed from: b */
        public boolean c(Drawable drawable, Object obj, p<Drawable> pVar, DataSource dataSource, boolean z3) {
            ImageDetailFragment.this.f1847b.setImageDrawable(drawable);
            ImageDetailFragment.this.f1848c.setVisibility(8);
            ImageDetailFragment.this.f1849d.update();
            return false;
        }
    }

    public static ImageDetailFragment e(String str) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((i) ((i) com.bumptech.glide.d.C(getContext()).a(this.f1846a).s(j.f17104b)).H0(true)).k().t().l1(new b()).j1(this.f1847b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1846a = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.image_detail_fragment, viewGroup, false);
        this.f1847b = (ImageView) inflate.findViewById(R.id.image);
        d dVar = new d(this.f1847b);
        this.f1849d = dVar;
        dVar.setOnPhotoTapListener(new a());
        this.f1848c = (ProgressBar) inflate.findViewById(R.id.loading);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
