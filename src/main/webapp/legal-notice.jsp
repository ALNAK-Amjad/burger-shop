<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Impressum</title>
    <link rel="icon" type="image/x-icon" href="./images/burger.jpg">
    <link rel="stylesheet" href="CSS/legal-notice.css">
    <link rel="stylesheet" href="CSS/global-style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<main class="main-page-body flex-col">
    <div class="legal-notice-container flex-col">
        <h2 class="legal-notice-header default-font">Impressum</h2>
        <p class="legal-notice-text legal-notice-info default-font">
            Burger Paradies GmbH<br/>
            Musterweg 23<br/>
            12345 Musterhausen<br/>
            E-Mail: e.muster@burger-paradies.de<br/>
            Tel 049-098-764512-0<br/>
            Fax 049-098-764512-99
        </p>

        <h2 class="legal-notice-header default-font"> Geschäftsführer</h2>
        <p class="legal-notice-text legal-notice-info default-font">
            Markus Steppenberger<br/>
            Registergericht: Amtsgericht Musterstadt,<br/>
            HR 987654321<br/>
            Ust-IdNr: DE113344990<br/>
            W-IdNr: DE 22334455<br/>
        </p>

        <h2 class="legal-notice-header default-font">Datenschutz</h2>
        <p class="legal-notice-text default-font">
            Die Nutzung unserer Webseite ist in der Regel ohne eine Angabe personenbezogener Daten möglich.
            Soweit auf unseren Seiten personenbezogene Daten (beispielsweise Name, Anschrift oder E-Mail-Adresse) erhoben
            werden, erfolgt dies – soweit es möglich ist – immer auf freiwilliger Basis.
            Wir geben Ihre Daten ohne Ihre ausdrückliche Zustimmung nicht an Dritte weiter. Außerdem weisen wir Sie darauf
            hin, dass die Datenübertragung im Internet (wie beispielsweise bei der Kommunikation über E-Mail) Sicherheitslücken
            aufweisen kann. Denn ein lückenloser Schutz der Daten vor dem Zugriff durch Dritte ist nicht möglich. Wir widersprechen
            hiermit ausdrücklich der Nutzung von im Rahmen der Impressumspflicht veröffentlichten Kontaktdaten durch Dritte zur
            Übersendung von nicht ausdrücklich angeforderter Werbung und Informationsmaterialien. Die Betreiber dieser Seiten
            behalten sich ausdrücklich vor, im Fall der unverlangten Zusendung von Werbeinformationen, etwa durch Spam-Mails,
            rechtliche Schritte einzuleiten.
        </p>

    </div>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>
