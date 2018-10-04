import scalacache.ScalaCache
import scalacache.serialization.Codec

final case class MyCache[CacheRepr](scalaCache: ScalaCache[CacheRepr])(
  implicit stringCodec: Codec[Int, CacheRepr]) {

  def putInt(value: Int) = scalaCache.cache.put[Int]("my_int", value, None)

}
