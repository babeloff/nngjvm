
;; start clj from the jnaerator directory

;; https://github.com/nativelibs4java/JNAerator/blob/master/jnaerator/src/main/java/com/ochafik/lang/jnaerator/JNAerator.java

(import com.ochafik.lang.jnaerator.JNAerator)

(defn jnaerate [& args] (JNAerator/main (into-array String args)))

;; git clone https://github.com/nanomsg/nng

(jnaerate "@" "./scratch/config.jna")


