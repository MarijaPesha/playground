(ns app.ui.components.modal
  (:require [helix.dom :as d]
            [helix.hooks :as hooks]
            [helix.core :as hx :refer [$ <>]]
            [keechma.next.helix.lib :refer [defnc]]
            [keechma.next.helix.classified :refer [defclassified]]
            [app.domain.data :refer [test-data]]
            [keechma.next.toolbox.logging :as l]))

(defclassified AnswerWrap :li "py-4 hover:bg-black hover:bg-opacity-70 hover:text-white hover:rounded-md cursor-pointer")
(defclassified WhiteBoard :div "w-10/12 md:w-2/3 h-2/3 mx-auto bg-white opacity-80 rounded-md md:rounded-[6em]  
flex justify-center items-start md:items-center overflow-y-scroll md:overflow-auto")

(defn is-answer-corect 
  [answer-val state-guestion set-state-guestion set-answers-group answers-group]
  (if (= answer-val true)
    (do
      (set-state-guestion (inc state-guestion))
      (set-answers-group (inc answers-group)))
    (set-state-guestion false)))

(defnc Modal
  [{:keys [set-show-modal show-modal set-show-left-slider set-show-right-slider]}]
  (let [[answer-value set-answer-value] (hooks/use-state true)
        [state-guestion set-state-guestion] (hooks/use-state 0)
        [answer-group set-answer-group] (hooks/use-state 0)
        question (:question (get-in test-data [state-guestion]))
        answers-group (:answers (get-in test-data [answer-group]))]
    (d/div {:class ["z-40 w-full h-full bg-black flex items-center flex-col overflow-hidden md:overflow-auto"
                    (when-not show-modal "hidden")]}
           (d/img {:class ["mt-8 h-32 w-32 animate-pulse z-40 cursor-pointer order-first"]
                   :onClick #(do
                               (set-show-modal (not show-modal))
                               (set-show-left-slider false)
                               (set-show-right-slider false)
                               (set-state-guestion 0)
                               (set-answer-value true)
                               (set-answer-group 0))
                   :src "/svg/rabbit.svg"})
           ($ WhiteBoard
          (if answer-value
            (d/div {:class "text-center py-4 px-8"}
                   (d/div {:class "text-4xl font-bold my-6"}
                          question)
                   (d/ul {:class "text-2xl font-bold"}
                         (map-indexed
                          (fn [idx {:keys [copy value]}]
                            ($ AnswerWrap
                               {:key idx
                                :onClick (fn []
                                           (set-answer-value value)
                                           (is-answer-corect answer-value state-guestion set-state-guestion set-answer-group answer-group))}
                               copy))
                          answers-group)))
            (d/div {:class "text-center"}
             (d/div {:class "text-5xl font-bold"}
                    "Try again!")
              (d/button {:class "mt-10 rounded rounded-lg border-2 text-xl uppercase py-3 px-6 font-bold"
                         :onClick #(do
                                     (set-state-guestion 0)
                                     (set-answer-value true)
                                     (set-answer-group 0))}
               "good luck")))))))