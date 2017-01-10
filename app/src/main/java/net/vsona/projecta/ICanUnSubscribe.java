package net.vsona.projecta;

import io.reactivex.disposables.Disposable;

/**
 * Author   : roy
 * Data     : 2016-12-25  16:15
 * Describe :
 */

public interface ICanUnSubscribe {
    void bindDisposable(Disposable d);
}
