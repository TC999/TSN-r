package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import xyz.adscope.ad.control.render.view.AdVideoView;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdTotalView extends RelativeLayout {
    private AdClickInteractionView adClickInteractionView;
    private AdReplayInteractionView adReplayInteractionView;
    private AdVideoView adVideoView;
    private TextView appInfoRenderView;
    private DwinfoModel dwinfoModel;
    private View maskView;
    private ImageView replayInteractionView;
    private ImageView voiceRenderView;

    public AdTotalView(Context context) {
        super(context);
    }

    public AdClickInteractionView getAdClickInteractionView() {
        return this.adClickInteractionView;
    }

    public AdReplayInteractionView getAdReplayInteractionView() {
        return this.adReplayInteractionView;
    }

    public AdVideoView getAdVideoView() {
        return this.adVideoView;
    }

    public TextView getAppInfoRenderView() {
        return this.appInfoRenderView;
    }

    public DwinfoModel getDwinfoModel() {
        return this.dwinfoModel;
    }

    public View getMaskView() {
        return this.maskView;
    }

    public ImageView getReplayInteractionView() {
        return this.replayInteractionView;
    }

    public ImageView getVoiceRenderView() {
        return this.voiceRenderView;
    }

    public void setAdClickInteractionView(AdClickInteractionView adClickInteractionView) {
        this.adClickInteractionView = adClickInteractionView;
    }

    public void setAdReplayInteractionView(AdReplayInteractionView adReplayInteractionView) {
        this.adReplayInteractionView = adReplayInteractionView;
    }

    public void setAdVideoView(AdVideoView adVideoView) {
        this.adVideoView = adVideoView;
    }

    public void setAppInfoRenderView(TextView textView) {
        this.appInfoRenderView = textView;
    }

    public void setDwinfoModel(DwinfoModel dwinfoModel) {
        this.dwinfoModel = dwinfoModel;
    }

    public void setMaskView(View view) {
        this.maskView = view;
    }

    public void setReplayInteractionView(ImageView imageView) {
        this.replayInteractionView = imageView;
    }

    public void setVoiceRenderView(ImageView imageView) {
        this.voiceRenderView = imageView;
    }

    public AdTotalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdTotalView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public AdTotalView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
