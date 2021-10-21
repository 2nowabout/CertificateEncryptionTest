# CertificateEncryptionTest

Kleine test van het encrypte van een document.
De test werkt met SHA-256 hashing zoals vaak gebruikt wordt.
Deze testen moeten het hashen van een file, waarnaar deze op een blockchain kan worden gezet en later geverifieerd kan worden, "testen".

Voor het kunnen controleren van een valide document kan er een hash worden gemaakt van de files die uiteindelijk hetzelfde hoort te zijn.
Andere voorwaarde zijn:
- Na aanpassing naam van document hoort de hash van het document nog hetzelfde te zijn.
Eigenaar van document moet naam kunnen veranderen voor gebruiksgemak waarnaar hash nog hetzelfde is.
- Heropslaan van document zelfs zonder aanpassen kan compromiserend zijn en word dan afgewezen.

Vergeet niet de locaties in de strings aan te passen en een copy van de main file ergens anders neer te zetten voor eerste test.