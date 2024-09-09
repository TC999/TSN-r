package xyz.adscope.ad.control.interaction;

import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionClick implements IBaseInteraction {
    private AdListener adListener;
    private ClickCallbackInterface clickCallbackInterface;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface ClickCallbackInterface {
        void clickCallback();
    }

    public InteractionClick(ClickCallbackInterface clickCallbackInterface) {
        this.clickCallbackInterface = clickCallbackInterface;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void execute() {
        ClickCallbackInterface clickCallbackInterface = this.clickCallbackInterface;
        if (clickCallbackInterface != null) {
            clickCallbackInterface.clickCallback();
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }
}
