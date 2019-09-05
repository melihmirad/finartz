Finartz - Test Mühendisi Ödevi

Bu kısımda aşağıda verilen analiz doğrultusunda ilgili fonksiyonel test senaryoları çıkarılacaktır.
Ardından bu test senaryolarını içeren test otomasyonu hazırlanacaktır.

1. Test edilecek internet sayfası: ‘http://thedemosite.co.uk/login.php’
- 'Login' sayfası açıldığı zaman ekran aşağıdaki şekilde olmalıdır:
    * Sekme başlığı = 'Login example page to test the PHP MySQL online system'
    * Sayfa başlığı = '4. Login'
    * Statü mesajı = '**No login attempted**'
    * Sayfa bilgi mesajı = 'Enter your login details you added on the previous page and
    test the login. The success or failure will be shown above.'
    * Kullanıcı adı giriş alanı adı = 'Username:'
    * Şifre giriş alanı adı = 'Password:'
    * Giriş Yap butonu adı = 'Test Login'
    - Test için kullanıcı adı & şifre 'http://thedemosite.co.uk/addauser.php' üzerinden eklenebilir.
    * Test kullanıcı adı / şifre = ‘testuser’ / ‘testpass’ olarak belirlenebilir.
- Kullanıcı adı 4-16 karakter arasında olmalıdır.
- Şifre 4-8 karakter arası olmalıdır.
- Başarısız denemede ‘**Failed Login**’ mesajı gösterilecek.
- Başarılı girişte ‘**Successful Login**’ mesajı gösterilecek.
- 'http://thedemosite.co.uk/addauser.php' kısmından yeni kullanıcı eklendiği zaman, eski
kullanıcı adı ve şifre çalışmamakta, sadece yeni girilen bilgiler ile giriş yapılabilmektedir.
- Sadece ‘Giriş Yap’ akışı test edilecektir, sayfadaki diğer ögelerin test edilmeyecektir.

2. Otomasyon JAVA dilinde, Selenium kütüphanesiyle yazılacaktır. Onaylama fonksiyonları için JUnit
kullanılacaktır. İsteğe bağlı olarak, BDD aracı Cucumber kullanılması tercih sebebi olabilir. Browser
olarak Chrome veya Firefox kullanılabilir. Geliştirme tamamlandıktan sonra proje github üzerinden
paylaşılacaktır. Tercihen otomasyon içerisinde test sonuçlarını içeren bir raporlama eklentisi
kullanılabilir.
