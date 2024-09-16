import org.example.CacheLibrary;
import org.example.models.CachePolicyType;
import org.junit.Assert;
import org.junit.Test;

public class CacheLibraryTest {

  private CacheLibrary<Integer, String> cacheLibrary;

  @Test
  public void lruCacheTest() {
    cacheLibrary = new CacheLibrary<>(3, CachePolicyType.LRU, null);
    cacheLibrary.put(1, "1");
    cacheLibrary.put(2, "2");
    cacheLibrary.put(3, "3");
    Assert.assertEquals(cacheLibrary.get(2), "2");
    cacheLibrary.put(4, "4");
    Assert.assertNull(cacheLibrary.get(1));
    cacheLibrary.put(5, "5");
    Assert.assertNull(cacheLibrary.get(3));
    Assert.assertEquals(cacheLibrary.get(2), "2");
  }

  @Test
  public void lfuCacheTest() {
    cacheLibrary = new CacheLibrary<>(3, CachePolicyType.LFU, null);
    cacheLibrary.put(1, "1");
    cacheLibrary.put(2, "2");
    cacheLibrary.put(3, "3");
    Assert.assertEquals(cacheLibrary.get(2), "2");
    Assert.assertEquals(cacheLibrary.get(1), "1");
    cacheLibrary.put(4, "4");
    Assert.assertNull(cacheLibrary.get(3));
  }
}
