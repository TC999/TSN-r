package xyz.adscope.ad.control.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.action.inter.IAction;
import xyz.adscope.ad.control.action.util.PageJumpUtil;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ActionDeepLink implements IAction {
    private ITrackEventStatus iTrackEventStatus;

    private void showPromptDialog(final Context context, final Intent intent) {
        ITrackEventStatus iTrackEventStatus = this.iTrackEventStatus;
        if (iTrackEventStatus != null) {
            iTrackEventStatus.startInvoke();
        }
        AdscopeCommonDialog.Builder builder = new AdscopeCommonDialog.Builder(context);
        builder.setContent(context.getString(R.string.adscope_will_open_the_third_app));
        builder.setCustomDialogCallBack(new AdscopeCommonDialog.CustomDialogCallBack() { // from class: xyz.adscope.ad.control.action.ActionDeepLink.1
            @Override // xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog.CustomDialogCallBack
            public void onCancel() {
            }

            @Override // xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog.CustomDialogCallBack
            public void onConfirm() {
                Intent intent2;
                Context context2 = context;
                if (context2 == null || (intent2 = intent) == null) {
                    return;
                }
                context2.startActivity(intent2);
                if (ActionDeepLink.this.iTrackEventStatus != null) {
                    ActionDeepLink.this.iTrackEventStatus.invokeSuccess();
                }
            }
        });
        builder.create().show();
    }

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void execute(Context context, NativeModel nativeModel) {
        if (nativeModel != null) {
            IInteractionView.INTERACTION_ACTION_CODE interaction_action_code = IInteractionView.INTERACTION_ACTION_CODE.INTERACTION_CODE_DEEPLINK;
            if (interaction_action_code.getCode() == nativeModel.getLink().getStyle() && nativeModel.getLink() != null && interaction_action_code.getCode() == nativeModel.getLink().getStyle()) {
                if (!TextUtils.isEmpty(nativeModel.getLink().getUrlfb())) {
                    if (PageJumpUtil.startDeepLink(context, nativeModel, this.iTrackEventStatus)) {
                        return;
                    }
                    PageJumpUtil.startLandPage(context, nativeModel);
                } else if (TextUtils.isEmpty(nativeModel.getLink().getUrl())) {
                } else {
                    PageJumpUtil.startLandPage(context, nativeModel);
                }
            }
        }
    }

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }
}
