package ulL.WeEFDVoZmmWVmW.yXd.callbacks;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import android.view.View;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public abstract class XC_LayoutInflated extends XCallback implements Comparable {

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public final class LayoutInflatedParam extends XCallback.Param {
        public ources res;
        public ources.ResourceNames resNames;
        public String variant;
        public View view;

        public LayoutInflatedParam(XposedBridge.CopyOnWriteSortedSet copyOnWriteSortedSet) {
            super((XCallback[]) copyOnWriteSortedSet.getSnapshot(new XCallback[0]));
        }
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public class Unhook implements IXUnhook {
        private final int id;
        private final String resDir;

        public Unhook(String str, int i4) {
            this.resDir = str;
            this.id = i4;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.IXUnhook
        public XC_LayoutInflated getCallback() {
            return XC_LayoutInflated.this;
        }

        public int getId() {
            return this.id;
        }

        @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.IXUnhook
        public void unhook() {
            ources.unhookLayout(this.resDir, this.id, XC_LayoutInflated.this);
        }
    }

    public XC_LayoutInflated() {
    }

    @Override // ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback
    public void call(XCallback.Param param) {
        if (param instanceof LayoutInflatedParam) {
            handleLayoutInflated((LayoutInflatedParam) param);
        }
    }

    public abstract void handleLayoutInflated(LayoutInflatedParam layoutInflatedParam);

    public XC_LayoutInflated(int i4) {
        super(i4);
    }

    @Override // java.lang.Comparable
    public int compareTo(XC_LayoutInflated xC_LayoutInflated) {
        if (this == xC_LayoutInflated) {
            return 0;
        }
        int i4 = xC_LayoutInflated.priority;
        int i5 = this.priority;
        return i4 != i5 ? i4 - i5 : System.identityHashCode(this) < System.identityHashCode(xC_LayoutInflated) ? -1 : 1;
    }
}
