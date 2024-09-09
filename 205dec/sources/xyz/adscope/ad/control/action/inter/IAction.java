package xyz.adscope.ad.control.action.inter;

import android.content.Context;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.http.response.ad.NativeModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAction {
    void execute(Context context, NativeModel nativeModel);

    void setITrackEventStatus(ITrackEventStatus iTrackEventStatus);
}
