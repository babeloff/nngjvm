
(import com.ochafik.lang.jnaerator.JNAerator)
(import com.ochafik.lang.jnaerator.JNAeratorConfig)

;;

(defn jnaerate
      [& args]
      (JNAerator/main (into-array String args)))

(jnaerate "-help")

(jnaerate "-f" "-beautifyNames" "-v"
          "sample/Test.h"
          "-library" "nng"
          "-o" "target"
          "-mode" "Directory"
          "-arch" "linux_x64")