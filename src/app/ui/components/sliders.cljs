(ns app.ui.components.sliders
   (:require [helix.dom :as d]
             [helix.core :as hx :refer [$]]
             [keechma.next.helix.lib :refer [defnc]]
             [keechma.next.helix.classified :refer [defclassified]]))

(def slide-wrap "fixed h-screen w-2/3 md:w-1/3 bg-white transition-all duration-1000 flex items-center")
(defclassified SideLinks :li "py-4 hover:bg-black hover:text-white hover:rounded-full cursor-pointer")

(defnc Links []
  (d/ul {:class "text-base md:text-2xl font-bold"}
        ($ SideLinks 
           "Lorem ipsum")
        ($ SideLinks
           "Vitae nunc")
        ($ SideLinks 
           "Duis convallis")
        ($ SideLinks 
           "Nullam ac tortor")
        ($ SideLinks 
           "Lorem ipsum")
        ($ SideLinks 
           "Vitae nunc")
        ($ SideLinks 
           "Nullam ac tortor")))

(defnc SideBoxTextLeft
  [{:keys [show-left-slider]}]
  (d/div {:class ["w-10/12 h-9/12 text-center transition-opacity" 
                  (when (not show-left-slider) "opacity-0")]}
         ($ Links)))

(defnc SideBoxTextRight
  [{:keys [show-right-slider]}]
  (d/div {:class ["w-10/12 h-9/12 text-center transition-opacity" 
                  (when (not show-right-slider) "opacity-0")]}
         ($ Links)))

(defnc SideLeftSlider 
[{:keys [set-show-left-slider show-left-slider]}]
  (d/div {:class [slide-wrap "justify-end" 
                  (if show-left-slider 
                    "left-0 opacity-100 md:opacity-90" 
                    "-left-2/4 md:-left-1/4 opacity-10")]} 
         ($ SideBoxTextLeft {:show-left-slider show-left-slider})
         (d/button 
          {:onClick #(set-show-left-slider (not show-left-slider))}
          (if show-left-slider
            (d/img {:class "w-10 h-10 animate-pulse cursor-pointer"
                    :src "/img/back.png"})
            (d/img {:class "w-10 h-10 transform rotate-180 cursor-pointer"
                    :src "/img/back.png"})))))

(defnc SideRightSlider 
[{:keys [set-show-right-slider show-right-slider]}]
  (d/div {:class [slide-wrap "justify-start" 
                  (if show-right-slider 
                    "right-0 opacity-100 md:opacity-90" 
                    "-right-2/4 md:-right-1/4 opacity-10")]} 
         (d/button 
          {:onClick #(set-show-right-slider (not show-right-slider))}
          (if show-right-slider
            (d/img {:class "w-10 h-10 transform rotate-180 cursor-pointer"
                    :src "/img/back.png"})
            (d/img {:class "w-10 h-10 animate-pulse cursor-pointer"
                    :src "/img/back.png"})))
         ($ SideBoxTextRight {:show-right-slider show-right-slider})))