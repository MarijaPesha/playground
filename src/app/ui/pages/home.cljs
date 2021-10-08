(ns app.ui.pages.home
  (:require [helix.dom :as d]
            [helix.hooks :as hooks]
            [helix.core :as hx :refer [$]]
            [keechma.next.helix.core :refer [with-keechma]]
            [keechma.next.helix.lib :refer [defnc]]
            [keechma.next.helix.classified :refer [defclassified]]
            [app.ui.components.sliders :refer [SideLeftSlider SideRightSlider]]
            [app.ui.components.modal :refer [Modal]]))

(defclassified HomepageWrapper :div "h-screen w-screen flex justify-center items-start relative bg-black")

(defnc HomeRenderer []
  (let [[show-left-slider set-show-left-slider] (hooks/use-state false)
        [show-right-slider set-show-right-slider] (hooks/use-state false)
        [show-modal set-show-modal] (hooks/use-state false)]
    ($ HomepageWrapper
       ($ SideLeftSlider {:show-left-slider show-left-slider
                          :set-show-left-slider set-show-left-slider})
       ($ SideRightSlider {:show-right-slider show-right-slider
                           :set-show-right-slider set-show-right-slider})
       ($ Modal {:set-show-modal set-show-modal
                 :show-modal show-modal
                 :set-show-right-slider set-show-right-slider
                 :set-show-left-slider set-show-left-slider})
       (d/button {:class "custom-test"
                  :onClick #(set-show-modal (not show-modal))}
                 (d/img {:class ["mt-8 h-32 w-32 animate-pulse" 
                                 (when show-modal "hidden")]
                         :src "/svg/rabbit.svg"}))
       (d/div {:class ["front text-center text-[5em] md:text-[10em] absolute"
                       (when show-left-slider "hidden md:block")
                       (when show-right-slider "hidden md:block")]}
              "Feed Your Head"))))

(def Home (with-keechma HomeRenderer))