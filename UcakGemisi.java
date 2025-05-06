import java.util.List;

public class UcakGemisi extends Gemi {

    public UcakGemisi(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super(
                "Uçak Gemisi",
                gemi_adi,
                gemi_kodu,
                gemi_guverte_silahlari,
                300,                          // çok yüksek mürettebat
                gemi_guverte_silahlari.size(),
                80,                           // yüksek zırh
                0.15,                         // düşük-orta kritik hasar olasılığı
                3,                            // yüksek çarpan
                500                           // çok yüksek sağlık
        );
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 50;
        System.out.println(gemi_adi + " hava saldırısı düzenliyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK hava saldırısı yaptı! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }
}
