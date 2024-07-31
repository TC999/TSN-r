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
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
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
import p028c1.BitmapCropCallback;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UCropFragment extends Fragment {

    /* renamed from: A */
    public static final Bitmap.CompressFormat f39726A = Bitmap.CompressFormat.JPEG;

    /* renamed from: B */
    public static final int f39727B = 0;

    /* renamed from: C */
    public static final int f39728C = 1;

    /* renamed from: D */
    public static final int f39729D = 2;

    /* renamed from: E */
    public static final int f39730E = 3;

    /* renamed from: F */
    public static final String f39731F = "UCropFragment";

    /* renamed from: G */
    private static final long f39732G = 50;

    /* renamed from: H */
    private static final int f39733H = 3;

    /* renamed from: I */
    private static final int f39734I = 15000;

    /* renamed from: J */
    private static final int f39735J = 42;

    /* renamed from: z */
    public static final int f39736z = 90;

    /* renamed from: a */
    private UCropFragmentCallback f39737a;

    /* renamed from: b */
    private int f39738b;

    /* renamed from: c */
    private int f39739c;
    @ColorInt

    /* renamed from: d */
    private int f39740d;

    /* renamed from: e */
    private int f39741e;

    /* renamed from: f */
    private boolean f39742f;

    /* renamed from: g */
    private Transition f39743g;

    /* renamed from: h */
    private UCropView f39744h;

    /* renamed from: i */
    private GestureCropImageView f39745i;

    /* renamed from: j */
    private OverlayView f39746j;

    /* renamed from: k */
    private ViewGroup f39747k;

    /* renamed from: l */
    private ViewGroup f39748l;

    /* renamed from: m */
    private ViewGroup f39749m;

    /* renamed from: n */
    private ViewGroup f39750n;

    /* renamed from: o */
    private ViewGroup f39751o;

    /* renamed from: p */
    private ViewGroup f39752p;

    /* renamed from: r */
    private TextView f39754r;

    /* renamed from: s */
    private TextView f39755s;

    /* renamed from: t */
    private View f39756t;

    /* renamed from: q */
    private List<ViewGroup> f39753q = new ArrayList();

    /* renamed from: u */
    private Bitmap.CompressFormat f39757u = f39726A;

    /* renamed from: v */
    private int f39758v = 90;

    /* renamed from: w */
    private int[] f39759w = {1, 2, 3};

    /* renamed from: x */
    private TransformImageView.InterfaceC13539b f39760x = new C13513a();

    /* renamed from: y */
    private final View.OnClickListener f39761y = new View$OnClickListenerC13519g();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface GestureTypes {
    }

    /* renamed from: com.yalantis.ucrop.UCropFragment$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C13513a implements TransformImageView.InterfaceC13539b {
        C13513a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: a */
        public void mo12924a() {
            UCropFragment.this.f39744h.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.f39756t.setClickable(false);
            UCropFragment.this.f39737a.m13053b(false);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: b */
        public void mo12923b(@NonNull Exception exc) {
            UCropFragment.this.f39737a.m13054a(UCropFragment.this.m13139H(exc));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: c */
        public void mo12922c(float f) {
            UCropFragment.this.m13127Y(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.InterfaceC13539b
        /* renamed from: d */
        public void mo12921d(float f) {
            UCropFragment.this.m13131U(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropFragment$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13514b implements View.OnClickListener {
        View$OnClickListenerC13514b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.f39745i.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).m12913b(view.isSelected()));
            UCropFragment.this.f39745i.m12959y();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropFragment.this.f39753q) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropFragment$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13515c implements HorizontalProgressWheelView.InterfaceC13542a {
        C13515c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: a */
        public void mo12907a() {
            UCropFragment.this.f39745i.m12959y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: b */
        public void mo12906b() {
            UCropFragment.this.f39745i.m12965s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        public void onScroll(float f, float f2) {
            UCropFragment.this.f39745i.m12961w(f / 42.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropFragment$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13516d implements View.OnClickListener {
        View$OnClickListenerC13516d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.m13134R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropFragment$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class View$OnClickListenerC13517e implements View.OnClickListener {
        View$OnClickListenerC13517e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.m13133S(90);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yalantis.ucrop.UCropFragment$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13518f implements HorizontalProgressWheelView.InterfaceC13542a {
        C13518f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: a */
        public void mo12907a() {
            UCropFragment.this.f39745i.m12959y();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        /* renamed from: b */
        public void mo12906b() {
            UCropFragment.this.f39745i.m12965s();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC13542a
        public void onScroll(float f, float f2) {
            if (f > 0.0f) {
                UCropFragment.this.f39745i.m12973B(UCropFragment.this.f39745i.getCurrentScale() + (f * ((UCropFragment.this.f39745i.getMaxScale() - UCropFragment.this.f39745i.getMinScale()) / 15000.0f)));
            } else {
                UCropFragment.this.f39745i.m12971D(UCropFragment.this.f39745i.getCurrentScale() + (f * ((UCropFragment.this.f39745i.getMaxScale() - UCropFragment.this.f39745i.getMinScale()) / 15000.0f)));
            }
        }
    }

    /* renamed from: com.yalantis.ucrop.UCropFragment$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class View$OnClickListenerC13519g implements View.OnClickListener {
        View$OnClickListenerC13519g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropFragment.this.m13126Z(view.getId());
        }
    }

    /* renamed from: com.yalantis.ucrop.UCropFragment$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C13520h implements BitmapCropCallback {
        C13520h() {
        }

        @Override // p028c1.BitmapCropCallback
        /* renamed from: a */
        public void mo13108a(@NonNull Uri uri, int i, int i2, int i3, int i4) {
            UCropFragmentCallback uCropFragmentCallback = UCropFragment.this.f39737a;
            UCropFragment uCropFragment = UCropFragment.this;
            uCropFragmentCallback.m13054a(uCropFragment.m13138N(uri, uCropFragment.f39745i.getTargetAspectRatio(), i, i2, i3, i4));
            UCropFragment.this.f39737a.m13053b(false);
        }

        @Override // p028c1.BitmapCropCallback
        /* renamed from: b */
        public void mo13107b(@NonNull Throwable th) {
            UCropFragment.this.f39737a.m13054a(UCropFragment.this.m13139H(th));
        }
    }

    /* renamed from: com.yalantis.ucrop.UCropFragment$i */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13521i {

        /* renamed from: a */
        public int f39770a;

        /* renamed from: b */
        public Intent f39771b;

        public C13521i(int i, Intent intent) {
            this.f39770a = i;
            this.f39771b = intent;
        }
    }

    /* renamed from: O */
    private void m13137O(View view) {
        UCropView uCropView = (UCropView) view.findViewById(C13495R.C13499id.ucrop);
        this.f39744h = uCropView;
        this.f39745i = uCropView.getCropImageView();
        this.f39746j = this.f39744h.getOverlayView();
        this.f39745i.setTransformImageListener(this.f39760x);
        ((ImageView) view.findViewById(C13495R.C13499id.image_view_logo)).setColorFilter(this.f39741e, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(C13495R.C13499id.ucrop_frame).setBackgroundColor(this.f39740d);
    }

    /* renamed from: P */
    public static UCropFragment m13136P(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    /* renamed from: Q */
    private void m13135Q(@NonNull Bundle bundle) {
        String string = bundle.getString(UCrop.C13523a.f39802b);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (valueOf == null) {
            valueOf = f39726A;
        }
        this.f39757u = valueOf;
        this.f39758v = bundle.getInt(UCrop.C13523a.f39803c, 90);
        int[] intArray = bundle.getIntArray(UCrop.C13523a.f39804d);
        if (intArray != null && intArray.length == 3) {
            this.f39759w = intArray;
        }
        this.f39745i.setMaxBitmapSize(bundle.getInt(UCrop.C13523a.f39805e, 0));
        this.f39745i.setMaxScaleMultiplier(bundle.getFloat(UCrop.C13523a.f39806f, 10.0f));
        this.f39745i.setImageToWrapCropBoundsAnimDuration(bundle.getInt(UCrop.C13523a.f39807g, 500));
        this.f39746j.setFreestyleCropEnabled(bundle.getBoolean(UCrop.C13523a.f39798B, false));
        this.f39746j.setDimmedColor(bundle.getInt(UCrop.C13523a.f39808h, getResources().getColor(C13495R.C13497color.ucrop_color_default_dimmed)));
        this.f39746j.setCircleDimmedLayer(bundle.getBoolean(UCrop.C13523a.f39809i, false));
        this.f39746j.setShowCropFrame(bundle.getBoolean(UCrop.C13523a.f39810j, true));
        this.f39746j.setCropFrameColor(bundle.getInt(UCrop.C13523a.f39811k, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_frame)));
        this.f39746j.setCropFrameStrokeWidth(bundle.getInt(UCrop.C13523a.f39812l, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f39746j.setShowCropGrid(bundle.getBoolean(UCrop.C13523a.f39813m, true));
        this.f39746j.setCropGridRowCount(bundle.getInt(UCrop.C13523a.f39814n, 2));
        this.f39746j.setCropGridColumnCount(bundle.getInt(UCrop.C13523a.f39815o, 2));
        this.f39746j.setCropGridColor(bundle.getInt(UCrop.C13523a.f39816p, getResources().getColor(C13495R.C13497color.ucrop_color_default_crop_grid)));
        this.f39746j.setCropGridStrokeWidth(bundle.getInt(UCrop.C13523a.f39817q, getResources().getDimensionPixelSize(C13495R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f = bundle.getFloat(UCrop.f39791o, 0.0f);
        float f2 = bundle.getFloat(UCrop.f39792p, 0.0f);
        int i = bundle.getInt(UCrop.C13523a.f39799C, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.C13523a.f39800D);
        if (f > 0.0f && f2 > 0.0f) {
            ViewGroup viewGroup = this.f39747k;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f39745i.setTargetAspectRatio(f / f2);
        } else if (parcelableArrayList != null && i < parcelableArrayList.size()) {
            this.f39745i.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i)).m13051b() / ((AspectRatio) parcelableArrayList.get(i)).m13050c());
        } else {
            this.f39745i.setTargetAspectRatio(0.0f);
        }
        int i2 = bundle.getInt(UCrop.f39793q, 0);
        int i3 = bundle.getInt(UCrop.f39794r, 0);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f39745i.setMaxResultImageSizeX(i2);
        this.f39745i.setMaxResultImageSizeY(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public void m13134R() {
        GestureCropImageView gestureCropImageView = this.f39745i;
        gestureCropImageView.m12961w(-gestureCropImageView.getCurrentAngle());
        this.f39745i.m12959y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public void m13133S(int i) {
        this.f39745i.m12961w(i);
        this.f39745i.m12959y();
    }

    /* renamed from: T */
    private void m13132T(int i) {
        GestureCropImageView gestureCropImageView = this.f39745i;
        int[] iArr = this.f39759w;
        boolean z = false;
        gestureCropImageView.setScaleEnabled(iArr[i] == 3 || iArr[i] == 1);
        GestureCropImageView gestureCropImageView2 = this.f39745i;
        int[] iArr2 = this.f39759w;
        gestureCropImageView2.setRotateEnabled((iArr2[i] == 3 || iArr2[i] == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public void m13131U(float f) {
        TextView textView = this.f39754r;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    /* renamed from: W */
    private void m13129W(@NonNull Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(UCrop.f39783g);
        Uri uri2 = (Uri) bundle.getParcelable(UCrop.f39784h);
        m13135Q(bundle);
        if (uri != null && uri2 != null) {
            try {
                this.f39745i.m12928m(uri, uri2);
                return;
            } catch (Exception e) {
                this.f39737a.m13054a(m13139H(e));
                return;
            }
        }
        this.f39737a.m13054a(m13139H(new NullPointerException(getString(C13495R.C13503string.ucrop_error_input_data_is_absent))));
    }

    /* renamed from: X */
    private void m13128X() {
        if (this.f39742f) {
            if (this.f39747k.getVisibility() == 0) {
                m13126Z(C13495R.C13499id.state_aspect_ratio);
                return;
            } else {
                m13126Z(C13495R.C13499id.state_scale);
                return;
            }
        }
        m13132T(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public void m13127Y(float f) {
        TextView textView = this.f39755s;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m13126Z(@IdRes int i) {
        if (this.f39742f) {
            ViewGroup viewGroup = this.f39747k;
            int i2 = C13495R.C13499id.state_aspect_ratio;
            viewGroup.setSelected(i == i2);
            ViewGroup viewGroup2 = this.f39748l;
            int i3 = C13495R.C13499id.state_rotate;
            viewGroup2.setSelected(i == i3);
            ViewGroup viewGroup3 = this.f39749m;
            int i4 = C13495R.C13499id.state_scale;
            viewGroup3.setSelected(i == i4);
            this.f39750n.setVisibility(i == i2 ? 0 : 8);
            this.f39751o.setVisibility(i == i3 ? 0 : 8);
            this.f39752p.setVisibility(i == i4 ? 0 : 8);
            m13109m(i);
            if (i == i4) {
                m13132T(0);
            } else if (i == i3) {
                m13132T(1);
            } else {
                m13132T(2);
            }
        }
    }

    /* renamed from: a0 */
    private void m13125a0(@NonNull Bundle bundle, View view) {
        int i = bundle.getInt(UCrop.C13523a.f39799C, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.C13523a.f39800D);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i = 2;
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(C13495R.C13503string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C13495R.C13499id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(C13495R.C13501layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f39739c);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f39753q.add(frameLayout);
        }
        this.f39753q.get(i).setSelected(true);
        for (ViewGroup viewGroup : this.f39753q) {
            viewGroup.setOnClickListener(new View$OnClickListenerC13514b());
        }
    }

    /* renamed from: b0 */
    private void m13123b0(View view) {
        this.f39754r = (TextView) view.findViewById(C13495R.C13499id.text_view_rotate);
        int i = C13495R.C13499id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i)).setScrollingListener(new C13515c());
        ((HorizontalProgressWheelView) view.findViewById(i)).setMiddleLineColor(this.f39739c);
        view.findViewById(C13495R.C13499id.wrapper_reset_rotate).setOnClickListener(new View$OnClickListenerC13516d());
        view.findViewById(C13495R.C13499id.wrapper_rotate_by_angle).setOnClickListener(new View$OnClickListenerC13517e());
    }

    /* renamed from: c0 */
    private void m13121c0(View view) {
        this.f39755s = (TextView) view.findViewById(C13495R.C13499id.text_view_scale);
        int i = C13495R.C13499id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i)).setScrollingListener(new C13518f());
        ((HorizontalProgressWheelView) view.findViewById(i)).setMiddleLineColor(this.f39739c);
    }

    /* renamed from: d0 */
    private void m13119d0(View view) {
        ImageView imageView = (ImageView) view.findViewById(C13495R.C13499id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(C13495R.C13499id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(C13495R.C13499id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f39738b));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f39738b));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f39738b));
    }

    /* renamed from: l */
    private void m13110l(View view) {
        if (this.f39756t == null) {
            this.f39756t = new View(getContext());
            this.f39756t.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f39756t.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(C13495R.C13499id.ucrop_photobox)).addView(this.f39756t);
    }

    /* renamed from: m */
    private void m13109m(int i) {
        if (getView() != null) {
            TransitionManager.beginDelayedTransition((ViewGroup) getView().findViewById(C13495R.C13499id.ucrop_photobox), this.f39743g);
        }
        this.f39749m.findViewById(C13495R.C13499id.text_view_scale).setVisibility(i == C13495R.C13499id.state_scale ? 0 : 8);
        this.f39747k.findViewById(C13495R.C13499id.text_view_crop).setVisibility(i == C13495R.C13499id.state_aspect_ratio ? 0 : 8);
        this.f39748l.findViewById(C13495R.C13499id.text_view_rotate).setVisibility(i != C13495R.C13499id.state_rotate ? 8 : 0);
    }

    /* renamed from: D */
    public void m13140D() {
        this.f39756t.setClickable(true);
        this.f39737a.m13053b(true);
        this.f39745i.m12964t(this.f39757u, this.f39758v, new C13520h());
    }

    /* renamed from: H */
    protected C13521i m13139H(Throwable th) {
        return new C13521i(96, new Intent().putExtra(UCrop.f39790n, th));
    }

    /* renamed from: N */
    protected C13521i m13138N(Uri uri, float f, int i, int i2, int i3, int i4) {
        return new C13521i(-1, new Intent().putExtra(UCrop.f39784h, uri).putExtra(UCrop.f39785i, f).putExtra(UCrop.f39786j, i3).putExtra(UCrop.f39787k, i4).putExtra(UCrop.f39788l, i).putExtra(UCrop.f39789m, i2));
    }

    /* renamed from: V */
    public void m13130V(UCropFragmentCallback uCropFragmentCallback) {
        this.f39737a = uCropFragmentCallback;
    }

    /* renamed from: e0 */
    public void m13117e0(View view, Bundle bundle) {
        this.f39739c = bundle.getInt(UCrop.C13523a.f39820t, ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_widget_background));
        this.f39738b = bundle.getInt(UCrop.C13523a.f39820t, ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_widget_active));
        this.f39741e = bundle.getInt(UCrop.C13523a.f39826z, ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_default_logo));
        this.f39742f = !bundle.getBoolean(UCrop.C13523a.f39797A, false);
        this.f39740d = bundle.getInt(UCrop.C13523a.f39801E, ContextCompat.getColor(getContext(), C13495R.C13497color.ucrop_color_crop_background));
        m13137O(view);
        this.f39737a.m13053b(true);
        if (this.f39742f) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(C13495R.C13499id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.f39740d);
            LayoutInflater.from(getContext()).inflate(C13495R.C13501layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.f39743g = autoTransition;
            autoTransition.setDuration(f39732G);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(C13495R.C13499id.state_aspect_ratio);
            this.f39747k = viewGroup2;
            viewGroup2.setOnClickListener(this.f39761y);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(C13495R.C13499id.state_rotate);
            this.f39748l = viewGroup3;
            viewGroup3.setOnClickListener(this.f39761y);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(C13495R.C13499id.state_scale);
            this.f39749m = viewGroup4;
            viewGroup4.setOnClickListener(this.f39761y);
            this.f39750n = (ViewGroup) view.findViewById(C13495R.C13499id.layout_aspect_ratio);
            this.f39751o = (ViewGroup) view.findViewById(C13495R.C13499id.layout_rotate_wheel);
            this.f39752p = (ViewGroup) view.findViewById(C13495R.C13499id.layout_scale_wheel);
            m13125a0(bundle, view);
            m13123b0(view);
            m13121c0(view);
            m13119d0(view);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof UCropFragmentCallback) {
            this.f39737a = (UCropFragmentCallback) getParentFragment();
        } else if (context instanceof UCropFragmentCallback) {
            this.f39737a = (UCropFragmentCallback) context;
        } else {
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C13495R.C13501layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        m13117e0(inflate, arguments);
        m13129W(arguments);
        m13128X();
        m13110l(inflate);
        return inflate;
    }
}
