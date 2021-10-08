(ns app.domain.data)

(def test-data
  [{:key :1
    :question "Lorem ipsum question 01, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore?"
    :answers [{:copy "01 Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore velit esse cillum dolore"
               :value true
               :key ""}
              {:copy "01 Excepteur sint occaecat cupidatat non"
               :value false
               :key ""}
              {:copy "01 Ut enim ad minim veniam, quis nostrud exercitation ullamco"
               :value false
               :key ""}
              {:copy "01 Magna etiam tempor orci eu lobortis elementum nibh"
               :value false
               :key ""}]}
   {:key :2
    :question "Lorem ipsum question 02, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore?"
    :answers [{:copy "02 Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore velit esse cillum dolore"
               :value false
               :key ""}
              {:copy "02 Excepteur sint occaecat cupidatat non"
               :value false
               :key ""}
              {:copy "02 Ut enim ad minim veniam, quis nostrud exercitation ullamco"
               :value true
               :key ""}
              {:copy "02 Magna etiam tempor orci eu lobortis elementum nibh"
               :value false
               :key ""}]}
   {:key :3
    :question "Lorem ipsum question 03, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore?"
    :answers [{:copy "03 Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore velit esse cillum dolore"
               :value false
               :key ""}
              {:copy "03 Excepteur sint occaecat cupidatat non"
               :value false
               :key ""}
              {:copy "03 Ut enim ad minim veniam, quis nostrud exercitation ullamco"
               :value false
               :key ""}
              {:copy "03 Magna etiam tempor orci eu lobortis elementum nibh"
               :value true
               :key ""}]}
   {:key :4
    :question "Lorem ipsum question 04, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore?"
    :answers [{:copy "04 Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore velit esse cillum dolore"
               :value false
               :key ""}
              {:copy "04 Excepteur sint occaecat cupidatat non"
               :value true
               :key ""}
              {:copy "04 Ut enim ad minim veniam, quis nostrud exercitation ullamco"
               :value false
               :key ""}
              {:copy "04 Magna etiam tempor orci eu lobortis elementum nibh"
               :value false
               :key ""}]}])

(defn get-test-data-by-key [key]
  (first (filter #(= key (:key %)) test-data)))