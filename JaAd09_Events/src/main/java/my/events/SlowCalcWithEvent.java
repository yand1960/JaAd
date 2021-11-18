package my.events;


import java.util.ArrayList;
import java.util.List;

public class SlowCalcWithEvent {

    private List<ProgressListener> progressListeners = new ArrayList<>();

    public int plus(int x, int y) {
        for(int i=0; i <= 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onProgress(i);
        }
        return x + y;
    }

    public void addProgressListener(ProgressListener progressListener) {
        progressListeners.add(progressListener);
    }

    //Еще нужен removeProgressListener - отложим

    protected void onProgress(int percent) {
        progressListeners.forEach(listener -> {
            listener.progress(percent);
        });
    }
}

//public class SlowCalcWithEvent {
//
//    private ProgressListener progressListener;
//
//    public int plus(int x, int y) {
//        for(int i=0; i <= 100; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (progressListener != null)
//                progressListener.progress(i);
//        }
//        return x + y;
//    }
//
//    public void setProgressListener(ProgressListener progressListener) {
//        this.progressListener = progressListener;
//    }
//}
