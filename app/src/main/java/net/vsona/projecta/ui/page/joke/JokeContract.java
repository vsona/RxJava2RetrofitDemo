package net.vsona.projecta.ui.page.joke;

import net.vsona.projecta.IBaseView;
import net.vsona.projecta.domain.JockDo;
import net.vsona.projecta.domain.JokeResult;

import java.util.List;

/**
 * Author   : roy
 * Data     : 2017-01-10  12:19
 * Describe :
 */

public class JokeContract {
    interface View extends IBaseView {

        void showJokes(List<JockDo> contentlist);

        void clearData();

        void showEmpty();

        void setLoadFinish();

        void setRefreshing(boolean b);
    }
}
