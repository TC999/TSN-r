package com.mbridge.msdk.widget.custom.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.custom.CustomViewMessageWrap;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.custom.a;
import com.mbridge.msdk.widget.custom.b.e;
import com.mbridge.msdk.widget.custom.baseview.MBButton;
import com.mbridge.msdk.widget.custom.baseview.MBImageView;
import com.mbridge.msdk.widget.custom.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.widget.custom.baseview.MBTextView;

/* compiled from: RenderEngine.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private CustomViewMessageWrap f41153a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.widget.custom.a f41154b;

    /* renamed from: c  reason: collision with root package name */
    private DownloadMessageDialog f41155c;

    /* renamed from: d  reason: collision with root package name */
    private int f41156d;

    /* renamed from: e  reason: collision with root package name */
    private int f41157e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f41158f;

    /* renamed from: g  reason: collision with root package name */
    private MBImageView f41159g;

    /* renamed from: h  reason: collision with root package name */
    private MBButton f41160h;

    /* renamed from: i  reason: collision with root package name */
    private MBImageView f41161i;

    public d(CustomViewMessageWrap customViewMessageWrap, com.mbridge.msdk.widget.custom.a aVar, DownloadMessageDialog downloadMessageDialog, int i4, int i5) {
        this.f41153a = customViewMessageWrap;
        this.f41154b = aVar;
        this.f41155c = downloadMessageDialog;
        this.f41156d = i4;
        this.f41157e = i5;
    }

    public final void a(ViewGroup viewGroup) {
        if ((viewGroup instanceof MBStarLevelLayoutView) && viewGroup.getContentDescription().equals("getStarCount")) {
            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) viewGroup;
            CustomViewMessageWrap customViewMessageWrap = this.f41153a;
            mBStarLevelLayoutView.setRating(Math.min(Math.max(customViewMessageWrap != null ? customViewMessageWrap.getStarCount() : 0, 0), 5));
        }
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            final View childAt = viewGroup.getChildAt(i4);
            if (!TextUtils.isEmpty(childAt.getContentDescription())) {
                String str = (String) childAt.getContentDescription();
                String[] split = str.split("#");
                if (split.length > 1) {
                    String str2 = split[0];
                    String str3 = split[1];
                    if (e.a(str3)) {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt == 1) {
                            childAt.setVisibility(TextUtils.isEmpty(CustomViewMessageWrap.getMessage(this.f41153a, str2)) ? 8 : 0);
                        } else if (parseInt == 2) {
                            try {
                                final View childAt2 = viewGroup.getChildAt(i4 + 1);
                                final ImageView imageView = null;
                                ViewGroup viewGroup2 = (ViewGroup) childAt;
                                for (int i5 = 0; i5 < viewGroup2.getChildCount(); i5++) {
                                    if (viewGroup2.getChildAt(i5) instanceof ImageView) {
                                        imageView = (ImageView) viewGroup2.getChildAt(i5);
                                    }
                                }
                                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        View view2 = childAt2;
                                        view2.setVisibility(view2.getVisibility() == 0 ? 8 : 0);
                                        imageView.setImageResource(r.a(d.this.f41158f.getContext(), childAt2.getVisibility() == 0 ? "mbridge_download_message_dialog_hide" : "mbridge_download_message_dialog_expand", "drawable"));
                                    }
                                });
                            } catch (Exception e4) {
                                if (MBridgeConstans.DEBUG) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                }
                if (str.equals("close")) {
                    childAt.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.this.f41153a.putView("image_close", d.this.f41161i);
                            d.this.f41154b.a(d.this.f41155c, d.this.f41153a, a.EnumC0769a.CLICK_EVENT_CLOSE);
                        }
                    });
                }
                if (str.startsWith("getApplicationPrivacy")) {
                    childAt.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            try {
                                View childAt3 = ((ViewGroup) childAt).getChildAt(1);
                                if (childAt3 != null) {
                                    childAt3.performClick();
                                }
                            } catch (Exception e5) {
                                x.a("render", e5.getMessage());
                            }
                        }
                    });
                }
            }
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
            } else if (childAt instanceof MBTextView) {
                MBTextView mBTextView = (MBTextView) childAt;
                String message = CustomViewMessageWrap.getMessage(this.f41153a, String.valueOf(mBTextView.getContentDescription()));
                if (TextUtils.isEmpty(mBTextView.getText()) && !TextUtils.isEmpty(message)) {
                    mBTextView.setText(message);
                }
            } else if (childAt instanceof MBImageView) {
                final MBImageView mBImageView = (MBImageView) childAt;
                if (!TextUtils.isEmpty(mBImageView.getContentDescription())) {
                    if (mBImageView.getContentDescription().equals("imgbg")) {
                        this.f41159g = mBImageView;
                        if (!TextUtils.isEmpty(CustomViewMessageWrap.getMessage(this.f41153a, "getApplicationImage"))) {
                            int c4 = mBImageView.getResources().getDisplayMetrics().widthPixels - b.a().c("20dp");
                            ViewGroup.LayoutParams layoutParams = mBImageView.getLayoutParams();
                            layoutParams.width = c4;
                            layoutParams.height = (int) (c4 * 0.5225f);
                            mBImageView.setLayoutParams(layoutParams);
                        }
                    } else if (mBImageView.getContentDescription().equals("getApplicationImage")) {
                        String message2 = CustomViewMessageWrap.getMessage(this.f41153a, String.valueOf(mBImageView.getContentDescription()));
                        if (!TextUtils.isEmpty(mBImageView.getContentDescription()) && TextUtils.isEmpty(message2)) {
                            mBImageView.setVisibility(8);
                            MBImageView mBImageView2 = this.f41159g;
                            if (mBImageView2 != null) {
                                mBImageView2.setVisibility(8);
                            }
                        } else {
                            com.mbridge.msdk.widget.custom.b.b.a(mBImageView, this.f41159g, message2, this.f41156d, this.f41157e, this.f41155c);
                        }
                    } else if (mBImageView.getContentDescription().equals("getApplicationLogo")) {
                        String message3 = CustomViewMessageWrap.getMessage(this.f41153a, String.valueOf(mBImageView.getContentDescription()));
                        if (!TextUtils.isEmpty(message3)) {
                            com.mbridge.msdk.widget.custom.b.b.a(mBImageView, message3);
                        } else {
                            mBImageView.setBackgroundColor(Color.parseColor("#e6e6e6"));
                        }
                    } else if (mBImageView.getContentDescription().equals("close")) {
                        this.f41161i = mBImageView;
                        mBImageView.setImageResource(r.a(mBImageView.getContext(), "mbridge_download_message_dialog_close", "drawable"));
                    } else if (mBImageView.getContentDescription().equals("permissionexpand")) {
                        mBImageView.setImageResource(r.a(mBImageView.getContext(), "mbridge_download_message_dialog_expand", "drawable"));
                        this.f41158f = mBImageView;
                    } else if (mBImageView.getContentDescription().equals("getApplicationPrivacy")) {
                        mBImageView.setImageResource(r.a(mBImageView.getContext(), "mbridge_download_message_dialog_expand", "drawable"));
                        mBImageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                if (d.this.f41153a != null) {
                                    d.this.f41153a.putView("image_privacy", mBImageView);
                                }
                                d.this.f41154b.a(d.this.f41155c, d.this.f41153a, a.EnumC0769a.CLICK_EVENT_OPEN_PRIVACY);
                            }
                        });
                    }
                }
            } else if (childAt instanceof MBButton) {
                final MBButton mBButton = (MBButton) childAt;
                mBButton.setIndeterminateProgressMode(true);
                mBButton.setBackgroundResource(r.a(mBButton.getContext(), "mbridge_download_message_dialog_button_shape", "drawable"));
                if (!TextUtils.isEmpty(mBButton.getContentDescription()) && String.valueOf(mBButton.getContentDescription()).startsWith("download")) {
                    this.f41160h = mBButton;
                    mBButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (d.this.f41153a != null) {
                                d.this.f41153a.putView("button_download", mBButton);
                            }
                            d.this.f41154b.a(d.this.f41155c, d.this.f41153a, a.EnumC0769a.CLICK_EVENT_DOWNLOAD);
                        }
                    });
                }
            }
        }
    }

    public final MBButton a() {
        return this.f41160h;
    }
}
