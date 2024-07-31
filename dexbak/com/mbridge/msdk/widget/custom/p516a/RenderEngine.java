package com.mbridge.msdk.widget.custom.p516a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ResourceUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.widget.custom.CustomViewMessageWrap;
import com.mbridge.msdk.widget.custom.CustomViewRenderListener;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.custom.baseview.MBButton;
import com.mbridge.msdk.widget.custom.baseview.MBImageView;
import com.mbridge.msdk.widget.custom.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.widget.custom.baseview.MBTextView;
import com.mbridge.msdk.widget.custom.p517b.FastBlurUtil;
import com.mbridge.msdk.widget.custom.p517b.XmlUtils;

/* renamed from: com.mbridge.msdk.widget.custom.a.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RenderEngine {

    /* renamed from: a */
    private CustomViewMessageWrap f32464a;

    /* renamed from: b */
    private CustomViewRenderListener f32465b;

    /* renamed from: c */
    private DownloadMessageDialog f32466c;

    /* renamed from: d */
    private int f32467d;

    /* renamed from: e */
    private int f32468e;

    /* renamed from: f */
    private ImageView f32469f;

    /* renamed from: g */
    private MBImageView f32470g;

    /* renamed from: h */
    private MBButton f32471h;

    /* renamed from: i */
    private MBImageView f32472i;

    public RenderEngine(CustomViewMessageWrap customViewMessageWrap, CustomViewRenderListener customViewRenderListener, DownloadMessageDialog downloadMessageDialog, int i, int i2) {
        this.f32464a = customViewMessageWrap;
        this.f32465b = customViewRenderListener;
        this.f32466c = downloadMessageDialog;
        this.f32467d = i;
        this.f32468e = i2;
    }

    /* renamed from: a */
    public final void m20588a(ViewGroup viewGroup) {
        if ((viewGroup instanceof MBStarLevelLayoutView) && viewGroup.getContentDescription().equals("getStarCount")) {
            MBStarLevelLayoutView mBStarLevelLayoutView = (MBStarLevelLayoutView) viewGroup;
            CustomViewMessageWrap customViewMessageWrap = this.f32464a;
            mBStarLevelLayoutView.setRating(Math.min(Math.max(customViewMessageWrap != null ? customViewMessageWrap.getStarCount() : 0, 0), 5));
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            final View childAt = viewGroup.getChildAt(i);
            if (!TextUtils.isEmpty(childAt.getContentDescription())) {
                String str = (String) childAt.getContentDescription();
                String[] split = str.split("#");
                if (split.length > 1) {
                    String str2 = split[0];
                    String str3 = split[1];
                    if (XmlUtils.m20565a(str3)) {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt == 1) {
                            childAt.setVisibility(TextUtils.isEmpty(CustomViewMessageWrap.getMessage(this.f32464a, str2)) ? 8 : 0);
                        } else if (parseInt == 2) {
                            try {
                                final View childAt2 = viewGroup.getChildAt(i + 1);
                                final ImageView imageView = null;
                                ViewGroup viewGroup2 = (ViewGroup) childAt;
                                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                                    if (viewGroup2.getChildAt(i2) instanceof ImageView) {
                                        imageView = (ImageView) viewGroup2.getChildAt(i2);
                                    }
                                }
                                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        View view2 = childAt2;
                                        view2.setVisibility(view2.getVisibility() == 0 ? 8 : 0);
                                        imageView.setImageResource(ResourceUtil.m21814a(RenderEngine.this.f32469f.getContext(), childAt2.getVisibility() == 0 ? "mbridge_download_message_dialog_hide" : "mbridge_download_message_dialog_expand", "drawable"));
                                    }
                                });
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                if (str.equals("close")) {
                    childAt.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RenderEngine.this.f32464a.putView("image_close", RenderEngine.this.f32472i);
                            RenderEngine.this.f32465b.mo20613a(RenderEngine.this.f32466c, RenderEngine.this.f32464a, CustomViewRenderListener.EnumC11739a.CLICK_EVENT_CLOSE);
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
                            } catch (Exception e2) {
                                SameLogTool.m21738a("render", e2.getMessage());
                            }
                        }
                    });
                }
            }
            if (childAt instanceof ViewGroup) {
                m20588a((ViewGroup) childAt);
            } else if (childAt instanceof MBTextView) {
                MBTextView mBTextView = (MBTextView) childAt;
                String message = CustomViewMessageWrap.getMessage(this.f32464a, String.valueOf(mBTextView.getContentDescription()));
                if (TextUtils.isEmpty(mBTextView.getText()) && !TextUtils.isEmpty(message)) {
                    mBTextView.setText(message);
                }
            } else if (childAt instanceof MBImageView) {
                final MBImageView mBImageView = (MBImageView) childAt;
                if (!TextUtils.isEmpty(mBImageView.getContentDescription())) {
                    if (mBImageView.getContentDescription().equals("imgbg")) {
                        this.f32470g = mBImageView;
                        if (!TextUtils.isEmpty(CustomViewMessageWrap.getMessage(this.f32464a, "getApplicationImage"))) {
                            int m20594c = mBImageView.getResources().getDisplayMetrics().widthPixels - MBResource.m20600a().m20594c("20dp");
                            ViewGroup.LayoutParams layoutParams = mBImageView.getLayoutParams();
                            layoutParams.width = m20594c;
                            layoutParams.height = (int) (m20594c * 0.5225f);
                            mBImageView.setLayoutParams(layoutParams);
                        }
                    } else if (mBImageView.getContentDescription().equals("getApplicationImage")) {
                        String message2 = CustomViewMessageWrap.getMessage(this.f32464a, String.valueOf(mBImageView.getContentDescription()));
                        if (!TextUtils.isEmpty(mBImageView.getContentDescription()) && TextUtils.isEmpty(message2)) {
                            mBImageView.setVisibility(8);
                            MBImageView mBImageView2 = this.f32470g;
                            if (mBImageView2 != null) {
                                mBImageView2.setVisibility(8);
                            }
                        } else {
                            FastBlurUtil.m20573a(mBImageView, this.f32470g, message2, this.f32467d, this.f32468e, this.f32466c);
                        }
                    } else if (mBImageView.getContentDescription().equals("getApplicationLogo")) {
                        String message3 = CustomViewMessageWrap.getMessage(this.f32464a, String.valueOf(mBImageView.getContentDescription()));
                        if (!TextUtils.isEmpty(message3)) {
                            FastBlurUtil.m20572a(mBImageView, message3);
                        } else {
                            mBImageView.setBackgroundColor(Color.parseColor("#e6e6e6"));
                        }
                    } else if (mBImageView.getContentDescription().equals("close")) {
                        this.f32472i = mBImageView;
                        mBImageView.setImageResource(ResourceUtil.m21814a(mBImageView.getContext(), "mbridge_download_message_dialog_close", "drawable"));
                    } else if (mBImageView.getContentDescription().equals("permissionexpand")) {
                        mBImageView.setImageResource(ResourceUtil.m21814a(mBImageView.getContext(), "mbridge_download_message_dialog_expand", "drawable"));
                        this.f32469f = mBImageView;
                    } else if (mBImageView.getContentDescription().equals("getApplicationPrivacy")) {
                        mBImageView.setImageResource(ResourceUtil.m21814a(mBImageView.getContext(), "mbridge_download_message_dialog_expand", "drawable"));
                        mBImageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                if (RenderEngine.this.f32464a != null) {
                                    RenderEngine.this.f32464a.putView("image_privacy", mBImageView);
                                }
                                RenderEngine.this.f32465b.mo20613a(RenderEngine.this.f32466c, RenderEngine.this.f32464a, CustomViewRenderListener.EnumC11739a.CLICK_EVENT_OPEN_PRIVACY);
                            }
                        });
                    }
                }
            } else if (childAt instanceof MBButton) {
                final MBButton mBButton = (MBButton) childAt;
                mBButton.setIndeterminateProgressMode(true);
                mBButton.setBackgroundResource(ResourceUtil.m21814a(mBButton.getContext(), "mbridge_download_message_dialog_button_shape", "drawable"));
                if (!TextUtils.isEmpty(mBButton.getContentDescription()) && String.valueOf(mBButton.getContentDescription()).startsWith("download")) {
                    this.f32471h = mBButton;
                    mBButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.custom.a.d.5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (RenderEngine.this.f32464a != null) {
                                RenderEngine.this.f32464a.putView("button_download", mBButton);
                            }
                            RenderEngine.this.f32465b.mo20613a(RenderEngine.this.f32466c, RenderEngine.this.f32464a, CustomViewRenderListener.EnumC11739a.CLICK_EVENT_DOWNLOAD);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public final MBButton m20589a() {
        return this.f32471h;
    }
}
