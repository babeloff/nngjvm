

(import com.ochafik.lang.jnaerator.JNAerator)
(import com.ochafik.lang.jnaerator.JNAeratorConfig)

(JNAerator/main (into-array String ["@config.jna"]))

(def jnae-args (System/getProperty "jnaerator.args"))
(def jnae-config (JNAeratorConfig.))
(def jnaerator (JNAerator. jnae-config))

(import java.nio.file.FileSystems)
(import java.nio.file.FileSystem)
(import java.net.URI)
(def java-base (URI/create "jrt:/"))
(def jrtfs (FileSystems/getFileSystem java-base))
(.getPath jrtfs "java.base"
          (into-array String ["java/lang/String.class"]))

(import java.util.regex.Matcher)
(import java.util.regex.Pattern)
(def resstr "jrt:/java.base/java/lang/String.class")
(def pattern (Pattern/compile "jrt:/(?<module>[^/]*)(?<path>.*)"))
(def matcher (.matcher pattern resstr))
(.find matcher)
(def newstr (.group matcher "path"))
