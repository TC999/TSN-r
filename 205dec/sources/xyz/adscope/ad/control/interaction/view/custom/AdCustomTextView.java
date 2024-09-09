package xyz.adscope.ad.control.interaction.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.common.info.DeviceInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdCustomTextView extends AppCompatTextView implements IAdCustomTextInterface {
    private AdScopeCycleModel adScopeCycleModel;

    public AdCustomTextView(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adScopeCycleModel != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setDownTS(DeviceInfo.getInstance(getContext()).getTimeStamp());
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel.setClickDownX(motionEvent.getX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel2 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel2.setClickDownY(motionEvent.getY() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel3 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel3.setSrcDownX(motionEvent.getRawX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel4 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel4.setSrcDownY(motionEvent.getRawY() + "");
            } else if (action == 1) {
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel5 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel5.setClickUpX(motionEvent.getX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel6 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel6.setClickUpY(motionEvent.getY() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel7 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel7.setSrcUpX(motionEvent.getRawX() + "");
                AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel8 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
                adScopeRenderCustomTrackerModel8.setSrcUpY(motionEvent.getRawY() + "");
                this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setUpTS(DeviceInfo.getInstance(getContext()).getTimeStamp());
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // xyz.adscope.ad.control.interaction.view.custom.inter.IAdCustomTextInterface
    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(this);
    }

    public AdCustomTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdCustomTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
