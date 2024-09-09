package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import xyz.adscope.ad.R;
import xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCustomCloseView extends RelativeLayout implements IAdCustomTextInterface {
    private ImageView closeImageView;
    private TextView closeTextView;
    private TextView countdownTextView;
    private LinearLayout textContainer;

    public AdCustomCloseView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.asnp_custom_close_view, (ViewGroup) this, true);
        this.closeImageView = (ImageView) findViewById(R.id.asnp_interstitial_ad_close_iv);
        this.textContainer = (LinearLayout) findViewById(R.id.asnp_interstitial_ad_close_text_container_ll);
        this.countdownTextView = (TextView) findViewById(R.id.asnp_interstitial_ad_countdown_tv);
        this.closeTextView = (TextView) findViewById(R.id.asnp_interstitial_ad_close_tv);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
    }

    @Override // android.widget.RelativeLayout, xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setGravity(int i4) {
        this.countdownTextView.setGravity(i4);
        this.closeTextView.setGravity(i4);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setLines(int i4) {
        this.countdownTextView.setLines(1);
        this.closeTextView.setLines(1);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setText(CharSequence charSequence) {
        this.closeTextView.setText(charSequence);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setTextColor(int i4) {
        this.countdownTextView.setTextColor(i4);
        this.closeTextView.setTextColor(i4);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setTextSize(int i4, float f4) {
        this.countdownTextView.setTextSize(i4, f4);
        this.closeTextView.setTextSize(i4, f4);
    }

    public void showCloseUI(int i4, int i5) {
        this.closeImageView.setVisibility(0);
        this.textContainer.setVisibility(8);
        this.closeImageView.setLayoutParams(new RelativeLayout.LayoutParams(i4, i5));
    }

    public void showCountDownTimeUI(int i4) {
        this.closeImageView.setVisibility(8);
        this.textContainer.setVisibility(0);
        ShapeUtil.setViewBackGround(this.countdownTextView, "#66303030", 0, (String) null, i4 * 2);
    }

    public void updateCountDownTimeText(int i4) {
        if (i4 == 0) {
            this.countdownTextView.setVisibility(8);
            return;
        }
        this.countdownTextView.setVisibility(0);
        TextView textView = this.countdownTextView;
        textView.setText(i4 + "");
    }

    public AdCustomCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AdCustomCloseView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context);
    }
}
