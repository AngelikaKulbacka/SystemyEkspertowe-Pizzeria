;;;***************************
;;;* DEFTEMPLATES & DEFFACTS *
;;;***************************

(deftemplate price
    (slot value (type FLOAT) (default 0.00))
)    (defglobal ?*p* = 0.00)

(deftemplate pizza
    (slot type)
    (slot price (type FLOAT) (default 0.00))
    (slot size (type FLOAT) (default 0.00))
    (slot drinks (type FLOAT) (default 0.00))
    (slot toppings (type FLOAT) (default 0.00))
    (slot dippings (type FLOAT) (default 0.00))
    (slot student (type FLOAT) (default 0.00))
    (slot final (type FLOAT) (default 0.00))
)

;;;****************
;;;* STARTUP RULE *
;;;****************

(defrule MAIN::startup ""
    =>
    (assert(price))
    (assert(discount))
)

;;;***************
;;;* PRICE RULES *
;;;***************

(defrule MAIN::margherita-price ""
    ?f <- (pizza (type ?type)(price ?price))
    (test (and (eq ?type margherita) (eq ?price 0.00)))
    =>
    (modify ?f (price 20.00))
)

(defrule MAIN::hawaian-price ""
    ?f <- (pizza (type ?type)(price ?price))
    (test (and (eq ?type hawaian) (eq ?price 0.00)))
    =>
    (modify ?f (price 24.00))
)

(defrule MAIN::capricciosa-price ""
    ?f <- (pizza (type ?type)(price ?price))
    (test (and (eq ?type capricciosa) (eq ?price 0.00)))
    =>
    (modify ?f (price 22.00))
)

(defrule MAIN::small-price ""
    ?f <- (pizza (size ?size)(price ?price))
    (test (and (eq ?size small) (eq ?price 0.00)))
    =>
    (modify ?f (price 0.00))
)

(defrule MAIN::medium-price ""
    ?f <- (pizza (size ?size)(price ?price))
    (test (and (eq ?size medium) (eq ?price 0.00)))
    =>
    (modify ?f (price 4.00))
)

(defrule MAIN::large-price ""
    ?f <- (pizza (size ?size)(price ?price))
    (test (and (eq ?size large) (eq ?price 0.00)))
    =>
    (modify ?f (price 8.00))
)

(defrule MAIN::drink-price ""
    ?f <- (pizza (drinks ?drinks)(price ?price))
    (test (and (eq ?size drink) (eq ?price 0.00)))
    =>
    (modify ?f (price 6.00))
)

(defrule MAIN::topping-price ""
    ?f <- (pizza (toppings ?toppings)(price ?price))
    (test (and (eq ?toppings topping) (eq ?price 0.00)))
    =>
    (modify ?f (price 3.00))
)

(defrule MAIN::dipping-price ""
    ?f <- (pizza (dippings ?dippings)(price ?price))
    (test (and (eq ?dippings dipping) (eq ?price 0.00)))
    =>
    (modify ?f (price 2.00))
)

(defrule MAIN::yes-price ""
    ?f <- (pizza (student ?student)(price ?price))
    (test (and (eq ?student yes) (eq ?price 0.00)))
    =>
    (modify ?f (price 15.00))
)

(defrule total ""
    ?q<-(price(value ?value))
    (test(eq ?value 0.00))
    =>
    (do-for-all-facts ((?i pizza)) TRUE
    (bind ?*p* (+ ?*p* ?i:price))
    )
    (modify ?q (value (/ (* ?*p* 100) 100) ))
)

(defrule make-receipt ""
    (do-for-all-facts ((?f pizza)) TRUE
)
)

;;;***************************
;;;* DEFFUNCTION DEFINITIONS *
;;;***************************

(deffunction MAIN::get-discount ()
    (find-all-facts ((?f discount)) TRUE)
)