package be.hogent.examen2014_1e_zit;

import android.test.AndroidTestCase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import be.hogent.examen2014_1e_zit.network.SubredditsDownloader;
import be.hogent.examen2014_1e_zit.interfaces.SubredditsListener;
import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;

/**
 * Created by jbuy519 on 04/12/2014.
 */
public class SubredditsTest extends AndroidTestCase implements SubredditsListener{

    private SubredditsDownloader downloader;
    private CountDownLatch signal;
    private List<SubRedditData> subRedditDatas;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
        downloader = new SubredditsDownloader(this);
    }


    public void testDownload() throws InterruptedException, MalformedURLException{
        downloader.download(new URL("http://www.reddit.com/subreddits/popular.json"));
        signal.await(5, TimeUnit.SECONDS);
        assertEquals(25,subRedditDatas.size());

    }

    public void downloadCompleted(List<SubRedditData> subRedditDatas){
        signal.countDown();
        this.subRedditDatas = subRedditDatas;
    }
}
