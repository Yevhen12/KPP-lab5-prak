import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UrlProcessorTest {

    @Test
    public void testProcessUrl() {

        assertEquals("https://kahoot.com/6/6/6/o", UrlProcessor.processUrl("http://kahoot.com/1/2/3"));
        assertEquals("https://testing.com/5/5/n", UrlProcessor.processUrl("https://testing.com/2/3"));

        assertEquals("https://testing.com/3/orders/3/n", UrlProcessor.processUrl("http://testing.com/1/orders/2"));

        assertEquals("https://testing.com/12/orders/12/12/12/n", UrlProcessor.processUrl("http://testing.com/1/orders/2/7/2"));

        assertEquals("https://some.com/3/orders/3/m", UrlProcessor.processUrl("http://some.com/1/orders/2"));

    }
}
