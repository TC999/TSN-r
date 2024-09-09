package xyz.adscope.common.network.download;

import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Url;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Download {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface Policy {
        public static final Policy DEFAULT = new Policy() { // from class: xyz.adscope.common.network.download.Download.Policy.1
            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean allowDownload(int i4, Headers headers) {
                return true;
            }

            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean isRange() {
                return true;
            }

            @Override // xyz.adscope.common.network.download.Download.Policy
            public boolean oldAvailable(String str, int i4, Headers headers) {
                return false;
            }
        };

        boolean allowDownload(int i4, Headers headers);

        boolean isRange();

        boolean oldAvailable(String str, int i4, Headers headers);
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface ProgressBar {
        public static final ProgressBar DEFAULT = new ProgressBar() { // from class: xyz.adscope.common.network.download.Download.ProgressBar.1
            @Override // xyz.adscope.common.network.download.Download.ProgressBar
            public void onProgress(int i4, long j4, long j5) {
            }
        };

        void onProgress(int i4, long j4, long j5);
    }

    String directory();

    String fileName();

    Headers headers();

    Policy policy();

    ProgressBar progressBar();

    Url url();
}
