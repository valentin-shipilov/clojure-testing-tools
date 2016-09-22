(ns testing-tools.core-test-java
  (:require [clojure.test :refer :all]
            [testing-tools.core :refer :all]))

(deftest assert-true-test
  (testing "Should return assertTrue(true)."
    (is (= "assertTrue(true)" (generate-assert :java '(assert true))))))

(deftest assert-false-test
  (testing "Should return assertTrue(false)."
    (is (= "assertTrue(false)" (generate-assert :java '(assert false))))))

(deftest assert-is-prime-of-number
  (testing "Should return assertTrue(is_prime(10))"
    (is (= "assertTrue(is_prime(10))" (generate-assert :java '(assert (is_prime 10)))))))

(deftest assert-some-funct-of-many-args
  (testing "Should return assertTrue(some_funct(10, 11, 12))"
    (is (= "assertTrue(some_funct(10, 11, 12))" (generate-assert :java '(assert (some_funct 10 11 12)))))))

(deftest assert-is-prime-of-sum
  (testing "Should return assertTrue(is_prime(10 + 1)))"
    (is (= "assertTrue(is_prime(10 + 1))" (generate-assert :java '(assert (is_prime (+ 10 1))))))))

(deftest assert-is-prime-of-substraction
  (testing "Should return assertTrue(is_prime(10 - 1)))"
    (is (= "assertTrue(is_prime(10 - 1))" (generate-assert :java '(assert (is_prime (- 10 1))))))))

(deftest assert-is-prime-of-multiplication
  (testing "Should return assertTrue(is_prime(10 * 1)))"
    (is (= "assertTrue(is_prime(10 * 1))" (generate-assert :java '(assert (is_prime (* 10 1))))))))

(deftest assert-is-prime-of-division
  (testing "Should return assertTrue(is_prime(10 / 1)))"
    (is (= "assertTrue(is_prime(10 / 1))" (generate-assert :java '(assert (is_prime (/ 10 1))))))))

(deftest assert-is-prime-of-sum-foo-bar
  (testing "assertTrue(is_prime(foo(10, 11) + bar(1, 2 - 3)))"
    (is (= "assertTrue(is_prime(foo(10, 11) + bar(1, 2 - 3)))" (generate-assert :java '(assert (is_prime (+ (foo 10 11) (bar 1 (- 2 3))))))))))

(deftest assert-test-of-reminder
  (testing "assertTrue(test(10 % 2))"
    (is (= "assertTrue(test(10 % 2))" (generate-assert :java '(assert (test (rem 10 2))))))))
