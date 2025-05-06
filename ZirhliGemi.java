import java.util.List;

public class ZirhliGemi extends Gemi {

    public ZirhliGemi(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super("Zırhlı Gemi", gemi_adi, gemi_kodu, gemi_guverte_silahlari,
                150, 100, 150,        // Mürettebat sayısı, silah sayısı, zırh
                0.2,                  // Kritik hasar olasılığı
                2,                    // Kritik hasar çarpanı
                400);                 // Sağlık
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 60;  // Zırhlı geminin saldırı gücü
        System.out.println(gemi_adi + " hedefe top atışı yapıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK top atışı yaptı! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) {
            saglik = 0;
        }
    }

    @Override
    public void torpidoAt(Gemi hedefGemi) {
        int torpidoHasari = 40;
        System.out.println(gemi_adi + " torpido atıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(torpidoHasari);
    }

    @Override
    public void suAltiBombasi(Gemi hedefGemi) {
        int bombaHasari = 30;
        System.out.println(gemi_adi + " su altı bombası atıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(bombaHasari);
    }
    @Override
    public void ozelSaldiri(Gemi hedefGemi) {
        System.out.println(gemi_adi + " özel zırhlı top saldırısı yapıyor!");
        hedefGemi.hasarAlma(75);  // Zırhlı geminin özel saldırısı
    }
}
