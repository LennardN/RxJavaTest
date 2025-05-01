# Informationen zu RxJava
- verhindert zu viele zu handelne Callbacks
- Threading ist einfacher
- Asynchrone Operationen sind einfacher
- einfaches Errorhandling
## Asynchrone Programming
## Reactive Programming
Ist sehr praktisch für das Observer Pattern (Publish-Subscribe, Listener-Pattern). Automatisiert diese quasi.
Einzusetzen wäre es bei der Steuerung des Models. 
Ein Beispiel wäre ein Produkt welches ein Preis hat und dieser Preis rechnet sich dynamisch aus verschiedenen Faktoren zusammen.
Statt nach jedem Wechsel von einen dieser Faktoren erneut auszurechnen was das Produkt kostet, wird bei dem Reactive Programming von RXJava dies automatisch erledigt.

Im Allgemeinen kann es auch sehr unintuitiv sein (Beispielbild)
### Observable
### Single
### Completable
### Maybe
### FLowable