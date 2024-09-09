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
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.internal.nativead.NativeAdUtil;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.fusion.R;
import com.beizi.fusion.g.ac;
import com.beizi.fusion.g.as;
import com.beizi.fusion.g.at;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.p;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.CustomRoundImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BeiZiNativeLTRPWorker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c extends b {
    private RelativeLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    private ImageView V;
    private ImageView W;
    private CustomRoundImageView X;

    public c(Context context, String str, long j4, long j5, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.d.e eVar, float f4, float f5) {
        super(context, str, j4, j5, buyerBean, forwardBean, eVar, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                p pVar = new p();
                pVar.a(((b) this).f15793n, ((b) this).f15799t, "3");
                pVar.a(new p.a() { // from class: com.beizi.fusion.work.nativead.c.1
                    @Override // com.beizi.fusion.g.p.a
                    public void a(String str) {
                        try {
                            c cVar = c.this;
                            at.a(((b) cVar).f15793n, cVar.O, Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) c.this).f15365b.S(str);
                            c.this.au();
                            c.this.I();
                            c.this.aO();
                            if (((com.beizi.fusion.work.a) c.this).f15367d != null && ((com.beizi.fusion.work.a) c.this).f15367d.s() != 2) {
                                ((com.beizi.fusion.work.a) c.this).f15367d.b(c.this.g(), ((b) c.this).f15800u);
                            }
                            c.this.G();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        try {
            LinearLayout linearLayout = new LinearLayout(((b) this).f15793n);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(((b) this).f15793n);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(((b) this).f15793n);
            textView.setText("\u6295\u8bc9\u6210\u529f\uff0c\u6211\u4eec\u5c06\u91cd\u89c6\u60a8\u7684\u53cd\u9988\u3002");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 0, 0, 0);
            linearLayout.addView(textView, layoutParams);
            ((b) this).f15800u.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(((b) this).f15800u.getMeasuredWidth(), ((b) this).f15800u.getMeasuredHeight());
            layoutParams2.gravity = 17;
            ((b) this).f15799t.addView(linearLayout, layoutParams2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP() {
        View downloadTextView;
        try {
            NativeAdResponse nativeAdResponse = this.K;
            if (nativeAdResponse == null || nativeAdResponse.getApkInfo() == null || (downloadTextView = NativeAdUtil.getDownloadTextView(((b) this).f15793n, this.K)) == null) {
                return;
            }
            ((b) this).f15799t.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((((b) this).f15799t.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            ((b) this).f15799t.addView(downloadTextView, layoutParams);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void aQ() {
        try {
            NativeAdResponse nativeAdResponse = this.K;
            if (nativeAdResponse == null) {
                return;
            }
            ImageManager.with(null).getBitmap(nativeAdResponse.getImageUrl(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.fusion.work.nativead.c.2
                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoadFailed() {
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
                    c.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }

                @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                public void onBitmapLoaded(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((b) c.this).f15793n == null) {
                                return;
                            }
                            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            double d4 = width;
                            Double.isNaN(d4);
                            double d5 = height;
                            Double.isNaN(d5);
                            float f4 = (float) ((d4 * 1.0d) / d5);
                            c cVar = c.this;
                            double a4 = av.a(((b) cVar).f15793n, ((b) cVar).f15797r);
                            Double.isNaN(a4);
                            int i4 = (int) (a4 * 0.285d);
                            c cVar2 = c.this;
                            float f5 = ((b) cVar2).f15798s;
                            int a5 = f5 > 0.0f ? av.a(((b) cVar2).f15793n, f5) - av.a(((b) c.this).f15793n, 20.0f) : (int) (i4 / f4);
                            if (c.this.X != null && (layoutParams = c.this.X.getLayoutParams()) != null) {
                                layoutParams.width = i4;
                                layoutParams.height = a5;
                                c.this.X.setLayoutParams(layoutParams);
                            }
                            if (c.this.X != null) {
                                c.this.X.setRectRadius(av.a(((b) c.this).f15793n, 8.0f));
                                c.this.X.setBackground(new BitmapDrawable(ac.a(((b) c.this).f15793n, bitmap, 20.0f)));
                                c.this.X.setImageBitmap(bitmap);
                            }
                            c cVar3 = c.this;
                            cVar3.a(cVar3.X);
                            c.this.aN();
                            c.this.aP();
                            c.this.aR();
                            c.this.aG();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR() {
        try {
            if (this.K == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((b) this).f15793n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout createLogoImageView = ViewUtil.createLogoImageView(((b) this).f15793n, this.K.getlogoUrl());
            createLogoImageView.setVisibility(0);
            linearLayout.addView(createLogoImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            FrameLayout createAdImageView = ViewUtil.createAdImageView(((b) this).f15793n, this.K.getAdUrl());
            createAdImageView.setVisibility(0);
            linearLayout.addView(createAdImageView, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createAdImageView.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            createAdImageView.setLayoutParams(layoutParams);
            ((b) this).f15799t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, 0, 15, 15);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.nativead.b
    public void b() {
        try {
            if (this.K == null) {
                c(-991);
                return;
            }
            View inflate = LayoutInflater.from(((b) this).f15793n).inflate(R.layout.beizi_layout_native_left_text_right_picture_view, (ViewGroup) null);
            this.M = inflate;
            this.R = (RelativeLayout) inflate.findViewById(R.id.native_ad_ltrg_content_rl);
            LinearLayout linearLayout = (LinearLayout) this.M.findViewById(R.id.native_ad_ltrg_title_ll);
            this.S = (TextView) this.M.findViewById(R.id.native_ad_ltrg_title_tv);
            RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.native_ad_ltrg_subtitle_rl);
            this.T = (TextView) this.M.findViewById(R.id.native_ad_ltrg_subtitle_tv);
            this.U = (TextView) this.M.findViewById(R.id.native_ad_ltrg_go_tv);
            this.V = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_go_iv);
            this.X = (CustomRoundImageView) this.M.findViewById(R.id.native_ad_ltrg_image_iv);
            this.W = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_ad_text_iv);
            RelativeLayout relativeLayout2 = this.R;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(0, av.a(((b) this).f15793n, 10.0f), av.a(((b) this).f15793n, 10.0f), 0);
            }
            if (linearLayout != null) {
                linearLayout.setPadding(av.a(((b) this).f15793n, 20.0f), av.a(((b) this).f15793n, 8.0f), av.a(((b) this).f15793n, 11.0f), 0);
            }
            String headline = this.K.getHeadline();
            if (this.S != null && !TextUtils.isEmpty(headline)) {
                this.S.setText(headline);
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, av.a(((b) this).f15793n, 5.0f), 0, 0);
            }
            String body = this.K.getBody();
            if (this.T != null && !TextUtils.isEmpty(body)) {
                this.T.setText(body);
            }
            ImageView imageView = this.W;
            if (imageView != null) {
                imageView.setPadding(0, av.a(((b) this).f15793n, 10.0f), 0, 0);
            }
            TextView textView = this.U;
            if (textView != null) {
                as.a(textView, "#71A0FF", 0, (String) null, av.a(((b) this).f15793n, 10.0f));
            }
            a(this.U, this.V);
            aQ();
            aH();
            aI();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.nativead.b
    public void a(final NativeAdResponse nativeAdResponse) {
        try {
            ImageView imageView = new ImageView(((b) this).f15793n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(65, 65);
            imageView.setPadding(15, 8, 8, 15);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(65, 65);
            layoutParams2.gravity = 5;
            ((b) this).f15799t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.nativead.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ((b) c.this).F = motionEvent.getX();
                        ((b) c.this).G = motionEvent.getY();
                        ((b) c.this).H = motionEvent.getRawX();
                        c.this.I = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.nativead.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (c.this.aK()) {
                            if (c.this.aL()) {
                                c cVar = c.this;
                                at.a(((b) cVar).f15793n, cVar.J, Long.valueOf(System.currentTimeMillis()));
                                NativeAdResponse nativeAdResponse2 = nativeAdResponse;
                                c cVar2 = c.this;
                                NativeAdUtil.handleClick(nativeAdResponse2, ((b) cVar2).f15800u, String.valueOf(((b) cVar2).F), String.valueOf(((b) c.this).G), String.valueOf(((b) c.this).H), String.valueOf(c.this.I), 0);
                            } else {
                                c.this.aM();
                            }
                        } else {
                            c.this.aM();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
