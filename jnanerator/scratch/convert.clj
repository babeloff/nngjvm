

;; https://github.com/nativelibs4java/JNAerator/blob/master/jnaerator/src/main/java/com/ochafik/lang/jnaerator/JNAerator.java

(import com.ochafik.lang.jnaerator.JNAerator)
(import com.ochafik.lang.jnaerator.JNAeratorConfig)

;;

(defn jnaerate
      [& args]
      (JNAerator/main (into-array String args)))

;; git clone https://github.com/nanomsg/nng

(jnaerate "-f" "-beautifyNames" "-v"
          "/home/fred/github/nng/src/nng.h"
          "-I" "/home/fred/github/nng/src/"
          "-library" "nng"
          "-o" "../src/main/java"
          "-mode" "Directory"
          "-arch" "linux_x64")


