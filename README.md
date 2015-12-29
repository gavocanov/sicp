# Sicp code in ClojureScript, with devcards

Learning [ `ClojureScript` ](https://github.com/clojure/clojurescript) by rewriting (some) [ `SICP` ](https://mitpress.mit.edu/sicp/) code in it.

The **objective** is to write **idiomatic** `ClojureScript` code as much as possible but still retain the `SICP` spirit of the code.

[ `Devcards` ](https://github.com/bhauman/devcards) because why not? It's totally _awesome_ ;) 

Learn some [ `Reagent` ](https://github.com/reagent-project/reagent) by the way, and learn writing some tests in `ClojureScript`.

## Run
You need [ leiningen ](http://leiningen.org/) to try it out.
Just `brew install leiningen` if you're on a Mac, then run `lein figwheel`, wait and open [ `http://localhost:3449/cards.html` ](http://localhost:3449/cards.html) in your browser, the rest should be pretty self-explanatory.

## Hack
This stuff works really well with [ `vim-fireplace` ](https://github.com/tpope/vim-fireplace), I just put:
```clojure
{:user {:repl-options {
                       :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

        :dependencies [[figwheel-sidecar "0.5.0-2"]
                       [cider/cider-nrepl "0.10.0"]
                       [com.cemerick/piggieback "0.2.1"]
                       [org.clojure/tools.nrepl "0.2.12"]]

        :plugins [[lein-ancient "0.6.8"]]

        :figwheel {:nrepl-port       7888
                   :nrepl-middleware ["cider.nrepl/cider-middleware"
                                      "cemerick.piggieback/wrap-cljs-repl"]}}}


```
in my `~/.lein/profiles.clj` and then I can evaluate stuff directly from Vim. 

Connect to the `nRepl` with: 
```vim
:Connect nrepl://localhost:7888
``` 
and then execute:
```vim
Piggieback! (do (require 'figwheel-sidecar.repl-api) (figwheel-sidecar.repl-api/cljs-repl))
```
in `fireplace` 'quasi-repl'.

I put this in my `.vimrc` as a command:
```vim
command! Figwheel :Piggieback! (do (require 'figwheel-sidecar.repl-api) (figwheel-sidecar.repl-api/cljs-repl))
```

The `ClojureScript` tooling is very chaotic ATM, if `vim-fireplace` does not play well with `eval (cpp)` try [ this ](https://github.com/christoph-frick/vim-fireplace) fork, works nice for me.

## License
em....whatever...

