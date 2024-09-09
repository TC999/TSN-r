package xyz.adscope.ad.control.interaction;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.interstitial.ASNPInterstitialActivity;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.ad.tool.widget.dialog.base.CustomDialog;
import xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionComplaint implements IBaseInteraction {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showComplainDialog$0(View view, IInteractionExecute iInteractionExecute, WeakReference weakReference, String str, String str2, AdScopeCycleModel adScopeCycleModel, String str3) {
        try {
            if (view instanceof ViewGroup) {
                if (iInteractionExecute != null) {
                    iInteractionExecute.customClose();
                }
                ((ViewGroup) view).removeAllViews();
                ((ViewGroup) view).addView(renderComplaintResultView((Context) weakReference.get(), "1"));
                AdScopeSpUtil.put(Constants.COMPLAIN_TIMESTAMP_KEY + str + "_" + str2, Long.valueOf(System.currentTimeMillis()));
                adScopeCycleModel.setComplainContent(str3);
                AdScopeEventReport.getInstance().reportAdEvent(adScopeCycleModel, EventReportCode.EVENT_REPORT_COMPLAIN_CODE, "");
            }
            if (weakReference.get() instanceof ASNPInterstitialActivity) {
                ((ASNPInterstitialActivity) weakReference.get()).finish();
            }
            String str4 = Constants.TAG;
            LogUtil.i(str4, "itemValue : " + str3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showComplainDialog$1(View view) {
        try {
            if (view instanceof AdTotalView) {
                ((AdTotalView) view).getAdVideoView().resumeVideo();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showComplainDialog$2(View view, boolean z3) {
        if (z3) {
            try {
                if (view instanceof AdTotalView) {
                    ((AdTotalView) view).getAdVideoView().resumeVideo();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private View renderComplaintResultView(Context context, String str) {
        TextView textView;
        try {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            if (!"1".equals(str) && !"2".equals(str)) {
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setBackgroundColor(Color.parseColor("#000000"));
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.adscope_icon_checkbox);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                linearLayout.addView(imageView);
                textView = new TextView(context);
                textView.setText(context.getString(R.string.adscope_complaint_result_text));
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView.setTextSize(2, 13.0f);
                textView.setGravity(17);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                if (!"1".equals(str) && !"2".equals(str)) {
                    textView.setPadding(30, 0, 0, 0);
                    linearLayout.addView(textView);
                    return linearLayout;
                }
                textView.setPadding(0, 30, 0, 0);
                linearLayout.addView(textView);
                return linearLayout;
            }
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#000000"));
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(R.drawable.adscope_icon_checkbox);
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            linearLayout.addView(imageView2);
            textView = new TextView(context);
            textView.setText(context.getString(R.string.adscope_complaint_result_text));
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (!"1".equals(str)) {
                textView.setPadding(30, 0, 0, 0);
                linearLayout.addView(textView);
                return linearLayout;
            }
            textView.setPadding(0, 30, 0, 0);
            linearLayout.addView(textView);
            return linearLayout;
        } catch (Exception e4) {
            String str2 = Constants.TAG;
            LogUtil.e(str2, "e : " + e4);
            return null;
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void execute() {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void setAdListener(AdListener adListener) {
    }

    public void showComplainDialog(View view, final AdScopeCycleModel adScopeCycleModel, final IInteractionExecute iInteractionExecute) {
        if (adScopeCycleModel == null) {
            return;
        }
        try {
            final String spaceType = adScopeCycleModel.getSpaceType();
            final String apiKey = adScopeCycleModel.getApiKey();
            final View totalAdView = ((IInteractionView) view).getTotalAdView();
            final WeakReference<Context> findActivityContext = SystemUtil.findActivityContext(totalAdView);
            if (findActivityContext.get() != null) {
                ComplainDialog.Builder builder = new ComplainDialog.Builder(findActivityContext.get());
                builder.setDialogItemCallback(new ComplainDialog.DialogItemCallback() { // from class: xyz.adscope.ad.control.interaction.c
                    @Override // xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.DialogItemCallback
                    public final void onDialogItemClick(String str) {
                        InteractionComplaint.this.lambda$showComplainDialog$0(totalAdView, iInteractionExecute, findActivityContext, spaceType, apiKey, adScopeCycleModel, str);
                    }
                });
                builder.setDialogCloseCallback(new ComplainDialog.DialogCloseCallback() { // from class: xyz.adscope.ad.control.interaction.b
                    @Override // xyz.adscope.ad.tool.widget.dialog.complain.ComplainDialog.DialogCloseCallback
                    public final void onCloseClick() {
                        InteractionComplaint.lambda$showComplainDialog$1(totalAdView);
                    }
                });
                ComplainDialog create = builder.create();
                create.setOnDialogDismissListener(new CustomDialog.OnDialogDismissListener() { // from class: xyz.adscope.ad.control.interaction.a
                    @Override // xyz.adscope.ad.tool.widget.dialog.base.CustomDialog.OnDialogDismissListener
                    public final void onDialogDismissed(boolean z3) {
                        InteractionComplaint.lambda$showComplainDialog$2(totalAdView, z3);
                    }
                });
                create.show();
                if (totalAdView instanceof AdTotalView) {
                    ((AdTotalView) totalAdView).getAdVideoView().pauseVideo();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
