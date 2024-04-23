package com.example.safesdk.sample.internal.partials;

import android.media.MediaPlayer;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;

/* compiled from: AdMobSourceFile */
public class AdMobVideoBridge {
    public static void MediaPlayerStart(MediaPlayer mp) throws IllegalStateException {
        Logger.m3600d("AdMobVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AdMobVideoBridge;->MediaPlayerStart(Landroid/media/MediaPlayer;)V");
        try {
            Logger.m3601d("VideoBridge", "MediaPlayerStart: " + mp);
            CreativeInfoManager.m3072a(C1357d.f3603k, (Object) mp);
        } catch (Exception e) {
            Logger.m3601d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
        }
        mp.start();
    }

    public static void MediaPlayerStop(MediaPlayer mp) throws IllegalStateException {
        Logger.m3600d("AdMobVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/AdMobVideoBridge;->MediaPlayerStop(Landroid/media/MediaPlayer;)V");
        try {
            Logger.m3601d("VideoBridge", "MediaPlayerStop: " + mp);
            CreativeInfoManager.onVideoCompleted(C1357d.f3603k, mp);
        } catch (Exception e) {
            Logger.m3601d("VideoBridge", "exception in MediaPlayerStop: " + e.getMessage());
        }
        mp.stop();
    }
}
