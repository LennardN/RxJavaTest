# Informationen zu RxJava
## Grobe Vorteile laut 
- verhindert zu viele zu handelne Callbacks
- Threading ist einfacher
- Asynchrone Operationen sind einfacher
- einfaches Errorhandling
## Reactive Programming
Ist sehr praktisch für das Observer Pattern (Publish-Subscribe, Listener-Pattern). Automatisiert diese quasi.
Einzusetzen wäre es bei der Steuerung des Models. 
Ein Beispiel wäre ein Produkt welches ein Preis hat und dieser Preis rechnet sich dynamisch aus verschiedenen Faktoren zusammen.
Statt nach jedem Wechsel von einen dieser Faktoren erneut auszurechnen was das Produkt kostet, wird bei dem Reactive Programming von RXJava dies automatisch erledigt.

## Einschätzung
Für ende eines Releases (oder Teil einer App) würde sich dieses Framework fürs Refactoring eignen.
Für Stellen im Programmcode die undurchsichtig sind und schwer zu verwalten.