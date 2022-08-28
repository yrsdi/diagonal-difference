(ns diagonal-difference.core
  (:gen-class))

;; sum function
(defn sum [x] (apply + x))

(defn signedDiagonalDiff
  [arr]
  ;; get first diagonal
  (def dig-primary
    (for [i (range (count (first arr)))] [i i]))
  ;; get second diagonal
  (def dig-secondary
    (for [i (range (count (first arr)))] [(- (count (first arr)) i 1) i]))
  ;; get first diagonal value
  (def val-primary
    (map #(get-in arr %) dig-primary))
  ;; get second diagonal value
  (def val-secondary 
    (map #(get-in arr %) dig-secondary))
  ;; sum value  
  (- (sum val-primary) (sum val-secondary))
  )

(defn diagonalDifference
  [arr]
  (let [diff (signedDiagonalDiff arr)]
    (if (neg? diff) (- diff) diff))
  )

(defn -main 
  (def arr [[11 2 4]
            [4 5 6]
            [10 8 -12]]) 
  (println (diagonalDifference arr))
  
  )
