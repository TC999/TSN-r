package xyz.adscope.ad.control.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import xyz.adscope.ad.R;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.inter.IAction;
import xyz.adscope.ad.control.action.util.MarketTools;
import xyz.adscope.ad.control.action.util.PageJumpUtil;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.download.DownloadManager;
import xyz.adscope.ad.tool.widget.dialog.AdscopeCommonDialog;
import xyz.adscope.ad.tool.widget.dialog.download.AdscopeDownloadDialog;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ActionDownload implements IAction {
    private ITrackEventStatus iTrackEventStatus;

    private void downLoadApk(Context context, String str) {
        new DownloadManager().startDownload(context, str);
    }

    private void landDownloadApk(Context context, NativeModel nativeModel) {
        try {
            showPromptDialog(context, nativeModel, nativeModel.getLink().getUrldw());
        } catch (Exception unused) {
            PageJumpUtil.startLandPage(context, nativeModel);
        }
    }

    private void landMarket(Context context, NativeModel nativeModel) {
        if (!TextUtils.isEmpty(nativeModel.getLink().getUrlmk())) {
            if (MarketTools.startMarket(context, nativeModel.getDwinfo().getBundle())) {
                return;
            }
            loadMarketException(context, nativeModel);
            return;
        }
        loadMarketException(context, nativeModel);
    }

    private void loadMarketException(Context context, NativeModel nativeModel) {
        if (!TextUtils.isEmpty(nativeModel.getLink().getUrldw())) {
            landDownloadApk(context, nativeModel);
        } else if (TextUtils.isEmpty(nativeModel.getLink().getUrl())) {
        } else {
            PageJumpUtil.startLandPage(context, nativeModel);
        }
    }

    private void showPromptDialog(final Context context, final Intent intent) {
        AdscopeCommonDialog.Builder builder = new AdscopeCommonDialog.Builder(context);
        builder.setContent(context.getString(R.string.adscope_will_open_the_third_app));
        builder.setCustomDialogCallBack(new AdscopeCommonDialog.CustomDialogCallBack() { // from class: xyz.adscope.ad.control.action.ActionDownload.1
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
            }
        });
        builder.create().show();
    }

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void execute(Context context, NativeModel nativeModel) {
        if (nativeModel == null || nativeModel.getLink() == null || IInteractionView.INTERACTION_ACTION_CODE.INTERACTION_CODE_DOWNLOAD.getCode() != nativeModel.getLink().getStyle()) {
            return;
        }
        if (!TextUtils.isEmpty(nativeModel.getLink().getUrlfb())) {
            if (PageJumpUtil.startDeepLink(context, nativeModel, this.iTrackEventStatus)) {
                return;
            }
            landMarket(context, nativeModel);
        } else if (!TextUtils.isEmpty(nativeModel.getLink().getUrlmk())) {
            landMarket(context, nativeModel);
        } else if (!TextUtils.isEmpty(nativeModel.getLink().getUrldw())) {
            landDownloadApk(context, nativeModel);
        } else if (TextUtils.isEmpty(nativeModel.getLink().getUrl())) {
        } else {
            PageJumpUtil.startLandPage(context, nativeModel);
        }
    }

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }

    private void showPromptDialog(Context context, NativeModel nativeModel, String str) {
        if (nativeModel == null || nativeModel.getDwinfo() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(Constants.DOWNLOAD_INFO_KEY, nativeModel.getDwinfo());
        intent.putExtra(Constants.DOWNLOAD_URL_KEY, str);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, AdscopeDownloadDialog.class);
        context.startActivity(intent);
    }
}
