
(import com.ochafik.lang.jnaerator.JNAerator)

(defn jnaerate [& args] (JNAerator/main (into-array String args)))

(jnaerate "-help")