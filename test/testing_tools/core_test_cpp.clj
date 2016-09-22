(ns testing-tools.core-test-cpp
  (:require [clojure.test :refer :all]
            [testing-tools.core :refer :all]))

(deftest assert-true-test
  (testing "Should return ASSERT_TRUE(true)."
    (is (= "ASSERT_TRUE(true)" (generate-assert :cpp '(assert true))))))

(deftest assert-false-test
  (testing "Should return ASSERT_TRUE(false)."
    (is (= "ASSERT_TRUE(false)" (generate-assert :cpp '(assert false))))))

(deftest assert-is-prime-of-number
  (testing "Should return ASSERT_TRUE(is_prime(10))"
    (is (= "ASSERT_TRUE(is_prime(10))" (generate-assert :cpp '(assert (is_prime 10)))))))

(deftest assert-some-funct-of-many-args
  (testing "Should return ASSERT_TRUE(some_funct(10, 11, 12))"
    (is (= "ASSERT_TRUE(some_funct(10, 11, 12))" (generate-assert :cpp '(assert (some_funct 10 11 12)))))))

(deftest assert-is-prime-of-sum
  (testing "Should return ASSERT_TRUE(is_prime(10 + 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 + 1))" (generate-assert :cpp '(assert (is_prime (+ 10 1))))))))

(deftest assert-is-prime-of-substraction
  (testing "Should return ASSERT_TRUE(is_prime(10 - 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 - 1))" (generate-assert :cpp '(assert (is_prime (- 10 1))))))))

(deftest assert-is-prime-of-multiplication
  (testing "Should return ASSERT_TRUE(is_prime(10 * 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 * 1))" (generate-assert :cpp '(assert (is_prime (* 10 1))))))))

(deftest assert-is-prime-of-division
  (testing "Should return ASSERT_TRUE(is_prime(10 / 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 / 1))" (generate-assert :cpp '(assert (isprime (/ 10 1))))))))

(deftest assert-is-prime-of-sum-foo-bar
  (testing "ASSERT_TRUE(is_prime(foo(10, 11) + bar(1, 2 - 3)))"
    (is (= "ASSERT_TRUE(is_prime(foo(10, 11) + bar(1, 2 - 3)))" (generate-assert :cpp '(assert (is_prime (+ (foo 10 11) (bar 1 (- 2 3))))))))))
