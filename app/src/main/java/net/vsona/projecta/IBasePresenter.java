package net.vsona.projecta;

import android.os.Bundle;

/**
 * Author   : roy
 * Data     : 2017-01-09  19:05
 * Describe :
 */

public interface IBasePresenter {
    void onCreate(Bundle savedInstanceState);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void detachView();
}
