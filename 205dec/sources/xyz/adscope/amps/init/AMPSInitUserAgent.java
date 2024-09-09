package xyz.adscope.amps.init;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;
import xyz.adscope.amps.tool.thread.AMPSThreadPool;
import xyz.adscope.amps.tool.widget.AMPSCustomWebView;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInitUserAgent {
    public static final int USER_AGENT_MESSAGE = 1;
    private ScheduledExecutorService executor;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.amps.init.AMPSInitUserAgent.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            try {
                AMPSSDKManager.getInstance().setUserAgent(new AMPSCustomWebView(AMPSInitUserAgent.this.mContext).getSettings().getUserAgentString());
                AMPSSpUtil.putString(CommonConstants.USER_AGENT_KEY, AMPSSDKManager.getInstance().getUserAgent());
                AMPSInitUserAgent.this.stopSchedulerTask();
            } catch (Exception e4) {
                LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public void getUserAgent(Context context) {
        if (context == null) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService = AMPSThreadPool.getScheduledExecutorService();
        this.executor = scheduledExecutorService;
        this.mContext = context;
        scheduledExecutorService.schedule(new Runnable() { // from class: xyz.adscope.amps.init.AMPSInitUserAgent.2
            @Override // java.lang.Runnable
            public void run() {
                AMPSInitUserAgent.this.mHandler.sendEmptyMessage(1);
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }
}
