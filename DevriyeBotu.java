import java.util.List;

public class DevriyeBotu extends Gemi {

    public DevriyeBotu(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super(
                "Devriye Botu",
                gemi_adi,
                gemi_kodu,
                gemi_guverte_silahlari,
                20,                           // çok az mürettebat
                gemi_guverte_silahlari.size(),
                30,                           // düşük zırh
                0.2,                          // orta kritik hasar olasılığı
                2,                            // orta çarpan
                100                           // düşük sağlık
        );
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 25;
        System.out.println(gemi_adi + " hızlı saldırı yapıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK vuruş yaptı! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }
    @Override
    public void torpidoAt(Gemi hedefGemi) {
        int hasar = 10;
        System.out.println(gemi_adi + " torpido atıyor!");
        hedefGemi.hasarAlma(hasar);
    }

    @Override
    public void suAltiBombasi(Gemi hedefGemi) {
        int hasar =5;
        System.out.println(gemi_adi + " su altı bombası atıyor!");
        hedefGemi.hasarAlma(hasar);
    }
    @Override
    public void ozelSaldiri(Gemi hedefGemi) {
        System.out.println(gemi_adi + " özel zırhlı top saldırısı yapıyor!");
        hedefGemi.hasarAlma(45);  // Zırhlı geminin özel saldırısı
    }
}
