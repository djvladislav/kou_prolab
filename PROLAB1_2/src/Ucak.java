public class Ucak extends HavaSinifi {
    private static final int DEFAULT_DAYANIKLILIK = 20; // Sabit başlangıç dayanıklılık
    private static final int KARA_VURUS_AVANTAJI = 10; // Kara vuruş avantaj çarpanı

    // Varsayılan seviye puanı (0) ile constructor
    public Ucak() {
        super(DEFAULT_DAYANIKLILIK, 0, "Hava", 10, true); // Vuruş gücü sabit: 10
    }

    // Kullanıcı tarafından belirtilen seviye puanı ile constructor
    public Ucak(int seviyePuani) {
        super(DEFAULT_DAYANIKLILIK, seviyePuani, "Hava", 10, true); // Dayanıklılık sabit, seviye puanı belirlenebilir
    }

    @Override
    public void DurumGuncelle(int hasar) {
        // Dayanıklılığı hasara göre azalt
        setDayaniklilik(getDayaniklilik() - hasar);
        if (getDayaniklilik() < 0) {
            setDayaniklilik(0); // Negatif değerleri sıfıra çek
        }
    }

    public void seviyePuaniEkle(int puan) {
        // Seviye puanını artır
        setSeviyePuani(getSeviyePuani() + puan);
    }

    @Override
    public void KartPuaniGoster() {
        System.out.println("Uçak - Dayanıklılık: " + getDayaniklilik() +
                ", Seviye Puanı: " + getSeviyePuani());
    }

    // Vuruş gücü hesaplama (avantaj duruma göre dahil edilecek)
    public int SaldiriHesapla(SavasAraclari rakip) {

        if (rakip instanceof KaraSinifi) {
            return getVurus() + KARA_VURUS_AVANTAJI;
        } else {
            return getVurus();
        }
    }


    @Override
    public String KartAdiGoster(){
        return "Uçak";
    }

    // Kartın aktif olup olmadığını kontrol et
    public boolean aktifMi() {
        return getDayaniklilik() > 0;
    }

    @Override
    public String getKartGorselYolu() {
        return "src/fotolar/ucak.png";
    }
}
