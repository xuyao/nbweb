package nbweb;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args){
		Jedis jedis = new Jedis("218.241.106.181");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}
}
