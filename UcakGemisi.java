import java.util.List;

public class UcakGemisi extends Gemi {

    public UcakGemisi(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super("Uçak Gemisi", gemi_adi, gemi_kodu, gemi_guverte_silahlari,
                300, gemi_guverte_silahlari.size(), 80, 0.15, 3, 500);
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 50;  // Hava saldırısı gücü
        System.out.println(gemi_adi + " hava saldırısı düzenliyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        // Kritik hasarın ekstra kısmını hesaplamak için
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK hava saldırısı yaptı! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) {
            saglik = 0;
        }
    }

    @Override
    public void torpidoAt(Gemi hedefGemi) {
        // Uçak Gemisi torpido atmaz, bu metod boş bırakılabilir veya bir mesaj verebilir
        System.out.println(gemi_adi + " torpido atıyor!");
        hedefGemi.hasarAlma(50);  // Torpido hasarı uygulama
    }

    @Override
    public void suAltiBombasi(Gemi hedefGemi) {
        // Uçak Gemisi su altı bombası atmaz, bu metod boş bırakılabilir
        System.out.println(gemi_adi + " su altı bombası atıyor!");
        hedefGemi.hasarAlma(30);  // Su altı bombası hasarı
    }

    @Override
    public void ozelSaldiri(Gemi hedefGemi) {
        System.out.println(gemi_adi + " özel hava saldırısı yapıyor!");
        hedefGemi.hasarAlma(100);  // Uçak Gemisi'nin özel saldırısı
    }
}
