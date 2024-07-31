package com.kwad.framework.filedownloader.exception;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
