scalaVersion := "2.12.7"

val scalaCacheVersion = "0.9.4"
val ficusVersion      = "1.4.3"

libraryDependencies ++= Seq(
  "com.github.cb372"     %% "scalacache-caffeine"     % scalaCacheVersion,
  "com.github.cb372"     %% "scalacache-redis"        % scalaCacheVersion,
  "com.iheart"           %% "ficus"                   % ficusVersion
)

