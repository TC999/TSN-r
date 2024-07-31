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
import cn.bluemobi.dylan.photoview.library.PhotoViewAttacher;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ImageDetailFragment extends Fragment {

    /* renamed from: a */
    private String f1861a;

    /* renamed from: b */
    private ImageView f1862b;

    /* renamed from: c */
    private ProgressBar f1863c;

    /* renamed from: d */
    private PhotoViewAttacher f1864d;

    /* renamed from: cn.bluemobi.dylan.photoview.ImageDetailFragment$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1189a implements PhotoViewAttacher.InterfaceC1210f {
        C1189a() {
        }

        @Override // cn.bluemobi.dylan.photoview.library.PhotoViewAttacher.InterfaceC1210f
        /* renamed from: a */
        public void mo57521a(View view, float f, float f2) {
            ImageDetailFragment.this.getActivity().finish();
        }
    }

    /* renamed from: cn.bluemobi.dylan.photoview.ImageDetailFragment$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1190b implements RequestListener<Drawable> {
        C1190b() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean mo44585a(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: b */
        public boolean mo44584c(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            ImageDetailFragment.this.f1862b.setImageDrawable(drawable);
            ImageDetailFragment.this.f1863c.setVisibility(8);
            ImageDetailFragment.this.f1864d.update();
            return false;
        }
    }

    /* renamed from: e */
    public static ImageDetailFragment m57565e(String str) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Glide.m45751C(getContext()).mo45507a(this.f1861a).m44612r(DiskCacheStrategy.f13787b).m44668G0(true).m44625j().m44610s().m45549k1(new C1190b()).m45551i1(this.f1862b);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1861a = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1197R.C1201layout.image_detail_fragment, viewGroup, false);
        this.f1862b = (ImageView) inflate.findViewById(C1197R.C1200id.image);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(this.f1862b);
        this.f1864d = photoViewAttacher;
        photoViewAttacher.setOnPhotoTapListener(new C1189a());
        this.f1863c = (ProgressBar) inflate.findViewById(C1197R.C1200id.loading);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
