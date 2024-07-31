package com.beizi.fusion.work.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
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
import com.beizi.fusion.widget.CustomRoundImageView;
import com.beizi.fusion.work.AdWorker;
import com.beizi.p051ad.NativeAdResponse;
import com.beizi.p051ad.internal.nativead.NativeAdUtil;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;

/* renamed from: com.beizi.fusion.work.nativead.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiNativeTPBTWorker extends BaseBeiZiNativeWorker {

    /* renamed from: R */
    private LinearLayout f12343R;

    /* renamed from: S */
    private LinearLayout f12344S;

    /* renamed from: T */
    private FrameLayout f12345T;

    /* renamed from: U */
    private CustomRoundImageView f12346U;

    /* renamed from: V */
    private TextView f12347V;

    /* renamed from: W */
    private TextView f12348W;

    /* renamed from: X */
    private TextView f12349X;

    /* renamed from: Y */
    private ImageView f12350Y;

    public BeiZiNativeTPBTWorker(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, BaseManager baseManager, float f, float f2) {
        super(context, str, j, j2, buyerBean, forwardBean, baseManager, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aN */
    public void m46916aN() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.f12297N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                ComplaintViewUtil complaintViewUtil = new ComplaintViewUtil();
                complaintViewUtil.m48231a(((BaseBeiZiNativeWorker) this).f12301n, ((BaseBeiZiNativeWorker) this).f12307t, "2");
                complaintViewUtil.m48229a(new ComplaintViewUtil.InterfaceC3161a() { // from class: com.beizi.fusion.work.nativead.d.1
                    @Override // com.beizi.fusion.p072g.ComplaintViewUtil.InterfaceC3161a
                    /* renamed from: a */
                    public void mo46797a(String str) {
                        try {
                            BeiZiNativeTPBTWorker beiZiNativeTPBTWorker = BeiZiNativeTPBTWorker.this;
                            C3137at.m48315a(((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker).f12301n, beiZiNativeTPBTWorker.f12298O, Long.valueOf(System.currentTimeMillis()));
                            ((AdWorker) BeiZiNativeTPBTWorker.this).f11795b.m48930S(str);
                            BeiZiNativeTPBTWorker.this.m47929au();
                            BeiZiNativeTPBTWorker.this.m47986I();
                            BeiZiNativeTPBTWorker.this.m46915aO();
                            if (((AdWorker) BeiZiNativeTPBTWorker.this).f11797d != null && ((AdWorker) BeiZiNativeTPBTWorker.this).f11797d.m48668s() != 2) {
                                ((AdWorker) BeiZiNativeTPBTWorker.this).f11797d.m48709b(BeiZiNativeTPBTWorker.this.mo46059g(), ((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12308u);
                            }
                            BeiZiNativeTPBTWorker.this.m47988G();
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
    public void m46915aO() {
        try {
            LinearLayout linearLayout = new LinearLayout(((BaseBeiZiNativeWorker) this).f12301n);
            linearLayout.setOrientation(1);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
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
    public void m46914aP() {
        View downloadTextView;
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse == null || nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(((BaseBeiZiNativeWorker) this).f12301n, this.f12294K)) == null) {
                return;
            }
            this.f12345T.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f12345T.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.f12345T.addView(downloadTextView, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aQ */
    private void m46913aQ() {
        try {
            NativeAdResponse nativeAdResponse = this.f12294K;
            if (nativeAdResponse == null) {
                return;
            }
            ImageManager.with(null).getBitmap(nativeAdResponse.getImageUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.d.2
                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
                    BeiZiNativeTPBTWorker.this.m47961a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12301n == null) {
                                return;
                            }
                            Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            double d = width;
                            Double.isNaN(d);
                            double d2 = height;
                            Double.isNaN(d2);
                            float f = (float) ((d * 1.0d) / d2);
                            BeiZiNativeTPBTWorker beiZiNativeTPBTWorker = BeiZiNativeTPBTWorker.this;
                            int m48304a = C3138av.m48304a(((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker).f12301n, ((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker).f12305r - 16.0f);
                            int i = (int) (m48304a / f);
                            BeiZiNativeTPBTWorker beiZiNativeTPBTWorker2 = BeiZiNativeTPBTWorker.this;
                            if (((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker2).f12306s > 0.0f) {
                                int i2 = 0;
                                if (beiZiNativeTPBTWorker2.f12344S != null) {
                                    BeiZiNativeTPBTWorker.this.f12344S.measure(0, 0);
                                    i2 = BeiZiNativeTPBTWorker.this.f12344S.getMeasuredHeight();
                                }
                                BeiZiNativeTPBTWorker beiZiNativeTPBTWorker3 = BeiZiNativeTPBTWorker.this;
                                int m48304a2 = C3138av.m48304a(((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker3).f12301n, ((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker3).f12306s - 16.0f);
                                if (m48304a2 > i2) {
                                    i = m48304a2 - i2;
                                }
                            }
                            if (BeiZiNativeTPBTWorker.this.f12346U != null && (layoutParams = BeiZiNativeTPBTWorker.this.f12346U.getLayoutParams()) != null) {
                                layoutParams.width = m48304a;
                                layoutParams.height = i;
                                BeiZiNativeTPBTWorker.this.f12346U.setLayoutParams(layoutParams);
                            }
                            if (BeiZiNativeTPBTWorker.this.f12346U != null) {
                                BeiZiNativeTPBTWorker.this.f12346U.setRectRadius(C3138av.m48304a(((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12301n, 4.0f));
                                BeiZiNativeTPBTWorker.this.f12346U.setBackground(new BitmapDrawable(ImageUtil.m48505a(((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12301n, bitmap, 20.0f)));
                                BeiZiNativeTPBTWorker.this.f12346U.setImageBitmap(bitmap);
                            }
                            BeiZiNativeTPBTWorker beiZiNativeTPBTWorker4 = BeiZiNativeTPBTWorker.this;
                            beiZiNativeTPBTWorker4.m46982a(beiZiNativeTPBTWorker4.f12346U);
                            BeiZiNativeTPBTWorker.this.m46916aN();
                            BeiZiNativeTPBTWorker.this.m46914aP();
                            BeiZiNativeTPBTWorker.this.m46912aR();
                            BeiZiNativeTPBTWorker.this.m46972aG();
                        } catch (Exception e) {
                            e.printStackTrace();
                            BeiZiNativeTPBTWorker.this.m47961a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
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
    public void m46912aR() {
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
            ((BaseBeiZiNativeWorker) this).f12307t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 53));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            if (m46969aJ()) {
                layoutParams2.setMargins(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 16.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 40.0f), 0);
            } else {
                layoutParams2.setMargins(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 16.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 16.0f), 0);
            }
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.nativead.BaseBeiZiNativeWorker
    /* renamed from: a */
    public void mo46919a(final NativeAdResponse nativeAdResponse) {
        try {
            ImageView imageView = new ImageView(((BaseBeiZiNativeWorker) this).f12301n);
            int m48304a = C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 24.0f) + 42;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m48304a, m48304a);
            int m48304a2 = C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 16.0f);
            int m48304a3 = C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 8.0f);
            imageView.setPadding(m48304a3, m48304a2, m48304a2, m48304a3);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(C3025R.C3027drawable.beizi_close_two);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(m48304a, m48304a);
            layoutParams2.gravity = 5;
            ((BaseBeiZiNativeWorker) this).f12307t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.nativead.d.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12289F = motionEvent.getX();
                        ((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12290G = motionEvent.getY();
                        ((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12291H = motionEvent.getRawX();
                        BeiZiNativeTPBTWorker.this.f12292I = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiNativeTPBTWorker.this.m46968aK()) {
                            if (BeiZiNativeTPBTWorker.this.m46967aL()) {
                                BeiZiNativeTPBTWorker beiZiNativeTPBTWorker = BeiZiNativeTPBTWorker.this;
                                C3137at.m48315a(((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker).f12301n, beiZiNativeTPBTWorker.f12293J, Long.valueOf(System.currentTimeMillis()));
                                NativeAdResponse nativeAdResponse2 = nativeAdResponse;
                                BeiZiNativeTPBTWorker beiZiNativeTPBTWorker2 = BeiZiNativeTPBTWorker.this;
                                NativeAdUtil.handleClick(nativeAdResponse2, ((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker2).f12308u, String.valueOf(((BaseBeiZiNativeWorker) beiZiNativeTPBTWorker2).f12289F), String.valueOf(((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12290G), String.valueOf(((BaseBeiZiNativeWorker) BeiZiNativeTPBTWorker.this).f12291H), String.valueOf(BeiZiNativeTPBTWorker.this.f12292I), 0);
                            } else {
                                BeiZiNativeTPBTWorker.this.m46966aM();
                            }
                        } else {
                            BeiZiNativeTPBTWorker.this.m46966aM();
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

    @Override // com.beizi.fusion.work.nativead.BaseBeiZiNativeWorker
    /* renamed from: b */
    public void mo46911b() {
        TextView textView;
        try {
            if (this.f12294K == null) {
                m47921c(-991);
                return;
            }
            View inflate = LayoutInflater.from(((BaseBeiZiNativeWorker) this).f12301n).inflate(C3025R.C3029layout.beizi_layout_native_top_picture_bottom_text_view, (ViewGroup) null);
            this.f12296M = inflate;
            this.f12343R = (LinearLayout) inflate.findViewById(C3025R.C3028id.native_ad_tpbt_container_ll);
            this.f12345T = (FrameLayout) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_img_container_fl);
            this.f12346U = (CustomRoundImageView) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_image_iv);
            this.f12344S = (LinearLayout) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_content_ll);
            this.f12347V = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_title_tv);
            this.f12348W = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_subtitle_tv);
            this.f12349X = (TextView) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_go_tv);
            this.f12350Y = (ImageView) this.f12296M.findViewById(C3025R.C3028id.native_ad_tpbt_go_iv);
            int m48304a = C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, ((BaseBeiZiNativeWorker) this).f12305r);
            float f = ((BaseBeiZiNativeWorker) this).f12306s;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m48304a, f > 0.0f ? C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, f) : -2);
            int m48304a2 = C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 8.0f);
            LinearLayout linearLayout = this.f12343R;
            if (linearLayout != null) {
                linearLayout.setPadding(m48304a2, m48304a2, m48304a2, m48304a2);
                this.f12343R.setLayoutParams(layoutParams);
            }
            LinearLayout linearLayout2 = this.f12344S;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 8.0f), 0, C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 8.0f));
            }
            String headline = this.f12294K.getHeadline();
            if (this.f12347V != null && !TextUtils.isEmpty(headline)) {
                this.f12347V.setText(headline);
            }
            String body = this.f12294K.getBody();
            if (this.f12348W != null && !TextUtils.isEmpty(body)) {
                this.f12348W.setText(body);
            }
            if (Build.VERSION.SDK_INT >= 21 && (textView = this.f12349X) != null) {
                textView.setBackground(((BaseBeiZiNativeWorker) this).f12301n.getDrawable(C3025R.C3027drawable.beizi_bg_operate_button));
            }
            if (this.f12350Y != null) {
                this.f12350Y.setLayoutParams(new RelativeLayout.LayoutParams(C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 63.0f), C3138av.m48304a(((BaseBeiZiNativeWorker) this).f12301n, 24.0f)));
                this.f12350Y.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            m46981a(this.f12349X, this.f12350Y);
            m46913aQ();
            m46971aH();
            m46970aI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
