package tests;

import categories.FastTest;
import categories.FullTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import pages.TestPage;


@RunWith(ConcurrentTestRunner.class)
public class TestTwo extends baseTest
{

    @Category({FastTest.class, FullTest.class})
    @Test
    public void test() throws InterruptedException
    {
        TestPage testPage = new TestPage(driver);

        testPage.openPage();

        testPage.test1();
        testPage.test2();
        testPage.test3();
    }
}