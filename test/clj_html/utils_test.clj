(ns clj-html.utils-test
  (:use clj-unit.core (clj-html core utils)))

(deftest "map-str"
  (assert= "foobarbat"
    (map-str name '(:foo :bar :bat))))

(deftest "domap-str"
  (assert= "foobarbat"
    (domap-str [key '(:foo :bar :bat)]
      (name key))))

(def result "<div num=\"3\">text</div>")

(deftest "defhtml"
  (defhtml foo [inner] [:div {:num (+ 1 2)} inner])
  (assert= (foo "text") result))

(deftest "when-let-html"
  (assert= result (when-let-html [inner "text"] [:div {:num (+ 1 2)} inner]))
  (assert-nil (when-let-html [inner false] [:div {:num (+ 1 2)} inner])))

(deftest "when-html"
  (assert= result (when-html true [:div {:num (+ 1 2)} "text"]))
  (assert-nil (when-html false [:div {:num (+ 1 2)} "text"])))