
(import com.ochafik.lang.jnaerator.JNAerator)

(defn jnaerate [& args] (JNAerator/main (into-array String args)))

(jnaerate "-f" "-beautifyNames" "-v"
          "sample/Test.h"
          "-library" "nng"
          "-o" "target"
          "-mode" "Directory"
          "-arch" "linux_x64")