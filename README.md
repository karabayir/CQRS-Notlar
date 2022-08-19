# CQRS-Notlar


![CQRS](https://user-images.githubusercontent.com/101670417/185717516-b2a9973e-bc42-4b0f-9d68-a205c4ac2c54.jpg)


## CQRS NE YAPAR ? (Command Query Responsibility Segregation)

 Sistemimizde veriyi işleyen ve veriye sorgu yapan kısımları birbirinden ayırmamızı sağlar (Komut-Sorgu ayrımı).


Command : Nesnelerin durumunda(state) değişiklik yapan komutlar.

Query   : Veriyi sorgulama.

### Neden Böyle Bir Ayrım Yapılır?

 Özellikle e-ticaret ve finans gibi uygulamalarda CQRS gün geçtikçe hayata girmeye başladı.
 
 Finans uygulamasında verimizin durumunu(state) daha çok güncelleyip daha az sorgu yapmamız gerekebilir
 
 E-Ticaret uygulamasında ise daha çok sorgu daha az state günceleme olabilir.

 Ben bütün durumları tek bir sisteme koyarsam hem state'yi değiştiren kısımda (komut) hem de veriyi 
sorgulama kısmında (query) aynı kaynağı kullanır. Bunları ayırırsak kaynak yönetimi konusunda 
esneklik sağlayabiliriz. Daha iyi performans elde edilebilir.
  
----------------------------------------------------------------------------------------------------

Veritabanında hep nihai sonucu görmekteyiz.

Ancak o sonuçtaki geçen aşamaları görmek istersek -> CQRS

Ya da yanlışlıkla veritabanını uçurur isek burada CQRS kullanabiliriz.

Burada kullanacağımız kavramlar şunlardır ;

(EDD)
Event Driven Desing      : Sisteme gelen bütün istekleri bir Kafka , RabbitMq EDD mimarisiyle kaydedip
                           T anında bir yukarıda anlatılan problemlerden biri ile karşılaşılırsa event
                           tekrar çalıştırılarak veritabanı kayıtlarına tekrar ulaşabiliriz veya analiz
                           edebiliriz.


Event Sourcing           : Event Driven Desing'ın bir alt kümesi olarak hayatımıza girer. CQRS tabanlı
                           bir mimaridir.

-----------------------------------------------------------------------------------------------------

 -> Command , aldığı komutu işleyip bir event oluşturur. Bu EventSource 'a kaydedilir. EventSource için 
 AxonServer kullandık.Command sadece nesnenin state'i ile igilenir.	
 
 -> Query ise EventSource'a kaydedilmiş eventlerle iletişim halindedir.Bu eventleri yakalar.

 -> Command, sadece event source ile ilgilenir. DB ile iletişim kuramaz.
 
 -> DB ile iletişimi Query tarafı kurar.

-----------------------------------------------------------------------------------------------------

![CQRS2](https://user-images.githubusercontent.com/101670417/185719623-9578bb73-86b2-48d5-a22c-bea134efa246.jpg)



 Aggregate : Axon'un command dünyasını yöneten kısmı.
