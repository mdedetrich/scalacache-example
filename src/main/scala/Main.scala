import com.typesafe.config.ConfigFactory
import scalacache.ScalaCache
import scalacache.caffeine.CaffeineCache
import scalacache._
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
import net.ceedubs.ficus.readers.namemappers.implicits.hyphenCase
import scalacache.redis.SentinelRedisCache
import ApplicationConfig._

object Main extends App {
  val config = ConfigFactory.load()
  val applicationConfig = config.as[ApplicationConfig]("application=config")

  val myCache: MyCache[_] = MyCache(ScalaCache(CaffeineCache())) // This works
  val myCache2: MyCache[_] = MyCache(ScalaCache(SentinelRedisCache("", Set.empty, ""))) // This works
//  val myCache3: MyCache[_] = MyCache(ScalaCache(applicationConfig.cache)) // This doesn't

}
