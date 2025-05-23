
# NUTrack - Fitness Takip Uygulaması

NUTrack, kullanıcıların günlük kalori alımını, yemek tüketimlerini ve antrenman planlarını takip etmelerine olanak tanıyan bir masaüstü uygulamasıdır. Java Swing ile geliştirilmiş olan bu uygulama, kullanıcı dostu bir arayüz ile MySQL veritabanı bağlantısı kurar ve kullanıcıların sağlık hedeflerine ulaşmasına yardımcı olur.

## Özellikler

-  Kullanıcı kayıt ve giriş sistemi
-  Günlük yemek girişleri ve gramaj bazlı kalori hesaplama
-  Haftalık antrenman planı oluşturma ve düzenleme
-  Güncel kalori hedefi hesaplama (boy, kilo, yaş ve cinsiyete göre)
-  Tüm veriler MySQL veritabanında güvenle saklanır
-  Swing GUI ile sezgisel kullanıcı arayüzü

## Kullanılan Teknolojiler

- Java 17+
- Java Swing (GUI)
- MySQL (Veritabanı)
- JDBC (Veritabanı bağlantısı)
- MVC (Model-View-Controller) mimarisi

## Kurulum Talimatları

1. **Veritabanını Kurun:**
   - MySQL kurulu olmalıdır.
   - "CREATE DATABASE fitnessapp;" komudu ile fitnessapp adında database oluşturun
   - `DATABASE` klasörü içindeki SQL dosyalarını sırasıyla çalıştırın:
     - `fitnessapp_users.sql`
     - `create_meals_table.sql`
     - `fitnessapp_workout_plan.sql`

2. **Veritabanı Bağlantısını Yapılandırın:**
   - `DBManager.java` sınıfında yer alan bağlantı bilgilerini kendi MySQL kullanıcı adı ve şifrenize göre düzenleyin:

   ```java
   String url = "jdbc:mysql://localhost:3306/fitnessapp";
   String user = "root";
   String password = "your_password_here";
   ```

3. **Projeyi Derleyin ve Çalıştırın:**
   - `controller.Main` sınıfı uygulamanın başlangıç noktasıdır.
   - Bir Java IDE'si (örneğin IntelliJ IDEA, Eclipse) ile projeyi açıp `Main.java` dosyasını çalıştırarak başlatabilirsiniz.

## Ekran Görüntüleri

-  Giriş Ekranı
-  Yemek Giriş Formu
-  Antrenman Planı Ekleme
-  Kalori Hedefi Hesaplama

## Klasör Yapısı

```

## Katkı ve Geliştirme

Projeyi kendi ihtiyaçlarınıza göre geliştirebilir, GUI iyileştirmeleri yapabilir veya yeni özellikler (örneğin su takibi, BMI analizi) ekleyebilirsiniz.


