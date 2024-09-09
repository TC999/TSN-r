package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UCropFragment extends Fragment {
    public static final Bitmap.CompressFormat A = Bitmap.CompressFormat.JPEG;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final String F = "UCropFragment";
    private static final long G = 50;
    private static final int H = 3;
    private static final int I = 15000;
    private static final int J = 42;

    /* renamed from: z  reason: collision with root package name */
    public static final int f54277z = 90;

    /* renamed from: a  reason: collision with root package name */
    private com.yalantis.ucrop.c f54278a;

    /* renamed from: b  reason: collision with root package name */
    private int f54279b;

    /* renamed from: c  reason: collision with root package name */
    private int f54280c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    private int f54281d;

    /* renamed from: e  reason: collision with root package name */
    private int f54282e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f54283f;

    /* renamed from: g  reason: collision with root package name */
    private Transition f54284g;

    /* renamed from: h  reason: collision with root package name */
    private UCropView f54285h;

    /* renamed from: i  reason: collision with root package name */
    private GestureCropImageView f54286i;

    /* renamed from: j  reason: collision with root package name */
    private OverlayView f54287j;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f54288k;

    /* renamed from: l  reason: collision with root package name */
    private ViewGroup f54289l;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f54290m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f54291n;

    /* renamed from: o  reason: collision with root package name */
    private ViewGroup f54292o;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f54293p;

    /* renamed from: r  reason: collision with root package name */
    private TextView f54295r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f54296s;

    /* renamed from: t  reason: collision with root package name */
    private View f54297t;

    /* renamed from: q  reason: collision with root package name */
    private List<ViewGroup> f54294q = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    private Bitmap.CompressFormat f54298u = A;

    /* renamed from: v  reason: collision with root package name */
    private int f54299v = 90;

    /* renamed from: w  reason: collision with root package name */
    private int[] f54300w = {1, 2, 3};

    /* renamed from: x  reason: collision with root package name */
    private TransformImageView.b f54301x = new a();

    /* renamed from: y  reason: collision with root package name */
    private final View.OnClickListener f54302y = new g();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface GestureTypes {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements TransformImageView.b {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void a() {
            UCropFragment.this.f54285h.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.f54297t.setClickable(false);
            UCropFragment.this.f54278a.b(false);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b(@NonNull Exception exc) {
            UCropFragment.this.f54278a.a(UCropFragment.this.H(exc));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(float f4) {
            UCropFragment.this.Y(f4);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f4) {
            UCropFragment.this.U(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.f54286i.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).b(view.isSelected()));
            UCropFragment.this.f54286i.y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropFragment.this.f54294q) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements HorizontalProgressWheelView.a {
        c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropFragment.this.f54286i.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropFragment.this.f54286i.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f4, float f5) {
            UCropFragment.this.f54286i.w(f4 / 42.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.S(90);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class f implements HorizontalProgressWheelView.a {
        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropFragment.this.f54286i.y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b() {
            UCropFragment.this.f54286i.s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void onScroll(float f4, float f5) {
            if (f4 > 0.0f) {
                UCropFragment.this.f54286i.B(UCropFragment.this.f54286i.getCurrentScale() + (f4 * ((UCropFragment.this.f54286i.getMaxScale() - UCropFragment.this.f54286i.getMinScale()) / 15000.0f)));
            } else {
                UCropFragment.this.f54286i.D(UCropFragment.this.f54286i.getCurrentScale() + (f4 * ((UCropFragment.this.f54286i.getMaxScale() - UCropFragment.this.f54286i.getMinScale()) / 15000.0f)));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropFragment.this.Z(view.getId());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class h implements c1.a {
        h() {
        }

        @Override // c1.a
        public void a(@NonNull Uri uri, int i4, int i5, int i6, int i7) {
            com.yalantis.ucrop.c cVar = UCropFragment.this.f54278a;
            UCropFragment uCropFragment = UCropFragment.this;
            cVar.a(uCropFragment.N(uri, uCropFragment.f54286i.getTargetAspectRatio(), i4, i5, i6, i7));
            UCropFragment.this.f54278a.b(false);
        }

        @Override // c1.a
        public void b(@NonNull Throwable th) {
            UCropFragment.this.f54278a.a(UCropFragment.this.H(th));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public int f54311a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f54312b;

        public i(int i4, Intent intent) {
            this.f54311a = i4;
            this.f54312b = intent;
        }
    }

    private void O(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.f54285h = uCropView;
        this.f54286i = uCropView.getCropImageView();
        this.f54287j = this.f54285h.getOverlayView();
        this.f54286i.setTransformImageListener(this.f54301x);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.f54282e, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.f54281d);
    }

    public static UCropFragment P(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    private void Q(@NonNull Bundle bundle) {
        String string = bundle.getString("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = A;
        }
        this.f54298u = valueOf;
        this.f54299v = bundle.getInt("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArray = bundle.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (intArray != null && intArray.length == 3) {
            this.f54300w = intArray;
        }
        this.f54286i.setMaxBitmapSize(bundle.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.f54286i.setMaxScaleMultiplier(bundle.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.f54286i.setImageToWrapCropBoundsAnimDuration(bundle.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f54287j.setFreestyleCropEnabled(bundle.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f54287j.setDimmedColor(bundle.getInt("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f54287j.setCircleDimmedLayer(bundle.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f54287j.setShowCropFrame(bundle.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
        this.f54287j.setCropFrameColor(bundle.getInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f54287j.setCropFrameStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f54287j.setShowCropGrid(bundle.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
        this.f54287j.setCropGridRowCount(bundle.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f54287j.setCropGridColumnCount(bundle.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f54287j.setCropGridColor(bundle.getInt("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f54287j.setCropGridStrokeWidth(bundle.getInt("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f4 = bundle.getFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float f5 = bundle.getFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int i4 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (f4 > 0.0f && f5 > 0.0f) {
            ViewGroup viewGroup = this.f54288k;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f54286i.setTargetAspectRatio(f4 / f5);
        } else if (parcelableArrayList != null && i4 < parcelableArrayList.size()) {
            this.f54286i.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i4)).b() / ((AspectRatio) parcelableArrayList.get(i4)).c());
        } else {
            this.f54286i.setTargetAspectRatio(0.0f);
        }
        int i5 = bundle.getInt("com.yalantis.ucrop.MaxSizeX", 0);
        int i6 = bundle.getInt("com.yalantis.ucrop.MaxSizeY", 0);
        if (i5 <= 0 || i6 <= 0) {
            return;
        }
        this.f54286i.setMaxResultImageSizeX(i5);
        this.f54286i.setMaxResultImageSizeY(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        GestureCropImageView gestureCropImageView = this.f54286i;
        gestureCropImageView.w(-gestureCropImageView.getCurrentAngle());
        this.f54286i.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i4) {
        this.f54286i.w(i4);
        this.f54286i.y();
    }

    private void T(int i4) {
        GestureCropImageView gestureCropImageView = this.f54286i;
        int[] iArr = this.f54300w;
        boolean z3 = false;
        gestureCropImageView.setScaleEnabled(iArr[i4] == 3 || iArr[i4] == 1);
        GestureCropImageView gestureCropImageView2 = this.f54286i;
        int[] iArr2 = this.f54300w;
        gestureCropImageView2.setRotateEnabled((iArr2[i4] == 3 || iArr2[i4] == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f4) {
        TextView textView = this.f54295r;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f\u00b0", Float.valueOf(f4)));
        }
    }

    private void W(@NonNull Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) bundle.getParcelable("com.yalantis.ucrop.OutputUri");
        Q(bundle);
        if (uri != null && uri2 != null) {
            try {
                this.f54286i.m(uri, uri2);
                return;
            } catch (Exception e4) {
                this.f54278a.a(H(e4));
                return;
            }
        }
        this.f54278a.a(H(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
    }

    private void X() {
        if (this.f54283f) {
            if (this.f54288k.getVisibility() == 0) {
                Z(R.id.state_aspect_ratio);
                return;
            } else {
                Z(R.id.state_scale);
                return;
            }
        }
        T(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(float f4) {
        TextView textView = this.f54296s;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f4 * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(@IdRes int i4) {
        if (this.f54283f) {
            ViewGroup viewGroup = this.f54288k;
            int i5 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i4 == i5);
            ViewGroup viewGroup2 = this.f54289l;
            int i6 = R.id.state_rotate;
            viewGroup2.setSelected(i4 == i6);
            ViewGroup viewGroup3 = this.f54290m;
            int i7 = R.id.state_scale;
            viewGroup3.setSelected(i4 == i7);
            this.f54291n.setVisibility(i4 == i5 ? 0 : 8);
            this.f54292o.setVisibility(i4 == i6 ? 0 : 8);
            this.f54293p.setVisibility(i4 == i7 ? 0 : 8);
            m(i4);
            if (i4 == i7) {
                T(0);
            } else if (i4 == i6) {
                T(1);
            } else {
                T(2);
            }
        }
    }

    private void a0(@NonNull Bundle bundle, View view) {
        int i4 = bundle.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i4 = 2;
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f54280c);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f54294q.add(frameLayout);
        }
        this.f54294q.get(i4).setSelected(true);
        for (ViewGroup viewGroup : this.f54294q) {
            viewGroup.setOnClickListener(new b());
        }
    }

    private void b0(View view) {
        this.f54295r = (TextView) view.findViewById(R.id.text_view_rotate);
        int i4 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i4)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) view.findViewById(i4)).setMiddleLineColor(this.f54280c);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void c0(View view) {
        this.f54296s = (TextView) view.findViewById(R.id.text_view_scale);
        int i4 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i4)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) view.findViewById(i4)).setMiddleLineColor(this.f54280c);
    }

    private void d0(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new com.yalantis.ucrop.util.i(imageView.getDrawable(), this.f54279b));
        imageView2.setImageDrawable(new com.yalantis.ucrop.util.i(imageView2.getDrawable(), this.f54279b));
        imageView3.setImageDrawable(new com.yalantis.ucrop.util.i(imageView3.getDrawable(), this.f54279b));
    }

    private void l(View view) {
        if (this.f54297t == null) {
            this.f54297t = new View(getContext());
            this.f54297t.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f54297t.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.f54297t);
    }

    private void m(int i4) {
        if (getView() != null) {
            TransitionManager.beginDelayedTransition((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.f54284g);
        }
        this.f54290m.findViewById(R.id.text_view_scale).setVisibility(i4 == R.id.state_scale ? 0 : 8);
        this.f54288k.findViewById(R.id.text_view_crop).setVisibility(i4 == R.id.state_aspect_ratio ? 0 : 8);
        this.f54289l.findViewById(R.id.text_view_rotate).setVisibility(i4 != R.id.state_rotate ? 8 : 0);
    }

    public void D() {
        this.f54297t.setClickable(true);
        this.f54278a.b(true);
        this.f54286i.t(this.f54298u, this.f54299v, new h());
    }

    protected i H(Throwable th) {
        return new i(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    protected i N(Uri uri, float f4, int i4, int i5, int i6, int i7) {
        return new i(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f4).putExtra("com.yalantis.ucrop.ImageWidth", i6).putExtra("com.yalantis.ucrop.ImageHeight", i7).putExtra("com.yalantis.ucrop.OffsetX", i4).putExtra("com.yalantis.ucrop.OffsetY", i5));
    }

    public void V(com.yalantis.ucrop.c cVar) {
        this.f54278a = cVar;
    }

    public void e0(View view, Bundle bundle) {
        this.f54280c = bundle.getInt("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_background));
        this.f54279b = bundle.getInt("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.f54282e = bundle.getInt("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.f54283f = !bundle.getBoolean("com.yalantis.ucrop.HideBottomControls", false);
        this.f54281d = bundle.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        O(view);
        this.f54278a.b(true);
        if (this.f54283f) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.f54281d);
            LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f54284g = autoTransition;
            autoTransition.setDuration(50L);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.f54288k = viewGroup2;
            viewGroup2.setOnClickListener(this.f54302y);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.f54289l = viewGroup3;
            viewGroup3.setOnClickListener(this.f54302y);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.f54290m = viewGroup4;
            viewGroup4.setOnClickListener(this.f54302y);
            this.f54291n = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.f54292o = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.f54293p = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            a0(bundle, view);
            b0(view);
            c0(view);
            d0(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof com.yalantis.ucrop.c) {
            this.f54278a = (com.yalantis.ucrop.c) getParentFragment();
        } else if (context instanceof com.yalantis.ucrop.c) {
            this.f54278a = (com.yalantis.ucrop.c) context;
        } else {
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        e0(inflate, arguments);
        W(arguments);
        X();
        l(inflate);
        return inflate;
    }
}
