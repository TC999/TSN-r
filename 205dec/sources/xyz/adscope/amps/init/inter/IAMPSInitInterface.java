package xyz.adscope.amps.init.inter;

import android.content.Context;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.model.AMPSGlobalModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAMPSInitInterface {
    AMPSGlobalModel getGlobalModel();

    void init(Context context, AMPSInitConfig aMPSInitConfig, AMPSGlobalModel aMPSGlobalModel, IAMPSInitCallback iAMPSInitCallback);

    boolean isInitSuccess();
}
