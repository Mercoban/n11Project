@Product
Feature: Product payment
  Scenario: Payment page
    Given user goes to N11 Home Page
    And "kulaklık" icin arama yapar
    Then sonucun "kulaklık" icerdigini test eder
    Then Gelen sonuclar yorum sayisina göre siralanir.
    Then Gelen urunlerden ucretsiz kargo olanlar listelenir.
    Then Gelen sonuclardan ilk sayfadaki birinci ve sonuncu urun sepete eklenir.
    Then Sepette en ucuz urun adedi 2 yapılır ve misafir kullanıcı olarak odemeye gecilir.
    And sayfayi kapatir
