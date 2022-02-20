# AddressRegistrationSystem-JavaSpringBoot
This project is an address registration system api


## Proje 9001 portunda başlıyor  get methodlarını postmande yazmadım.
### localhost:9001/api/v1/{address,province,town,country,street,neighborhood} bu şekilde herhangi birini yazarsanız kayıtları gelecektir.
## Tüm Fonksiyonların rahatça kontrol edilebilmesi için bu koleksiyonu postman üzerinden import edebilirsiniz: https://www.getpostman.com/collections/036270838acdfa462694 

## Adres Kayıt Sistemi:  
Bir adreste bulunması gereken alanlar:  
- Ülke 
-  Şehir 
-  İlçe 
-  Mahalle 
-  Sokak 
-  Kapı No  
-  Daire No 
Bir adet controller yazınız(Tek controller yeterli). Bu controller içerisinde aşağıdaki işlemler yapılabilmelidir.  
1. Ülke kaydedilebilmelidir. 
2. Ülke kodundan ülke sorgulanabilmelidir. 
3. Şehir kaydedilebilmelidir. 
4. Plakadan şehir bilgisi sorgulanabilmelidir.
5. İlçe  kaydedilebilmelidir. 
6. Bir ile ait ilçeler sorgulanabilmelidir.
7. Mahalle kaydedilebilmelidir. 
8. Mahalle adını güncellenebilmelidir.  
9. Bir ilçeye ait mahalleler sorgulanabilmelidir. 
10. Sokak kaydedilebilmelidir. 
11. Sokak adı güncellenebilmelidir. 
12. Bir mahalleye ait sokaklar sorgulanabilmelidir.
13. Adres kaydedilebilmelidir.  
14. Adres silinebilmelidir. 
15. Id den adres bilgisi edinilebilmelidir. 
 
### NOT:  
- Address entitysi hariç diğer entitylerin servislerinde entity kullanabilirsiniz. Yani metot parametresi için dto, return için başka bir dto kullanmanıza gerek yok.  
- Address kaydeden dönen vs yerlerde mapper ya da converterlar kullanarak DTO ile veri akışını sağlayınız.
