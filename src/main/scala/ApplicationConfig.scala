import com.typesafe.config.Config
import net.ceedubs.ficus.readers.ValueReader
import scalacache.Cache
import scalacache.caffeine.CaffeineCache
import scalacache.redis.SentinelRedisCache

final case class ApplicationConfig(cache: Cache[_])

object ApplicationConfig {
  implicit val cacheValueReader: ValueReader[Cache[_]] = new ValueReader[Cache[_]] {
    override def read(config: Config, path: String): Cache[_] =
      config.getString(path + ".type") match {
        case "caffeine"       => CaffeineCache()
        case "sentinel-redis" => SentinelRedisCache("something", Set.empty, "something_else")
      }
  }
}