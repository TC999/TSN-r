package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.C3025R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p066d.BaseManager;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3138av;
import com.beizi.fusion.p072g.ComplaintViewUtil;
import com.beizi.fusion.p072g.ImageUtil;
import com.beizi.fusion.p072g.ShapeUtil;
import com.beizi.fusion.widget.CustomRoundImageView;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;

/* renamed from: com.beizi.fusion.work.nativead.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiNativeLTRPWorker extends BaseBeiZiNativeWorker {

    /* renamed from: R */
    private RelativeLayout f12331R;

    /* renamed from: S */
    private TextView f12332S;

    /* renamed from: T */
    private TextView f12333T;

    /* renamed from: U */
    private TextView f12334U;

    /* renamed from: V */
    private ImageView f12335V;

    /* renamed from: W */
    private ImageView f12336W;

    /* renamed from: X */
    private CustomRoundImageView f12337X;

    public BeiZiNativeLTRPWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        super(context, str, j, j2, buyerBean, forwardBean, baseManager, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m46935aN() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.f12297N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                ComplaintViewUtil complaintViewUtil = new ComplaintViewUtil();
                complaintViewUtil.m48231a(((BaseBeiZiNativeWorker) this).f12301n, ((BaseBeiZiNativeWorker) this).f12307t, "3");
                complaintViewUtil.m48229a(new ComplaintViewUtil.InterfaceC3161a() { // from class: com.beizi.fusion.work.nativead.c.1
                    @Override // com.beizi.fusion.p072g.ComplaintViewUtil.InterfaceC3161a
                    /* renamed from: a */
                    public void mo46797a(String str) {
                        try {
                            BeiZiNativeLTRPWorker beiZiNativeLTRPWorker = BeiZiNativeLTRPWorker.this;
                            C3137at.m48315a(((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker).f12301n, beiZiNativeLTRPWorker.f12298O, Long.valueOf(System.currentTimeMillis()));
                            ((AdWorker) BeiZiNativeLTRPWorker.this).f11795b.m48930S(str);
                            BeiZiNativeLTRPWorker.this.m47929au();
                            BeiZiNativeLTRPWorker.this.m47986I();
                            BeiZiNativeLTRPWorker.this.m46934aO();
                            if (((AdWorker) BeiZiNativeLTRPWorker.this).f11797d != null && ((AdWorker) BeiZiNativeLTRPWorker.this).f11797d.m48668s() != 2) {
                                ((AdWorker) BeiZiNativeLTRPWorker.this).f11797d.m48709b(BeiZiNativeLTRPWorker.this.mo46059g(), ((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12308u);
                            }
                            BeiZiNativeLTRPWorker.this.m47988G();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aO */
    public void m46934aO() {
        try {
            LinearLayout linearLayout = new LinearLayout(((BaseBeiZiNativeWorker) this).f12301n);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(((BaseBeiZiNativeWorker) this).f12301n);
            imageView.setImageResource(C3025R.C3027drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(((BaseBeiZiNativeWorker) this).f12301n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 0, 0, 0);
            linearLayout.addView(textView, layoutParams);
            ((BaseBeiZiNativeWorker) this).f12308u.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(((BaseBeiZiNativeWorker) this).f12308u.getMeasuredWidth(), ((BaseBeiZiNativeWorker) this).f12308u.getMeasuredHeight());
            layoutParams2.gravity = 17;
            ((BaseBeiZiNativeWorker) this).f12307t.addView(linearLayout, layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aP */
    public void m46933aP() {
        View downloadTextView;
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse == null || nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(((BaseBeiZiNativeWorker) this).f12301n, this.f12294K)) == null) {
                return;
            }
            ((BaseBeiZiNativeWorker) this).f12307t.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((((BaseBeiZiNativeWorker) this).f12307t.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            ((BaseBeiZiNativeWorker) this).f12307t.addView(downloadTextView, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aQ */
    private void m46932aQ() {
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse == null) {
                return;
            }
            ImageManager.with(null).getBitmap(nativeAdResponse.getImageUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.c.2
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    BeiZiNativeLTRPWorker.this.m47961a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12301n == null) {
                                return;
                            }
                            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            double d = width;
                            Double.isNaN(d);
                            double d2 = height;
                            Double.isNaN(d2);
                            float f = (float) ((d * 1.0d) / d2);
                            BeiZiNativeLTRPWorker beiZiNativeLTRPWorker = BeiZiNativeLTRPWorker.this;
                            double m48304a = C3138av.m48304a(((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker).f12301n, ((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker).f12305r);
                            Double.isNaN(m48304a);
                            int i = (int) (m48304a * 0.285d);
                            BeiZiNativeLTRPWorker beiZiNativeLTRPWorker2 = BeiZiNativeLTRPWorker.this;
                            float f2 = ((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker2).f12306s;
                            int m48304a2 = f2 > 0.0f ? C3138av.m48304a(((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker2).f12301n, f2) - C3138av.m48304a(((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12301n, 20.0f) : (int) (i / f);
                            if (BeiZiNativeLTRPWorker.this.f12337X != null && (layoutParams = BeiZiNativeLTRPWorker.this.f12337X.getLayoutParams()) != null) {
                                layoutParams.width = i;
                                layoutParams.height = m48304a2;
                                BeiZiNativeLTRPWorker.this.f12337X.setLayoutParams(layoutParams);
                            }
                            if (BeiZiNativeLTRPWorker.this.f12337X != null) {
                                BeiZiNativeLTRPWorker.this.f12337X.setRectRadius(C3138av.m48304a(((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12301n, 8.0f));
                                BeiZiNativeLTRPWorker.this.f12337X.setBackground(new BitmapDrawable(ImageUtil.m48505a(((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12301n, bitmap, 20.0f)));
                                BeiZiNativeLTRPWorker.this.f12337X.setImageBitmap(bitmap);
                            }
                            BeiZiNativeLTRPWorker beiZiNativeLTRPWorker3 = BeiZiNativeLTRPWorker.this;
                            beiZiNativeLTRPWorker3.m46982a(beiZiNativeLTRPWorker3.f12337X);
                            BeiZiNativeLTRPWorker.this.m46935aN();
                            BeiZiNativeLTRPWorker.this.m46933aP();
                            BeiZiNativeLTRPWorker.this.m46931aR();
                            BeiZiNativeLTRPWorker.this.m46972aG();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aR */
    public void m46931aR() {
        try {
            if (this.f12294K == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((BaseBeiZiNativeWorker) this).f12301n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(((BaseBeiZiNativeWorker) this).f12301n, this.f12294K.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(((BaseBeiZiNativeWorker) this).f12301n, this.f12294K.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            ((BaseBeiZiNativeWorker) this).f12307t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, 0, 15, 15);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.nativead.BaseBeiZiNativeWorker
    /* renamed from: b */
    public void mo46911b() {
        try {
            if (this.f12294K == null) {
                m47921c(-991);
                return;
            }
            View inflate = LayoutInflater.from(((BaseBeiZiNativeWorker) this).f12301n).inflate(C3025R.C3029layout.beizi_layout_native_left_text_right_picture_view, (ViewGroup) null);
            this.f12296M = inflate;
            this.f12331R = (RelativeLayout) inflate.findViewById(C3025R.C3028id.native_ad_ltrg_content_rl);
            LinearLayout linearLayout = (LinearLayout) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_title_ll);
            this.f12332S = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_title_tv);
            RelativeLayout relativeLayout = (RelativeLayout) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_subtitle_rl);
            this.f12333T = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_subtitle_tv);
            this.f12334U = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_go_tv);
            this.f12335V = (ImageView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_go_iv);
            this.f12337X = (CustomRoundImageView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_image_iv);
            this.f12336W = (ImageView) this.f12296M.findViewById(C3025R.C3028id.native_ad_ltrg_ad_text_iv);
            RelativeLayout relativeLayout2 = this.f12331R;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 10.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 10.0f), 0);
            }
            if (linearLayout != null) {
                linearLayout.setPadding(C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 20.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 8.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 11.0f), 0);
            }
            String headline = this.f12294K.getHeadline();
            if (this.f12332S != null && !TextUtils.isEmpty(headline)) {
                this.f12332S.setText(headline);
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 5.0f), 0, 0);
            }
            String body = this.f12294K.getBody();
            if (this.f12333T != null && !TextUtils.isEmpty(body)) {
                this.f12333T.setText(body);
            }
            ImageView imageView = this.f12336W;
            if (imageView != null) {
                imageView.setPadding(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 10.0f), 0, 0);
            }
            TextView textView = this.f12334U;
            if (textView != null) {
                ShapeUtil.m48318a(textView, "#71A0FF", 0, null, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 10.0f));
            }
            m46981a(this.f12334U, this.f12335V);
            m46932aQ();
            m46971aH();
            m46970aI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.nativead.BaseBeiZiNativeWorker
    /* renamed from: a */
    public void mo46919a(final NativeAdResponse nativeAdResponse) {
        try {
            ImageView imageView = new ImageView(((BaseBeiZiNativeWorker) this).f12301n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(65, 65);
            imageView.setPadding(15, 8, 8, 15);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(C3025R.C3027drawable.beizi_close);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(65, 65);
            layoutParams2.gravity = 5;
            ((BaseBeiZiNativeWorker) this).f12307t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.nativead.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12289F = motionEvent.getX();
                        ((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12290G = motionEvent.getY();
                        ((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12291H = motionEvent.getRawX();
                        BeiZiNativeLTRPWorker.this.f12292I = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiNativeLTRPWorker.this.m46968aK()) {
                            if (BeiZiNativeLTRPWorker.this.m46967aL()) {
                                BeiZiNativeLTRPWorker beiZiNativeLTRPWorker = BeiZiNativeLTRPWorker.this;
                                C3137at.m48315a(((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker).f12301n, beiZiNativeLTRPWorker.f12293J, Long.valueOf(System.currentTimeMillis()));
                                NativeAdResponse nativeAdResponse2 = nativeAdResponse;
                                BeiZiNativeLTRPWorker beiZiNativeLTRPWorker2 = BeiZiNativeLTRPWorker.this;
                                NativeAdUtil.handleClick(nativeAdResponse2, ((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker2).f12308u, String.valueOf(((BaseBeiZiNativeWorker) beiZiNativeLTRPWorker2).f12289F), String.valueOf(((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12290G), String.valueOf(((BaseBeiZiNativeWorker) BeiZiNativeLTRPWorker.this).f12291H), String.valueOf(BeiZiNativeLTRPWorker.this.f12292I), 0);
                            } else {
                                BeiZiNativeLTRPWorker.this.m46966aM();
                            }
                        } else {
                            BeiZiNativeLTRPWorker.this.m46966aM();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
