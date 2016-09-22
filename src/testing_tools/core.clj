(ns testing-tools.core
  (:gen-class))

(use '[clojure.string :only (join)])

(declare process-expression)

(def operators #{'+ '- '* '/ 'rem})

(defmulti map-function (fn [lang name] [lang name]))
(defmethod map-function[:java 'assert] [_ _] "assertTrue")
(defmethod map-function[:cpp 'assert] [_ _] "ASSERT_TRUE")
(defmethod map-function :default [_ name] name)

(defmulti map-operator (fn [lang oper-sign] [lang oper-sign]))
(defmethod map-operator [:java 'rem] [_ _] "%")
(defmethod map-operator [:cpp 'rem] [_ _] "%")
(defmethod map-operator :default [_ oper-sign] oper-sign)

(defmulti operator? (fn [lang oper-sign] [lang oper-sign]))
(defmethod operator? :default [_ oper-sign] (oper-sign operators))


(defn process-operator
  [lang oper-sign args] (
                         join (str " " (map-operator lang oper-sign) " ") (map (partial process-expression lang) args)))

(defn process-function
  [lang name args] (
                    str (map-function lang name) "(" (join ", " (map (partial process-expression lang) args)) ")"))

(defn process-form
  [lang name args] (cond
                     (operator? lang name)(process-operator lang name args)
                     :else  (process-function lang name args)))

(defn process-expression
  [lang expression] (cond
                       (list? expression) (process-form lang (first expression) (rest expression))
                       :else expression))

(defn generate-assert
  [lang assert-expr] (process-expression lang assert-expr))
