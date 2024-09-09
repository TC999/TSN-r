package xyz.adscope.ad.control.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import xyz.adscope.ad.control.action.inter.IAction;
import xyz.adscope.ad.control.action.webview.WebViewActivity;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.http.response.ad.NativeModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ActionLandingPage implements IAction {
    private ITrackEventStatus iTrackEventStatus;

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void execute(Context context, NativeModel nativeModel) {
        Intent intent = new Intent();
        intent.putExtra("url", nativeModel.getLink().getUrl());
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.setClass(context, WebViewActivity.class);
        context.startActivity(intent);
    }

    @Override // xyz.adscope.ad.control.action.inter.IAction
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }
}
