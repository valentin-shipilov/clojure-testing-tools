(ns testing-tools.core-test-cpp
  (:require [clojure.test :refer :all]
            [testing-tools.core :refer :all]))

(def lang :cpp)

(deftest assert-true-test
  (testing "Should return ASSERT_TRUE(true)."
    (is (= "ASSERT_TRUE(true)" (generate-assert lang '(assert true))))))

(deftest assert-false-test
  (testing "Should return ASSERT_TRUE(false)."
    (is (= "ASSERT_TRUE(false)" (generate-assert lang '(assert false))))))

(deftest assert-is-prime-of-number
  (testing "Should return ASSERT_TRUE(is_prime(10))"
    (is (= "ASSERT_TRUE(is_prime(10))" (generate-assert lang '(assert (is_prime 10)))))))

(deftest assert-some-funct-of-many-args
  (testing "Should return ASSERT_TRUE(some_funct(10, 11, 12))"
    (is (= "ASSERT_TRUE(some_funct(10, 11, 12))" (generate-assert lang '(assert (some_funct 10 11 12)))))))

(deftest assert-is-prime-of-sum
  (testing "Should return ASSERT_TRUE(is_prime(10 + 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 + 1))" (generate-assert lang '(assert (is_prime (+ 10 1))))))))

(deftest assert-is-prime-of-substraction
  (testing "Should return ASSERT_TRUE(is_prime(10 - 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 - 1))" (generate-assert lang '(assert (is_prime (- 10 1))))))))

(deftest assert-is-prime-of-multiplication
  (testing "Should return ASSERT_TRUE(is_prime(10 * 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 * 1))" (generate-assert lang '(assert (is_prime (* 10 1))))))))

(deftest assert-is-prime-of-division
  (testing "Should return ASSERT_TRUE(is_prime(10 / 1)))"
    (is (= "ASSERT_TRUE(is_prime(10 / 1))" (generate-assert lang '(assert (is_prime (/ 10 1))))))))

(deftest assert-is-prime-of-sum-foo-bar
  (testing "ASSERT_TRUE(is_prime(foo(10, 11) + bar(1, 2 - 3)))"
    (is (= "ASSERT_TRUE(is_prime(foo(10, 11) + bar(1, 2 - 3)))" (generate-assert lang '(assert (is_prime (+ (foo 10 11) (bar 1 (- 2 3))))))))))

(deftest assert-test-of-reminder
  (testing "assertTrue(test(10 % 2))"
    (is (= "ASSERT_TRUE(test(10 % 2))" (generate-assert lang '(assert (test (rem 10 2))))))))
