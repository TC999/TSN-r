package xyz.adscope.amps.config.inter;

import android.content.Context;
import xyz.adscope.amps.model.AMPSGlobalModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IConfigInterface {
    boolean checkConfig();

    void initConfigureFile(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback);

    void requestConfigureFile(AMPSGlobalModel aMPSGlobalModel, IConfigInfoCallback iConfigInfoCallback);

    void schedulerUpdateConfigureFile();

    void setContext(Context context);

    void updateConfigureFile(AMPSGlobalModel aMPSGlobalModel, String str);
}
