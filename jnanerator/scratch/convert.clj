

;; https://github.com/nativelibs4java/JNAerator/blob/master/jnaerator/src/main/java/com/ochafik/lang/jnaerator/JNAerator.java

(import com.ochafik.lang.jnaerator.JNAerator)

;;
(JNAerator/main (into-array String ["-help"]))

(JNAerator/main (into-array String ["-f" "-beautifyNames" "-v"
                                    "sample/Test.h"
                                    "-library" "nng"
                                    "-o" "target"
                                    "-mode" "Directory"
                                    "-arch" "linux_x64" ]))