import java.util.List;

public class MayinTaramaGemisi extends Gemi {

    public MayinTaramaGemisi(String gemi_adi, String gemi_kodu, List<String> gemi_guverte_silahlari) {
        super(
                "Mayın Tarama Gemisi",
                gemi_adi,
                gemi_kodu,
                gemi_guverte_silahlari,
                40,
                gemi_guverte_silahlari.size(),
                40,                           // düşük-orta zırh
                0.25,                         // orta-yüksek kritik hasar olasılığı
                1.5,                          // düşük çarpan
                150                           // orta sağlık
        );
    }

    @Override
    public void saldir(Gemi hedefGemi) {
        int saldiriGucu = 20;
        System.out.println(gemi_adi + " mayın saldırısı yapıyor: " + hedefGemi.getGemiAdi());
        hedefGemi.hasarAlma(saldiriGucu);
    }

    @Override
    public void kritikHasar(int hasar) {
        int ekstraHasar = (int)(hasar * kritik_hasar_carpani);
        System.out.println(gemi_adi + " KRİTİK mayın patlaması oluşturdu! Ekstra hasar: " + ekstraHasar);
        saglik -= ekstraHasar;
        if (saglik < 0) saglik = 0;
    }
}
