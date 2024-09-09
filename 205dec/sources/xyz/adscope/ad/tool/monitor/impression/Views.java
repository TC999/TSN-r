package xyz.adscope.ad.tool.monitor.impression;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Views {
    private static View getRootViewFromActivity(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    private static View getRootViewFromView(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    public static View getTopmostView(Context context, View view) {
        View rootViewFromActivity = getRootViewFromActivity(context);
        return rootViewFromActivity != null ? rootViewFromActivity : getRootViewFromView(view);
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
