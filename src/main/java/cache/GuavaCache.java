package cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * @author yangmin
 * @email ym99929@alibaba-inc.com
 * @date 2017/2/23 上午10:43
 * @description
 */
public class GuavaCache {


	public  <K , V> LoadingCache<K , V> cached(CacheLoader<K , V> cacheLoader) {
		LoadingCache<K , V> cache = CacheBuilder
				.newBuilder()
				.maximumSize(3)
				.weakKeys()
				.softValues()
				.refreshAfterWrite(120, TimeUnit.SECONDS)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.removalListener(new RemovalListener<K, V>(){

					@Override
					public void onRemoval(RemovalNotification<K, V> rn) {
						System.out.println(rn.getKey()+"被移除");

					}})
				.build(cacheLoader);
		return cache;
	}

	public  LoadingCache<String , String> commonCache() throws Exception{
		LoadingCache<String , String> commonCache= cached(new CacheLoader<String , String>(){
			@Override
			public String load(String key) throws Exception {
				return "hello "+key+"!";
			}
		});
		return commonCache;
	}

	public static void main(String[] args) throws Exception {

		GuavaCache cache=new GuavaCache();
		LoadingCache map=cache.commonCache();
		System.out.println("peida:"+map.get("peida"));
		System.out.println("harry:"+map.get("harry"));
		map.put("harry","we change harry");
		System.out.println("lisa:"+map.get("lisa"));

	}

}
